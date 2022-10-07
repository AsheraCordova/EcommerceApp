// start - imports

export const enum AutoLink {
all = "all",
email = "email",
map = "map",
none = "none",
phone = "phone",
web = "web",
}
export const enum BreakStrategy {
balanced = "balanced",
high_quality = "high_quality",
simple = "simple",
}
export const enum Ellipsize {
end = "end",
marquee = "marquee",
middle = "middle",
none = "none",
start = "start",
}
export const enum HyphenationFrequency {
full = "full",
none = "none",
normal = "normal",
}
export const enum JustificationMode {
inter_word = "inter_word",
none = "none",
}
export const enum MarqueeRepeatLimit {
marquee_forever = "marquee_forever",
}
export const enum ButtonTintMode {
add = "add",
multiply = "multiply",
screen = "screen",
src_atop = "src_atop",
src_in = "src_in",
src_over = "src_over",
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


export class AutoLinkTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<AutoLink> = new Array<AutoLink>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "all":
						valueArr.push(AutoLink.all);
                       	break;	
					case "email":
						valueArr.push(AutoLink.email);
                       	break;	
					case "map":
						valueArr.push(AutoLink.map);
                       	break;	
					case "none":
						valueArr.push(AutoLink.none);
                       	break;	
					case "phone":
						valueArr.push(AutoLink.phone);
                       	break;	
					case "web":
						valueArr.push(AutoLink.web);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}

























































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
		TransformerFactory.getInstance().register("autoLink", new AutoLinkTransformer());
		TransformerFactory.getInstance().register("textStyle", new TextStyleTransformer());
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "autoLink" })
	autoLink!:CommandAttr<AutoLink[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "breakStrategy" })
	breakStrategy!:CommandAttr<BreakStrategy>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawablePadding" })
	drawablePadding!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "elegantTextHeight" })
	elegantTextHeight!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "ellipsize" })
	ellipsize!:CommandAttr<Ellipsize>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "ems" })
	ems!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "fallbackLineSpacing" })
	fallbackLineSpacing!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "firstBaselineToTopHeight" })
	firstBaselineToTopHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "fontFeatureSettings" })
	fontFeatureSettings!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "gravity" })
	gravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "height" })
	height!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "hyphenationFrequency" })
	hyphenationFrequency!:CommandAttr<HyphenationFrequency>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "includeFontPadding" })
	includeFontPadding!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "justificationMode" })
	justificationMode!:CommandAttr<JustificationMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "lastBaselineToBottomHeight" })
	lastBaselineToBottomHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "letterSpacing" })
	letterSpacing!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "lineHeight" })
	lineHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "lineSpacingExtra" })
	lineSpacingExtra!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "lineSpacingMultiplier" })
	lineSpacingMultiplier!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "lines" })
	lines!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "marqueeRepeatLimit" })
	marqueeRepeatLimit!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxEms" })
	maxEms!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxHeight" })
	maxHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxLines" })
	maxLines!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxWidth" })
	maxWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minEms" })
	minEms!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minHeight" })
	minHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minLines" })
	minLines!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minWidth" })
	minWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollHorizontally" })
	scrollHorizontally!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "shadowColor" })
	shadowColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "shadowDx" })
	shadowDx!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "shadowDy" })
	shadowDy!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "shadowRadius" })
	shadowRadius!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "singleLine" })
	singleLine!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textAllCaps" })
	textAllCaps!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textColor" })
	textColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textColorHighlight" })
	textColorHighlight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textColorLink" })
	textColorLink!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textIsSelectable" })
	textIsSelectable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textScaleX" })
	textScaleX!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "width" })
	width!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "button" })
	button!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "buttonTint" })
	buttonTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "buttonTintMode" })
	buttonTintMode!:CommandAttr<ButtonTintMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onCheckedChange" })
	onCheckedChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "checked" })
	checked!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "text" })
	text!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textSize" })
	textSize!:CommandAttr<string>| undefined;
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
	@Expose({ name: "textAppearance" })
	textAppearance!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "enabled" })
	enabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "editable" })
	editable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableTint" })
	drawableTint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableTintMode" })
	drawableTintMode!:CommandAttr<DrawableTintMode>| undefined;
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
	@Expose({ name: "textFormat" })
	textFormat!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.autoLink = undefined;
		this.breakStrategy = undefined;
		this.drawablePadding = undefined;
		this.elegantTextHeight = undefined;
		this.ellipsize = undefined;
		this.ems = undefined;
		this.fallbackLineSpacing = undefined;
		this.firstBaselineToTopHeight = undefined;
		this.fontFeatureSettings = undefined;
		this.gravity = undefined;
		this.height = undefined;
		this.hyphenationFrequency = undefined;
		this.includeFontPadding = undefined;
		this.justificationMode = undefined;
		this.lastBaselineToBottomHeight = undefined;
		this.letterSpacing = undefined;
		this.lineHeight = undefined;
		this.lineSpacingExtra = undefined;
		this.lineSpacingMultiplier = undefined;
		this.lines = undefined;
		this.marqueeRepeatLimit = undefined;
		this.maxEms = undefined;
		this.maxHeight = undefined;
		this.maxLines = undefined;
		this.maxWidth = undefined;
		this.minEms = undefined;
		this.minHeight = undefined;
		this.minLines = undefined;
		this.minWidth = undefined;
		this.scrollHorizontally = undefined;
		this.shadowColor = undefined;
		this.shadowDx = undefined;
		this.shadowDy = undefined;
		this.shadowRadius = undefined;
		this.singleLine = undefined;
		this.textAllCaps = undefined;
		this.textColor = undefined;
		this.textColorHighlight = undefined;
		this.textColorLink = undefined;
		this.textIsSelectable = undefined;
		this.textScaleX = undefined;
		this.width = undefined;
		this.button = undefined;
		this.buttonTint = undefined;
		this.buttonTintMode = undefined;
		this.onCheckedChange = undefined;
		this.checked = undefined;
		this.text = undefined;
		this.textSize = undefined;
		this.drawableLeft = undefined;
		this.drawableStart = undefined;
		this.drawableRight = undefined;
		this.drawableEnd = undefined;
		this.drawableTop = undefined;
		this.drawableBottom = undefined;
		this.maxLength = undefined;
		this.typeface = undefined;
		this.textStyle = undefined;
		this.fontFamily = undefined;
		this.textAppearance = undefined;
		this.enabled = undefined;
		this.editable = undefined;
		this.drawableTint = undefined;
		this.drawableTintMode = undefined;
		this.padding = undefined;
		this.paddingBottom = undefined;
		this.paddingRight = undefined;
		this.paddingLeft = undefined;
		this.paddingStart = undefined;
		this.paddingEnd = undefined;
		this.paddingTop = undefined;
		this.paddingHorizontal = undefined;
		this.paddingVertical = undefined;
		this.textFormat = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetAutoLink() : T {
		this.resetIfRequired();
		if (this.autoLink == null || this.autoLink == undefined) {
			this.autoLink = new CommandAttr<AutoLink[]>()
		}
		
		this.autoLink.setGetter(true);
		this.orderGet++;
		this.autoLink.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getAutoLink() : AutoLink[] {
		if (this.autoLink == null || this.autoLink == undefined) {
			this.autoLink = new CommandAttr<AutoLink[]>();
		}
this.autoLink.setTransformer('autoLink');		return this.autoLink.getCommandReturnValue();
	}
	public setAutoLink(...value : AutoLink[]) : T {
		this.resetIfRequired();
		if (this.autoLink == null || this.autoLink == undefined) {
			this.autoLink = new CommandAttr<AutoLink[]>();
		}
		
		this.autoLink.setSetter(true);
		this.autoLink.setValue(value);
		this.orderSet++;
		this.autoLink.setOrderSet(this.orderSet);
this.autoLink.setTransformer('autoLink');		return this.thisPointer;
	}
		

	public tryGetBreakStrategy() : T {
		this.resetIfRequired();
		if (this.breakStrategy == null || this.breakStrategy == undefined) {
			this.breakStrategy = new CommandAttr<BreakStrategy>()
		}
		
		this.breakStrategy.setGetter(true);
		this.orderGet++;
		this.breakStrategy.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBreakStrategy() : BreakStrategy {
		if (this.breakStrategy == null || this.breakStrategy == undefined) {
			this.breakStrategy = new CommandAttr<BreakStrategy>();
		}
		return this.breakStrategy.getCommandReturnValue();
	}
	public setBreakStrategy(value : BreakStrategy) : T {
		this.resetIfRequired();
		if (this.breakStrategy == null || this.breakStrategy == undefined) {
			this.breakStrategy = new CommandAttr<BreakStrategy>();
		}
		
		this.breakStrategy.setSetter(true);
		this.breakStrategy.setValue(value);
		this.orderSet++;
		this.breakStrategy.setOrderSet(this.orderSet);
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
		

	public tryGetElegantTextHeight() : T {
		this.resetIfRequired();
		if (this.elegantTextHeight == null || this.elegantTextHeight == undefined) {
			this.elegantTextHeight = new CommandAttr<boolean>()
		}
		
		this.elegantTextHeight.setGetter(true);
		this.orderGet++;
		this.elegantTextHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isElegantTextHeight() : boolean {
		if (this.elegantTextHeight == null || this.elegantTextHeight == undefined) {
			this.elegantTextHeight = new CommandAttr<boolean>();
		}
		return this.elegantTextHeight.getCommandReturnValue();
	}
	public setElegantTextHeight(value : boolean) : T {
		this.resetIfRequired();
		if (this.elegantTextHeight == null || this.elegantTextHeight == undefined) {
			this.elegantTextHeight = new CommandAttr<boolean>();
		}
		
		this.elegantTextHeight.setSetter(true);
		this.elegantTextHeight.setValue(value);
		this.orderSet++;
		this.elegantTextHeight.setOrderSet(this.orderSet);
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
		

	public tryGetFallbackLineSpacing() : T {
		this.resetIfRequired();
		if (this.fallbackLineSpacing == null || this.fallbackLineSpacing == undefined) {
			this.fallbackLineSpacing = new CommandAttr<boolean>()
		}
		
		this.fallbackLineSpacing.setGetter(true);
		this.orderGet++;
		this.fallbackLineSpacing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isFallbackLineSpacing() : boolean {
		if (this.fallbackLineSpacing == null || this.fallbackLineSpacing == undefined) {
			this.fallbackLineSpacing = new CommandAttr<boolean>();
		}
		return this.fallbackLineSpacing.getCommandReturnValue();
	}
	public setFallbackLineSpacing(value : boolean) : T {
		this.resetIfRequired();
		if (this.fallbackLineSpacing == null || this.fallbackLineSpacing == undefined) {
			this.fallbackLineSpacing = new CommandAttr<boolean>();
		}
		
		this.fallbackLineSpacing.setSetter(true);
		this.fallbackLineSpacing.setValue(value);
		this.orderSet++;
		this.fallbackLineSpacing.setOrderSet(this.orderSet);
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
		

	public tryGetFontFeatureSettings() : T {
		this.resetIfRequired();
		if (this.fontFeatureSettings == null || this.fontFeatureSettings == undefined) {
			this.fontFeatureSettings = new CommandAttr<string>()
		}
		
		this.fontFeatureSettings.setGetter(true);
		this.orderGet++;
		this.fontFeatureSettings.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getFontFeatureSettings() : string {
		if (this.fontFeatureSettings == null || this.fontFeatureSettings == undefined) {
			this.fontFeatureSettings = new CommandAttr<string>();
		}
		return this.fontFeatureSettings.getCommandReturnValue();
	}
	public setFontFeatureSettings(value : string) : T {
		this.resetIfRequired();
		if (this.fontFeatureSettings == null || this.fontFeatureSettings == undefined) {
			this.fontFeatureSettings = new CommandAttr<string>();
		}
		
		this.fontFeatureSettings.setSetter(true);
		this.fontFeatureSettings.setValue(value);
		this.orderSet++;
		this.fontFeatureSettings.setOrderSet(this.orderSet);
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
		

	public tryGetHyphenationFrequency() : T {
		this.resetIfRequired();
		if (this.hyphenationFrequency == null || this.hyphenationFrequency == undefined) {
			this.hyphenationFrequency = new CommandAttr<HyphenationFrequency>()
		}
		
		this.hyphenationFrequency.setGetter(true);
		this.orderGet++;
		this.hyphenationFrequency.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getHyphenationFrequency() : HyphenationFrequency {
		if (this.hyphenationFrequency == null || this.hyphenationFrequency == undefined) {
			this.hyphenationFrequency = new CommandAttr<HyphenationFrequency>();
		}
		return this.hyphenationFrequency.getCommandReturnValue();
	}
	public setHyphenationFrequency(value : HyphenationFrequency) : T {
		this.resetIfRequired();
		if (this.hyphenationFrequency == null || this.hyphenationFrequency == undefined) {
			this.hyphenationFrequency = new CommandAttr<HyphenationFrequency>();
		}
		
		this.hyphenationFrequency.setSetter(true);
		this.hyphenationFrequency.setValue(value);
		this.orderSet++;
		this.hyphenationFrequency.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIncludeFontPadding() : T {
		this.resetIfRequired();
		if (this.includeFontPadding == null || this.includeFontPadding == undefined) {
			this.includeFontPadding = new CommandAttr<boolean>()
		}
		
		this.includeFontPadding.setGetter(true);
		this.orderGet++;
		this.includeFontPadding.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIncludeFontPadding() : boolean {
		if (this.includeFontPadding == null || this.includeFontPadding == undefined) {
			this.includeFontPadding = new CommandAttr<boolean>();
		}
		return this.includeFontPadding.getCommandReturnValue();
	}
	public setIncludeFontPadding(value : boolean) : T {
		this.resetIfRequired();
		if (this.includeFontPadding == null || this.includeFontPadding == undefined) {
			this.includeFontPadding = new CommandAttr<boolean>();
		}
		
		this.includeFontPadding.setSetter(true);
		this.includeFontPadding.setValue(value);
		this.orderSet++;
		this.includeFontPadding.setOrderSet(this.orderSet);
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
		

	public tryGetLetterSpacing() : T {
		this.resetIfRequired();
		if (this.letterSpacing == null || this.letterSpacing == undefined) {
			this.letterSpacing = new CommandAttr<number>()
		}
		
		this.letterSpacing.setGetter(true);
		this.orderGet++;
		this.letterSpacing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLetterSpacing() : number {
		if (this.letterSpacing == null || this.letterSpacing == undefined) {
			this.letterSpacing = new CommandAttr<number>();
		}
		return this.letterSpacing.getCommandReturnValue();
	}
	public setLetterSpacing(value : number) : T {
		this.resetIfRequired();
		if (this.letterSpacing == null || this.letterSpacing == undefined) {
			this.letterSpacing = new CommandAttr<number>();
		}
		
		this.letterSpacing.setSetter(true);
		this.letterSpacing.setValue(value);
		this.orderSet++;
		this.letterSpacing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetLineHeight() : T {
		this.resetIfRequired();
		if (this.lineHeight == null || this.lineHeight == undefined) {
			this.lineHeight = new CommandAttr<string>()
		}
		
		this.lineHeight.setGetter(true);
		this.orderGet++;
		this.lineHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLineHeight() : string {
		if (this.lineHeight == null || this.lineHeight == undefined) {
			this.lineHeight = new CommandAttr<string>();
		}
		return this.lineHeight.getCommandReturnValue();
	}
	public setLineHeight(value : string) : T {
		this.resetIfRequired();
		if (this.lineHeight == null || this.lineHeight == undefined) {
			this.lineHeight = new CommandAttr<string>();
		}
		
		this.lineHeight.setSetter(true);
		this.lineHeight.setValue(value);
		this.orderSet++;
		this.lineHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetLineSpacingExtra() : T {
		this.resetIfRequired();
		if (this.lineSpacingExtra == null || this.lineSpacingExtra == undefined) {
			this.lineSpacingExtra = new CommandAttr<string>()
		}
		
		this.lineSpacingExtra.setGetter(true);
		this.orderGet++;
		this.lineSpacingExtra.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLineSpacingExtra() : string {
		if (this.lineSpacingExtra == null || this.lineSpacingExtra == undefined) {
			this.lineSpacingExtra = new CommandAttr<string>();
		}
		return this.lineSpacingExtra.getCommandReturnValue();
	}
	public setLineSpacingExtra(value : string) : T {
		this.resetIfRequired();
		if (this.lineSpacingExtra == null || this.lineSpacingExtra == undefined) {
			this.lineSpacingExtra = new CommandAttr<string>();
		}
		
		this.lineSpacingExtra.setSetter(true);
		this.lineSpacingExtra.setValue(value);
		this.orderSet++;
		this.lineSpacingExtra.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetLineSpacingMultiplier() : T {
		this.resetIfRequired();
		if (this.lineSpacingMultiplier == null || this.lineSpacingMultiplier == undefined) {
			this.lineSpacingMultiplier = new CommandAttr<number>()
		}
		
		this.lineSpacingMultiplier.setGetter(true);
		this.orderGet++;
		this.lineSpacingMultiplier.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLineSpacingMultiplier() : number {
		if (this.lineSpacingMultiplier == null || this.lineSpacingMultiplier == undefined) {
			this.lineSpacingMultiplier = new CommandAttr<number>();
		}
		return this.lineSpacingMultiplier.getCommandReturnValue();
	}
	public setLineSpacingMultiplier(value : number) : T {
		this.resetIfRequired();
		if (this.lineSpacingMultiplier == null || this.lineSpacingMultiplier == undefined) {
			this.lineSpacingMultiplier = new CommandAttr<number>();
		}
		
		this.lineSpacingMultiplier.setSetter(true);
		this.lineSpacingMultiplier.setValue(value);
		this.orderSet++;
		this.lineSpacingMultiplier.setOrderSet(this.orderSet);
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
		

	public tryGetShadowColor() : T {
		this.resetIfRequired();
		if (this.shadowColor == null || this.shadowColor == undefined) {
			this.shadowColor = new CommandAttr<string>()
		}
		
		this.shadowColor.setGetter(true);
		this.orderGet++;
		this.shadowColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getShadowColor() : string {
		if (this.shadowColor == null || this.shadowColor == undefined) {
			this.shadowColor = new CommandAttr<string>();
		}
		return this.shadowColor.getCommandReturnValue();
	}
	public setShadowColor(value : string) : T {
		this.resetIfRequired();
		if (this.shadowColor == null || this.shadowColor == undefined) {
			this.shadowColor = new CommandAttr<string>();
		}
		
		this.shadowColor.setSetter(true);
		this.shadowColor.setValue(value);
		this.orderSet++;
		this.shadowColor.setOrderSet(this.orderSet);
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
		

	public tryGetShadowRadius() : T {
		this.resetIfRequired();
		if (this.shadowRadius == null || this.shadowRadius == undefined) {
			this.shadowRadius = new CommandAttr<number>()
		}
		
		this.shadowRadius.setGetter(true);
		this.orderGet++;
		this.shadowRadius.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getShadowRadius() : number {
		if (this.shadowRadius == null || this.shadowRadius == undefined) {
			this.shadowRadius = new CommandAttr<number>();
		}
		return this.shadowRadius.getCommandReturnValue();
	}
	public setShadowRadius(value : number) : T {
		this.resetIfRequired();
		if (this.shadowRadius == null || this.shadowRadius == undefined) {
			this.shadowRadius = new CommandAttr<number>();
		}
		
		this.shadowRadius.setSetter(true);
		this.shadowRadius.setValue(value);
		this.orderSet++;
		this.shadowRadius.setOrderSet(this.orderSet);
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
		

	public tryGetTextAllCaps() : T {
		this.resetIfRequired();
		if (this.textAllCaps == null || this.textAllCaps == undefined) {
			this.textAllCaps = new CommandAttr<boolean>()
		}
		
		this.textAllCaps.setGetter(true);
		this.orderGet++;
		this.textAllCaps.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isTextAllCaps() : boolean {
		if (this.textAllCaps == null || this.textAllCaps == undefined) {
			this.textAllCaps = new CommandAttr<boolean>();
		}
		return this.textAllCaps.getCommandReturnValue();
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
		

	public tryGetTextColorHighlight() : T {
		this.resetIfRequired();
		if (this.textColorHighlight == null || this.textColorHighlight == undefined) {
			this.textColorHighlight = new CommandAttr<string>()
		}
		
		this.textColorHighlight.setGetter(true);
		this.orderGet++;
		this.textColorHighlight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTextColorHighlight() : string {
		if (this.textColorHighlight == null || this.textColorHighlight == undefined) {
			this.textColorHighlight = new CommandAttr<string>();
		}
		return this.textColorHighlight.getCommandReturnValue();
	}
	public setTextColorHighlight(value : string) : T {
		this.resetIfRequired();
		if (this.textColorHighlight == null || this.textColorHighlight == undefined) {
			this.textColorHighlight = new CommandAttr<string>();
		}
		
		this.textColorHighlight.setSetter(true);
		this.textColorHighlight.setValue(value);
		this.orderSet++;
		this.textColorHighlight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTextColorLink(value : string) : T {
		this.resetIfRequired();
		if (this.textColorLink == null || this.textColorLink == undefined) {
			this.textColorLink = new CommandAttr<string>();
		}
		
		this.textColorLink.setSetter(true);
		this.textColorLink.setValue(value);
		this.orderSet++;
		this.textColorLink.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTextIsSelectable() : T {
		this.resetIfRequired();
		if (this.textIsSelectable == null || this.textIsSelectable == undefined) {
			this.textIsSelectable = new CommandAttr<boolean>()
		}
		
		this.textIsSelectable.setGetter(true);
		this.orderGet++;
		this.textIsSelectable.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isTextIsSelectable() : boolean {
		if (this.textIsSelectable == null || this.textIsSelectable == undefined) {
			this.textIsSelectable = new CommandAttr<boolean>();
		}
		return this.textIsSelectable.getCommandReturnValue();
	}
	public setTextIsSelectable(value : boolean) : T {
		this.resetIfRequired();
		if (this.textIsSelectable == null || this.textIsSelectable == undefined) {
			this.textIsSelectable = new CommandAttr<boolean>();
		}
		
		this.textIsSelectable.setSetter(true);
		this.textIsSelectable.setValue(value);
		this.orderSet++;
		this.textIsSelectable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTextScaleX() : T {
		this.resetIfRequired();
		if (this.textScaleX == null || this.textScaleX == undefined) {
			this.textScaleX = new CommandAttr<number>()
		}
		
		this.textScaleX.setGetter(true);
		this.orderGet++;
		this.textScaleX.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTextScaleX() : number {
		if (this.textScaleX == null || this.textScaleX == undefined) {
			this.textScaleX = new CommandAttr<number>();
		}
		return this.textScaleX.getCommandReturnValue();
	}
	public setTextScaleX(value : number) : T {
		this.resetIfRequired();
		if (this.textScaleX == null || this.textScaleX == undefined) {
			this.textScaleX = new CommandAttr<number>();
		}
		
		this.textScaleX.setSetter(true);
		this.textScaleX.setValue(value);
		this.orderSet++;
		this.textScaleX.setOrderSet(this.orderSet);
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
		

	public tryGetButtonTint() : T {
		this.resetIfRequired();
		if (this.buttonTint == null || this.buttonTint == undefined) {
			this.buttonTint = new CommandAttr<string>()
		}
		
		this.buttonTint.setGetter(true);
		this.orderGet++;
		this.buttonTint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getButtonTint() : string {
		if (this.buttonTint == null || this.buttonTint == undefined) {
			this.buttonTint = new CommandAttr<string>();
		}
		return this.buttonTint.getCommandReturnValue();
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
		

	public tryGetButtonTintMode() : T {
		this.resetIfRequired();
		if (this.buttonTintMode == null || this.buttonTintMode == undefined) {
			this.buttonTintMode = new CommandAttr<ButtonTintMode>()
		}
		
		this.buttonTintMode.setGetter(true);
		this.orderGet++;
		this.buttonTintMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getButtonTintMode() : ButtonTintMode {
		if (this.buttonTintMode == null || this.buttonTintMode == undefined) {
			this.buttonTintMode = new CommandAttr<ButtonTintMode>();
		}
		return this.buttonTintMode.getCommandReturnValue();
	}
	public setButtonTintMode(value : ButtonTintMode) : T {
		this.resetIfRequired();
		if (this.buttonTintMode == null || this.buttonTintMode == undefined) {
			this.buttonTintMode = new CommandAttr<ButtonTintMode>();
		}
		
		this.buttonTintMode.setSetter(true);
		this.buttonTintMode.setValue(value);
		this.orderSet++;
		this.buttonTintMode.setOrderSet(this.orderSet);
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
		

	public setTextAppearance(value : string) : T {
		this.resetIfRequired();
		if (this.textAppearance == null || this.textAppearance == undefined) {
			this.textAppearance = new CommandAttr<string>();
		}
		
		this.textAppearance.setSetter(true);
		this.textAppearance.setValue(value);
		this.orderSet++;
		this.textAppearance.setOrderSet(this.orderSet);
		return this.thisPointer;
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
export interface OnafterTextChangeEvent extends Event{
        //s:Editable;


}
export interface OnbeforeTextChangeEvent extends Event{
        //s:CharSequence;

	        start:number;
	        count:number;
	        after:number;

}
export interface OnTextChangeEvent extends Event{
        //s:CharSequence;

	        start:number;
	        before:number;
	        count:number;

}
export interface OnEditorActionEvent extends Event{
        //v:TextView;

	        actionId:number;
        //event:KeyEvent;
        		eventInfo: KeyEvent;


}
export interface OnCheckedChangeEvent extends Event{
        //buttonView:CompoundButton;

        isChecked:boolean;

}

//end - staticinit
