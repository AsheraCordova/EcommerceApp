// start - imports

export const enum DescendantFocusability {
afterDescendants = "afterDescendants",
beforeDescendants = "beforeDescendants",
blocksDescendants = "blocksDescendants",
}
export const enum LayoutMode {
clipBounds = "clipBounds",
opticalBounds = "opticalBounds",
}
export const enum PersistentDrawingCache {
all = "all",
animation = "animation",
none = "none",
scrolling = "scrolling",
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








export class PersistentDrawingCacheTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<PersistentDrawingCache> = new Array<PersistentDrawingCache>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "all":
						valueArr.push(PersistentDrawingCache.all);
                       	break;	
					case "animation":
						valueArr.push(PersistentDrawingCache.animation);
                       	break;	
					case "none":
						valueArr.push(PersistentDrawingCache.none);
                       	break;	
					case "scrolling":
						valueArr.push(PersistentDrawingCache.scrolling);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}


















// end - imports

import {ViewGroupModelImpl} from './ViewGroupModelImpl';

export abstract class ViewGroupImpl<T> extends ViewGroupModelImpl<T>{
	//start - body
	static initialize() {
		TransformerFactory.getInstance().register("persistentDrawingCache", new PersistentDrawingCacheTransformer());
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "alwaysDrawnWithCache" })
	alwaysDrawnWithCache!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "animationCache" })
	animationCache!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "clipChildren" })
	clipChildren!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "clipToPadding" })
	clipToPadding!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "descendantFocusability" })
	descendantFocusability!:CommandAttr<DescendantFocusability>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layoutMode" })
	layoutMode!:CommandAttr<LayoutMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "persistentDrawingCache" })
	persistentDrawingCache!:CommandAttr<PersistentDrawingCache[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "splitMotionEvents" })
	splitMotionEvents!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onChildViewAdded" })
	onChildViewAdded!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onChildViewRemoved" })
	onChildViewRemoved!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "animateLayoutChanges" })
	animateLayoutChanges!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "listitem" })
	listitem!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "addStatesFromChildren" })
	addStatesFromChildren!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "childXml" })
	childXml!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.alwaysDrawnWithCache = undefined;
		this.animationCache = undefined;
		this.clipChildren = undefined;
		this.clipToPadding = undefined;
		this.descendantFocusability = undefined;
		this.layoutMode = undefined;
		this.persistentDrawingCache = undefined;
		this.splitMotionEvents = undefined;
		this.onChildViewAdded = undefined;
		this.onChildViewRemoved = undefined;
		this.animateLayoutChanges = undefined;
		this.listitem = undefined;
		this.addStatesFromChildren = undefined;
		this.childXml = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetAlwaysDrawnWithCache() : T {
		this.resetIfRequired();
		if (this.alwaysDrawnWithCache == null || this.alwaysDrawnWithCache == undefined) {
			this.alwaysDrawnWithCache = new CommandAttr<boolean>()
		}
		
		this.alwaysDrawnWithCache.setGetter(true);
		this.orderGet++;
		this.alwaysDrawnWithCache.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isAlwaysDrawnWithCache() : boolean {
		if (this.alwaysDrawnWithCache == null || this.alwaysDrawnWithCache == undefined) {
			this.alwaysDrawnWithCache = new CommandAttr<boolean>();
		}
		return this.alwaysDrawnWithCache.getCommandReturnValue();
	}
	public setAlwaysDrawnWithCache(value : boolean) : T {
		this.resetIfRequired();
		if (this.alwaysDrawnWithCache == null || this.alwaysDrawnWithCache == undefined) {
			this.alwaysDrawnWithCache = new CommandAttr<boolean>();
		}
		
		this.alwaysDrawnWithCache.setSetter(true);
		this.alwaysDrawnWithCache.setValue(value);
		this.orderSet++;
		this.alwaysDrawnWithCache.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetAnimationCache() : T {
		this.resetIfRequired();
		if (this.animationCache == null || this.animationCache == undefined) {
			this.animationCache = new CommandAttr<boolean>()
		}
		
		this.animationCache.setGetter(true);
		this.orderGet++;
		this.animationCache.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isAnimationCache() : boolean {
		if (this.animationCache == null || this.animationCache == undefined) {
			this.animationCache = new CommandAttr<boolean>();
		}
		return this.animationCache.getCommandReturnValue();
	}
	public setAnimationCache(value : boolean) : T {
		this.resetIfRequired();
		if (this.animationCache == null || this.animationCache == undefined) {
			this.animationCache = new CommandAttr<boolean>();
		}
		
		this.animationCache.setSetter(true);
		this.animationCache.setValue(value);
		this.orderSet++;
		this.animationCache.setOrderSet(this.orderSet);
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
		

	public tryGetDescendantFocusability() : T {
		this.resetIfRequired();
		if (this.descendantFocusability == null || this.descendantFocusability == undefined) {
			this.descendantFocusability = new CommandAttr<DescendantFocusability>()
		}
		
		this.descendantFocusability.setGetter(true);
		this.orderGet++;
		this.descendantFocusability.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getDescendantFocusability() : DescendantFocusability {
		if (this.descendantFocusability == null || this.descendantFocusability == undefined) {
			this.descendantFocusability = new CommandAttr<DescendantFocusability>();
		}
		return this.descendantFocusability.getCommandReturnValue();
	}
	public setDescendantFocusability(value : DescendantFocusability) : T {
		this.resetIfRequired();
		if (this.descendantFocusability == null || this.descendantFocusability == undefined) {
			this.descendantFocusability = new CommandAttr<DescendantFocusability>();
		}
		
		this.descendantFocusability.setSetter(true);
		this.descendantFocusability.setValue(value);
		this.orderSet++;
		this.descendantFocusability.setOrderSet(this.orderSet);
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
		

	public tryGetPersistentDrawingCache() : T {
		this.resetIfRequired();
		if (this.persistentDrawingCache == null || this.persistentDrawingCache == undefined) {
			this.persistentDrawingCache = new CommandAttr<PersistentDrawingCache[]>()
		}
		
		this.persistentDrawingCache.setGetter(true);
		this.orderGet++;
		this.persistentDrawingCache.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getPersistentDrawingCache() : PersistentDrawingCache[] {
		if (this.persistentDrawingCache == null || this.persistentDrawingCache == undefined) {
			this.persistentDrawingCache = new CommandAttr<PersistentDrawingCache[]>();
		}
this.persistentDrawingCache.setTransformer('persistentDrawingCache');		return this.persistentDrawingCache.getCommandReturnValue();
	}
	public setPersistentDrawingCache(...value : PersistentDrawingCache[]) : T {
		this.resetIfRequired();
		if (this.persistentDrawingCache == null || this.persistentDrawingCache == undefined) {
			this.persistentDrawingCache = new CommandAttr<PersistentDrawingCache[]>();
		}
		
		this.persistentDrawingCache.setSetter(true);
		this.persistentDrawingCache.setValue(value);
		this.orderSet++;
		this.persistentDrawingCache.setOrderSet(this.orderSet);
this.persistentDrawingCache.setTransformer('persistentDrawingCache');		return this.thisPointer;
	}
		

	public tryGetSplitMotionEvents() : T {
		this.resetIfRequired();
		if (this.splitMotionEvents == null || this.splitMotionEvents == undefined) {
			this.splitMotionEvents = new CommandAttr<boolean>()
		}
		
		this.splitMotionEvents.setGetter(true);
		this.orderGet++;
		this.splitMotionEvents.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isSplitMotionEvents() : boolean {
		if (this.splitMotionEvents == null || this.splitMotionEvents == undefined) {
			this.splitMotionEvents = new CommandAttr<boolean>();
		}
		return this.splitMotionEvents.getCommandReturnValue();
	}
	public setSplitMotionEvents(value : boolean) : T {
		this.resetIfRequired();
		if (this.splitMotionEvents == null || this.splitMotionEvents == undefined) {
			this.splitMotionEvents = new CommandAttr<boolean>();
		}
		
		this.splitMotionEvents.setSetter(true);
		this.splitMotionEvents.setValue(value);
		this.orderSet++;
		this.splitMotionEvents.setOrderSet(this.orderSet);
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
		

	public setAnimateLayoutChanges(value : boolean) : T {
		this.resetIfRequired();
		if (this.animateLayoutChanges == null || this.animateLayoutChanges == undefined) {
			this.animateLayoutChanges = new CommandAttr<boolean>();
		}
		
		this.animateLayoutChanges.setSetter(true);
		this.animateLayoutChanges.setValue(value);
		this.orderSet++;
		this.animateLayoutChanges.setOrderSet(this.orderSet);
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
export interface OnChildViewAddedEvent extends Event{
        //parent:View;

        //child:View;


}
export interface OnChildViewRemovedEvent extends Event{
        //parent:View;

        //child:View;


}

//end - staticinit