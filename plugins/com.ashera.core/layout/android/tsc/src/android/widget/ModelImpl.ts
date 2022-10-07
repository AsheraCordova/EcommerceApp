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
export abstract class ModelImpl<T> extends ViewImpl<T> {
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "param" })
	param!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.param = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetParam() : T {
		this.resetIfRequired();
		if (this.param == null || this.param == undefined) {
			this.param = new CommandAttr<string>()
		}
		
		this.param.setGetter(true);
		this.orderGet++;
		this.param.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getParam() : string {
		if (this.param == null || this.param == undefined) {
			this.param = new CommandAttr<string>();
		}
		return this.param.getCommandReturnValue();
	}
	public setParam(value : string) : T {
		this.resetIfRequired();
		if (this.param == null || this.param == undefined) {
			this.param = new CommandAttr<string>();
		}
		
		this.param.setSetter(true);
		this.param.setValue(value);
		this.orderSet++;
		this.param.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
//start - staticinit

export class Model extends ModelImpl<Model> implements IWidget{
    getThisPointer(): Model {
        return this;
    }
    
   	public getClass() {
		return Model;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ModelImpl.initialize();

//end - staticinit
