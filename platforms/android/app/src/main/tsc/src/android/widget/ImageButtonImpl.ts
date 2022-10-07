// start - imports

export const enum ScaleType {
center = "center",
centerCrop = "centerCrop",
centerInside = "centerInside",
fitCenter = "fitCenter",
fitEnd = "fitEnd",
fitStart = "fitStart",
fitXY = "fitXY",
matrix = "matrix",
}
export const enum TintMode {
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
export abstract class ImageButtonImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "adjustViewBounds" })
	adjustViewBounds!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "baseline" })
	baseline!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "baselineAlignBottom" })
	baselineAlignBottom!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "cropToPadding" })
	cropToPadding!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxHeight" })
	maxHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxWidth" })
	maxWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scaleType" })
	scaleType!:CommandAttr<ScaleType>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "tint" })
	tint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "tintMode" })
	tintMode!:CommandAttr<TintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "src" })
	src!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "imageFromUrl" })
	imageFromUrl!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "imageFromUrlPlaceHolder" })
	imageFromUrlPlaceHolder!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "imageFromUrlError" })
	imageFromUrlError!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "padding" })
	padding!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingBottom" })
	paddingBottom!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingRight" })
	paddingRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingLeft" })
	paddingLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingStart" })
	paddingStart!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingEnd" })
	paddingEnd!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingTop" })
	paddingTop!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingHorizontal" })
	paddingHorizontal!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingVertical" })
	paddingVertical!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.adjustViewBounds = undefined;
		this.baseline = undefined;
		this.baselineAlignBottom = undefined;
		this.cropToPadding = undefined;
		this.maxHeight = undefined;
		this.maxWidth = undefined;
		this.scaleType = undefined;
		this.tint = undefined;
		this.tintMode = undefined;
		this.src = undefined;
		this.imageFromUrl = undefined;
		this.imageFromUrlPlaceHolder = undefined;
		this.imageFromUrlError = undefined;
		this.padding = undefined;
		this.paddingBottom = undefined;
		this.paddingRight = undefined;
		this.paddingLeft = undefined;
		this.paddingStart = undefined;
		this.paddingEnd = undefined;
		this.paddingTop = undefined;
		this.paddingHorizontal = undefined;
		this.paddingVertical = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetAdjustViewBounds() : T {
		this.resetIfRequired();
		if (this.adjustViewBounds == null || this.adjustViewBounds == undefined) {
			this.adjustViewBounds = new CommandAttr<boolean>()
		}
		
		this.adjustViewBounds.setGetter(true);
		this.orderGet++;
		this.adjustViewBounds.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isAdjustViewBounds() : boolean {
		if (this.adjustViewBounds == null || this.adjustViewBounds == undefined) {
			this.adjustViewBounds = new CommandAttr<boolean>();
		}
		return this.adjustViewBounds.getCommandReturnValue();
	}
	public setAdjustViewBounds(value : boolean) : T {
		this.resetIfRequired();
		if (this.adjustViewBounds == null || this.adjustViewBounds == undefined) {
			this.adjustViewBounds = new CommandAttr<boolean>();
		}
		
		this.adjustViewBounds.setSetter(true);
		this.adjustViewBounds.setValue(value);
		this.orderSet++;
		this.adjustViewBounds.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBaseline() : T {
		this.resetIfRequired();
		if (this.baseline == null || this.baseline == undefined) {
			this.baseline = new CommandAttr<string>()
		}
		
		this.baseline.setGetter(true);
		this.orderGet++;
		this.baseline.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBaseline() : string {
		if (this.baseline == null || this.baseline == undefined) {
			this.baseline = new CommandAttr<string>();
		}
		return this.baseline.getCommandReturnValue();
	}
	public setBaseline(value : string) : T {
		this.resetIfRequired();
		if (this.baseline == null || this.baseline == undefined) {
			this.baseline = new CommandAttr<string>();
		}
		
		this.baseline.setSetter(true);
		this.baseline.setValue(value);
		this.orderSet++;
		this.baseline.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBaselineAlignBottom() : T {
		this.resetIfRequired();
		if (this.baselineAlignBottom == null || this.baselineAlignBottom == undefined) {
			this.baselineAlignBottom = new CommandAttr<boolean>()
		}
		
		this.baselineAlignBottom.setGetter(true);
		this.orderGet++;
		this.baselineAlignBottom.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isBaselineAlignBottom() : boolean {
		if (this.baselineAlignBottom == null || this.baselineAlignBottom == undefined) {
			this.baselineAlignBottom = new CommandAttr<boolean>();
		}
		return this.baselineAlignBottom.getCommandReturnValue();
	}
	public setBaselineAlignBottom(value : boolean) : T {
		this.resetIfRequired();
		if (this.baselineAlignBottom == null || this.baselineAlignBottom == undefined) {
			this.baselineAlignBottom = new CommandAttr<boolean>();
		}
		
		this.baselineAlignBottom.setSetter(true);
		this.baselineAlignBottom.setValue(value);
		this.orderSet++;
		this.baselineAlignBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetCropToPadding() : T {
		this.resetIfRequired();
		if (this.cropToPadding == null || this.cropToPadding == undefined) {
			this.cropToPadding = new CommandAttr<boolean>()
		}
		
		this.cropToPadding.setGetter(true);
		this.orderGet++;
		this.cropToPadding.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isCropToPadding() : boolean {
		if (this.cropToPadding == null || this.cropToPadding == undefined) {
			this.cropToPadding = new CommandAttr<boolean>();
		}
		return this.cropToPadding.getCommandReturnValue();
	}
	public setCropToPadding(value : boolean) : T {
		this.resetIfRequired();
		if (this.cropToPadding == null || this.cropToPadding == undefined) {
			this.cropToPadding = new CommandAttr<boolean>();
		}
		
		this.cropToPadding.setSetter(true);
		this.cropToPadding.setValue(value);
		this.orderSet++;
		this.cropToPadding.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetMaxHeight() : T {
		this.resetIfRequired();
		if (this.maxHeight == null || this.maxHeight == undefined) {
			this.maxHeight = new CommandAttr<string>()
		}
		
		this.maxHeight.setGetter(true);
		this.orderGet++;
		this.maxHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getMaxHeight() : string {
		if (this.maxHeight == null || this.maxHeight == undefined) {
			this.maxHeight = new CommandAttr<string>();
		}
		return this.maxHeight.getCommandReturnValue();
	}
	public setMaxHeight(value : string) : T {
		this.resetIfRequired();
		if (this.maxHeight == null || this.maxHeight == undefined) {
			this.maxHeight = new CommandAttr<string>();
		}
		
		this.maxHeight.setSetter(true);
		this.maxHeight.setValue(value);
		this.orderSet++;
		this.maxHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetMaxWidth() : T {
		this.resetIfRequired();
		if (this.maxWidth == null || this.maxWidth == undefined) {
			this.maxWidth = new CommandAttr<string>()
		}
		
		this.maxWidth.setGetter(true);
		this.orderGet++;
		this.maxWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getMaxWidth() : string {
		if (this.maxWidth == null || this.maxWidth == undefined) {
			this.maxWidth = new CommandAttr<string>();
		}
		return this.maxWidth.getCommandReturnValue();
	}
	public setMaxWidth(value : string) : T {
		this.resetIfRequired();
		if (this.maxWidth == null || this.maxWidth == undefined) {
			this.maxWidth = new CommandAttr<string>();
		}
		
		this.maxWidth.setSetter(true);
		this.maxWidth.setValue(value);
		this.orderSet++;
		this.maxWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScaleType() : T {
		this.resetIfRequired();
		if (this.scaleType == null || this.scaleType == undefined) {
			this.scaleType = new CommandAttr<ScaleType>()
		}
		
		this.scaleType.setGetter(true);
		this.orderGet++;
		this.scaleType.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScaleType() : ScaleType {
		if (this.scaleType == null || this.scaleType == undefined) {
			this.scaleType = new CommandAttr<ScaleType>();
		}
		return this.scaleType.getCommandReturnValue();
	}
	public setScaleType(value : ScaleType) : T {
		this.resetIfRequired();
		if (this.scaleType == null || this.scaleType == undefined) {
			this.scaleType = new CommandAttr<ScaleType>();
		}
		
		this.scaleType.setSetter(true);
		this.scaleType.setValue(value);
		this.orderSet++;
		this.scaleType.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTint() : T {
		this.resetIfRequired();
		if (this.tint == null || this.tint == undefined) {
			this.tint = new CommandAttr<string>()
		}
		
		this.tint.setGetter(true);
		this.orderGet++;
		this.tint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTint() : string {
		if (this.tint == null || this.tint == undefined) {
			this.tint = new CommandAttr<string>();
		}
		return this.tint.getCommandReturnValue();
	}
	public setTint(value : string) : T {
		this.resetIfRequired();
		if (this.tint == null || this.tint == undefined) {
			this.tint = new CommandAttr<string>();
		}
		
		this.tint.setSetter(true);
		this.tint.setValue(value);
		this.orderSet++;
		this.tint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTintMode() : T {
		this.resetIfRequired();
		if (this.tintMode == null || this.tintMode == undefined) {
			this.tintMode = new CommandAttr<TintMode>()
		}
		
		this.tintMode.setGetter(true);
		this.orderGet++;
		this.tintMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTintMode() : TintMode {
		if (this.tintMode == null || this.tintMode == undefined) {
			this.tintMode = new CommandAttr<TintMode>();
		}
		return this.tintMode.getCommandReturnValue();
	}
	public setTintMode(value : TintMode) : T {
		this.resetIfRequired();
		if (this.tintMode == null || this.tintMode == undefined) {
			this.tintMode = new CommandAttr<TintMode>();
		}
		
		this.tintMode.setSetter(true);
		this.tintMode.setValue(value);
		this.orderSet++;
		this.tintMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSrc() : T {
		this.resetIfRequired();
		if (this.src == null || this.src == undefined) {
			this.src = new CommandAttr<string>()
		}
		
		this.src.setGetter(true);
		this.orderGet++;
		this.src.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSrc() : string {
		if (this.src == null || this.src == undefined) {
			this.src = new CommandAttr<string>();
		}
		return this.src.getCommandReturnValue();
	}
	public setSrc(value : string) : T {
		this.resetIfRequired();
		if (this.src == null || this.src == undefined) {
			this.src = new CommandAttr<string>();
		}
		
		this.src.setSetter(true);
		this.src.setValue(value);
		this.orderSet++;
		this.src.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setImageFromUrl(value : string) : T {
		this.resetIfRequired();
		if (this.imageFromUrl == null || this.imageFromUrl == undefined) {
			this.imageFromUrl = new CommandAttr<string>();
		}
		
		this.imageFromUrl.setSetter(true);
		this.imageFromUrl.setValue(value);
		this.orderSet++;
		this.imageFromUrl.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setImageFromUrlPlaceHolder(value : string) : T {
		this.resetIfRequired();
		if (this.imageFromUrlPlaceHolder == null || this.imageFromUrlPlaceHolder == undefined) {
			this.imageFromUrlPlaceHolder = new CommandAttr<string>();
		}
		
		this.imageFromUrlPlaceHolder.setSetter(true);
		this.imageFromUrlPlaceHolder.setValue(value);
		this.orderSet++;
		this.imageFromUrlPlaceHolder.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setImageFromUrlError(value : string) : T {
		this.resetIfRequired();
		if (this.imageFromUrlError == null || this.imageFromUrlError == undefined) {
			this.imageFromUrlError = new CommandAttr<string>();
		}
		
		this.imageFromUrlError.setSetter(true);
		this.imageFromUrlError.setValue(value);
		this.orderSet++;
		this.imageFromUrlError.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setPadding(value : string) : T {
		this.resetIfRequired();
		if (this.padding == null || this.padding == undefined) {
			this.padding = new CommandAttr<string>();
		}
		
		this.padding.setSetter(true);
		this.padding.setValue(value);
		this.orderSet++;
		this.padding.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetPaddingBottom() : T {
		this.resetIfRequired();
		if (this.paddingBottom == null || this.paddingBottom == undefined) {
			this.paddingBottom = new CommandAttr<string>()
		}
		
		this.paddingBottom.setGetter(true);
		this.orderGet++;
		this.paddingBottom.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getPaddingBottom() : string {
		if (this.paddingBottom == null || this.paddingBottom == undefined) {
			this.paddingBottom = new CommandAttr<string>();
		}
		return this.paddingBottom.getCommandReturnValue();
	}
	public setPaddingBottom(value : string) : T {
		this.resetIfRequired();
		if (this.paddingBottom == null || this.paddingBottom == undefined) {
			this.paddingBottom = new CommandAttr<string>();
		}
		
		this.paddingBottom.setSetter(true);
		this.paddingBottom.setValue(value);
		this.orderSet++;
		this.paddingBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetPaddingRight() : T {
		this.resetIfRequired();
		if (this.paddingRight == null || this.paddingRight == undefined) {
			this.paddingRight = new CommandAttr<string>()
		}
		
		this.paddingRight.setGetter(true);
		this.orderGet++;
		this.paddingRight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getPaddingRight() : string {
		if (this.paddingRight == null || this.paddingRight == undefined) {
			this.paddingRight = new CommandAttr<string>();
		}
		return this.paddingRight.getCommandReturnValue();
	}
	public setPaddingRight(value : string) : T {
		this.resetIfRequired();
		if (this.paddingRight == null || this.paddingRight == undefined) {
			this.paddingRight = new CommandAttr<string>();
		}
		
		this.paddingRight.setSetter(true);
		this.paddingRight.setValue(value);
		this.orderSet++;
		this.paddingRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetPaddingLeft() : T {
		this.resetIfRequired();
		if (this.paddingLeft == null || this.paddingLeft == undefined) {
			this.paddingLeft = new CommandAttr<string>()
		}
		
		this.paddingLeft.setGetter(true);
		this.orderGet++;
		this.paddingLeft.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getPaddingLeft() : string {
		if (this.paddingLeft == null || this.paddingLeft == undefined) {
			this.paddingLeft = new CommandAttr<string>();
		}
		return this.paddingLeft.getCommandReturnValue();
	}
	public setPaddingLeft(value : string) : T {
		this.resetIfRequired();
		if (this.paddingLeft == null || this.paddingLeft == undefined) {
			this.paddingLeft = new CommandAttr<string>();
		}
		
		this.paddingLeft.setSetter(true);
		this.paddingLeft.setValue(value);
		this.orderSet++;
		this.paddingLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetPaddingStart() : T {
		this.resetIfRequired();
		if (this.paddingStart == null || this.paddingStart == undefined) {
			this.paddingStart = new CommandAttr<string>()
		}
		
		this.paddingStart.setGetter(true);
		this.orderGet++;
		this.paddingStart.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getPaddingStart() : string {
		if (this.paddingStart == null || this.paddingStart == undefined) {
			this.paddingStart = new CommandAttr<string>();
		}
		return this.paddingStart.getCommandReturnValue();
	}
	public setPaddingStart(value : string) : T {
		this.resetIfRequired();
		if (this.paddingStart == null || this.paddingStart == undefined) {
			this.paddingStart = new CommandAttr<string>();
		}
		
		this.paddingStart.setSetter(true);
		this.paddingStart.setValue(value);
		this.orderSet++;
		this.paddingStart.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetPaddingEnd() : T {
		this.resetIfRequired();
		if (this.paddingEnd == null || this.paddingEnd == undefined) {
			this.paddingEnd = new CommandAttr<string>()
		}
		
		this.paddingEnd.setGetter(true);
		this.orderGet++;
		this.paddingEnd.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getPaddingEnd() : string {
		if (this.paddingEnd == null || this.paddingEnd == undefined) {
			this.paddingEnd = new CommandAttr<string>();
		}
		return this.paddingEnd.getCommandReturnValue();
	}
	public setPaddingEnd(value : string) : T {
		this.resetIfRequired();
		if (this.paddingEnd == null || this.paddingEnd == undefined) {
			this.paddingEnd = new CommandAttr<string>();
		}
		
		this.paddingEnd.setSetter(true);
		this.paddingEnd.setValue(value);
		this.orderSet++;
		this.paddingEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetPaddingTop() : T {
		this.resetIfRequired();
		if (this.paddingTop == null || this.paddingTop == undefined) {
			this.paddingTop = new CommandAttr<string>()
		}
		
		this.paddingTop.setGetter(true);
		this.orderGet++;
		this.paddingTop.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getPaddingTop() : string {
		if (this.paddingTop == null || this.paddingTop == undefined) {
			this.paddingTop = new CommandAttr<string>();
		}
		return this.paddingTop.getCommandReturnValue();
	}
	public setPaddingTop(value : string) : T {
		this.resetIfRequired();
		if (this.paddingTop == null || this.paddingTop == undefined) {
			this.paddingTop = new CommandAttr<string>();
		}
		
		this.paddingTop.setSetter(true);
		this.paddingTop.setValue(value);
		this.orderSet++;
		this.paddingTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setPaddingHorizontal(value : string) : T {
		this.resetIfRequired();
		if (this.paddingHorizontal == null || this.paddingHorizontal == undefined) {
			this.paddingHorizontal = new CommandAttr<string>();
		}
		
		this.paddingHorizontal.setSetter(true);
		this.paddingHorizontal.setValue(value);
		this.orderSet++;
		this.paddingHorizontal.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setPaddingVertical(value : string) : T {
		this.resetIfRequired();
		if (this.paddingVertical == null || this.paddingVertical == undefined) {
			this.paddingVertical = new CommandAttr<string>();
		}
		
		this.paddingVertical.setSetter(true);
		this.paddingVertical.setValue(value);
		this.orderSet++;
		this.paddingVertical.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
//start - staticinit

export class ImageButton extends ImageButtonImpl<ImageButton> implements IWidget{
    getThisPointer(): ImageButton {
        return this;
    }
    
   	public getClass() {
		return ImageButton;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ImageButtonImpl.initialize();

//end - staticinit
