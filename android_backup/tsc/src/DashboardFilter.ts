import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';

//start - import

import { LinearLayout } from './android/widget/LinearLayoutImpl';

//end - import

import EventType from './app/EventType';
import { ApplySelectionEvent, ClearSelectionEvent, eventBus, filterChangeEvent } from './Model';
import DatabaseAdapter from './adapter/DatabaseAdapter';

//start - className
export default class DashboardFilter extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        @Inject({ id: "@+id/filterItems" })

        private filterItems!:LinearLayout;


        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body
        @EventType(ApplySelectionEvent)
        async applyFilter(event: ApplySelectionEvent) {
            await DatabaseAdapter.getInstance().insertOrUpdateCategory(event.getCategory());
            eventBus.publish(filterChangeEvent({ categories: event.getCategory() }));
            this.dismissFilterDialog();
        }

        async dismissFilterDialog() {
            this.navController.closeDialog().executeCommand();
        }

        @EventType(ClearSelectionEvent)
        async clearFilter(event: ClearSelectionEvent) {
            let categories = event.getCategory();

            for (let i in categories) {
                categories[i].selected = false;
            }
            this.filterItems.updateModelData("categories->view as list", categories).notifyDataSetChanged(true);
            this.executeCommand(this.filterItems);
        }
}
        