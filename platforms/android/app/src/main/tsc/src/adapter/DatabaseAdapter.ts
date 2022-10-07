import { deserializeArray, plainToClass, plainToInstance } from "class-transformer";
import { CartItem, Category, Menu } from "../Model";

export default class DatabaseAdapter {
    private static databaseAdapter: DatabaseAdapter;
    public static getInstance(): DatabaseAdapter {
        if (DatabaseAdapter.databaseAdapter == null) {
            DatabaseAdapter.databaseAdapter = new DatabaseAdapter();
        }
        return DatabaseAdapter.databaseAdapter;
    }

    private IndxDb: IDBFactory;
    private db: IDBDatabase;
    constructor() {
        this.IndxDb = window.indexedDB;
    }

    async open() {
        return new Promise((resolve, reject) => {
            let req: IDBOpenDBRequest = this.IndxDb.open("mydb");
            req.onupgradeneeded = (event: any) => {
                let db: IDBDatabase = event.target.result;
                let categoryStore: IDBObjectStore = db.createObjectStore('category', { keyPath: 'id', autoIncrement:true });
                categoryStore.createIndex("cat_idx", "itemMainCategory");

                let menuStore: IDBObjectStore = db.createObjectStore('menu', { keyPath: 'itemId', autoIncrement:true });
                menuStore.createIndex("itemMainCategory_idx", "itemMainCategory");

                let cartStore: IDBObjectStore = db.createObjectStore('cart', { keyPath: 'itemId'});
            };
            req.onsuccess = (event: any) => {
                this.db = event.target.result;
                resolve(req);
            };

            req.onerror = (event: any) => {
                reject('error opening database ' + event.target.errorCode);
            }
        });
    }

    async filterMenuItems(mainCategory: string, selectedSubCat: boolean = true): Promise<Menu[]> {
        if (this.db == null) {
            await this.open();
        }
        let subcategories: string[] = (await this.getSubcategories(mainCategory, selectedSubCat)).map(c => c.name);
        if (subcategories.length == 0) {
            subcategories = (await this.getSubcategories(mainCategory, false)).map(c => c.name);
        }

        return new Promise((resolve, reject) => {
            const tx: IDBTransaction = this.db.transaction('menu', "readwrite");
            let menuStore: IDBObjectStore = tx.objectStore("menu");
            let index = menuStore.index("itemMainCategory_idx");
            let request: IDBRequest;

            request = index.openCursor(IDBKeyRange.only(mainCategory))

            let menuItems: Menu[] = [];
            request.onsuccess = (event: any) => {
                let cursor: IDBCursorWithValue = request.result;

                if (cursor) {
                    // Called for each matching record.
                    let menuItem: Menu = plainToInstance(Menu, cursor.value);
                    if (subcategories == null || subcategories.length == 0 || subcategories.includes(menuItem.category)) {
                        menuItems.push(menuItem);
                    }
                    cursor.continue();
                } else {
                    resolve(menuItems);
                }
            }
        });
    }

    
    async getSubcategories(mainCategory: string, selected: boolean): Promise<Category[]> {
        if (this.db == null) {
            await this.open();
        }
        return new Promise((resolve, reject) => {
            const tx: IDBTransaction = this.db.transaction('category', "readwrite");
            let categoryStore: IDBObjectStore = tx.objectStore("category");
            const index = categoryStore.index("cat_idx");
            const request: IDBRequest = index.openCursor(IDBKeyRange.only(mainCategory));
            let categories: Category[] = [];
            request.onsuccess = (event: any) => {                
                let cursor: IDBCursorWithValue = request.result;

                if (cursor) {
                    const myCat = plainToInstance(Category, cursor.value);                    
                    // Called for each matching record.
                    if (!selected || (selected && myCat.selected)) {
                        categories.push(myCat);
                    }

                    cursor.continue();
                } else {
                    resolve(categories);
                }
            };
        });
    }

    async clearDatabase() {
        if (this.db == null) {
            await this.open();
        }
        const tx: IDBTransaction = this.db.transaction('category', "readwrite");
        // clear category table
        tx.objectStore("category").clear();

        const txMenu: IDBTransaction = this.db.transaction('menu', "readwrite");
        // clear menu table
        txMenu.objectStore("menu").clear();

        this.clearCart()
    }

    async clearCart() {
        if (this.db == null) {
            await this.open();
        }

        const txCart: IDBTransaction = this.db.transaction('cart', "readwrite");
        // clear cart table
        txCart.objectStore("cart").clear();
    }

    async insertOrUpdateCategory(categories: Category[]) {
        if (this.db == null) {
            await this.open();
        }

        return new Promise((resolve, reject) => {
            const tx: IDBTransaction = this.db.transaction('category', "readwrite");

            var t0 = new Date().getTime();
            for (var i = 0; i < categories.length; i++) {
                tx.objectStore('category').put(categories[i]);
            }
            tx.oncomplete = (event) => {
                console.log((new Date().getTime() - t0));
                resolve(0);
            }
            tx.onabort = (event) => {
                console.log((new Date().getTime() - t0));
                reject(tx.error);
            }
        });
    }

    async insertMenu(menuItems: Menu[]) {
        if (this.db == null) {
            await this.open();
        }
        return new Promise((resolve, reject) => {
            const tx: IDBTransaction = this.db.transaction('menu', "readwrite");

            var t0 = new Date().getTime();
            for (var i = 0; i < menuItems.length; i++) {
                tx.objectStore('menu').add(menuItems[i]);
            }
            tx.oncomplete = (event) => {
                console.log((new Date().getTime() - t0));
                resolve(0);
            }
            tx.onabort = (event) => {
                console.log((new Date().getTime() - t0));
                reject(tx.error);
            }
        });
    }

    async getCartItems() : Promise<CartItem[]> {
        if (this.db == null) {
            await this.open();
        }

        return new Promise((resolve, reject) => {
            const tx: IDBTransaction = this.db.transaction('cart', "readwrite");
            let req: IDBRequest = tx.objectStore('cart').getAll();

            tx.oncomplete = (event) => {
                resolve((req.result as Object[]).map(value => plainToClass(CartItem, value)));
            }
            tx.onabort = (event) => {
                reject(tx.error);
            }
        });
    }
    async getCartItem(itemId: number) : Promise<CartItem> {
        if (this.db == null) {
            await this.open();
        }

        return new Promise((resolve, reject) => {
            const tx: IDBTransaction = this.db.transaction('cart', "readwrite");
            let req: IDBRequest = tx.objectStore('cart').get(itemId);

            tx.oncomplete = (event) => {
                resolve(plainToClass(CartItem, req.result));
            }
            tx.onabort = (event) => {
                reject(tx.error);
            }
        });
    }

    async insertOrUpdateIntoBag(cartItem: CartItem) {
        if (this.db == null) {
            await this.open();
        }

        return new Promise((resolve, reject) => {
            const tx: IDBTransaction = this.db.transaction('cart', "readwrite");
            var t0 = new Date().getTime();

            if (cartItem.quantity == 0) {
                tx.objectStore('cart').delete(cartItem.itemId);
            } else {
                tx.objectStore('cart').put(cartItem);
            }
            tx.oncomplete = (event) => {
                console.log((new Date().getTime() - t0));
                resolve(0);
            }
            tx.onabort = (event) => {
                console.log((new Date().getTime() - t0));
                reject(tx.error);
            }
        });
    }
}