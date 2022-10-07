// start - imports

export const enum IosAccessibilityTraits {
uiaccessibilitytraitadjustable = "uiaccessibilitytraitadjustable",
uiaccessibilitytraitallowsdirectinteraction = "uiaccessibilitytraitallowsdirectinteraction",
uiaccessibilitytraitbutton = "uiaccessibilitytraitbutton",
uiaccessibilitytraitcausespageturn = "uiaccessibilitytraitcausespageturn",
uiaccessibilitytraitheader = "uiaccessibilitytraitheader",
uiaccessibilitytraitimage = "uiaccessibilitytraitimage",
uiaccessibilitytraitkeyboardkey = "uiaccessibilitytraitkeyboardkey",
uiaccessibilitytraitlink = "uiaccessibilitytraitlink",
uiaccessibilitytraitnone = "uiaccessibilitytraitnone",
uiaccessibilitytraitnotenabled = "uiaccessibilitytraitnotenabled",
uiaccessibilitytraitplayssound = "uiaccessibilitytraitplayssound",
uiaccessibilitytraitsearchfield = "uiaccessibilitytraitsearchfield",
uiaccessibilitytraitselected = "uiaccessibilitytraitselected",
uiaccessibilitytraitstartsmediasession = "uiaccessibilitytraitstartsmediasession",
uiaccessibilitytraitstatictext = "uiaccessibilitytraitstatictext",
uiaccessibilitytraitsummaryelement = "uiaccessibilitytraitsummaryelement",
uiaccessibilitytraittabbar = "uiaccessibilitytraittabbar",
uiaccessibilitytraitupdatesfrequently = "uiaccessibilitytraitupdatesfrequently",
}
export const enum BackgroundRepeat {
no_repeat = "no-repeat",
repeat = "repeat",
}
export const enum BackgroundTintMode {
add = "add",
multiply = "multiply",
screen = "screen",
src_atop = "src_atop",
src_in = "src_in",
src_over = "src_over",
}
export const enum ForegroundRepeat {
no_repeat = "no-repeat",
repeat = "repeat",
}
export const enum ForegroundTintMode {
add = "add",
multiply = "multiply",
screen = "screen",
src_atop = "src_atop",
src_in = "src_in",
src_over = "src_over",
}
export const enum Visibility {
gone = "gone",
invisible = "invisible",
visible = "visible",
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
	@Expose({ name: "iosBackgroundColor" })
	iosBackgroundColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsHidden" })
	iosIsHidden!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAlpha" })
	iosAlpha!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsOpaque" })
	iosIsOpaque!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosTintColor" })
	iosTintColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosClipsToBounds" })
	iosClipsToBounds!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosClearsContextBeforeDrawing" })
	iosClearsContextBeforeDrawing!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsUserInteractionEnabled" })
	iosIsUserInteractionEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsMultipleTouchEnabled" })
	iosIsMultipleTouchEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsExclusiveTouch" })
	iosIsExclusiveTouch!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosPreservesSuperviewLayoutMargins" })
	iosPreservesSuperviewLayoutMargins!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosInsetsLayoutMarginsFromSafeArea" })
	iosInsetsLayoutMarginsFromSafeArea!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAutoresizesSubviews" })
	iosAutoresizesSubviews!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosTranslatesAutoresizingMaskIntoConstraints" })
	iosTranslatesAutoresizingMaskIntoConstraints!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosContentScaleFactor" })
	iosContentScaleFactor!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsFocused" })
	iosIsFocused!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosRestorationIdentifier" })
	iosRestorationIdentifier!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosTag" })
	iosTag!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAccessibilityIgnoresInvertColors" })
	iosAccessibilityIgnoresInvertColors!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosLargeContentImage" })
	iosLargeContentImage!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosLargeContentTitle" })
	iosLargeContentTitle!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosScalesLargeContentImage" })
	iosScalesLargeContentImage!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosShowsLargeContentViewer" })
	iosShowsLargeContentViewer!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsAccessibilityElement" })
	iosIsAccessibilityElement!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAccessibilityLabel" })
	iosAccessibilityLabel!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAccessibilityHint" })
	iosAccessibilityHint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAccessibilityValue" })
	iosAccessibilityValue!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAccessibilityTraits" })
	iosAccessibilityTraits!:CommandAttr<IosAccessibilityTraits>| undefined;
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
	@Expose({ name: "background" })
	background!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundRepeat" })
	backgroundRepeat!:CommandAttr<BackgroundRepeat>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onClick" })
	onClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onTouch" })
	onTouch!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minWidth" })
	minWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minHeight" })
	minHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "attributeUnderTest" })
	attributeUnderTest!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundTint" })
	backgroundTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundTintMode" })
	backgroundTintMode!:CommandAttr<BackgroundTintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foreground" })
	foreground!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundRepeat" })
	foregroundRepeat!:CommandAttr<ForegroundRepeat>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundTint" })
	foregroundTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundTintMode" })
	foregroundTintMode!:CommandAttr<ForegroundTintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "visibility" })
	visibility!:CommandAttr<Visibility>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "alpha" })
	alpha!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onLongClick" })
	onLongClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "longClickable" })
	longClickable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "clickable" })
	clickable!:CommandAttr<boolean>| undefined;
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
	@Expose({ name: "transformPivotX" })
	transformPivotX!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "transformPivotY" })
	transformPivotY!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "invalidate" })
	invalidate_!:CommandAttr<void>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "requestLayout" })
	requestLayout_!:CommandAttr<void>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "keepScreenOn" })
	keepScreenOn!:CommandAttr<boolean>| undefined;
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
	@Expose({ name: "onDrag" })
	onDrag!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "asDragSource" })
	asDragSource!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "enabled" })
	enabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "duplicateParentState" })
	duplicateParentState!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundGravity" })
	foregroundGravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onKey" })
	onKey!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosLayerBorderWidth" })
	iosLayerBorderWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosLayerBorderColor" })
	iosLayerBorderColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosLayerCornerRadius" })
	iosLayerCornerRadius!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosLayerMasksToBounds" })
	iosLayerMasksToBounds!:CommandAttr<boolean>| undefined;
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
		this.iosBackgroundColor = undefined;
		this.iosIsHidden = undefined;
		this.iosAlpha = undefined;
		this.iosIsOpaque = undefined;
		this.iosTintColor = undefined;
		this.iosClipsToBounds = undefined;
		this.iosClearsContextBeforeDrawing = undefined;
		this.iosIsUserInteractionEnabled = undefined;
		this.iosIsMultipleTouchEnabled = undefined;
		this.iosIsExclusiveTouch = undefined;
		this.iosPreservesSuperviewLayoutMargins = undefined;
		this.iosInsetsLayoutMarginsFromSafeArea = undefined;
		this.iosAutoresizesSubviews = undefined;
		this.iosTranslatesAutoresizingMaskIntoConstraints = undefined;
		this.iosContentScaleFactor = undefined;
		this.iosIsFocused = undefined;
		this.iosRestorationIdentifier = undefined;
		this.iosTag = undefined;
		this.iosAccessibilityIgnoresInvertColors = undefined;
		this.iosLargeContentImage = undefined;
		this.iosLargeContentTitle = undefined;
		this.iosScalesLargeContentImage = undefined;
		this.iosShowsLargeContentViewer = undefined;
		this.iosIsAccessibilityElement = undefined;
		this.iosAccessibilityLabel = undefined;
		this.iosAccessibilityHint = undefined;
		this.iosAccessibilityValue = undefined;
		this.iosAccessibilityTraits = undefined;
		this.modelSyncEvents = undefined;
		this.modelParam = undefined;
		this.modelPojoToUi = undefined;
		this.modelUiToPojo = undefined;
		this.modelPojoToUiParams = undefined;
		this.refreshUiFromModel_ = undefined;
		this.modelUiToPojoEventIds = undefined;
		this.updateModelData_ = undefined;
		this.notifyDataSetChanged_ = undefined;
		this.background = undefined;
		this.backgroundRepeat = undefined;
		this.onClick = undefined;
		this.onTouch = undefined;
		this.minWidth = undefined;
		this.minHeight = undefined;
		this.attributeUnderTest = undefined;
		this.backgroundTint = undefined;
		this.backgroundTintMode = undefined;
		this.foreground = undefined;
		this.foregroundRepeat = undefined;
		this.foregroundTint = undefined;
		this.foregroundTintMode = undefined;
		this.visibility = undefined;
		this.alpha = undefined;
		this.onLongClick = undefined;
		this.longClickable = undefined;
		this.clickable = undefined;
		this.translationX = undefined;
		this.translationY = undefined;
		this.translationZ = undefined;
		this.rotation = undefined;
		this.rotationX = undefined;
		this.rotationY = undefined;
		this.scaleX = undefined;
		this.scaleY = undefined;
		this.transformPivotX = undefined;
		this.transformPivotY = undefined;
		this.invalidate_ = undefined;
		this.requestLayout_ = undefined;
		this.keepScreenOn = undefined;
		this.layoutDirection = undefined;
		this.textDirection = undefined;
		this.textAlignment = undefined;
		this.onDrag = undefined;
		this.asDragSource = undefined;
		this.enabled = undefined;
		this.duplicateParentState = undefined;
		this.foregroundGravity = undefined;
		this.onKey = undefined;
		this.iosLayerBorderWidth = undefined;
		this.iosLayerBorderColor = undefined;
		this.iosLayerCornerRadius = undefined;
		this.iosLayerMasksToBounds = undefined;
		this.zIndex = undefined;
		this.maxWidth = undefined;
		this.maxHeight = undefined;
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
	

	public tryGetIosBackgroundColor() : T {
		this.resetIfRequired();
		if (this.iosBackgroundColor == null || this.iosBackgroundColor == undefined) {
			this.iosBackgroundColor = new CommandAttr<string>()
		}
		
		this.iosBackgroundColor.setGetter(true);
		this.orderGet++;
		this.iosBackgroundColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosBackgroundColor() : string {
		if (this.iosBackgroundColor == null || this.iosBackgroundColor == undefined) {
			this.iosBackgroundColor = new CommandAttr<string>();
		}
		return this.iosBackgroundColor.getCommandReturnValue();
	}
	public setIosBackgroundColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosBackgroundColor == null || this.iosBackgroundColor == undefined) {
			this.iosBackgroundColor = new CommandAttr<string>();
		}
		
		this.iosBackgroundColor.setSetter(true);
		this.iosBackgroundColor.setValue(value);
		this.orderSet++;
		this.iosBackgroundColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsHidden() : T {
		this.resetIfRequired();
		if (this.iosIsHidden == null || this.iosIsHidden == undefined) {
			this.iosIsHidden = new CommandAttr<boolean>()
		}
		
		this.iosIsHidden.setGetter(true);
		this.orderGet++;
		this.iosIsHidden.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsHidden() : boolean {
		if (this.iosIsHidden == null || this.iosIsHidden == undefined) {
			this.iosIsHidden = new CommandAttr<boolean>();
		}
		return this.iosIsHidden.getCommandReturnValue();
	}
	public setIosIsHidden(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsHidden == null || this.iosIsHidden == undefined) {
			this.iosIsHidden = new CommandAttr<boolean>();
		}
		
		this.iosIsHidden.setSetter(true);
		this.iosIsHidden.setValue(value);
		this.orderSet++;
		this.iosIsHidden.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAlpha() : T {
		this.resetIfRequired();
		if (this.iosAlpha == null || this.iosAlpha == undefined) {
			this.iosAlpha = new CommandAttr<number>()
		}
		
		this.iosAlpha.setGetter(true);
		this.orderGet++;
		this.iosAlpha.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosAlpha() : number {
		if (this.iosAlpha == null || this.iosAlpha == undefined) {
			this.iosAlpha = new CommandAttr<number>();
		}
		return this.iosAlpha.getCommandReturnValue();
	}
	public setIosAlpha(value : number) : T {
		this.resetIfRequired();
		if (this.iosAlpha == null || this.iosAlpha == undefined) {
			this.iosAlpha = new CommandAttr<number>();
		}
		
		this.iosAlpha.setSetter(true);
		this.iosAlpha.setValue(value);
		this.orderSet++;
		this.iosAlpha.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsOpaque() : T {
		this.resetIfRequired();
		if (this.iosIsOpaque == null || this.iosIsOpaque == undefined) {
			this.iosIsOpaque = new CommandAttr<boolean>()
		}
		
		this.iosIsOpaque.setGetter(true);
		this.orderGet++;
		this.iosIsOpaque.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsOpaque() : boolean {
		if (this.iosIsOpaque == null || this.iosIsOpaque == undefined) {
			this.iosIsOpaque = new CommandAttr<boolean>();
		}
		return this.iosIsOpaque.getCommandReturnValue();
	}
	public setIosIsOpaque(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsOpaque == null || this.iosIsOpaque == undefined) {
			this.iosIsOpaque = new CommandAttr<boolean>();
		}
		
		this.iosIsOpaque.setSetter(true);
		this.iosIsOpaque.setValue(value);
		this.orderSet++;
		this.iosIsOpaque.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosTintColor() : T {
		this.resetIfRequired();
		if (this.iosTintColor == null || this.iosTintColor == undefined) {
			this.iosTintColor = new CommandAttr<string>()
		}
		
		this.iosTintColor.setGetter(true);
		this.orderGet++;
		this.iosTintColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosTintColor() : string {
		if (this.iosTintColor == null || this.iosTintColor == undefined) {
			this.iosTintColor = new CommandAttr<string>();
		}
		return this.iosTintColor.getCommandReturnValue();
	}
	public setIosTintColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosTintColor == null || this.iosTintColor == undefined) {
			this.iosTintColor = new CommandAttr<string>();
		}
		
		this.iosTintColor.setSetter(true);
		this.iosTintColor.setValue(value);
		this.orderSet++;
		this.iosTintColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosClipsToBounds() : T {
		this.resetIfRequired();
		if (this.iosClipsToBounds == null || this.iosClipsToBounds == undefined) {
			this.iosClipsToBounds = new CommandAttr<boolean>()
		}
		
		this.iosClipsToBounds.setGetter(true);
		this.orderGet++;
		this.iosClipsToBounds.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosClipsToBounds() : boolean {
		if (this.iosClipsToBounds == null || this.iosClipsToBounds == undefined) {
			this.iosClipsToBounds = new CommandAttr<boolean>();
		}
		return this.iosClipsToBounds.getCommandReturnValue();
	}
	public setIosClipsToBounds(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosClipsToBounds == null || this.iosClipsToBounds == undefined) {
			this.iosClipsToBounds = new CommandAttr<boolean>();
		}
		
		this.iosClipsToBounds.setSetter(true);
		this.iosClipsToBounds.setValue(value);
		this.orderSet++;
		this.iosClipsToBounds.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosClearsContextBeforeDrawing() : T {
		this.resetIfRequired();
		if (this.iosClearsContextBeforeDrawing == null || this.iosClearsContextBeforeDrawing == undefined) {
			this.iosClearsContextBeforeDrawing = new CommandAttr<boolean>()
		}
		
		this.iosClearsContextBeforeDrawing.setGetter(true);
		this.orderGet++;
		this.iosClearsContextBeforeDrawing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosClearsContextBeforeDrawing() : boolean {
		if (this.iosClearsContextBeforeDrawing == null || this.iosClearsContextBeforeDrawing == undefined) {
			this.iosClearsContextBeforeDrawing = new CommandAttr<boolean>();
		}
		return this.iosClearsContextBeforeDrawing.getCommandReturnValue();
	}
	public setIosClearsContextBeforeDrawing(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosClearsContextBeforeDrawing == null || this.iosClearsContextBeforeDrawing == undefined) {
			this.iosClearsContextBeforeDrawing = new CommandAttr<boolean>();
		}
		
		this.iosClearsContextBeforeDrawing.setSetter(true);
		this.iosClearsContextBeforeDrawing.setValue(value);
		this.orderSet++;
		this.iosClearsContextBeforeDrawing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsUserInteractionEnabled() : T {
		this.resetIfRequired();
		if (this.iosIsUserInteractionEnabled == null || this.iosIsUserInteractionEnabled == undefined) {
			this.iosIsUserInteractionEnabled = new CommandAttr<boolean>()
		}
		
		this.iosIsUserInteractionEnabled.setGetter(true);
		this.orderGet++;
		this.iosIsUserInteractionEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsUserInteractionEnabled() : boolean {
		if (this.iosIsUserInteractionEnabled == null || this.iosIsUserInteractionEnabled == undefined) {
			this.iosIsUserInteractionEnabled = new CommandAttr<boolean>();
		}
		return this.iosIsUserInteractionEnabled.getCommandReturnValue();
	}
	public setIosIsUserInteractionEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsUserInteractionEnabled == null || this.iosIsUserInteractionEnabled == undefined) {
			this.iosIsUserInteractionEnabled = new CommandAttr<boolean>();
		}
		
		this.iosIsUserInteractionEnabled.setSetter(true);
		this.iosIsUserInteractionEnabled.setValue(value);
		this.orderSet++;
		this.iosIsUserInteractionEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsMultipleTouchEnabled() : T {
		this.resetIfRequired();
		if (this.iosIsMultipleTouchEnabled == null || this.iosIsMultipleTouchEnabled == undefined) {
			this.iosIsMultipleTouchEnabled = new CommandAttr<boolean>()
		}
		
		this.iosIsMultipleTouchEnabled.setGetter(true);
		this.orderGet++;
		this.iosIsMultipleTouchEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsMultipleTouchEnabled() : boolean {
		if (this.iosIsMultipleTouchEnabled == null || this.iosIsMultipleTouchEnabled == undefined) {
			this.iosIsMultipleTouchEnabled = new CommandAttr<boolean>();
		}
		return this.iosIsMultipleTouchEnabled.getCommandReturnValue();
	}
	public setIosIsMultipleTouchEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsMultipleTouchEnabled == null || this.iosIsMultipleTouchEnabled == undefined) {
			this.iosIsMultipleTouchEnabled = new CommandAttr<boolean>();
		}
		
		this.iosIsMultipleTouchEnabled.setSetter(true);
		this.iosIsMultipleTouchEnabled.setValue(value);
		this.orderSet++;
		this.iosIsMultipleTouchEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsExclusiveTouch() : T {
		this.resetIfRequired();
		if (this.iosIsExclusiveTouch == null || this.iosIsExclusiveTouch == undefined) {
			this.iosIsExclusiveTouch = new CommandAttr<boolean>()
		}
		
		this.iosIsExclusiveTouch.setGetter(true);
		this.orderGet++;
		this.iosIsExclusiveTouch.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsExclusiveTouch() : boolean {
		if (this.iosIsExclusiveTouch == null || this.iosIsExclusiveTouch == undefined) {
			this.iosIsExclusiveTouch = new CommandAttr<boolean>();
		}
		return this.iosIsExclusiveTouch.getCommandReturnValue();
	}
	public setIosIsExclusiveTouch(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsExclusiveTouch == null || this.iosIsExclusiveTouch == undefined) {
			this.iosIsExclusiveTouch = new CommandAttr<boolean>();
		}
		
		this.iosIsExclusiveTouch.setSetter(true);
		this.iosIsExclusiveTouch.setValue(value);
		this.orderSet++;
		this.iosIsExclusiveTouch.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosPreservesSuperviewLayoutMargins() : T {
		this.resetIfRequired();
		if (this.iosPreservesSuperviewLayoutMargins == null || this.iosPreservesSuperviewLayoutMargins == undefined) {
			this.iosPreservesSuperviewLayoutMargins = new CommandAttr<boolean>()
		}
		
		this.iosPreservesSuperviewLayoutMargins.setGetter(true);
		this.orderGet++;
		this.iosPreservesSuperviewLayoutMargins.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosPreservesSuperviewLayoutMargins() : boolean {
		if (this.iosPreservesSuperviewLayoutMargins == null || this.iosPreservesSuperviewLayoutMargins == undefined) {
			this.iosPreservesSuperviewLayoutMargins = new CommandAttr<boolean>();
		}
		return this.iosPreservesSuperviewLayoutMargins.getCommandReturnValue();
	}
	public setIosPreservesSuperviewLayoutMargins(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosPreservesSuperviewLayoutMargins == null || this.iosPreservesSuperviewLayoutMargins == undefined) {
			this.iosPreservesSuperviewLayoutMargins = new CommandAttr<boolean>();
		}
		
		this.iosPreservesSuperviewLayoutMargins.setSetter(true);
		this.iosPreservesSuperviewLayoutMargins.setValue(value);
		this.orderSet++;
		this.iosPreservesSuperviewLayoutMargins.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosInsetsLayoutMarginsFromSafeArea() : T {
		this.resetIfRequired();
		if (this.iosInsetsLayoutMarginsFromSafeArea == null || this.iosInsetsLayoutMarginsFromSafeArea == undefined) {
			this.iosInsetsLayoutMarginsFromSafeArea = new CommandAttr<boolean>()
		}
		
		this.iosInsetsLayoutMarginsFromSafeArea.setGetter(true);
		this.orderGet++;
		this.iosInsetsLayoutMarginsFromSafeArea.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosInsetsLayoutMarginsFromSafeArea() : boolean {
		if (this.iosInsetsLayoutMarginsFromSafeArea == null || this.iosInsetsLayoutMarginsFromSafeArea == undefined) {
			this.iosInsetsLayoutMarginsFromSafeArea = new CommandAttr<boolean>();
		}
		return this.iosInsetsLayoutMarginsFromSafeArea.getCommandReturnValue();
	}
	public setIosInsetsLayoutMarginsFromSafeArea(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosInsetsLayoutMarginsFromSafeArea == null || this.iosInsetsLayoutMarginsFromSafeArea == undefined) {
			this.iosInsetsLayoutMarginsFromSafeArea = new CommandAttr<boolean>();
		}
		
		this.iosInsetsLayoutMarginsFromSafeArea.setSetter(true);
		this.iosInsetsLayoutMarginsFromSafeArea.setValue(value);
		this.orderSet++;
		this.iosInsetsLayoutMarginsFromSafeArea.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAutoresizesSubviews() : T {
		this.resetIfRequired();
		if (this.iosAutoresizesSubviews == null || this.iosAutoresizesSubviews == undefined) {
			this.iosAutoresizesSubviews = new CommandAttr<boolean>()
		}
		
		this.iosAutoresizesSubviews.setGetter(true);
		this.orderGet++;
		this.iosAutoresizesSubviews.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAutoresizesSubviews() : boolean {
		if (this.iosAutoresizesSubviews == null || this.iosAutoresizesSubviews == undefined) {
			this.iosAutoresizesSubviews = new CommandAttr<boolean>();
		}
		return this.iosAutoresizesSubviews.getCommandReturnValue();
	}
	public setIosAutoresizesSubviews(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAutoresizesSubviews == null || this.iosAutoresizesSubviews == undefined) {
			this.iosAutoresizesSubviews = new CommandAttr<boolean>();
		}
		
		this.iosAutoresizesSubviews.setSetter(true);
		this.iosAutoresizesSubviews.setValue(value);
		this.orderSet++;
		this.iosAutoresizesSubviews.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosTranslatesAutoresizingMaskIntoConstraints() : T {
		this.resetIfRequired();
		if (this.iosTranslatesAutoresizingMaskIntoConstraints == null || this.iosTranslatesAutoresizingMaskIntoConstraints == undefined) {
			this.iosTranslatesAutoresizingMaskIntoConstraints = new CommandAttr<boolean>()
		}
		
		this.iosTranslatesAutoresizingMaskIntoConstraints.setGetter(true);
		this.orderGet++;
		this.iosTranslatesAutoresizingMaskIntoConstraints.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosTranslatesAutoresizingMaskIntoConstraints() : boolean {
		if (this.iosTranslatesAutoresizingMaskIntoConstraints == null || this.iosTranslatesAutoresizingMaskIntoConstraints == undefined) {
			this.iosTranslatesAutoresizingMaskIntoConstraints = new CommandAttr<boolean>();
		}
		return this.iosTranslatesAutoresizingMaskIntoConstraints.getCommandReturnValue();
	}
	public setIosTranslatesAutoresizingMaskIntoConstraints(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosTranslatesAutoresizingMaskIntoConstraints == null || this.iosTranslatesAutoresizingMaskIntoConstraints == undefined) {
			this.iosTranslatesAutoresizingMaskIntoConstraints = new CommandAttr<boolean>();
		}
		
		this.iosTranslatesAutoresizingMaskIntoConstraints.setSetter(true);
		this.iosTranslatesAutoresizingMaskIntoConstraints.setValue(value);
		this.orderSet++;
		this.iosTranslatesAutoresizingMaskIntoConstraints.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosContentScaleFactor() : T {
		this.resetIfRequired();
		if (this.iosContentScaleFactor == null || this.iosContentScaleFactor == undefined) {
			this.iosContentScaleFactor = new CommandAttr<number>()
		}
		
		this.iosContentScaleFactor.setGetter(true);
		this.orderGet++;
		this.iosContentScaleFactor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosContentScaleFactor() : number {
		if (this.iosContentScaleFactor == null || this.iosContentScaleFactor == undefined) {
			this.iosContentScaleFactor = new CommandAttr<number>();
		}
		return this.iosContentScaleFactor.getCommandReturnValue();
	}
	public setIosContentScaleFactor(value : number) : T {
		this.resetIfRequired();
		if (this.iosContentScaleFactor == null || this.iosContentScaleFactor == undefined) {
			this.iosContentScaleFactor = new CommandAttr<number>();
		}
		
		this.iosContentScaleFactor.setSetter(true);
		this.iosContentScaleFactor.setValue(value);
		this.orderSet++;
		this.iosContentScaleFactor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsFocused() : T {
		this.resetIfRequired();
		if (this.iosIsFocused == null || this.iosIsFocused == undefined) {
			this.iosIsFocused = new CommandAttr<boolean>()
		}
		
		this.iosIsFocused.setGetter(true);
		this.orderGet++;
		this.iosIsFocused.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsFocused() : boolean {
		if (this.iosIsFocused == null || this.iosIsFocused == undefined) {
			this.iosIsFocused = new CommandAttr<boolean>();
		}
		return this.iosIsFocused.getCommandReturnValue();
	}
	
		

	public tryGetIosRestorationIdentifier() : T {
		this.resetIfRequired();
		if (this.iosRestorationIdentifier == null || this.iosRestorationIdentifier == undefined) {
			this.iosRestorationIdentifier = new CommandAttr<string>()
		}
		
		this.iosRestorationIdentifier.setGetter(true);
		this.orderGet++;
		this.iosRestorationIdentifier.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosRestorationIdentifier() : string {
		if (this.iosRestorationIdentifier == null || this.iosRestorationIdentifier == undefined) {
			this.iosRestorationIdentifier = new CommandAttr<string>();
		}
		return this.iosRestorationIdentifier.getCommandReturnValue();
	}
	public setIosRestorationIdentifier(value : string) : T {
		this.resetIfRequired();
		if (this.iosRestorationIdentifier == null || this.iosRestorationIdentifier == undefined) {
			this.iosRestorationIdentifier = new CommandAttr<string>();
		}
		
		this.iosRestorationIdentifier.setSetter(true);
		this.iosRestorationIdentifier.setValue(value);
		this.orderSet++;
		this.iosRestorationIdentifier.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosTag() : T {
		this.resetIfRequired();
		if (this.iosTag == null || this.iosTag == undefined) {
			this.iosTag = new CommandAttr<number>()
		}
		
		this.iosTag.setGetter(true);
		this.orderGet++;
		this.iosTag.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosTag() : number {
		if (this.iosTag == null || this.iosTag == undefined) {
			this.iosTag = new CommandAttr<number>();
		}
		return this.iosTag.getCommandReturnValue();
	}
	public setIosTag(value : number) : T {
		this.resetIfRequired();
		if (this.iosTag == null || this.iosTag == undefined) {
			this.iosTag = new CommandAttr<number>();
		}
		
		this.iosTag.setSetter(true);
		this.iosTag.setValue(value);
		this.orderSet++;
		this.iosTag.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAccessibilityIgnoresInvertColors() : T {
		this.resetIfRequired();
		if (this.iosAccessibilityIgnoresInvertColors == null || this.iosAccessibilityIgnoresInvertColors == undefined) {
			this.iosAccessibilityIgnoresInvertColors = new CommandAttr<boolean>()
		}
		
		this.iosAccessibilityIgnoresInvertColors.setGetter(true);
		this.orderGet++;
		this.iosAccessibilityIgnoresInvertColors.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAccessibilityIgnoresInvertColors() : boolean {
		if (this.iosAccessibilityIgnoresInvertColors == null || this.iosAccessibilityIgnoresInvertColors == undefined) {
			this.iosAccessibilityIgnoresInvertColors = new CommandAttr<boolean>();
		}
		return this.iosAccessibilityIgnoresInvertColors.getCommandReturnValue();
	}
	public setIosAccessibilityIgnoresInvertColors(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAccessibilityIgnoresInvertColors == null || this.iosAccessibilityIgnoresInvertColors == undefined) {
			this.iosAccessibilityIgnoresInvertColors = new CommandAttr<boolean>();
		}
		
		this.iosAccessibilityIgnoresInvertColors.setSetter(true);
		this.iosAccessibilityIgnoresInvertColors.setValue(value);
		this.orderSet++;
		this.iosAccessibilityIgnoresInvertColors.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosLargeContentImage() : T {
		this.resetIfRequired();
		if (this.iosLargeContentImage == null || this.iosLargeContentImage == undefined) {
			this.iosLargeContentImage = new CommandAttr<string>()
		}
		
		this.iosLargeContentImage.setGetter(true);
		this.orderGet++;
		this.iosLargeContentImage.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosLargeContentImage() : string {
		if (this.iosLargeContentImage == null || this.iosLargeContentImage == undefined) {
			this.iosLargeContentImage = new CommandAttr<string>();
		}
		return this.iosLargeContentImage.getCommandReturnValue();
	}
	public setIosLargeContentImage(value : string) : T {
		this.resetIfRequired();
		if (this.iosLargeContentImage == null || this.iosLargeContentImage == undefined) {
			this.iosLargeContentImage = new CommandAttr<string>();
		}
		
		this.iosLargeContentImage.setSetter(true);
		this.iosLargeContentImage.setValue(value);
		this.orderSet++;
		this.iosLargeContentImage.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosLargeContentTitle() : T {
		this.resetIfRequired();
		if (this.iosLargeContentTitle == null || this.iosLargeContentTitle == undefined) {
			this.iosLargeContentTitle = new CommandAttr<string>()
		}
		
		this.iosLargeContentTitle.setGetter(true);
		this.orderGet++;
		this.iosLargeContentTitle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosLargeContentTitle() : string {
		if (this.iosLargeContentTitle == null || this.iosLargeContentTitle == undefined) {
			this.iosLargeContentTitle = new CommandAttr<string>();
		}
		return this.iosLargeContentTitle.getCommandReturnValue();
	}
	public setIosLargeContentTitle(value : string) : T {
		this.resetIfRequired();
		if (this.iosLargeContentTitle == null || this.iosLargeContentTitle == undefined) {
			this.iosLargeContentTitle = new CommandAttr<string>();
		}
		
		this.iosLargeContentTitle.setSetter(true);
		this.iosLargeContentTitle.setValue(value);
		this.orderSet++;
		this.iosLargeContentTitle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosScalesLargeContentImage() : T {
		this.resetIfRequired();
		if (this.iosScalesLargeContentImage == null || this.iosScalesLargeContentImage == undefined) {
			this.iosScalesLargeContentImage = new CommandAttr<boolean>()
		}
		
		this.iosScalesLargeContentImage.setGetter(true);
		this.orderGet++;
		this.iosScalesLargeContentImage.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosScalesLargeContentImage() : boolean {
		if (this.iosScalesLargeContentImage == null || this.iosScalesLargeContentImage == undefined) {
			this.iosScalesLargeContentImage = new CommandAttr<boolean>();
		}
		return this.iosScalesLargeContentImage.getCommandReturnValue();
	}
	public setIosScalesLargeContentImage(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosScalesLargeContentImage == null || this.iosScalesLargeContentImage == undefined) {
			this.iosScalesLargeContentImage = new CommandAttr<boolean>();
		}
		
		this.iosScalesLargeContentImage.setSetter(true);
		this.iosScalesLargeContentImage.setValue(value);
		this.orderSet++;
		this.iosScalesLargeContentImage.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosShowsLargeContentViewer() : T {
		this.resetIfRequired();
		if (this.iosShowsLargeContentViewer == null || this.iosShowsLargeContentViewer == undefined) {
			this.iosShowsLargeContentViewer = new CommandAttr<boolean>()
		}
		
		this.iosShowsLargeContentViewer.setGetter(true);
		this.orderGet++;
		this.iosShowsLargeContentViewer.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosShowsLargeContentViewer() : boolean {
		if (this.iosShowsLargeContentViewer == null || this.iosShowsLargeContentViewer == undefined) {
			this.iosShowsLargeContentViewer = new CommandAttr<boolean>();
		}
		return this.iosShowsLargeContentViewer.getCommandReturnValue();
	}
	public setIosShowsLargeContentViewer(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosShowsLargeContentViewer == null || this.iosShowsLargeContentViewer == undefined) {
			this.iosShowsLargeContentViewer = new CommandAttr<boolean>();
		}
		
		this.iosShowsLargeContentViewer.setSetter(true);
		this.iosShowsLargeContentViewer.setValue(value);
		this.orderSet++;
		this.iosShowsLargeContentViewer.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsAccessibilityElement() : T {
		this.resetIfRequired();
		if (this.iosIsAccessibilityElement == null || this.iosIsAccessibilityElement == undefined) {
			this.iosIsAccessibilityElement = new CommandAttr<boolean>()
		}
		
		this.iosIsAccessibilityElement.setGetter(true);
		this.orderGet++;
		this.iosIsAccessibilityElement.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsAccessibilityElement() : boolean {
		if (this.iosIsAccessibilityElement == null || this.iosIsAccessibilityElement == undefined) {
			this.iosIsAccessibilityElement = new CommandAttr<boolean>();
		}
		return this.iosIsAccessibilityElement.getCommandReturnValue();
	}
	public setIosIsAccessibilityElement(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsAccessibilityElement == null || this.iosIsAccessibilityElement == undefined) {
			this.iosIsAccessibilityElement = new CommandAttr<boolean>();
		}
		
		this.iosIsAccessibilityElement.setSetter(true);
		this.iosIsAccessibilityElement.setValue(value);
		this.orderSet++;
		this.iosIsAccessibilityElement.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetFocusable() : T {
		this.resetIfRequired();
		if (this.iosIsAccessibilityElement == null || this.iosIsAccessibilityElement == undefined) {
			this.iosIsAccessibilityElement = new CommandAttr<boolean>()
		}
		
		this.iosIsAccessibilityElement.setGetter(true);
		this.orderGet++;
		this.iosIsAccessibilityElement.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getFocusable() : boolean {
		if (this.iosIsAccessibilityElement == null || this.iosIsAccessibilityElement == undefined) {
			this.iosIsAccessibilityElement = new CommandAttr<boolean>();
		}
		return this.iosIsAccessibilityElement.getCommandReturnValue();
	}
	public setFocusable(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsAccessibilityElement == null || this.iosIsAccessibilityElement == undefined) {
			this.iosIsAccessibilityElement = new CommandAttr<boolean>();
		}
		
		this.iosIsAccessibilityElement.setSetter(true);
		this.iosIsAccessibilityElement.setValue(value);
		this.orderSet++;
		this.iosIsAccessibilityElement.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAccessibilityLabel() : T {
		this.resetIfRequired();
		if (this.iosAccessibilityLabel == null || this.iosAccessibilityLabel == undefined) {
			this.iosAccessibilityLabel = new CommandAttr<string>()
		}
		
		this.iosAccessibilityLabel.setGetter(true);
		this.orderGet++;
		this.iosAccessibilityLabel.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosAccessibilityLabel() : string {
		if (this.iosAccessibilityLabel == null || this.iosAccessibilityLabel == undefined) {
			this.iosAccessibilityLabel = new CommandAttr<string>();
		}
		return this.iosAccessibilityLabel.getCommandReturnValue();
	}
	public setIosAccessibilityLabel(value : string) : T {
		this.resetIfRequired();
		if (this.iosAccessibilityLabel == null || this.iosAccessibilityLabel == undefined) {
			this.iosAccessibilityLabel = new CommandAttr<string>();
		}
		
		this.iosAccessibilityLabel.setSetter(true);
		this.iosAccessibilityLabel.setValue(value);
		this.orderSet++;
		this.iosAccessibilityLabel.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAccessibilityHint() : T {
		this.resetIfRequired();
		if (this.iosAccessibilityHint == null || this.iosAccessibilityHint == undefined) {
			this.iosAccessibilityHint = new CommandAttr<string>()
		}
		
		this.iosAccessibilityHint.setGetter(true);
		this.orderGet++;
		this.iosAccessibilityHint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosAccessibilityHint() : string {
		if (this.iosAccessibilityHint == null || this.iosAccessibilityHint == undefined) {
			this.iosAccessibilityHint = new CommandAttr<string>();
		}
		return this.iosAccessibilityHint.getCommandReturnValue();
	}
	public setIosAccessibilityHint(value : string) : T {
		this.resetIfRequired();
		if (this.iosAccessibilityHint == null || this.iosAccessibilityHint == undefined) {
			this.iosAccessibilityHint = new CommandAttr<string>();
		}
		
		this.iosAccessibilityHint.setSetter(true);
		this.iosAccessibilityHint.setValue(value);
		this.orderSet++;
		this.iosAccessibilityHint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetContentDescription() : T {
		this.resetIfRequired();
		if (this.iosAccessibilityHint == null || this.iosAccessibilityHint == undefined) {
			this.iosAccessibilityHint = new CommandAttr<string>()
		}
		
		this.iosAccessibilityHint.setGetter(true);
		this.orderGet++;
		this.iosAccessibilityHint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getContentDescription() : string {
		if (this.iosAccessibilityHint == null || this.iosAccessibilityHint == undefined) {
			this.iosAccessibilityHint = new CommandAttr<string>();
		}
		return this.iosAccessibilityHint.getCommandReturnValue();
	}
	public setContentDescription(value : string) : T {
		this.resetIfRequired();
		if (this.iosAccessibilityHint == null || this.iosAccessibilityHint == undefined) {
			this.iosAccessibilityHint = new CommandAttr<string>();
		}
		
		this.iosAccessibilityHint.setSetter(true);
		this.iosAccessibilityHint.setValue(value);
		this.orderSet++;
		this.iosAccessibilityHint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAccessibilityValue() : T {
		this.resetIfRequired();
		if (this.iosAccessibilityValue == null || this.iosAccessibilityValue == undefined) {
			this.iosAccessibilityValue = new CommandAttr<string>()
		}
		
		this.iosAccessibilityValue.setGetter(true);
		this.orderGet++;
		this.iosAccessibilityValue.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosAccessibilityValue() : string {
		if (this.iosAccessibilityValue == null || this.iosAccessibilityValue == undefined) {
			this.iosAccessibilityValue = new CommandAttr<string>();
		}
		return this.iosAccessibilityValue.getCommandReturnValue();
	}
	public setIosAccessibilityValue(value : string) : T {
		this.resetIfRequired();
		if (this.iosAccessibilityValue == null || this.iosAccessibilityValue == undefined) {
			this.iosAccessibilityValue = new CommandAttr<string>();
		}
		
		this.iosAccessibilityValue.setSetter(true);
		this.iosAccessibilityValue.setValue(value);
		this.orderSet++;
		this.iosAccessibilityValue.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAccessibilityTraits() : T {
		this.resetIfRequired();
		if (this.iosAccessibilityTraits == null || this.iosAccessibilityTraits == undefined) {
			this.iosAccessibilityTraits = new CommandAttr<IosAccessibilityTraits>()
		}
		
		this.iosAccessibilityTraits.setGetter(true);
		this.orderGet++;
		this.iosAccessibilityTraits.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosAccessibilityTraits() : IosAccessibilityTraits {
		if (this.iosAccessibilityTraits == null || this.iosAccessibilityTraits == undefined) {
			this.iosAccessibilityTraits = new CommandAttr<IosAccessibilityTraits>();
		}
		return this.iosAccessibilityTraits.getCommandReturnValue();
	}
	public setIosAccessibilityTraits(value : IosAccessibilityTraits) : T {
		this.resetIfRequired();
		if (this.iosAccessibilityTraits == null || this.iosAccessibilityTraits == undefined) {
			this.iosAccessibilityTraits = new CommandAttr<IosAccessibilityTraits>();
		}
		
		this.iosAccessibilityTraits.setSetter(true);
		this.iosAccessibilityTraits.setValue(value);
		this.orderSet++;
		this.iosAccessibilityTraits.setOrderSet(this.orderSet);
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
		

	public tryGetBackgroundTint() : T {
		this.resetIfRequired();
		if (this.backgroundTint == null || this.backgroundTint == undefined) {
			this.backgroundTint = new CommandAttr<string>()
		}
		
		this.backgroundTint.setGetter(true);
		this.orderGet++;
		this.backgroundTint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBackgroundTint() : string {
		if (this.backgroundTint == null || this.backgroundTint == undefined) {
			this.backgroundTint = new CommandAttr<string>();
		}
		return this.backgroundTint.getCommandReturnValue();
	}
	public setBackgroundTint(value : string) : T {
		this.resetIfRequired();
		if (this.backgroundTint == null || this.backgroundTint == undefined) {
			this.backgroundTint = new CommandAttr<string>();
		}
		
		this.backgroundTint.setSetter(true);
		this.backgroundTint.setValue(value);
		this.orderSet++;
		this.backgroundTint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBackgroundTintMode() : T {
		this.resetIfRequired();
		if (this.backgroundTintMode == null || this.backgroundTintMode == undefined) {
			this.backgroundTintMode = new CommandAttr<BackgroundTintMode>()
		}
		
		this.backgroundTintMode.setGetter(true);
		this.orderGet++;
		this.backgroundTintMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBackgroundTintMode() : BackgroundTintMode {
		if (this.backgroundTintMode == null || this.backgroundTintMode == undefined) {
			this.backgroundTintMode = new CommandAttr<BackgroundTintMode>();
		}
		return this.backgroundTintMode.getCommandReturnValue();
	}
	public setBackgroundTintMode(value : BackgroundTintMode) : T {
		this.resetIfRequired();
		if (this.backgroundTintMode == null || this.backgroundTintMode == undefined) {
			this.backgroundTintMode = new CommandAttr<BackgroundTintMode>();
		}
		
		this.backgroundTintMode.setSetter(true);
		this.backgroundTintMode.setValue(value);
		this.orderSet++;
		this.backgroundTintMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetForeground() : T {
		this.resetIfRequired();
		if (this.foreground == null || this.foreground == undefined) {
			this.foreground = new CommandAttr<string>()
		}
		
		this.foreground.setGetter(true);
		this.orderGet++;
		this.foreground.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getForeground() : string {
		if (this.foreground == null || this.foreground == undefined) {
			this.foreground = new CommandAttr<string>();
		}
		return this.foreground.getCommandReturnValue();
	}
	public setForeground(value : string) : T {
		this.resetIfRequired();
		if (this.foreground == null || this.foreground == undefined) {
			this.foreground = new CommandAttr<string>();
		}
		
		this.foreground.setSetter(true);
		this.foreground.setValue(value);
		this.orderSet++;
		this.foreground.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setForegroundRepeat(value : ForegroundRepeat) : T {
		this.resetIfRequired();
		if (this.foregroundRepeat == null || this.foregroundRepeat == undefined) {
			this.foregroundRepeat = new CommandAttr<ForegroundRepeat>();
		}
		
		this.foregroundRepeat.setSetter(true);
		this.foregroundRepeat.setValue(value);
		this.orderSet++;
		this.foregroundRepeat.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetForegroundTint() : T {
		this.resetIfRequired();
		if (this.foregroundTint == null || this.foregroundTint == undefined) {
			this.foregroundTint = new CommandAttr<string>()
		}
		
		this.foregroundTint.setGetter(true);
		this.orderGet++;
		this.foregroundTint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getForegroundTint() : string {
		if (this.foregroundTint == null || this.foregroundTint == undefined) {
			this.foregroundTint = new CommandAttr<string>();
		}
		return this.foregroundTint.getCommandReturnValue();
	}
	public setForegroundTint(value : string) : T {
		this.resetIfRequired();
		if (this.foregroundTint == null || this.foregroundTint == undefined) {
			this.foregroundTint = new CommandAttr<string>();
		}
		
		this.foregroundTint.setSetter(true);
		this.foregroundTint.setValue(value);
		this.orderSet++;
		this.foregroundTint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetForegroundTintMode() : T {
		this.resetIfRequired();
		if (this.foregroundTintMode == null || this.foregroundTintMode == undefined) {
			this.foregroundTintMode = new CommandAttr<ForegroundTintMode>()
		}
		
		this.foregroundTintMode.setGetter(true);
		this.orderGet++;
		this.foregroundTintMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getForegroundTintMode() : ForegroundTintMode {
		if (this.foregroundTintMode == null || this.foregroundTintMode == undefined) {
			this.foregroundTintMode = new CommandAttr<ForegroundTintMode>();
		}
		return this.foregroundTintMode.getCommandReturnValue();
	}
	public setForegroundTintMode(value : ForegroundTintMode) : T {
		this.resetIfRequired();
		if (this.foregroundTintMode == null || this.foregroundTintMode == undefined) {
			this.foregroundTintMode = new CommandAttr<ForegroundTintMode>();
		}
		
		this.foregroundTintMode.setSetter(true);
		this.foregroundTintMode.setValue(value);
		this.orderSet++;
		this.foregroundTintMode.setOrderSet(this.orderSet);
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
		

	public tryGetTransformPivotX() : T {
		this.resetIfRequired();
		if (this.transformPivotX == null || this.transformPivotX == undefined) {
			this.transformPivotX = new CommandAttr<string>()
		}
		
		this.transformPivotX.setGetter(true);
		this.orderGet++;
		this.transformPivotX.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTransformPivotX() : string {
		if (this.transformPivotX == null || this.transformPivotX == undefined) {
			this.transformPivotX = new CommandAttr<string>();
		}
		return this.transformPivotX.getCommandReturnValue();
	}
	public setTransformPivotX(value : string) : T {
		this.resetIfRequired();
		if (this.transformPivotX == null || this.transformPivotX == undefined) {
			this.transformPivotX = new CommandAttr<string>();
		}
		
		this.transformPivotX.setSetter(true);
		this.transformPivotX.setValue(value);
		this.orderSet++;
		this.transformPivotX.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTransformPivotY() : T {
		this.resetIfRequired();
		if (this.transformPivotY == null || this.transformPivotY == undefined) {
			this.transformPivotY = new CommandAttr<string>()
		}
		
		this.transformPivotY.setGetter(true);
		this.orderGet++;
		this.transformPivotY.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTransformPivotY() : string {
		if (this.transformPivotY == null || this.transformPivotY == undefined) {
			this.transformPivotY = new CommandAttr<string>();
		}
		return this.transformPivotY.getCommandReturnValue();
	}
	public setTransformPivotY(value : string) : T {
		this.resetIfRequired();
		if (this.transformPivotY == null || this.transformPivotY == undefined) {
			this.transformPivotY = new CommandAttr<string>();
		}
		
		this.transformPivotY.setSetter(true);
		this.transformPivotY.setValue(value);
		this.orderSet++;
		this.transformPivotY.setOrderSet(this.orderSet);
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
		

	public tryGetKeepScreenOn() : T {
		this.resetIfRequired();
		if (this.keepScreenOn == null || this.keepScreenOn == undefined) {
			this.keepScreenOn = new CommandAttr<boolean>()
		}
		
		this.keepScreenOn.setGetter(true);
		this.orderGet++;
		this.keepScreenOn.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isKeepScreenOn() : boolean {
		if (this.keepScreenOn == null || this.keepScreenOn == undefined) {
			this.keepScreenOn = new CommandAttr<boolean>();
		}
		return this.keepScreenOn.getCommandReturnValue();
	}
	public setKeepScreenOn(value : boolean) : T {
		this.resetIfRequired();
		if (this.keepScreenOn == null || this.keepScreenOn == undefined) {
			this.keepScreenOn = new CommandAttr<boolean>();
		}
		
		this.keepScreenOn.setSetter(true);
		this.keepScreenOn.setValue(value);
		this.orderSet++;
		this.keepScreenOn.setOrderSet(this.orderSet);
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
		

	public tryGetForegroundGravity() : T {
		this.resetIfRequired();
		if (this.foregroundGravity == null || this.foregroundGravity == undefined) {
			this.foregroundGravity = new CommandAttr<Gravity[]>()
		}
		
		this.foregroundGravity.setGetter(true);
		this.orderGet++;
		this.foregroundGravity.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getForegroundGravity() : Gravity[] {
		if (this.foregroundGravity == null || this.foregroundGravity == undefined) {
			this.foregroundGravity = new CommandAttr<Gravity[]>();
		}
this.foregroundGravity.setTransformer('gravity');		return this.foregroundGravity.getCommandReturnValue();
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
		

	public setIosLayerBorderWidth(value : string) : T {
		this.resetIfRequired();
		if (this.iosLayerBorderWidth == null || this.iosLayerBorderWidth == undefined) {
			this.iosLayerBorderWidth = new CommandAttr<string>();
		}
		
		this.iosLayerBorderWidth.setSetter(true);
		this.iosLayerBorderWidth.setValue(value);
		this.orderSet++;
		this.iosLayerBorderWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setIosLayerBorderColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosLayerBorderColor == null || this.iosLayerBorderColor == undefined) {
			this.iosLayerBorderColor = new CommandAttr<string>();
		}
		
		this.iosLayerBorderColor.setSetter(true);
		this.iosLayerBorderColor.setValue(value);
		this.orderSet++;
		this.iosLayerBorderColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setIosLayerCornerRadius(value : string) : T {
		this.resetIfRequired();
		if (this.iosLayerCornerRadius == null || this.iosLayerCornerRadius == undefined) {
			this.iosLayerCornerRadius = new CommandAttr<string>();
		}
		
		this.iosLayerCornerRadius.setSetter(true);
		this.iosLayerCornerRadius.setValue(value);
		this.orderSet++;
		this.iosLayerCornerRadius.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setIosLayerMasksToBounds(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosLayerMasksToBounds == null || this.iosLayerMasksToBounds == undefined) {
			this.iosLayerMasksToBounds = new CommandAttr<boolean>();
		}
		
		this.iosLayerMasksToBounds.setSetter(true);
		this.iosLayerMasksToBounds.setValue(value);
		this.orderSet++;
		this.iosLayerMasksToBounds.setOrderSet(this.orderSet);
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
