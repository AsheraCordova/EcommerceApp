import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//start - import

import { RelativeLayout } from './android/widget/RelativeLayoutImpl';

//end - import
import { login } from './R/NavGraph';


//start - className
export default class Index extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/mainLayout" })

        private mainLayout!:RelativeLayout;

		static createInstance () {
			return new Index();
		}
        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body

        async gotoLogin() {
           this.navController.navigateAsTop(login).executeCommand();
        }
}
    