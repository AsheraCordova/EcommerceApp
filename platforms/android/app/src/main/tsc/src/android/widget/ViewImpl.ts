// start - imports

export const enum AccessibilityLiveRegion {
assertive = "assertive",
none = "none",
polite = "polite",
}
export const enum BackgroundTintMode {
add = "add",
multiply = "multiply",
screen = "screen",
src_atop = "src_atop",
src_in = "src_in",
src_over = "src_over",
}
export const enum ForegroundTintMode {
add = "add",
multiply = "multiply",
screen = "screen",
src_atop = "src_atop",
src_in = "src_in",
src_over = "src_over",
}
export const enum ImportantForAccessibility {
auto = "auto",
no = "no",
noHideDescendants = "noHideDescendants",
yes = "yes",
}
export const enum ImportantForAutofill {
auto = "auto",
no = "no",
noExcludeDescendants = "noExcludeDescendants",
yes = "yes",
yesExcludeDescendants = "yesExcludeDescendants",
}
export const enum LayoutDirection {
inherit = "inherit",
locale = "locale",
ltr = "ltr",
rtl = "rtl",
}
export const enum ScrollIndicators {
bottom = "bottom",
end = "end",
left = "left",
none = "none",
right = "right",
start = "start",
top = "top",
}
export const enum ScrollbarStyle {
insideInset = "insideInset",
insideOverlay = "insideOverlay",
outsideInset = "outsideInset",
outsideOverlay = "outsideOverlay",
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
export const enum Visibility {
gone = "gone",
invisible = "invisible",
visible = "visible",
}
export const enum LayerType {
hardware = "hardware",
none = "none",
software = "software",
}
export const enum RequiresFadingEdge {
horizontal = "horizontal",
none = "none",
vertical = "vertical",
}
export const enum BackgroundRepeat {
no_repeat = "no-repeat",
repeat = "repeat",
}
export const enum ForegroundRepeat {
no_repeat = "no-repeat",
repeat = "repeat",
}
export const enum HapticFeedbackConstants {
LONG_PRESS = "LONG_PRESS",
VIRTUAL_KEY = "VIRTUAL_KEY",
KEYBOARD_TAP = "KEYBOARD_TAP",
CLOCK_TICK = "CLOCK_TICK",
CONTEXT_CLICK = "CONTEXT_CLICK",
KEYBOARD_PRESS = "KEYBOARD_PRESS",
KEYBOARD_RELEASE = "KEYBOARD_RELEASE",
VIRTUAL_KEY_RELEASE = "VIRTUAL_KEY_RELEASE",
TEXT_HANDLE_MOVE = "TEXT_HANDLE_MOVE",
}
export const enum HapticFeedbackConstantsFlag {
FLAG_IGNORE_VIEW_SETTING = "FLAG_IGNORE_VIEW_SETTING",
FLAG_IGNORE_GLOBAL_SETTING = "FLAG_IGNORE_GLOBAL_SETTING",
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





























export class ImportantForAutofillTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<ImportantForAutofill> = new Array<ImportantForAutofill>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "auto":
						valueArr.push(ImportantForAutofill.auto);
                       	break;	
					case "no":
						valueArr.push(ImportantForAutofill.no);
                       	break;	
					case "noExcludeDescendants":
						valueArr.push(ImportantForAutofill.noExcludeDescendants);
                       	break;	
					case "yes":
						valueArr.push(ImportantForAutofill.yes);
                       	break;	
					case "yesExcludeDescendants":
						valueArr.push(ImportantForAutofill.yesExcludeDescendants);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}























export class ScrollIndicatorsTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<ScrollIndicators> = new Array<ScrollIndicators>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "bottom":
						valueArr.push(ScrollIndicators.bottom);
                       	break;	
					case "end":
						valueArr.push(ScrollIndicators.end);
                       	break;	
					case "left":
						valueArr.push(ScrollIndicators.left);
                       	break;	
					case "none":
						valueArr.push(ScrollIndicators.none);
                       	break;	
					case "right":
						valueArr.push(ScrollIndicators.right);
                       	break;	
					case "start":
						valueArr.push(ScrollIndicators.start);
                       	break;	
					case "top":
						valueArr.push(ScrollIndicators.top);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}








































export class RequiresFadingEdgeTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<RequiresFadingEdge> = new Array<RequiresFadingEdge>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "horizontal":
						valueArr.push(RequiresFadingEdge.horizontal);
                       	break;	
					case "none":
						valueArr.push(RequiresFadingEdge.none);
                       	break;	
					case "vertical":
						valueArr.push(RequiresFadingEdge.vertical);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}















export class ViewImpl_performHapticFeedbackWithFlags {
@Expose({ name: "value" })
value!:HapticFeedbackConstants;
@Expose({ name: "flags" })
@Transform(({value, obj, type}) => TransformerFactory.getInstance().transform(value, obj, type, "HapticFeedbackConstantsFlag"))
flags!:HapticFeedbackConstantsFlag[];
}
export class HapticFeedbackConstantsFlagTransformer implements ITranform {
transform(value: any, obj: any, type: number) : any{
if (type == 1) {
return value.toString().replace(",", "|");
} else {
let strArray:Array<string> = value.toString().split("|");
let valueArr:Array<HapticFeedbackConstantsFlag> = new Array<HapticFeedbackConstantsFlag>();
for (let i =0; i < strArray.length; i++) {
switch(strArray[i]) {
case "FLAG_IGNORE_VIEW_SETTING":
valueArr.push(HapticFeedbackConstantsFlag.FLAG_IGNORE_VIEW_SETTING);
break;
case "FLAG_IGNORE_GLOBAL_SETTING":
valueArr.push(HapticFeedbackConstantsFlag.FLAG_IGNORE_GLOBAL_SETTING);
break;
}
}
return valueArr;
}
}
}
























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
		TransformerFactory.getInstance().register("importantForAutofill", new ImportantForAutofillTransformer());
		TransformerFactory.getInstance().register("scrollIndicators", new ScrollIndicatorsTransformer());
		TransformerFactory.getInstance().register("requiresFadingEdge", new RequiresFadingEdgeTransformer());
		TransformerFactory.getInstance().register("HapticFeedbackConstantsFlag", new HapticFeedbackConstantsFlagTransformer());
		TransformerFactory.getInstance().register("validationErrorDisplay", new ValidationErrorDisplayTransformer());
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "accessibilityHeading" })
	accessibilityHeading!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "accessibilityLiveRegion" })
	accessibilityLiveRegion!:CommandAttr<AccessibilityLiveRegion>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "accessibilityPaneTitle" })
	accessibilityPaneTitle!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "accessibilityTraversalAfter" })
	accessibilityTraversalAfter!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "accessibilityTraversalBefore" })
	accessibilityTraversalBefore!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "alpha" })
	alpha!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "autofillHints" })
	autofillHints!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundTint" })
	backgroundTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundTintMode" })
	backgroundTintMode!:CommandAttr<BackgroundTintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "clickable" })
	clickable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "contentDescription" })
	contentDescription!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "contextClickable" })
	contextClickable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "defaultFocusHighlightEnabled" })
	defaultFocusHighlightEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "duplicateParentState" })
	duplicateParentState!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "elevation" })
	elevation!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "fadeScrollbars" })
	fadeScrollbars!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "fadingEdgeLength" })
	fadingEdgeLength!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "filterTouchesWhenObscured" })
	filterTouchesWhenObscured!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "fitsSystemWindows" })
	fitsSystemWindows!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "focusableInTouchMode" })
	focusableInTouchMode!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "focusedByDefault" })
	focusedByDefault!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "forceHasOverlappingRendering" })
	forceHasOverlappingRendering!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundTint" })
	foregroundTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundTintMode" })
	foregroundTintMode!:CommandAttr<ForegroundTintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "hapticFeedbackEnabled" })
	hapticFeedbackEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "importantForAccessibility" })
	importantForAccessibility!:CommandAttr<ImportantForAccessibility>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "importantForAutofill" })
	importantForAutofill!:CommandAttr<ImportantForAutofill[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "isScrollContainer" })
	isScrollContainer!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "keepScreenOn" })
	keepScreenOn!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "keyboardNavigationCluster" })
	keyboardNavigationCluster!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layoutDirection" })
	layoutDirection!:CommandAttr<LayoutDirection>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "longClickable" })
	longClickable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minHeight" })
	minHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minWidth" })
	minWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "nextClusterForward" })
	nextClusterForward!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "nextFocusDown" })
	nextFocusDown!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "nextFocusForward" })
	nextFocusForward!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "nextFocusLeft" })
	nextFocusLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "nextFocusRight" })
	nextFocusRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "nextFocusUp" })
	nextFocusUp!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "outlineAmbientShadowColor" })
	outlineAmbientShadowColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "outlineSpotShadowColor" })
	outlineSpotShadowColor!:CommandAttr<string>| undefined;
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
	@Expose({ name: "saveEnabled" })
	saveEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scaleX" })
	scaleX!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scaleY" })
	scaleY!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "screenReaderFocusable" })
	screenReaderFocusable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollIndicators" })
	scrollIndicators!:CommandAttr<ScrollIndicators[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollbarDefaultDelayBeforeFade" })
	scrollbarDefaultDelayBeforeFade!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollbarFadeDuration" })
	scrollbarFadeDuration!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollbarSize" })
	scrollbarSize!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollbarStyle" })
	scrollbarStyle!:CommandAttr<ScrollbarStyle>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "soundEffectsEnabled" })
	soundEffectsEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textAlignment" })
	textAlignment!:CommandAttr<TextAlignment>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textDirection" })
	textDirection!:CommandAttr<TextDirection>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "tooltipText" })
	tooltipText!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "transformPivotX" })
	transformPivotX!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "transformPivotY" })
	transformPivotY!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "transitionName" })
	transitionName!:CommandAttr<string>| undefined;
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
	@Expose({ name: "visibility" })
	visibility!:CommandAttr<Visibility>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onApplyWindowInsets" })
	onApplyWindowInsets!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onCapturedPointer" })
	onCapturedPointer!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onClick" })
	onClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onContextClick" })
	onContextClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onCreateContextMenu" })
	onCreateContextMenu!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onDrag" })
	onDrag!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onFocusChange" })
	onFocusChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onGenericMotion" })
	onGenericMotion!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onHover" })
	onHover!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onKey" })
	onKey!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onLongClick" })
	onLongClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onScrollChange" })
	onScrollChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onSystemUiVisibilityChange" })
	onSystemUiVisibilityChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onTouch" })
	onTouch!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "padding" })
	padding!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingTop" })
	paddingTop!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingBottom" })
	paddingBottom!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingLeft" })
	paddingLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingRight" })
	paddingRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingStart" })
	paddingStart!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingEnd" })
	paddingEnd!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingHorizontal" })
	paddingHorizontal!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "paddingVertical" })
	paddingVertical!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layerType" })
	layerType!:CommandAttr<LayerType>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "requiresFadingEdge" })
	requiresFadingEdge!:CommandAttr<RequiresFadingEdge[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "background" })
	background!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foreground" })
	foreground!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "backgroundRepeat" })
	backgroundRepeat!:CommandAttr<BackgroundRepeat>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelSyncEvents" })
	modelSyncEvents!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "updateModelData" })
	updateModelData_!:CommandAttr<ScopedObject|ScopedObject[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "notifyDataSetChanged" })
	notifyDataSetChanged_!:CommandAttr<boolean>| undefined;
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
	@Expose({ name: "foregroundRepeat" })
	foregroundRepeat!:CommandAttr<ForegroundRepeat>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "foregroundGravity" })
	foregroundGravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "performHapticFeedback" })
	performHapticFeedback_!:CommandAttr<HapticFeedbackConstants>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "performHapticFeedbackWithFlags" })
	performHapticFeedbackWithFlags_!:CommandAttr<ViewImpl_performHapticFeedbackWithFlags>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "attributeUnderTest" })
	attributeUnderTest!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "selected" })
	selected!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "enabled" })
	enabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "focusable" })
	focusable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollX" })
	scrollX!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollY" })
	scrollY!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "invalidate" })
	invalidate_!:CommandAttr<void>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "requestLayout" })
	requestLayout_!:CommandAttr<void>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "asDragSource" })
	asDragSource!:CommandAttr<string>| undefined;
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
		this.accessibilityHeading = undefined;
		this.accessibilityLiveRegion = undefined;
		this.accessibilityPaneTitle = undefined;
		this.accessibilityTraversalAfter = undefined;
		this.accessibilityTraversalBefore = undefined;
		this.alpha = undefined;
		this.autofillHints = undefined;
		this.backgroundTint = undefined;
		this.backgroundTintMode = undefined;
		this.clickable = undefined;
		this.contentDescription = undefined;
		this.contextClickable = undefined;
		this.defaultFocusHighlightEnabled = undefined;
		this.duplicateParentState = undefined;
		this.elevation = undefined;
		this.fadeScrollbars = undefined;
		this.fadingEdgeLength = undefined;
		this.filterTouchesWhenObscured = undefined;
		this.fitsSystemWindows = undefined;
		this.focusableInTouchMode = undefined;
		this.focusedByDefault = undefined;
		this.forceHasOverlappingRendering = undefined;
		this.foregroundTint = undefined;
		this.foregroundTintMode = undefined;
		this.hapticFeedbackEnabled = undefined;
		this.importantForAccessibility = undefined;
		this.importantForAutofill = undefined;
		this.isScrollContainer = undefined;
		this.keepScreenOn = undefined;
		this.keyboardNavigationCluster = undefined;
		this.layoutDirection = undefined;
		this.longClickable = undefined;
		this.minHeight = undefined;
		this.minWidth = undefined;
		this.nextClusterForward = undefined;
		this.nextFocusDown = undefined;
		this.nextFocusForward = undefined;
		this.nextFocusLeft = undefined;
		this.nextFocusRight = undefined;
		this.nextFocusUp = undefined;
		this.outlineAmbientShadowColor = undefined;
		this.outlineSpotShadowColor = undefined;
		this.rotation = undefined;
		this.rotationX = undefined;
		this.rotationY = undefined;
		this.saveEnabled = undefined;
		this.scaleX = undefined;
		this.scaleY = undefined;
		this.screenReaderFocusable = undefined;
		this.scrollIndicators = undefined;
		this.scrollbarDefaultDelayBeforeFade = undefined;
		this.scrollbarFadeDuration = undefined;
		this.scrollbarSize = undefined;
		this.scrollbarStyle = undefined;
		this.soundEffectsEnabled = undefined;
		this.textAlignment = undefined;
		this.textDirection = undefined;
		this.tooltipText = undefined;
		this.transformPivotX = undefined;
		this.transformPivotY = undefined;
		this.transitionName = undefined;
		this.translationX = undefined;
		this.translationY = undefined;
		this.translationZ = undefined;
		this.visibility = undefined;
		this.onApplyWindowInsets = undefined;
		this.onCapturedPointer = undefined;
		this.onClick = undefined;
		this.onContextClick = undefined;
		this.onCreateContextMenu = undefined;
		this.onDrag = undefined;
		this.onFocusChange = undefined;
		this.onGenericMotion = undefined;
		this.onHover = undefined;
		this.onKey = undefined;
		this.onLongClick = undefined;
		this.onScrollChange = undefined;
		this.onSystemUiVisibilityChange = undefined;
		this.onTouch = undefined;
		this.padding = undefined;
		this.paddingTop = undefined;
		this.paddingBottom = undefined;
		this.paddingLeft = undefined;
		this.paddingRight = undefined;
		this.paddingStart = undefined;
		this.paddingEnd = undefined;
		this.paddingHorizontal = undefined;
		this.paddingVertical = undefined;
		this.layerType = undefined;
		this.requiresFadingEdge = undefined;
		this.background = undefined;
		this.foreground = undefined;
		this.backgroundRepeat = undefined;
		this.modelSyncEvents = undefined;
		this.updateModelData_ = undefined;
		this.notifyDataSetChanged_ = undefined;
		this.modelParam = undefined;
		this.modelPojoToUi = undefined;
		this.modelUiToPojo = undefined;
		this.modelPojoToUiParams = undefined;
		this.refreshUiFromModel_ = undefined;
		this.modelUiToPojoEventIds = undefined;
		this.foregroundRepeat = undefined;
		this.foregroundGravity = undefined;
		this.performHapticFeedback_ = undefined;
		this.performHapticFeedbackWithFlags_ = undefined;
		this.attributeUnderTest = undefined;
		this.selected = undefined;
		this.enabled = undefined;
		this.focusable = undefined;
		this.scrollX = undefined;
		this.scrollY = undefined;
		this.invalidate_ = undefined;
		this.requestLayout_ = undefined;
		this.asDragSource = undefined;
		this.zIndex = undefined;
		this.maxWidth = undefined;
		this.maxHeight = undefined;
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
	

	public tryGetAccessibilityHeading() : T {
		this.resetIfRequired();
		if (this.accessibilityHeading == null || this.accessibilityHeading == undefined) {
			this.accessibilityHeading = new CommandAttr<boolean>()
		}
		
		this.accessibilityHeading.setGetter(true);
		this.orderGet++;
		this.accessibilityHeading.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isAccessibilityHeading() : boolean {
		if (this.accessibilityHeading == null || this.accessibilityHeading == undefined) {
			this.accessibilityHeading = new CommandAttr<boolean>();
		}
		return this.accessibilityHeading.getCommandReturnValue();
	}
	public setAccessibilityHeading(value : boolean) : T {
		this.resetIfRequired();
		if (this.accessibilityHeading == null || this.accessibilityHeading == undefined) {
			this.accessibilityHeading = new CommandAttr<boolean>();
		}
		
		this.accessibilityHeading.setSetter(true);
		this.accessibilityHeading.setValue(value);
		this.orderSet++;
		this.accessibilityHeading.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetAccessibilityLiveRegion() : T {
		this.resetIfRequired();
		if (this.accessibilityLiveRegion == null || this.accessibilityLiveRegion == undefined) {
			this.accessibilityLiveRegion = new CommandAttr<AccessibilityLiveRegion>()
		}
		
		this.accessibilityLiveRegion.setGetter(true);
		this.orderGet++;
		this.accessibilityLiveRegion.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getAccessibilityLiveRegion() : AccessibilityLiveRegion {
		if (this.accessibilityLiveRegion == null || this.accessibilityLiveRegion == undefined) {
			this.accessibilityLiveRegion = new CommandAttr<AccessibilityLiveRegion>();
		}
		return this.accessibilityLiveRegion.getCommandReturnValue();
	}
	public setAccessibilityLiveRegion(value : AccessibilityLiveRegion) : T {
		this.resetIfRequired();
		if (this.accessibilityLiveRegion == null || this.accessibilityLiveRegion == undefined) {
			this.accessibilityLiveRegion = new CommandAttr<AccessibilityLiveRegion>();
		}
		
		this.accessibilityLiveRegion.setSetter(true);
		this.accessibilityLiveRegion.setValue(value);
		this.orderSet++;
		this.accessibilityLiveRegion.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetAccessibilityPaneTitle() : T {
		this.resetIfRequired();
		if (this.accessibilityPaneTitle == null || this.accessibilityPaneTitle == undefined) {
			this.accessibilityPaneTitle = new CommandAttr<string>()
		}
		
		this.accessibilityPaneTitle.setGetter(true);
		this.orderGet++;
		this.accessibilityPaneTitle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getAccessibilityPaneTitle() : string {
		if (this.accessibilityPaneTitle == null || this.accessibilityPaneTitle == undefined) {
			this.accessibilityPaneTitle = new CommandAttr<string>();
		}
		return this.accessibilityPaneTitle.getCommandReturnValue();
	}
	public setAccessibilityPaneTitle(value : string) : T {
		this.resetIfRequired();
		if (this.accessibilityPaneTitle == null || this.accessibilityPaneTitle == undefined) {
			this.accessibilityPaneTitle = new CommandAttr<string>();
		}
		
		this.accessibilityPaneTitle.setSetter(true);
		this.accessibilityPaneTitle.setValue(value);
		this.orderSet++;
		this.accessibilityPaneTitle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetAccessibilityTraversalAfter() : T {
		this.resetIfRequired();
		if (this.accessibilityTraversalAfter == null || this.accessibilityTraversalAfter == undefined) {
			this.accessibilityTraversalAfter = new CommandAttr<string>()
		}
		
		this.accessibilityTraversalAfter.setGetter(true);
		this.orderGet++;
		this.accessibilityTraversalAfter.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getAccessibilityTraversalAfter() : string {
		if (this.accessibilityTraversalAfter == null || this.accessibilityTraversalAfter == undefined) {
			this.accessibilityTraversalAfter = new CommandAttr<string>();
		}
		return this.accessibilityTraversalAfter.getCommandReturnValue();
	}
	public setAccessibilityTraversalAfter(value : string) : T {
		this.resetIfRequired();
		if (this.accessibilityTraversalAfter == null || this.accessibilityTraversalAfter == undefined) {
			this.accessibilityTraversalAfter = new CommandAttr<string>();
		}
		
		this.accessibilityTraversalAfter.setSetter(true);
		this.accessibilityTraversalAfter.setValue(value);
		this.orderSet++;
		this.accessibilityTraversalAfter.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetAccessibilityTraversalBefore() : T {
		this.resetIfRequired();
		if (this.accessibilityTraversalBefore == null || this.accessibilityTraversalBefore == undefined) {
			this.accessibilityTraversalBefore = new CommandAttr<string>()
		}
		
		this.accessibilityTraversalBefore.setGetter(true);
		this.orderGet++;
		this.accessibilityTraversalBefore.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getAccessibilityTraversalBefore() : string {
		if (this.accessibilityTraversalBefore == null || this.accessibilityTraversalBefore == undefined) {
			this.accessibilityTraversalBefore = new CommandAttr<string>();
		}
		return this.accessibilityTraversalBefore.getCommandReturnValue();
	}
	public setAccessibilityTraversalBefore(value : string) : T {
		this.resetIfRequired();
		if (this.accessibilityTraversalBefore == null || this.accessibilityTraversalBefore == undefined) {
			this.accessibilityTraversalBefore = new CommandAttr<string>();
		}
		
		this.accessibilityTraversalBefore.setSetter(true);
		this.accessibilityTraversalBefore.setValue(value);
		this.orderSet++;
		this.accessibilityTraversalBefore.setOrderSet(this.orderSet);
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
		

	public tryGetAutofillHints() : T {
		this.resetIfRequired();
		if (this.autofillHints == null || this.autofillHints == undefined) {
			this.autofillHints = new CommandAttr<string>()
		}
		
		this.autofillHints.setGetter(true);
		this.orderGet++;
		this.autofillHints.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getAutofillHints() : string {
		if (this.autofillHints == null || this.autofillHints == undefined) {
			this.autofillHints = new CommandAttr<string>();
		}
		return this.autofillHints.getCommandReturnValue();
	}
	public setAutofillHints(value : string) : T {
		this.resetIfRequired();
		if (this.autofillHints == null || this.autofillHints == undefined) {
			this.autofillHints = new CommandAttr<string>();
		}
		
		this.autofillHints.setSetter(true);
		this.autofillHints.setValue(value);
		this.orderSet++;
		this.autofillHints.setOrderSet(this.orderSet);
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
		

	public tryGetContentDescription() : T {
		this.resetIfRequired();
		if (this.contentDescription == null || this.contentDescription == undefined) {
			this.contentDescription = new CommandAttr<string>()
		}
		
		this.contentDescription.setGetter(true);
		this.orderGet++;
		this.contentDescription.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getContentDescription() : string {
		if (this.contentDescription == null || this.contentDescription == undefined) {
			this.contentDescription = new CommandAttr<string>();
		}
		return this.contentDescription.getCommandReturnValue();
	}
	public setContentDescription(value : string) : T {
		this.resetIfRequired();
		if (this.contentDescription == null || this.contentDescription == undefined) {
			this.contentDescription = new CommandAttr<string>();
		}
		
		this.contentDescription.setSetter(true);
		this.contentDescription.setValue(value);
		this.orderSet++;
		this.contentDescription.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetContextClickable() : T {
		this.resetIfRequired();
		if (this.contextClickable == null || this.contextClickable == undefined) {
			this.contextClickable = new CommandAttr<boolean>()
		}
		
		this.contextClickable.setGetter(true);
		this.orderGet++;
		this.contextClickable.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isContextClickable() : boolean {
		if (this.contextClickable == null || this.contextClickable == undefined) {
			this.contextClickable = new CommandAttr<boolean>();
		}
		return this.contextClickable.getCommandReturnValue();
	}
	public setContextClickable(value : boolean) : T {
		this.resetIfRequired();
		if (this.contextClickable == null || this.contextClickable == undefined) {
			this.contextClickable = new CommandAttr<boolean>();
		}
		
		this.contextClickable.setSetter(true);
		this.contextClickable.setValue(value);
		this.orderSet++;
		this.contextClickable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetDefaultFocusHighlightEnabled() : T {
		this.resetIfRequired();
		if (this.defaultFocusHighlightEnabled == null || this.defaultFocusHighlightEnabled == undefined) {
			this.defaultFocusHighlightEnabled = new CommandAttr<boolean>()
		}
		
		this.defaultFocusHighlightEnabled.setGetter(true);
		this.orderGet++;
		this.defaultFocusHighlightEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isDefaultFocusHighlightEnabled() : boolean {
		if (this.defaultFocusHighlightEnabled == null || this.defaultFocusHighlightEnabled == undefined) {
			this.defaultFocusHighlightEnabled = new CommandAttr<boolean>();
		}
		return this.defaultFocusHighlightEnabled.getCommandReturnValue();
	}
	public setDefaultFocusHighlightEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.defaultFocusHighlightEnabled == null || this.defaultFocusHighlightEnabled == undefined) {
			this.defaultFocusHighlightEnabled = new CommandAttr<boolean>();
		}
		
		this.defaultFocusHighlightEnabled.setSetter(true);
		this.defaultFocusHighlightEnabled.setValue(value);
		this.orderSet++;
		this.defaultFocusHighlightEnabled.setOrderSet(this.orderSet);
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
		

	public tryGetElevation() : T {
		this.resetIfRequired();
		if (this.elevation == null || this.elevation == undefined) {
			this.elevation = new CommandAttr<string>()
		}
		
		this.elevation.setGetter(true);
		this.orderGet++;
		this.elevation.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getElevation() : string {
		if (this.elevation == null || this.elevation == undefined) {
			this.elevation = new CommandAttr<string>();
		}
		return this.elevation.getCommandReturnValue();
	}
	public setElevation(value : string) : T {
		this.resetIfRequired();
		if (this.elevation == null || this.elevation == undefined) {
			this.elevation = new CommandAttr<string>();
		}
		
		this.elevation.setSetter(true);
		this.elevation.setValue(value);
		this.orderSet++;
		this.elevation.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetFadeScrollbars() : T {
		this.resetIfRequired();
		if (this.fadeScrollbars == null || this.fadeScrollbars == undefined) {
			this.fadeScrollbars = new CommandAttr<boolean>()
		}
		
		this.fadeScrollbars.setGetter(true);
		this.orderGet++;
		this.fadeScrollbars.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isFadeScrollbars() : boolean {
		if (this.fadeScrollbars == null || this.fadeScrollbars == undefined) {
			this.fadeScrollbars = new CommandAttr<boolean>();
		}
		return this.fadeScrollbars.getCommandReturnValue();
	}
	public setFadeScrollbars(value : boolean) : T {
		this.resetIfRequired();
		if (this.fadeScrollbars == null || this.fadeScrollbars == undefined) {
			this.fadeScrollbars = new CommandAttr<boolean>();
		}
		
		this.fadeScrollbars.setSetter(true);
		this.fadeScrollbars.setValue(value);
		this.orderSet++;
		this.fadeScrollbars.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFadingEdgeLength(value : string) : T {
		this.resetIfRequired();
		if (this.fadingEdgeLength == null || this.fadingEdgeLength == undefined) {
			this.fadingEdgeLength = new CommandAttr<string>();
		}
		
		this.fadingEdgeLength.setSetter(true);
		this.fadingEdgeLength.setValue(value);
		this.orderSet++;
		this.fadingEdgeLength.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetFilterTouchesWhenObscured() : T {
		this.resetIfRequired();
		if (this.filterTouchesWhenObscured == null || this.filterTouchesWhenObscured == undefined) {
			this.filterTouchesWhenObscured = new CommandAttr<boolean>()
		}
		
		this.filterTouchesWhenObscured.setGetter(true);
		this.orderGet++;
		this.filterTouchesWhenObscured.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isFilterTouchesWhenObscured() : boolean {
		if (this.filterTouchesWhenObscured == null || this.filterTouchesWhenObscured == undefined) {
			this.filterTouchesWhenObscured = new CommandAttr<boolean>();
		}
		return this.filterTouchesWhenObscured.getCommandReturnValue();
	}
	public setFilterTouchesWhenObscured(value : boolean) : T {
		this.resetIfRequired();
		if (this.filterTouchesWhenObscured == null || this.filterTouchesWhenObscured == undefined) {
			this.filterTouchesWhenObscured = new CommandAttr<boolean>();
		}
		
		this.filterTouchesWhenObscured.setSetter(true);
		this.filterTouchesWhenObscured.setValue(value);
		this.orderSet++;
		this.filterTouchesWhenObscured.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetFitsSystemWindows() : T {
		this.resetIfRequired();
		if (this.fitsSystemWindows == null || this.fitsSystemWindows == undefined) {
			this.fitsSystemWindows = new CommandAttr<boolean>()
		}
		
		this.fitsSystemWindows.setGetter(true);
		this.orderGet++;
		this.fitsSystemWindows.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isFitsSystemWindows() : boolean {
		if (this.fitsSystemWindows == null || this.fitsSystemWindows == undefined) {
			this.fitsSystemWindows = new CommandAttr<boolean>();
		}
		return this.fitsSystemWindows.getCommandReturnValue();
	}
	public setFitsSystemWindows(value : boolean) : T {
		this.resetIfRequired();
		if (this.fitsSystemWindows == null || this.fitsSystemWindows == undefined) {
			this.fitsSystemWindows = new CommandAttr<boolean>();
		}
		
		this.fitsSystemWindows.setSetter(true);
		this.fitsSystemWindows.setValue(value);
		this.orderSet++;
		this.fitsSystemWindows.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetFocusableInTouchMode() : T {
		this.resetIfRequired();
		if (this.focusableInTouchMode == null || this.focusableInTouchMode == undefined) {
			this.focusableInTouchMode = new CommandAttr<boolean>()
		}
		
		this.focusableInTouchMode.setGetter(true);
		this.orderGet++;
		this.focusableInTouchMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isFocusableInTouchMode() : boolean {
		if (this.focusableInTouchMode == null || this.focusableInTouchMode == undefined) {
			this.focusableInTouchMode = new CommandAttr<boolean>();
		}
		return this.focusableInTouchMode.getCommandReturnValue();
	}
	public setFocusableInTouchMode(value : boolean) : T {
		this.resetIfRequired();
		if (this.focusableInTouchMode == null || this.focusableInTouchMode == undefined) {
			this.focusableInTouchMode = new CommandAttr<boolean>();
		}
		
		this.focusableInTouchMode.setSetter(true);
		this.focusableInTouchMode.setValue(value);
		this.orderSet++;
		this.focusableInTouchMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetFocusedByDefault() : T {
		this.resetIfRequired();
		if (this.focusedByDefault == null || this.focusedByDefault == undefined) {
			this.focusedByDefault = new CommandAttr<boolean>()
		}
		
		this.focusedByDefault.setGetter(true);
		this.orderGet++;
		this.focusedByDefault.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isFocusedByDefault() : boolean {
		if (this.focusedByDefault == null || this.focusedByDefault == undefined) {
			this.focusedByDefault = new CommandAttr<boolean>();
		}
		return this.focusedByDefault.getCommandReturnValue();
	}
	public setFocusedByDefault(value : boolean) : T {
		this.resetIfRequired();
		if (this.focusedByDefault == null || this.focusedByDefault == undefined) {
			this.focusedByDefault = new CommandAttr<boolean>();
		}
		
		this.focusedByDefault.setSetter(true);
		this.focusedByDefault.setValue(value);
		this.orderSet++;
		this.focusedByDefault.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setForceHasOverlappingRendering(value : boolean) : T {
		this.resetIfRequired();
		if (this.forceHasOverlappingRendering == null || this.forceHasOverlappingRendering == undefined) {
			this.forceHasOverlappingRendering = new CommandAttr<boolean>();
		}
		
		this.forceHasOverlappingRendering.setSetter(true);
		this.forceHasOverlappingRendering.setValue(value);
		this.orderSet++;
		this.forceHasOverlappingRendering.setOrderSet(this.orderSet);
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
		

	public tryGetHapticFeedbackEnabled() : T {
		this.resetIfRequired();
		if (this.hapticFeedbackEnabled == null || this.hapticFeedbackEnabled == undefined) {
			this.hapticFeedbackEnabled = new CommandAttr<boolean>()
		}
		
		this.hapticFeedbackEnabled.setGetter(true);
		this.orderGet++;
		this.hapticFeedbackEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isHapticFeedbackEnabled() : boolean {
		if (this.hapticFeedbackEnabled == null || this.hapticFeedbackEnabled == undefined) {
			this.hapticFeedbackEnabled = new CommandAttr<boolean>();
		}
		return this.hapticFeedbackEnabled.getCommandReturnValue();
	}
	public setHapticFeedbackEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.hapticFeedbackEnabled == null || this.hapticFeedbackEnabled == undefined) {
			this.hapticFeedbackEnabled = new CommandAttr<boolean>();
		}
		
		this.hapticFeedbackEnabled.setSetter(true);
		this.hapticFeedbackEnabled.setValue(value);
		this.orderSet++;
		this.hapticFeedbackEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetImportantForAccessibility() : T {
		this.resetIfRequired();
		if (this.importantForAccessibility == null || this.importantForAccessibility == undefined) {
			this.importantForAccessibility = new CommandAttr<ImportantForAccessibility>()
		}
		
		this.importantForAccessibility.setGetter(true);
		this.orderGet++;
		this.importantForAccessibility.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getImportantForAccessibility() : ImportantForAccessibility {
		if (this.importantForAccessibility == null || this.importantForAccessibility == undefined) {
			this.importantForAccessibility = new CommandAttr<ImportantForAccessibility>();
		}
		return this.importantForAccessibility.getCommandReturnValue();
	}
	public setImportantForAccessibility(value : ImportantForAccessibility) : T {
		this.resetIfRequired();
		if (this.importantForAccessibility == null || this.importantForAccessibility == undefined) {
			this.importantForAccessibility = new CommandAttr<ImportantForAccessibility>();
		}
		
		this.importantForAccessibility.setSetter(true);
		this.importantForAccessibility.setValue(value);
		this.orderSet++;
		this.importantForAccessibility.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetImportantForAutofill() : T {
		this.resetIfRequired();
		if (this.importantForAutofill == null || this.importantForAutofill == undefined) {
			this.importantForAutofill = new CommandAttr<ImportantForAutofill[]>()
		}
		
		this.importantForAutofill.setGetter(true);
		this.orderGet++;
		this.importantForAutofill.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getImportantForAutofill() : ImportantForAutofill[] {
		if (this.importantForAutofill == null || this.importantForAutofill == undefined) {
			this.importantForAutofill = new CommandAttr<ImportantForAutofill[]>();
		}
this.importantForAutofill.setTransformer('importantForAutofill');		return this.importantForAutofill.getCommandReturnValue();
	}
	public setImportantForAutofill(...value : ImportantForAutofill[]) : T {
		this.resetIfRequired();
		if (this.importantForAutofill == null || this.importantForAutofill == undefined) {
			this.importantForAutofill = new CommandAttr<ImportantForAutofill[]>();
		}
		
		this.importantForAutofill.setSetter(true);
		this.importantForAutofill.setValue(value);
		this.orderSet++;
		this.importantForAutofill.setOrderSet(this.orderSet);
this.importantForAutofill.setTransformer('importantForAutofill');		return this.thisPointer;
	}
		

	public tryGetIsScrollContainer() : T {
		this.resetIfRequired();
		if (this.isScrollContainer == null || this.isScrollContainer == undefined) {
			this.isScrollContainer = new CommandAttr<boolean>()
		}
		
		this.isScrollContainer.setGetter(true);
		this.orderGet++;
		this.isScrollContainer.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIsScrollContainer() : boolean {
		if (this.isScrollContainer == null || this.isScrollContainer == undefined) {
			this.isScrollContainer = new CommandAttr<boolean>();
		}
		return this.isScrollContainer.getCommandReturnValue();
	}
	public setIsScrollContainer(value : boolean) : T {
		this.resetIfRequired();
		if (this.isScrollContainer == null || this.isScrollContainer == undefined) {
			this.isScrollContainer = new CommandAttr<boolean>();
		}
		
		this.isScrollContainer.setSetter(true);
		this.isScrollContainer.setValue(value);
		this.orderSet++;
		this.isScrollContainer.setOrderSet(this.orderSet);
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
		

	public tryGetKeyboardNavigationCluster() : T {
		this.resetIfRequired();
		if (this.keyboardNavigationCluster == null || this.keyboardNavigationCluster == undefined) {
			this.keyboardNavigationCluster = new CommandAttr<boolean>()
		}
		
		this.keyboardNavigationCluster.setGetter(true);
		this.orderGet++;
		this.keyboardNavigationCluster.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isKeyboardNavigationCluster() : boolean {
		if (this.keyboardNavigationCluster == null || this.keyboardNavigationCluster == undefined) {
			this.keyboardNavigationCluster = new CommandAttr<boolean>();
		}
		return this.keyboardNavigationCluster.getCommandReturnValue();
	}
	public setKeyboardNavigationCluster(value : boolean) : T {
		this.resetIfRequired();
		if (this.keyboardNavigationCluster == null || this.keyboardNavigationCluster == undefined) {
			this.keyboardNavigationCluster = new CommandAttr<boolean>();
		}
		
		this.keyboardNavigationCluster.setSetter(true);
		this.keyboardNavigationCluster.setValue(value);
		this.orderSet++;
		this.keyboardNavigationCluster.setOrderSet(this.orderSet);
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
		

	public tryGetNextClusterForward() : T {
		this.resetIfRequired();
		if (this.nextClusterForward == null || this.nextClusterForward == undefined) {
			this.nextClusterForward = new CommandAttr<string>()
		}
		
		this.nextClusterForward.setGetter(true);
		this.orderGet++;
		this.nextClusterForward.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getNextClusterForward() : string {
		if (this.nextClusterForward == null || this.nextClusterForward == undefined) {
			this.nextClusterForward = new CommandAttr<string>();
		}
		return this.nextClusterForward.getCommandReturnValue();
	}
	public setNextClusterForward(value : string) : T {
		this.resetIfRequired();
		if (this.nextClusterForward == null || this.nextClusterForward == undefined) {
			this.nextClusterForward = new CommandAttr<string>();
		}
		
		this.nextClusterForward.setSetter(true);
		this.nextClusterForward.setValue(value);
		this.orderSet++;
		this.nextClusterForward.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetNextFocusDown() : T {
		this.resetIfRequired();
		if (this.nextFocusDown == null || this.nextFocusDown == undefined) {
			this.nextFocusDown = new CommandAttr<string>()
		}
		
		this.nextFocusDown.setGetter(true);
		this.orderGet++;
		this.nextFocusDown.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getNextFocusDown() : string {
		if (this.nextFocusDown == null || this.nextFocusDown == undefined) {
			this.nextFocusDown = new CommandAttr<string>();
		}
		return this.nextFocusDown.getCommandReturnValue();
	}
	public setNextFocusDown(value : string) : T {
		this.resetIfRequired();
		if (this.nextFocusDown == null || this.nextFocusDown == undefined) {
			this.nextFocusDown = new CommandAttr<string>();
		}
		
		this.nextFocusDown.setSetter(true);
		this.nextFocusDown.setValue(value);
		this.orderSet++;
		this.nextFocusDown.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetNextFocusForward() : T {
		this.resetIfRequired();
		if (this.nextFocusForward == null || this.nextFocusForward == undefined) {
			this.nextFocusForward = new CommandAttr<string>()
		}
		
		this.nextFocusForward.setGetter(true);
		this.orderGet++;
		this.nextFocusForward.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getNextFocusForward() : string {
		if (this.nextFocusForward == null || this.nextFocusForward == undefined) {
			this.nextFocusForward = new CommandAttr<string>();
		}
		return this.nextFocusForward.getCommandReturnValue();
	}
	public setNextFocusForward(value : string) : T {
		this.resetIfRequired();
		if (this.nextFocusForward == null || this.nextFocusForward == undefined) {
			this.nextFocusForward = new CommandAttr<string>();
		}
		
		this.nextFocusForward.setSetter(true);
		this.nextFocusForward.setValue(value);
		this.orderSet++;
		this.nextFocusForward.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetNextFocusLeft() : T {
		this.resetIfRequired();
		if (this.nextFocusLeft == null || this.nextFocusLeft == undefined) {
			this.nextFocusLeft = new CommandAttr<string>()
		}
		
		this.nextFocusLeft.setGetter(true);
		this.orderGet++;
		this.nextFocusLeft.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getNextFocusLeft() : string {
		if (this.nextFocusLeft == null || this.nextFocusLeft == undefined) {
			this.nextFocusLeft = new CommandAttr<string>();
		}
		return this.nextFocusLeft.getCommandReturnValue();
	}
	public setNextFocusLeft(value : string) : T {
		this.resetIfRequired();
		if (this.nextFocusLeft == null || this.nextFocusLeft == undefined) {
			this.nextFocusLeft = new CommandAttr<string>();
		}
		
		this.nextFocusLeft.setSetter(true);
		this.nextFocusLeft.setValue(value);
		this.orderSet++;
		this.nextFocusLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetNextFocusRight() : T {
		this.resetIfRequired();
		if (this.nextFocusRight == null || this.nextFocusRight == undefined) {
			this.nextFocusRight = new CommandAttr<string>()
		}
		
		this.nextFocusRight.setGetter(true);
		this.orderGet++;
		this.nextFocusRight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getNextFocusRight() : string {
		if (this.nextFocusRight == null || this.nextFocusRight == undefined) {
			this.nextFocusRight = new CommandAttr<string>();
		}
		return this.nextFocusRight.getCommandReturnValue();
	}
	public setNextFocusRight(value : string) : T {
		this.resetIfRequired();
		if (this.nextFocusRight == null || this.nextFocusRight == undefined) {
			this.nextFocusRight = new CommandAttr<string>();
		}
		
		this.nextFocusRight.setSetter(true);
		this.nextFocusRight.setValue(value);
		this.orderSet++;
		this.nextFocusRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetNextFocusUp() : T {
		this.resetIfRequired();
		if (this.nextFocusUp == null || this.nextFocusUp == undefined) {
			this.nextFocusUp = new CommandAttr<string>()
		}
		
		this.nextFocusUp.setGetter(true);
		this.orderGet++;
		this.nextFocusUp.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getNextFocusUp() : string {
		if (this.nextFocusUp == null || this.nextFocusUp == undefined) {
			this.nextFocusUp = new CommandAttr<string>();
		}
		return this.nextFocusUp.getCommandReturnValue();
	}
	public setNextFocusUp(value : string) : T {
		this.resetIfRequired();
		if (this.nextFocusUp == null || this.nextFocusUp == undefined) {
			this.nextFocusUp = new CommandAttr<string>();
		}
		
		this.nextFocusUp.setSetter(true);
		this.nextFocusUp.setValue(value);
		this.orderSet++;
		this.nextFocusUp.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetOutlineAmbientShadowColor() : T {
		this.resetIfRequired();
		if (this.outlineAmbientShadowColor == null || this.outlineAmbientShadowColor == undefined) {
			this.outlineAmbientShadowColor = new CommandAttr<string>()
		}
		
		this.outlineAmbientShadowColor.setGetter(true);
		this.orderGet++;
		this.outlineAmbientShadowColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getOutlineAmbientShadowColor() : string {
		if (this.outlineAmbientShadowColor == null || this.outlineAmbientShadowColor == undefined) {
			this.outlineAmbientShadowColor = new CommandAttr<string>();
		}
		return this.outlineAmbientShadowColor.getCommandReturnValue();
	}
	public setOutlineAmbientShadowColor(value : string) : T {
		this.resetIfRequired();
		if (this.outlineAmbientShadowColor == null || this.outlineAmbientShadowColor == undefined) {
			this.outlineAmbientShadowColor = new CommandAttr<string>();
		}
		
		this.outlineAmbientShadowColor.setSetter(true);
		this.outlineAmbientShadowColor.setValue(value);
		this.orderSet++;
		this.outlineAmbientShadowColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetOutlineSpotShadowColor() : T {
		this.resetIfRequired();
		if (this.outlineSpotShadowColor == null || this.outlineSpotShadowColor == undefined) {
			this.outlineSpotShadowColor = new CommandAttr<string>()
		}
		
		this.outlineSpotShadowColor.setGetter(true);
		this.orderGet++;
		this.outlineSpotShadowColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getOutlineSpotShadowColor() : string {
		if (this.outlineSpotShadowColor == null || this.outlineSpotShadowColor == undefined) {
			this.outlineSpotShadowColor = new CommandAttr<string>();
		}
		return this.outlineSpotShadowColor.getCommandReturnValue();
	}
	public setOutlineSpotShadowColor(value : string) : T {
		this.resetIfRequired();
		if (this.outlineSpotShadowColor == null || this.outlineSpotShadowColor == undefined) {
			this.outlineSpotShadowColor = new CommandAttr<string>();
		}
		
		this.outlineSpotShadowColor.setSetter(true);
		this.outlineSpotShadowColor.setValue(value);
		this.orderSet++;
		this.outlineSpotShadowColor.setOrderSet(this.orderSet);
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
		

	public tryGetSaveEnabled() : T {
		this.resetIfRequired();
		if (this.saveEnabled == null || this.saveEnabled == undefined) {
			this.saveEnabled = new CommandAttr<boolean>()
		}
		
		this.saveEnabled.setGetter(true);
		this.orderGet++;
		this.saveEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isSaveEnabled() : boolean {
		if (this.saveEnabled == null || this.saveEnabled == undefined) {
			this.saveEnabled = new CommandAttr<boolean>();
		}
		return this.saveEnabled.getCommandReturnValue();
	}
	public setSaveEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.saveEnabled == null || this.saveEnabled == undefined) {
			this.saveEnabled = new CommandAttr<boolean>();
		}
		
		this.saveEnabled.setSetter(true);
		this.saveEnabled.setValue(value);
		this.orderSet++;
		this.saveEnabled.setOrderSet(this.orderSet);
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
		

	public tryGetScreenReaderFocusable() : T {
		this.resetIfRequired();
		if (this.screenReaderFocusable == null || this.screenReaderFocusable == undefined) {
			this.screenReaderFocusable = new CommandAttr<boolean>()
		}
		
		this.screenReaderFocusable.setGetter(true);
		this.orderGet++;
		this.screenReaderFocusable.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isScreenReaderFocusable() : boolean {
		if (this.screenReaderFocusable == null || this.screenReaderFocusable == undefined) {
			this.screenReaderFocusable = new CommandAttr<boolean>();
		}
		return this.screenReaderFocusable.getCommandReturnValue();
	}
	public setScreenReaderFocusable(value : boolean) : T {
		this.resetIfRequired();
		if (this.screenReaderFocusable == null || this.screenReaderFocusable == undefined) {
			this.screenReaderFocusable = new CommandAttr<boolean>();
		}
		
		this.screenReaderFocusable.setSetter(true);
		this.screenReaderFocusable.setValue(value);
		this.orderSet++;
		this.screenReaderFocusable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScrollIndicators() : T {
		this.resetIfRequired();
		if (this.scrollIndicators == null || this.scrollIndicators == undefined) {
			this.scrollIndicators = new CommandAttr<ScrollIndicators[]>()
		}
		
		this.scrollIndicators.setGetter(true);
		this.orderGet++;
		this.scrollIndicators.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScrollIndicators() : ScrollIndicators[] {
		if (this.scrollIndicators == null || this.scrollIndicators == undefined) {
			this.scrollIndicators = new CommandAttr<ScrollIndicators[]>();
		}
this.scrollIndicators.setTransformer('scrollIndicators');		return this.scrollIndicators.getCommandReturnValue();
	}
	public setScrollIndicators(...value : ScrollIndicators[]) : T {
		this.resetIfRequired();
		if (this.scrollIndicators == null || this.scrollIndicators == undefined) {
			this.scrollIndicators = new CommandAttr<ScrollIndicators[]>();
		}
		
		this.scrollIndicators.setSetter(true);
		this.scrollIndicators.setValue(value);
		this.orderSet++;
		this.scrollIndicators.setOrderSet(this.orderSet);
this.scrollIndicators.setTransformer('scrollIndicators');		return this.thisPointer;
	}
		

	public tryGetScrollbarDefaultDelayBeforeFade() : T {
		this.resetIfRequired();
		if (this.scrollbarDefaultDelayBeforeFade == null || this.scrollbarDefaultDelayBeforeFade == undefined) {
			this.scrollbarDefaultDelayBeforeFade = new CommandAttr<number>()
		}
		
		this.scrollbarDefaultDelayBeforeFade.setGetter(true);
		this.orderGet++;
		this.scrollbarDefaultDelayBeforeFade.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScrollbarDefaultDelayBeforeFade() : number {
		if (this.scrollbarDefaultDelayBeforeFade == null || this.scrollbarDefaultDelayBeforeFade == undefined) {
			this.scrollbarDefaultDelayBeforeFade = new CommandAttr<number>();
		}
		return this.scrollbarDefaultDelayBeforeFade.getCommandReturnValue();
	}
	public setScrollbarDefaultDelayBeforeFade(value : number) : T {
		this.resetIfRequired();
		if (this.scrollbarDefaultDelayBeforeFade == null || this.scrollbarDefaultDelayBeforeFade == undefined) {
			this.scrollbarDefaultDelayBeforeFade = new CommandAttr<number>();
		}
		
		this.scrollbarDefaultDelayBeforeFade.setSetter(true);
		this.scrollbarDefaultDelayBeforeFade.setValue(value);
		this.orderSet++;
		this.scrollbarDefaultDelayBeforeFade.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScrollbarFadeDuration() : T {
		this.resetIfRequired();
		if (this.scrollbarFadeDuration == null || this.scrollbarFadeDuration == undefined) {
			this.scrollbarFadeDuration = new CommandAttr<number>()
		}
		
		this.scrollbarFadeDuration.setGetter(true);
		this.orderGet++;
		this.scrollbarFadeDuration.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScrollbarFadeDuration() : number {
		if (this.scrollbarFadeDuration == null || this.scrollbarFadeDuration == undefined) {
			this.scrollbarFadeDuration = new CommandAttr<number>();
		}
		return this.scrollbarFadeDuration.getCommandReturnValue();
	}
	public setScrollbarFadeDuration(value : number) : T {
		this.resetIfRequired();
		if (this.scrollbarFadeDuration == null || this.scrollbarFadeDuration == undefined) {
			this.scrollbarFadeDuration = new CommandAttr<number>();
		}
		
		this.scrollbarFadeDuration.setSetter(true);
		this.scrollbarFadeDuration.setValue(value);
		this.orderSet++;
		this.scrollbarFadeDuration.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScrollbarSize() : T {
		this.resetIfRequired();
		if (this.scrollbarSize == null || this.scrollbarSize == undefined) {
			this.scrollbarSize = new CommandAttr<string>()
		}
		
		this.scrollbarSize.setGetter(true);
		this.orderGet++;
		this.scrollbarSize.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScrollbarSize() : string {
		if (this.scrollbarSize == null || this.scrollbarSize == undefined) {
			this.scrollbarSize = new CommandAttr<string>();
		}
		return this.scrollbarSize.getCommandReturnValue();
	}
	public setScrollbarSize(value : string) : T {
		this.resetIfRequired();
		if (this.scrollbarSize == null || this.scrollbarSize == undefined) {
			this.scrollbarSize = new CommandAttr<string>();
		}
		
		this.scrollbarSize.setSetter(true);
		this.scrollbarSize.setValue(value);
		this.orderSet++;
		this.scrollbarSize.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScrollbarStyle() : T {
		this.resetIfRequired();
		if (this.scrollbarStyle == null || this.scrollbarStyle == undefined) {
			this.scrollbarStyle = new CommandAttr<ScrollbarStyle>()
		}
		
		this.scrollbarStyle.setGetter(true);
		this.orderGet++;
		this.scrollbarStyle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScrollbarStyle() : ScrollbarStyle {
		if (this.scrollbarStyle == null || this.scrollbarStyle == undefined) {
			this.scrollbarStyle = new CommandAttr<ScrollbarStyle>();
		}
		return this.scrollbarStyle.getCommandReturnValue();
	}
	public setScrollbarStyle(value : ScrollbarStyle) : T {
		this.resetIfRequired();
		if (this.scrollbarStyle == null || this.scrollbarStyle == undefined) {
			this.scrollbarStyle = new CommandAttr<ScrollbarStyle>();
		}
		
		this.scrollbarStyle.setSetter(true);
		this.scrollbarStyle.setValue(value);
		this.orderSet++;
		this.scrollbarStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSoundEffectsEnabled() : T {
		this.resetIfRequired();
		if (this.soundEffectsEnabled == null || this.soundEffectsEnabled == undefined) {
			this.soundEffectsEnabled = new CommandAttr<boolean>()
		}
		
		this.soundEffectsEnabled.setGetter(true);
		this.orderGet++;
		this.soundEffectsEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isSoundEffectsEnabled() : boolean {
		if (this.soundEffectsEnabled == null || this.soundEffectsEnabled == undefined) {
			this.soundEffectsEnabled = new CommandAttr<boolean>();
		}
		return this.soundEffectsEnabled.getCommandReturnValue();
	}
	public setSoundEffectsEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.soundEffectsEnabled == null || this.soundEffectsEnabled == undefined) {
			this.soundEffectsEnabled = new CommandAttr<boolean>();
		}
		
		this.soundEffectsEnabled.setSetter(true);
		this.soundEffectsEnabled.setValue(value);
		this.orderSet++;
		this.soundEffectsEnabled.setOrderSet(this.orderSet);
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
		

	public tryGetTooltipText() : T {
		this.resetIfRequired();
		if (this.tooltipText == null || this.tooltipText == undefined) {
			this.tooltipText = new CommandAttr<string>()
		}
		
		this.tooltipText.setGetter(true);
		this.orderGet++;
		this.tooltipText.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTooltipText() : string {
		if (this.tooltipText == null || this.tooltipText == undefined) {
			this.tooltipText = new CommandAttr<string>();
		}
		return this.tooltipText.getCommandReturnValue();
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
		

	public tryGetTransitionName() : T {
		this.resetIfRequired();
		if (this.transitionName == null || this.transitionName == undefined) {
			this.transitionName = new CommandAttr<string>()
		}
		
		this.transitionName.setGetter(true);
		this.orderGet++;
		this.transitionName.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTransitionName() : string {
		if (this.transitionName == null || this.transitionName == undefined) {
			this.transitionName = new CommandAttr<string>();
		}
		return this.transitionName.getCommandReturnValue();
	}
	public setTransitionName(value : string) : T {
		this.resetIfRequired();
		if (this.transitionName == null || this.transitionName == undefined) {
			this.transitionName = new CommandAttr<string>();
		}
		
		this.transitionName.setSetter(true);
		this.transitionName.setValue(value);
		this.orderSet++;
		this.transitionName.setOrderSet(this.orderSet);
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
		

	public setOnApplyWindowInsets(value : string) : T {
		this.resetIfRequired();
		if (this.onApplyWindowInsets == null || this.onApplyWindowInsets == undefined) {
			this.onApplyWindowInsets = new CommandAttr<string>();
		}
		
		this.onApplyWindowInsets.setSetter(true);
		this.onApplyWindowInsets.setValue(value);
		this.orderSet++;
		this.onApplyWindowInsets.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnCapturedPointer(value : string) : T {
		this.resetIfRequired();
		if (this.onCapturedPointer == null || this.onCapturedPointer == undefined) {
			this.onCapturedPointer = new CommandAttr<string>();
		}
		
		this.onCapturedPointer.setSetter(true);
		this.onCapturedPointer.setValue(value);
		this.orderSet++;
		this.onCapturedPointer.setOrderSet(this.orderSet);
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
		

	public setOnContextClick(value : string) : T {
		this.resetIfRequired();
		if (this.onContextClick == null || this.onContextClick == undefined) {
			this.onContextClick = new CommandAttr<string>();
		}
		
		this.onContextClick.setSetter(true);
		this.onContextClick.setValue(value);
		this.orderSet++;
		this.onContextClick.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnCreateContextMenu(value : string) : T {
		this.resetIfRequired();
		if (this.onCreateContextMenu == null || this.onCreateContextMenu == undefined) {
			this.onCreateContextMenu = new CommandAttr<string>();
		}
		
		this.onCreateContextMenu.setSetter(true);
		this.onCreateContextMenu.setValue(value);
		this.orderSet++;
		this.onCreateContextMenu.setOrderSet(this.orderSet);
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
		

	public setOnFocusChange(value : string) : T {
		this.resetIfRequired();
		if (this.onFocusChange == null || this.onFocusChange == undefined) {
			this.onFocusChange = new CommandAttr<string>();
		}
		
		this.onFocusChange.setSetter(true);
		this.onFocusChange.setValue(value);
		this.orderSet++;
		this.onFocusChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnGenericMotion(value : string) : T {
		this.resetIfRequired();
		if (this.onGenericMotion == null || this.onGenericMotion == undefined) {
			this.onGenericMotion = new CommandAttr<string>();
		}
		
		this.onGenericMotion.setSetter(true);
		this.onGenericMotion.setValue(value);
		this.orderSet++;
		this.onGenericMotion.setOrderSet(this.orderSet);
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
		

	public setOnScrollChange(value : string) : T {
		this.resetIfRequired();
		if (this.onScrollChange == null || this.onScrollChange == undefined) {
			this.onScrollChange = new CommandAttr<string>();
		}
		
		this.onScrollChange.setSetter(true);
		this.onScrollChange.setValue(value);
		this.orderSet++;
		this.onScrollChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnSystemUiVisibilityChange(value : string) : T {
		this.resetIfRequired();
		if (this.onSystemUiVisibilityChange == null || this.onSystemUiVisibilityChange == undefined) {
			this.onSystemUiVisibilityChange = new CommandAttr<string>();
		}
		
		this.onSystemUiVisibilityChange.setSetter(true);
		this.onSystemUiVisibilityChange.setValue(value);
		this.orderSet++;
		this.onSystemUiVisibilityChange.setOrderSet(this.orderSet);
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
		

	public setLayerType(value : LayerType) : T {
		this.resetIfRequired();
		if (this.layerType == null || this.layerType == undefined) {
			this.layerType = new CommandAttr<LayerType>();
		}
		
		this.layerType.setSetter(true);
		this.layerType.setValue(value);
		this.orderSet++;
		this.layerType.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetRequiresFadingEdge() : T {
		this.resetIfRequired();
		if (this.requiresFadingEdge == null || this.requiresFadingEdge == undefined) {
			this.requiresFadingEdge = new CommandAttr<RequiresFadingEdge[]>()
		}
		
		this.requiresFadingEdge.setGetter(true);
		this.orderGet++;
		this.requiresFadingEdge.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getRequiresFadingEdge() : RequiresFadingEdge[] {
		if (this.requiresFadingEdge == null || this.requiresFadingEdge == undefined) {
			this.requiresFadingEdge = new CommandAttr<RequiresFadingEdge[]>();
		}
this.requiresFadingEdge.setTransformer('requiresFadingEdge');		return this.requiresFadingEdge.getCommandReturnValue();
	}
	public setRequiresFadingEdge(...value : RequiresFadingEdge[]) : T {
		this.resetIfRequired();
		if (this.requiresFadingEdge == null || this.requiresFadingEdge == undefined) {
			this.requiresFadingEdge = new CommandAttr<RequiresFadingEdge[]>();
		}
		
		this.requiresFadingEdge.setSetter(true);
		this.requiresFadingEdge.setValue(value);
		this.orderSet++;
		this.requiresFadingEdge.setOrderSet(this.orderSet);
this.requiresFadingEdge.setTransformer('requiresFadingEdge');		return this.thisPointer;
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
		

	public performHapticFeedback(value : HapticFeedbackConstants) : T {
		this.resetIfRequired();
		if (this.performHapticFeedback_ == null || this.performHapticFeedback_ == undefined) {
			this.performHapticFeedback_ = new CommandAttr<HapticFeedbackConstants>();
		}
		
		this.performHapticFeedback_.setSetter(true);
		this.performHapticFeedback_.setValue(value);
		this.orderSet++;
		this.performHapticFeedback_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public performHapticFeedbackWithFlags(value : HapticFeedbackConstants,
...flags : HapticFeedbackConstantsFlag[]) : T {
		this.resetIfRequired();
		if (this.performHapticFeedbackWithFlags_ == null || this.performHapticFeedbackWithFlags_ == undefined) {
			this.performHapticFeedbackWithFlags_ = new CommandAttr<ViewImpl_performHapticFeedbackWithFlags>();
		}
		
		let wrapper:ViewImpl_performHapticFeedbackWithFlags = new ViewImpl_performHapticFeedbackWithFlags();
		wrapper.value = value;
		wrapper.flags = flags;
		this.performHapticFeedbackWithFlags_.setSetter(true);
		this.performHapticFeedbackWithFlags_.setValue(wrapper);	
		this.orderSet++;
		this.performHapticFeedbackWithFlags_.setOrderSet(this.orderSet);
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
		

	public tryGetFocusable() : T {
		this.resetIfRequired();
		if (this.focusable == null || this.focusable == undefined) {
			this.focusable = new CommandAttr<boolean>()
		}
		
		this.focusable.setGetter(true);
		this.orderGet++;
		this.focusable.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isFocusable() : boolean {
		if (this.focusable == null || this.focusable == undefined) {
			this.focusable = new CommandAttr<boolean>();
		}
		return this.focusable.getCommandReturnValue();
	}
	public setFocusable(value : boolean) : T {
		this.resetIfRequired();
		if (this.focusable == null || this.focusable == undefined) {
			this.focusable = new CommandAttr<boolean>();
		}
		
		this.focusable.setSetter(true);
		this.focusable.setValue(value);
		this.orderSet++;
		this.focusable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScrollX() : T {
		this.resetIfRequired();
		if (this.scrollX == null || this.scrollX == undefined) {
			this.scrollX = new CommandAttr<string>()
		}
		
		this.scrollX.setGetter(true);
		this.orderGet++;
		this.scrollX.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScrollX() : string {
		if (this.scrollX == null || this.scrollX == undefined) {
			this.scrollX = new CommandAttr<string>();
		}
		return this.scrollX.getCommandReturnValue();
	}
	public setScrollX(value : string) : T {
		this.resetIfRequired();
		if (this.scrollX == null || this.scrollX == undefined) {
			this.scrollX = new CommandAttr<string>();
		}
		
		this.scrollX.setSetter(true);
		this.scrollX.setValue(value);
		this.orderSet++;
		this.scrollX.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScrollY() : T {
		this.resetIfRequired();
		if (this.scrollY == null || this.scrollY == undefined) {
			this.scrollY = new CommandAttr<string>()
		}
		
		this.scrollY.setGetter(true);
		this.orderGet++;
		this.scrollY.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScrollY() : string {
		if (this.scrollY == null || this.scrollY == undefined) {
			this.scrollY = new CommandAttr<string>();
		}
		return this.scrollY.getCommandReturnValue();
	}
	public setScrollY(value : string) : T {
		this.resetIfRequired();
		if (this.scrollY == null || this.scrollY == undefined) {
			this.scrollY = new CommandAttr<string>();
		}
		
		this.scrollY.setSetter(true);
		this.scrollY.setValue(value);
		this.orderSet++;
		this.scrollY.setOrderSet(this.orderSet);
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
export interface OnApplyWindowInsetsEvent extends Event{
        //v:View;

        //insets:WindowInsets;


}
export interface OnCapturedPointerEvent extends Event{
        //view:View;

        //event:MotionEvent;
        		eventInfo: MotionEvent;


}
export interface OnClickEvent extends Event{
        //v:View;


}
export interface OnContextClickEvent extends Event{
        //v:View;


}
export interface OnCreateContextMenuEvent extends Event{
        //menu:ContextMenu;

        //v:View;

        //menuInfo:ContextMenu.ContextMenuInfo;


}
export interface OnDragEvent extends Event{
        //v:View;

        //event:DragEvent;
        		eventInfo: DragEvent;


}
export interface OnFocusChangeEvent extends Event{
        //v:View;

        hasFocus:boolean;

}
export interface OnGenericMotionEvent extends Event{
        //v:View;

        //event:MotionEvent;
        		eventInfo: MotionEvent;


}
export interface OnHoverEvent extends Event{
        //v:View;

        //event:MotionEvent;
        		eventInfo: MotionEvent;


}
export interface OnKeyEvent extends Event{
        //v:View;

	        keyCode:number;
        //event:KeyEvent;
        		eventInfo: KeyEvent;


}
export interface OnLongClickEvent extends Event{
        //v:View;


}
export interface OnScrollChangeEvent extends Event{
        //v:View;

	        scrollX:number;
	        scrollY:number;
	        oldScrollX:number;
	        oldScrollY:number;

}
export interface OnSystemUiVisibilityChangeEvent extends Event{
	        visibility:number;

}
export interface OnTouchEvent extends Event{
        //v:View;

        //event:MotionEvent;
        		eventInfo: MotionEvent;


}

//end - staticinit