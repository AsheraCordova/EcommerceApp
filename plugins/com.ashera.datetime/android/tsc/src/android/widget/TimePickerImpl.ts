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
export abstract class TimePickerImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "timeFormat" })
	timeFormat!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "hint" })
	hint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "text" })
	text!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onTextChange" })
	onTextChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onbeforeTextChange" })
	onbeforeTextChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onafterTextChange" })
	onafterTextChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "showClearButton" })
	showClearButton_!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "hintTextFormat" })
	hintTextFormat!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.timeFormat = undefined;
		this.hint = undefined;
		this.text = undefined;
		this.onTextChange = undefined;
		this.onbeforeTextChange = undefined;
		this.onafterTextChange = undefined;
		this.showClearButton_ = undefined;
		this.hintTextFormat = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setTimeFormat(value : string) : T {
		this.resetIfRequired();
		if (this.timeFormat == null || this.timeFormat == undefined) {
			this.timeFormat = new CommandAttr<string>();
		}
		
		this.timeFormat.setSetter(true);
		this.timeFormat.setValue(value);
		this.orderSet++;
		this.timeFormat.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetHint() : T {
		this.resetIfRequired();
		if (this.hint == null || this.hint == undefined) {
			this.hint = new CommandAttr<string>()
		}
		
		this.hint.setGetter(true);
		this.orderGet++;
		this.hint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getHint() : string {
		if (this.hint == null || this.hint == undefined) {
			this.hint = new CommandAttr<string>();
		}
		return this.hint.getCommandReturnValue();
	}
	public setHint(value : string) : T {
		this.resetIfRequired();
		if (this.hint == null || this.hint == undefined) {
			this.hint = new CommandAttr<string>();
		}
		
		this.hint.setSetter(true);
		this.hint.setValue(value);
		this.orderSet++;
		this.hint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetText() : T {
		this.resetIfRequired();
		if (this.text == null || this.text == undefined) {
			this.text = new CommandAttr<string>()
		}
		
		this.text.setGetter(true);
		this.orderGet++;
		this.text.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getText() : string {
		if (this.text == null || this.text == undefined) {
			this.text = new CommandAttr<string>();
		}
		return this.text.getCommandReturnValue();
	}
	public setText(value : string) : T {
		this.resetIfRequired();
		if (this.text == null || this.text == undefined) {
			this.text = new CommandAttr<string>();
		}
		
		this.text.setSetter(true);
		this.text.setValue(value);
		this.orderSet++;
		this.text.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnTextChange(value : string) : T {
		this.resetIfRequired();
		if (this.onTextChange == null || this.onTextChange == undefined) {
			this.onTextChange = new CommandAttr<string>();
		}
		
		this.onTextChange.setSetter(true);
		this.onTextChange.setValue(value);
		this.orderSet++;
		this.onTextChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnbeforeTextChange(value : string) : T {
		this.resetIfRequired();
		if (this.onbeforeTextChange == null || this.onbeforeTextChange == undefined) {
			this.onbeforeTextChange = new CommandAttr<string>();
		}
		
		this.onbeforeTextChange.setSetter(true);
		this.onbeforeTextChange.setValue(value);
		this.orderSet++;
		this.onbeforeTextChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnafterTextChange(value : string) : T {
		this.resetIfRequired();
		if (this.onafterTextChange == null || this.onafterTextChange == undefined) {
			this.onafterTextChange = new CommandAttr<string>();
		}
		
		this.onafterTextChange.setSetter(true);
		this.onafterTextChange.setValue(value);
		this.orderSet++;
		this.onafterTextChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public showClearButton(value : boolean) : T {
		this.resetIfRequired();
		if (this.showClearButton_ == null || this.showClearButton_ == undefined) {
			this.showClearButton_ = new CommandAttr<boolean>();
		}
		
		this.showClearButton_.setSetter(true);
		this.showClearButton_.setValue(value);
		this.orderSet++;
		this.showClearButton_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setHintTextFormat(value : string) : T {
		this.resetIfRequired();
		if (this.hintTextFormat == null || this.hintTextFormat == undefined) {
			this.hintTextFormat = new CommandAttr<string>();
		}
		
		this.hintTextFormat.setSetter(true);
		this.hintTextFormat.setValue(value);
		this.orderSet++;
		this.hintTextFormat.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class TimePicker extends TimePickerImpl<TimePicker> implements IWidget{
    getThisPointer(): TimePicker {
        return this;
    }
    
   	public getClass() {
		return TimePicker;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

TimePickerImpl.initialize();

//end - staticinit
