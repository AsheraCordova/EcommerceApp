import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//start - import

import { RelativeLayout } from './android/widget/RelativeLayoutImpl';

//end - import
import { dashboard, selectstore_dialog } from './R/NavGraph';
import AdapterFactory from './adapter/AdapterFactory';
import { Store } from './Model';
import Progress from './decorator/Progress';
//start - className
export default class Selectstore extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/root" })

        private root!:RelativeLayout;


        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body
        @Progress("@string/loading")
        async showSelectStoreDialog() {
            let stores: Store[] = await AdapterFactory.getInstance().getStores();
            setTimeout(() => this.navController.navigateTo(selectstore_dialog,
                new ScopedObject("stores->view as list", stores)).executeCommand(), 0);
        }

        async onCloseDialog(obj: any): Promise<void> {
            this.root.refreshUiFromModel("selectStoreText,letsGo");
            await this.executeCommand(this.root);
        }

        @Progress("@string/loading")
        async goToDashBoard() {
            await AdapterFactory.getInstance().getMenu();            
            this.navController.navigateAsTop(dashboard,
                new ScopedObject("categories->view as list", []),
                new ScopedObject("sections->view as list", []),
                new ScopedObject("drinks->view as bool", true),
                new ScopedObject("food->view as bool", false),
                new ScopedObject("noOfItems->view as integer", 0),
                new ScopedObject("noOfItemsVisibility->view as bool", false),
                new ScopedObject("refreshing->view as bool", true)                
                ).executeCommand();           
    
        }

}
        