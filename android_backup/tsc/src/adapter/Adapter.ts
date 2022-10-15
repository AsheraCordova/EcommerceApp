import { User, RegistrationScreenData, Registration, PasswordUpdate, Notification, Order, Store } from "../Model";

export default interface Adapter {
      getMenu():  Promise<void>;
      updatePassword(model: PasswordUpdate):  Promise<void>;
      updateUser(user: User):  Promise<void>;
      register(registration: Registration):  Promise<void>;
      sendOtp(mobileNumber: string):  Promise<void>;
      getRegScreenData() : Promise<RegistrationScreenData>;
      login(username: string, password: string) : Promise<User>;
      getNotifications() : Promise<Notification[]>;
      getOrders(): Promise<Order[]>;
      getStores(): Promise<Store[]>;
}