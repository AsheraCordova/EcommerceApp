import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//start - import

//end - import
//start - className
export default class OrderList extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        
		static createInstance () {
			return new OrderList();
		}
        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body

}
        