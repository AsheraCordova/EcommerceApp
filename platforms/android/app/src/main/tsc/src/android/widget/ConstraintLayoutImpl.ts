// start - imports

export const enum OptimizationLevel {
none = "none",
legacy = "legacy",
standard = "standard",
direct = "direct",
barrier = "barrier",
chains = "chains",
dimensions = "dimensions",
ratio = "ratio",
groups = "groups",
graph = "graph",
graph_wrap = "graph_wrap",
cache_measures = "cache_measures",
dependency_ordering = "dependency_ordering",
grouping = "grouping",
}
export const enum Orientation {
horizontal = "horizontal",
vertical = "vertical",
}
export const enum Layout_constraintWidth {
match_parent = "match_parent",
wrap_content = "wrap_content",
match_constraint = "match_constraint",
wrap_content_constrained = "wrap_content_constrained",
}
export const enum Layout_constraintHeight {
match_parent = "match_parent",
wrap_content = "wrap_content",
match_constraint = "match_constraint",
wrap_content_constrained = "wrap_content_constrained",
}
export const enum Layout_constraintWidth_default {
spread = "spread",
wrap = "wrap",
percent = "percent",
}
export const enum Layout_constraintHeight_default {
spread = "spread",
wrap = "wrap",
percent = "percent",
}
export const enum Layout_constraintHorizontal_chainStyle {
spread = "spread",
spread_inside = "spread_inside",
packed = "packed",
}
export const enum Layout_constraintVertical_chainStyle {
spread = "spread",
spread_inside = "spread_inside",
packed = "packed",
}
export const enum Layout_wrapBehaviorInParent {
included = "included",
horizontal_only = "horizontal_only",
vertical_only = "vertical_only",
skipped = "skipped",
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



























































import {ViewGroupImpl_LayoutParams} from './ViewGroupImpl';

// end - imports
import {ViewGroupImpl} from './ViewGroupImpl';
export abstract class ConstraintLayoutImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
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
	@Expose({ name: "optimizationLevel" })
	optimizationLevel!:CommandAttr<OptimizationLevel>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.minWidth = undefined;
		this.minHeight = undefined;
		this.maxWidth = undefined;
		this.maxHeight = undefined;
		this.optimizationLevel = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
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
		

	public tryGetOptimizationLevel() : T {
		this.resetIfRequired();
		if (this.optimizationLevel == null || this.optimizationLevel == undefined) {
			this.optimizationLevel = new CommandAttr<OptimizationLevel>()
		}
		
		this.optimizationLevel.setGetter(true);
		this.orderGet++;
		this.optimizationLevel.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getOptimizationLevel() : OptimizationLevel {
		if (this.optimizationLevel == null || this.optimizationLevel == undefined) {
			this.optimizationLevel = new CommandAttr<OptimizationLevel>();
		}
		return this.optimizationLevel.getCommandReturnValue();
	}
	public setOptimizationLevel(value : OptimizationLevel) : T {
		this.resetIfRequired();
		if (this.optimizationLevel == null || this.optimizationLevel == undefined) {
			this.optimizationLevel = new CommandAttr<OptimizationLevel>();
		}
		
		this.optimizationLevel.setSetter(true);
		this.optimizationLevel.setValue(value);
		this.orderSet++;
		this.optimizationLevel.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetLayout_optimizationLevel() : T {
		this.resetIfRequired();
		if (this.optimizationLevel == null || this.optimizationLevel == undefined) {
			this.optimizationLevel = new CommandAttr<OptimizationLevel>()
		}
		
		this.optimizationLevel.setGetter(true);
		this.orderGet++;
		this.optimizationLevel.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayout_optimizationLevel() : OptimizationLevel {
		if (this.optimizationLevel == null || this.optimizationLevel == undefined) {
			this.optimizationLevel = new CommandAttr<OptimizationLevel>();
		}
		return this.optimizationLevel.getCommandReturnValue();
	}
	public setLayout_optimizationLevel(value : OptimizationLevel) : T {
		this.resetIfRequired();
		if (this.optimizationLevel == null || this.optimizationLevel == undefined) {
			this.optimizationLevel = new CommandAttr<OptimizationLevel>();
		}
		
		this.optimizationLevel.setSetter(true);
		this.optimizationLevel.setValue(value);
		this.orderSet++;
		this.optimizationLevel.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
//start - staticinit
export abstract class ConstraintLayoutImpl_LayoutParams<T> extends ViewGroupImpl_LayoutParams<T> {
	@Type(() => CommandAttr)
	@Expose({ name: "layout_orientation" })
	layout_orientation!:CommandAttr<Orientation>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintCircle" })
	layout_constraintCircle!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintCircleRadius" })
	layout_constraintCircleRadius!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintCircleAngle" })
	layout_constraintCircleAngle!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintGuide_begin" })
	layout_constraintGuide_begin!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintGuide_end" })
	layout_constraintGuide_end!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintGuide_percent" })
	layout_constraintGuide_percent!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintLeft_toLeftOf" })
	layout_constraintLeft_toLeftOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintLeft_toRightOf" })
	layout_constraintLeft_toRightOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintRight_toLeftOf" })
	layout_constraintRight_toLeftOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintRight_toRightOf" })
	layout_constraintRight_toRightOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintTop_toTopOf" })
	layout_constraintTop_toTopOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintTop_toBottomOf" })
	layout_constraintTop_toBottomOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintBottom_toTopOf" })
	layout_constraintBottom_toTopOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintBottom_toBottomOf" })
	layout_constraintBottom_toBottomOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintBaseline_toBaselineOf" })
	layout_constraintBaseline_toBaselineOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintBaseline_toTopOf" })
	layout_constraintBaseline_toTopOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintBaseline_toBottomOf" })
	layout_constraintBaseline_toBottomOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintStart_toEndOf" })
	layout_constraintStart_toEndOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintStart_toStartOf" })
	layout_constraintStart_toStartOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintEnd_toStartOf" })
	layout_constraintEnd_toStartOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintEnd_toEndOf" })
	layout_constraintEnd_toEndOf!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_goneMarginLeft" })
	layout_goneMarginLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_goneMarginTop" })
	layout_goneMarginTop!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_goneMarginRight" })
	layout_goneMarginRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_goneMarginBottom" })
	layout_goneMarginBottom!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_goneMarginStart" })
	layout_goneMarginStart!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_goneMarginEnd" })
	layout_goneMarginEnd!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_goneMarginBaseline" })
	layout_goneMarginBaseline!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_marginBaseline" })
	layout_marginBaseline!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintWidth" })
	layout_constraintWidth!:CommandAttr<Layout_constraintWidth>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintHeight" })
	layout_constraintHeight!:CommandAttr<Layout_constraintHeight>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constrainedWidth" })
	layout_constrainedWidth!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constrainedHeight" })
	layout_constrainedHeight!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintHorizontal_bias" })
	layout_constraintHorizontal_bias!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintVertical_bias" })
	layout_constraintVertical_bias!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintWidth_default" })
	layout_constraintWidth_default!:CommandAttr<Layout_constraintWidth_default>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintHeight_default" })
	layout_constraintHeight_default!:CommandAttr<Layout_constraintHeight_default>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintWidth_min" })
	layout_constraintWidth_min!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintWidth_max" })
	layout_constraintWidth_max!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintWidth_percent" })
	layout_constraintWidth_percent!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintHeight_min" })
	layout_constraintHeight_min!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintHeight_max" })
	layout_constraintHeight_max!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintHeight_percent" })
	layout_constraintHeight_percent!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintDimensionRatio" })
	layout_constraintDimensionRatio!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintHorizontal_weight" })
	layout_constraintHorizontal_weight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintVertical_weight" })
	layout_constraintVertical_weight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintHorizontal_chainStyle" })
	layout_constraintHorizontal_chainStyle!:CommandAttr<Layout_constraintHorizontal_chainStyle>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintVertical_chainStyle" })
	layout_constraintVertical_chainStyle!:CommandAttr<Layout_constraintVertical_chainStyle>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_editor_absoluteX" })
	layout_editor_absoluteX!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_editor_absoluteY" })
	layout_editor_absoluteY!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_constraintTag" })
	layout_constraintTag!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_wrapBehaviorInParent" })
	layout_wrapBehaviorInParent!:CommandAttr<Layout_wrapBehaviorInParent>| undefined;
	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.layout_orientation = undefined;
		this.layout_constraintCircle = undefined;
		this.layout_constraintCircleRadius = undefined;
		this.layout_constraintCircleAngle = undefined;
		this.layout_constraintGuide_begin = undefined;
		this.layout_constraintGuide_end = undefined;
		this.layout_constraintGuide_percent = undefined;
		this.layout_constraintLeft_toLeftOf = undefined;
		this.layout_constraintLeft_toRightOf = undefined;
		this.layout_constraintRight_toLeftOf = undefined;
		this.layout_constraintRight_toRightOf = undefined;
		this.layout_constraintTop_toTopOf = undefined;
		this.layout_constraintTop_toBottomOf = undefined;
		this.layout_constraintBottom_toTopOf = undefined;
		this.layout_constraintBottom_toBottomOf = undefined;
		this.layout_constraintBaseline_toBaselineOf = undefined;
		this.layout_constraintBaseline_toTopOf = undefined;
		this.layout_constraintBaseline_toBottomOf = undefined;
		this.layout_constraintStart_toEndOf = undefined;
		this.layout_constraintStart_toStartOf = undefined;
		this.layout_constraintEnd_toStartOf = undefined;
		this.layout_constraintEnd_toEndOf = undefined;
		this.layout_goneMarginLeft = undefined;
		this.layout_goneMarginTop = undefined;
		this.layout_goneMarginRight = undefined;
		this.layout_goneMarginBottom = undefined;
		this.layout_goneMarginStart = undefined;
		this.layout_goneMarginEnd = undefined;
		this.layout_goneMarginBaseline = undefined;
		this.layout_marginBaseline = undefined;
		this.layout_constraintWidth = undefined;
		this.layout_constraintHeight = undefined;
		this.layout_constrainedWidth = undefined;
		this.layout_constrainedHeight = undefined;
		this.layout_constraintHorizontal_bias = undefined;
		this.layout_constraintVertical_bias = undefined;
		this.layout_constraintWidth_default = undefined;
		this.layout_constraintHeight_default = undefined;
		this.layout_constraintWidth_min = undefined;
		this.layout_constraintWidth_max = undefined;
		this.layout_constraintWidth_percent = undefined;
		this.layout_constraintHeight_min = undefined;
		this.layout_constraintHeight_max = undefined;
		this.layout_constraintHeight_percent = undefined;
		this.layout_constraintDimensionRatio = undefined;
		this.layout_constraintHorizontal_weight = undefined;
		this.layout_constraintVertical_weight = undefined;
		this.layout_constraintHorizontal_chainStyle = undefined;
		this.layout_constraintVertical_chainStyle = undefined;
		this.layout_editor_absoluteX = undefined;
		this.layout_editor_absoluteY = undefined;
		this.layout_constraintTag = undefined;
		this.layout_wrapBehaviorInParent = undefined;
		return this.thisPointer;
	}
	constructor() {
		super();
		this.thisPointer = this.getThisPointer();
	}
	
	public tryGetLayoutOrientation() : T {
		if (this.layout_orientation == null || this.layout_orientation == undefined) {
			this.layout_orientation = new CommandAttr<Orientation>()
		}
		
		this.layout_orientation.setGetter(true);
		this.orderGet++;
		this.layout_orientation.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutOrientation() : Orientation {
		if (this.layout_orientation == null || this.layout_orientation == undefined) {
			this.layout_orientation = new CommandAttr<Orientation>();
		}
		return this.layout_orientation.getCommandReturnValue();
	}
	public setLayoutOrientation(value : Orientation) : T {
		if (this.layout_orientation == null || this.layout_orientation == undefined) {
			this.layout_orientation = new CommandAttr<Orientation>();
		}
		this.layout_orientation.setSetter(true);
		this.layout_orientation.setValue(value);
		this.orderSet++;
		this.layout_orientation.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintCircle() : T {
		if (this.layout_constraintCircle == null || this.layout_constraintCircle == undefined) {
			this.layout_constraintCircle = new CommandAttr<string>()
		}
		
		this.layout_constraintCircle.setGetter(true);
		this.orderGet++;
		this.layout_constraintCircle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintCircle() : string {
		if (this.layout_constraintCircle == null || this.layout_constraintCircle == undefined) {
			this.layout_constraintCircle = new CommandAttr<string>();
		}
		return this.layout_constraintCircle.getCommandReturnValue();
	}
	public setLayoutConstraintCircle(value : string) : T {
		if (this.layout_constraintCircle == null || this.layout_constraintCircle == undefined) {
			this.layout_constraintCircle = new CommandAttr<string>();
		}
		this.layout_constraintCircle.setSetter(true);
		this.layout_constraintCircle.setValue(value);
		this.orderSet++;
		this.layout_constraintCircle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintCircleRadius() : T {
		if (this.layout_constraintCircleRadius == null || this.layout_constraintCircleRadius == undefined) {
			this.layout_constraintCircleRadius = new CommandAttr<string>()
		}
		
		this.layout_constraintCircleRadius.setGetter(true);
		this.orderGet++;
		this.layout_constraintCircleRadius.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintCircleRadius() : string {
		if (this.layout_constraintCircleRadius == null || this.layout_constraintCircleRadius == undefined) {
			this.layout_constraintCircleRadius = new CommandAttr<string>();
		}
		return this.layout_constraintCircleRadius.getCommandReturnValue();
	}
	public setLayoutConstraintCircleRadius(value : string) : T {
		if (this.layout_constraintCircleRadius == null || this.layout_constraintCircleRadius == undefined) {
			this.layout_constraintCircleRadius = new CommandAttr<string>();
		}
		this.layout_constraintCircleRadius.setSetter(true);
		this.layout_constraintCircleRadius.setValue(value);
		this.orderSet++;
		this.layout_constraintCircleRadius.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintCircleAngle() : T {
		if (this.layout_constraintCircleAngle == null || this.layout_constraintCircleAngle == undefined) {
			this.layout_constraintCircleAngle = new CommandAttr<number>()
		}
		
		this.layout_constraintCircleAngle.setGetter(true);
		this.orderGet++;
		this.layout_constraintCircleAngle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintCircleAngle() : number {
		if (this.layout_constraintCircleAngle == null || this.layout_constraintCircleAngle == undefined) {
			this.layout_constraintCircleAngle = new CommandAttr<number>();
		}
		return this.layout_constraintCircleAngle.getCommandReturnValue();
	}
	public setLayoutConstraintCircleAngle(value : number) : T {
		if (this.layout_constraintCircleAngle == null || this.layout_constraintCircleAngle == undefined) {
			this.layout_constraintCircleAngle = new CommandAttr<number>();
		}
		this.layout_constraintCircleAngle.setSetter(true);
		this.layout_constraintCircleAngle.setValue(value);
		this.orderSet++;
		this.layout_constraintCircleAngle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintGuide_begin() : T {
		if (this.layout_constraintGuide_begin == null || this.layout_constraintGuide_begin == undefined) {
			this.layout_constraintGuide_begin = new CommandAttr<string>()
		}
		
		this.layout_constraintGuide_begin.setGetter(true);
		this.orderGet++;
		this.layout_constraintGuide_begin.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintGuide_begin() : string {
		if (this.layout_constraintGuide_begin == null || this.layout_constraintGuide_begin == undefined) {
			this.layout_constraintGuide_begin = new CommandAttr<string>();
		}
		return this.layout_constraintGuide_begin.getCommandReturnValue();
	}
	public setLayoutConstraintGuide_begin(value : string) : T {
		if (this.layout_constraintGuide_begin == null || this.layout_constraintGuide_begin == undefined) {
			this.layout_constraintGuide_begin = new CommandAttr<string>();
		}
		this.layout_constraintGuide_begin.setSetter(true);
		this.layout_constraintGuide_begin.setValue(value);
		this.orderSet++;
		this.layout_constraintGuide_begin.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintGuide_end() : T {
		if (this.layout_constraintGuide_end == null || this.layout_constraintGuide_end == undefined) {
			this.layout_constraintGuide_end = new CommandAttr<string>()
		}
		
		this.layout_constraintGuide_end.setGetter(true);
		this.orderGet++;
		this.layout_constraintGuide_end.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintGuide_end() : string {
		if (this.layout_constraintGuide_end == null || this.layout_constraintGuide_end == undefined) {
			this.layout_constraintGuide_end = new CommandAttr<string>();
		}
		return this.layout_constraintGuide_end.getCommandReturnValue();
	}
	public setLayoutConstraintGuide_end(value : string) : T {
		if (this.layout_constraintGuide_end == null || this.layout_constraintGuide_end == undefined) {
			this.layout_constraintGuide_end = new CommandAttr<string>();
		}
		this.layout_constraintGuide_end.setSetter(true);
		this.layout_constraintGuide_end.setValue(value);
		this.orderSet++;
		this.layout_constraintGuide_end.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintGuide_percent() : T {
		if (this.layout_constraintGuide_percent == null || this.layout_constraintGuide_percent == undefined) {
			this.layout_constraintGuide_percent = new CommandAttr<number>()
		}
		
		this.layout_constraintGuide_percent.setGetter(true);
		this.orderGet++;
		this.layout_constraintGuide_percent.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintGuide_percent() : number {
		if (this.layout_constraintGuide_percent == null || this.layout_constraintGuide_percent == undefined) {
			this.layout_constraintGuide_percent = new CommandAttr<number>();
		}
		return this.layout_constraintGuide_percent.getCommandReturnValue();
	}
	public setLayoutConstraintGuide_percent(value : number) : T {
		if (this.layout_constraintGuide_percent == null || this.layout_constraintGuide_percent == undefined) {
			this.layout_constraintGuide_percent = new CommandAttr<number>();
		}
		this.layout_constraintGuide_percent.setSetter(true);
		this.layout_constraintGuide_percent.setValue(value);
		this.orderSet++;
		this.layout_constraintGuide_percent.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintLeft_toLeftOf() : T {
		if (this.layout_constraintLeft_toLeftOf == null || this.layout_constraintLeft_toLeftOf == undefined) {
			this.layout_constraintLeft_toLeftOf = new CommandAttr<string>()
		}
		
		this.layout_constraintLeft_toLeftOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintLeft_toLeftOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintLeft_toLeftOf() : string {
		if (this.layout_constraintLeft_toLeftOf == null || this.layout_constraintLeft_toLeftOf == undefined) {
			this.layout_constraintLeft_toLeftOf = new CommandAttr<string>();
		}
		return this.layout_constraintLeft_toLeftOf.getCommandReturnValue();
	}
	public setLayoutConstraintLeft_toLeftOf(value : string) : T {
		if (this.layout_constraintLeft_toLeftOf == null || this.layout_constraintLeft_toLeftOf == undefined) {
			this.layout_constraintLeft_toLeftOf = new CommandAttr<string>();
		}
		this.layout_constraintLeft_toLeftOf.setSetter(true);
		this.layout_constraintLeft_toLeftOf.setValue(value);
		this.orderSet++;
		this.layout_constraintLeft_toLeftOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintLeft_toRightOf() : T {
		if (this.layout_constraintLeft_toRightOf == null || this.layout_constraintLeft_toRightOf == undefined) {
			this.layout_constraintLeft_toRightOf = new CommandAttr<string>()
		}
		
		this.layout_constraintLeft_toRightOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintLeft_toRightOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintLeft_toRightOf() : string {
		if (this.layout_constraintLeft_toRightOf == null || this.layout_constraintLeft_toRightOf == undefined) {
			this.layout_constraintLeft_toRightOf = new CommandAttr<string>();
		}
		return this.layout_constraintLeft_toRightOf.getCommandReturnValue();
	}
	public setLayoutConstraintLeft_toRightOf(value : string) : T {
		if (this.layout_constraintLeft_toRightOf == null || this.layout_constraintLeft_toRightOf == undefined) {
			this.layout_constraintLeft_toRightOf = new CommandAttr<string>();
		}
		this.layout_constraintLeft_toRightOf.setSetter(true);
		this.layout_constraintLeft_toRightOf.setValue(value);
		this.orderSet++;
		this.layout_constraintLeft_toRightOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintRight_toLeftOf() : T {
		if (this.layout_constraintRight_toLeftOf == null || this.layout_constraintRight_toLeftOf == undefined) {
			this.layout_constraintRight_toLeftOf = new CommandAttr<string>()
		}
		
		this.layout_constraintRight_toLeftOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintRight_toLeftOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintRight_toLeftOf() : string {
		if (this.layout_constraintRight_toLeftOf == null || this.layout_constraintRight_toLeftOf == undefined) {
			this.layout_constraintRight_toLeftOf = new CommandAttr<string>();
		}
		return this.layout_constraintRight_toLeftOf.getCommandReturnValue();
	}
	public setLayoutConstraintRight_toLeftOf(value : string) : T {
		if (this.layout_constraintRight_toLeftOf == null || this.layout_constraintRight_toLeftOf == undefined) {
			this.layout_constraintRight_toLeftOf = new CommandAttr<string>();
		}
		this.layout_constraintRight_toLeftOf.setSetter(true);
		this.layout_constraintRight_toLeftOf.setValue(value);
		this.orderSet++;
		this.layout_constraintRight_toLeftOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintRight_toRightOf() : T {
		if (this.layout_constraintRight_toRightOf == null || this.layout_constraintRight_toRightOf == undefined) {
			this.layout_constraintRight_toRightOf = new CommandAttr<string>()
		}
		
		this.layout_constraintRight_toRightOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintRight_toRightOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintRight_toRightOf() : string {
		if (this.layout_constraintRight_toRightOf == null || this.layout_constraintRight_toRightOf == undefined) {
			this.layout_constraintRight_toRightOf = new CommandAttr<string>();
		}
		return this.layout_constraintRight_toRightOf.getCommandReturnValue();
	}
	public setLayoutConstraintRight_toRightOf(value : string) : T {
		if (this.layout_constraintRight_toRightOf == null || this.layout_constraintRight_toRightOf == undefined) {
			this.layout_constraintRight_toRightOf = new CommandAttr<string>();
		}
		this.layout_constraintRight_toRightOf.setSetter(true);
		this.layout_constraintRight_toRightOf.setValue(value);
		this.orderSet++;
		this.layout_constraintRight_toRightOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintTop_toTopOf() : T {
		if (this.layout_constraintTop_toTopOf == null || this.layout_constraintTop_toTopOf == undefined) {
			this.layout_constraintTop_toTopOf = new CommandAttr<string>()
		}
		
		this.layout_constraintTop_toTopOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintTop_toTopOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintTop_toTopOf() : string {
		if (this.layout_constraintTop_toTopOf == null || this.layout_constraintTop_toTopOf == undefined) {
			this.layout_constraintTop_toTopOf = new CommandAttr<string>();
		}
		return this.layout_constraintTop_toTopOf.getCommandReturnValue();
	}
	public setLayoutConstraintTop_toTopOf(value : string) : T {
		if (this.layout_constraintTop_toTopOf == null || this.layout_constraintTop_toTopOf == undefined) {
			this.layout_constraintTop_toTopOf = new CommandAttr<string>();
		}
		this.layout_constraintTop_toTopOf.setSetter(true);
		this.layout_constraintTop_toTopOf.setValue(value);
		this.orderSet++;
		this.layout_constraintTop_toTopOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintTop_toBottomOf() : T {
		if (this.layout_constraintTop_toBottomOf == null || this.layout_constraintTop_toBottomOf == undefined) {
			this.layout_constraintTop_toBottomOf = new CommandAttr<string>()
		}
		
		this.layout_constraintTop_toBottomOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintTop_toBottomOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintTop_toBottomOf() : string {
		if (this.layout_constraintTop_toBottomOf == null || this.layout_constraintTop_toBottomOf == undefined) {
			this.layout_constraintTop_toBottomOf = new CommandAttr<string>();
		}
		return this.layout_constraintTop_toBottomOf.getCommandReturnValue();
	}
	public setLayoutConstraintTop_toBottomOf(value : string) : T {
		if (this.layout_constraintTop_toBottomOf == null || this.layout_constraintTop_toBottomOf == undefined) {
			this.layout_constraintTop_toBottomOf = new CommandAttr<string>();
		}
		this.layout_constraintTop_toBottomOf.setSetter(true);
		this.layout_constraintTop_toBottomOf.setValue(value);
		this.orderSet++;
		this.layout_constraintTop_toBottomOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintBottom_toTopOf() : T {
		if (this.layout_constraintBottom_toTopOf == null || this.layout_constraintBottom_toTopOf == undefined) {
			this.layout_constraintBottom_toTopOf = new CommandAttr<string>()
		}
		
		this.layout_constraintBottom_toTopOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintBottom_toTopOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintBottom_toTopOf() : string {
		if (this.layout_constraintBottom_toTopOf == null || this.layout_constraintBottom_toTopOf == undefined) {
			this.layout_constraintBottom_toTopOf = new CommandAttr<string>();
		}
		return this.layout_constraintBottom_toTopOf.getCommandReturnValue();
	}
	public setLayoutConstraintBottom_toTopOf(value : string) : T {
		if (this.layout_constraintBottom_toTopOf == null || this.layout_constraintBottom_toTopOf == undefined) {
			this.layout_constraintBottom_toTopOf = new CommandAttr<string>();
		}
		this.layout_constraintBottom_toTopOf.setSetter(true);
		this.layout_constraintBottom_toTopOf.setValue(value);
		this.orderSet++;
		this.layout_constraintBottom_toTopOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintBottom_toBottomOf() : T {
		if (this.layout_constraintBottom_toBottomOf == null || this.layout_constraintBottom_toBottomOf == undefined) {
			this.layout_constraintBottom_toBottomOf = new CommandAttr<string>()
		}
		
		this.layout_constraintBottom_toBottomOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintBottom_toBottomOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintBottom_toBottomOf() : string {
		if (this.layout_constraintBottom_toBottomOf == null || this.layout_constraintBottom_toBottomOf == undefined) {
			this.layout_constraintBottom_toBottomOf = new CommandAttr<string>();
		}
		return this.layout_constraintBottom_toBottomOf.getCommandReturnValue();
	}
	public setLayoutConstraintBottom_toBottomOf(value : string) : T {
		if (this.layout_constraintBottom_toBottomOf == null || this.layout_constraintBottom_toBottomOf == undefined) {
			this.layout_constraintBottom_toBottomOf = new CommandAttr<string>();
		}
		this.layout_constraintBottom_toBottomOf.setSetter(true);
		this.layout_constraintBottom_toBottomOf.setValue(value);
		this.orderSet++;
		this.layout_constraintBottom_toBottomOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintBaseline_toBaselineOf() : T {
		if (this.layout_constraintBaseline_toBaselineOf == null || this.layout_constraintBaseline_toBaselineOf == undefined) {
			this.layout_constraintBaseline_toBaselineOf = new CommandAttr<string>()
		}
		
		this.layout_constraintBaseline_toBaselineOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintBaseline_toBaselineOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintBaseline_toBaselineOf() : string {
		if (this.layout_constraintBaseline_toBaselineOf == null || this.layout_constraintBaseline_toBaselineOf == undefined) {
			this.layout_constraintBaseline_toBaselineOf = new CommandAttr<string>();
		}
		return this.layout_constraintBaseline_toBaselineOf.getCommandReturnValue();
	}
	public setLayoutConstraintBaseline_toBaselineOf(value : string) : T {
		if (this.layout_constraintBaseline_toBaselineOf == null || this.layout_constraintBaseline_toBaselineOf == undefined) {
			this.layout_constraintBaseline_toBaselineOf = new CommandAttr<string>();
		}
		this.layout_constraintBaseline_toBaselineOf.setSetter(true);
		this.layout_constraintBaseline_toBaselineOf.setValue(value);
		this.orderSet++;
		this.layout_constraintBaseline_toBaselineOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintBaseline_toTopOf() : T {
		if (this.layout_constraintBaseline_toTopOf == null || this.layout_constraintBaseline_toTopOf == undefined) {
			this.layout_constraintBaseline_toTopOf = new CommandAttr<string>()
		}
		
		this.layout_constraintBaseline_toTopOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintBaseline_toTopOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintBaseline_toTopOf() : string {
		if (this.layout_constraintBaseline_toTopOf == null || this.layout_constraintBaseline_toTopOf == undefined) {
			this.layout_constraintBaseline_toTopOf = new CommandAttr<string>();
		}
		return this.layout_constraintBaseline_toTopOf.getCommandReturnValue();
	}
	public setLayoutConstraintBaseline_toTopOf(value : string) : T {
		if (this.layout_constraintBaseline_toTopOf == null || this.layout_constraintBaseline_toTopOf == undefined) {
			this.layout_constraintBaseline_toTopOf = new CommandAttr<string>();
		}
		this.layout_constraintBaseline_toTopOf.setSetter(true);
		this.layout_constraintBaseline_toTopOf.setValue(value);
		this.orderSet++;
		this.layout_constraintBaseline_toTopOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintBaseline_toBottomOf() : T {
		if (this.layout_constraintBaseline_toBottomOf == null || this.layout_constraintBaseline_toBottomOf == undefined) {
			this.layout_constraintBaseline_toBottomOf = new CommandAttr<string>()
		}
		
		this.layout_constraintBaseline_toBottomOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintBaseline_toBottomOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintBaseline_toBottomOf() : string {
		if (this.layout_constraintBaseline_toBottomOf == null || this.layout_constraintBaseline_toBottomOf == undefined) {
			this.layout_constraintBaseline_toBottomOf = new CommandAttr<string>();
		}
		return this.layout_constraintBaseline_toBottomOf.getCommandReturnValue();
	}
	public setLayoutConstraintBaseline_toBottomOf(value : string) : T {
		if (this.layout_constraintBaseline_toBottomOf == null || this.layout_constraintBaseline_toBottomOf == undefined) {
			this.layout_constraintBaseline_toBottomOf = new CommandAttr<string>();
		}
		this.layout_constraintBaseline_toBottomOf.setSetter(true);
		this.layout_constraintBaseline_toBottomOf.setValue(value);
		this.orderSet++;
		this.layout_constraintBaseline_toBottomOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintStart_toEndOf() : T {
		if (this.layout_constraintStart_toEndOf == null || this.layout_constraintStart_toEndOf == undefined) {
			this.layout_constraintStart_toEndOf = new CommandAttr<string>()
		}
		
		this.layout_constraintStart_toEndOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintStart_toEndOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintStart_toEndOf() : string {
		if (this.layout_constraintStart_toEndOf == null || this.layout_constraintStart_toEndOf == undefined) {
			this.layout_constraintStart_toEndOf = new CommandAttr<string>();
		}
		return this.layout_constraintStart_toEndOf.getCommandReturnValue();
	}
	public setLayoutConstraintStart_toEndOf(value : string) : T {
		if (this.layout_constraintStart_toEndOf == null || this.layout_constraintStart_toEndOf == undefined) {
			this.layout_constraintStart_toEndOf = new CommandAttr<string>();
		}
		this.layout_constraintStart_toEndOf.setSetter(true);
		this.layout_constraintStart_toEndOf.setValue(value);
		this.orderSet++;
		this.layout_constraintStart_toEndOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintStart_toStartOf() : T {
		if (this.layout_constraintStart_toStartOf == null || this.layout_constraintStart_toStartOf == undefined) {
			this.layout_constraintStart_toStartOf = new CommandAttr<string>()
		}
		
		this.layout_constraintStart_toStartOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintStart_toStartOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintStart_toStartOf() : string {
		if (this.layout_constraintStart_toStartOf == null || this.layout_constraintStart_toStartOf == undefined) {
			this.layout_constraintStart_toStartOf = new CommandAttr<string>();
		}
		return this.layout_constraintStart_toStartOf.getCommandReturnValue();
	}
	public setLayoutConstraintStart_toStartOf(value : string) : T {
		if (this.layout_constraintStart_toStartOf == null || this.layout_constraintStart_toStartOf == undefined) {
			this.layout_constraintStart_toStartOf = new CommandAttr<string>();
		}
		this.layout_constraintStart_toStartOf.setSetter(true);
		this.layout_constraintStart_toStartOf.setValue(value);
		this.orderSet++;
		this.layout_constraintStart_toStartOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintEnd_toStartOf() : T {
		if (this.layout_constraintEnd_toStartOf == null || this.layout_constraintEnd_toStartOf == undefined) {
			this.layout_constraintEnd_toStartOf = new CommandAttr<string>()
		}
		
		this.layout_constraintEnd_toStartOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintEnd_toStartOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintEnd_toStartOf() : string {
		if (this.layout_constraintEnd_toStartOf == null || this.layout_constraintEnd_toStartOf == undefined) {
			this.layout_constraintEnd_toStartOf = new CommandAttr<string>();
		}
		return this.layout_constraintEnd_toStartOf.getCommandReturnValue();
	}
	public setLayoutConstraintEnd_toStartOf(value : string) : T {
		if (this.layout_constraintEnd_toStartOf == null || this.layout_constraintEnd_toStartOf == undefined) {
			this.layout_constraintEnd_toStartOf = new CommandAttr<string>();
		}
		this.layout_constraintEnd_toStartOf.setSetter(true);
		this.layout_constraintEnd_toStartOf.setValue(value);
		this.orderSet++;
		this.layout_constraintEnd_toStartOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintEnd_toEndOf() : T {
		if (this.layout_constraintEnd_toEndOf == null || this.layout_constraintEnd_toEndOf == undefined) {
			this.layout_constraintEnd_toEndOf = new CommandAttr<string>()
		}
		
		this.layout_constraintEnd_toEndOf.setGetter(true);
		this.orderGet++;
		this.layout_constraintEnd_toEndOf.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintEnd_toEndOf() : string {
		if (this.layout_constraintEnd_toEndOf == null || this.layout_constraintEnd_toEndOf == undefined) {
			this.layout_constraintEnd_toEndOf = new CommandAttr<string>();
		}
		return this.layout_constraintEnd_toEndOf.getCommandReturnValue();
	}
	public setLayoutConstraintEnd_toEndOf(value : string) : T {
		if (this.layout_constraintEnd_toEndOf == null || this.layout_constraintEnd_toEndOf == undefined) {
			this.layout_constraintEnd_toEndOf = new CommandAttr<string>();
		}
		this.layout_constraintEnd_toEndOf.setSetter(true);
		this.layout_constraintEnd_toEndOf.setValue(value);
		this.orderSet++;
		this.layout_constraintEnd_toEndOf.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutGoneMarginLeft() : T {
		if (this.layout_goneMarginLeft == null || this.layout_goneMarginLeft == undefined) {
			this.layout_goneMarginLeft = new CommandAttr<string>()
		}
		
		this.layout_goneMarginLeft.setGetter(true);
		this.orderGet++;
		this.layout_goneMarginLeft.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutGoneMarginLeft() : string {
		if (this.layout_goneMarginLeft == null || this.layout_goneMarginLeft == undefined) {
			this.layout_goneMarginLeft = new CommandAttr<string>();
		}
		return this.layout_goneMarginLeft.getCommandReturnValue();
	}
	public setLayoutGoneMarginLeft(value : string) : T {
		if (this.layout_goneMarginLeft == null || this.layout_goneMarginLeft == undefined) {
			this.layout_goneMarginLeft = new CommandAttr<string>();
		}
		this.layout_goneMarginLeft.setSetter(true);
		this.layout_goneMarginLeft.setValue(value);
		this.orderSet++;
		this.layout_goneMarginLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutGoneMarginTop() : T {
		if (this.layout_goneMarginTop == null || this.layout_goneMarginTop == undefined) {
			this.layout_goneMarginTop = new CommandAttr<string>()
		}
		
		this.layout_goneMarginTop.setGetter(true);
		this.orderGet++;
		this.layout_goneMarginTop.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutGoneMarginTop() : string {
		if (this.layout_goneMarginTop == null || this.layout_goneMarginTop == undefined) {
			this.layout_goneMarginTop = new CommandAttr<string>();
		}
		return this.layout_goneMarginTop.getCommandReturnValue();
	}
	public setLayoutGoneMarginTop(value : string) : T {
		if (this.layout_goneMarginTop == null || this.layout_goneMarginTop == undefined) {
			this.layout_goneMarginTop = new CommandAttr<string>();
		}
		this.layout_goneMarginTop.setSetter(true);
		this.layout_goneMarginTop.setValue(value);
		this.orderSet++;
		this.layout_goneMarginTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutGoneMarginRight() : T {
		if (this.layout_goneMarginRight == null || this.layout_goneMarginRight == undefined) {
			this.layout_goneMarginRight = new CommandAttr<string>()
		}
		
		this.layout_goneMarginRight.setGetter(true);
		this.orderGet++;
		this.layout_goneMarginRight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutGoneMarginRight() : string {
		if (this.layout_goneMarginRight == null || this.layout_goneMarginRight == undefined) {
			this.layout_goneMarginRight = new CommandAttr<string>();
		}
		return this.layout_goneMarginRight.getCommandReturnValue();
	}
	public setLayoutGoneMarginRight(value : string) : T {
		if (this.layout_goneMarginRight == null || this.layout_goneMarginRight == undefined) {
			this.layout_goneMarginRight = new CommandAttr<string>();
		}
		this.layout_goneMarginRight.setSetter(true);
		this.layout_goneMarginRight.setValue(value);
		this.orderSet++;
		this.layout_goneMarginRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutGoneMarginBottom() : T {
		if (this.layout_goneMarginBottom == null || this.layout_goneMarginBottom == undefined) {
			this.layout_goneMarginBottom = new CommandAttr<string>()
		}
		
		this.layout_goneMarginBottom.setGetter(true);
		this.orderGet++;
		this.layout_goneMarginBottom.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutGoneMarginBottom() : string {
		if (this.layout_goneMarginBottom == null || this.layout_goneMarginBottom == undefined) {
			this.layout_goneMarginBottom = new CommandAttr<string>();
		}
		return this.layout_goneMarginBottom.getCommandReturnValue();
	}
	public setLayoutGoneMarginBottom(value : string) : T {
		if (this.layout_goneMarginBottom == null || this.layout_goneMarginBottom == undefined) {
			this.layout_goneMarginBottom = new CommandAttr<string>();
		}
		this.layout_goneMarginBottom.setSetter(true);
		this.layout_goneMarginBottom.setValue(value);
		this.orderSet++;
		this.layout_goneMarginBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutGoneMarginStart() : T {
		if (this.layout_goneMarginStart == null || this.layout_goneMarginStart == undefined) {
			this.layout_goneMarginStart = new CommandAttr<string>()
		}
		
		this.layout_goneMarginStart.setGetter(true);
		this.orderGet++;
		this.layout_goneMarginStart.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutGoneMarginStart() : string {
		if (this.layout_goneMarginStart == null || this.layout_goneMarginStart == undefined) {
			this.layout_goneMarginStart = new CommandAttr<string>();
		}
		return this.layout_goneMarginStart.getCommandReturnValue();
	}
	public setLayoutGoneMarginStart(value : string) : T {
		if (this.layout_goneMarginStart == null || this.layout_goneMarginStart == undefined) {
			this.layout_goneMarginStart = new CommandAttr<string>();
		}
		this.layout_goneMarginStart.setSetter(true);
		this.layout_goneMarginStart.setValue(value);
		this.orderSet++;
		this.layout_goneMarginStart.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutGoneMarginEnd() : T {
		if (this.layout_goneMarginEnd == null || this.layout_goneMarginEnd == undefined) {
			this.layout_goneMarginEnd = new CommandAttr<string>()
		}
		
		this.layout_goneMarginEnd.setGetter(true);
		this.orderGet++;
		this.layout_goneMarginEnd.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutGoneMarginEnd() : string {
		if (this.layout_goneMarginEnd == null || this.layout_goneMarginEnd == undefined) {
			this.layout_goneMarginEnd = new CommandAttr<string>();
		}
		return this.layout_goneMarginEnd.getCommandReturnValue();
	}
	public setLayoutGoneMarginEnd(value : string) : T {
		if (this.layout_goneMarginEnd == null || this.layout_goneMarginEnd == undefined) {
			this.layout_goneMarginEnd = new CommandAttr<string>();
		}
		this.layout_goneMarginEnd.setSetter(true);
		this.layout_goneMarginEnd.setValue(value);
		this.orderSet++;
		this.layout_goneMarginEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutGoneMarginBaseline() : T {
		if (this.layout_goneMarginBaseline == null || this.layout_goneMarginBaseline == undefined) {
			this.layout_goneMarginBaseline = new CommandAttr<string>()
		}
		
		this.layout_goneMarginBaseline.setGetter(true);
		this.orderGet++;
		this.layout_goneMarginBaseline.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutGoneMarginBaseline() : string {
		if (this.layout_goneMarginBaseline == null || this.layout_goneMarginBaseline == undefined) {
			this.layout_goneMarginBaseline = new CommandAttr<string>();
		}
		return this.layout_goneMarginBaseline.getCommandReturnValue();
	}
	public setLayoutGoneMarginBaseline(value : string) : T {
		if (this.layout_goneMarginBaseline == null || this.layout_goneMarginBaseline == undefined) {
			this.layout_goneMarginBaseline = new CommandAttr<string>();
		}
		this.layout_goneMarginBaseline.setSetter(true);
		this.layout_goneMarginBaseline.setValue(value);
		this.orderSet++;
		this.layout_goneMarginBaseline.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutMarginBaseline() : T {
		if (this.layout_marginBaseline == null || this.layout_marginBaseline == undefined) {
			this.layout_marginBaseline = new CommandAttr<string>()
		}
		
		this.layout_marginBaseline.setGetter(true);
		this.orderGet++;
		this.layout_marginBaseline.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutMarginBaseline() : string {
		if (this.layout_marginBaseline == null || this.layout_marginBaseline == undefined) {
			this.layout_marginBaseline = new CommandAttr<string>();
		}
		return this.layout_marginBaseline.getCommandReturnValue();
	}
	public setLayoutMarginBaseline(value : string) : T {
		if (this.layout_marginBaseline == null || this.layout_marginBaseline == undefined) {
			this.layout_marginBaseline = new CommandAttr<string>();
		}
		this.layout_marginBaseline.setSetter(true);
		this.layout_marginBaseline.setValue(value);
		this.orderSet++;
		this.layout_marginBaseline.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintWidth() : T {
		if (this.layout_constraintWidth == null || this.layout_constraintWidth == undefined) {
			this.layout_constraintWidth = new CommandAttr<Layout_constraintWidth>()
		}
		
		this.layout_constraintWidth.setGetter(true);
		this.orderGet++;
		this.layout_constraintWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintWidth() : Layout_constraintWidth {
		if (this.layout_constraintWidth == null || this.layout_constraintWidth == undefined) {
			this.layout_constraintWidth = new CommandAttr<Layout_constraintWidth>();
		}
		return this.layout_constraintWidth.getCommandReturnValue();
	}
	public setLayoutConstraintWidth(value : Layout_constraintWidth) : T {
		if (this.layout_constraintWidth == null || this.layout_constraintWidth == undefined) {
			this.layout_constraintWidth = new CommandAttr<Layout_constraintWidth>();
		}
		this.layout_constraintWidth.setSetter(true);
		this.layout_constraintWidth.setValue(value);
		this.orderSet++;
		this.layout_constraintWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintHeight() : T {
		if (this.layout_constraintHeight == null || this.layout_constraintHeight == undefined) {
			this.layout_constraintHeight = new CommandAttr<Layout_constraintHeight>()
		}
		
		this.layout_constraintHeight.setGetter(true);
		this.orderGet++;
		this.layout_constraintHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintHeight() : Layout_constraintHeight {
		if (this.layout_constraintHeight == null || this.layout_constraintHeight == undefined) {
			this.layout_constraintHeight = new CommandAttr<Layout_constraintHeight>();
		}
		return this.layout_constraintHeight.getCommandReturnValue();
	}
	public setLayoutConstraintHeight(value : Layout_constraintHeight) : T {
		if (this.layout_constraintHeight == null || this.layout_constraintHeight == undefined) {
			this.layout_constraintHeight = new CommandAttr<Layout_constraintHeight>();
		}
		this.layout_constraintHeight.setSetter(true);
		this.layout_constraintHeight.setValue(value);
		this.orderSet++;
		this.layout_constraintHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstrainedWidth() : T {
		if (this.layout_constrainedWidth == null || this.layout_constrainedWidth == undefined) {
			this.layout_constrainedWidth = new CommandAttr<boolean>()
		}
		
		this.layout_constrainedWidth.setGetter(true);
		this.orderGet++;
		this.layout_constrainedWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutConstrainedWidth() : boolean {
		if (this.layout_constrainedWidth == null || this.layout_constrainedWidth == undefined) {
			this.layout_constrainedWidth = new CommandAttr<boolean>();
		}
		return this.layout_constrainedWidth.getCommandReturnValue();
	}
	public setLayoutConstrainedWidth(value : boolean) : T {
		if (this.layout_constrainedWidth == null || this.layout_constrainedWidth == undefined) {
			this.layout_constrainedWidth = new CommandAttr<boolean>();
		}
		this.layout_constrainedWidth.setSetter(true);
		this.layout_constrainedWidth.setValue(value);
		this.orderSet++;
		this.layout_constrainedWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstrainedHeight() : T {
		if (this.layout_constrainedHeight == null || this.layout_constrainedHeight == undefined) {
			this.layout_constrainedHeight = new CommandAttr<boolean>()
		}
		
		this.layout_constrainedHeight.setGetter(true);
		this.orderGet++;
		this.layout_constrainedHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isLayoutConstrainedHeight() : boolean {
		if (this.layout_constrainedHeight == null || this.layout_constrainedHeight == undefined) {
			this.layout_constrainedHeight = new CommandAttr<boolean>();
		}
		return this.layout_constrainedHeight.getCommandReturnValue();
	}
	public setLayoutConstrainedHeight(value : boolean) : T {
		if (this.layout_constrainedHeight == null || this.layout_constrainedHeight == undefined) {
			this.layout_constrainedHeight = new CommandAttr<boolean>();
		}
		this.layout_constrainedHeight.setSetter(true);
		this.layout_constrainedHeight.setValue(value);
		this.orderSet++;
		this.layout_constrainedHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintHorizontal_bias() : T {
		if (this.layout_constraintHorizontal_bias == null || this.layout_constraintHorizontal_bias == undefined) {
			this.layout_constraintHorizontal_bias = new CommandAttr<number>()
		}
		
		this.layout_constraintHorizontal_bias.setGetter(true);
		this.orderGet++;
		this.layout_constraintHorizontal_bias.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintHorizontal_bias() : number {
		if (this.layout_constraintHorizontal_bias == null || this.layout_constraintHorizontal_bias == undefined) {
			this.layout_constraintHorizontal_bias = new CommandAttr<number>();
		}
		return this.layout_constraintHorizontal_bias.getCommandReturnValue();
	}
	public setLayoutConstraintHorizontal_bias(value : number) : T {
		if (this.layout_constraintHorizontal_bias == null || this.layout_constraintHorizontal_bias == undefined) {
			this.layout_constraintHorizontal_bias = new CommandAttr<number>();
		}
		this.layout_constraintHorizontal_bias.setSetter(true);
		this.layout_constraintHorizontal_bias.setValue(value);
		this.orderSet++;
		this.layout_constraintHorizontal_bias.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintVertical_bias() : T {
		if (this.layout_constraintVertical_bias == null || this.layout_constraintVertical_bias == undefined) {
			this.layout_constraintVertical_bias = new CommandAttr<number>()
		}
		
		this.layout_constraintVertical_bias.setGetter(true);
		this.orderGet++;
		this.layout_constraintVertical_bias.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintVertical_bias() : number {
		if (this.layout_constraintVertical_bias == null || this.layout_constraintVertical_bias == undefined) {
			this.layout_constraintVertical_bias = new CommandAttr<number>();
		}
		return this.layout_constraintVertical_bias.getCommandReturnValue();
	}
	public setLayoutConstraintVertical_bias(value : number) : T {
		if (this.layout_constraintVertical_bias == null || this.layout_constraintVertical_bias == undefined) {
			this.layout_constraintVertical_bias = new CommandAttr<number>();
		}
		this.layout_constraintVertical_bias.setSetter(true);
		this.layout_constraintVertical_bias.setValue(value);
		this.orderSet++;
		this.layout_constraintVertical_bias.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintWidth_default() : T {
		if (this.layout_constraintWidth_default == null || this.layout_constraintWidth_default == undefined) {
			this.layout_constraintWidth_default = new CommandAttr<Layout_constraintWidth_default>()
		}
		
		this.layout_constraintWidth_default.setGetter(true);
		this.orderGet++;
		this.layout_constraintWidth_default.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintWidth_default() : Layout_constraintWidth_default {
		if (this.layout_constraintWidth_default == null || this.layout_constraintWidth_default == undefined) {
			this.layout_constraintWidth_default = new CommandAttr<Layout_constraintWidth_default>();
		}
		return this.layout_constraintWidth_default.getCommandReturnValue();
	}
	public setLayoutConstraintWidth_default(value : Layout_constraintWidth_default) : T {
		if (this.layout_constraintWidth_default == null || this.layout_constraintWidth_default == undefined) {
			this.layout_constraintWidth_default = new CommandAttr<Layout_constraintWidth_default>();
		}
		this.layout_constraintWidth_default.setSetter(true);
		this.layout_constraintWidth_default.setValue(value);
		this.orderSet++;
		this.layout_constraintWidth_default.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintHeight_default() : T {
		if (this.layout_constraintHeight_default == null || this.layout_constraintHeight_default == undefined) {
			this.layout_constraintHeight_default = new CommandAttr<Layout_constraintHeight_default>()
		}
		
		this.layout_constraintHeight_default.setGetter(true);
		this.orderGet++;
		this.layout_constraintHeight_default.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintHeight_default() : Layout_constraintHeight_default {
		if (this.layout_constraintHeight_default == null || this.layout_constraintHeight_default == undefined) {
			this.layout_constraintHeight_default = new CommandAttr<Layout_constraintHeight_default>();
		}
		return this.layout_constraintHeight_default.getCommandReturnValue();
	}
	public setLayoutConstraintHeight_default(value : Layout_constraintHeight_default) : T {
		if (this.layout_constraintHeight_default == null || this.layout_constraintHeight_default == undefined) {
			this.layout_constraintHeight_default = new CommandAttr<Layout_constraintHeight_default>();
		}
		this.layout_constraintHeight_default.setSetter(true);
		this.layout_constraintHeight_default.setValue(value);
		this.orderSet++;
		this.layout_constraintHeight_default.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintWidth_min() : T {
		if (this.layout_constraintWidth_min == null || this.layout_constraintWidth_min == undefined) {
			this.layout_constraintWidth_min = new CommandAttr<string>()
		}
		
		this.layout_constraintWidth_min.setGetter(true);
		this.orderGet++;
		this.layout_constraintWidth_min.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintWidth_min() : string {
		if (this.layout_constraintWidth_min == null || this.layout_constraintWidth_min == undefined) {
			this.layout_constraintWidth_min = new CommandAttr<string>();
		}
		return this.layout_constraintWidth_min.getCommandReturnValue();
	}
	public setLayoutConstraintWidth_min(value : string) : T {
		if (this.layout_constraintWidth_min == null || this.layout_constraintWidth_min == undefined) {
			this.layout_constraintWidth_min = new CommandAttr<string>();
		}
		this.layout_constraintWidth_min.setSetter(true);
		this.layout_constraintWidth_min.setValue(value);
		this.orderSet++;
		this.layout_constraintWidth_min.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintWidth_max() : T {
		if (this.layout_constraintWidth_max == null || this.layout_constraintWidth_max == undefined) {
			this.layout_constraintWidth_max = new CommandAttr<string>()
		}
		
		this.layout_constraintWidth_max.setGetter(true);
		this.orderGet++;
		this.layout_constraintWidth_max.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintWidth_max() : string {
		if (this.layout_constraintWidth_max == null || this.layout_constraintWidth_max == undefined) {
			this.layout_constraintWidth_max = new CommandAttr<string>();
		}
		return this.layout_constraintWidth_max.getCommandReturnValue();
	}
	public setLayoutConstraintWidth_max(value : string) : T {
		if (this.layout_constraintWidth_max == null || this.layout_constraintWidth_max == undefined) {
			this.layout_constraintWidth_max = new CommandAttr<string>();
		}
		this.layout_constraintWidth_max.setSetter(true);
		this.layout_constraintWidth_max.setValue(value);
		this.orderSet++;
		this.layout_constraintWidth_max.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintWidth_percent() : T {
		if (this.layout_constraintWidth_percent == null || this.layout_constraintWidth_percent == undefined) {
			this.layout_constraintWidth_percent = new CommandAttr<number>()
		}
		
		this.layout_constraintWidth_percent.setGetter(true);
		this.orderGet++;
		this.layout_constraintWidth_percent.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintWidth_percent() : number {
		if (this.layout_constraintWidth_percent == null || this.layout_constraintWidth_percent == undefined) {
			this.layout_constraintWidth_percent = new CommandAttr<number>();
		}
		return this.layout_constraintWidth_percent.getCommandReturnValue();
	}
	public setLayoutConstraintWidth_percent(value : number) : T {
		if (this.layout_constraintWidth_percent == null || this.layout_constraintWidth_percent == undefined) {
			this.layout_constraintWidth_percent = new CommandAttr<number>();
		}
		this.layout_constraintWidth_percent.setSetter(true);
		this.layout_constraintWidth_percent.setValue(value);
		this.orderSet++;
		this.layout_constraintWidth_percent.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintHeight_min() : T {
		if (this.layout_constraintHeight_min == null || this.layout_constraintHeight_min == undefined) {
			this.layout_constraintHeight_min = new CommandAttr<string>()
		}
		
		this.layout_constraintHeight_min.setGetter(true);
		this.orderGet++;
		this.layout_constraintHeight_min.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintHeight_min() : string {
		if (this.layout_constraintHeight_min == null || this.layout_constraintHeight_min == undefined) {
			this.layout_constraintHeight_min = new CommandAttr<string>();
		}
		return this.layout_constraintHeight_min.getCommandReturnValue();
	}
	public setLayoutConstraintHeight_min(value : string) : T {
		if (this.layout_constraintHeight_min == null || this.layout_constraintHeight_min == undefined) {
			this.layout_constraintHeight_min = new CommandAttr<string>();
		}
		this.layout_constraintHeight_min.setSetter(true);
		this.layout_constraintHeight_min.setValue(value);
		this.orderSet++;
		this.layout_constraintHeight_min.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintHeight_max() : T {
		if (this.layout_constraintHeight_max == null || this.layout_constraintHeight_max == undefined) {
			this.layout_constraintHeight_max = new CommandAttr<string>()
		}
		
		this.layout_constraintHeight_max.setGetter(true);
		this.orderGet++;
		this.layout_constraintHeight_max.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintHeight_max() : string {
		if (this.layout_constraintHeight_max == null || this.layout_constraintHeight_max == undefined) {
			this.layout_constraintHeight_max = new CommandAttr<string>();
		}
		return this.layout_constraintHeight_max.getCommandReturnValue();
	}
	public setLayoutConstraintHeight_max(value : string) : T {
		if (this.layout_constraintHeight_max == null || this.layout_constraintHeight_max == undefined) {
			this.layout_constraintHeight_max = new CommandAttr<string>();
		}
		this.layout_constraintHeight_max.setSetter(true);
		this.layout_constraintHeight_max.setValue(value);
		this.orderSet++;
		this.layout_constraintHeight_max.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintHeight_percent() : T {
		if (this.layout_constraintHeight_percent == null || this.layout_constraintHeight_percent == undefined) {
			this.layout_constraintHeight_percent = new CommandAttr<number>()
		}
		
		this.layout_constraintHeight_percent.setGetter(true);
		this.orderGet++;
		this.layout_constraintHeight_percent.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintHeight_percent() : number {
		if (this.layout_constraintHeight_percent == null || this.layout_constraintHeight_percent == undefined) {
			this.layout_constraintHeight_percent = new CommandAttr<number>();
		}
		return this.layout_constraintHeight_percent.getCommandReturnValue();
	}
	public setLayoutConstraintHeight_percent(value : number) : T {
		if (this.layout_constraintHeight_percent == null || this.layout_constraintHeight_percent == undefined) {
			this.layout_constraintHeight_percent = new CommandAttr<number>();
		}
		this.layout_constraintHeight_percent.setSetter(true);
		this.layout_constraintHeight_percent.setValue(value);
		this.orderSet++;
		this.layout_constraintHeight_percent.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintDimensionRatio() : T {
		if (this.layout_constraintDimensionRatio == null || this.layout_constraintDimensionRatio == undefined) {
			this.layout_constraintDimensionRatio = new CommandAttr<string>()
		}
		
		this.layout_constraintDimensionRatio.setGetter(true);
		this.orderGet++;
		this.layout_constraintDimensionRatio.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintDimensionRatio() : string {
		if (this.layout_constraintDimensionRatio == null || this.layout_constraintDimensionRatio == undefined) {
			this.layout_constraintDimensionRatio = new CommandAttr<string>();
		}
		return this.layout_constraintDimensionRatio.getCommandReturnValue();
	}
	public setLayoutConstraintDimensionRatio(value : string) : T {
		if (this.layout_constraintDimensionRatio == null || this.layout_constraintDimensionRatio == undefined) {
			this.layout_constraintDimensionRatio = new CommandAttr<string>();
		}
		this.layout_constraintDimensionRatio.setSetter(true);
		this.layout_constraintDimensionRatio.setValue(value);
		this.orderSet++;
		this.layout_constraintDimensionRatio.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintHorizontal_weight() : T {
		if (this.layout_constraintHorizontal_weight == null || this.layout_constraintHorizontal_weight == undefined) {
			this.layout_constraintHorizontal_weight = new CommandAttr<number>()
		}
		
		this.layout_constraintHorizontal_weight.setGetter(true);
		this.orderGet++;
		this.layout_constraintHorizontal_weight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintHorizontal_weight() : number {
		if (this.layout_constraintHorizontal_weight == null || this.layout_constraintHorizontal_weight == undefined) {
			this.layout_constraintHorizontal_weight = new CommandAttr<number>();
		}
		return this.layout_constraintHorizontal_weight.getCommandReturnValue();
	}
	public setLayoutConstraintHorizontal_weight(value : number) : T {
		if (this.layout_constraintHorizontal_weight == null || this.layout_constraintHorizontal_weight == undefined) {
			this.layout_constraintHorizontal_weight = new CommandAttr<number>();
		}
		this.layout_constraintHorizontal_weight.setSetter(true);
		this.layout_constraintHorizontal_weight.setValue(value);
		this.orderSet++;
		this.layout_constraintHorizontal_weight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintVertical_weight() : T {
		if (this.layout_constraintVertical_weight == null || this.layout_constraintVertical_weight == undefined) {
			this.layout_constraintVertical_weight = new CommandAttr<number>()
		}
		
		this.layout_constraintVertical_weight.setGetter(true);
		this.orderGet++;
		this.layout_constraintVertical_weight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintVertical_weight() : number {
		if (this.layout_constraintVertical_weight == null || this.layout_constraintVertical_weight == undefined) {
			this.layout_constraintVertical_weight = new CommandAttr<number>();
		}
		return this.layout_constraintVertical_weight.getCommandReturnValue();
	}
	public setLayoutConstraintVertical_weight(value : number) : T {
		if (this.layout_constraintVertical_weight == null || this.layout_constraintVertical_weight == undefined) {
			this.layout_constraintVertical_weight = new CommandAttr<number>();
		}
		this.layout_constraintVertical_weight.setSetter(true);
		this.layout_constraintVertical_weight.setValue(value);
		this.orderSet++;
		this.layout_constraintVertical_weight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintHorizontal_chainStyle() : T {
		if (this.layout_constraintHorizontal_chainStyle == null || this.layout_constraintHorizontal_chainStyle == undefined) {
			this.layout_constraintHorizontal_chainStyle = new CommandAttr<Layout_constraintHorizontal_chainStyle>()
		}
		
		this.layout_constraintHorizontal_chainStyle.setGetter(true);
		this.orderGet++;
		this.layout_constraintHorizontal_chainStyle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintHorizontal_chainStyle() : Layout_constraintHorizontal_chainStyle {
		if (this.layout_constraintHorizontal_chainStyle == null || this.layout_constraintHorizontal_chainStyle == undefined) {
			this.layout_constraintHorizontal_chainStyle = new CommandAttr<Layout_constraintHorizontal_chainStyle>();
		}
		return this.layout_constraintHorizontal_chainStyle.getCommandReturnValue();
	}
	public setLayoutConstraintHorizontal_chainStyle(value : Layout_constraintHorizontal_chainStyle) : T {
		if (this.layout_constraintHorizontal_chainStyle == null || this.layout_constraintHorizontal_chainStyle == undefined) {
			this.layout_constraintHorizontal_chainStyle = new CommandAttr<Layout_constraintHorizontal_chainStyle>();
		}
		this.layout_constraintHorizontal_chainStyle.setSetter(true);
		this.layout_constraintHorizontal_chainStyle.setValue(value);
		this.orderSet++;
		this.layout_constraintHorizontal_chainStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintVertical_chainStyle() : T {
		if (this.layout_constraintVertical_chainStyle == null || this.layout_constraintVertical_chainStyle == undefined) {
			this.layout_constraintVertical_chainStyle = new CommandAttr<Layout_constraintVertical_chainStyle>()
		}
		
		this.layout_constraintVertical_chainStyle.setGetter(true);
		this.orderGet++;
		this.layout_constraintVertical_chainStyle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintVertical_chainStyle() : Layout_constraintVertical_chainStyle {
		if (this.layout_constraintVertical_chainStyle == null || this.layout_constraintVertical_chainStyle == undefined) {
			this.layout_constraintVertical_chainStyle = new CommandAttr<Layout_constraintVertical_chainStyle>();
		}
		return this.layout_constraintVertical_chainStyle.getCommandReturnValue();
	}
	public setLayoutConstraintVertical_chainStyle(value : Layout_constraintVertical_chainStyle) : T {
		if (this.layout_constraintVertical_chainStyle == null || this.layout_constraintVertical_chainStyle == undefined) {
			this.layout_constraintVertical_chainStyle = new CommandAttr<Layout_constraintVertical_chainStyle>();
		}
		this.layout_constraintVertical_chainStyle.setSetter(true);
		this.layout_constraintVertical_chainStyle.setValue(value);
		this.orderSet++;
		this.layout_constraintVertical_chainStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutEditor_absoluteX() : T {
		if (this.layout_editor_absoluteX == null || this.layout_editor_absoluteX == undefined) {
			this.layout_editor_absoluteX = new CommandAttr<string>()
		}
		
		this.layout_editor_absoluteX.setGetter(true);
		this.orderGet++;
		this.layout_editor_absoluteX.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutEditor_absoluteX() : string {
		if (this.layout_editor_absoluteX == null || this.layout_editor_absoluteX == undefined) {
			this.layout_editor_absoluteX = new CommandAttr<string>();
		}
		return this.layout_editor_absoluteX.getCommandReturnValue();
	}
	public setLayoutEditor_absoluteX(value : string) : T {
		if (this.layout_editor_absoluteX == null || this.layout_editor_absoluteX == undefined) {
			this.layout_editor_absoluteX = new CommandAttr<string>();
		}
		this.layout_editor_absoluteX.setSetter(true);
		this.layout_editor_absoluteX.setValue(value);
		this.orderSet++;
		this.layout_editor_absoluteX.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutEditor_absoluteY() : T {
		if (this.layout_editor_absoluteY == null || this.layout_editor_absoluteY == undefined) {
			this.layout_editor_absoluteY = new CommandAttr<string>()
		}
		
		this.layout_editor_absoluteY.setGetter(true);
		this.orderGet++;
		this.layout_editor_absoluteY.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutEditor_absoluteY() : string {
		if (this.layout_editor_absoluteY == null || this.layout_editor_absoluteY == undefined) {
			this.layout_editor_absoluteY = new CommandAttr<string>();
		}
		return this.layout_editor_absoluteY.getCommandReturnValue();
	}
	public setLayoutEditor_absoluteY(value : string) : T {
		if (this.layout_editor_absoluteY == null || this.layout_editor_absoluteY == undefined) {
			this.layout_editor_absoluteY = new CommandAttr<string>();
		}
		this.layout_editor_absoluteY.setSetter(true);
		this.layout_editor_absoluteY.setValue(value);
		this.orderSet++;
		this.layout_editor_absoluteY.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutConstraintTag() : T {
		if (this.layout_constraintTag == null || this.layout_constraintTag == undefined) {
			this.layout_constraintTag = new CommandAttr<string>()
		}
		
		this.layout_constraintTag.setGetter(true);
		this.orderGet++;
		this.layout_constraintTag.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutConstraintTag() : string {
		if (this.layout_constraintTag == null || this.layout_constraintTag == undefined) {
			this.layout_constraintTag = new CommandAttr<string>();
		}
		return this.layout_constraintTag.getCommandReturnValue();
	}
	public setLayoutConstraintTag(value : string) : T {
		if (this.layout_constraintTag == null || this.layout_constraintTag == undefined) {
			this.layout_constraintTag = new CommandAttr<string>();
		}
		this.layout_constraintTag.setSetter(true);
		this.layout_constraintTag.setValue(value);
		this.orderSet++;
		this.layout_constraintTag.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public tryGetLayoutWrapBehaviorInParent() : T {
		if (this.layout_wrapBehaviorInParent == null || this.layout_wrapBehaviorInParent == undefined) {
			this.layout_wrapBehaviorInParent = new CommandAttr<Layout_wrapBehaviorInParent>()
		}
		
		this.layout_wrapBehaviorInParent.setGetter(true);
		this.orderGet++;
		this.layout_wrapBehaviorInParent.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getLayoutWrapBehaviorInParent() : Layout_wrapBehaviorInParent {
		if (this.layout_wrapBehaviorInParent == null || this.layout_wrapBehaviorInParent == undefined) {
			this.layout_wrapBehaviorInParent = new CommandAttr<Layout_wrapBehaviorInParent>();
		}
		return this.layout_wrapBehaviorInParent.getCommandReturnValue();
	}
	public setLayoutWrapBehaviorInParent(value : Layout_wrapBehaviorInParent) : T {
		if (this.layout_wrapBehaviorInParent == null || this.layout_wrapBehaviorInParent == undefined) {
			this.layout_wrapBehaviorInParent = new CommandAttr<Layout_wrapBehaviorInParent>();
		}
		this.layout_wrapBehaviorInParent.setSetter(true);
		this.layout_wrapBehaviorInParent.setValue(value);
		this.orderSet++;
		this.layout_wrapBehaviorInParent.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
}

export class ConstraintLayout_LayoutParams extends ConstraintLayoutImpl_LayoutParams<ConstraintLayout_LayoutParams> implements ILayoutParam {
    getThisPointer(): ConstraintLayout_LayoutParams {
        return this;
    }

   	constructor() {
		super();	
	}
}

export class ConstraintLayout extends ConstraintLayoutImpl<ConstraintLayout> implements IWidget{
    getThisPointer(): ConstraintLayout {
        return this;
    }
    
   	public getClass() {
		return ConstraintLayout;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ConstraintLayoutImpl.initialize();

//end - staticinit
