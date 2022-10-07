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
export abstract class SpinnerImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
		TransformerFactory.getInstance().register("textStyle", new TextStyleTransformer());
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "dropDownHorizontalOffset" })
	dropDownHorizontalOffset!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "dropDownVerticalOffset" })
	dropDownVerticalOffset!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "dropDownWidth" })
	dropDownWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "prompt" })
	prompt!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "selection" })
	selection!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "entries" })
	entries!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onItemSelected" })
	onItemSelected!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelOptionTextPath" })
	modelOptionTextPath!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "modelOptionValuePath" })
	modelOptionValuePath!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "listitem" })
	listitem!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "values" })
	values!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "selectedValue" })
	selectedValue!:CommandAttr<any>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "hintTextFormat" })
	hintTextFormat!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawablePadding" })
	drawablePadding!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "gravity" })
	gravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textColor" })
	textColor!:CommandAttr<string>| undefined;
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
	@Expose({ name: "typeface" })
	typeface!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textStyle" })
	textStyle!:CommandAttr<TextStyle[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "fontFamily" })
	fontFamily!:CommandAttr<string>| undefined;
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
	@Expose({ name: "hint" })
	hint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textColorHint" })
	textColorHint!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.dropDownHorizontalOffset = undefined;
		this.dropDownVerticalOffset = undefined;
		this.dropDownWidth = undefined;
		this.prompt = undefined;
		this.selection = undefined;
		this.entries = undefined;
		this.onItemSelected = undefined;
		this.modelOptionTextPath = undefined;
		this.modelOptionValuePath = undefined;
		this.listitem = undefined;
		this.values = undefined;
		this.selectedValue = undefined;
		this.hintTextFormat = undefined;
		this.drawablePadding = undefined;
		this.gravity = undefined;
		this.textColor = undefined;
		this.textSize = undefined;
		this.drawableLeft = undefined;
		this.drawableStart = undefined;
		this.drawableRight = undefined;
		this.drawableEnd = undefined;
		this.drawableTop = undefined;
		this.drawableBottom = undefined;
		this.typeface = undefined;
		this.textStyle = undefined;
		this.fontFamily = undefined;
		this.enabled = undefined;
		this.editable = undefined;
		this.drawableTint = undefined;
		this.drawableTintMode = undefined;
		this.hint = undefined;
		this.textColorHint = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetDropDownHorizontalOffset() : T {
		this.resetIfRequired();
		if (this.dropDownHorizontalOffset == null || this.dropDownHorizontalOffset == undefined) {
			this.dropDownHorizontalOffset = new CommandAttr<string>()
		}
		
		this.dropDownHorizontalOffset.setGetter(true);
		this.orderGet++;
		this.dropDownHorizontalOffset.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getDropDownHorizontalOffset() : string {
		if (this.dropDownHorizontalOffset == null || this.dropDownHorizontalOffset == undefined) {
			this.dropDownHorizontalOffset = new CommandAttr<string>();
		}
		return this.dropDownHorizontalOffset.getCommandReturnValue();
	}
	public setDropDownHorizontalOffset(value : string) : T {
		this.resetIfRequired();
		if (this.dropDownHorizontalOffset == null || this.dropDownHorizontalOffset == undefined) {
			this.dropDownHorizontalOffset = new CommandAttr<string>();
		}
		
		this.dropDownHorizontalOffset.setSetter(true);
		this.dropDownHorizontalOffset.setValue(value);
		this.orderSet++;
		this.dropDownHorizontalOffset.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetDropDownVerticalOffset() : T {
		this.resetIfRequired();
		if (this.dropDownVerticalOffset == null || this.dropDownVerticalOffset == undefined) {
			this.dropDownVerticalOffset = new CommandAttr<string>()
		}
		
		this.dropDownVerticalOffset.setGetter(true);
		this.orderGet++;
		this.dropDownVerticalOffset.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getDropDownVerticalOffset() : string {
		if (this.dropDownVerticalOffset == null || this.dropDownVerticalOffset == undefined) {
			this.dropDownVerticalOffset = new CommandAttr<string>();
		}
		return this.dropDownVerticalOffset.getCommandReturnValue();
	}
	public setDropDownVerticalOffset(value : string) : T {
		this.resetIfRequired();
		if (this.dropDownVerticalOffset == null || this.dropDownVerticalOffset == undefined) {
			this.dropDownVerticalOffset = new CommandAttr<string>();
		}
		
		this.dropDownVerticalOffset.setSetter(true);
		this.dropDownVerticalOffset.setValue(value);
		this.orderSet++;
		this.dropDownVerticalOffset.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetDropDownWidth() : T {
		this.resetIfRequired();
		if (this.dropDownWidth == null || this.dropDownWidth == undefined) {
			this.dropDownWidth = new CommandAttr<string>()
		}
		
		this.dropDownWidth.setGetter(true);
		this.orderGet++;
		this.dropDownWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getDropDownWidth() : string {
		if (this.dropDownWidth == null || this.dropDownWidth == undefined) {
			this.dropDownWidth = new CommandAttr<string>();
		}
		return this.dropDownWidth.getCommandReturnValue();
	}
	public setDropDownWidth(value : string) : T {
		this.resetIfRequired();
		if (this.dropDownWidth == null || this.dropDownWidth == undefined) {
			this.dropDownWidth = new CommandAttr<string>();
		}
		
		this.dropDownWidth.setSetter(true);
		this.dropDownWidth.setValue(value);
		this.orderSet++;
		this.dropDownWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setPrompt(value : string) : T {
		this.resetIfRequired();
		if (this.prompt == null || this.prompt == undefined) {
			this.prompt = new CommandAttr<string>();
		}
		
		this.prompt.setSetter(true);
		this.prompt.setValue(value);
		this.orderSet++;
		this.prompt.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSelection(value : number) : T {
		this.resetIfRequired();
		if (this.selection == null || this.selection == undefined) {
			this.selection = new CommandAttr<number>();
		}
		
		this.selection.setSetter(true);
		this.selection.setValue(value);
		this.orderSet++;
		this.selection.setOrderSet(this.orderSet);
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
		

	public setListitem(value : string) : T {
		this.resetIfRequired();
		if (this.listitem == null || this.listitem == undefined) {
			this.listitem = new CommandAttr<string>();
		}
		
		this.listitem.setSetter(true);
		this.listitem.setValue(value);
		this.orderSet++;
		this.listitem.setOrderSet(this.orderSet);
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
		

	public tryGetSelectedValue() : T {
		this.resetIfRequired();
		if (this.selectedValue == null || this.selectedValue == undefined) {
			this.selectedValue = new CommandAttr<any>()
		}
		
		this.selectedValue.setGetter(true);
		this.orderGet++;
		this.selectedValue.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getSelectedValue() : any {
		if (this.selectedValue == null || this.selectedValue == undefined) {
			this.selectedValue = new CommandAttr<any>();
		}
		return this.selectedValue.getCommandReturnValue();
	}
	public setSelectedValue(value : any) : T {
		this.resetIfRequired();
		if (this.selectedValue == null || this.selectedValue == undefined) {
			this.selectedValue = new CommandAttr<any>();
		}
		
		this.selectedValue.setSetter(true);
		this.selectedValue.setValue(value);
		this.orderSet++;
		this.selectedValue.setOrderSet(this.orderSet);
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
		
	//end - body

}
	
//start - staticinit

export class Spinner extends SpinnerImpl<Spinner> implements IWidget{
    getThisPointer(): Spinner {
        return this;
    }
    
   	public getClass() {
		return Spinner;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

SpinnerImpl.initialize();
export interface OnItemSelectedEvent extends Event{
        //parent:AdapterView<?>;

        //view:View;

	        position:number;
	        idInt:number;

}
export interface OnNothingSelectedEvent extends Event{
        //parent:AdapterView<?>;


}

//end - staticinit
