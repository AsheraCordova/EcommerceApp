import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//start - import

import { TextView } from './android/widget/TextViewImpl';

//end - import
//start - className
export default class ForgotPasswordOtp extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/submit" })

        private submit!:TextView;


        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body

        async forgotPasswordOtp() {
            if (await this.validateForm("default", this.submit)) {
                this.navController.popBackStackTo('login', false).executeCommand();
            }
        }

}
        