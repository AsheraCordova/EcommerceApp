import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//start - import

import { TextView } from './android/widget/TextViewImpl';

import { RecyclerView } from './android/widget/RecyclerViewImpl';

//end - import
import { AddToBagEvent, CartItem, eventBus, filterChangeEvent } from './Model';
import DatabaseAdapter from './adapter/DatabaseAdapter';
import EventType from './app/EventType';
import { order_booked } from './R/NavGraph';

//start - className
export default class OrderPreviewCart extends Fragment
//end - className
{
    //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/locationText" })

        private locationText!:TextView;
@Inject({ id: "@+id/cartItemsRecyclerView" })

        private cartItemsRecyclerView!:RecyclerView;


        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body
    public onCreate(obj: any): void {
        navigator.geolocation.getCurrentPosition((position: any) => {
            let distance = this.getDistanceFromLatLonInKm(position.coords.latitude, position.coords.longitude,
                12.9255, 77.5468);
            this.locationText.updateModelData("distance->view as string", distance + "").refreshUiFromModel("locationText");
            this.executeCommand(this.locationText);
        });        
    }

    getDistanceFromLatLonInKm(lat1: number, lon1: number, lat2: number, lon2: number) {
        var R = 6371; // Radius of the earth in km
        var dLat = this.deg2rad(lat2 - lat1);  // deg2rad below
        var dLon = this.deg2rad(lon2 - lon1);
        var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(this.deg2rad(lat1)) * Math.cos(this.deg2rad(lat2)) *
            Math.sin(dLon / 2) * Math.sin(dLon / 2);
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        var d = R * c; // Distance in km
        return d;
    }

    deg2rad(deg: number) {
        return deg * (Math.PI / 180)
    }


    @EventType(AddToBagEvent)
    async updateCart(event: AddToBagEvent) {
        if (event.getCartItem()) {

            let cartItem: CartItem = await DatabaseAdapter.getInstance().getCartItem(event.getCartItem().itemId);
            if (cartItem.quantity != event.getCartItem().quantity) {
                await DatabaseAdapter.getInstance().insertOrUpdateIntoBag(event.getCartItem());
                eventBus.publish(filterChangeEvent({ categories: [] }));

                this.cartItemsRecyclerView.notifyDataSetChanged(true);
                await this.executeCommand(this.cartItemsRecyclerView);
            }
        }
    }

    @EventType(AddToBagEvent)
    async deleteFromCart(event: AddToBagEvent) {
        let cartItem: CartItem = event.getCartItem();
        cartItem.quantity = 0;
        await DatabaseAdapter.getInstance().insertOrUpdateIntoBag(cartItem);
        this.cartItemsRecyclerView.removeModelById(cartItem.itemId + '').notifyDataSetChanged(true)
            .refreshUiFromModel("cartItemsContainer,noData");
        await this.executeCommand(this.cartItemsRecyclerView);
        eventBus.publish(filterChangeEvent({ categories: [] }));
    }

    async removeAllItems() {
        let flag = confirm("Do you want to clear all items in cart?");

        if (flag) {
            await DatabaseAdapter.getInstance().clearCart();

            this.cartItemsRecyclerView.updateModelData("cartItems->view as list", []).notifyDataSetChanged(true)
                .refreshUiFromModel("cartItemsContainer,noData");
            await this.executeCommand(this.cartItemsRecyclerView);
            eventBus.publish(filterChangeEvent({ categories: [] }));
        }
    }

    async bookItem() {
        await DatabaseAdapter.getInstance().clearCart();
        eventBus.publish(filterChangeEvent({ categories: [] }));
        this.navController.navigateTo(order_booked).executeCommand();
    }

    public async onCloseDialog(obj: any): Promise<void> {

    }
}
