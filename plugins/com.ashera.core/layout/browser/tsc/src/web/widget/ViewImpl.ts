// start - imports

export const enum Visibility {
gone = "gone",
invisible = "invisible",
visible = "visible",
}
export const enum BackgroundRepeat {
no_repeat = "no-repeat",
repeat = "repeat",
}
export const enum LayoutDirection {
inherit = "inherit",
locale = "locale",
ltr = "ltr",
rtl = "rtl",
}
export const enum TextDirection {
anyRtl = "anyRtl",
firstStrong = "firstStrong",
firstStrongLtr = "firstStrongLtr",
firstStrongRtl = "firstStrongRtl",
inherit = "inherit",
locale = "locale",
ltr = "ltr",
rtl = "rtl",
}
export const enum TextAlignment {
center = "center",
gravity = "gravity",
inherit = "inherit",
textEnd = "textEnd",
textStart = "textStart",
viewEnd = "viewEnd",
viewStart = "viewStart",
}
export const enum Vtype {
email = "email",
time = "time",
date = "date",
url = "url",
tel = "tel",
}
export const enum ValidationErrorDisplay {
popup = "popup",
label = "label",
style = "style",
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





























































export class ValidationErrorDisplayTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<ValidationErrorDisplay> = new Array<ValidationErrorDisplay>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "popup":
						valueArr.push(ValidationErrorDisplay.popup);
                       	break;	
					case "label":
						valueArr.push(ValidationErrorDisplay.label);
                       	break;	
					case "style":
						valueArr.push(ValidationErrorDisplay.style);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}






import {ViewGroup_LayoutParams} from './ViewGroupImpl';
// end - imports
export abstract class ViewImpl<T> {
	//start - body
	static initialize() {
		TransformerFactory.getInstance().register("validationErrorDisplay", new ValidationErrorDisplayTransformer());
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "alpha" })
	alpha!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelSyncEvents" })
	modelSyncEvents!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelParam" })
	modelParam!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelPojoToUi" })
	modelPojoToUi!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelUiToPojo" })
	modelUiToPojo!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelPojoToUiParams" })
	modelPojoToUiParams!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "refreshUiFromModel" })
	refreshUiFromModel_!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelUiToPojoEventIds" })
	modelUiToPojoEventIds!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "updateModelData" })
	updateModelData_!:CommandAttr<ScopedObject|ScopedObject[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "notifyDataSetChanged" })
	notifyDataSetChanged_!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "visibility" })
	visibility!:CommandAttr<Visibility>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "background" })
	background!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundRepeat" })
	backgroundRepeat!:CommandAttr<BackgroundRepeat>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minWidth" })
	minWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minHeight" })
	minHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "invalidate" })
	invalidate_!:CommandAttr<void>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "requestLayout" })
	requestLayout_!:CommandAttr<void>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layoutDirection" })
	layoutDirection!:CommandAttr<LayoutDirection>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textDirection" })
	textDirection!:CommandAttr<TextDirection>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textAlignment" })
	textAlignment!:CommandAttr<TextAlignment>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onClick" })
	onClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onLongClick" })
	onLongClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onTouch" })
	onTouch!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onKey" })
	onKey!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onHover" })
	onHover!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onDrag" })
	onDrag!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "clickable" })
	clickable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "duplicateParentState" })
	duplicateParentState!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "longClickable" })
	longClickable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "asDragSource" })
	asDragSource!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "tooltipText" })
	tooltipText!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "enabled" })
	enabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "attributeUnderTest" })
	attributeUnderTest!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "zIndex" })
	zIndex!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxWidth" })
	maxWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxHeight" })
	maxHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "webTabIndex" })
	webTabIndex!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "webOverflow" })
	webOverflow!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "translationX" })
	translationX!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "translationY" })
	translationY!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "translationZ" })
	translationZ!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "rotation" })
	rotation!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "rotationX" })
	rotationX!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "rotationY" })
	rotationY!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scaleX" })
	scaleX!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scaleY" })
	scaleY!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "selected" })
	selected!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "style" })
	style!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "errorStyle" })
	errorStyle!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "validateForm" })
	validateForm_!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "validation" })
	validation!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "v_required" })
	v_required!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "v_minlength" })
	v_minlength!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "v_maxlength" })
	v_maxlength!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "v_min" })
	v_min!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "v_max" })
	v_max!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "v_pattern" })
	v_pattern!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "v_type" })
	v_type!:CommandAttr<Vtype>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "validationErrorDisplayType" })
	validationErrorDisplayType!:CommandAttr<ValidationErrorDisplay[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "customErrorMessageValues" })
	customErrorMessageValues!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "customErrorMessageKeys" })
	customErrorMessageKeys!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "invalidateOnFrameChange" })
	invalidateOnFrameChange!:CommandAttr<boolean>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	@Exclude()
	protected orderGet: number = 0;
	@Exclude()
    protected orderSet: number = 0;
    protected flush = false;
	public markForReset() {
		this.flush = true;
	}
	public resetIfRequired() {
		if (this.flush) {
			this.reset()
		}
	}
	reset() : T {	
		this.alpha = undefined;
		this.modelSyncEvents = undefined;
		this.modelParam = undefined;
		this.modelPojoToUi = undefined;
		this.modelUiToPojo = undefined;
		this.modelPojoToUiParams = undefined;
		this.refreshUiFromModel_ = undefined;
		this.modelUiToPojoEventIds = undefined;
		this.updateModelData_ = undefined;
		this.notifyDataSetChanged_ = undefined;
		this.visibility = undefined;
		this.background = undefined;
		this.backgroundRepeat = undefined;
		this.minWidth = undefined;
		this.minHeight = undefined;
		this.invalidate_ = undefined;
		this.requestLayout_ = undefined;
		this.layoutDirection = undefined;
		this.textDirection = undefined;
		this.textAlignment = undefined;
		this.onClick = undefined;
		this.onLongClick = undefined;
		this.onTouch = undefined;
		this.onKey = undefined;
		this.onHover = undefined;
		this.onDrag = undefined;
		this.clickable = undefined;
		this.duplicateParentState = undefined;
		this.longClickable = undefined;
		this.asDragSource = undefined;
		this.tooltipText = undefined;
		this.enabled = undefined;
		this.attributeUnderTest = undefined;
		this.zIndex = undefined;
		this.maxWidth = undefined;
		this.maxHeight = undefined;
		this.webTabIndex = undefined;
		this.webOverflow = undefined;
		this.translationX = undefined;
		this.translationY = undefined;
		this.translationZ = undefined;
		this.rotation = undefined;
		this.rotationX = undefined;
		this.rotationY = undefined;
		this.scaleX = undefined;
		this.scaleY = undefined;
		this.selected = undefined;
		this.style = undefined;
		this.errorStyle = undefined;
		this.validateForm_ = undefined;
		this.validation = undefined;
		this.v_required = undefined;
		this.v_minlength = undefined;
		this.v_maxlength = undefined;
		this.v_min = undefined;
		this.v_max = undefined;
		this.v_pattern = undefined;
		this.v_type = undefined;
		this.validationErrorDisplayType = undefined;
		this.customErrorMessageValues = undefined;
		this.customErrorMessageKeys = undefined;
		this.invalidateOnFrameChange = undefined;
		this.orderGet = 0;
		this.orderSet = 0;
		this.flush = false;
		return this.thisPointer;
	}
	id: string;
	paths: string[];
	event: string;
	@Expose({ name: "layoutParams" })
	layoutParams: any;
	constructor(id: string, paths: string[], event: string) {		
		this.id = id;
		this.paths = paths;
		this.event = event;
		this.thisPointer = this.getThisPointer();
		this.layoutParams = undefined;
	}
	
	setLayoutParams<M extends ILayoutParam>(layoutParams: M) {
		this.resetIfRequired();
		this.layoutParams = layoutParams;
	}
	
	getLayoutParams<M extends ILayoutParam>() : M{
		return this.layoutParams;
	}
	

	public tryGetAlpha() : T {
		this.resetIfRequired();
		if (this.alpha == null || this.alpha == undefined) {
			this.alpha = new CommandAttr<number>()
		}
		
		this.alpha.setGetter(true);
		this.orderGet++;
		this.alpha.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getAlpha() : number {
		if (this.alpha == null || this.alpha == undefined) {
			this.alpha = new CommandAttr<number>();
		}
		return this.alpha.getCommandReturnValue();
	}
	public setAlpha(value : number) : T {
		this.resetIfRequired();
		if (this.alpha == null || this.alpha == undefined) {
			this.alpha = new CommandAttr<number>();
		}
		
		this.alpha.setSetter(true);
		this.alpha.setValue(value);
		this.orderSet++;
		this.alpha.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetModelSyncEvents() : T {
		this.resetIfRequired();
		if (this.modelSyncEvents == null || this.modelSyncEvents == undefined) {
			this.modelSyncEvents = new CommandAttr<string>()
		}
		
		this.modelSyncEvents.setGetter(true);
		this.orderGet++;
		this.modelSyncEvents.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getModelSyncEvents() : string {
		if (this.modelSyncEvents == null || this.modelSyncEvents == undefined) {
			this.modelSyncEvents = new CommandAttr<string>();
		}
		return this.modelSyncEvents.getCommandReturnValue();
	}
	public setModelSyncEvents(value : string) : T {
		this.resetIfRequired();
		if (this.modelSyncEvents == null || this.modelSyncEvents == undefined) {
			this.modelSyncEvents = new CommandAttr<string>();
		}
		
		this.modelSyncEvents.setSetter(true);
		this.modelSyncEvents.setValue(value);
		this.orderSet++;
		this.modelSyncEvents.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetModelParam() : T {
		this.resetIfRequired();
		if (this.modelParam == null || this.modelParam == undefined) {
			this.modelParam = new CommandAttr<string>()
		}
		
		this.modelParam.setGetter(true);
		this.orderGet++;
		this.modelParam.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getModelParam() : string {
		if (this.modelParam == null || this.modelParam == undefined) {
			this.modelParam = new CommandAttr<string>();
		}
		return this.modelParam.getCommandReturnValue();
	}
	public setModelParam(value : string) : T {
		this.resetIfRequired();
		if (this.modelParam == null || this.modelParam == undefined) {
			this.modelParam = new CommandAttr<string>();
		}
		
		this.modelParam.setSetter(true);
		this.modelParam.setValue(value);
		this.orderSet++;
		this.modelParam.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetModelPojoToUi() : T {
		this.resetIfRequired();
		if (this.modelPojoToUi == null || this.modelPojoToUi == undefined) {
			this.modelPojoToUi = new CommandAttr<string>()
		}
		
		this.modelPojoToUi.setGetter(true);
		this.orderGet++;
		this.modelPojoToUi.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getModelPojoToUi() : string {
		if (this.modelPojoToUi == null || this.modelPojoToUi == undefined) {
			this.modelPojoToUi = new CommandAttr<string>();
		}
		return this.modelPojoToUi.getCommandReturnValue();
	}
	public setModelPojoToUi(value : string) : T {
		this.resetIfRequired();
		if (this.modelPojoToUi == null || this.modelPojoToUi == undefined) {
			this.modelPojoToUi = new CommandAttr<string>();
		}
		
		this.modelPojoToUi.setSetter(true);
		this.modelPojoToUi.setValue(value);
		this.orderSet++;
		this.modelPojoToUi.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetModelUiToPojo() : T {
		this.resetIfRequired();
		if (this.modelUiToPojo == null || this.modelUiToPojo == undefined) {
			this.modelUiToPojo = new CommandAttr<string>()
		}
		
		this.modelUiToPojo.setGetter(true);
		this.orderGet++;
		this.modelUiToPojo.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getModelUiToPojo() : string {
		if (this.modelUiToPojo == null || this.modelUiToPojo == undefined) {
			this.modelUiToPojo = new CommandAttr<string>();
		}
		return this.modelUiToPojo.getCommandReturnValue();
	}
	public setModelUiToPojo(value : string) : T {
		this.resetIfRequired();
		if (this.modelUiToPojo == null || this.modelUiToPojo == undefined) {
			this.modelUiToPojo = new CommandAttr<string>();
		}
		
		this.modelUiToPojo.setSetter(true);
		this.modelUiToPojo.setValue(value);
		this.orderSet++;
		this.modelUiToPojo.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setModelPojoToUiParams(value : string) : T {
		this.resetIfRequired();
		if (this.modelPojoToUiParams == null || this.modelPojoToUiParams == undefined) {
			this.modelPojoToUiParams = new CommandAttr<string>();
		}
		
		this.modelPojoToUiParams.setSetter(true);
		this.modelPojoToUiParams.setValue(value);
		this.orderSet++;
		this.modelPojoToUiParams.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public refreshUiFromModel(value : string) : T {
		this.resetIfRequired();
		if (this.refreshUiFromModel_ == null || this.refreshUiFromModel_ == undefined) {
			this.refreshUiFromModel_ = new CommandAttr<string>();
		}
		
		this.refreshUiFromModel_.setSetter(true);
		this.refreshUiFromModel_.setValue(value);
		this.orderSet++;
		this.refreshUiFromModel_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setModelUiToPojoEventIds(value : string) : T {
		this.resetIfRequired();
		if (this.modelUiToPojoEventIds == null || this.modelUiToPojoEventIds == undefined) {
			this.modelUiToPojoEventIds = new CommandAttr<string>();
		}
		
		this.modelUiToPojoEventIds.setSetter(true);
		this.modelUiToPojoEventIds.setValue(value);
		this.orderSet++;
		this.modelUiToPojoEventIds.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public updateModelData(expression : string,
payload : any) : T {
		this.resetIfRequired();
		if (this.updateModelData_ == null || this.updateModelData_ == undefined) {
			this.updateModelData_ = new CommandAttr<ScopedObject>();
		}
		
		let wrapper:ScopedObject = new ScopedObject();
		wrapper.expression = expression;
		wrapper.payload = payload;
		this.updateModelData_.setSetter(true);
		this.updateModelData_.setValue(wrapper);	
		this.orderSet++;
		this.updateModelData_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	public updateModelDataWithScopedObject(...arr: ScopedObject[]) : T {
		this.resetIfRequired();
		if (this.updateModelData_ == null || this.updateModelData_ == undefined) {
			this.updateModelData_ = new CommandAttr<ScopedObject[]>();
		}
		
		this.updateModelData_.setSetter(true);
		this.updateModelData_.setValue(arr);	
		this.orderSet++;
		this.updateModelData_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}

	public notifyDataSetChanged(value : boolean) : T {
		this.resetIfRequired();
		if (this.notifyDataSetChanged_ == null || this.notifyDataSetChanged_ == undefined) {
			this.notifyDataSetChanged_ = new CommandAttr<boolean>();
		}
		
		this.notifyDataSetChanged_.setSetter(true);
		this.notifyDataSetChanged_.setValue(value);
		this.orderSet++;
		this.notifyDataSetChanged_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetVisibility() : T {
		this.resetIfRequired();
		if (this.visibility == null || this.visibility == undefined) {
			this.visibility = new CommandAttr<Visibility>()
		}
		
		this.visibility.setGetter(true);
		this.orderGet++;
		this.visibility.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getVisibility() : Visibility {
		if (this.visibility == null || this.visibility == undefined) {
			this.visibility = new CommandAttr<Visibility>();
		}
		return this.visibility.getCommandReturnValue();
	}
	public setVisibility(value : Visibility) : T {
		this.resetIfRequired();
		if (this.visibility == null || this.visibility == undefined) {
			this.visibility = new CommandAttr<Visibility>();
		}
		
		this.visibility.setSetter(true);
		this.visibility.setValue(value);
		this.orderSet++;
		this.visibility.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBackground() : T {
		this.resetIfRequired();
		if (this.background == null || this.background == undefined) {
			this.background = new CommandAttr<string>()
		}
		
		this.background.setGetter(true);
		this.orderGet++;
		this.background.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBackground() : string {
		if (this.background == null || this.background == undefined) {
			this.background = new CommandAttr<string>();
		}
		return this.background.getCommandReturnValue();
	}
	public setBackground(value : string) : T {
		this.resetIfRequired();
		if (this.background == null || this.background == undefined) {
			this.background = new CommandAttr<string>();
		}
		
		this.background.setSetter(true);
		this.background.setValue(value);
		this.orderSet++;
		this.background.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBackgroundRepeat(value : BackgroundRepeat) : T {
		this.resetIfRequired();
		if (this.backgroundRepeat == null || this.backgroundRepeat == undefined) {
			this.backgroundRepeat = new CommandAttr<BackgroundRepeat>();
		}
		
		this.backgroundRepeat.setSetter(true);
		this.backgroundRepeat.setValue(value);
		this.orderSet++;
		this.backgroundRepeat.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetMinWidth() : T {
		this.resetIfRequired();
		if (this.minWidth == null || this.minWidth == undefined) {
			this.minWidth = new CommandAttr<string>()
		}
		
		this.minWidth.setGetter(true);
		this.orderGet++;
		this.minWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getMinWidth() : string {
		if (this.minWidth == null || this.minWidth == undefined) {
			this.minWidth = new CommandAttr<string>();
		}
		return this.minWidth.getCommandReturnValue();
	}
	public setMinWidth(value : string) : T {
		this.resetIfRequired();
		if (this.minWidth == null || this.minWidth == undefined) {
			this.minWidth = new CommandAttr<string>();
		}
		
		this.minWidth.setSetter(true);
		this.minWidth.setValue(value);
		this.orderSet++;
		this.minWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetMinHeight() : T {
		this.resetIfRequired();
		if (this.minHeight == null || this.minHeight == undefined) {
			this.minHeight = new CommandAttr<string>()
		}
		
		this.minHeight.setGetter(true);
		this.orderGet++;
		this.minHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getMinHeight() : string {
		if (this.minHeight == null || this.minHeight == undefined) {
			this.minHeight = new CommandAttr<string>();
		}
		return this.minHeight.getCommandReturnValue();
	}
	public setMinHeight(value : string) : T {
		this.resetIfRequired();
		if (this.minHeight == null || this.minHeight == undefined) {
			this.minHeight = new CommandAttr<string>();
		}
		
		this.minHeight.setSetter(true);
		this.minHeight.setValue(value);
		this.orderSet++;
		this.minHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public invalidate() : T {
		this.resetIfRequired();
		if (this.invalidate_ == null || this.invalidate_ == undefined) {
			this.invalidate_ = new CommandAttr<void>();
		}
		
		this.invalidate_.setSetter(true);
		
		this.orderSet++;
		this.invalidate_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public requestLayout() : T {
		this.resetIfRequired();
		if (this.requestLayout_ == null || this.requestLayout_ == undefined) {
			this.requestLayout_ = new CommandAttr<void>();
		}
		
		this.requestLayout_.setSetter(true);
		
		this.orderSet++;
		this.requestLayout_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetLayoutDirection() : T {
		this.resetIfRequired();
		if (this.layoutDirection == null || this.layoutDirection == undefined) {
			this.layoutDirection = new CommandAttr<LayoutDirection>()
		}
		
		this.layoutDirection.setGetter(true);
		this.orderGet++;
		this.layoutDirection.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutDirection() : LayoutDirection {
		if (this.layoutDirection == null || this.layoutDirection == undefined) {
			this.layoutDirection = new CommandAttr<LayoutDirection>();
		}
		return this.layoutDirection.getCommandReturnValue();
	}
	public setLayoutDirection(value : LayoutDirection) : T {
		this.resetIfRequired();
		if (this.layoutDirection == null || this.layoutDirection == undefined) {
			this.layoutDirection = new CommandAttr<LayoutDirection>();
		}
		
		this.layoutDirection.setSetter(true);
		this.layoutDirection.setValue(value);
		this.orderSet++;
		this.layoutDirection.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTextDirection() : T {
		this.resetIfRequired();
		if (this.textDirection == null || this.textDirection == undefined) {
			this.textDirection = new CommandAttr<TextDirection>()
		}
		
		this.textDirection.setGetter(true);
		this.orderGet++;
		this.textDirection.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTextDirection() : TextDirection {
		if (this.textDirection == null || this.textDirection == undefined) {
			this.textDirection = new CommandAttr<TextDirection>();
		}
		return this.textDirection.getCommandReturnValue();
	}
	public setTextDirection(value : TextDirection) : T {
		this.resetIfRequired();
		if (this.textDirection == null || this.textDirection == undefined) {
			this.textDirection = new CommandAttr<TextDirection>();
		}
		
		this.textDirection.setSetter(true);
		this.textDirection.setValue(value);
		this.orderSet++;
		this.textDirection.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTextAlignment() : T {
		this.resetIfRequired();
		if (this.textAlignment == null || this.textAlignment == undefined) {
			this.textAlignment = new CommandAttr<TextAlignment>()
		}
		
		this.textAlignment.setGetter(true);
		this.orderGet++;
		this.textAlignment.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTextAlignment() : TextAlignment {
		if (this.textAlignment == null || this.textAlignment == undefined) {
			this.textAlignment = new CommandAttr<TextAlignment>();
		}
		return this.textAlignment.getCommandReturnValue();
	}
	public setTextAlignment(value : TextAlignment) : T {
		this.resetIfRequired();
		if (this.textAlignment == null || this.textAlignment == undefined) {
			this.textAlignment = new CommandAttr<TextAlignment>();
		}
		
		this.textAlignment.setSetter(true);
		this.textAlignment.setValue(value);
		this.orderSet++;
		this.textAlignment.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnClick(value : string) : T {
		this.resetIfRequired();
		if (this.onClick == null || this.onClick == undefined) {
			this.onClick = new CommandAttr<string>();
		}
		
		this.onClick.setSetter(true);
		this.onClick.setValue(value);
		this.orderSet++;
		this.onClick.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnLongClick(value : string) : T {
		this.resetIfRequired();
		if (this.onLongClick == null || this.onLongClick == undefined) {
			this.onLongClick = new CommandAttr<string>();
		}
		
		this.onLongClick.setSetter(true);
		this.onLongClick.setValue(value);
		this.orderSet++;
		this.onLongClick.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnTouch(value : string) : T {
		this.resetIfRequired();
		if (this.onTouch == null || this.onTouch == undefined) {
			this.onTouch = new CommandAttr<string>();
		}
		
		this.onTouch.setSetter(true);
		this.onTouch.setValue(value);
		this.orderSet++;
		this.onTouch.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnKey(value : string) : T {
		this.resetIfRequired();
		if (this.onKey == null || this.onKey == undefined) {
			this.onKey = new CommandAttr<string>();
		}
		
		this.onKey.setSetter(true);
		this.onKey.setValue(value);
		this.orderSet++;
		this.onKey.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnHover(value : string) : T {
		this.resetIfRequired();
		if (this.onHover == null || this.onHover == undefined) {
			this.onHover = new CommandAttr<string>();
		}
		
		this.onHover.setSetter(true);
		this.onHover.setValue(value);
		this.orderSet++;
		this.onHover.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnDrag(value : string) : T {
		this.resetIfRequired();
		if (this.onDrag == null || this.onDrag == undefined) {
			this.onDrag = new CommandAttr<string>();
		}
		
		this.onDrag.setSetter(true);
		this.onDrag.setValue(value);
		this.orderSet++;
		this.onDrag.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetClickable() : T {
		this.resetIfRequired();
		if (this.clickable == null || this.clickable == undefined) {
			this.clickable = new CommandAttr<boolean>()
		}
		
		this.clickable.setGetter(true);
		this.orderGet++;
		this.clickable.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isClickable() : boolean {
		if (this.clickable == null || this.clickable == undefined) {
			this.clickable = new CommandAttr<boolean>();
		}
		return this.clickable.getCommandReturnValue();
	}
	public setClickable(value : boolean) : T {
		this.resetIfRequired();
		if (this.clickable == null || this.clickable == undefined) {
			this.clickable = new CommandAttr<boolean>();
		}
		
		this.clickable.setSetter(true);
		this.clickable.setValue(value);
		this.orderSet++;
		this.clickable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetDuplicateParentState() : T {
		this.resetIfRequired();
		if (this.duplicateParentState == null || this.duplicateParentState == undefined) {
			this.duplicateParentState = new CommandAttr<boolean>()
		}
		
		this.duplicateParentState.setGetter(true);
		this.orderGet++;
		this.duplicateParentState.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isDuplicateParentState() : boolean {
		if (this.duplicateParentState == null || this.duplicateParentState == undefined) {
			this.duplicateParentState = new CommandAttr<boolean>();
		}
		return this.duplicateParentState.getCommandReturnValue();
	}
	public setDuplicateParentState(value : boolean) : T {
		this.resetIfRequired();
		if (this.duplicateParentState == null || this.duplicateParentState == undefined) {
			this.duplicateParentState = new CommandAttr<boolean>();
		}
		
		this.duplicateParentState.setSetter(true);
		this.duplicateParentState.setValue(value);
		this.orderSet++;
		this.duplicateParentState.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetLongClickable() : T {
		this.resetIfRequired();
		if (this.longClickable == null || this.longClickable == undefined) {
			this.longClickable = new CommandAttr<boolean>()
		}
		
		this.longClickable.setGetter(true);
		this.orderGet++;
		this.longClickable.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLongClickable() : boolean {
		if (this.longClickable == null || this.longClickable == undefined) {
			this.longClickable = new CommandAttr<boolean>();
		}
		return this.longClickable.getCommandReturnValue();
	}
	public setLongClickable(value : boolean) : T {
		this.resetIfRequired();
		if (this.longClickable == null || this.longClickable == undefined) {
			this.longClickable = new CommandAttr<boolean>();
		}
		
		this.longClickable.setSetter(true);
		this.longClickable.setValue(value);
		this.orderSet++;
		this.longClickable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setAsDragSource(value : string) : T {
		this.resetIfRequired();
		if (this.asDragSource == null || this.asDragSource == undefined) {
			this.asDragSource = new CommandAttr<string>();
		}
		
		this.asDragSource.setSetter(true);
		this.asDragSource.setValue(value);
		this.orderSet++;
		this.asDragSource.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTooltipText(value : string) : T {
		this.resetIfRequired();
		if (this.tooltipText == null || this.tooltipText == undefined) {
			this.tooltipText = new CommandAttr<string>();
		}
		
		this.tooltipText.setSetter(true);
		this.tooltipText.setValue(value);
		this.orderSet++;
		this.tooltipText.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetEnabled() : T {
		this.resetIfRequired();
		if (this.enabled == null || this.enabled == undefined) {
			this.enabled = new CommandAttr<boolean>()
		}
		
		this.enabled.setGetter(true);
		this.orderGet++;
		this.enabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isEnabled() : boolean {
		if (this.enabled == null || this.enabled == undefined) {
			this.enabled = new CommandAttr<boolean>();
		}
		return this.enabled.getCommandReturnValue();
	}
	public setEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.enabled == null || this.enabled == undefined) {
			this.enabled = new CommandAttr<boolean>();
		}
		
		this.enabled.setSetter(true);
		this.enabled.setValue(value);
		this.orderSet++;
		this.enabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setAttributeUnderTest(value : string) : T {
		this.resetIfRequired();
		if (this.attributeUnderTest == null || this.attributeUnderTest == undefined) {
			this.attributeUnderTest = new CommandAttr<string>();
		}
		
		this.attributeUnderTest.setSetter(true);
		this.attributeUnderTest.setValue(value);
		this.orderSet++;
		this.attributeUnderTest.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setZIndex(value : number) : T {
		this.resetIfRequired();
		if (this.zIndex == null || this.zIndex == undefined) {
			this.zIndex = new CommandAttr<number>();
		}
		
		this.zIndex.setSetter(true);
		this.zIndex.setValue(value);
		this.orderSet++;
		this.zIndex.setOrderSet(this.orderSet);
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
		

	public setWebTabIndex(value : string) : T {
		this.resetIfRequired();
		if (this.webTabIndex == null || this.webTabIndex == undefined) {
			this.webTabIndex = new CommandAttr<string>();
		}
		
		this.webTabIndex.setSetter(true);
		this.webTabIndex.setValue(value);
		this.orderSet++;
		this.webTabIndex.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setWebOverflow(value : string) : T {
		this.resetIfRequired();
		if (this.webOverflow == null || this.webOverflow == undefined) {
			this.webOverflow = new CommandAttr<string>();
		}
		
		this.webOverflow.setSetter(true);
		this.webOverflow.setValue(value);
		this.orderSet++;
		this.webOverflow.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTranslationX() : T {
		this.resetIfRequired();
		if (this.translationX == null || this.translationX == undefined) {
			this.translationX = new CommandAttr<string>()
		}
		
		this.translationX.setGetter(true);
		this.orderGet++;
		this.translationX.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTranslationX() : string {
		if (this.translationX == null || this.translationX == undefined) {
			this.translationX = new CommandAttr<string>();
		}
		return this.translationX.getCommandReturnValue();
	}
	public setTranslationX(value : string) : T {
		this.resetIfRequired();
		if (this.translationX == null || this.translationX == undefined) {
			this.translationX = new CommandAttr<string>();
		}
		
		this.translationX.setSetter(true);
		this.translationX.setValue(value);
		this.orderSet++;
		this.translationX.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTranslationY() : T {
		this.resetIfRequired();
		if (this.translationY == null || this.translationY == undefined) {
			this.translationY = new CommandAttr<string>()
		}
		
		this.translationY.setGetter(true);
		this.orderGet++;
		this.translationY.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTranslationY() : string {
		if (this.translationY == null || this.translationY == undefined) {
			this.translationY = new CommandAttr<string>();
		}
		return this.translationY.getCommandReturnValue();
	}
	public setTranslationY(value : string) : T {
		this.resetIfRequired();
		if (this.translationY == null || this.translationY == undefined) {
			this.translationY = new CommandAttr<string>();
		}
		
		this.translationY.setSetter(true);
		this.translationY.setValue(value);
		this.orderSet++;
		this.translationY.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTranslationZ() : T {
		this.resetIfRequired();
		if (this.translationZ == null || this.translationZ == undefined) {
			this.translationZ = new CommandAttr<string>()
		}
		
		this.translationZ.setGetter(true);
		this.orderGet++;
		this.translationZ.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTranslationZ() : string {
		if (this.translationZ == null || this.translationZ == undefined) {
			this.translationZ = new CommandAttr<string>();
		}
		return this.translationZ.getCommandReturnValue();
	}
	public setTranslationZ(value : string) : T {
		this.resetIfRequired();
		if (this.translationZ == null || this.translationZ == undefined) {
			this.translationZ = new CommandAttr<string>();
		}
		
		this.translationZ.setSetter(true);
		this.translationZ.setValue(value);
		this.orderSet++;
		this.translationZ.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetRotation() : T {
		this.resetIfRequired();
		if (this.rotation == null || this.rotation == undefined) {
			this.rotation = new CommandAttr<number>()
		}
		
		this.rotation.setGetter(true);
		this.orderGet++;
		this.rotation.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getRotation() : number {
		if (this.rotation == null || this.rotation == undefined) {
			this.rotation = new CommandAttr<number>();
		}
		return this.rotation.getCommandReturnValue();
	}
	public setRotation(value : number) : T {
		this.resetIfRequired();
		if (this.rotation == null || this.rotation == undefined) {
			this.rotation = new CommandAttr<number>();
		}
		
		this.rotation.setSetter(true);
		this.rotation.setValue(value);
		this.orderSet++;
		this.rotation.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetRotationX() : T {
		this.resetIfRequired();
		if (this.rotationX == null || this.rotationX == undefined) {
			this.rotationX = new CommandAttr<number>()
		}
		
		this.rotationX.setGetter(true);
		this.orderGet++;
		this.rotationX.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getRotationX() : number {
		if (this.rotationX == null || this.rotationX == undefined) {
			this.rotationX = new CommandAttr<number>();
		}
		return this.rotationX.getCommandReturnValue();
	}
	public setRotationX(value : number) : T {
		this.resetIfRequired();
		if (this.rotationX == null || this.rotationX == undefined) {
			this.rotationX = new CommandAttr<number>();
		}
		
		this.rotationX.setSetter(true);
		this.rotationX.setValue(value);
		this.orderSet++;
		this.rotationX.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetRotationY() : T {
		this.resetIfRequired();
		if (this.rotationY == null || this.rotationY == undefined) {
			this.rotationY = new CommandAttr<number>()
		}
		
		this.rotationY.setGetter(true);
		this.orderGet++;
		this.rotationY.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getRotationY() : number {
		if (this.rotationY == null || this.rotationY == undefined) {
			this.rotationY = new CommandAttr<number>();
		}
		return this.rotationY.getCommandReturnValue();
	}
	public setRotationY(value : number) : T {
		this.resetIfRequired();
		if (this.rotationY == null || this.rotationY == undefined) {
			this.rotationY = new CommandAttr<number>();
		}
		
		this.rotationY.setSetter(true);
		this.rotationY.setValue(value);
		this.orderSet++;
		this.rotationY.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScaleX() : T {
		this.resetIfRequired();
		if (this.scaleX == null || this.scaleX == undefined) {
			this.scaleX = new CommandAttr<number>()
		}
		
		this.scaleX.setGetter(true);
		this.orderGet++;
		this.scaleX.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScaleX() : number {
		if (this.scaleX == null || this.scaleX == undefined) {
			this.scaleX = new CommandAttr<number>();
		}
		return this.scaleX.getCommandReturnValue();
	}
	public setScaleX(value : number) : T {
		this.resetIfRequired();
		if (this.scaleX == null || this.scaleX == undefined) {
			this.scaleX = new CommandAttr<number>();
		}
		
		this.scaleX.setSetter(true);
		this.scaleX.setValue(value);
		this.orderSet++;
		this.scaleX.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScaleY() : T {
		this.resetIfRequired();
		if (this.scaleY == null || this.scaleY == undefined) {
			this.scaleY = new CommandAttr<number>()
		}
		
		this.scaleY.setGetter(true);
		this.orderGet++;
		this.scaleY.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScaleY() : number {
		if (this.scaleY == null || this.scaleY == undefined) {
			this.scaleY = new CommandAttr<number>();
		}
		return this.scaleY.getCommandReturnValue();
	}
	public setScaleY(value : number) : T {
		this.resetIfRequired();
		if (this.scaleY == null || this.scaleY == undefined) {
			this.scaleY = new CommandAttr<number>();
		}
		
		this.scaleY.setSetter(true);
		this.scaleY.setValue(value);
		this.orderSet++;
		this.scaleY.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSelected() : T {
		this.resetIfRequired();
		if (this.selected == null || this.selected == undefined) {
			this.selected = new CommandAttr<boolean>()
		}
		
		this.selected.setGetter(true);
		this.orderGet++;
		this.selected.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isSelected() : boolean {
		if (this.selected == null || this.selected == undefined) {
			this.selected = new CommandAttr<boolean>();
		}
		return this.selected.getCommandReturnValue();
	}
	public setSelected(value : boolean) : T {
		this.resetIfRequired();
		if (this.selected == null || this.selected == undefined) {
			this.selected = new CommandAttr<boolean>();
		}
		
		this.selected.setSetter(true);
		this.selected.setValue(value);
		this.orderSet++;
		this.selected.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setStyle(value : string) : T {
		this.resetIfRequired();
		if (this.style == null || this.style == undefined) {
			this.style = new CommandAttr<string>();
		}
		
		this.style.setSetter(true);
		this.style.setValue(value);
		this.orderSet++;
		this.style.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setErrorStyle(value : string) : T {
		this.resetIfRequired();
		if (this.errorStyle == null || this.errorStyle == undefined) {
			this.errorStyle = new CommandAttr<string>();
		}
		
		this.errorStyle.setSetter(true);
		this.errorStyle.setValue(value);
		this.orderSet++;
		this.errorStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetValidateForm() : T {
		this.resetIfRequired();
		if (this.validateForm_ == null || this.validateForm_ == undefined) {
			this.validateForm_ = new CommandAttr<string>()
		}
		
		this.validateForm_.setGetter(true);
		this.orderGet++;
		this.validateForm_.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getValidateForm() : string {
		if (this.validateForm_ == null || this.validateForm_ == undefined) {
			this.validateForm_ = new CommandAttr<string>();
		}
		return this.validateForm_.getCommandReturnValue();
	}
	public validateForm(value : string) : T {
		this.resetIfRequired();
		if (this.validateForm_ == null || this.validateForm_ == undefined) {
			this.validateForm_ = new CommandAttr<string>();
		}
		
		this.validateForm_.setSetter(true);
		this.validateForm_.setValue(value);
		this.orderSet++;
		this.validateForm_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setValidation(value : string) : T {
		this.resetIfRequired();
		if (this.validation == null || this.validation == undefined) {
			this.validation = new CommandAttr<string>();
		}
		
		this.validation.setSetter(true);
		this.validation.setValue(value);
		this.orderSet++;
		this.validation.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setV_required(value : string) : T {
		this.resetIfRequired();
		if (this.v_required == null || this.v_required == undefined) {
			this.v_required = new CommandAttr<string>();
		}
		
		this.v_required.setSetter(true);
		this.v_required.setValue(value);
		this.orderSet++;
		this.v_required.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setV_minlength(value : string) : T {
		this.resetIfRequired();
		if (this.v_minlength == null || this.v_minlength == undefined) {
			this.v_minlength = new CommandAttr<string>();
		}
		
		this.v_minlength.setSetter(true);
		this.v_minlength.setValue(value);
		this.orderSet++;
		this.v_minlength.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setV_maxlength(value : string) : T {
		this.resetIfRequired();
		if (this.v_maxlength == null || this.v_maxlength == undefined) {
			this.v_maxlength = new CommandAttr<string>();
		}
		
		this.v_maxlength.setSetter(true);
		this.v_maxlength.setValue(value);
		this.orderSet++;
		this.v_maxlength.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setV_min(value : string) : T {
		this.resetIfRequired();
		if (this.v_min == null || this.v_min == undefined) {
			this.v_min = new CommandAttr<string>();
		}
		
		this.v_min.setSetter(true);
		this.v_min.setValue(value);
		this.orderSet++;
		this.v_min.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setV_max(value : string) : T {
		this.resetIfRequired();
		if (this.v_max == null || this.v_max == undefined) {
			this.v_max = new CommandAttr<string>();
		}
		
		this.v_max.setSetter(true);
		this.v_max.setValue(value);
		this.orderSet++;
		this.v_max.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setV_pattern(value : string) : T {
		this.resetIfRequired();
		if (this.v_pattern == null || this.v_pattern == undefined) {
			this.v_pattern = new CommandAttr<string>();
		}
		
		this.v_pattern.setSetter(true);
		this.v_pattern.setValue(value);
		this.orderSet++;
		this.v_pattern.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setV_type(value : Vtype) : T {
		this.resetIfRequired();
		if (this.v_type == null || this.v_type == undefined) {
			this.v_type = new CommandAttr<Vtype>();
		}
		
		this.v_type.setSetter(true);
		this.v_type.setValue(value);
		this.orderSet++;
		this.v_type.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setValidationErrorDisplayType(...value : ValidationErrorDisplay[]) : T {
		this.resetIfRequired();
		if (this.validationErrorDisplayType == null || this.validationErrorDisplayType == undefined) {
			this.validationErrorDisplayType = new CommandAttr<ValidationErrorDisplay[]>();
		}
		
		this.validationErrorDisplayType.setSetter(true);
		this.validationErrorDisplayType.setValue(value);
		this.orderSet++;
		this.validationErrorDisplayType.setOrderSet(this.orderSet);
this.validationErrorDisplayType.setTransformer('validationErrorDisplay');		return this.thisPointer;
	}
		

	public setCustomErrorMessageValues(value : string) : T {
		this.resetIfRequired();
		if (this.customErrorMessageValues == null || this.customErrorMessageValues == undefined) {
			this.customErrorMessageValues = new CommandAttr<string>();
		}
		
		this.customErrorMessageValues.setSetter(true);
		this.customErrorMessageValues.setValue(value);
		this.orderSet++;
		this.customErrorMessageValues.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setCustomErrorMessageKeys(value : string) : T {
		this.resetIfRequired();
		if (this.customErrorMessageKeys == null || this.customErrorMessageKeys == undefined) {
			this.customErrorMessageKeys = new CommandAttr<string>();
		}
		
		this.customErrorMessageKeys.setSetter(true);
		this.customErrorMessageKeys.setValue(value);
		this.orderSet++;
		this.customErrorMessageKeys.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setInvalidateOnFrameChange(value : boolean) : T {
		this.resetIfRequired();
		if (this.invalidateOnFrameChange == null || this.invalidateOnFrameChange == undefined) {
			this.invalidateOnFrameChange = new CommandAttr<boolean>();
		}
		
		this.invalidateOnFrameChange.setSetter(true);
		this.invalidateOnFrameChange.setValue(value);
		this.orderSet++;
		this.invalidateOnFrameChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class View extends ViewImpl<View> implements IWidget{
    getThisPointer(): View {
        return this;
    }
    
   	public getClass() {
		return View;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ViewImpl.initialize();

//end - staticinit
