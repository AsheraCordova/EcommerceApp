import "reflect-metadata";
declare var navigationManager :any;
declare var coreManager :any;
import 'babel-polyfill';
import IWidget from '../widget/IWidget';
import {plainToClass, serialize} from "class-transformer";
import { View } from  '../android/widget/ViewImpl';

export class Fragment {

    public findViewById<T>(id: string, type: { new(id?: string, path?: string[], event?: string): T ;} ): T {
        return new type(id, undefined, undefined);
    }

	public onAttach(obj:any) {
    }

    public onCreate(obj:any) {
    }

    public onResume(obj:any) {
    }

    public onError(obj:any) {
    }

    public onPause(obj:any) {
    }

    public onDestroy(obj:any) {
    }

    public onDetach(obj:any) {
    }

	public onCloseDialog(obj:any) {
    }

    public findViewByPath<T>(path: string[], type: { new(id?: string, path?: string[], event?: string): T ;} ): T {
        return new type(undefined, path, undefined);
    }
    
    public fireEventToWidget<T>(event: string, type: { new(id?: string, path?: string[], event?: string): T ;} ): T {
        return new type(undefined, undefined, event);
    }

    public validateForm = async(form: string, viewCommand: View) : Promise<string> => {
        viewCommand.validateForm(form).tryGetValidateForm();
        await this.executeCommand(viewCommand);
        return viewCommand.getValidateForm();
    }
    
    public executeCommand = async(...commands: IWidget[]) => {
        let commandArray: string = await this.executeInternalCommand(commands);
        let resultCommands: any[] = JSON.parse(commandArray);
        for (let i = 0; i < resultCommands.length; i++) {
            let resultCommand = resultCommands[i];
            this.updateCommandReturnValue(resultCommand, commands[i]);
        }

        for (let i = 0; i < commands.length; i++) {
            let command: any = commands[i];
            command.markForReset();
        }
    }
    
    public updateCommandReturnValue(obj:any, source: any): void {
    	Object.keys(obj).forEach((key) => {
        	if (key == 'layoutParams') {
        		this.updateCommandReturnValue(obj[key], source["layoutParams"]);
        	}
        	if (key != 'id' && typeof obj[key] == 'object') {
				let sourceKey = key;
				if (typeof source[key] == 'function') {
					sourceKey = sourceKey + "_";
				}
				source[sourceKey]["commandReturnValue"] = obj[key]["commandReturnValue"]; 
			}
		});
    }

    public startActivity = async(fileName: string, varExpression:string, data:any) => {
        let result: string = await this.executeStartActivity(fileName, varExpression, data);
        return JSON.parse(result);
    }

    private executeStartActivity(fileName: string, varExpression:string, data:any) : Promise<string> {
        return new Promise<string>((resolve, reject) => {
            navigationManager.startActivity(fileName, varExpression, data, (result:string) => {
                resolve(result);
            });
        });
    }

    private executeInternalCommand(commands: any[]) : Promise<string> {
        return new Promise<string>((resolve, reject) => {
            coreManager.executeCommand(serialize(commands), (result:string) => {
                resolve(result);
            });
        });
    }
}


export function Inject(arg: any) {
    return function recordInjection(target : any, decoratedPropertyName : string) : void {
            let t = Reflect.getMetadata("design:type", target, decoratedPropertyName);
            if (arg.id) {
            	target[decoratedPropertyName] = target.findViewById(arg.id, t);
            } else if (arg.path) {
            	target[decoratedPropertyName] = target.findViewByPath(arg.path, t);
            } else if (arg.event) {
            	target[decoratedPropertyName] = target.fireEventToWidget(arg.event, t);
            } 
        };
}
