
//start - import
import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//end - import
import { qrcode_scanner } from './R/NavGraph';

//start - className
export default class OrderBooked extends Fragment
//end - className
{
    //start - body
        @InjectController({})
        navController!: NavController;
        

        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body
    async dismissBookedDialog() {
        await this.navController.closeDialog().popBackStack().executeCommand();
        console.log("dismissBookedDialog");
        // await this.navController.executeCommand();        

    }

    async scanQRCode() {
        await this.navController.closeDialog().popBackStack().navigateTo(qrcode_scanner).executeCommand();
    }

    

}
