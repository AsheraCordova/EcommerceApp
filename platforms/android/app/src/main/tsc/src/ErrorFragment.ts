import {Fragment, Inject} from './app/Fragment';
import {NavController, InjectController} from './navigation/NavController';
import {error, error_detail} from './R/NavGraph';

export default class ErrorFragment extends Fragment {
    @InjectController({})
    navController!: NavController;
    constructor() {
        super();
    }

    display = async(errorData: any) => {
        this.navController.navigate(error, "errors->view as list", errorData.errors).executeCommand();
    }

    gotoErrorDetails = async(obj: any) => {
        await this.navController.navigate(error_detail, "error->view as map", obj.error).executeCommand();
    }
}
