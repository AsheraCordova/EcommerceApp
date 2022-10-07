
//start - import
import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

import { TextView } from './android/widget/TextViewImpl';

import { LinearLayout } from './android/widget/LinearLayoutImpl';

//end - import

import EventType from './app/EventType';
import { AddMixerEvent, AddToBagEvent, eventBus, filterChangeEvent } from './Model';
import DatabaseAdapter from './adapter/DatabaseAdapter';

//start - className
export default class DashboardQuantity extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/addToBagButton" })

        private addToBagButton!:TextView;
@Inject({ id: "@+id/mixerGridLayout" })

        private mixerGridLayout!:LinearLayout;


        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body
        async quantityDialogDismiss() {
            await this.navController.closeDialog().executeCommand();
        }

        @EventType(AddToBagEvent)
        async addToBag(event: AddToBagEvent) {
            if (await this.validateForm("defaultForm", this.addToBagButton)) {
                await DatabaseAdapter.getInstance().insertOrUpdateIntoBag(event.getCartItem());
                let mixers = event.getMixerCartItems();
                for (let i in mixers) {
                    await DatabaseAdapter.getInstance().insertOrUpdateIntoBag(mixers[i]);
                }
                eventBus.publish(filterChangeEvent({categories: []}));
                await this.navController.closeDialog().executeCommand(); 
            }           
        }
        
        @EventType(AddMixerEvent)
        async addMixersToCart(event: AddMixerEvent) {
            let cartItem = event.getCartItem();
            cartItem.quantity = cartItem.quantity + 1;
            this.mixerGridLayout.addModel(cartItem).notifyDataSetChanged(true);
            this.executeCommand(this.mixerGridLayout);
        }

        @EventType(AddMixerEvent)
        async removeMixerFromCart(event: AddMixerEvent) {
            let cartItem = event.getCartItem();
            cartItem.quantity = 0;
            this.mixerGridLayout.addModel(cartItem).notifyDataSetChanged(true);
            this.executeCommand(this.mixerGridLayout);
        }
}
        