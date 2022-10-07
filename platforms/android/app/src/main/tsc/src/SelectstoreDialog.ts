
//start - import
import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

import { LinearLayout } from './android/widget/LinearLayoutImpl';

//end - import
import EventType from './app/EventType';
import { StoreSelectionEvent } from './Model';

//start - className
export default class SelectstoreDialog extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/selectStoreLL" })

        private selectStoreLL!:LinearLayout;


        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body
        @EventType(StoreSelectionEvent)
        async selectStore(event: StoreSelectionEvent) {
            this.selectStoreLL.updateModelData("store->session as map", event.getStore());
            await this.executeCommand(this.selectStoreLL);
            this.navController.closeDialog().executeCommand();
        }

        async dismissDialog() {
            await this.navController.closeDialog().executeCommand();
        }

}
        