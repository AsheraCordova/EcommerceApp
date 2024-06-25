import { Type, Expose, Transform } from 'class-transformer';
import moment from 'moment';
import { Event } from './app/Event';
import { EventBus, createEventDefinition } from "ts-bus";

export const eventBus = new EventBus();

export const filterChangeEvent = createEventDefinition<{
  categories: Category[];
}>()("filter.updated");

export function DateToString() {
  const toPlain = Transform(({ value }) => moment(value as Date).format('DD/MM/yyyy'), {
    toPlainOnly: true,
  });

  const toClass = Transform(({ value }) => moment(value, "DD/MM/yyyy").toDate(), {
    toClassOnly: true,
  });

  return function (target: any, key: string) {
    toPlain(target, key);
    toClass(target, key);
  };
}

export function BooleanToString() {
  const toPlain = Transform(({ value }) => Boolean(value as boolean) ? "true" : "false", {
    toPlainOnly: true,
  });

  const toClass = Transform(({ value }) => value != null && (value as string).toLowerCase() == 'true', {
    toClassOnly: true,
  });

  return function (target: any, key: string) {
    toPlain(target, key);
    toClass(target, key);
  };
}


const toPlainTransformInt = Transform(({ value }) => (value | 0) + "", {
  toPlainOnly: true,
});

const toClassTransformInt = Transform(({ value }) => parseInt(value), {
  toClassOnly: true,
});

export function StringToIntOnly() {
  return function (target: any, key: string) {
    toClassTransformInt(target, key);
  };
}
export function IntToString() {
  return function (target: any, key: string) {
    toPlainTransformInt(target, key);
    toClassTransformInt(target, key);
  };
}

export class User {
  id: number;
  firstName: string;
  lastName: string;
  @DateToString()
  dob: Date;
  emailId: string;
  mobileNumber: string;
  status: string;
  gender: string;
  city: string;
  state: string;
  officeAddress: string;
  residenceAddress: string;

  @Expose()
  get membershipComplete() {
    return (this.status === 'Complete');
  }

  @Expose()
  get name() {
    return `${this.firstName} ${this.lastName}`;
  }
}



export class Store {
  id: string;
  name: string;
  openTime: string;
  closeTime: string;

  @Expose()
  get timing(): string {
    return `${this.openTime} - ${this.closeTime}`;
  }
}

export class Notification {
  @DateToString()
  createdDate: Date;
  title: string;
  desc: string;
  @Expose()
  @IntToString()
  get createdDay(): number {
    return this.createdDate.getDate();
  }

  @Expose()
  get createdMonthYear(): string {
    return moment(this.createdDate).format('MMM yyyy');
  }
}

export class RegistrationType {
  id: string;
  title: string;
  desc: string;
  details: string;
  @Expose()
  get description() {
    return `<span textColor='#000' textSize='16sp'>${this.title}</span><br><span textColor='#000' textSize='14sp'><![CDATA[${this.desc}]]></span>`;
  }
}

export class DropDown {
  id: string;
  value: string;
}

export class RegistrationScreenData {
  @Type(() => RegistrationType)
  regTypes: RegistrationType[];
  @Type(() => DropDown)
  favDrinks: DropDown[];
  @Type(() => DropDown)
  favStarters: DropDown[];
}

export class Registration {
  id: string;
  membershipType: string;
  firstName: string;
  lastName: string;
  @DateToString()
  dateOfBirth: Date;
  gender: string;
  mobileNumber: string;
  email: string;
  password: string;
  confirmPassword: string;
  primaryFavouriteDrink: string;
  secondaryFavouriteDrink: string;
  favStarter: string;
  otp:string;
  terms: boolean;
}


export class PasswordUpdate {
  oldPassword:string;
  newPassword:string;
  confirmPassword:string;
}

export class Category {
  id: number;
  name: string;
  itemMainCategory: string;
  selected: boolean;
  
  @Expose()
  get image() {
    const id = this.name.toLowerCase().replace(/ /g,"_");
    if (this.selected)  {      
      return `@drawable/category_${id}_wht`;  
    }
    return `@drawable/category_${id}`;
  }
}
export class Menu {
  itemId: number;
  name: string;
  itemCode: string;
  type: string;
  category: string;
  @IntToString()
  sellPrice: number;
  @IntToString()
  highPrice: number;
  @IntToString()
  lowPrice: number;
  storeCode: string;
  itemMainCategory: string;
  bookedText = '';
}


export class OnClickEvent implements Event {
  id: string;
  action: string;
  eventType: string;
  event: string;
  parentFragments: string;
}

export class CategorySelectionEvent extends OnClickEvent {
  @Type(() => Category)
  private model: Category;

  getCategory(): Category {
      return this.model;
  }
}

export class ClearSelectionEvent extends OnClickEvent {
  @Type(() => Category)
  private model: Category[];

  getCategory(): Category[] {
      return this.model;
  }
}

export class StoreSelectionEvent extends OnClickEvent {
  @Type(() => Store)
  private model: Store;

  getStore(): Store {
      return this.model;
  }
}

export class ApplySelectionEvent extends OnClickEvent {
  @Type(() => Category)
  private model: Category[];

  getCategory(): Category[] {
      return this.model;
  }
}

export class BookItemEvent extends OnClickEvent {
  @Type(() => Menu)
  private model: Menu;

  getMenuItem(): Menu {
      return this.model;
  }
}

export class AddToBagEvent extends OnClickEvent {
  @Type(() => CartItem)
  private model: CartItem;
  @Type(() => CartItem)
  private mixers: CartItem[];

  getCartItem(): CartItem {
      return this.model;
  }

  getMixerCartItems(): CartItem[] {
    return this.mixers;
}
}

export class AddMixerEvent extends OnClickEvent {
  @Type(() => CartItem)
  private model: CartItem;

  getCartItem(): CartItem {
      return this.model;
  }
}

export class CartItem {
  itemId: number;
  name: string;
  itemCode: string;
  type: string;
  category: string;
  @IntToString()
  sellPrice: number;
  storeCode: string;
  itemMainCategory: string;
  @IntToString()
  quantity: number;
  @Expose()
  get mixerBg() {    
    if (this.quantity > 0) {
      return "#f0f0f0";
    }
    return "#ffffff";
  }
  @Expose()
  get nameAndQty() {    
    return `${this.name} - [${this.quantity}]`;
  }

  @Expose()
  get image() {
    const id = this.name.toLowerCase().replace(/ /g,"_");
    return `@drawable/mixer_${id}`;
  }
}


export class Order {
  @DateToString()
  createdDate: Date;
  orderRef: string;
  desc: string;
  status: string;
  expires: number;
  cost: number;
  @Expose()
  @IntToString()
  get createdDay(): number {
    return this.createdDate.getDate();
  }

  @Expose()
  get createdMonthYear(): string {
    return moment(this.createdDate).format('MMM yyyy');
  }
}

