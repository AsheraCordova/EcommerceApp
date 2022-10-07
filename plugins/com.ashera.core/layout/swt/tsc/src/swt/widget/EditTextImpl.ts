// start - imports

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
export const enum Numeric {
decimal = "decimal",
integer = "integer",
signed = "signed",
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











export class NumericTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<Numeric> = new Array<Numeric>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "decimal":
						valueArr.push(Numeric.decimal);
                       	break;	
					case "integer":
						valueArr.push(Numeric.integer);
                       	break;	
					case "signed":
						valueArr.push(Numeric.signed);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}


























// end - imports
import {ViewImpl} from './ViewImpl';
export abstract class EditTextImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
		TransformerFactory.getInstance().register("textStyle", new TextStyleTransformer());
		TransformerFactory.getInstance().register("numeric", new NumericTransformer());
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "swtDoubleClickEnabled" })
	swtDoubleClickEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "swtEditable" })
	swtEditable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "swtMessage" })
	swtMessage!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "swtOrientation" })
	swtOrientation!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "swtRedraw" })
	swtRedraw!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "swtTabs" })
	swtTabs!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "swtText" })
	swtText!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "swtTextLimit" })
	swtTextLimit!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "swtTopIndex" })
	swtTopIndex!:CommandAttr<number>| undefined;
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
	@Expose({ name: "typeface" })
	typeface!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textStyle" })
	textStyle!:CommandAttr<TextStyle[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "fontFamily" })
	fontFamily!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textSize" })
	textSize!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textColor" })
	textColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "password" })
	password!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textAllCaps" })
	textAllCaps!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "selectAllOnFocus" })
	selectAllOnFocus_!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "selectAll" })
	selectAll_!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "swtSelection" })
	swtSelection!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textColorHint" })
	textColorHint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "singleLine" })
	singleLine!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "numeric" })
	numeric!:CommandAttr<Numeric[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "digits" })
	digits!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "hint" })
	hint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "hintTextFormat" })
	hintTextFormat!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "gravity" })
	gravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableLeft" })
	drawableLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableRight" })
	drawableRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawableStart" })
	drawableStart!:CommandAttr<string>| undefined;
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
	@Expose({ name: "maxEms" })
	maxEms!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "minEms" })
	minEms!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "ems" })
	ems!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "enabled" })
	enabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "editable" })
	editable!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollHorizontally" })
	scrollHorizontally!:CommandAttr<boolean>| undefined;
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
	@Expose({ name: "swtUseTabForNavigation" })
	swtUseTabForNavigation!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "firstBaselineToTopHeight" })
	firstBaselineToTopHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "lastBaselineToBottomHeight" })
	lastBaselineToBottomHeight!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.swtDoubleClickEnabled = undefined;
		this.swtEditable = undefined;
		this.swtMessage = undefined;
		this.swtOrientation = undefined;
		this.swtRedraw = undefined;
		this.swtTabs = undefined;
		this.swtText = undefined;
		this.swtTextLimit = undefined;
		this.swtTopIndex = undefined;
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
		this.typeface = undefined;
		this.textStyle = undefined;
		this.fontFamily = undefined;
		this.textSize = undefined;
		this.textColor = undefined;
		this.password = undefined;
		this.textAllCaps = undefined;
		this.selectAllOnFocus_ = undefined;
		this.selectAll_ = undefined;
		this.swtSelection = undefined;
		this.textColorHint = undefined;
		this.singleLine = undefined;
		this.numeric = undefined;
		this.digits = undefined;
		this.hint = undefined;
		this.hintTextFormat = undefined;
		this.gravity = undefined;
		this.drawableLeft = undefined;
		this.drawableRight = undefined;
		this.drawableStart = undefined;
		this.drawableEnd = undefined;
		this.drawableTop = undefined;
		this.drawableBottom = undefined;
		this.drawablePadding = undefined;
		this.maxEms = undefined;
		this.minEms = undefined;
		this.ems = undefined;
		this.enabled = undefined;
		this.editable = undefined;
		this.scrollHorizontally = undefined;
		this.onTextChange = undefined;
		this.onbeforeTextChange = undefined;
		this.onafterTextChange = undefined;
		this.swtUseTabForNavigation = undefined;
		this.firstBaselineToTopHeight = undefined;
		this.lastBaselineToBottomHeight = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetSwtDoubleClickEnabled() : T {
		this.resetIfRequired();
		if (this.swtDoubleClickEnabled == null || this.swtDoubleClickEnabled == undefined) {
			this.swtDoubleClickEnabled = new CommandAttr<boolean>()
		}
		
		this.swtDoubleClickEnabled.setGetter(true);
		this.orderGet++;
		this.swtDoubleClickEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isSwtDoubleClickEnabled() : boolean {
		if (this.swtDoubleClickEnabled == null || this.swtDoubleClickEnabled == undefined) {
			this.swtDoubleClickEnabled = new CommandAttr<boolean>();
		}
		return this.swtDoubleClickEnabled.getCommandReturnValue();
	}
	public setSwtDoubleClickEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.swtDoubleClickEnabled == null || this.swtDoubleClickEnabled == undefined) {
			this.swtDoubleClickEnabled = new CommandAttr<boolean>();
		}
		
		this.swtDoubleClickEnabled.setSetter(true);
		this.swtDoubleClickEnabled.setValue(value);
		this.orderSet++;
		this.swtDoubleClickEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSwtEditable() : T {
		this.resetIfRequired();
		if (this.swtEditable == null || this.swtEditable == undefined) {
			this.swtEditable = new CommandAttr<boolean>()
		}
		
		this.swtEditable.setGetter(true);
		this.orderGet++;
		this.swtEditable.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isSwtEditable() : boolean {
		if (this.swtEditable == null || this.swtEditable == undefined) {
			this.swtEditable = new CommandAttr<boolean>();
		}
		return this.swtEditable.getCommandReturnValue();
	}
	public setSwtEditable(value : boolean) : T {
		this.resetIfRequired();
		if (this.swtEditable == null || this.swtEditable == undefined) {
			this.swtEditable = new CommandAttr<boolean>();
		}
		
		this.swtEditable.setSetter(true);
		this.swtEditable.setValue(value);
		this.orderSet++;
		this.swtEditable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSwtMessage() : T {
		this.resetIfRequired();
		if (this.swtMessage == null || this.swtMessage == undefined) {
			this.swtMessage = new CommandAttr<string>()
		}
		
		this.swtMessage.setGetter(true);
		this.orderGet++;
		this.swtMessage.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSwtMessage() : string {
		if (this.swtMessage == null || this.swtMessage == undefined) {
			this.swtMessage = new CommandAttr<string>();
		}
		return this.swtMessage.getCommandReturnValue();
	}
	public setSwtMessage(value : string) : T {
		this.resetIfRequired();
		if (this.swtMessage == null || this.swtMessage == undefined) {
			this.swtMessage = new CommandAttr<string>();
		}
		
		this.swtMessage.setSetter(true);
		this.swtMessage.setValue(value);
		this.orderSet++;
		this.swtMessage.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSwtOrientation() : T {
		this.resetIfRequired();
		if (this.swtOrientation == null || this.swtOrientation == undefined) {
			this.swtOrientation = new CommandAttr<string>()
		}
		
		this.swtOrientation.setGetter(true);
		this.orderGet++;
		this.swtOrientation.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSwtOrientation() : string {
		if (this.swtOrientation == null || this.swtOrientation == undefined) {
			this.swtOrientation = new CommandAttr<string>();
		}
		return this.swtOrientation.getCommandReturnValue();
	}
	public setSwtOrientation(value : string) : T {
		this.resetIfRequired();
		if (this.swtOrientation == null || this.swtOrientation == undefined) {
			this.swtOrientation = new CommandAttr<string>();
		}
		
		this.swtOrientation.setSetter(true);
		this.swtOrientation.setValue(value);
		this.orderSet++;
		this.swtOrientation.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSwtRedraw(value : boolean) : T {
		this.resetIfRequired();
		if (this.swtRedraw == null || this.swtRedraw == undefined) {
			this.swtRedraw = new CommandAttr<boolean>();
		}
		
		this.swtRedraw.setSetter(true);
		this.swtRedraw.setValue(value);
		this.orderSet++;
		this.swtRedraw.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSwtTabs() : T {
		this.resetIfRequired();
		if (this.swtTabs == null || this.swtTabs == undefined) {
			this.swtTabs = new CommandAttr<number>()
		}
		
		this.swtTabs.setGetter(true);
		this.orderGet++;
		this.swtTabs.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSwtTabs() : number {
		if (this.swtTabs == null || this.swtTabs == undefined) {
			this.swtTabs = new CommandAttr<number>();
		}
		return this.swtTabs.getCommandReturnValue();
	}
	public setSwtTabs(value : number) : T {
		this.resetIfRequired();
		if (this.swtTabs == null || this.swtTabs == undefined) {
			this.swtTabs = new CommandAttr<number>();
		}
		
		this.swtTabs.setSetter(true);
		this.swtTabs.setValue(value);
		this.orderSet++;
		this.swtTabs.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSwtText() : T {
		this.resetIfRequired();
		if (this.swtText == null || this.swtText == undefined) {
			this.swtText = new CommandAttr<string>()
		}
		
		this.swtText.setGetter(true);
		this.orderGet++;
		this.swtText.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSwtText() : string {
		if (this.swtText == null || this.swtText == undefined) {
			this.swtText = new CommandAttr<string>();
		}
		return this.swtText.getCommandReturnValue();
	}
	public setSwtText(value : string) : T {
		this.resetIfRequired();
		if (this.swtText == null || this.swtText == undefined) {
			this.swtText = new CommandAttr<string>();
		}
		
		this.swtText.setSetter(true);
		this.swtText.setValue(value);
		this.orderSet++;
		this.swtText.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetText() : T {
		this.resetIfRequired();
		if (this.swtText == null || this.swtText == undefined) {
			this.swtText = new CommandAttr<string>()
		}
		
		this.swtText.setGetter(true);
		this.orderGet++;
		this.swtText.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getText() : string {
		if (this.swtText == null || this.swtText == undefined) {
			this.swtText = new CommandAttr<string>();
		}
		return this.swtText.getCommandReturnValue();
	}
	public setText(value : string) : T {
		this.resetIfRequired();
		if (this.swtText == null || this.swtText == undefined) {
			this.swtText = new CommandAttr<string>();
		}
		
		this.swtText.setSetter(true);
		this.swtText.setValue(value);
		this.orderSet++;
		this.swtText.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSwtTextLimit() : T {
		this.resetIfRequired();
		if (this.swtTextLimit == null || this.swtTextLimit == undefined) {
			this.swtTextLimit = new CommandAttr<number>()
		}
		
		this.swtTextLimit.setGetter(true);
		this.orderGet++;
		this.swtTextLimit.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSwtTextLimit() : number {
		if (this.swtTextLimit == null || this.swtTextLimit == undefined) {
			this.swtTextLimit = new CommandAttr<number>();
		}
		return this.swtTextLimit.getCommandReturnValue();
	}
	public setSwtTextLimit(value : number) : T {
		this.resetIfRequired();
		if (this.swtTextLimit == null || this.swtTextLimit == undefined) {
			this.swtTextLimit = new CommandAttr<number>();
		}
		
		this.swtTextLimit.setSetter(true);
		this.swtTextLimit.setValue(value);
		this.orderSet++;
		this.swtTextLimit.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetMaxLength() : T {
		this.resetIfRequired();
		if (this.swtTextLimit == null || this.swtTextLimit == undefined) {
			this.swtTextLimit = new CommandAttr<number>()
		}
		
		this.swtTextLimit.setGetter(true);
		this.orderGet++;
		this.swtTextLimit.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getMaxLength() : number {
		if (this.swtTextLimit == null || this.swtTextLimit == undefined) {
			this.swtTextLimit = new CommandAttr<number>();
		}
		return this.swtTextLimit.getCommandReturnValue();
	}
	public setMaxLength(value : number) : T {
		this.resetIfRequired();
		if (this.swtTextLimit == null || this.swtTextLimit == undefined) {
			this.swtTextLimit = new CommandAttr<number>();
		}
		
		this.swtTextLimit.setSetter(true);
		this.swtTextLimit.setValue(value);
		this.orderSet++;
		this.swtTextLimit.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSwtTopIndex() : T {
		this.resetIfRequired();
		if (this.swtTopIndex == null || this.swtTopIndex == undefined) {
			this.swtTopIndex = new CommandAttr<number>()
		}
		
		this.swtTopIndex.setGetter(true);
		this.orderGet++;
		this.swtTopIndex.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSwtTopIndex() : number {
		if (this.swtTopIndex == null || this.swtTopIndex == undefined) {
			this.swtTopIndex = new CommandAttr<number>();
		}
		return this.swtTopIndex.getCommandReturnValue();
	}
	public setSwtTopIndex(value : number) : T {
		this.resetIfRequired();
		if (this.swtTopIndex == null || this.swtTopIndex == undefined) {
			this.swtTopIndex = new CommandAttr<number>();
		}
		
		this.swtTopIndex.setSetter(true);
		this.swtTopIndex.setValue(value);
		this.orderSet++;
		this.swtTopIndex.setOrderSet(this.orderSet);
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
		

	public setPassword(value : boolean) : T {
		this.resetIfRequired();
		if (this.password == null || this.password == undefined) {
			this.password = new CommandAttr<boolean>();
		}
		
		this.password.setSetter(true);
		this.password.setValue(value);
		this.orderSet++;
		this.password.setOrderSet(this.orderSet);
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
		

	public selectAllOnFocus(value : boolean) : T {
		this.resetIfRequired();
		if (this.selectAllOnFocus_ == null || this.selectAllOnFocus_ == undefined) {
			this.selectAllOnFocus_ = new CommandAttr<boolean>();
		}
		
		this.selectAllOnFocus_.setSetter(true);
		this.selectAllOnFocus_.setValue(value);
		this.orderSet++;
		this.selectAllOnFocus_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public selectAll(value : boolean) : T {
		this.resetIfRequired();
		if (this.selectAll_ == null || this.selectAll_ == undefined) {
			this.selectAll_ = new CommandAttr<boolean>();
		}
		
		this.selectAll_.setSetter(true);
		this.selectAll_.setValue(value);
		this.orderSet++;
		this.selectAll_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSwtSelection() : T {
		this.resetIfRequired();
		if (this.swtSelection == null || this.swtSelection == undefined) {
			this.swtSelection = new CommandAttr<number>()
		}
		
		this.swtSelection.setGetter(true);
		this.orderGet++;
		this.swtSelection.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSwtSelection() : number {
		if (this.swtSelection == null || this.swtSelection == undefined) {
			this.swtSelection = new CommandAttr<number>();
		}
		return this.swtSelection.getCommandReturnValue();
	}
	public setSwtSelection(value : number) : T {
		this.resetIfRequired();
		if (this.swtSelection == null || this.swtSelection == undefined) {
			this.swtSelection = new CommandAttr<number>();
		}
		
		this.swtSelection.setSetter(true);
		this.swtSelection.setValue(value);
		this.orderSet++;
		this.swtSelection.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTextColorHint(value : string) : T {
		this.resetIfRequired();
		if (this.textColorHint == null || this.textColorHint == undefined) {
			this.textColorHint = new CommandAttr<string>();
		}
		
		this.textColorHint.setSetter(true);
		this.textColorHint.setValue(value);
		this.orderSet++;
		this.textColorHint.setOrderSet(this.orderSet);
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
		

	public setNumeric(...value : Numeric[]) : T {
		this.resetIfRequired();
		if (this.numeric == null || this.numeric == undefined) {
			this.numeric = new CommandAttr<Numeric[]>();
		}
		
		this.numeric.setSetter(true);
		this.numeric.setValue(value);
		this.orderSet++;
		this.numeric.setOrderSet(this.orderSet);
this.numeric.setTransformer('numeric');		return this.thisPointer;
	}
		

	public setDigits(value : string) : T {
		this.resetIfRequired();
		if (this.digits == null || this.digits == undefined) {
			this.digits = new CommandAttr<string>();
		}
		
		this.digits.setSetter(true);
		this.digits.setValue(value);
		this.orderSet++;
		this.digits.setOrderSet(this.orderSet);
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
		

	public setSwtUseTabForNavigation(value : boolean) : T {
		this.resetIfRequired();
		if (this.swtUseTabForNavigation == null || this.swtUseTabForNavigation == undefined) {
			this.swtUseTabForNavigation = new CommandAttr<boolean>();
		}
		
		this.swtUseTabForNavigation.setSetter(true);
		this.swtUseTabForNavigation.setValue(value);
		this.orderSet++;
		this.swtUseTabForNavigation.setOrderSet(this.orderSet);
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
		
	//end - body

}
//start - staticinit

export class EditText extends EditTextImpl<EditText> implements IWidget{
    getThisPointer(): EditText {
        return this;
    }
    
   	public getClass() {
		return EditText;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

EditTextImpl.initialize();

//end - staticinit
