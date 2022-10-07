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
export abstract class ScrollViewImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundGravity" })
	foregroundGravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "measureAllChildren" })
	measureAllChildren!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "fillViewport" })
	fillViewport!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollY" })
	scrollY!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onScrollChange" })
	onScrollChange!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.foregroundGravity = undefined;
		this.measureAllChildren = undefined;
		this.fillViewport = undefined;
		this.scrollY = undefined;
		this.onScrollChange = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setForegroundGravity(...value : Gravity[]) : T {
		this.resetIfRequired();
		if (this.foregroundGravity == null || this.foregroundGravity == undefined) {
			this.foregroundGravity = new CommandAttr<Gravity[]>();
		}
		
		this.foregroundGravity.setSetter(true);
		this.foregroundGravity.setValue(value);
		this.orderSet++;
		this.foregroundGravity.setOrderSet(this.orderSet);
this.foregroundGravity.setTransformer('gravity');		return this.thisPointer;
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
		

	public tryGetFillViewport() : T {
		this.resetIfRequired();
		if (this.fillViewport == null || this.fillViewport == undefined) {
			this.fillViewport = new CommandAttr<boolean>()
		}
		
		this.fillViewport.setGetter(true);
		this.orderGet++;
		this.fillViewport.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isFillViewport() : boolean {
		if (this.fillViewport == null || this.fillViewport == undefined) {
			this.fillViewport = new CommandAttr<boolean>();
		}
		return this.fillViewport.getCommandReturnValue();
	}
	public setFillViewport(value : boolean) : T {
		this.resetIfRequired();
		if (this.fillViewport == null || this.fillViewport == undefined) {
			this.fillViewport = new CommandAttr<boolean>();
		}
		
		this.fillViewport.setSetter(true);
		this.fillViewport.setValue(value);
		this.orderSet++;
		this.fillViewport.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScrollY() : T {
		this.resetIfRequired();
		if (this.scrollY == null || this.scrollY == undefined) {
			this.scrollY = new CommandAttr<string>()
		}
		
		this.scrollY.setGetter(true);
		this.orderGet++;
		this.scrollY.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScrollY() : string {
		if (this.scrollY == null || this.scrollY == undefined) {
			this.scrollY = new CommandAttr<string>();
		}
		return this.scrollY.getCommandReturnValue();
	}
	public setScrollY(value : string) : T {
		this.resetIfRequired();
		if (this.scrollY == null || this.scrollY == undefined) {
			this.scrollY = new CommandAttr<string>();
		}
		
		this.scrollY.setSetter(true);
		this.scrollY.setValue(value);
		this.orderSet++;
		this.scrollY.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnScrollChange(value : string) : T {
		this.resetIfRequired();
		if (this.onScrollChange == null || this.onScrollChange == undefined) {
			this.onScrollChange = new CommandAttr<string>();
		}
		
		this.onScrollChange.setSetter(true);
		this.onScrollChange.setValue(value);
		this.orderSet++;
		this.onScrollChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
//start - staticinit
export abstract class ScrollViewImpl_LayoutParams<T> extends ViewGroupImpl_LayoutParams<T> {
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

export class ScrollView_LayoutParams extends ScrollViewImpl_LayoutParams<ScrollView_LayoutParams> implements ILayoutParam {
    getThisPointer(): ScrollView_LayoutParams {
        return this;
    }

   	constructor() {
		super();	
	}
}

export class ScrollView extends ScrollViewImpl<ScrollView> implements IWidget{
    getThisPointer(): ScrollView {
        return this;
    }
    
   	public getClass() {
		return ScrollView;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ScrollViewImpl.initialize();

//end - staticinit
