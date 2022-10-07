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
import {ViewGroupImpl} from './ViewGroupImpl';
export abstract class ViewOnlyImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "attributeUnderTest" })
	attributeUnderTest!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.attributeUnderTest = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setAttributeUnderTest(value : string) : T {
		this.resetIfRequired();
		if (this.attributeUnderTest == null || this.attributeUnderTest == undefined) {
			this.attributeUnderTest = new CommandAttr<string>();
		}
		
		this.attributeUnderTest.setSetter(true);
		this.attributeUnderTest.setValue(value);
		this.orderSet++;
		this.attributeUnderTest.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class ViewOnly extends ViewOnlyImpl<ViewOnly> implements IWidget{
    getThisPointer(): ViewOnly {
        return this;
    }
    
   	public getClass() {
		return ViewOnly;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ViewOnlyImpl.initialize();

//end - staticinit
