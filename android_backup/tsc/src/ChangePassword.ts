import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//start - import

import { TextView } from './android/widget/TextViewImpl';

//end - import
//start - className
export default class ChangePassword extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/submit" })

        private submit!:TextView;

		static createInstance () {
			return new ChangePassword();
		}
        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body
        async changePassword() {
           if (await this.validateForm("defaultForm", this.submit)) {
                this.navController.popBackStack().executeCommand();
           }
        }
}
        