// start - imports

export const enum RemoveRule {
layout_above = "layout_above",
layout_alignBaseline = "layout_alignBaseline",
layout_alignBottom = "layout_alignBottom",
layout_alignEnd = "layout_alignEnd",
layout_alignLeft = "layout_alignLeft",
layout_alignParentBottom = "layout_alignParentBottom",
layout_alignParentEnd = "layout_alignParentEnd",
layout_alignParentLeft = "layout_alignParentLeft",
layout_alignParentRight = "layout_alignParentRight",
layout_alignParentStart = "layout_alignParentStart",
layout_alignParentTop = "layout_alignParentTop",
layout_alignRight = "layout_alignRight",
layout_alignStart = "layout_alignStart",
layout_alignTop = "layout_alignTop",
layout_below = "layout_below",
layout_centerHorizontal = "layout_centerHorizontal",
layout_centerInParent = "layout_centerInParent",
layout_centerVertical = "layout_centerVertical",
layout_toEndOf = "layout_toEndOf",
layout_toLeftOf = "layout_toLeftOf",
layout_toRightOf = "layout_toRightOf",
layout_toStartOf = "layout_toStartOf",
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



























export class RemoveRuleTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<RemoveRule> = new Array<RemoveRule>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "layout_above":
						valueArr.push(RemoveRule.layout_above);
                       	break;	
					case "layout_alignBaseline":
						valueArr.push(RemoveRule.layout_alignBaseline);
                       	break;	
					case "layout_alignBottom":
						valueArr.push(RemoveRule.layout_alignBottom);
                       	break;	
					case "layout_alignEnd":
						valueArr.push(RemoveRule.layout_alignEnd);
                       	break;	
					case "layout_alignLeft":
						valueArr.push(RemoveRule.layout_alignLeft);
                       	break;	
					case "layout_alignParentBottom":
						valueArr.push(RemoveRule.layout_alignParentBottom);
                       	break;	
					case "layout_alignParentEnd":
						valueArr.push(RemoveRule.layout_alignParentEnd);
                       	break;	
					case "layout_alignParentLeft":
						valueArr.push(RemoveRule.layout_alignParentLeft);
                       	break;	
					case "layout_alignParentRight":
						valueArr.push(RemoveRule.layout_alignParentRight);
                       	break;	
					case "layout_alignParentStart":
						valueArr.push(RemoveRule.layout_alignParentStart);
                       	break;	
					case "layout_alignParentTop":
						valueArr.push(RemoveRule.layout_alignParentTop);
                       	break;	
					case "layout_alignRight":
						valueArr.push(RemoveRule.layout_alignRight);
                       	break;	
					case "layout_alignStart":
						valueArr.push(RemoveRule.layout_alignStart);
                       	break;	
					case "layout_alignTop":
						valueArr.push(RemoveRule.layout_alignTop);
                       	break;	
					case "layout_below":
						valueArr.push(RemoveRule.layout_below);
                       	break;	
					case "layout_centerHorizontal":
						valueArr.push(RemoveRule.layout_centerHorizontal);
                       	break;	
					case "layout_centerInParent":
						valueArr.push(RemoveRule.layout_centerInParent);
                       	break;	
					case "layout_centerVertical":
						valueArr.push(RemoveRule.layout_centerVertical);
                       	break;	
					case "layout_toEndOf":
						valueArr.push(RemoveRule.layout_toEndOf);
                       	break;	
					case "layout_toLeftOf":
						valueArr.push(RemoveRule.layout_toLeftOf);
                       	break;	
					case "layout_toRightOf":
						valueArr.push(RemoveRule.layout_toRightOf);
                       	break;	
					case "layout_toStartOf":
						valueArr.push(RemoveRule.layout_toStartOf);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}

import {ViewGroupImpl_LayoutParams} from './ViewGroupImpl';

// end - imports
import {ViewGroupImpl} from './ViewGroupImpl';
export abstract class RootImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
		TransformerFactory.getInstance().register("removeRule", new RemoveRuleTransformer());
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "gravity" })
	gravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "ignoreGravity" })
	ignoreGravity!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.gravity = undefined;
		this.ignoreGravity = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
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
		

	public setIgnoreGravity(value : string) : T {
		this.resetIfRequired();
		if (this.ignoreGravity == null || this.ignoreGravity == undefined) {
			this.ignoreGravity = new CommandAttr<string>();
		}
		
		this.ignoreGravity.setSetter(true);
		this.ignoreGravity.setValue(value);
		this.orderSet++;
		this.ignoreGravity.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit
export abstract class RootImpl_LayoutParams<T> extends ViewGroupImpl_LayoutParams<T> {
	@Type(() => CommandAttr)
	@Expose({ name: "layout_above" })
	layout_above!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignBaseline" })
	layout_alignBaseline!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignBottom" })
	layout_alignBottom!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignEnd" })
	layout_alignEnd!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignLeft" })
	layout_alignLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignParentBottom" })
	layout_alignParentBottom!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignParentEnd" })
	layout_alignParentEnd!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignParentLeft" })
	layout_alignParentLeft!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignParentRight" })
	layout_alignParentRight!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignParentStart" })
	layout_alignParentStart!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignParentTop" })
	layout_alignParentTop!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignRight" })
	layout_alignRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignStart" })
	layout_alignStart!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignTop" })
	layout_alignTop!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_below" })
	layout_below!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_centerHorizontal" })
	layout_centerHorizontal!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_centerInParent" })
	layout_centerInParent!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_centerVertical" })
	layout_centerVertical!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_toEndOf" })
	layout_toEndOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_toLeftOf" })
	layout_toLeftOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_toRightOf" })
	layout_toRightOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_toStartOf" })
	layout_toStartOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_alignWithParentIfMissing" })
	layout_alignWithParentIfMissing!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_removeRule" })
	layout_removeRule!:CommandAttr<RemoveRule[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_removeAllRules" })
	layout_removeAllRules!:CommandAttr<boolean>| undefined;
	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.layout_above = undefined;
		this.layout_alignBaseline = undefined;
		this.layout_alignBottom = undefined;
		this.layout_alignEnd = undefined;
		this.layout_alignLeft = undefined;
		this.layout_alignParentBottom = undefined;
		this.layout_alignParentEnd = undefined;
		this.layout_alignParentLeft = undefined;
		this.layout_alignParentRight = undefined;
		this.layout_alignParentStart = undefined;
		this.layout_alignParentTop = undefined;
		this.layout_alignRight = undefined;
		this.layout_alignStart = undefined;
		this.layout_alignTop = undefined;
		this.layout_below = undefined;
		this.layout_centerHorizontal = undefined;
		this.layout_centerInParent = undefined;
		this.layout_centerVertical = undefined;
		this.layout_toEndOf = undefined;
		this.layout_toLeftOf = undefined;
		this.layout_toRightOf = undefined;
		this.layout_toStartOf = undefined;
		this.layout_alignWithParentIfMissing = undefined;
		this.layout_removeRule = undefined;
		this.layout_removeAllRules = undefined;
		return this.thisPointer;
	}
	constructor() {
		super();
		this.thisPointer = this.getThisPointer();
	}
	
	public tryGetLayoutAbove() : T {
		if (this.layout_above == null || this.layout_above == undefined) {
			this.layout_above = new CommandAttr<string>()
		}
		
		this.layout_above.setGetter(true);
		this.orderGet++;
		this.layout_above.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutAbove() : string {
		if (this.layout_above == null || this.layout_above == undefined) {
			this.layout_above = new CommandAttr<string>();
		}
		return this.layout_above.getCommandReturnValue();
	}
	public setLayoutAbove(value : string) : T {
		if (this.layout_above == null || this.layout_above == undefined) {
			this.layout_above = new CommandAttr<string>();
		}
		this.layout_above.setSetter(true);
		this.layout_above.setValue(value);
		this.orderSet++;
		this.layout_above.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignBaseline() : T {
		if (this.layout_alignBaseline == null || this.layout_alignBaseline == undefined) {
			this.layout_alignBaseline = new CommandAttr<string>()
		}
		
		this.layout_alignBaseline.setGetter(true);
		this.orderGet++;
		this.layout_alignBaseline.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutAlignBaseline() : string {
		if (this.layout_alignBaseline == null || this.layout_alignBaseline == undefined) {
			this.layout_alignBaseline = new CommandAttr<string>();
		}
		return this.layout_alignBaseline.getCommandReturnValue();
	}
	public setLayoutAlignBaseline(value : string) : T {
		if (this.layout_alignBaseline == null || this.layout_alignBaseline == undefined) {
			this.layout_alignBaseline = new CommandAttr<string>();
		}
		this.layout_alignBaseline.setSetter(true);
		this.layout_alignBaseline.setValue(value);
		this.orderSet++;
		this.layout_alignBaseline.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignBottom() : T {
		if (this.layout_alignBottom == null || this.layout_alignBottom == undefined) {
			this.layout_alignBottom = new CommandAttr<string>()
		}
		
		this.layout_alignBottom.setGetter(true);
		this.orderGet++;
		this.layout_alignBottom.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutAlignBottom() : string {
		if (this.layout_alignBottom == null || this.layout_alignBottom == undefined) {
			this.layout_alignBottom = new CommandAttr<string>();
		}
		return this.layout_alignBottom.getCommandReturnValue();
	}
	public setLayoutAlignBottom(value : string) : T {
		if (this.layout_alignBottom == null || this.layout_alignBottom == undefined) {
			this.layout_alignBottom = new CommandAttr<string>();
		}
		this.layout_alignBottom.setSetter(true);
		this.layout_alignBottom.setValue(value);
		this.orderSet++;
		this.layout_alignBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignEnd() : T {
		if (this.layout_alignEnd == null || this.layout_alignEnd == undefined) {
			this.layout_alignEnd = new CommandAttr<string>()
		}
		
		this.layout_alignEnd.setGetter(true);
		this.orderGet++;
		this.layout_alignEnd.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutAlignEnd() : string {
		if (this.layout_alignEnd == null || this.layout_alignEnd == undefined) {
			this.layout_alignEnd = new CommandAttr<string>();
		}
		return this.layout_alignEnd.getCommandReturnValue();
	}
	public setLayoutAlignEnd(value : string) : T {
		if (this.layout_alignEnd == null || this.layout_alignEnd == undefined) {
			this.layout_alignEnd = new CommandAttr<string>();
		}
		this.layout_alignEnd.setSetter(true);
		this.layout_alignEnd.setValue(value);
		this.orderSet++;
		this.layout_alignEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignLeft() : T {
		if (this.layout_alignLeft == null || this.layout_alignLeft == undefined) {
			this.layout_alignLeft = new CommandAttr<string>()
		}
		
		this.layout_alignLeft.setGetter(true);
		this.orderGet++;
		this.layout_alignLeft.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutAlignLeft() : string {
		if (this.layout_alignLeft == null || this.layout_alignLeft == undefined) {
			this.layout_alignLeft = new CommandAttr<string>();
		}
		return this.layout_alignLeft.getCommandReturnValue();
	}
	public setLayoutAlignLeft(value : string) : T {
		if (this.layout_alignLeft == null || this.layout_alignLeft == undefined) {
			this.layout_alignLeft = new CommandAttr<string>();
		}
		this.layout_alignLeft.setSetter(true);
		this.layout_alignLeft.setValue(value);
		this.orderSet++;
		this.layout_alignLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignParentBottom() : T {
		if (this.layout_alignParentBottom == null || this.layout_alignParentBottom == undefined) {
			this.layout_alignParentBottom = new CommandAttr<boolean>()
		}
		
		this.layout_alignParentBottom.setGetter(true);
		this.orderGet++;
		this.layout_alignParentBottom.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutAlignParentBottom() : boolean {
		if (this.layout_alignParentBottom == null || this.layout_alignParentBottom == undefined) {
			this.layout_alignParentBottom = new CommandAttr<boolean>();
		}
		return this.layout_alignParentBottom.getCommandReturnValue();
	}
	public setLayoutAlignParentBottom(value : boolean) : T {
		if (this.layout_alignParentBottom == null || this.layout_alignParentBottom == undefined) {
			this.layout_alignParentBottom = new CommandAttr<boolean>();
		}
		this.layout_alignParentBottom.setSetter(true);
		this.layout_alignParentBottom.setValue(value);
		this.orderSet++;
		this.layout_alignParentBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignParentEnd() : T {
		if (this.layout_alignParentEnd == null || this.layout_alignParentEnd == undefined) {
			this.layout_alignParentEnd = new CommandAttr<boolean>()
		}
		
		this.layout_alignParentEnd.setGetter(true);
		this.orderGet++;
		this.layout_alignParentEnd.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutAlignParentEnd() : boolean {
		if (this.layout_alignParentEnd == null || this.layout_alignParentEnd == undefined) {
			this.layout_alignParentEnd = new CommandAttr<boolean>();
		}
		return this.layout_alignParentEnd.getCommandReturnValue();
	}
	public setLayoutAlignParentEnd(value : boolean) : T {
		if (this.layout_alignParentEnd == null || this.layout_alignParentEnd == undefined) {
			this.layout_alignParentEnd = new CommandAttr<boolean>();
		}
		this.layout_alignParentEnd.setSetter(true);
		this.layout_alignParentEnd.setValue(value);
		this.orderSet++;
		this.layout_alignParentEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignParentLeft() : T {
		if (this.layout_alignParentLeft == null || this.layout_alignParentLeft == undefined) {
			this.layout_alignParentLeft = new CommandAttr<boolean>()
		}
		
		this.layout_alignParentLeft.setGetter(true);
		this.orderGet++;
		this.layout_alignParentLeft.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutAlignParentLeft() : boolean {
		if (this.layout_alignParentLeft == null || this.layout_alignParentLeft == undefined) {
			this.layout_alignParentLeft = new CommandAttr<boolean>();
		}
		return this.layout_alignParentLeft.getCommandReturnValue();
	}
	public setLayoutAlignParentLeft(value : boolean) : T {
		if (this.layout_alignParentLeft == null || this.layout_alignParentLeft == undefined) {
			this.layout_alignParentLeft = new CommandAttr<boolean>();
		}
		this.layout_alignParentLeft.setSetter(true);
		this.layout_alignParentLeft.setValue(value);
		this.orderSet++;
		this.layout_alignParentLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignParentRight() : T {
		if (this.layout_alignParentRight == null || this.layout_alignParentRight == undefined) {
			this.layout_alignParentRight = new CommandAttr<boolean>()
		}
		
		this.layout_alignParentRight.setGetter(true);
		this.orderGet++;
		this.layout_alignParentRight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutAlignParentRight() : boolean {
		if (this.layout_alignParentRight == null || this.layout_alignParentRight == undefined) {
			this.layout_alignParentRight = new CommandAttr<boolean>();
		}
		return this.layout_alignParentRight.getCommandReturnValue();
	}
	public setLayoutAlignParentRight(value : boolean) : T {
		if (this.layout_alignParentRight == null || this.layout_alignParentRight == undefined) {
			this.layout_alignParentRight = new CommandAttr<boolean>();
		}
		this.layout_alignParentRight.setSetter(true);
		this.layout_alignParentRight.setValue(value);
		this.orderSet++;
		this.layout_alignParentRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignParentStart() : T {
		if (this.layout_alignParentStart == null || this.layout_alignParentStart == undefined) {
			this.layout_alignParentStart = new CommandAttr<boolean>()
		}
		
		this.layout_alignParentStart.setGetter(true);
		this.orderGet++;
		this.layout_alignParentStart.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutAlignParentStart() : boolean {
		if (this.layout_alignParentStart == null || this.layout_alignParentStart == undefined) {
			this.layout_alignParentStart = new CommandAttr<boolean>();
		}
		return this.layout_alignParentStart.getCommandReturnValue();
	}
	public setLayoutAlignParentStart(value : boolean) : T {
		if (this.layout_alignParentStart == null || this.layout_alignParentStart == undefined) {
			this.layout_alignParentStart = new CommandAttr<boolean>();
		}
		this.layout_alignParentStart.setSetter(true);
		this.layout_alignParentStart.setValue(value);
		this.orderSet++;
		this.layout_alignParentStart.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignParentTop() : T {
		if (this.layout_alignParentTop == null || this.layout_alignParentTop == undefined) {
			this.layout_alignParentTop = new CommandAttr<boolean>()
		}
		
		this.layout_alignParentTop.setGetter(true);
		this.orderGet++;
		this.layout_alignParentTop.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutAlignParentTop() : boolean {
		if (this.layout_alignParentTop == null || this.layout_alignParentTop == undefined) {
			this.layout_alignParentTop = new CommandAttr<boolean>();
		}
		return this.layout_alignParentTop.getCommandReturnValue();
	}
	public setLayoutAlignParentTop(value : boolean) : T {
		if (this.layout_alignParentTop == null || this.layout_alignParentTop == undefined) {
			this.layout_alignParentTop = new CommandAttr<boolean>();
		}
		this.layout_alignParentTop.setSetter(true);
		this.layout_alignParentTop.setValue(value);
		this.orderSet++;
		this.layout_alignParentTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignRight() : T {
		if (this.layout_alignRight == null || this.layout_alignRight == undefined) {
			this.layout_alignRight = new CommandAttr<string>()
		}
		
		this.layout_alignRight.setGetter(true);
		this.orderGet++;
		this.layout_alignRight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutAlignRight() : string {
		if (this.layout_alignRight == null || this.layout_alignRight == undefined) {
			this.layout_alignRight = new CommandAttr<string>();
		}
		return this.layout_alignRight.getCommandReturnValue();
	}
	public setLayoutAlignRight(value : string) : T {
		if (this.layout_alignRight == null || this.layout_alignRight == undefined) {
			this.layout_alignRight = new CommandAttr<string>();
		}
		this.layout_alignRight.setSetter(true);
		this.layout_alignRight.setValue(value);
		this.orderSet++;
		this.layout_alignRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignStart() : T {
		if (this.layout_alignStart == null || this.layout_alignStart == undefined) {
			this.layout_alignStart = new CommandAttr<string>()
		}
		
		this.layout_alignStart.setGetter(true);
		this.orderGet++;
		this.layout_alignStart.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutAlignStart() : string {
		if (this.layout_alignStart == null || this.layout_alignStart == undefined) {
			this.layout_alignStart = new CommandAttr<string>();
		}
		return this.layout_alignStart.getCommandReturnValue();
	}
	public setLayoutAlignStart(value : string) : T {
		if (this.layout_alignStart == null || this.layout_alignStart == undefined) {
			this.layout_alignStart = new CommandAttr<string>();
		}
		this.layout_alignStart.setSetter(true);
		this.layout_alignStart.setValue(value);
		this.orderSet++;
		this.layout_alignStart.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignTop() : T {
		if (this.layout_alignTop == null || this.layout_alignTop == undefined) {
			this.layout_alignTop = new CommandAttr<string>()
		}
		
		this.layout_alignTop.setGetter(true);
		this.orderGet++;
		this.layout_alignTop.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutAlignTop() : string {
		if (this.layout_alignTop == null || this.layout_alignTop == undefined) {
			this.layout_alignTop = new CommandAttr<string>();
		}
		return this.layout_alignTop.getCommandReturnValue();
	}
	public setLayoutAlignTop(value : string) : T {
		if (this.layout_alignTop == null || this.layout_alignTop == undefined) {
			this.layout_alignTop = new CommandAttr<string>();
		}
		this.layout_alignTop.setSetter(true);
		this.layout_alignTop.setValue(value);
		this.orderSet++;
		this.layout_alignTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutBelow() : T {
		if (this.layout_below == null || this.layout_below == undefined) {
			this.layout_below = new CommandAttr<string>()
		}
		
		this.layout_below.setGetter(true);
		this.orderGet++;
		this.layout_below.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutBelow() : string {
		if (this.layout_below == null || this.layout_below == undefined) {
			this.layout_below = new CommandAttr<string>();
		}
		return this.layout_below.getCommandReturnValue();
	}
	public setLayoutBelow(value : string) : T {
		if (this.layout_below == null || this.layout_below == undefined) {
			this.layout_below = new CommandAttr<string>();
		}
		this.layout_below.setSetter(true);
		this.layout_below.setValue(value);
		this.orderSet++;
		this.layout_below.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutCenterHorizontal() : T {
		if (this.layout_centerHorizontal == null || this.layout_centerHorizontal == undefined) {
			this.layout_centerHorizontal = new CommandAttr<boolean>()
		}
		
		this.layout_centerHorizontal.setGetter(true);
		this.orderGet++;
		this.layout_centerHorizontal.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutCenterHorizontal() : boolean {
		if (this.layout_centerHorizontal == null || this.layout_centerHorizontal == undefined) {
			this.layout_centerHorizontal = new CommandAttr<boolean>();
		}
		return this.layout_centerHorizontal.getCommandReturnValue();
	}
	public setLayoutCenterHorizontal(value : boolean) : T {
		if (this.layout_centerHorizontal == null || this.layout_centerHorizontal == undefined) {
			this.layout_centerHorizontal = new CommandAttr<boolean>();
		}
		this.layout_centerHorizontal.setSetter(true);
		this.layout_centerHorizontal.setValue(value);
		this.orderSet++;
		this.layout_centerHorizontal.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutCenterInParent() : T {
		if (this.layout_centerInParent == null || this.layout_centerInParent == undefined) {
			this.layout_centerInParent = new CommandAttr<boolean>()
		}
		
		this.layout_centerInParent.setGetter(true);
		this.orderGet++;
		this.layout_centerInParent.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutCenterInParent() : boolean {
		if (this.layout_centerInParent == null || this.layout_centerInParent == undefined) {
			this.layout_centerInParent = new CommandAttr<boolean>();
		}
		return this.layout_centerInParent.getCommandReturnValue();
	}
	public setLayoutCenterInParent(value : boolean) : T {
		if (this.layout_centerInParent == null || this.layout_centerInParent == undefined) {
			this.layout_centerInParent = new CommandAttr<boolean>();
		}
		this.layout_centerInParent.setSetter(true);
		this.layout_centerInParent.setValue(value);
		this.orderSet++;
		this.layout_centerInParent.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutCenterVertical() : T {
		if (this.layout_centerVertical == null || this.layout_centerVertical == undefined) {
			this.layout_centerVertical = new CommandAttr<boolean>()
		}
		
		this.layout_centerVertical.setGetter(true);
		this.orderGet++;
		this.layout_centerVertical.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutCenterVertical() : boolean {
		if (this.layout_centerVertical == null || this.layout_centerVertical == undefined) {
			this.layout_centerVertical = new CommandAttr<boolean>();
		}
		return this.layout_centerVertical.getCommandReturnValue();
	}
	public setLayoutCenterVertical(value : boolean) : T {
		if (this.layout_centerVertical == null || this.layout_centerVertical == undefined) {
			this.layout_centerVertical = new CommandAttr<boolean>();
		}
		this.layout_centerVertical.setSetter(true);
		this.layout_centerVertical.setValue(value);
		this.orderSet++;
		this.layout_centerVertical.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutToEndOf() : T {
		if (this.layout_toEndOf == null || this.layout_toEndOf == undefined) {
			this.layout_toEndOf = new CommandAttr<string>()
		}
		
		this.layout_toEndOf.setGetter(true);
		this.orderGet++;
		this.layout_toEndOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutToEndOf() : string {
		if (this.layout_toEndOf == null || this.layout_toEndOf == undefined) {
			this.layout_toEndOf = new CommandAttr<string>();
		}
		return this.layout_toEndOf.getCommandReturnValue();
	}
	public setLayoutToEndOf(value : string) : T {
		if (this.layout_toEndOf == null || this.layout_toEndOf == undefined) {
			this.layout_toEndOf = new CommandAttr<string>();
		}
		this.layout_toEndOf.setSetter(true);
		this.layout_toEndOf.setValue(value);
		this.orderSet++;
		this.layout_toEndOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutToLeftOf() : T {
		if (this.layout_toLeftOf == null || this.layout_toLeftOf == undefined) {
			this.layout_toLeftOf = new CommandAttr<string>()
		}
		
		this.layout_toLeftOf.setGetter(true);
		this.orderGet++;
		this.layout_toLeftOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutToLeftOf() : string {
		if (this.layout_toLeftOf == null || this.layout_toLeftOf == undefined) {
			this.layout_toLeftOf = new CommandAttr<string>();
		}
		return this.layout_toLeftOf.getCommandReturnValue();
	}
	public setLayoutToLeftOf(value : string) : T {
		if (this.layout_toLeftOf == null || this.layout_toLeftOf == undefined) {
			this.layout_toLeftOf = new CommandAttr<string>();
		}
		this.layout_toLeftOf.setSetter(true);
		this.layout_toLeftOf.setValue(value);
		this.orderSet++;
		this.layout_toLeftOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutToRightOf() : T {
		if (this.layout_toRightOf == null || this.layout_toRightOf == undefined) {
			this.layout_toRightOf = new CommandAttr<string>()
		}
		
		this.layout_toRightOf.setGetter(true);
		this.orderGet++;
		this.layout_toRightOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutToRightOf() : string {
		if (this.layout_toRightOf == null || this.layout_toRightOf == undefined) {
			this.layout_toRightOf = new CommandAttr<string>();
		}
		return this.layout_toRightOf.getCommandReturnValue();
	}
	public setLayoutToRightOf(value : string) : T {
		if (this.layout_toRightOf == null || this.layout_toRightOf == undefined) {
			this.layout_toRightOf = new CommandAttr<string>();
		}
		this.layout_toRightOf.setSetter(true);
		this.layout_toRightOf.setValue(value);
		this.orderSet++;
		this.layout_toRightOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutToStartOf() : T {
		if (this.layout_toStartOf == null || this.layout_toStartOf == undefined) {
			this.layout_toStartOf = new CommandAttr<string>()
		}
		
		this.layout_toStartOf.setGetter(true);
		this.orderGet++;
		this.layout_toStartOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutToStartOf() : string {
		if (this.layout_toStartOf == null || this.layout_toStartOf == undefined) {
			this.layout_toStartOf = new CommandAttr<string>();
		}
		return this.layout_toStartOf.getCommandReturnValue();
	}
	public setLayoutToStartOf(value : string) : T {
		if (this.layout_toStartOf == null || this.layout_toStartOf == undefined) {
			this.layout_toStartOf = new CommandAttr<string>();
		}
		this.layout_toStartOf.setSetter(true);
		this.layout_toStartOf.setValue(value);
		this.orderSet++;
		this.layout_toStartOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutAlignWithParentIfMissing() : T {
		if (this.layout_alignWithParentIfMissing == null || this.layout_alignWithParentIfMissing == undefined) {
			this.layout_alignWithParentIfMissing = new CommandAttr<boolean>()
		}
		
		this.layout_alignWithParentIfMissing.setGetter(true);
		this.orderGet++;
		this.layout_alignWithParentIfMissing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutAlignWithParentIfMissing() : boolean {
		if (this.layout_alignWithParentIfMissing == null || this.layout_alignWithParentIfMissing == undefined) {
			this.layout_alignWithParentIfMissing = new CommandAttr<boolean>();
		}
		return this.layout_alignWithParentIfMissing.getCommandReturnValue();
	}
	public setLayoutAlignWithParentIfMissing(value : boolean) : T {
		if (this.layout_alignWithParentIfMissing == null || this.layout_alignWithParentIfMissing == undefined) {
			this.layout_alignWithParentIfMissing = new CommandAttr<boolean>();
		}
		this.layout_alignWithParentIfMissing.setSetter(true);
		this.layout_alignWithParentIfMissing.setValue(value);
		this.orderSet++;
		this.layout_alignWithParentIfMissing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public setLayoutRemoveRule(...value : RemoveRule[]) : T {
		if (this.layout_removeRule == null || this.layout_removeRule == undefined) {
			this.layout_removeRule = new CommandAttr<RemoveRule[]>();
		}
		this.layout_removeRule.setSetter(true);
		this.layout_removeRule.setValue(value);
		this.orderSet++;
		this.layout_removeRule.setOrderSet(this.orderSet);
this.layout_removeRule.setTransformer('removeRule');		return this.thisPointer;
	}
	public setLayoutRemoveAllRules(value : boolean) : T {
		if (this.layout_removeAllRules == null || this.layout_removeAllRules == undefined) {
			this.layout_removeAllRules = new CommandAttr<boolean>();
		}
		this.layout_removeAllRules.setSetter(true);
		this.layout_removeAllRules.setValue(value);
		this.orderSet++;
		this.layout_removeAllRules.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
}

export class Root_LayoutParams extends RootImpl_LayoutParams<Root_LayoutParams> implements ILayoutParam {
    getThisPointer(): Root_LayoutParams {
        return this;
    }

   	constructor() {
		super();	
	}
}

export class Root extends RootImpl<Root> implements IWidget{
    getThisPointer(): Root {
        return this;
    }
    
   	public getClass() {
		return Root;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

RootImpl.initialize();

//end - staticinit
