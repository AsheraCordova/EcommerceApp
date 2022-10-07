
//start - import
import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

import { WebView } from './android/widget/WebViewImpl';

//end - import
//start - className
export default class Webview extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/webview" })

        private webview!:WebView;


        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body

        async showWebView() {
            this.webview.updateModelDataWithScopedObject(new ScopedObject("webviewVisible->view as bool", true)).
                refreshUiFromModel("progressbar,webview");
            await this.executeCommand(this.webview);
        }

}
        