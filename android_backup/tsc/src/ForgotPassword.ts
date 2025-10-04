import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//start - import

import { ImageView } from './android/widget/ImageViewImpl';

//end - import

import { forgot_password_otp } from './R/NavGraph';

//start - className
export default class ForgotPassword extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/submit" })

        private submit!:ImageView;

		static createInstance () {
			return new ForgotPassword();
		}
        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body
        async forgotPassword() {
            if (await this.validateForm("default", this.submit)) {
                this.navController.navigateTo(forgot_password_otp).executeCommand();
            }
        }

}
        