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
export abstract class GroupImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "constraint_referenced_ids" })
	constraint_referenced_ids!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.constraint_referenced_ids = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetConstraint_referenced_ids() : T {
		this.resetIfRequired();
		if (this.constraint_referenced_ids == null || this.constraint_referenced_ids == undefined) {
			this.constraint_referenced_ids = new CommandAttr<string>()
		}
		
		this.constraint_referenced_ids.setGetter(true);
		this.orderGet++;
		this.constraint_referenced_ids.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getConstraint_referenced_ids() : string {
		if (this.constraint_referenced_ids == null || this.constraint_referenced_ids == undefined) {
			this.constraint_referenced_ids = new CommandAttr<string>();
		}
		return this.constraint_referenced_ids.getCommandReturnValue();
	}
	public setConstraint_referenced_ids(value : string) : T {
		this.resetIfRequired();
		if (this.constraint_referenced_ids == null || this.constraint_referenced_ids == undefined) {
			this.constraint_referenced_ids = new CommandAttr<string>();
		}
		
		this.constraint_referenced_ids.setSetter(true);
		this.constraint_referenced_ids.setValue(value);
		this.orderSet++;
		this.constraint_referenced_ids.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
//start - staticinit

export class Group extends GroupImpl<Group> implements IWidget{
    getThisPointer(): Group {
        return this;
    }
    
   	public getClass() {
		return Group;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

GroupImpl.initialize();

//end - staticinit
