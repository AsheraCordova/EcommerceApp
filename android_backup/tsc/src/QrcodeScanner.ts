import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';
import { DialogHelper } from './helpers/DialogHelper';

//start - import

//end - import
declare var QRScanner: any;
//start - className
export default class QrcodeScanner extends Fragment
//end - className
{
    //start - body
        @InjectController({})
        navController!: NavController;
        
		static createInstance () {
			return new QrcodeScanner();
		}
        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body

    public async onCreate(obj: any): Promise<void> {
        try {
        await navigator.mediaDevices.getUserMedia({ video: true });
        } catch (e) {
            //
        }
        QRScanner.prepare(this.onDone.bind(this));
    }

    onDone(err: any, status: any) {
        if (err) {
            // here we can handle errors and clean up any loose ends.
            DialogHelper.alert(JSON.stringify(err), () => {});
            return;
        }
        if (status.authorized) {
            // W00t, you have camera access and the scanner is initialized.
            // QRscanner.show() should feel very fast.            
            QRScanner.scan(this.displayContents);
        } else if (status.denied) {
            // The video preview will remain black, and scanning is disabled. We can
            // try to ask the user to change their mind, but we'll have to send them
            // to their device settings with `QRScanner.openSettings()`.
            DialogHelper.alert("Access is denied", () => {});
        } else {
            // we didn't get permission, but we didn't get permanently denied. (On
            // Android, a denial isn't permanent unless the user checks the "Don't
            // ask again" box.) We can ask again at the next relevant opportunity.
            DialogHelper.alert("onDone", () => {});
        }
    }

    displayContents(err: any, text: any) {
        if (err) {
            // an error occurred, or the scan was canceled (error code `6`)
            DialogHelper.alert(JSON.stringify(err), () => {});
        } else {
            // The scan completed, display the contents of the QR code:
            DialogHelper.alert(JSON.stringify(text), () => {});
        }
    }

    public onDestroy(obj: any): void {
        QRScanner.destroy(function (status: any) {
            console.log(status);
        });
    }
}
