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
export abstract class CapInsetsViewImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundCapInsets" })
	backgroundCapInsets!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundCapInsetsTop" })
	backgroundCapInsetsTop!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundCapInsetsBottom" })
	backgroundCapInsetsBottom!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundCapInsetsLeft" })
	backgroundCapInsetsLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundCapInsetsRight" })
	backgroundCapInsetsRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundCapInsets" })
	foregroundCapInsets!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundCapInsetsTop" })
	foregroundCapInsetsTop!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundCapInsetsBottom" })
	foregroundCapInsetsBottom!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundCapInsetsLeft" })
	foregroundCapInsetsLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundCapInsetsRight" })
	foregroundCapInsetsRight!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.backgroundCapInsets = undefined;
		this.backgroundCapInsetsTop = undefined;
		this.backgroundCapInsetsBottom = undefined;
		this.backgroundCapInsetsLeft = undefined;
		this.backgroundCapInsetsRight = undefined;
		this.foregroundCapInsets = undefined;
		this.foregroundCapInsetsTop = undefined;
		this.foregroundCapInsetsBottom = undefined;
		this.foregroundCapInsetsLeft = undefined;
		this.foregroundCapInsetsRight = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setBackgroundCapInsets(value : string) : T {
		this.resetIfRequired();
		if (this.backgroundCapInsets == null || this.backgroundCapInsets == undefined) {
			this.backgroundCapInsets = new CommandAttr<string>();
		}
		
		this.backgroundCapInsets.setSetter(true);
		this.backgroundCapInsets.setValue(value);
		this.orderSet++;
		this.backgroundCapInsets.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBackgroundCapInsetsTop(value : string) : T {
		this.resetIfRequired();
		if (this.backgroundCapInsetsTop == null || this.backgroundCapInsetsTop == undefined) {
			this.backgroundCapInsetsTop = new CommandAttr<string>();
		}
		
		this.backgroundCapInsetsTop.setSetter(true);
		this.backgroundCapInsetsTop.setValue(value);
		this.orderSet++;
		this.backgroundCapInsetsTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBackgroundCapInsetsBottom(value : string) : T {
		this.resetIfRequired();
		if (this.backgroundCapInsetsBottom == null || this.backgroundCapInsetsBottom == undefined) {
			this.backgroundCapInsetsBottom = new CommandAttr<string>();
		}
		
		this.backgroundCapInsetsBottom.setSetter(true);
		this.backgroundCapInsetsBottom.setValue(value);
		this.orderSet++;
		this.backgroundCapInsetsBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBackgroundCapInsetsLeft(value : string) : T {
		this.resetIfRequired();
		if (this.backgroundCapInsetsLeft == null || this.backgroundCapInsetsLeft == undefined) {
			this.backgroundCapInsetsLeft = new CommandAttr<string>();
		}
		
		this.backgroundCapInsetsLeft.setSetter(true);
		this.backgroundCapInsetsLeft.setValue(value);
		this.orderSet++;
		this.backgroundCapInsetsLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBackgroundCapInsetsRight(value : string) : T {
		this.resetIfRequired();
		if (this.backgroundCapInsetsRight == null || this.backgroundCapInsetsRight == undefined) {
			this.backgroundCapInsetsRight = new CommandAttr<string>();
		}
		
		this.backgroundCapInsetsRight.setSetter(true);
		this.backgroundCapInsetsRight.setValue(value);
		this.orderSet++;
		this.backgroundCapInsetsRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setForegroundCapInsets(value : string) : T {
		this.resetIfRequired();
		if (this.foregroundCapInsets == null || this.foregroundCapInsets == undefined) {
			this.foregroundCapInsets = new CommandAttr<string>();
		}
		
		this.foregroundCapInsets.setSetter(true);
		this.foregroundCapInsets.setValue(value);
		this.orderSet++;
		this.foregroundCapInsets.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setForegroundCapInsetsTop(value : string) : T {
		this.resetIfRequired();
		if (this.foregroundCapInsetsTop == null || this.foregroundCapInsetsTop == undefined) {
			this.foregroundCapInsetsTop = new CommandAttr<string>();
		}
		
		this.foregroundCapInsetsTop.setSetter(true);
		this.foregroundCapInsetsTop.setValue(value);
		this.orderSet++;
		this.foregroundCapInsetsTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setForegroundCapInsetsBottom(value : string) : T {
		this.resetIfRequired();
		if (this.foregroundCapInsetsBottom == null || this.foregroundCapInsetsBottom == undefined) {
			this.foregroundCapInsetsBottom = new CommandAttr<string>();
		}
		
		this.foregroundCapInsetsBottom.setSetter(true);
		this.foregroundCapInsetsBottom.setValue(value);
		this.orderSet++;
		this.foregroundCapInsetsBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setForegroundCapInsetsLeft(value : string) : T {
		this.resetIfRequired();
		if (this.foregroundCapInsetsLeft == null || this.foregroundCapInsetsLeft == undefined) {
			this.foregroundCapInsetsLeft = new CommandAttr<string>();
		}
		
		this.foregroundCapInsetsLeft.setSetter(true);
		this.foregroundCapInsetsLeft.setValue(value);
		this.orderSet++;
		this.foregroundCapInsetsLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setForegroundCapInsetsRight(value : string) : T {
		this.resetIfRequired();
		if (this.foregroundCapInsetsRight == null || this.foregroundCapInsetsRight == undefined) {
			this.foregroundCapInsetsRight = new CommandAttr<string>();
		}
		
		this.foregroundCapInsetsRight.setSetter(true);
		this.foregroundCapInsetsRight.setValue(value);
		this.orderSet++;
		this.foregroundCapInsetsRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class CapInsetsView extends CapInsetsViewImpl<CapInsetsView> implements IWidget{
    getThisPointer(): CapInsetsView {
        return this;
    }
    
   	public getClass() {
		return CapInsetsView;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

CapInsetsViewImpl.initialize();

//end - staticinit
