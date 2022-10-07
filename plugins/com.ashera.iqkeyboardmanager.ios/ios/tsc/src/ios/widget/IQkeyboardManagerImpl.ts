// start - imports

	
import CommandAttr from '../../widget/CommandAttr';
import IWidget from '../../widget/IWidget';
import ILayoutParam from '../../widget/ILayoutParam';
import {plainToClass, Type, Exclude, Expose, Transform} from "class-transformer";
import 'babel-polyfill';
import {Gravity} from '../../widget/TypeConstants';
import {ITranform, TransformerFactory} from '../../widget/TransformerFactory';
import {Event} from '../../app/Event';
import {MotionEvent} from '../../app/MotionEvent';
import {DragEvent} from '../../app/DragEvent';
import {KeyEvent} from '../../app/KeyEvent';
import { ScopedObject } from '../../app/ScopedObject';






// end - imports
import {ViewImpl} from './ViewImpl';
export abstract class IQkeyboardManagerImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "nextFocusDown" })
	nextFocusDown!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "nextFocusUp" })
	nextFocusUp!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onEditorAction" })
	onEditorAction!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.nextFocusDown = undefined;
		this.nextFocusUp = undefined;
		this.onEditorAction = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setNextFocusDown(value : string) : T {
		this.resetIfRequired();
		if (this.nextFocusDown == null || this.nextFocusDown == undefined) {
			this.nextFocusDown = new CommandAttr<string>();
		}
		
		this.nextFocusDown.setSetter(true);
		this.nextFocusDown.setValue(value);
		this.orderSet++;
		this.nextFocusDown.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setNextFocusUp(value : string) : T {
		this.resetIfRequired();
		if (this.nextFocusUp == null || this.nextFocusUp == undefined) {
			this.nextFocusUp = new CommandAttr<string>();
		}
		
		this.nextFocusUp.setSetter(true);
		this.nextFocusUp.setValue(value);
		this.orderSet++;
		this.nextFocusUp.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnEditorAction(value : string) : T {
		this.resetIfRequired();
		if (this.onEditorAction == null || this.onEditorAction == undefined) {
			this.onEditorAction = new CommandAttr<string>();
		}
		
		this.onEditorAction.setSetter(true);
		this.onEditorAction.setValue(value);
		this.orderSet++;
		this.onEditorAction.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class IQkeyboardManager extends IQkeyboardManagerImpl<IQkeyboardManager> implements IWidget{
    getThisPointer(): IQkeyboardManager {
        return this;
    }
    
   	public getClass() {
		return IQkeyboardManager;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

IQkeyboardManagerImpl.initialize();

//end - staticinit
