// start - imports

export const enum Placeholder_emptyVisibility {
visible = "visible",
invisible = "invisible",
gone = "gone",
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
import {ViewImpl} from './ViewImpl';
export abstract class PlaceholderImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "placeholder_emptyVisibility" })
	placeholder_emptyVisibility!:CommandAttr<Placeholder_emptyVisibility>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "content" })
	content!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.placeholder_emptyVisibility = undefined;
		this.content = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetPlaceholder_emptyVisibility() : T {
		this.resetIfRequired();
		if (this.placeholder_emptyVisibility == null || this.placeholder_emptyVisibility == undefined) {
			this.placeholder_emptyVisibility = new CommandAttr<Placeholder_emptyVisibility>()
		}
		
		this.placeholder_emptyVisibility.setGetter(true);
		this.orderGet++;
		this.placeholder_emptyVisibility.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getPlaceholder_emptyVisibility() : Placeholder_emptyVisibility {
		if (this.placeholder_emptyVisibility == null || this.placeholder_emptyVisibility == undefined) {
			this.placeholder_emptyVisibility = new CommandAttr<Placeholder_emptyVisibility>();
		}
		return this.placeholder_emptyVisibility.getCommandReturnValue();
	}
	public setPlaceholder_emptyVisibility(value : Placeholder_emptyVisibility) : T {
		this.resetIfRequired();
		if (this.placeholder_emptyVisibility == null || this.placeholder_emptyVisibility == undefined) {
			this.placeholder_emptyVisibility = new CommandAttr<Placeholder_emptyVisibility>();
		}
		
		this.placeholder_emptyVisibility.setSetter(true);
		this.placeholder_emptyVisibility.setValue(value);
		this.orderSet++;
		this.placeholder_emptyVisibility.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetContent() : T {
		this.resetIfRequired();
		if (this.content == null || this.content == undefined) {
			this.content = new CommandAttr<string>()
		}
		
		this.content.setGetter(true);
		this.orderGet++;
		this.content.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getContent() : string {
		if (this.content == null || this.content == undefined) {
			this.content = new CommandAttr<string>();
		}
		return this.content.getCommandReturnValue();
	}
	public setContent(value : string) : T {
		this.resetIfRequired();
		if (this.content == null || this.content == undefined) {
			this.content = new CommandAttr<string>();
		}
		
		this.content.setSetter(true);
		this.content.setValue(value);
		this.orderSet++;
		this.content.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class Placeholder extends PlaceholderImpl<Placeholder> implements IWidget{
    getThisPointer(): Placeholder {
        return this;
    }
    
   	public getClass() {
		return Placeholder;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

PlaceholderImpl.initialize();

//end - staticinit
