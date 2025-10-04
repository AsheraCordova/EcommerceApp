import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//start - import

import { TextView } from './android/widget/TextViewImpl';

//end - import

import { dashboard, forgot_password, register, selectstore, webview } from './R/NavGraph';
import AdapterFactory from './adapter/AdapterFactory';
import DatabaseAdapter from './adapter/DatabaseAdapter';
import { Category } from './Model';
import Progress from './decorator/Progress';


//start - className
export default class Login extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/submit" })

        private submit!:TextView;

		static createInstance () {
			return new Login();
		}
        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body

    async goToForgotPassword() {
        this.navController.navigateTo(forgot_password).executeCommand();
    }
        
    async login() {       
        if (await this.validateForm("defaultForm", this.submit)) {
            this.navController.navigateTo(selectstore).executeCommand();           
        }
    }
    async goToRegister() {        
        this.navController.navigateTo(register).executeCommand();           
    }
    
}
        