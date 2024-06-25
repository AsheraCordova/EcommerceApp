import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//start - import

import { DrawerLayout } from './android/widget/DrawerLayoutImpl';

import { TextView } from './android/widget/TextViewImpl';

import { RecyclerView } from './android/widget/RecyclerViewImpl';

import { LinearLayout } from './android/widget/LinearLayoutImpl';

//end - import
import { Gravity } from './widget/TypeConstants';
import { change_password, dashboard_filter, dashboard_quantity, faq, login, notification_list, order_list, order_preview_cart, selectstore, webview } from './R/NavGraph';
import DatabaseAdapter from './adapter/DatabaseAdapter';
import { AddToBagEvent, BookItemEvent, CartItem, Category, CategorySelectionEvent, eventBus, filterChangeEvent, Menu, Notification, Order, RegistrationScreenData } from './Model';
import EventType from './app/EventType';
import AdapterFactory from './adapter/AdapterFactory';
import Progress from './decorator/Progress';
import LocaleManager from './app/LocaleManager';

//start - className
export default class Dashboard extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/drawerLayout" })

        private drawerLayout!:DrawerLayout;
@Inject({ id: "@+id/noOfItems" })

        private noOfItems!:TextView;
@Inject({ id: "@+id/menuItemsRecyclerView" })

        private menuItemsRecyclerView!:RecyclerView;
@Inject({ id: "@+id/filterIcon" })

        private filterIcon!:LinearLayout;
@Inject({ id: "@+id/categoriesContainer" })

        private categoriesContainer!:LinearLayout;


        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body
    filterChangeEvent: any;
    private unsubscribeFilterChangeEvent: () => void;
    constructor() {
        super();
        this.unsubscribeFilterChangeEvent = eventBus.subscribe(filterChangeEvent, event => {
            this.filterChangeEvent = event.payload.categories;
        });

    }
    public onDestroy(obj: any): void {
        this.unsubscribeFilterChangeEvent();
    }

    currentCategory = "drinks";
    public async onCreate(obj: any): Promise<void> {
        await this.filterMenuItems();
        this.categoriesContainer.updateModelData("refreshing->view as bool", false).
            refreshUiFromModel("refreshData,dataContainer");
        await this.executeCommand(this.categoriesContainer);
    }

    public async onCloseDialog(obj: any): Promise<void> {
        await this.onResume(obj);
    }

    public async onResume(obj: any): Promise<void> {
        if (this.filterChangeEvent != null) {
            await this.filterMenuItems();
            this.filterChangeEvent = null;
        }
    }
    private async filterMenuItems() {
        let cartItems = await DatabaseAdapter.getInstance().getCartItems();
        let menuItems: Menu[] = await DatabaseAdapter.getInstance().filterMenuItems(this.currentCategory);
        let categoryMap: any = {};
        let sections = [];
        let cartItemsMap: any = {};
        for (var i = 0; i < cartItems.length; i++) {
            cartItemsMap[cartItems[i].itemId] = cartItems[i].quantity;
        }

        for (var i = 0; i < menuItems.length; i++) {
            let item: Menu = menuItems[i];
            let category = item.category;

            if (categoryMap[category] == null) {
                categoryMap[category] = [];
                let section: any = {};
                section["name"] = category;
                section["items"] = categoryMap[category];
                sections.push(section);
            }

            if (cartItemsMap[item.itemId]) {
                item.bookedText = ` (${cartItemsMap[item.itemId]})`;
            } else {
                item.bookedText = '';
            }

            categoryMap[category].push(item);
        }
        this.menuItemsRecyclerView.updateModelDataWithScopedObject(
            new ScopedObject("sections->view as list", sections)
        ).notifyDataSetChanged(true);

        let categories: Category[] = await DatabaseAdapter.getInstance().getSubcategories(this.currentCategory, false);
        this.categoriesContainer.updateModelData("categories->view as list", categories).notifyDataSetChanged(true);
        this.noOfItems.updateModelDataWithScopedObject(
            new ScopedObject("noOfItems->view as integer", cartItems.length),
            new ScopedObject("noOfItemsVisibility->view as bool", cartItems.length > 0)).refreshUiFromModel("noOfItems");
        await this.executeCommand(this.categoriesContainer, this.menuItemsRecyclerView, this.noOfItems);            


    }

    async openDrawer() {
        this.drawerLayout.openDrawer(Gravity.start);
        await this.executeCommand(this.drawerLayout);
    }

    async showFilterDialog() {
        let categories: Category[] = await DatabaseAdapter.getInstance().getSubcategories(this.currentCategory, false);
        this.navController.navigateTo(dashboard_filter,
            new ScopedObject("categories->view as list", categories)).executeCommand();    
    }

    @EventType(BookItemEvent)
    async book(event: BookItemEvent) {
        let menu = event.getMenuItem();

        let cartItem: CartItem = await DatabaseAdapter.getInstance().getCartItem(menu.itemId);
        
        if (cartItem == null) {
            cartItem = this.createCartItem(menu);
        }

        let mixers: Menu[] = [];
        if (menu.category == 'Whisky') {
            mixers = await (await DatabaseAdapter.getInstance().filterMenuItems(this.currentCategory, false)).filter(value => value.category == 'Mixers');        
        }
        let mixerCartItems: CartItem[] = [];
        for (let i in mixers) {
            let mixer: Menu = mixers[i];
            let mixerCartItem: CartItem = await DatabaseAdapter.getInstance().getCartItem(mixer.itemId);
            if (mixerCartItem == null) {
                mixerCartItem = this.createCartItem(mixer);
                mixerCartItem.quantity = 0;
            }

            mixerCartItems.push(mixerCartItem);
        }
        this.navController.navigateTo(dashboard_quantity,
            new ScopedObject("item->view as map", cartItem),
            new ScopedObject("mixers->view as list", mixerCartItems)).executeCommand();   
    }

    createCartItem(menu:Menu) : CartItem{
        let cartItem = new CartItem();
        cartItem.category = menu.category;
        cartItem.itemCode = menu.itemCode;
        cartItem.itemId = menu.itemId;
        cartItem.itemMainCategory = menu.itemMainCategory;
        cartItem.name = menu.name;
        cartItem.sellPrice = menu.sellPrice;
        cartItem.storeCode = menu.storeCode;
        cartItem.type = menu.type;
        cartItem.quantity = 1;
        return cartItem;
    }

    private async refreshTabs(drinks: boolean, food: boolean, ...scopedObjects: ScopedObject[]) {
        this.drawerLayout.updateModelDataWithScopedObject(
            new ScopedObject("drinks->view as bool", drinks),
            new ScopedObject("food->view as bool", food),
            ...scopedObjects
        ).refreshUiFromModel(`drinks,food,drinksText,foodText,drinksImage,foodImage`)
        
        await this.executeCommand(this.drawerLayout);
    }

    async selectFood() {
        this.currentCategory = "food";
        await this.filterMenuItems();
        this.refreshTabs(false, true);
    }

    async selectDrinks() {
        this.currentCategory = "drinks";
        await this.filterMenuItems();
        this.refreshTabs(true, false);
    }

    @EventType(CategorySelectionEvent)
    async applyMainFilter(event: CategorySelectionEvent) {
        let category = event.getCategory();
        category.selected = !category.selected;
        await DatabaseAdapter.getInstance().insertOrUpdateCategory([category]);        
        this.categoriesContainer.addModel(category).notifyDataSetChanged(true);
        this.executeCommand(this.categoriesContainer);
        await this.filterMenuItems();
    }

    async viewAll() {
        let categories = await DatabaseAdapter.getInstance().getSubcategories(this.currentCategory, false);

        for (let i in categories) {
            categories[i].selected = false;
        }
        await DatabaseAdapter.getInstance().insertOrUpdateCategory(categories);        
        this.filterMenuItems();
    }

    @Progress("@string/loading")
    async onMenuItemClick(event: any) {
        if (event.itemId == '@+id/transactions') {
            let cartItems = await DatabaseAdapter.getInstance().getCartItems();
            this.navController.navigateTo(order_preview_cart,
                new ScopedObject("cartItems->view as list", cartItems)).executeCommand();
        }
        if (event.itemId == '@+id/notify') {
            let notifications: Notification[] = await AdapterFactory.getInstance().getNotifications();
            this.navController.navigateTo(notification_list, new ScopedObject("notifications->view as list", notifications)).executeCommand();
        }
        
    }
    
    @Progress("@string/loading")
    async gotoOrderList() {
        let orders: Order[] = await AdapterFactory.getInstance().getOrders();
        this.navController.navigateTo(order_list,
            new ScopedObject("orders->view as list", orders)).executeCommand();
    }

    async goToChangePassword() {
        this.navController.navigateTo(change_password).executeCommand();
    }

    async goToSelectStore() {
        this.navController.navigateAsTop(selectstore).executeCommand();
    }

    @Progress("@string/loading")
    async goToFAQ() {
        let registrationScreenData: RegistrationScreenData = await AdapterFactory.getInstance().getRegScreenData();
        this.navController.navigateTo(faq,
            new ScopedObject("registrationScreenData->view as map", registrationScreenData)).executeCommand();
    }

    async gotoPrivacyPolicy() {
        await this.navController.navigateTo(webview,
            new ScopedObject("webviewVisible->view as bool", false),
            new ScopedObject("webviewTitle->view as string", "@string/privacy_policy"),
            new ScopedObject("webviewUrl->view as string", "https://www.lipsum.com/")).executeCommand();
    }

    
    async termsAndConditions() {
        await this.navController.navigateTo(webview,
            new ScopedObject("webviewVisible->view as bool", false),
            new ScopedObject("webviewTitle->view as string", "@string/terms_and_conditions"),
            new ScopedObject("webviewUrl->view as string", "https://www.lipsum.com/")).executeCommand();
    }

    async logout() {
        let confirmMsg = LocaleManager.getInstance().translate("@string/confirm_logout");
        let flag = confirm(confirmMsg);
        if (flag) {
            await this.navController.navigateAsTop(login, 
                new ScopedObject("login->view as map", {})).executeCommand(); 
        }
    }


}
        