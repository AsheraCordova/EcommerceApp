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



import {ViewGroupImpl_LayoutParams} from './ViewGroupImpl';

// end - imports
import {ViewGroupImpl} from './ViewGroupImpl';
export abstract class IQPreviousNextViewImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "measureAllChildren" })
	measureAllChildren!:CommandAttr<boolean>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.measureAllChildren = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetMeasureAllChildren() : T {
		this.resetIfRequired();
		if (this.measureAllChildren == null || this.measureAllChildren == undefined) {
			this.measureAllChildren = new CommandAttr<boolean>()
		}
		
		this.measureAllChildren.setGetter(true);
		this.orderGet++;
		this.measureAllChildren.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isMeasureAllChildren() : boolean {
		if (this.measureAllChildren == null || this.measureAllChildren == undefined) {
			this.measureAllChildren = new CommandAttr<boolean>();
		}
		return this.measureAllChildren.getCommandReturnValue();
	}
	public setMeasureAllChildren(value : boolean) : T {
		this.resetIfRequired();
		if (this.measureAllChildren == null || this.measureAllChildren == undefined) {
			this.measureAllChildren = new CommandAttr<boolean>();
		}
		
		this.measureAllChildren.setSetter(true);
		this.measureAllChildren.setValue(value);
		this.orderSet++;
		this.measureAllChildren.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit
export abstract class IQPreviousNextViewImpl_LayoutParams<T> extends ViewGroupImpl_LayoutParams<T> {
	@Type(() => CommandAttr)
	@Expose({ name: "layout_gravity" })
	layout_gravity!:CommandAttr<Gravity[]>| undefined;
	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.layout_gravity = undefined;
		return this.thisPointer;
	}
	constructor() {
		super();
		this.thisPointer = this.getThisPointer();
	}
	
	public tryGetLayoutGravity() : T {
		if (this.layout_gravity == null || this.layout_gravity == undefined) {
			this.layout_gravity = new CommandAttr<Gravity[]>()
		}
		
		this.layout_gravity.setGetter(true);
		this.orderGet++;
		this.layout_gravity.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutGravity() : Gravity[] {
		if (this.layout_gravity == null || this.layout_gravity == undefined) {
			this.layout_gravity = new CommandAttr<Gravity[]>();
		}
this.layout_gravity.setTransformer('gravity');		return this.layout_gravity.getCommandReturnValue();
	}
	public setLayoutGravity(...value : Gravity[]) : T {
		if (this.layout_gravity == null || this.layout_gravity == undefined) {
			this.layout_gravity = new CommandAttr<Gravity[]>();
		}
		this.layout_gravity.setSetter(true);
		this.layout_gravity.setValue(value);
		this.orderSet++;
		this.layout_gravity.setOrderSet(this.orderSet);
this.layout_gravity.setTransformer('gravity');		return this.thisPointer;
	}
}

export class IQPreviousNextView_LayoutParams extends IQPreviousNextViewImpl_LayoutParams<IQPreviousNextView_LayoutParams> implements ILayoutParam {
    getThisPointer(): IQPreviousNextView_LayoutParams {
        return this;
    }

   	constructor() {
		super();	
	}
}

export class IQPreviousNextView extends IQPreviousNextViewImpl<IQPreviousNextView> implements IWidget{
    getThisPointer(): IQPreviousNextView {
        return this;
    }
    
   	public getClass() {
		return IQPreviousNextView;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

IQPreviousNextViewImpl.initialize();

//end - staticinit
