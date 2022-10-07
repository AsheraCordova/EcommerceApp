
//start - import
import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

import { TextView } from './android/widget/TextViewImpl';

//end - import
import { webview } from './R/NavGraph';

//start - className
export default class Register extends Fragment
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

        
    async termsAndConditionsDialog(event: any) {
        if (event.terms) {
            let flag = confirm('Please click ok to view the terms and condition.');

            if (flag) {
                await this.navController.navigateTo(webview,
                    new ScopedObject("webviewVisible->view as bool", false),
                    new ScopedObject("webviewTitle->view as string", "@string/terms_and_conditions"),
                    new ScopedObject("webviewUrl->view as string", "https://www.lipsum.com/")).executeCommand();
            
            }
        }
    }

    async registration() {
        if (await this.validateForm("defaultForm", this.submit)) {
            this.navController.popBackStackTo("login", false).executeCommand();
        }
    }
}
        