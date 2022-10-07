// start - imports

	
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







export class CircularFlowImpl_addViewToCircularFlow {
@Expose({ name: "viewId" })
viewId!:string;
@Expose({ name: "radius" })
radius!:number;
@Expose({ name: "angle" })
angle!:number;
}
export class CircularFlowImpl_updateReference {
@Expose({ name: "viewId" })
viewId!:string;
@Expose({ name: "radius" })
radius!:number;
@Expose({ name: "angle" })
angle!:number;
}
export class CircularFlowImpl_updateRadius {
@Expose({ name: "viewId" })
viewId!:string;
@Expose({ name: "radius" })
radius!:number;
}
export class CircularFlowImpl_updateAngle {
@Expose({ name: "viewId" })
viewId!:string;
@Expose({ name: "angle" })
angle!:number;
}


// end - imports
import {ViewImpl} from './ViewImpl';
export abstract class CircularFlowImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "circularflow_radiusInDP" })
	circularflow_radiusInDP!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "circularflow_angles" })
	circularflow_angles!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "circularflow_viewCenter" })
	circularflow_viewCenter!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "circularflow_defaultRadius" })
	circularflow_defaultRadius!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "circularflow_defaultAngle" })
	circularflow_defaultAngle!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "constraint_referenced_ids" })
	constraint_referenced_ids!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "addViewToCircularFlow" })
	addViewToCircularFlow_!:CommandAttr<CircularFlowImpl_addViewToCircularFlow>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "updateReference" })
	updateReference_!:CommandAttr<CircularFlowImpl_updateReference>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "updateRadius" })
	updateRadius_!:CommandAttr<CircularFlowImpl_updateRadius>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "updateAngle" })
	updateAngle_!:CommandAttr<CircularFlowImpl_updateAngle>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.circularflow_radiusInDP = undefined;
		this.circularflow_angles = undefined;
		this.circularflow_viewCenter = undefined;
		this.circularflow_defaultRadius = undefined;
		this.circularflow_defaultAngle = undefined;
		this.constraint_referenced_ids = undefined;
		this.addViewToCircularFlow_ = undefined;
		this.updateReference_ = undefined;
		this.updateRadius_ = undefined;
		this.updateAngle_ = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setCircularflow_radiusInDP(value : string) : T {
		this.resetIfRequired();
		if (this.circularflow_radiusInDP == null || this.circularflow_radiusInDP == undefined) {
			this.circularflow_radiusInDP = new CommandAttr<string>();
		}
		
		this.circularflow_radiusInDP.setSetter(true);
		this.circularflow_radiusInDP.setValue(value);
		this.orderSet++;
		this.circularflow_radiusInDP.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setCircularflow_angles(value : string) : T {
		this.resetIfRequired();
		if (this.circularflow_angles == null || this.circularflow_angles == undefined) {
			this.circularflow_angles = new CommandAttr<string>();
		}
		
		this.circularflow_angles.setSetter(true);
		this.circularflow_angles.setValue(value);
		this.orderSet++;
		this.circularflow_angles.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setCircularflow_viewCenter(value : string) : T {
		this.resetIfRequired();
		if (this.circularflow_viewCenter == null || this.circularflow_viewCenter == undefined) {
			this.circularflow_viewCenter = new CommandAttr<string>();
		}
		
		this.circularflow_viewCenter.setSetter(true);
		this.circularflow_viewCenter.setValue(value);
		this.orderSet++;
		this.circularflow_viewCenter.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setCircularflow_defaultRadius(value : string) : T {
		this.resetIfRequired();
		if (this.circularflow_defaultRadius == null || this.circularflow_defaultRadius == undefined) {
			this.circularflow_defaultRadius = new CommandAttr<string>();
		}
		
		this.circularflow_defaultRadius.setSetter(true);
		this.circularflow_defaultRadius.setValue(value);
		this.orderSet++;
		this.circularflow_defaultRadius.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setCircularflow_defaultAngle(value : number) : T {
		this.resetIfRequired();
		if (this.circularflow_defaultAngle == null || this.circularflow_defaultAngle == undefined) {
			this.circularflow_defaultAngle = new CommandAttr<number>();
		}
		
		this.circularflow_defaultAngle.setSetter(true);
		this.circularflow_defaultAngle.setValue(value);
		this.orderSet++;
		this.circularflow_defaultAngle.setOrderSet(this.orderSet);
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
		

	public addViewToCircularFlow(viewId : string,
radius : number,
angle : number) : T {
		this.resetIfRequired();
		if (this.addViewToCircularFlow_ == null || this.addViewToCircularFlow_ == undefined) {
			this.addViewToCircularFlow_ = new CommandAttr<CircularFlowImpl_addViewToCircularFlow>();
		}
		
		let wrapper:CircularFlowImpl_addViewToCircularFlow = new CircularFlowImpl_addViewToCircularFlow();
		wrapper.viewId = viewId;
		wrapper.radius = radius;
		wrapper.angle = angle;
		this.addViewToCircularFlow_.setSetter(true);
		this.addViewToCircularFlow_.setValue(wrapper);	
		this.orderSet++;
		this.addViewToCircularFlow_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public updateReference(viewId : string,
radius : number,
angle : number) : T {
		this.resetIfRequired();
		if (this.updateReference_ == null || this.updateReference_ == undefined) {
			this.updateReference_ = new CommandAttr<CircularFlowImpl_updateReference>();
		}
		
		let wrapper:CircularFlowImpl_updateReference = new CircularFlowImpl_updateReference();
		wrapper.viewId = viewId;
		wrapper.radius = radius;
		wrapper.angle = angle;
		this.updateReference_.setSetter(true);
		this.updateReference_.setValue(wrapper);	
		this.orderSet++;
		this.updateReference_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public updateRadius(viewId : string,
radius : number) : T {
		this.resetIfRequired();
		if (this.updateRadius_ == null || this.updateRadius_ == undefined) {
			this.updateRadius_ = new CommandAttr<CircularFlowImpl_updateRadius>();
		}
		
		let wrapper:CircularFlowImpl_updateRadius = new CircularFlowImpl_updateRadius();
		wrapper.viewId = viewId;
		wrapper.radius = radius;
		this.updateRadius_.setSetter(true);
		this.updateRadius_.setValue(wrapper);	
		this.orderSet++;
		this.updateRadius_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public updateAngle(viewId : string,
angle : number) : T {
		this.resetIfRequired();
		if (this.updateAngle_ == null || this.updateAngle_ == undefined) {
			this.updateAngle_ = new CommandAttr<CircularFlowImpl_updateAngle>();
		}
		
		let wrapper:CircularFlowImpl_updateAngle = new CircularFlowImpl_updateAngle();
		wrapper.viewId = viewId;
		wrapper.angle = angle;
		this.updateAngle_.setSetter(true);
		this.updateAngle_.setValue(wrapper);	
		this.orderSet++;
		this.updateAngle_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class CircularFlow extends CircularFlowImpl<CircularFlow> implements IWidget{
    getThisPointer(): CircularFlow {
        return this;
    }
    
   	public getClass() {
		return CircularFlow;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

CircularFlowImpl.initialize();

//end - staticinit
