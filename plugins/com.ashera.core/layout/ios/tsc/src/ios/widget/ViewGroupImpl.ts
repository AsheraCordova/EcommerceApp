// start - imports

export const enum LayoutMode {
clipBounds = "clipBounds",
opticalBounds = "opticalBounds",
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
import {ViewGroupModelImpl} from './ViewGroupModelImpl';
export abstract class ViewGroupImpl<T> extends ViewGroupModelImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "listitem" })
	listitem!:CommandAttr<string>| undefined;
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
	@Expose({ name: "addStatesFromChildren" })
	addStatesFromChildren!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onChildViewAdded" })
	onChildViewAdded!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "clipChildren" })
	clipChildren!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "clipToPadding" })
	clipToPadding!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layoutMode" })
	layoutMode!:CommandAttr<LayoutMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onChildViewRemoved" })
	onChildViewRemoved!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "childXml" })
	childXml!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.listitem = undefined;
		this.padding = undefined;
		this.paddingBottom = undefined;
		this.paddingRight = undefined;
		this.paddingLeft = undefined;
		this.paddingStart = undefined;
		this.paddingEnd = undefined;
		this.paddingTop = undefined;
		this.paddingHorizontal = undefined;
		this.paddingVertical = undefined;
		this.addStatesFromChildren = undefined;
		this.onChildViewAdded = undefined;
		this.clipChildren = undefined;
		this.clipToPadding = undefined;
		this.layoutMode = undefined;
		this.onChildViewRemoved = undefined;
		this.childXml = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
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
		

	public tryGetAddStatesFromChildren() : T {
		this.resetIfRequired();
		if (this.addStatesFromChildren == null || this.addStatesFromChildren == undefined) {
			this.addStatesFromChildren = new CommandAttr<boolean>()
		}
		
		this.addStatesFromChildren.setGetter(true);
		this.orderGet++;
		this.addStatesFromChildren.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isAddStatesFromChildren() : boolean {
		if (this.addStatesFromChildren == null || this.addStatesFromChildren == undefined) {
			this.addStatesFromChildren = new CommandAttr<boolean>();
		}
		return this.addStatesFromChildren.getCommandReturnValue();
	}
	public setAddStatesFromChildren(value : boolean) : T {
		this.resetIfRequired();
		if (this.addStatesFromChildren == null || this.addStatesFromChildren == undefined) {
			this.addStatesFromChildren = new CommandAttr<boolean>();
		}
		
		this.addStatesFromChildren.setSetter(true);
		this.addStatesFromChildren.setValue(value);
		this.orderSet++;
		this.addStatesFromChildren.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnChildViewAdded(value : string) : T {
		this.resetIfRequired();
		if (this.onChildViewAdded == null || this.onChildViewAdded == undefined) {
			this.onChildViewAdded = new CommandAttr<string>();
		}
		
		this.onChildViewAdded.setSetter(true);
		this.onChildViewAdded.setValue(value);
		this.orderSet++;
		this.onChildViewAdded.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetClipChildren() : T {
		this.resetIfRequired();
		if (this.clipChildren == null || this.clipChildren == undefined) {
			this.clipChildren = new CommandAttr<boolean>()
		}
		
		this.clipChildren.setGetter(true);
		this.orderGet++;
		this.clipChildren.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isClipChildren() : boolean {
		if (this.clipChildren == null || this.clipChildren == undefined) {
			this.clipChildren = new CommandAttr<boolean>();
		}
		return this.clipChildren.getCommandReturnValue();
	}
	public setClipChildren(value : boolean) : T {
		this.resetIfRequired();
		if (this.clipChildren == null || this.clipChildren == undefined) {
			this.clipChildren = new CommandAttr<boolean>();
		}
		
		this.clipChildren.setSetter(true);
		this.clipChildren.setValue(value);
		this.orderSet++;
		this.clipChildren.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetClipToPadding() : T {
		this.resetIfRequired();
		if (this.clipToPadding == null || this.clipToPadding == undefined) {
			this.clipToPadding = new CommandAttr<boolean>()
		}
		
		this.clipToPadding.setGetter(true);
		this.orderGet++;
		this.clipToPadding.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isClipToPadding() : boolean {
		if (this.clipToPadding == null || this.clipToPadding == undefined) {
			this.clipToPadding = new CommandAttr<boolean>();
		}
		return this.clipToPadding.getCommandReturnValue();
	}
	public setClipToPadding(value : boolean) : T {
		this.resetIfRequired();
		if (this.clipToPadding == null || this.clipToPadding == undefined) {
			this.clipToPadding = new CommandAttr<boolean>();
		}
		
		this.clipToPadding.setSetter(true);
		this.clipToPadding.setValue(value);
		this.orderSet++;
		this.clipToPadding.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetLayoutMode() : T {
		this.resetIfRequired();
		if (this.layoutMode == null || this.layoutMode == undefined) {
			this.layoutMode = new CommandAttr<LayoutMode>()
		}
		
		this.layoutMode.setGetter(true);
		this.orderGet++;
		this.layoutMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutMode() : LayoutMode {
		if (this.layoutMode == null || this.layoutMode == undefined) {
			this.layoutMode = new CommandAttr<LayoutMode>();
		}
		return this.layoutMode.getCommandReturnValue();
	}
	public setLayoutMode(value : LayoutMode) : T {
		this.resetIfRequired();
		if (this.layoutMode == null || this.layoutMode == undefined) {
			this.layoutMode = new CommandAttr<LayoutMode>();
		}
		
		this.layoutMode.setSetter(true);
		this.layoutMode.setValue(value);
		this.orderSet++;
		this.layoutMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnChildViewRemoved(value : string) : T {
		this.resetIfRequired();
		if (this.onChildViewRemoved == null || this.onChildViewRemoved == undefined) {
			this.onChildViewRemoved = new CommandAttr<string>();
		}
		
		this.onChildViewRemoved.setSetter(true);
		this.onChildViewRemoved.setValue(value);
		this.orderSet++;
		this.onChildViewRemoved.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setChildXml(value : string) : T {
		this.resetIfRequired();
		if (this.childXml == null || this.childXml == undefined) {
			this.childXml = new CommandAttr<string>();
		}
		
		this.childXml.setSetter(true);
		this.childXml.setValue(value);
		this.orderSet++;
		this.childXml.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit
export abstract class ViewGroupImpl_LayoutParams<T>  {
	@Type(() => CommandAttr)
	@Expose({ name: "layout_marginBottom" })
	layout_marginBottom!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_marginTop" })
	layout_marginTop!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_marginStart" })
	layout_marginStart!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_marginEnd" })
	layout_marginEnd!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_marginLeft" })
	layout_marginLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_marginRight" })
	layout_marginRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_margin" })
	layout_margin!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_marginHorizontal" })
	layout_marginHorizontal!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_marginVertical" })
	layout_marginVertical!:CommandAttr<string>| undefined;
	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	@Exclude()
	protected orderGet: number = 0;
	@Exclude()
    protected orderSet: number = 0;
	reset() : T {	
		this.layout_marginBottom = undefined;
		this.layout_marginTop = undefined;
		this.layout_marginStart = undefined;
		this.layout_marginEnd = undefined;
		this.layout_marginLeft = undefined;
		this.layout_marginRight = undefined;
		this.layout_margin = undefined;
		this.layout_marginHorizontal = undefined;
		this.layout_marginVertical = undefined;
		this.orderGet = 0;
		this.orderSet = 0;
		return this.thisPointer;
	}
	constructor() {		
		this.thisPointer = this.getThisPointer();
	}
	
	public tryGetLayoutMarginBottom() : T {
		if (this.layout_marginBottom == null || this.layout_marginBottom == undefined) {
			this.layout_marginBottom = new CommandAttr<string>()
		}
		
		this.layout_marginBottom.setGetter(true);
		this.orderGet++;
		this.layout_marginBottom.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutMarginBottom() : string {
		if (this.layout_marginBottom == null || this.layout_marginBottom == undefined) {
			this.layout_marginBottom = new CommandAttr<string>();
		}
		return this.layout_marginBottom.getCommandReturnValue();
	}
	public setLayoutMarginBottom(value : string) : T {
		if (this.layout_marginBottom == null || this.layout_marginBottom == undefined) {
			this.layout_marginBottom = new CommandAttr<string>();
		}
		this.layout_marginBottom.setSetter(true);
		this.layout_marginBottom.setValue(value);
		this.orderSet++;
		this.layout_marginBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutMarginTop() : T {
		if (this.layout_marginTop == null || this.layout_marginTop == undefined) {
			this.layout_marginTop = new CommandAttr<string>()
		}
		
		this.layout_marginTop.setGetter(true);
		this.orderGet++;
		this.layout_marginTop.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutMarginTop() : string {
		if (this.layout_marginTop == null || this.layout_marginTop == undefined) {
			this.layout_marginTop = new CommandAttr<string>();
		}
		return this.layout_marginTop.getCommandReturnValue();
	}
	public setLayoutMarginTop(value : string) : T {
		if (this.layout_marginTop == null || this.layout_marginTop == undefined) {
			this.layout_marginTop = new CommandAttr<string>();
		}
		this.layout_marginTop.setSetter(true);
		this.layout_marginTop.setValue(value);
		this.orderSet++;
		this.layout_marginTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutMarginStart() : T {
		if (this.layout_marginStart == null || this.layout_marginStart == undefined) {
			this.layout_marginStart = new CommandAttr<string>()
		}
		
		this.layout_marginStart.setGetter(true);
		this.orderGet++;
		this.layout_marginStart.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutMarginStart() : string {
		if (this.layout_marginStart == null || this.layout_marginStart == undefined) {
			this.layout_marginStart = new CommandAttr<string>();
		}
		return this.layout_marginStart.getCommandReturnValue();
	}
	public setLayoutMarginStart(value : string) : T {
		if (this.layout_marginStart == null || this.layout_marginStart == undefined) {
			this.layout_marginStart = new CommandAttr<string>();
		}
		this.layout_marginStart.setSetter(true);
		this.layout_marginStart.setValue(value);
		this.orderSet++;
		this.layout_marginStart.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutMarginEnd() : T {
		if (this.layout_marginEnd == null || this.layout_marginEnd == undefined) {
			this.layout_marginEnd = new CommandAttr<string>()
		}
		
		this.layout_marginEnd.setGetter(true);
		this.orderGet++;
		this.layout_marginEnd.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutMarginEnd() : string {
		if (this.layout_marginEnd == null || this.layout_marginEnd == undefined) {
			this.layout_marginEnd = new CommandAttr<string>();
		}
		return this.layout_marginEnd.getCommandReturnValue();
	}
	public setLayoutMarginEnd(value : string) : T {
		if (this.layout_marginEnd == null || this.layout_marginEnd == undefined) {
			this.layout_marginEnd = new CommandAttr<string>();
		}
		this.layout_marginEnd.setSetter(true);
		this.layout_marginEnd.setValue(value);
		this.orderSet++;
		this.layout_marginEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutMarginLeft() : T {
		if (this.layout_marginLeft == null || this.layout_marginLeft == undefined) {
			this.layout_marginLeft = new CommandAttr<string>()
		}
		
		this.layout_marginLeft.setGetter(true);
		this.orderGet++;
		this.layout_marginLeft.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutMarginLeft() : string {
		if (this.layout_marginLeft == null || this.layout_marginLeft == undefined) {
			this.layout_marginLeft = new CommandAttr<string>();
		}
		return this.layout_marginLeft.getCommandReturnValue();
	}
	public setLayoutMarginLeft(value : string) : T {
		if (this.layout_marginLeft == null || this.layout_marginLeft == undefined) {
			this.layout_marginLeft = new CommandAttr<string>();
		}
		this.layout_marginLeft.setSetter(true);
		this.layout_marginLeft.setValue(value);
		this.orderSet++;
		this.layout_marginLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutMarginRight() : T {
		if (this.layout_marginRight == null || this.layout_marginRight == undefined) {
			this.layout_marginRight = new CommandAttr<string>()
		}
		
		this.layout_marginRight.setGetter(true);
		this.orderGet++;
		this.layout_marginRight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutMarginRight() : string {
		if (this.layout_marginRight == null || this.layout_marginRight == undefined) {
			this.layout_marginRight = new CommandAttr<string>();
		}
		return this.layout_marginRight.getCommandReturnValue();
	}
	public setLayoutMarginRight(value : string) : T {
		if (this.layout_marginRight == null || this.layout_marginRight == undefined) {
			this.layout_marginRight = new CommandAttr<string>();
		}
		this.layout_marginRight.setSetter(true);
		this.layout_marginRight.setValue(value);
		this.orderSet++;
		this.layout_marginRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public setLayoutMargin(value : string) : T {
		if (this.layout_margin == null || this.layout_margin == undefined) {
			this.layout_margin = new CommandAttr<string>();
		}
		this.layout_margin.setSetter(true);
		this.layout_margin.setValue(value);
		this.orderSet++;
		this.layout_margin.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public setLayoutMarginHorizontal(value : string) : T {
		if (this.layout_marginHorizontal == null || this.layout_marginHorizontal == undefined) {
			this.layout_marginHorizontal = new CommandAttr<string>();
		}
		this.layout_marginHorizontal.setSetter(true);
		this.layout_marginHorizontal.setValue(value);
		this.orderSet++;
		this.layout_marginHorizontal.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public setLayoutMarginVertical(value : string) : T {
		if (this.layout_marginVertical == null || this.layout_marginVertical == undefined) {
			this.layout_marginVertical = new CommandAttr<string>();
		}
		this.layout_marginVertical.setSetter(true);
		this.layout_marginVertical.setValue(value);
		this.orderSet++;
		this.layout_marginVertical.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
}

export class ViewGroup_LayoutParams extends ViewGroupImpl_LayoutParams<ViewGroup_LayoutParams> implements ILayoutParam {
    getThisPointer(): ViewGroup_LayoutParams {
        return this;
    }

   	constructor() {
		super();	
	}
}

export class ViewGroup extends ViewGroupImpl<ViewGroup> implements IWidget{
    getThisPointer(): ViewGroup {
        return this;
    }
    
   	public getClass() {
		return ViewGroup;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ViewGroupImpl.initialize();

//end - staticinit
