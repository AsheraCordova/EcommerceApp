// start - imports

export const enum IndeterminateTintMode {
add = "add",
multiply = "multiply",
screen = "screen",
src_atop = "src_atop",
src_in = "src_in",
src_over = "src_over",
}
export const enum BackgroundTintMode {
add = "add",
multiply = "multiply",
screen = "screen",
src_atop = "src_atop",
src_in = "src_in",
src_over = "src_over",
}
export const enum ProgressTintMode {
add = "add",
multiply = "multiply",
screen = "screen",
src_atop = "src_atop",
src_in = "src_in",
src_over = "src_over",
}
export const enum SecondaryProgressTintMode {
add = "add",
multiply = "multiply",
screen = "screen",
src_atop = "src_atop",
src_in = "src_in",
src_over = "src_over",
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
export abstract class ProgressBarImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "indeterminate" })
	indeterminate!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "indeterminateDrawable" })
	indeterminateDrawable!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "indeterminateTint" })
	indeterminateTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "indeterminateTintMode" })
	indeterminateTintMode!:CommandAttr<IndeterminateTintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "max" })
	max!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "min" })
	min!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "progress" })
	progress!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "progressBackgroundTint" })
	progressBackgroundTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "progressBackgroundTintMode" })
	progressBackgroundTintMode!:CommandAttr<BackgroundTintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "progressDrawable" })
	progressDrawable!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "progressTint" })
	progressTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "progressTintMode" })
	progressTintMode!:CommandAttr<ProgressTintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "secondaryProgress" })
	secondaryProgress!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "secondaryProgressTint" })
	secondaryProgressTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "secondaryProgressTintMode" })
	secondaryProgressTintMode!:CommandAttr<SecondaryProgressTintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "incrementProgressBy" })
	incrementProgressBy_!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "incrementSecondaryProgressBy" })
	incrementSecondaryProgressBy_!:CommandAttr<number>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.indeterminate = undefined;
		this.indeterminateDrawable = undefined;
		this.indeterminateTint = undefined;
		this.indeterminateTintMode = undefined;
		this.max = undefined;
		this.min = undefined;
		this.progress = undefined;
		this.progressBackgroundTint = undefined;
		this.progressBackgroundTintMode = undefined;
		this.progressDrawable = undefined;
		this.progressTint = undefined;
		this.progressTintMode = undefined;
		this.secondaryProgress = undefined;
		this.secondaryProgressTint = undefined;
		this.secondaryProgressTintMode = undefined;
		this.incrementProgressBy_ = undefined;
		this.incrementSecondaryProgressBy_ = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setIndeterminate(value : boolean) : T {
		this.resetIfRequired();
		if (this.indeterminate == null || this.indeterminate == undefined) {
			this.indeterminate = new CommandAttr<boolean>();
		}
		
		this.indeterminate.setSetter(true);
		this.indeterminate.setValue(value);
		this.orderSet++;
		this.indeterminate.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setIndeterminateDrawable(value : string) : T {
		this.resetIfRequired();
		if (this.indeterminateDrawable == null || this.indeterminateDrawable == undefined) {
			this.indeterminateDrawable = new CommandAttr<string>();
		}
		
		this.indeterminateDrawable.setSetter(true);
		this.indeterminateDrawable.setValue(value);
		this.orderSet++;
		this.indeterminateDrawable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIndeterminateTint() : T {
		this.resetIfRequired();
		if (this.indeterminateTint == null || this.indeterminateTint == undefined) {
			this.indeterminateTint = new CommandAttr<string>()
		}
		
		this.indeterminateTint.setGetter(true);
		this.orderGet++;
		this.indeterminateTint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIndeterminateTint() : string {
		if (this.indeterminateTint == null || this.indeterminateTint == undefined) {
			this.indeterminateTint = new CommandAttr<string>();
		}
		return this.indeterminateTint.getCommandReturnValue();
	}
	public setIndeterminateTint(value : string) : T {
		this.resetIfRequired();
		if (this.indeterminateTint == null || this.indeterminateTint == undefined) {
			this.indeterminateTint = new CommandAttr<string>();
		}
		
		this.indeterminateTint.setSetter(true);
		this.indeterminateTint.setValue(value);
		this.orderSet++;
		this.indeterminateTint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIndeterminateTintMode() : T {
		this.resetIfRequired();
		if (this.indeterminateTintMode == null || this.indeterminateTintMode == undefined) {
			this.indeterminateTintMode = new CommandAttr<IndeterminateTintMode>()
		}
		
		this.indeterminateTintMode.setGetter(true);
		this.orderGet++;
		this.indeterminateTintMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIndeterminateTintMode() : IndeterminateTintMode {
		if (this.indeterminateTintMode == null || this.indeterminateTintMode == undefined) {
			this.indeterminateTintMode = new CommandAttr<IndeterminateTintMode>();
		}
		return this.indeterminateTintMode.getCommandReturnValue();
	}
	public setIndeterminateTintMode(value : IndeterminateTintMode) : T {
		this.resetIfRequired();
		if (this.indeterminateTintMode == null || this.indeterminateTintMode == undefined) {
			this.indeterminateTintMode = new CommandAttr<IndeterminateTintMode>();
		}
		
		this.indeterminateTintMode.setSetter(true);
		this.indeterminateTintMode.setValue(value);
		this.orderSet++;
		this.indeterminateTintMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setMax(value : number) : T {
		this.resetIfRequired();
		if (this.max == null || this.max == undefined) {
			this.max = new CommandAttr<number>();
		}
		
		this.max.setSetter(true);
		this.max.setValue(value);
		this.orderSet++;
		this.max.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setMin(value : number) : T {
		this.resetIfRequired();
		if (this.min == null || this.min == undefined) {
			this.min = new CommandAttr<number>();
		}
		
		this.min.setSetter(true);
		this.min.setValue(value);
		this.orderSet++;
		this.min.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setProgress(value : number) : T {
		this.resetIfRequired();
		if (this.progress == null || this.progress == undefined) {
			this.progress = new CommandAttr<number>();
		}
		
		this.progress.setSetter(true);
		this.progress.setValue(value);
		this.orderSet++;
		this.progress.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetProgressBackgroundTint() : T {
		this.resetIfRequired();
		if (this.progressBackgroundTint == null || this.progressBackgroundTint == undefined) {
			this.progressBackgroundTint = new CommandAttr<string>()
		}
		
		this.progressBackgroundTint.setGetter(true);
		this.orderGet++;
		this.progressBackgroundTint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getProgressBackgroundTint() : string {
		if (this.progressBackgroundTint == null || this.progressBackgroundTint == undefined) {
			this.progressBackgroundTint = new CommandAttr<string>();
		}
		return this.progressBackgroundTint.getCommandReturnValue();
	}
	public setProgressBackgroundTint(value : string) : T {
		this.resetIfRequired();
		if (this.progressBackgroundTint == null || this.progressBackgroundTint == undefined) {
			this.progressBackgroundTint = new CommandAttr<string>();
		}
		
		this.progressBackgroundTint.setSetter(true);
		this.progressBackgroundTint.setValue(value);
		this.orderSet++;
		this.progressBackgroundTint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetProgressBackgroundTintMode() : T {
		this.resetIfRequired();
		if (this.progressBackgroundTintMode == null || this.progressBackgroundTintMode == undefined) {
			this.progressBackgroundTintMode = new CommandAttr<BackgroundTintMode>()
		}
		
		this.progressBackgroundTintMode.setGetter(true);
		this.orderGet++;
		this.progressBackgroundTintMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getProgressBackgroundTintMode() : BackgroundTintMode {
		if (this.progressBackgroundTintMode == null || this.progressBackgroundTintMode == undefined) {
			this.progressBackgroundTintMode = new CommandAttr<BackgroundTintMode>();
		}
		return this.progressBackgroundTintMode.getCommandReturnValue();
	}
	public setProgressBackgroundTintMode(value : BackgroundTintMode) : T {
		this.resetIfRequired();
		if (this.progressBackgroundTintMode == null || this.progressBackgroundTintMode == undefined) {
			this.progressBackgroundTintMode = new CommandAttr<BackgroundTintMode>();
		}
		
		this.progressBackgroundTintMode.setSetter(true);
		this.progressBackgroundTintMode.setValue(value);
		this.orderSet++;
		this.progressBackgroundTintMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setProgressDrawable(value : string) : T {
		this.resetIfRequired();
		if (this.progressDrawable == null || this.progressDrawable == undefined) {
			this.progressDrawable = new CommandAttr<string>();
		}
		
		this.progressDrawable.setSetter(true);
		this.progressDrawable.setValue(value);
		this.orderSet++;
		this.progressDrawable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetProgressTint() : T {
		this.resetIfRequired();
		if (this.progressTint == null || this.progressTint == undefined) {
			this.progressTint = new CommandAttr<string>()
		}
		
		this.progressTint.setGetter(true);
		this.orderGet++;
		this.progressTint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getProgressTint() : string {
		if (this.progressTint == null || this.progressTint == undefined) {
			this.progressTint = new CommandAttr<string>();
		}
		return this.progressTint.getCommandReturnValue();
	}
	public setProgressTint(value : string) : T {
		this.resetIfRequired();
		if (this.progressTint == null || this.progressTint == undefined) {
			this.progressTint = new CommandAttr<string>();
		}
		
		this.progressTint.setSetter(true);
		this.progressTint.setValue(value);
		this.orderSet++;
		this.progressTint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetProgressTintMode() : T {
		this.resetIfRequired();
		if (this.progressTintMode == null || this.progressTintMode == undefined) {
			this.progressTintMode = new CommandAttr<ProgressTintMode>()
		}
		
		this.progressTintMode.setGetter(true);
		this.orderGet++;
		this.progressTintMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getProgressTintMode() : ProgressTintMode {
		if (this.progressTintMode == null || this.progressTintMode == undefined) {
			this.progressTintMode = new CommandAttr<ProgressTintMode>();
		}
		return this.progressTintMode.getCommandReturnValue();
	}
	public setProgressTintMode(value : ProgressTintMode) : T {
		this.resetIfRequired();
		if (this.progressTintMode == null || this.progressTintMode == undefined) {
			this.progressTintMode = new CommandAttr<ProgressTintMode>();
		}
		
		this.progressTintMode.setSetter(true);
		this.progressTintMode.setValue(value);
		this.orderSet++;
		this.progressTintMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSecondaryProgress(value : number) : T {
		this.resetIfRequired();
		if (this.secondaryProgress == null || this.secondaryProgress == undefined) {
			this.secondaryProgress = new CommandAttr<number>();
		}
		
		this.secondaryProgress.setSetter(true);
		this.secondaryProgress.setValue(value);
		this.orderSet++;
		this.secondaryProgress.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSecondaryProgressTint() : T {
		this.resetIfRequired();
		if (this.secondaryProgressTint == null || this.secondaryProgressTint == undefined) {
			this.secondaryProgressTint = new CommandAttr<string>()
		}
		
		this.secondaryProgressTint.setGetter(true);
		this.orderGet++;
		this.secondaryProgressTint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSecondaryProgressTint() : string {
		if (this.secondaryProgressTint == null || this.secondaryProgressTint == undefined) {
			this.secondaryProgressTint = new CommandAttr<string>();
		}
		return this.secondaryProgressTint.getCommandReturnValue();
	}
	public setSecondaryProgressTint(value : string) : T {
		this.resetIfRequired();
		if (this.secondaryProgressTint == null || this.secondaryProgressTint == undefined) {
			this.secondaryProgressTint = new CommandAttr<string>();
		}
		
		this.secondaryProgressTint.setSetter(true);
		this.secondaryProgressTint.setValue(value);
		this.orderSet++;
		this.secondaryProgressTint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSecondaryProgressTintMode() : T {
		this.resetIfRequired();
		if (this.secondaryProgressTintMode == null || this.secondaryProgressTintMode == undefined) {
			this.secondaryProgressTintMode = new CommandAttr<SecondaryProgressTintMode>()
		}
		
		this.secondaryProgressTintMode.setGetter(true);
		this.orderGet++;
		this.secondaryProgressTintMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSecondaryProgressTintMode() : SecondaryProgressTintMode {
		if (this.secondaryProgressTintMode == null || this.secondaryProgressTintMode == undefined) {
			this.secondaryProgressTintMode = new CommandAttr<SecondaryProgressTintMode>();
		}
		return this.secondaryProgressTintMode.getCommandReturnValue();
	}
	public setSecondaryProgressTintMode(value : SecondaryProgressTintMode) : T {
		this.resetIfRequired();
		if (this.secondaryProgressTintMode == null || this.secondaryProgressTintMode == undefined) {
			this.secondaryProgressTintMode = new CommandAttr<SecondaryProgressTintMode>();
		}
		
		this.secondaryProgressTintMode.setSetter(true);
		this.secondaryProgressTintMode.setValue(value);
		this.orderSet++;
		this.secondaryProgressTintMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public incrementProgressBy(value : number) : T {
		this.resetIfRequired();
		if (this.incrementProgressBy_ == null || this.incrementProgressBy_ == undefined) {
			this.incrementProgressBy_ = new CommandAttr<number>();
		}
		
		this.incrementProgressBy_.setSetter(true);
		this.incrementProgressBy_.setValue(value);
		this.orderSet++;
		this.incrementProgressBy_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public incrementSecondaryProgressBy(value : number) : T {
		this.resetIfRequired();
		if (this.incrementSecondaryProgressBy_ == null || this.incrementSecondaryProgressBy_ == undefined) {
			this.incrementSecondaryProgressBy_ = new CommandAttr<number>();
		}
		
		this.incrementSecondaryProgressBy_.setSetter(true);
		this.incrementSecondaryProgressBy_.setValue(value);
		this.orderSet++;
		this.incrementSecondaryProgressBy_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class ProgressBar extends ProgressBarImpl<ProgressBar> implements IWidget{
    getThisPointer(): ProgressBar {
        return this;
    }
    
   	public getClass() {
		return ProgressBar;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ProgressBarImpl.initialize();

//end - staticinit
