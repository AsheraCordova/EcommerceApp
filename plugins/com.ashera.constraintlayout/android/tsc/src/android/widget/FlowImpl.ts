// start - imports

export const enum Orientation {
horizontal = "horizontal",
vertical = "vertical",
}
export const enum Flow_horizontalStyle {
spread = "spread",
spread_inside = "spread_inside",
packed = "packed",
}
export const enum Flow_verticalStyle {
spread = "spread",
spread_inside = "spread_inside",
packed = "packed",
}
export const enum Flow_wrapMode {
none = "none",
chain = "chain",
aligned = "aligned",
}
export const enum Flow_verticalAlign {
top = "top",
bottom = "bottom",
center = "center",
baseline = "baseline",
}
export const enum Flow_horizontalAlign {
start = "start",
end = "end",
center = "center",
}
export const enum Flow_firstHorizontalStyle {
spread = "spread",
spread_inside = "spread_inside",
packed = "packed",
}
export const enum Flow_firstVerticalStyle {
spread = "spread",
spread_inside = "spread_inside",
packed = "packed",
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
import {ViewImpl} from './ViewImpl';
export abstract class FlowImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "orientation" })
	orientation!:CommandAttr<Orientation>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_horizontalStyle" })
	flow_horizontalStyle!:CommandAttr<Flow_horizontalStyle>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_verticalStyle" })
	flow_verticalStyle!:CommandAttr<Flow_verticalStyle>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_wrapMode" })
	flow_wrapMode!:CommandAttr<Flow_wrapMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_maxElementsWrap" })
	flow_maxElementsWrap!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_horizontalGap" })
	flow_horizontalGap!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_verticalGap" })
	flow_verticalGap!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_verticalAlign" })
	flow_verticalAlign!:CommandAttr<Flow_verticalAlign>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_horizontalAlign" })
	flow_horizontalAlign!:CommandAttr<Flow_horizontalAlign>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_verticalBias" })
	flow_verticalBias!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_horizontalBias" })
	flow_horizontalBias!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_firstHorizontalStyle" })
	flow_firstHorizontalStyle!:CommandAttr<Flow_firstHorizontalStyle>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_firstVerticalStyle" })
	flow_firstVerticalStyle!:CommandAttr<Flow_firstVerticalStyle>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_firstHorizontalBias" })
	flow_firstHorizontalBias!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "flow_firstVerticalBias" })
	flow_firstVerticalBias!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "constraint_referenced_ids" })
	constraint_referenced_ids!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.orientation = undefined;
		this.flow_horizontalStyle = undefined;
		this.flow_verticalStyle = undefined;
		this.flow_wrapMode = undefined;
		this.flow_maxElementsWrap = undefined;
		this.flow_horizontalGap = undefined;
		this.flow_verticalGap = undefined;
		this.flow_verticalAlign = undefined;
		this.flow_horizontalAlign = undefined;
		this.flow_verticalBias = undefined;
		this.flow_horizontalBias = undefined;
		this.flow_firstHorizontalStyle = undefined;
		this.flow_firstVerticalStyle = undefined;
		this.flow_firstHorizontalBias = undefined;
		this.flow_firstVerticalBias = undefined;
		this.constraint_referenced_ids = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setOrientation(value : Orientation) : T {
		this.resetIfRequired();
		if (this.orientation == null || this.orientation == undefined) {
			this.orientation = new CommandAttr<Orientation>();
		}
		
		this.orientation.setSetter(true);
		this.orientation.setValue(value);
		this.orderSet++;
		this.orientation.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_horizontalStyle(value : Flow_horizontalStyle) : T {
		this.resetIfRequired();
		if (this.flow_horizontalStyle == null || this.flow_horizontalStyle == undefined) {
			this.flow_horizontalStyle = new CommandAttr<Flow_horizontalStyle>();
		}
		
		this.flow_horizontalStyle.setSetter(true);
		this.flow_horizontalStyle.setValue(value);
		this.orderSet++;
		this.flow_horizontalStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_verticalStyle(value : Flow_verticalStyle) : T {
		this.resetIfRequired();
		if (this.flow_verticalStyle == null || this.flow_verticalStyle == undefined) {
			this.flow_verticalStyle = new CommandAttr<Flow_verticalStyle>();
		}
		
		this.flow_verticalStyle.setSetter(true);
		this.flow_verticalStyle.setValue(value);
		this.orderSet++;
		this.flow_verticalStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_wrapMode(value : Flow_wrapMode) : T {
		this.resetIfRequired();
		if (this.flow_wrapMode == null || this.flow_wrapMode == undefined) {
			this.flow_wrapMode = new CommandAttr<Flow_wrapMode>();
		}
		
		this.flow_wrapMode.setSetter(true);
		this.flow_wrapMode.setValue(value);
		this.orderSet++;
		this.flow_wrapMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_maxElementsWrap(value : number) : T {
		this.resetIfRequired();
		if (this.flow_maxElementsWrap == null || this.flow_maxElementsWrap == undefined) {
			this.flow_maxElementsWrap = new CommandAttr<number>();
		}
		
		this.flow_maxElementsWrap.setSetter(true);
		this.flow_maxElementsWrap.setValue(value);
		this.orderSet++;
		this.flow_maxElementsWrap.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_horizontalGap(value : string) : T {
		this.resetIfRequired();
		if (this.flow_horizontalGap == null || this.flow_horizontalGap == undefined) {
			this.flow_horizontalGap = new CommandAttr<string>();
		}
		
		this.flow_horizontalGap.setSetter(true);
		this.flow_horizontalGap.setValue(value);
		this.orderSet++;
		this.flow_horizontalGap.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_verticalGap(value : string) : T {
		this.resetIfRequired();
		if (this.flow_verticalGap == null || this.flow_verticalGap == undefined) {
			this.flow_verticalGap = new CommandAttr<string>();
		}
		
		this.flow_verticalGap.setSetter(true);
		this.flow_verticalGap.setValue(value);
		this.orderSet++;
		this.flow_verticalGap.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_verticalAlign(value : Flow_verticalAlign) : T {
		this.resetIfRequired();
		if (this.flow_verticalAlign == null || this.flow_verticalAlign == undefined) {
			this.flow_verticalAlign = new CommandAttr<Flow_verticalAlign>();
		}
		
		this.flow_verticalAlign.setSetter(true);
		this.flow_verticalAlign.setValue(value);
		this.orderSet++;
		this.flow_verticalAlign.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_horizontalAlign(value : Flow_horizontalAlign) : T {
		this.resetIfRequired();
		if (this.flow_horizontalAlign == null || this.flow_horizontalAlign == undefined) {
			this.flow_horizontalAlign = new CommandAttr<Flow_horizontalAlign>();
		}
		
		this.flow_horizontalAlign.setSetter(true);
		this.flow_horizontalAlign.setValue(value);
		this.orderSet++;
		this.flow_horizontalAlign.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_verticalBias(value : number) : T {
		this.resetIfRequired();
		if (this.flow_verticalBias == null || this.flow_verticalBias == undefined) {
			this.flow_verticalBias = new CommandAttr<number>();
		}
		
		this.flow_verticalBias.setSetter(true);
		this.flow_verticalBias.setValue(value);
		this.orderSet++;
		this.flow_verticalBias.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_horizontalBias(value : number) : T {
		this.resetIfRequired();
		if (this.flow_horizontalBias == null || this.flow_horizontalBias == undefined) {
			this.flow_horizontalBias = new CommandAttr<number>();
		}
		
		this.flow_horizontalBias.setSetter(true);
		this.flow_horizontalBias.setValue(value);
		this.orderSet++;
		this.flow_horizontalBias.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_firstHorizontalStyle(value : Flow_firstHorizontalStyle) : T {
		this.resetIfRequired();
		if (this.flow_firstHorizontalStyle == null || this.flow_firstHorizontalStyle == undefined) {
			this.flow_firstHorizontalStyle = new CommandAttr<Flow_firstHorizontalStyle>();
		}
		
		this.flow_firstHorizontalStyle.setSetter(true);
		this.flow_firstHorizontalStyle.setValue(value);
		this.orderSet++;
		this.flow_firstHorizontalStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_firstVerticalStyle(value : Flow_firstVerticalStyle) : T {
		this.resetIfRequired();
		if (this.flow_firstVerticalStyle == null || this.flow_firstVerticalStyle == undefined) {
			this.flow_firstVerticalStyle = new CommandAttr<Flow_firstVerticalStyle>();
		}
		
		this.flow_firstVerticalStyle.setSetter(true);
		this.flow_firstVerticalStyle.setValue(value);
		this.orderSet++;
		this.flow_firstVerticalStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_firstHorizontalBias(value : number) : T {
		this.resetIfRequired();
		if (this.flow_firstHorizontalBias == null || this.flow_firstHorizontalBias == undefined) {
			this.flow_firstHorizontalBias = new CommandAttr<number>();
		}
		
		this.flow_firstHorizontalBias.setSetter(true);
		this.flow_firstHorizontalBias.setValue(value);
		this.orderSet++;
		this.flow_firstHorizontalBias.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFlow_firstVerticalBias(value : number) : T {
		this.resetIfRequired();
		if (this.flow_firstVerticalBias == null || this.flow_firstVerticalBias == undefined) {
			this.flow_firstVerticalBias = new CommandAttr<number>();
		}
		
		this.flow_firstVerticalBias.setSetter(true);
		this.flow_firstVerticalBias.setValue(value);
		this.orderSet++;
		this.flow_firstVerticalBias.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetConstraint_referenced_ids() : T {
		this.resetIfRequired();
		if (this.constraint_referenced_ids == null || this.constraint_referenced_ids == undefined) {
			this.constraint_referenced_ids = new CommandAttr<string>()
		}
		
		this.constraint_referenced_ids.setGetter(true);
		this.orderGet++;
		this.constraint_referenced_ids.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getConstraint_referenced_ids() : string {
		if (this.constraint_referenced_ids == null || this.constraint_referenced_ids == undefined) {
			this.constraint_referenced_ids = new CommandAttr<string>();
		}
		return this.constraint_referenced_ids.getCommandReturnValue();
	}
	public setConstraint_referenced_ids(value : string) : T {
		this.resetIfRequired();
		if (this.constraint_referenced_ids == null || this.constraint_referenced_ids == undefined) {
			this.constraint_referenced_ids = new CommandAttr<string>();
		}
		
		this.constraint_referenced_ids.setSetter(true);
		this.constraint_referenced_ids.setValue(value);
		this.orderSet++;
		this.constraint_referenced_ids.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class Flow extends FlowImpl<Flow> implements IWidget{
    getThisPointer(): Flow {
        return this;
    }
    
   	public getClass() {
		return Flow;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

FlowImpl.initialize();

//end - staticinit
