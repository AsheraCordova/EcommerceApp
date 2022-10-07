// start - imports

export const enum DrawableTintMode {
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
export abstract class MultiSelectionSpinnerImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
		TransformerFactory.getInstance().register("textStyle", new TextStyleTransformer());
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "iosText" })
	iosText!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosPlaceholder" })
	iosPlaceholder!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosTextColor" })
	iosTextColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAdjustsFontSizeToFitWidth" })
	iosAdjustsFontSizeToFitWidth!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosMinimumFontSize" })
	iosMinimumFontSize!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsEditing" })
	iosIsEditing!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosClearsOnBeginEditing" })
	iosClearsOnBeginEditing!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosClearsOnInsertion" })
	iosClearsOnInsertion!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAllowsEditingTextAttributes" })
	iosAllowsEditingTextAttributes!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosBackground" })
	iosBackground!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosDisabledBackground" })
	iosDisabledBackground!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "entries" })
	entries!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "selection" })
	selection!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelOptionTextPath" })
	modelOptionTextPath!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onItemSelected" })
	onItemSelected!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelOptionValuePath" })
	modelOptionValuePath!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "gravity" })
	gravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textSize" })
	textSize!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textColorHint" })
	textColorHint!:CommandAttr<string>| undefined;
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
	@Expose({ name: "editable" })
	editable!:CommandAttr<boolean>| undefined;
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
	@Expose({ name: "textColor" })
	textColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "enabled" })
	enabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "values" })
	values!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "selectedValues" })
	selectedValues!:CommandAttr<any>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "hintTextFormat" })
	hintTextFormat!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.iosText = undefined;
		this.iosPlaceholder = undefined;
		this.iosTextColor = undefined;
		this.iosAdjustsFontSizeToFitWidth = undefined;
		this.iosMinimumFontSize = undefined;
		this.iosIsEditing = undefined;
		this.iosClearsOnBeginEditing = undefined;
		this.iosClearsOnInsertion = undefined;
		this.iosAllowsEditingTextAttributes = undefined;
		this.iosBackground = undefined;
		this.iosDisabledBackground = undefined;
		this.entries = undefined;
		this.selection = undefined;
		this.modelOptionTextPath = undefined;
		this.onItemSelected = undefined;
		this.modelOptionValuePath = undefined;
		this.gravity = undefined;
		this.textSize = undefined;
		this.textColorHint = undefined;
		this.padding = undefined;
		this.paddingBottom = undefined;
		this.paddingRight = undefined;
		this.paddingLeft = undefined;
		this.paddingStart = undefined;
		this.paddingEnd = undefined;
		this.paddingTop = undefined;
		this.paddingHorizontal = undefined;
		this.paddingVertical = undefined;
		this.drawableLeft = undefined;
		this.drawableStart = undefined;
		this.drawableRight = undefined;
		this.drawableEnd = undefined;
		this.drawableTop = undefined;
		this.drawableBottom = undefined;
		this.drawablePadding = undefined;
		this.drawableTint = undefined;
		this.drawableTintMode = undefined;
		this.editable = undefined;
		this.typeface = undefined;
		this.textStyle = undefined;
		this.fontFamily = undefined;
		this.textColor = undefined;
		this.enabled = undefined;
		this.values = undefined;
		this.selectedValues = undefined;
		this.hintTextFormat = undefined;
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
		

	public tryGetIosPlaceholder() : T {
		this.resetIfRequired();
		if (this.iosPlaceholder == null || this.iosPlaceholder == undefined) {
			this.iosPlaceholder = new CommandAttr<string>()
		}
		
		this.iosPlaceholder.setGetter(true);
		this.orderGet++;
		this.iosPlaceholder.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosPlaceholder() : string {
		if (this.iosPlaceholder == null || this.iosPlaceholder == undefined) {
			this.iosPlaceholder = new CommandAttr<string>();
		}
		return this.iosPlaceholder.getCommandReturnValue();
	}
	public setIosPlaceholder(value : string) : T {
		this.resetIfRequired();
		if (this.iosPlaceholder == null || this.iosPlaceholder == undefined) {
			this.iosPlaceholder = new CommandAttr<string>();
		}
		
		this.iosPlaceholder.setSetter(true);
		this.iosPlaceholder.setValue(value);
		this.orderSet++;
		this.iosPlaceholder.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetHint() : T {
		this.resetIfRequired();
		if (this.iosPlaceholder == null || this.iosPlaceholder == undefined) {
			this.iosPlaceholder = new CommandAttr<string>()
		}
		
		this.iosPlaceholder.setGetter(true);
		this.orderGet++;
		this.iosPlaceholder.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getHint() : string {
		if (this.iosPlaceholder == null || this.iosPlaceholder == undefined) {
			this.iosPlaceholder = new CommandAttr<string>();
		}
		return this.iosPlaceholder.getCommandReturnValue();
	}
	public setHint(value : string) : T {
		this.resetIfRequired();
		if (this.iosPlaceholder == null || this.iosPlaceholder == undefined) {
			this.iosPlaceholder = new CommandAttr<string>();
		}
		
		this.iosPlaceholder.setSetter(true);
		this.iosPlaceholder.setValue(value);
		this.orderSet++;
		this.iosPlaceholder.setOrderSet(this.orderSet);
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
		

	public tryGetIosMinimumFontSize() : T {
		this.resetIfRequired();
		if (this.iosMinimumFontSize == null || this.iosMinimumFontSize == undefined) {
			this.iosMinimumFontSize = new CommandAttr<number>()
		}
		
		this.iosMinimumFontSize.setGetter(true);
		this.orderGet++;
		this.iosMinimumFontSize.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosMinimumFontSize() : number {
		if (this.iosMinimumFontSize == null || this.iosMinimumFontSize == undefined) {
			this.iosMinimumFontSize = new CommandAttr<number>();
		}
		return this.iosMinimumFontSize.getCommandReturnValue();
	}
	public setIosMinimumFontSize(value : number) : T {
		this.resetIfRequired();
		if (this.iosMinimumFontSize == null || this.iosMinimumFontSize == undefined) {
			this.iosMinimumFontSize = new CommandAttr<number>();
		}
		
		this.iosMinimumFontSize.setSetter(true);
		this.iosMinimumFontSize.setValue(value);
		this.orderSet++;
		this.iosMinimumFontSize.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsEditing() : T {
		this.resetIfRequired();
		if (this.iosIsEditing == null || this.iosIsEditing == undefined) {
			this.iosIsEditing = new CommandAttr<boolean>()
		}
		
		this.iosIsEditing.setGetter(true);
		this.orderGet++;
		this.iosIsEditing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsEditing() : boolean {
		if (this.iosIsEditing == null || this.iosIsEditing == undefined) {
			this.iosIsEditing = new CommandAttr<boolean>();
		}
		return this.iosIsEditing.getCommandReturnValue();
	}
	
		

	public tryGetIosClearsOnBeginEditing() : T {
		this.resetIfRequired();
		if (this.iosClearsOnBeginEditing == null || this.iosClearsOnBeginEditing == undefined) {
			this.iosClearsOnBeginEditing = new CommandAttr<boolean>()
		}
		
		this.iosClearsOnBeginEditing.setGetter(true);
		this.orderGet++;
		this.iosClearsOnBeginEditing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosClearsOnBeginEditing() : boolean {
		if (this.iosClearsOnBeginEditing == null || this.iosClearsOnBeginEditing == undefined) {
			this.iosClearsOnBeginEditing = new CommandAttr<boolean>();
		}
		return this.iosClearsOnBeginEditing.getCommandReturnValue();
	}
	public setIosClearsOnBeginEditing(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosClearsOnBeginEditing == null || this.iosClearsOnBeginEditing == undefined) {
			this.iosClearsOnBeginEditing = new CommandAttr<boolean>();
		}
		
		this.iosClearsOnBeginEditing.setSetter(true);
		this.iosClearsOnBeginEditing.setValue(value);
		this.orderSet++;
		this.iosClearsOnBeginEditing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosClearsOnInsertion() : T {
		this.resetIfRequired();
		if (this.iosClearsOnInsertion == null || this.iosClearsOnInsertion == undefined) {
			this.iosClearsOnInsertion = new CommandAttr<boolean>()
		}
		
		this.iosClearsOnInsertion.setGetter(true);
		this.orderGet++;
		this.iosClearsOnInsertion.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosClearsOnInsertion() : boolean {
		if (this.iosClearsOnInsertion == null || this.iosClearsOnInsertion == undefined) {
			this.iosClearsOnInsertion = new CommandAttr<boolean>();
		}
		return this.iosClearsOnInsertion.getCommandReturnValue();
	}
	public setIosClearsOnInsertion(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosClearsOnInsertion == null || this.iosClearsOnInsertion == undefined) {
			this.iosClearsOnInsertion = new CommandAttr<boolean>();
		}
		
		this.iosClearsOnInsertion.setSetter(true);
		this.iosClearsOnInsertion.setValue(value);
		this.orderSet++;
		this.iosClearsOnInsertion.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAllowsEditingTextAttributes() : T {
		this.resetIfRequired();
		if (this.iosAllowsEditingTextAttributes == null || this.iosAllowsEditingTextAttributes == undefined) {
			this.iosAllowsEditingTextAttributes = new CommandAttr<boolean>()
		}
		
		this.iosAllowsEditingTextAttributes.setGetter(true);
		this.orderGet++;
		this.iosAllowsEditingTextAttributes.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAllowsEditingTextAttributes() : boolean {
		if (this.iosAllowsEditingTextAttributes == null || this.iosAllowsEditingTextAttributes == undefined) {
			this.iosAllowsEditingTextAttributes = new CommandAttr<boolean>();
		}
		return this.iosAllowsEditingTextAttributes.getCommandReturnValue();
	}
	public setIosAllowsEditingTextAttributes(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAllowsEditingTextAttributes == null || this.iosAllowsEditingTextAttributes == undefined) {
			this.iosAllowsEditingTextAttributes = new CommandAttr<boolean>();
		}
		
		this.iosAllowsEditingTextAttributes.setSetter(true);
		this.iosAllowsEditingTextAttributes.setValue(value);
		this.orderSet++;
		this.iosAllowsEditingTextAttributes.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosBackground() : T {
		this.resetIfRequired();
		if (this.iosBackground == null || this.iosBackground == undefined) {
			this.iosBackground = new CommandAttr<string>()
		}
		
		this.iosBackground.setGetter(true);
		this.orderGet++;
		this.iosBackground.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosBackground() : string {
		if (this.iosBackground == null || this.iosBackground == undefined) {
			this.iosBackground = new CommandAttr<string>();
		}
		return this.iosBackground.getCommandReturnValue();
	}
	public setIosBackground(value : string) : T {
		this.resetIfRequired();
		if (this.iosBackground == null || this.iosBackground == undefined) {
			this.iosBackground = new CommandAttr<string>();
		}
		
		this.iosBackground.setSetter(true);
		this.iosBackground.setValue(value);
		this.orderSet++;
		this.iosBackground.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosDisabledBackground() : T {
		this.resetIfRequired();
		if (this.iosDisabledBackground == null || this.iosDisabledBackground == undefined) {
			this.iosDisabledBackground = new CommandAttr<string>()
		}
		
		this.iosDisabledBackground.setGetter(true);
		this.orderGet++;
		this.iosDisabledBackground.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosDisabledBackground() : string {
		if (this.iosDisabledBackground == null || this.iosDisabledBackground == undefined) {
			this.iosDisabledBackground = new CommandAttr<string>();
		}
		return this.iosDisabledBackground.getCommandReturnValue();
	}
	public setIosDisabledBackground(value : string) : T {
		this.resetIfRequired();
		if (this.iosDisabledBackground == null || this.iosDisabledBackground == undefined) {
			this.iosDisabledBackground = new CommandAttr<string>();
		}
		
		this.iosDisabledBackground.setSetter(true);
		this.iosDisabledBackground.setValue(value);
		this.orderSet++;
		this.iosDisabledBackground.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setEntries(value : string) : T {
		this.resetIfRequired();
		if (this.entries == null || this.entries == undefined) {
			this.entries = new CommandAttr<string>();
		}
		
		this.entries.setSetter(true);
		this.entries.setValue(value);
		this.orderSet++;
		this.entries.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSelection(value : string) : T {
		this.resetIfRequired();
		if (this.selection == null || this.selection == undefined) {
			this.selection = new CommandAttr<string>();
		}
		
		this.selection.setSetter(true);
		this.selection.setValue(value);
		this.orderSet++;
		this.selection.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setModelOptionTextPath(value : string) : T {
		this.resetIfRequired();
		if (this.modelOptionTextPath == null || this.modelOptionTextPath == undefined) {
			this.modelOptionTextPath = new CommandAttr<string>();
		}
		
		this.modelOptionTextPath.setSetter(true);
		this.modelOptionTextPath.setValue(value);
		this.orderSet++;
		this.modelOptionTextPath.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnItemSelected(value : string) : T {
		this.resetIfRequired();
		if (this.onItemSelected == null || this.onItemSelected == undefined) {
			this.onItemSelected = new CommandAttr<string>();
		}
		
		this.onItemSelected.setSetter(true);
		this.onItemSelected.setValue(value);
		this.orderSet++;
		this.onItemSelected.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setModelOptionValuePath(value : string) : T {
		this.resetIfRequired();
		if (this.modelOptionValuePath == null || this.modelOptionValuePath == undefined) {
			this.modelOptionValuePath = new CommandAttr<string>();
		}
		
		this.modelOptionValuePath.setSetter(true);
		this.modelOptionValuePath.setValue(value);
		this.orderSet++;
		this.modelOptionValuePath.setOrderSet(this.orderSet);
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
		

	public setValues(value : string) : T {
		this.resetIfRequired();
		if (this.values == null || this.values == undefined) {
			this.values = new CommandAttr<string>();
		}
		
		this.values.setSetter(true);
		this.values.setValue(value);
		this.orderSet++;
		this.values.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSelectedValues() : T {
		this.resetIfRequired();
		if (this.selectedValues == null || this.selectedValues == undefined) {
			this.selectedValues = new CommandAttr<any>()
		}
		
		this.selectedValues.setGetter(true);
		this.orderGet++;
		this.selectedValues.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSelectedValues() : any {
		if (this.selectedValues == null || this.selectedValues == undefined) {
			this.selectedValues = new CommandAttr<any>();
		}
		return this.selectedValues.getCommandReturnValue();
	}
	public setSelectedValues(value : any) : T {
		this.resetIfRequired();
		if (this.selectedValues == null || this.selectedValues == undefined) {
			this.selectedValues = new CommandAttr<any>();
		}
		
		this.selectedValues.setSetter(true);
		this.selectedValues.setValue(value);
		this.orderSet++;
		this.selectedValues.setOrderSet(this.orderSet);
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

export class MultiSelectionSpinner extends MultiSelectionSpinnerImpl<MultiSelectionSpinner> implements IWidget{
    getThisPointer(): MultiSelectionSpinner {
        return this;
    }
    
   	public getClass() {
		return MultiSelectionSpinner;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

MultiSelectionSpinnerImpl.initialize();
export interface OnItemSelectedEvent extends Event{
        //view:View;

        //positions:List<Integer>;


}
export interface OnNothingSelectedEvent extends Event{
        //view:View;

        //positions:List<Integer>;


}

//end - staticinit
