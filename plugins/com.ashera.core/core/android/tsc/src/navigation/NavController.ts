declare var coreManager :any;
import { classToPlain } from 'class-transformer';
import { ScopedObject } from '../app/ScopedObject';

export class NavController {
	commands:any[];
	constructor() {
		this.commands = [];
	}
	
	reset() : NavController {
		this.commands = [];
		return this;
	}
	
	popBackStack() : NavController {
		this.commands.push(["popBackStack"]);
		return this;
	}
	
	popBackStackTo(destinationId: string, inclusive: boolean) : NavController {
        this.commands.push(["popBackStackTo", destinationId, inclusive]);
        return this;
    }
	
	closeDialog() : NavController {
		this.commands.push(["closeDialog"]);
		return this;
	}
	
	navigate(actionId:string, varExpression: string, data:any) : NavController {
		this.navigateTo(actionId, new ScopedObject(varExpression, data));
		return this;
	}
	
	navigateWithPopBackStack(actionId:string, ...scopedObjects:ScopedObject[]) : NavController {
		this.commands.push(["navigateWithPopBackStack", actionId, classToPlain(scopedObjects)]);
		return this;
	}
	
	navigateAsTop(actionId:string, ...scopedObjects:ScopedObject[]) : NavController {
		this.commands.push(["navigateAsTop", actionId, classToPlain(scopedObjects)]);
		return this;
	}
	
	navigateWithPopBackStackTo(actionId:string, destinationId: string, inclusive: boolean, ...scopedObjects:ScopedObject[]) : NavController {
		this.commands.push(["navigateWithPopBackStackTo", actionId, destinationId, inclusive, classToPlain(scopedObjects)]);
		return this;
	}
	
	navigateTo(actionId:string, ...scopedObjects:ScopedObject[]) : NavController {
		this.commands.push(["navigate", actionId, classToPlain(scopedObjects)]);
		return this;
	}
	
	public executeCommand = async() => { 
        let result: string = await this.getExecuteCommandPromise();				
        return JSON.parse(result);
    }

    private getExecuteCommandPromise() : Promise<string> {
        return new Promise<string>((resolve, reject) => {
			let commands = [...this.commands];
			this.reset();
            coreManager.navigateCommand(commands, (result:string) => {
                resolve(result);
            });
        });
    }
}

export function InjectController(arg: any) {
    return function recordInjection(target : any, decoratedPropertyName : string) : void {
        let t = Reflect.getMetadata("design:type", target, decoratedPropertyName);
        target[decoratedPropertyName] = new NavController();
    };
}
