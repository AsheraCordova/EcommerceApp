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
export abstract class TableRowImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "gravity" })
	gravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "weightSum" })
	weightSum!:CommandAttr<number>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.gravity = undefined;
		this.weightSum = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetGravity() : T {
		this.resetIfRequired();
		if (this.gravity == null || this.gravity == undefined) {
			this.gravity = new CommandAttr<Gravity[]>()
		}
		
		this.gravity.setGetter(true);
		this.orderGet++;
		this.gravity.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getGravity() : Gravity[] {
		if (this.gravity == null || this.gravity == undefined) {
			this.gravity = new CommandAttr<Gravity[]>();
		}
this.gravity.setTransformer('gravity');		return this.gravity.getCommandReturnValue();
	}
	public setGravity(...value : Gravity[]) : T {
		this.resetIfRequired();
		if (this.gravity == null || this.gravity == undefined) {
			this.gravity = new CommandAttr<Gravity[]>();
		}
		
		this.gravity.setSetter(true);
		this.gravity.setValue(value);
		this.orderSet++;
		this.gravity.setOrderSet(this.orderSet);
this.gravity.setTransformer('gravity');		return this.thisPointer;
	}
		

	public tryGetWeightSum() : T {
		this.resetIfRequired();
		if (this.weightSum == null || this.weightSum == undefined) {
			this.weightSum = new CommandAttr<number>()
		}
		
		this.weightSum.setGetter(true);
		this.orderGet++;
		this.weightSum.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getWeightSum() : number {
		if (this.weightSum == null || this.weightSum == undefined) {
			this.weightSum = new CommandAttr<number>();
		}
		return this.weightSum.getCommandReturnValue();
	}
	public setWeightSum(value : number) : T {
		this.resetIfRequired();
		if (this.weightSum == null || this.weightSum == undefined) {
			this.weightSum = new CommandAttr<number>();
		}
		
		this.weightSum.setSetter(true);
		this.weightSum.setValue(value);
		this.orderSet++;
		this.weightSum.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
//start - staticinit
export abstract class TableRowImpl_LayoutParams<T> extends ViewGroupImpl_LayoutParams<T> {
	@Type(() => CommandAttr)
	@Expose({ name: "layout_gravity" })
	layout_gravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_weight" })
	layout_weight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_column" })
	layout_column!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_span" })
	layout_span!:CommandAttr<number>| undefined;
	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.layout_gravity = undefined;
		this.layout_weight = undefined;
		this.layout_column = undefined;
		this.layout_span = undefined;
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
	public tryGetLayoutWeight() : T {
		if (this.layout_weight == null || this.layout_weight == undefined) {
			this.layout_weight = new CommandAttr<number>()
		}
		
		this.layout_weight.setGetter(true);
		this.orderGet++;
		this.layout_weight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutWeight() : number {
		if (this.layout_weight == null || this.layout_weight == undefined) {
			this.layout_weight = new CommandAttr<number>();
		}
		return this.layout_weight.getCommandReturnValue();
	}
	public setLayoutWeight(value : number) : T {
		if (this.layout_weight == null || this.layout_weight == undefined) {
			this.layout_weight = new CommandAttr<number>();
		}
		this.layout_weight.setSetter(true);
		this.layout_weight.setValue(value);
		this.orderSet++;
		this.layout_weight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutColumn() : T {
		if (this.layout_column == null || this.layout_column == undefined) {
			this.layout_column = new CommandAttr<number>()
		}
		
		this.layout_column.setGetter(true);
		this.orderGet++;
		this.layout_column.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutColumn() : number {
		if (this.layout_column == null || this.layout_column == undefined) {
			this.layout_column = new CommandAttr<number>();
		}
		return this.layout_column.getCommandReturnValue();
	}
	public setLayoutColumn(value : number) : T {
		if (this.layout_column == null || this.layout_column == undefined) {
			this.layout_column = new CommandAttr<number>();
		}
		this.layout_column.setSetter(true);
		this.layout_column.setValue(value);
		this.orderSet++;
		this.layout_column.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutSpan() : T {
		if (this.layout_span == null || this.layout_span == undefined) {
			this.layout_span = new CommandAttr<number>()
		}
		
		this.layout_span.setGetter(true);
		this.orderGet++;
		this.layout_span.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutSpan() : number {
		if (this.layout_span == null || this.layout_span == undefined) {
			this.layout_span = new CommandAttr<number>();
		}
		return this.layout_span.getCommandReturnValue();
	}
	public setLayoutSpan(value : number) : T {
		if (this.layout_span == null || this.layout_span == undefined) {
			this.layout_span = new CommandAttr<number>();
		}
		this.layout_span.setSetter(true);
		this.layout_span.setValue(value);
		this.orderSet++;
		this.layout_span.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
}

export class TableRow_LayoutParams extends TableRowImpl_LayoutParams<TableRow_LayoutParams> implements ILayoutParam {
    getThisPointer(): TableRow_LayoutParams {
        return this;
    }

   	constructor() {
		super();	
	}
}

export class TableRow extends TableRowImpl<TableRow> implements IWidget{
    getThisPointer(): TableRow {
        return this;
    }
    
   	public getClass() {
		return TableRow;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

TableRowImpl.initialize();
export interface OnChildViewAddedEvent extends Event{
        //parent:View;

        //child:View;


}
export interface OnChildViewRemovedEvent extends Event{
        //parent:View;

        //child:View;


}

//end - staticinit
