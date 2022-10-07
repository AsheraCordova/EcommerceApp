// start - imports

export const enum ButtonTinttMode {
add = "add",
multiply = "multiply",
screen = "screen",
src_atop = "src_atop",
src_in = "src_in",
src_over = "src_over",
}
export const enum Ellipsize {
end = "end",
marquee = "marquee",
middle = "middle",
none = "none",
start = "start",
}
export const enum MarqueeRepeatLimit {
marquee_forever = "marquee_forever",
}
export const enum JustificationMode {
inter_word = "inter_word",
none = "none",
}
export const enum Font {
monospace = "monospace",
normal = "normal",
sans = "sans",
serif = "serif",
}
export const enum TextStyle {
bold = "bold",
italic = "italic",
normal = "normal",
}
export const enum DrawableTintMode {
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





















































export class TextStyleTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<TextStyle> = new Array<TextStyle>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "bold":
						valueArr.push(TextStyle.bold);
                       	break;	
					case "italic":
						valueArr.push(TextStyle.italic);
                       	break;	
					case "normal":
						valueArr.push(TextStyle.normal);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}


















// end - imports
import {ViewImpl} from './ViewImpl';
export abstract class CheckBoxImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
		TransformerFactory.getInstance().register("textStyle", new TextStyleTransformer());
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "iosText" })
	iosText!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosTextColor" })
	iosTextColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsEnabled" })
	iosIsEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAdjustsFontSizeToFitWidth" })
	iosAdjustsFontSizeToFitWidth!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAllowsDefaultTighteningForTruncation" })
	iosAllowsDefaultTighteningForTruncation!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosMinimumScaleFactor" })
	iosMinimumScaleFactor!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosNumberOfLines" })
	iosNumberOfLines!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosHighlightedTextColor" })
	iosHighlightedTextColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsHighlighted" })
	iosIsHighlighted!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosShadowColor" })
	iosShadowColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosPreferredMaxLayoutWidth" })
	iosPreferredMaxLayoutWidth!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsUserInteractionEnabled" })
	iosIsUserInteractionEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "checked" })
	checked!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onCheckedChange" })
	onCheckedChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "button" })
	button!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "buttonTint" })
	buttonTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "buttonTintMode" })
	buttonTintMode!:CommandAttr<ButtonTinttMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "text" })
	text!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "gravity" })
	gravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textSize" })
	textSize!:CommandAttr<string>| undefined;
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
	@Type(() => CommandAttr)
	@Expose({ name: "minLines" })
	minLines!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "lines" })
	lines!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxLines" })
	maxLines!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minWidth" })
	minWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minHeight" })
	minHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxWidth" })
	maxWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxHeight" })
	maxHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "height" })
	height!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "width" })
	width!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxEms" })
	maxEms!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minEms" })
	minEms!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "ems" })
	ems!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "ellipsize" })
	ellipsize!:CommandAttr<Ellipsize>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "marqueeRepeatLimit" })
	marqueeRepeatLimit!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "justificationMode" })
	justificationMode!:CommandAttr<JustificationMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "shadowDx" })
	shadowDx!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "shadowDy" })
	shadowDy!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "singleLine" })
	singleLine!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "editable" })
	editable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textAllCaps" })
	textAllCaps!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxLength" })
	maxLength!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "typeface" })
	typeface!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textStyle" })
	textStyle!:CommandAttr<TextStyle[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "fontFamily" })
	fontFamily!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableLeft" })
	drawableLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableStart" })
	drawableStart!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableRight" })
	drawableRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableEnd" })
	drawableEnd!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableTop" })
	drawableTop!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableBottom" })
	drawableBottom!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawablePadding" })
	drawablePadding!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableTint" })
	drawableTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableTintMode" })
	drawableTintMode!:CommandAttr<DrawableTintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollHorizontally" })
	scrollHorizontally!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "firstBaselineToTopHeight" })
	firstBaselineToTopHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "lastBaselineToBottomHeight" })
	lastBaselineToBottomHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textColor" })
	textColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textFormat" })
	textFormat!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.iosText = undefined;
		this.iosTextColor = undefined;
		this.iosIsEnabled = undefined;
		this.iosAdjustsFontSizeToFitWidth = undefined;
		this.iosAllowsDefaultTighteningForTruncation = undefined;
		this.iosMinimumScaleFactor = undefined;
		this.iosNumberOfLines = undefined;
		this.iosHighlightedTextColor = undefined;
		this.iosIsHighlighted = undefined;
		this.iosShadowColor = undefined;
		this.iosPreferredMaxLayoutWidth = undefined;
		this.iosIsUserInteractionEnabled = undefined;
		this.checked = undefined;
		this.onCheckedChange = undefined;
		this.button = undefined;
		this.buttonTint = undefined;
		this.buttonTintMode = undefined;
		this.text = undefined;
		this.gravity = undefined;
		this.textSize = undefined;
		this.padding = undefined;
		this.paddingBottom = undefined;
		this.paddingRight = undefined;
		this.paddingLeft = undefined;
		this.paddingStart = undefined;
		this.paddingEnd = undefined;
		this.paddingTop = undefined;
		this.paddingHorizontal = undefined;
		this.paddingVertical = undefined;
		this.minLines = undefined;
		this.lines = undefined;
		this.maxLines = undefined;
		this.minWidth = undefined;
		this.minHeight = undefined;
		this.maxWidth = undefined;
		this.maxHeight = undefined;
		this.height = undefined;
		this.width = undefined;
		this.maxEms = undefined;
		this.minEms = undefined;
		this.ems = undefined;
		this.ellipsize = undefined;
		this.marqueeRepeatLimit = undefined;
		this.justificationMode = undefined;
		this.shadowDx = undefined;
		this.shadowDy = undefined;
		this.singleLine = undefined;
		this.editable = undefined;
		this.textAllCaps = undefined;
		this.maxLength = undefined;
		this.typeface = undefined;
		this.textStyle = undefined;
		this.fontFamily = undefined;
		this.drawableLeft = undefined;
		this.drawableStart = undefined;
		this.drawableRight = undefined;
		this.drawableEnd = undefined;
		this.drawableTop = undefined;
		this.drawableBottom = undefined;
		this.drawablePadding = undefined;
		this.drawableTint = undefined;
		this.drawableTintMode = undefined;
		this.scrollHorizontally = undefined;
		this.firstBaselineToTopHeight = undefined;
		this.lastBaselineToBottomHeight = undefined;
		this.textColor = undefined;
		this.textFormat = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetIosText() : T {
		this.resetIfRequired();
		if (this.iosText == null || this.iosText == undefined) {
			this.iosText = new CommandAttr<string>()
		}
		
		this.iosText.setGetter(true);
		this.orderGet++;
		this.iosText.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosText() : string {
		if (this.iosText == null || this.iosText == undefined) {
			this.iosText = new CommandAttr<string>();
		}
		return this.iosText.getCommandReturnValue();
	}
	public setIosText(value : string) : T {
		this.resetIfRequired();
		if (this.iosText == null || this.iosText == undefined) {
			this.iosText = new CommandAttr<string>();
		}
		
		this.iosText.setSetter(true);
		this.iosText.setValue(value);
		this.orderSet++;
		this.iosText.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosTextColor() : T {
		this.resetIfRequired();
		if (this.iosTextColor == null || this.iosTextColor == undefined) {
			this.iosTextColor = new CommandAttr<string>()
		}
		
		this.iosTextColor.setGetter(true);
		this.orderGet++;
		this.iosTextColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosTextColor() : string {
		if (this.iosTextColor == null || this.iosTextColor == undefined) {
			this.iosTextColor = new CommandAttr<string>();
		}
		return this.iosTextColor.getCommandReturnValue();
	}
	public setIosTextColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosTextColor == null || this.iosTextColor == undefined) {
			this.iosTextColor = new CommandAttr<string>();
		}
		
		this.iosTextColor.setSetter(true);
		this.iosTextColor.setValue(value);
		this.orderSet++;
		this.iosTextColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsEnabled() : T {
		this.resetIfRequired();
		if (this.iosIsEnabled == null || this.iosIsEnabled == undefined) {
			this.iosIsEnabled = new CommandAttr<boolean>()
		}
		
		this.iosIsEnabled.setGetter(true);
		this.orderGet++;
		this.iosIsEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsEnabled() : boolean {
		if (this.iosIsEnabled == null || this.iosIsEnabled == undefined) {
			this.iosIsEnabled = new CommandAttr<boolean>();
		}
		return this.iosIsEnabled.getCommandReturnValue();
	}
	public setIosIsEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsEnabled == null || this.iosIsEnabled == undefined) {
			this.iosIsEnabled = new CommandAttr<boolean>();
		}
		
		this.iosIsEnabled.setSetter(true);
		this.iosIsEnabled.setValue(value);
		this.orderSet++;
		this.iosIsEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetEnabled() : T {
		this.resetIfRequired();
		if (this.iosIsEnabled == null || this.iosIsEnabled == undefined) {
			this.iosIsEnabled = new CommandAttr<boolean>()
		}
		
		this.iosIsEnabled.setGetter(true);
		this.orderGet++;
		this.iosIsEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getEnabled() : boolean {
		if (this.iosIsEnabled == null || this.iosIsEnabled == undefined) {
			this.iosIsEnabled = new CommandAttr<boolean>();
		}
		return this.iosIsEnabled.getCommandReturnValue();
	}
	public setEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsEnabled == null || this.iosIsEnabled == undefined) {
			this.iosIsEnabled = new CommandAttr<boolean>();
		}
		
		this.iosIsEnabled.setSetter(true);
		this.iosIsEnabled.setValue(value);
		this.orderSet++;
		this.iosIsEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAdjustsFontSizeToFitWidth() : T {
		this.resetIfRequired();
		if (this.iosAdjustsFontSizeToFitWidth == null || this.iosAdjustsFontSizeToFitWidth == undefined) {
			this.iosAdjustsFontSizeToFitWidth = new CommandAttr<boolean>()
		}
		
		this.iosAdjustsFontSizeToFitWidth.setGetter(true);
		this.orderGet++;
		this.iosAdjustsFontSizeToFitWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAdjustsFontSizeToFitWidth() : boolean {
		if (this.iosAdjustsFontSizeToFitWidth == null || this.iosAdjustsFontSizeToFitWidth == undefined) {
			this.iosAdjustsFontSizeToFitWidth = new CommandAttr<boolean>();
		}
		return this.iosAdjustsFontSizeToFitWidth.getCommandReturnValue();
	}
	public setIosAdjustsFontSizeToFitWidth(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAdjustsFontSizeToFitWidth == null || this.iosAdjustsFontSizeToFitWidth == undefined) {
			this.iosAdjustsFontSizeToFitWidth = new CommandAttr<boolean>();
		}
		
		this.iosAdjustsFontSizeToFitWidth.setSetter(true);
		this.iosAdjustsFontSizeToFitWidth.setValue(value);
		this.orderSet++;
		this.iosAdjustsFontSizeToFitWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAllowsDefaultTighteningForTruncation() : T {
		this.resetIfRequired();
		if (this.iosAllowsDefaultTighteningForTruncation == null || this.iosAllowsDefaultTighteningForTruncation == undefined) {
			this.iosAllowsDefaultTighteningForTruncation = new CommandAttr<boolean>()
		}
		
		this.iosAllowsDefaultTighteningForTruncation.setGetter(true);
		this.orderGet++;
		this.iosAllowsDefaultTighteningForTruncation.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAllowsDefaultTighteningForTruncation() : boolean {
		if (this.iosAllowsDefaultTighteningForTruncation == null || this.iosAllowsDefaultTighteningForTruncation == undefined) {
			this.iosAllowsDefaultTighteningForTruncation = new CommandAttr<boolean>();
		}
		return this.iosAllowsDefaultTighteningForTruncation.getCommandReturnValue();
	}
	public setIosAllowsDefaultTighteningForTruncation(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAllowsDefaultTighteningForTruncation == null || this.iosAllowsDefaultTighteningForTruncation == undefined) {
			this.iosAllowsDefaultTighteningForTruncation = new CommandAttr<boolean>();
		}
		
		this.iosAllowsDefaultTighteningForTruncation.setSetter(true);
		this.iosAllowsDefaultTighteningForTruncation.setValue(value);
		this.orderSet++;
		this.iosAllowsDefaultTighteningForTruncation.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosMinimumScaleFactor() : T {
		this.resetIfRequired();
		if (this.iosMinimumScaleFactor == null || this.iosMinimumScaleFactor == undefined) {
			this.iosMinimumScaleFactor = new CommandAttr<number>()
		}
		
		this.iosMinimumScaleFactor.setGetter(true);
		this.orderGet++;
		this.iosMinimumScaleFactor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosMinimumScaleFactor() : number {
		if (this.iosMinimumScaleFactor == null || this.iosMinimumScaleFactor == undefined) {
			this.iosMinimumScaleFactor = new CommandAttr<number>();
		}
		return this.iosMinimumScaleFactor.getCommandReturnValue();
	}
	public setIosMinimumScaleFactor(value : number) : T {
		this.resetIfRequired();
		if (this.iosMinimumScaleFactor == null || this.iosMinimumScaleFactor == undefined) {
			this.iosMinimumScaleFactor = new CommandAttr<number>();
		}
		
		this.iosMinimumScaleFactor.setSetter(true);
		this.iosMinimumScaleFactor.setValue(value);
		this.orderSet++;
		this.iosMinimumScaleFactor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosNumberOfLines() : T {
		this.resetIfRequired();
		if (this.iosNumberOfLines == null || this.iosNumberOfLines == undefined) {
			this.iosNumberOfLines = new CommandAttr<number>()
		}
		
		this.iosNumberOfLines.setGetter(true);
		this.orderGet++;
		this.iosNumberOfLines.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosNumberOfLines() : number {
		if (this.iosNumberOfLines == null || this.iosNumberOfLines == undefined) {
			this.iosNumberOfLines = new CommandAttr<number>();
		}
		return this.iosNumberOfLines.getCommandReturnValue();
	}
	public setIosNumberOfLines(value : number) : T {
		this.resetIfRequired();
		if (this.iosNumberOfLines == null || this.iosNumberOfLines == undefined) {
			this.iosNumberOfLines = new CommandAttr<number>();
		}
		
		this.iosNumberOfLines.setSetter(true);
		this.iosNumberOfLines.setValue(value);
		this.orderSet++;
		this.iosNumberOfLines.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosHighlightedTextColor() : T {
		this.resetIfRequired();
		if (this.iosHighlightedTextColor == null || this.iosHighlightedTextColor == undefined) {
			this.iosHighlightedTextColor = new CommandAttr<string>()
		}
		
		this.iosHighlightedTextColor.setGetter(true);
		this.orderGet++;
		this.iosHighlightedTextColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosHighlightedTextColor() : string {
		if (this.iosHighlightedTextColor == null || this.iosHighlightedTextColor == undefined) {
			this.iosHighlightedTextColor = new CommandAttr<string>();
		}
		return this.iosHighlightedTextColor.getCommandReturnValue();
	}
	public setIosHighlightedTextColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosHighlightedTextColor == null || this.iosHighlightedTextColor == undefined) {
			this.iosHighlightedTextColor = new CommandAttr<string>();
		}
		
		this.iosHighlightedTextColor.setSetter(true);
		this.iosHighlightedTextColor.setValue(value);
		this.orderSet++;
		this.iosHighlightedTextColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTextColorHighlight() : T {
		this.resetIfRequired();
		if (this.iosHighlightedTextColor == null || this.iosHighlightedTextColor == undefined) {
			this.iosHighlightedTextColor = new CommandAttr<string>()
		}
		
		this.iosHighlightedTextColor.setGetter(true);
		this.orderGet++;
		this.iosHighlightedTextColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTextColorHighlight() : string {
		if (this.iosHighlightedTextColor == null || this.iosHighlightedTextColor == undefined) {
			this.iosHighlightedTextColor = new CommandAttr<string>();
		}
		return this.iosHighlightedTextColor.getCommandReturnValue();
	}
	public setTextColorHighlight(value : string) : T {
		this.resetIfRequired();
		if (this.iosHighlightedTextColor == null || this.iosHighlightedTextColor == undefined) {
			this.iosHighlightedTextColor = new CommandAttr<string>();
		}
		
		this.iosHighlightedTextColor.setSetter(true);
		this.iosHighlightedTextColor.setValue(value);
		this.orderSet++;
		this.iosHighlightedTextColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsHighlighted() : T {
		this.resetIfRequired();
		if (this.iosIsHighlighted == null || this.iosIsHighlighted == undefined) {
			this.iosIsHighlighted = new CommandAttr<boolean>()
		}
		
		this.iosIsHighlighted.setGetter(true);
		this.orderGet++;
		this.iosIsHighlighted.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsHighlighted() : boolean {
		if (this.iosIsHighlighted == null || this.iosIsHighlighted == undefined) {
			this.iosIsHighlighted = new CommandAttr<boolean>();
		}
		return this.iosIsHighlighted.getCommandReturnValue();
	}
	public setIosIsHighlighted(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsHighlighted == null || this.iosIsHighlighted == undefined) {
			this.iosIsHighlighted = new CommandAttr<boolean>();
		}
		
		this.iosIsHighlighted.setSetter(true);
		this.iosIsHighlighted.setValue(value);
		this.orderSet++;
		this.iosIsHighlighted.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosShadowColor() : T {
		this.resetIfRequired();
		if (this.iosShadowColor == null || this.iosShadowColor == undefined) {
			this.iosShadowColor = new CommandAttr<string>()
		}
		
		this.iosShadowColor.setGetter(true);
		this.orderGet++;
		this.iosShadowColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosShadowColor() : string {
		if (this.iosShadowColor == null || this.iosShadowColor == undefined) {
			this.iosShadowColor = new CommandAttr<string>();
		}
		return this.iosShadowColor.getCommandReturnValue();
	}
	public setIosShadowColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosShadowColor == null || this.iosShadowColor == undefined) {
			this.iosShadowColor = new CommandAttr<string>();
		}
		
		this.iosShadowColor.setSetter(true);
		this.iosShadowColor.setValue(value);
		this.orderSet++;
		this.iosShadowColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetShadowColor() : T {
		this.resetIfRequired();
		if (this.iosShadowColor == null || this.iosShadowColor == undefined) {
			this.iosShadowColor = new CommandAttr<string>()
		}
		
		this.iosShadowColor.setGetter(true);
		this.orderGet++;
		this.iosShadowColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getShadowColor() : string {
		if (this.iosShadowColor == null || this.iosShadowColor == undefined) {
			this.iosShadowColor = new CommandAttr<string>();
		}
		return this.iosShadowColor.getCommandReturnValue();
	}
	public setShadowColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosShadowColor == null || this.iosShadowColor == undefined) {
			this.iosShadowColor = new CommandAttr<string>();
		}
		
		this.iosShadowColor.setSetter(true);
		this.iosShadowColor.setValue(value);
		this.orderSet++;
		this.iosShadowColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosPreferredMaxLayoutWidth() : T {
		this.resetIfRequired();
		if (this.iosPreferredMaxLayoutWidth == null || this.iosPreferredMaxLayoutWidth == undefined) {
			this.iosPreferredMaxLayoutWidth = new CommandAttr<number>()
		}
		
		this.iosPreferredMaxLayoutWidth.setGetter(true);
		this.orderGet++;
		this.iosPreferredMaxLayoutWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosPreferredMaxLayoutWidth() : number {
		if (this.iosPreferredMaxLayoutWidth == null || this.iosPreferredMaxLayoutWidth == undefined) {
			this.iosPreferredMaxLayoutWidth = new CommandAttr<number>();
		}
		return this.iosPreferredMaxLayoutWidth.getCommandReturnValue();
	}
	public setIosPreferredMaxLayoutWidth(value : number) : T {
		this.resetIfRequired();
		if (this.iosPreferredMaxLayoutWidth == null || this.iosPreferredMaxLayoutWidth == undefined) {
			this.iosPreferredMaxLayoutWidth = new CommandAttr<number>();
		}
		
		this.iosPreferredMaxLayoutWidth.setSetter(true);
		this.iosPreferredMaxLayoutWidth.setValue(value);
		this.orderSet++;
		this.iosPreferredMaxLayoutWidth.setOrderSet(this.orderSet);
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
		

	public tryGetChecked() : T {
		this.resetIfRequired();
		if (this.checked == null || this.checked == undefined) {
			this.checked = new CommandAttr<boolean>()
		}
		
		this.checked.setGetter(true);
		this.orderGet++;
		this.checked.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isChecked() : boolean {
		if (this.checked == null || this.checked == undefined) {
			this.checked = new CommandAttr<boolean>();
		}
		return this.checked.getCommandReturnValue();
	}
	public setChecked(value : boolean) : T {
		this.resetIfRequired();
		if (this.checked == null || this.checked == undefined) {
			this.checked = new CommandAttr<boolean>();
		}
		
		this.checked.setSetter(true);
		this.checked.setValue(value);
		this.orderSet++;
		this.checked.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnCheckedChange(value : string) : T {
		this.resetIfRequired();
		if (this.onCheckedChange == null || this.onCheckedChange == undefined) {
			this.onCheckedChange = new CommandAttr<string>();
		}
		
		this.onCheckedChange.setSetter(true);
		this.onCheckedChange.setValue(value);
		this.orderSet++;
		this.onCheckedChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetButton() : T {
		this.resetIfRequired();
		if (this.button == null || this.button == undefined) {
			this.button = new CommandAttr<string>()
		}
		
		this.button.setGetter(true);
		this.orderGet++;
		this.button.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getButton() : string {
		if (this.button == null || this.button == undefined) {
			this.button = new CommandAttr<string>();
		}
		return this.button.getCommandReturnValue();
	}
	public setButton(value : string) : T {
		this.resetIfRequired();
		if (this.button == null || this.button == undefined) {
			this.button = new CommandAttr<string>();
		}
		
		this.button.setSetter(true);
		this.button.setValue(value);
		this.orderSet++;
		this.button.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setButtonTint(value : string) : T {
		this.resetIfRequired();
		if (this.buttonTint == null || this.buttonTint == undefined) {
			this.buttonTint = new CommandAttr<string>();
		}
		
		this.buttonTint.setSetter(true);
		this.buttonTint.setValue(value);
		this.orderSet++;
		this.buttonTint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setButtonTintMode(value : ButtonTinttMode) : T {
		this.resetIfRequired();
		if (this.buttonTintMode == null || this.buttonTintMode == undefined) {
			this.buttonTintMode = new CommandAttr<ButtonTinttMode>();
		}
		
		this.buttonTintMode.setSetter(true);
		this.buttonTintMode.setValue(value);
		this.orderSet++;
		this.buttonTintMode.setOrderSet(this.orderSet);
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
		

	public tryGetGravity() : T {
		this.resetIfRequired();
		if (this.gravity == null || this.gravity == undefined) {
			this.gravity = new CommandAttr<Gravity[]>()
		}
		
		this.gravity.setGetter(true);
		this.orderGet++;
		this.gravity.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getGravity() : Gravity[] {
		if (this.gravity == null || this.gravity == undefined) {
			this.gravity = new CommandAttr<Gravity[]>();
		}
this.gravity.setTransformer('gravity');		return this.gravity.getCommandReturnValue();
	}
	public setGravity(...value : Gravity[]) : T {
		this.resetIfRequired();
		if (this.gravity == null || this.gravity == undefined) {
			this.gravity = new CommandAttr<Gravity[]>();
		}
		
		this.gravity.setSetter(true);
		this.gravity.setValue(value);
		this.orderSet++;
		this.gravity.setOrderSet(this.orderSet);
this.gravity.setTransformer('gravity');		return this.thisPointer;
	}
		

	public tryGetTextSize() : T {
		this.resetIfRequired();
		if (this.textSize == null || this.textSize == undefined) {
			this.textSize = new CommandAttr<string>()
		}
		
		this.textSize.setGetter(true);
		this.orderGet++;
		this.textSize.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTextSize() : string {
		if (this.textSize == null || this.textSize == undefined) {
			this.textSize = new CommandAttr<string>();
		}
		return this.textSize.getCommandReturnValue();
	}
	public setTextSize(value : string) : T {
		this.resetIfRequired();
		if (this.textSize == null || this.textSize == undefined) {
			this.textSize = new CommandAttr<string>();
		}
		
		this.textSize.setSetter(true);
		this.textSize.setValue(value);
		this.orderSet++;
		this.textSize.setOrderSet(this.orderSet);
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
		

	public tryGetMinLines() : T {
		this.resetIfRequired();
		if (this.minLines == null || this.minLines == undefined) {
			this.minLines = new CommandAttr<number>()
		}
		
		this.minLines.setGetter(true);
		this.orderGet++;
		this.minLines.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getMinLines() : number {
		if (this.minLines == null || this.minLines == undefined) {
			this.minLines = new CommandAttr<number>();
		}
		return this.minLines.getCommandReturnValue();
	}
	public setMinLines(value : number) : T {
		this.resetIfRequired();
		if (this.minLines == null || this.minLines == undefined) {
			this.minLines = new CommandAttr<number>();
		}
		
		this.minLines.setSetter(true);
		this.minLines.setValue(value);
		this.orderSet++;
		this.minLines.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setLines(value : number) : T {
		this.resetIfRequired();
		if (this.lines == null || this.lines == undefined) {
			this.lines = new CommandAttr<number>();
		}
		
		this.lines.setSetter(true);
		this.lines.setValue(value);
		this.orderSet++;
		this.lines.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetMaxLines() : T {
		this.resetIfRequired();
		if (this.maxLines == null || this.maxLines == undefined) {
			this.maxLines = new CommandAttr<number>()
		}
		
		this.maxLines.setGetter(true);
		this.orderGet++;
		this.maxLines.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getMaxLines() : number {
		if (this.maxLines == null || this.maxLines == undefined) {
			this.maxLines = new CommandAttr<number>();
		}
		return this.maxLines.getCommandReturnValue();
	}
	public setMaxLines(value : number) : T {
		this.resetIfRequired();
		if (this.maxLines == null || this.maxLines == undefined) {
			this.maxLines = new CommandAttr<number>();
		}
		
		this.maxLines.setSetter(true);
		this.maxLines.setValue(value);
		this.orderSet++;
		this.maxLines.setOrderSet(this.orderSet);
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
		

	public tryGetHeight() : T {
		this.resetIfRequired();
		if (this.height == null || this.height == undefined) {
			this.height = new CommandAttr<string>()
		}
		
		this.height.setGetter(true);
		this.orderGet++;
		this.height.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getHeight() : string {
		if (this.height == null || this.height == undefined) {
			this.height = new CommandAttr<string>();
		}
		return this.height.getCommandReturnValue();
	}
	public setHeight(value : string) : T {
		this.resetIfRequired();
		if (this.height == null || this.height == undefined) {
			this.height = new CommandAttr<string>();
		}
		
		this.height.setSetter(true);
		this.height.setValue(value);
		this.orderSet++;
		this.height.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetWidth() : T {
		this.resetIfRequired();
		if (this.width == null || this.width == undefined) {
			this.width = new CommandAttr<string>()
		}
		
		this.width.setGetter(true);
		this.orderGet++;
		this.width.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getWidth() : string {
		if (this.width == null || this.width == undefined) {
			this.width = new CommandAttr<string>();
		}
		return this.width.getCommandReturnValue();
	}
	public setWidth(value : string) : T {
		this.resetIfRequired();
		if (this.width == null || this.width == undefined) {
			this.width = new CommandAttr<string>();
		}
		
		this.width.setSetter(true);
		this.width.setValue(value);
		this.orderSet++;
		this.width.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetMaxEms() : T {
		this.resetIfRequired();
		if (this.maxEms == null || this.maxEms == undefined) {
			this.maxEms = new CommandAttr<number>()
		}
		
		this.maxEms.setGetter(true);
		this.orderGet++;
		this.maxEms.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getMaxEms() : number {
		if (this.maxEms == null || this.maxEms == undefined) {
			this.maxEms = new CommandAttr<number>();
		}
		return this.maxEms.getCommandReturnValue();
	}
	public setMaxEms(value : number) : T {
		this.resetIfRequired();
		if (this.maxEms == null || this.maxEms == undefined) {
			this.maxEms = new CommandAttr<number>();
		}
		
		this.maxEms.setSetter(true);
		this.maxEms.setValue(value);
		this.orderSet++;
		this.maxEms.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetMinEms() : T {
		this.resetIfRequired();
		if (this.minEms == null || this.minEms == undefined) {
			this.minEms = new CommandAttr<number>()
		}
		
		this.minEms.setGetter(true);
		this.orderGet++;
		this.minEms.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getMinEms() : number {
		if (this.minEms == null || this.minEms == undefined) {
			this.minEms = new CommandAttr<number>();
		}
		return this.minEms.getCommandReturnValue();
	}
	public setMinEms(value : number) : T {
		this.resetIfRequired();
		if (this.minEms == null || this.minEms == undefined) {
			this.minEms = new CommandAttr<number>();
		}
		
		this.minEms.setSetter(true);
		this.minEms.setValue(value);
		this.orderSet++;
		this.minEms.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setEms(value : number) : T {
		this.resetIfRequired();
		if (this.ems == null || this.ems == undefined) {
			this.ems = new CommandAttr<number>();
		}
		
		this.ems.setSetter(true);
		this.ems.setValue(value);
		this.orderSet++;
		this.ems.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetEllipsize() : T {
		this.resetIfRequired();
		if (this.ellipsize == null || this.ellipsize == undefined) {
			this.ellipsize = new CommandAttr<Ellipsize>()
		}
		
		this.ellipsize.setGetter(true);
		this.orderGet++;
		this.ellipsize.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getEllipsize() : Ellipsize {
		if (this.ellipsize == null || this.ellipsize == undefined) {
			this.ellipsize = new CommandAttr<Ellipsize>();
		}
		return this.ellipsize.getCommandReturnValue();
	}
	public setEllipsize(value : Ellipsize) : T {
		this.resetIfRequired();
		if (this.ellipsize == null || this.ellipsize == undefined) {
			this.ellipsize = new CommandAttr<Ellipsize>();
		}
		
		this.ellipsize.setSetter(true);
		this.ellipsize.setValue(value);
		this.orderSet++;
		this.ellipsize.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetMarqueeRepeatLimit() : T {
		this.resetIfRequired();
		if (this.marqueeRepeatLimit == null || this.marqueeRepeatLimit == undefined) {
			this.marqueeRepeatLimit = new CommandAttr<string>()
		}
		
		this.marqueeRepeatLimit.setGetter(true);
		this.orderGet++;
		this.marqueeRepeatLimit.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getMarqueeRepeatLimit() : string {
		if (this.marqueeRepeatLimit == null || this.marqueeRepeatLimit == undefined) {
			this.marqueeRepeatLimit = new CommandAttr<string>();
		}
		return this.marqueeRepeatLimit.getCommandReturnValue();
	}
	public setMarqueeRepeatLimit(value : string) : T {
		this.resetIfRequired();
		if (this.marqueeRepeatLimit == null || this.marqueeRepeatLimit == undefined) {
			this.marqueeRepeatLimit = new CommandAttr<string>();
		}
		
		this.marqueeRepeatLimit.setSetter(true);
		this.marqueeRepeatLimit.setValue(value);
		this.orderSet++;
		this.marqueeRepeatLimit.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetJustificationMode() : T {
		this.resetIfRequired();
		if (this.justificationMode == null || this.justificationMode == undefined) {
			this.justificationMode = new CommandAttr<JustificationMode>()
		}
		
		this.justificationMode.setGetter(true);
		this.orderGet++;
		this.justificationMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getJustificationMode() : JustificationMode {
		if (this.justificationMode == null || this.justificationMode == undefined) {
			this.justificationMode = new CommandAttr<JustificationMode>();
		}
		return this.justificationMode.getCommandReturnValue();
	}
	public setJustificationMode(value : JustificationMode) : T {
		this.resetIfRequired();
		if (this.justificationMode == null || this.justificationMode == undefined) {
			this.justificationMode = new CommandAttr<JustificationMode>();
		}
		
		this.justificationMode.setSetter(true);
		this.justificationMode.setValue(value);
		this.orderSet++;
		this.justificationMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetShadowDx() : T {
		this.resetIfRequired();
		if (this.shadowDx == null || this.shadowDx == undefined) {
			this.shadowDx = new CommandAttr<number>()
		}
		
		this.shadowDx.setGetter(true);
		this.orderGet++;
		this.shadowDx.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getShadowDx() : number {
		if (this.shadowDx == null || this.shadowDx == undefined) {
			this.shadowDx = new CommandAttr<number>();
		}
		return this.shadowDx.getCommandReturnValue();
	}
	public setShadowDx(value : number) : T {
		this.resetIfRequired();
		if (this.shadowDx == null || this.shadowDx == undefined) {
			this.shadowDx = new CommandAttr<number>();
		}
		
		this.shadowDx.setSetter(true);
		this.shadowDx.setValue(value);
		this.orderSet++;
		this.shadowDx.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetShadowDy() : T {
		this.resetIfRequired();
		if (this.shadowDy == null || this.shadowDy == undefined) {
			this.shadowDy = new CommandAttr<number>()
		}
		
		this.shadowDy.setGetter(true);
		this.orderGet++;
		this.shadowDy.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getShadowDy() : number {
		if (this.shadowDy == null || this.shadowDy == undefined) {
			this.shadowDy = new CommandAttr<number>();
		}
		return this.shadowDy.getCommandReturnValue();
	}
	public setShadowDy(value : number) : T {
		this.resetIfRequired();
		if (this.shadowDy == null || this.shadowDy == undefined) {
			this.shadowDy = new CommandAttr<number>();
		}
		
		this.shadowDy.setSetter(true);
		this.shadowDy.setValue(value);
		this.orderSet++;
		this.shadowDy.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSingleLine(value : boolean) : T {
		this.resetIfRequired();
		if (this.singleLine == null || this.singleLine == undefined) {
			this.singleLine = new CommandAttr<boolean>();
		}
		
		this.singleLine.setSetter(true);
		this.singleLine.setValue(value);
		this.orderSet++;
		this.singleLine.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setEditable(value : boolean) : T {
		this.resetIfRequired();
		if (this.editable == null || this.editable == undefined) {
			this.editable = new CommandAttr<boolean>();
		}
		
		this.editable.setSetter(true);
		this.editable.setValue(value);
		this.orderSet++;
		this.editable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTextAllCaps(value : boolean) : T {
		this.resetIfRequired();
		if (this.textAllCaps == null || this.textAllCaps == undefined) {
			this.textAllCaps = new CommandAttr<boolean>();
		}
		
		this.textAllCaps.setSetter(true);
		this.textAllCaps.setValue(value);
		this.orderSet++;
		this.textAllCaps.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setMaxLength(value : number) : T {
		this.resetIfRequired();
		if (this.maxLength == null || this.maxLength == undefined) {
			this.maxLength = new CommandAttr<number>();
		}
		
		this.maxLength.setSetter(true);
		this.maxLength.setValue(value);
		this.orderSet++;
		this.maxLength.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTypeface(value : string) : T {
		this.resetIfRequired();
		if (this.typeface == null || this.typeface == undefined) {
			this.typeface = new CommandAttr<string>();
		}
		
		this.typeface.setSetter(true);
		this.typeface.setValue(value);
		this.orderSet++;
		this.typeface.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTextStyle(...value : TextStyle[]) : T {
		this.resetIfRequired();
		if (this.textStyle == null || this.textStyle == undefined) {
			this.textStyle = new CommandAttr<TextStyle[]>();
		}
		
		this.textStyle.setSetter(true);
		this.textStyle.setValue(value);
		this.orderSet++;
		this.textStyle.setOrderSet(this.orderSet);
this.textStyle.setTransformer('textStyle');		return this.thisPointer;
	}
		

	public setFontFamily(value : string) : T {
		this.resetIfRequired();
		if (this.fontFamily == null || this.fontFamily == undefined) {
			this.fontFamily = new CommandAttr<string>();
		}
		
		this.fontFamily.setSetter(true);
		this.fontFamily.setValue(value);
		this.orderSet++;
		this.fontFamily.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDrawableLeft(value : string) : T {
		this.resetIfRequired();
		if (this.drawableLeft == null || this.drawableLeft == undefined) {
			this.drawableLeft = new CommandAttr<string>();
		}
		
		this.drawableLeft.setSetter(true);
		this.drawableLeft.setValue(value);
		this.orderSet++;
		this.drawableLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDrawableStart(value : string) : T {
		this.resetIfRequired();
		if (this.drawableStart == null || this.drawableStart == undefined) {
			this.drawableStart = new CommandAttr<string>();
		}
		
		this.drawableStart.setSetter(true);
		this.drawableStart.setValue(value);
		this.orderSet++;
		this.drawableStart.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDrawableRight(value : string) : T {
		this.resetIfRequired();
		if (this.drawableRight == null || this.drawableRight == undefined) {
			this.drawableRight = new CommandAttr<string>();
		}
		
		this.drawableRight.setSetter(true);
		this.drawableRight.setValue(value);
		this.orderSet++;
		this.drawableRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDrawableEnd(value : string) : T {
		this.resetIfRequired();
		if (this.drawableEnd == null || this.drawableEnd == undefined) {
			this.drawableEnd = new CommandAttr<string>();
		}
		
		this.drawableEnd.setSetter(true);
		this.drawableEnd.setValue(value);
		this.orderSet++;
		this.drawableEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDrawableTop(value : string) : T {
		this.resetIfRequired();
		if (this.drawableTop == null || this.drawableTop == undefined) {
			this.drawableTop = new CommandAttr<string>();
		}
		
		this.drawableTop.setSetter(true);
		this.drawableTop.setValue(value);
		this.orderSet++;
		this.drawableTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDrawableBottom(value : string) : T {
		this.resetIfRequired();
		if (this.drawableBottom == null || this.drawableBottom == undefined) {
			this.drawableBottom = new CommandAttr<string>();
		}
		
		this.drawableBottom.setSetter(true);
		this.drawableBottom.setValue(value);
		this.orderSet++;
		this.drawableBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetDrawablePadding() : T {
		this.resetIfRequired();
		if (this.drawablePadding == null || this.drawablePadding == undefined) {
			this.drawablePadding = new CommandAttr<string>()
		}
		
		this.drawablePadding.setGetter(true);
		this.orderGet++;
		this.drawablePadding.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getDrawablePadding() : string {
		if (this.drawablePadding == null || this.drawablePadding == undefined) {
			this.drawablePadding = new CommandAttr<string>();
		}
		return this.drawablePadding.getCommandReturnValue();
	}
	public setDrawablePadding(value : string) : T {
		this.resetIfRequired();
		if (this.drawablePadding == null || this.drawablePadding == undefined) {
			this.drawablePadding = new CommandAttr<string>();
		}
		
		this.drawablePadding.setSetter(true);
		this.drawablePadding.setValue(value);
		this.orderSet++;
		this.drawablePadding.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDrawableTint(value : string) : T {
		this.resetIfRequired();
		if (this.drawableTint == null || this.drawableTint == undefined) {
			this.drawableTint = new CommandAttr<string>();
		}
		
		this.drawableTint.setSetter(true);
		this.drawableTint.setValue(value);
		this.orderSet++;
		this.drawableTint.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDrawableTintMode(value : DrawableTintMode) : T {
		this.resetIfRequired();
		if (this.drawableTintMode == null || this.drawableTintMode == undefined) {
			this.drawableTintMode = new CommandAttr<DrawableTintMode>();
		}
		
		this.drawableTintMode.setSetter(true);
		this.drawableTintMode.setValue(value);
		this.orderSet++;
		this.drawableTintMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setScrollHorizontally(value : boolean) : T {
		this.resetIfRequired();
		if (this.scrollHorizontally == null || this.scrollHorizontally == undefined) {
			this.scrollHorizontally = new CommandAttr<boolean>();
		}
		
		this.scrollHorizontally.setSetter(true);
		this.scrollHorizontally.setValue(value);
		this.orderSet++;
		this.scrollHorizontally.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetFirstBaselineToTopHeight() : T {
		this.resetIfRequired();
		if (this.firstBaselineToTopHeight == null || this.firstBaselineToTopHeight == undefined) {
			this.firstBaselineToTopHeight = new CommandAttr<string>()
		}
		
		this.firstBaselineToTopHeight.setGetter(true);
		this.orderGet++;
		this.firstBaselineToTopHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getFirstBaselineToTopHeight() : string {
		if (this.firstBaselineToTopHeight == null || this.firstBaselineToTopHeight == undefined) {
			this.firstBaselineToTopHeight = new CommandAttr<string>();
		}
		return this.firstBaselineToTopHeight.getCommandReturnValue();
	}
	public setFirstBaselineToTopHeight(value : string) : T {
		this.resetIfRequired();
		if (this.firstBaselineToTopHeight == null || this.firstBaselineToTopHeight == undefined) {
			this.firstBaselineToTopHeight = new CommandAttr<string>();
		}
		
		this.firstBaselineToTopHeight.setSetter(true);
		this.firstBaselineToTopHeight.setValue(value);
		this.orderSet++;
		this.firstBaselineToTopHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetLastBaselineToBottomHeight() : T {
		this.resetIfRequired();
		if (this.lastBaselineToBottomHeight == null || this.lastBaselineToBottomHeight == undefined) {
			this.lastBaselineToBottomHeight = new CommandAttr<string>()
		}
		
		this.lastBaselineToBottomHeight.setGetter(true);
		this.orderGet++;
		this.lastBaselineToBottomHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLastBaselineToBottomHeight() : string {
		if (this.lastBaselineToBottomHeight == null || this.lastBaselineToBottomHeight == undefined) {
			this.lastBaselineToBottomHeight = new CommandAttr<string>();
		}
		return this.lastBaselineToBottomHeight.getCommandReturnValue();
	}
	public setLastBaselineToBottomHeight(value : string) : T {
		this.resetIfRequired();
		if (this.lastBaselineToBottomHeight == null || this.lastBaselineToBottomHeight == undefined) {
			this.lastBaselineToBottomHeight = new CommandAttr<string>();
		}
		
		this.lastBaselineToBottomHeight.setSetter(true);
		this.lastBaselineToBottomHeight.setValue(value);
		this.orderSet++;
		this.lastBaselineToBottomHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTextColor() : T {
		this.resetIfRequired();
		if (this.textColor == null || this.textColor == undefined) {
			this.textColor = new CommandAttr<string>()
		}
		
		this.textColor.setGetter(true);
		this.orderGet++;
		this.textColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTextColor() : string {
		if (this.textColor == null || this.textColor == undefined) {
			this.textColor = new CommandAttr<string>();
		}
		return this.textColor.getCommandReturnValue();
	}
	public setTextColor(value : string) : T {
		this.resetIfRequired();
		if (this.textColor == null || this.textColor == undefined) {
			this.textColor = new CommandAttr<string>();
		}
		
		this.textColor.setSetter(true);
		this.textColor.setValue(value);
		this.orderSet++;
		this.textColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTextFormat(value : string) : T {
		this.resetIfRequired();
		if (this.textFormat == null || this.textFormat == undefined) {
			this.textFormat = new CommandAttr<string>();
		}
		
		this.textFormat.setSetter(true);
		this.textFormat.setValue(value);
		this.orderSet++;
		this.textFormat.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class CheckBox extends CheckBoxImpl<CheckBox> implements IWidget{
    getThisPointer(): CheckBox {
        return this;
    }
    
   	public getClass() {
		return CheckBox;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

CheckBoxImpl.initialize();

//end - staticinit
