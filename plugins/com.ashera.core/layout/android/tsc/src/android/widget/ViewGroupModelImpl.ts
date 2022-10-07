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
export abstract class ViewGroupModelImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "addModel" })
	addModel_!:CommandAttr<any>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "addAllModel" })
	addAllModel_!:CommandAttr<any>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "addModelByIndex" })
	addModelByIndex_!:CommandAttr<any>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "removeModelAtIndex" })
	removeModelAtIndex_!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "removeModelById" })
	removeModelById_!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelFor" })
	modelFor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelIdPath" })
	modelIdPath!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.addModel_ = undefined;
		this.addAllModel_ = undefined;
		this.addModelByIndex_ = undefined;
		this.removeModelAtIndex_ = undefined;
		this.removeModelById_ = undefined;
		this.modelFor = undefined;
		this.modelIdPath = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public addModel(value : any) : T {
		this.resetIfRequired();
		if (this.addModel_ == null || this.addModel_ == undefined) {
			this.addModel_ = new CommandAttr<any>();
		}
		
		this.addModel_.setSetter(true);
		this.addModel_.setValue(value);
		this.orderSet++;
		this.addModel_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public addAllModel(value : any) : T {
		this.resetIfRequired();
		if (this.addAllModel_ == null || this.addAllModel_ == undefined) {
			this.addAllModel_ = new CommandAttr<any>();
		}
		
		this.addAllModel_.setSetter(true);
		this.addAllModel_.setValue(value);
		this.orderSet++;
		this.addAllModel_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public addModelByIndex(value : any,index:number) : T {
		this.resetIfRequired();
		if (this.addModelByIndex_ == null || this.addModelByIndex_ == undefined) {
			this.addModelByIndex_ = new CommandAttr<any>();
		}
		
		let wrapper:any = {};
		wrapper["index"] = index;
		wrapper["data"] = value;
		this.addModelByIndex_.setSetter(true);
		this.addModelByIndex_.setValue(wrapper);	
		this.orderSet++;
		this.addModelByIndex_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public removeModelAtIndex(value : number) : T {
		this.resetIfRequired();
		if (this.removeModelAtIndex_ == null || this.removeModelAtIndex_ == undefined) {
			this.removeModelAtIndex_ = new CommandAttr<number>();
		}
		
		this.removeModelAtIndex_.setSetter(true);
		this.removeModelAtIndex_.setValue(value);
		this.orderSet++;
		this.removeModelAtIndex_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public removeModelById(value : string) : T {
		this.resetIfRequired();
		if (this.removeModelById_ == null || this.removeModelById_ == undefined) {
			this.removeModelById_ = new CommandAttr<string>();
		}
		
		this.removeModelById_.setSetter(true);
		this.removeModelById_.setValue(value);
		this.orderSet++;
		this.removeModelById_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setModelFor(value : string) : T {
		this.resetIfRequired();
		if (this.modelFor == null || this.modelFor == undefined) {
			this.modelFor = new CommandAttr<string>();
		}
		
		this.modelFor.setSetter(true);
		this.modelFor.setValue(value);
		this.orderSet++;
		this.modelFor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetModelIdPath() : T {
		this.resetIfRequired();
		if (this.modelIdPath == null || this.modelIdPath == undefined) {
			this.modelIdPath = new CommandAttr<string>()
		}
		
		this.modelIdPath.setGetter(true);
		this.orderGet++;
		this.modelIdPath.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getModelIdPath() : string {
		if (this.modelIdPath == null || this.modelIdPath == undefined) {
			this.modelIdPath = new CommandAttr<string>();
		}
		return this.modelIdPath.getCommandReturnValue();
	}
	public setModelIdPath(value : string) : T {
		this.resetIfRequired();
		if (this.modelIdPath == null || this.modelIdPath == undefined) {
			this.modelIdPath = new CommandAttr<string>();
		}
		
		this.modelIdPath.setSetter(true);
		this.modelIdPath.setValue(value);
		this.orderSet++;
		this.modelIdPath.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class ViewGroupModel extends ViewGroupModelImpl<ViewGroupModel> implements IWidget{
    getThisPointer(): ViewGroupModel {
        return this;
    }
    
   	public getClass() {
		return ViewGroupModel;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ViewGroupModelImpl.initialize();

//end - staticinit
