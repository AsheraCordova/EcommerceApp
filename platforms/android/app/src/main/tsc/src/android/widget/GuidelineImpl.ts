// start - imports

export const enum Orientation {
horizontal = "horizontal",
vertical = "vertical",
}	
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
export abstract class GuidelineImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "orientation" })
	orientation!:CommandAttr<Orientation>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.orientation = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetOrientation() : T {
		this.resetIfRequired();
		if (this.orientation == null || this.orientation == undefined) {
			this.orientation = new CommandAttr<Orientation>()
		}
		
		this.orientation.setGetter(true);
		this.orderGet++;
		this.orientation.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getOrientation() : Orientation {
		if (this.orientation == null || this.orientation == undefined) {
			this.orientation = new CommandAttr<Orientation>();
		}
		return this.orientation.getCommandReturnValue();
	}
	public setOrientation(value : Orientation) : T {
		this.resetIfRequired();
		if (this.orientation == null || this.orientation == undefined) {
			this.orientation = new CommandAttr<Orientation>();
		}
		
		this.orientation.setSetter(true);
		this.orientation.setValue(value);
		this.orderSet++;
		this.orientation.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
//start - staticinit

export class Guideline extends GuidelineImpl<Guideline> implements IWidget{
    getThisPointer(): Guideline {
        return this;
    }
    
   	public getClass() {
		return Guideline;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

GuidelineImpl.initialize();

//end - staticinit
