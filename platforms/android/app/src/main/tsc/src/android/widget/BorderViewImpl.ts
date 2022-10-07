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

































// end - imports
import {ViewImpl} from './ViewImpl'; 
export abstract class BorderViewImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "borderWidth" })
	borderWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderColor" })
	borderColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderStyle" })
	borderStyle!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderDashWidth" })
	borderDashWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderDashSpacing" })
	borderDashSpacing!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderRadius" })
	borderRadius!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderTopWidth" })
	borderTopWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderTopColor" })
	borderTopColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderTopStyle" })
	borderTopStyle!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderTopDashWidth" })
	borderTopDashWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderTopDashSpacing" })
	borderTopDashSpacing!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderTopLeftRadius" })
	borderTopLeftRadius!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderTopRightRadius" })
	borderTopRightRadius!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderBottomWidth" })
	borderBottomWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderBottomColor" })
	borderBottomColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderBottomStyle" })
	borderBottomStyle!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderBottomDashWidth" })
	borderBottomDashWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderBottomDashSpacing" })
	borderBottomDashSpacing!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderBottomLeftRadius" })
	borderBottomLeftRadius!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderBottomRightRadius" })
	borderBottomRightRadius!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderLeftWidth" })
	borderLeftWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderLeftColor" })
	borderLeftColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderLeftStyle" })
	borderLeftStyle!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderLeftDashWidth" })
	borderLeftDashWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderLeftDashSpacing" })
	borderLeftDashSpacing!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderRightWidth" })
	borderRightWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderRightColor" })
	borderRightColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderRightStyle" })
	borderRightStyle!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderRightDashWidth" })
	borderRightDashWidth!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "borderRightDashSpacing" })
	borderRightDashSpacing!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.borderWidth = undefined;
		this.borderColor = undefined;
		this.borderStyle = undefined;
		this.borderDashWidth = undefined;
		this.borderDashSpacing = undefined;
		this.borderRadius = undefined;
		this.borderTopWidth = undefined;
		this.borderTopColor = undefined;
		this.borderTopStyle = undefined;
		this.borderTopDashWidth = undefined;
		this.borderTopDashSpacing = undefined;
		this.borderTopLeftRadius = undefined;
		this.borderTopRightRadius = undefined;
		this.borderBottomWidth = undefined;
		this.borderBottomColor = undefined;
		this.borderBottomStyle = undefined;
		this.borderBottomDashWidth = undefined;
		this.borderBottomDashSpacing = undefined;
		this.borderBottomLeftRadius = undefined;
		this.borderBottomRightRadius = undefined;
		this.borderLeftWidth = undefined;
		this.borderLeftColor = undefined;
		this.borderLeftStyle = undefined;
		this.borderLeftDashWidth = undefined;
		this.borderLeftDashSpacing = undefined;
		this.borderRightWidth = undefined;
		this.borderRightColor = undefined;
		this.borderRightStyle = undefined;
		this.borderRightDashWidth = undefined;
		this.borderRightDashSpacing = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setBorderWidth(value : string) : T {
		this.resetIfRequired();
		if (this.borderWidth == null || this.borderWidth == undefined) {
			this.borderWidth = new CommandAttr<string>();
		}
		
		this.borderWidth.setSetter(true);
		this.borderWidth.setValue(value);
		this.orderSet++;
		this.borderWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBorderColor(value : string) : T {
		this.resetIfRequired();
		if (this.borderColor == null || this.borderColor == undefined) {
			this.borderColor = new CommandAttr<string>();
		}
		
		this.borderColor.setSetter(true);
		this.borderColor.setValue(value);
		this.orderSet++;
		this.borderColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBorderStyle(value : string) : T {
		this.resetIfRequired();
		if (this.borderStyle == null || this.borderStyle == undefined) {
			this.borderStyle = new CommandAttr<string>();
		}
		
		this.borderStyle.setSetter(true);
		this.borderStyle.setValue(value);
		this.orderSet++;
		this.borderStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBorderDashWidth(value : string) : T {
		this.resetIfRequired();
		if (this.borderDashWidth == null || this.borderDashWidth == undefined) {
			this.borderDashWidth = new CommandAttr<string>();
		}
		
		this.borderDashWidth.setSetter(true);
		this.borderDashWidth.setValue(value);
		this.orderSet++;
		this.borderDashWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBorderDashSpacing(value : string) : T {
		this.resetIfRequired();
		if (this.borderDashSpacing == null || this.borderDashSpacing == undefined) {
			this.borderDashSpacing = new CommandAttr<string>();
		}
		
		this.borderDashSpacing.setSetter(true);
		this.borderDashSpacing.setValue(value);
		this.orderSet++;
		this.borderDashSpacing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setBorderRadius(value : string) : T {
		this.resetIfRequired();
		if (this.borderRadius == null || this.borderRadius == undefined) {
			this.borderRadius = new CommandAttr<string>();
		}
		
		this.borderRadius.setSetter(true);
		this.borderRadius.setValue(value);
		this.orderSet++;
		this.borderRadius.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderTopWidth() : T {
		this.resetIfRequired();
		if (this.borderTopWidth == null || this.borderTopWidth == undefined) {
			this.borderTopWidth = new CommandAttr<string>()
		}
		
		this.borderTopWidth.setGetter(true);
		this.orderGet++;
		this.borderTopWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderTopWidth() : string {
		if (this.borderTopWidth == null || this.borderTopWidth == undefined) {
			this.borderTopWidth = new CommandAttr<string>();
		}
		return this.borderTopWidth.getCommandReturnValue();
	}
	public setBorderTopWidth(value : string) : T {
		this.resetIfRequired();
		if (this.borderTopWidth == null || this.borderTopWidth == undefined) {
			this.borderTopWidth = new CommandAttr<string>();
		}
		
		this.borderTopWidth.setSetter(true);
		this.borderTopWidth.setValue(value);
		this.orderSet++;
		this.borderTopWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderTopColor() : T {
		this.resetIfRequired();
		if (this.borderTopColor == null || this.borderTopColor == undefined) {
			this.borderTopColor = new CommandAttr<string>()
		}
		
		this.borderTopColor.setGetter(true);
		this.orderGet++;
		this.borderTopColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderTopColor() : string {
		if (this.borderTopColor == null || this.borderTopColor == undefined) {
			this.borderTopColor = new CommandAttr<string>();
		}
		return this.borderTopColor.getCommandReturnValue();
	}
	public setBorderTopColor(value : string) : T {
		this.resetIfRequired();
		if (this.borderTopColor == null || this.borderTopColor == undefined) {
			this.borderTopColor = new CommandAttr<string>();
		}
		
		this.borderTopColor.setSetter(true);
		this.borderTopColor.setValue(value);
		this.orderSet++;
		this.borderTopColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderTopStyle() : T {
		this.resetIfRequired();
		if (this.borderTopStyle == null || this.borderTopStyle == undefined) {
			this.borderTopStyle = new CommandAttr<string>()
		}
		
		this.borderTopStyle.setGetter(true);
		this.orderGet++;
		this.borderTopStyle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderTopStyle() : string {
		if (this.borderTopStyle == null || this.borderTopStyle == undefined) {
			this.borderTopStyle = new CommandAttr<string>();
		}
		return this.borderTopStyle.getCommandReturnValue();
	}
	public setBorderTopStyle(value : string) : T {
		this.resetIfRequired();
		if (this.borderTopStyle == null || this.borderTopStyle == undefined) {
			this.borderTopStyle = new CommandAttr<string>();
		}
		
		this.borderTopStyle.setSetter(true);
		this.borderTopStyle.setValue(value);
		this.orderSet++;
		this.borderTopStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderTopDashWidth() : T {
		this.resetIfRequired();
		if (this.borderTopDashWidth == null || this.borderTopDashWidth == undefined) {
			this.borderTopDashWidth = new CommandAttr<string>()
		}
		
		this.borderTopDashWidth.setGetter(true);
		this.orderGet++;
		this.borderTopDashWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderTopDashWidth() : string {
		if (this.borderTopDashWidth == null || this.borderTopDashWidth == undefined) {
			this.borderTopDashWidth = new CommandAttr<string>();
		}
		return this.borderTopDashWidth.getCommandReturnValue();
	}
	public setBorderTopDashWidth(value : string) : T {
		this.resetIfRequired();
		if (this.borderTopDashWidth == null || this.borderTopDashWidth == undefined) {
			this.borderTopDashWidth = new CommandAttr<string>();
		}
		
		this.borderTopDashWidth.setSetter(true);
		this.borderTopDashWidth.setValue(value);
		this.orderSet++;
		this.borderTopDashWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderTopDashSpacing() : T {
		this.resetIfRequired();
		if (this.borderTopDashSpacing == null || this.borderTopDashSpacing == undefined) {
			this.borderTopDashSpacing = new CommandAttr<string>()
		}
		
		this.borderTopDashSpacing.setGetter(true);
		this.orderGet++;
		this.borderTopDashSpacing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderTopDashSpacing() : string {
		if (this.borderTopDashSpacing == null || this.borderTopDashSpacing == undefined) {
			this.borderTopDashSpacing = new CommandAttr<string>();
		}
		return this.borderTopDashSpacing.getCommandReturnValue();
	}
	public setBorderTopDashSpacing(value : string) : T {
		this.resetIfRequired();
		if (this.borderTopDashSpacing == null || this.borderTopDashSpacing == undefined) {
			this.borderTopDashSpacing = new CommandAttr<string>();
		}
		
		this.borderTopDashSpacing.setSetter(true);
		this.borderTopDashSpacing.setValue(value);
		this.orderSet++;
		this.borderTopDashSpacing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderTopLeftRadius() : T {
		this.resetIfRequired();
		if (this.borderTopLeftRadius == null || this.borderTopLeftRadius == undefined) {
			this.borderTopLeftRadius = new CommandAttr<string>()
		}
		
		this.borderTopLeftRadius.setGetter(true);
		this.orderGet++;
		this.borderTopLeftRadius.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderTopLeftRadius() : string {
		if (this.borderTopLeftRadius == null || this.borderTopLeftRadius == undefined) {
			this.borderTopLeftRadius = new CommandAttr<string>();
		}
		return this.borderTopLeftRadius.getCommandReturnValue();
	}
	public setBorderTopLeftRadius(value : string) : T {
		this.resetIfRequired();
		if (this.borderTopLeftRadius == null || this.borderTopLeftRadius == undefined) {
			this.borderTopLeftRadius = new CommandAttr<string>();
		}
		
		this.borderTopLeftRadius.setSetter(true);
		this.borderTopLeftRadius.setValue(value);
		this.orderSet++;
		this.borderTopLeftRadius.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderTopRightRadius() : T {
		this.resetIfRequired();
		if (this.borderTopRightRadius == null || this.borderTopRightRadius == undefined) {
			this.borderTopRightRadius = new CommandAttr<string>()
		}
		
		this.borderTopRightRadius.setGetter(true);
		this.orderGet++;
		this.borderTopRightRadius.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderTopRightRadius() : string {
		if (this.borderTopRightRadius == null || this.borderTopRightRadius == undefined) {
			this.borderTopRightRadius = new CommandAttr<string>();
		}
		return this.borderTopRightRadius.getCommandReturnValue();
	}
	public setBorderTopRightRadius(value : string) : T {
		this.resetIfRequired();
		if (this.borderTopRightRadius == null || this.borderTopRightRadius == undefined) {
			this.borderTopRightRadius = new CommandAttr<string>();
		}
		
		this.borderTopRightRadius.setSetter(true);
		this.borderTopRightRadius.setValue(value);
		this.orderSet++;
		this.borderTopRightRadius.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderBottomWidth() : T {
		this.resetIfRequired();
		if (this.borderBottomWidth == null || this.borderBottomWidth == undefined) {
			this.borderBottomWidth = new CommandAttr<string>()
		}
		
		this.borderBottomWidth.setGetter(true);
		this.orderGet++;
		this.borderBottomWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderBottomWidth() : string {
		if (this.borderBottomWidth == null || this.borderBottomWidth == undefined) {
			this.borderBottomWidth = new CommandAttr<string>();
		}
		return this.borderBottomWidth.getCommandReturnValue();
	}
	public setBorderBottomWidth(value : string) : T {
		this.resetIfRequired();
		if (this.borderBottomWidth == null || this.borderBottomWidth == undefined) {
			this.borderBottomWidth = new CommandAttr<string>();
		}
		
		this.borderBottomWidth.setSetter(true);
		this.borderBottomWidth.setValue(value);
		this.orderSet++;
		this.borderBottomWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderBottomColor() : T {
		this.resetIfRequired();
		if (this.borderBottomColor == null || this.borderBottomColor == undefined) {
			this.borderBottomColor = new CommandAttr<string>()
		}
		
		this.borderBottomColor.setGetter(true);
		this.orderGet++;
		this.borderBottomColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderBottomColor() : string {
		if (this.borderBottomColor == null || this.borderBottomColor == undefined) {
			this.borderBottomColor = new CommandAttr<string>();
		}
		return this.borderBottomColor.getCommandReturnValue();
	}
	public setBorderBottomColor(value : string) : T {
		this.resetIfRequired();
		if (this.borderBottomColor == null || this.borderBottomColor == undefined) {
			this.borderBottomColor = new CommandAttr<string>();
		}
		
		this.borderBottomColor.setSetter(true);
		this.borderBottomColor.setValue(value);
		this.orderSet++;
		this.borderBottomColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderBottomStyle() : T {
		this.resetIfRequired();
		if (this.borderBottomStyle == null || this.borderBottomStyle == undefined) {
			this.borderBottomStyle = new CommandAttr<string>()
		}
		
		this.borderBottomStyle.setGetter(true);
		this.orderGet++;
		this.borderBottomStyle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderBottomStyle() : string {
		if (this.borderBottomStyle == null || this.borderBottomStyle == undefined) {
			this.borderBottomStyle = new CommandAttr<string>();
		}
		return this.borderBottomStyle.getCommandReturnValue();
	}
	public setBorderBottomStyle(value : string) : T {
		this.resetIfRequired();
		if (this.borderBottomStyle == null || this.borderBottomStyle == undefined) {
			this.borderBottomStyle = new CommandAttr<string>();
		}
		
		this.borderBottomStyle.setSetter(true);
		this.borderBottomStyle.setValue(value);
		this.orderSet++;
		this.borderBottomStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderBottomDashWidth() : T {
		this.resetIfRequired();
		if (this.borderBottomDashWidth == null || this.borderBottomDashWidth == undefined) {
			this.borderBottomDashWidth = new CommandAttr<string>()
		}
		
		this.borderBottomDashWidth.setGetter(true);
		this.orderGet++;
		this.borderBottomDashWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderBottomDashWidth() : string {
		if (this.borderBottomDashWidth == null || this.borderBottomDashWidth == undefined) {
			this.borderBottomDashWidth = new CommandAttr<string>();
		}
		return this.borderBottomDashWidth.getCommandReturnValue();
	}
	public setBorderBottomDashWidth(value : string) : T {
		this.resetIfRequired();
		if (this.borderBottomDashWidth == null || this.borderBottomDashWidth == undefined) {
			this.borderBottomDashWidth = new CommandAttr<string>();
		}
		
		this.borderBottomDashWidth.setSetter(true);
		this.borderBottomDashWidth.setValue(value);
		this.orderSet++;
		this.borderBottomDashWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderBottomDashSpacing() : T {
		this.resetIfRequired();
		if (this.borderBottomDashSpacing == null || this.borderBottomDashSpacing == undefined) {
			this.borderBottomDashSpacing = new CommandAttr<string>()
		}
		
		this.borderBottomDashSpacing.setGetter(true);
		this.orderGet++;
		this.borderBottomDashSpacing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderBottomDashSpacing() : string {
		if (this.borderBottomDashSpacing == null || this.borderBottomDashSpacing == undefined) {
			this.borderBottomDashSpacing = new CommandAttr<string>();
		}
		return this.borderBottomDashSpacing.getCommandReturnValue();
	}
	public setBorderBottomDashSpacing(value : string) : T {
		this.resetIfRequired();
		if (this.borderBottomDashSpacing == null || this.borderBottomDashSpacing == undefined) {
			this.borderBottomDashSpacing = new CommandAttr<string>();
		}
		
		this.borderBottomDashSpacing.setSetter(true);
		this.borderBottomDashSpacing.setValue(value);
		this.orderSet++;
		this.borderBottomDashSpacing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderBottomLeftRadius() : T {
		this.resetIfRequired();
		if (this.borderBottomLeftRadius == null || this.borderBottomLeftRadius == undefined) {
			this.borderBottomLeftRadius = new CommandAttr<string>()
		}
		
		this.borderBottomLeftRadius.setGetter(true);
		this.orderGet++;
		this.borderBottomLeftRadius.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderBottomLeftRadius() : string {
		if (this.borderBottomLeftRadius == null || this.borderBottomLeftRadius == undefined) {
			this.borderBottomLeftRadius = new CommandAttr<string>();
		}
		return this.borderBottomLeftRadius.getCommandReturnValue();
	}
	public setBorderBottomLeftRadius(value : string) : T {
		this.resetIfRequired();
		if (this.borderBottomLeftRadius == null || this.borderBottomLeftRadius == undefined) {
			this.borderBottomLeftRadius = new CommandAttr<string>();
		}
		
		this.borderBottomLeftRadius.setSetter(true);
		this.borderBottomLeftRadius.setValue(value);
		this.orderSet++;
		this.borderBottomLeftRadius.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderBottomRightRadius() : T {
		this.resetIfRequired();
		if (this.borderBottomRightRadius == null || this.borderBottomRightRadius == undefined) {
			this.borderBottomRightRadius = new CommandAttr<string>()
		}
		
		this.borderBottomRightRadius.setGetter(true);
		this.orderGet++;
		this.borderBottomRightRadius.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderBottomRightRadius() : string {
		if (this.borderBottomRightRadius == null || this.borderBottomRightRadius == undefined) {
			this.borderBottomRightRadius = new CommandAttr<string>();
		}
		return this.borderBottomRightRadius.getCommandReturnValue();
	}
	public setBorderBottomRightRadius(value : string) : T {
		this.resetIfRequired();
		if (this.borderBottomRightRadius == null || this.borderBottomRightRadius == undefined) {
			this.borderBottomRightRadius = new CommandAttr<string>();
		}
		
		this.borderBottomRightRadius.setSetter(true);
		this.borderBottomRightRadius.setValue(value);
		this.orderSet++;
		this.borderBottomRightRadius.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderLeftWidth() : T {
		this.resetIfRequired();
		if (this.borderLeftWidth == null || this.borderLeftWidth == undefined) {
			this.borderLeftWidth = new CommandAttr<string>()
		}
		
		this.borderLeftWidth.setGetter(true);
		this.orderGet++;
		this.borderLeftWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderLeftWidth() : string {
		if (this.borderLeftWidth == null || this.borderLeftWidth == undefined) {
			this.borderLeftWidth = new CommandAttr<string>();
		}
		return this.borderLeftWidth.getCommandReturnValue();
	}
	public setBorderLeftWidth(value : string) : T {
		this.resetIfRequired();
		if (this.borderLeftWidth == null || this.borderLeftWidth == undefined) {
			this.borderLeftWidth = new CommandAttr<string>();
		}
		
		this.borderLeftWidth.setSetter(true);
		this.borderLeftWidth.setValue(value);
		this.orderSet++;
		this.borderLeftWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderLeftColor() : T {
		this.resetIfRequired();
		if (this.borderLeftColor == null || this.borderLeftColor == undefined) {
			this.borderLeftColor = new CommandAttr<string>()
		}
		
		this.borderLeftColor.setGetter(true);
		this.orderGet++;
		this.borderLeftColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderLeftColor() : string {
		if (this.borderLeftColor == null || this.borderLeftColor == undefined) {
			this.borderLeftColor = new CommandAttr<string>();
		}
		return this.borderLeftColor.getCommandReturnValue();
	}
	public setBorderLeftColor(value : string) : T {
		this.resetIfRequired();
		if (this.borderLeftColor == null || this.borderLeftColor == undefined) {
			this.borderLeftColor = new CommandAttr<string>();
		}
		
		this.borderLeftColor.setSetter(true);
		this.borderLeftColor.setValue(value);
		this.orderSet++;
		this.borderLeftColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderLeftStyle() : T {
		this.resetIfRequired();
		if (this.borderLeftStyle == null || this.borderLeftStyle == undefined) {
			this.borderLeftStyle = new CommandAttr<string>()
		}
		
		this.borderLeftStyle.setGetter(true);
		this.orderGet++;
		this.borderLeftStyle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderLeftStyle() : string {
		if (this.borderLeftStyle == null || this.borderLeftStyle == undefined) {
			this.borderLeftStyle = new CommandAttr<string>();
		}
		return this.borderLeftStyle.getCommandReturnValue();
	}
	public setBorderLeftStyle(value : string) : T {
		this.resetIfRequired();
		if (this.borderLeftStyle == null || this.borderLeftStyle == undefined) {
			this.borderLeftStyle = new CommandAttr<string>();
		}
		
		this.borderLeftStyle.setSetter(true);
		this.borderLeftStyle.setValue(value);
		this.orderSet++;
		this.borderLeftStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderLeftDashWidth() : T {
		this.resetIfRequired();
		if (this.borderLeftDashWidth == null || this.borderLeftDashWidth == undefined) {
			this.borderLeftDashWidth = new CommandAttr<string>()
		}
		
		this.borderLeftDashWidth.setGetter(true);
		this.orderGet++;
		this.borderLeftDashWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderLeftDashWidth() : string {
		if (this.borderLeftDashWidth == null || this.borderLeftDashWidth == undefined) {
			this.borderLeftDashWidth = new CommandAttr<string>();
		}
		return this.borderLeftDashWidth.getCommandReturnValue();
	}
	public setBorderLeftDashWidth(value : string) : T {
		this.resetIfRequired();
		if (this.borderLeftDashWidth == null || this.borderLeftDashWidth == undefined) {
			this.borderLeftDashWidth = new CommandAttr<string>();
		}
		
		this.borderLeftDashWidth.setSetter(true);
		this.borderLeftDashWidth.setValue(value);
		this.orderSet++;
		this.borderLeftDashWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderLeftDashSpacing() : T {
		this.resetIfRequired();
		if (this.borderLeftDashSpacing == null || this.borderLeftDashSpacing == undefined) {
			this.borderLeftDashSpacing = new CommandAttr<string>()
		}
		
		this.borderLeftDashSpacing.setGetter(true);
		this.orderGet++;
		this.borderLeftDashSpacing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderLeftDashSpacing() : string {
		if (this.borderLeftDashSpacing == null || this.borderLeftDashSpacing == undefined) {
			this.borderLeftDashSpacing = new CommandAttr<string>();
		}
		return this.borderLeftDashSpacing.getCommandReturnValue();
	}
	public setBorderLeftDashSpacing(value : string) : T {
		this.resetIfRequired();
		if (this.borderLeftDashSpacing == null || this.borderLeftDashSpacing == undefined) {
			this.borderLeftDashSpacing = new CommandAttr<string>();
		}
		
		this.borderLeftDashSpacing.setSetter(true);
		this.borderLeftDashSpacing.setValue(value);
		this.orderSet++;
		this.borderLeftDashSpacing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderRightWidth() : T {
		this.resetIfRequired();
		if (this.borderRightWidth == null || this.borderRightWidth == undefined) {
			this.borderRightWidth = new CommandAttr<string>()
		}
		
		this.borderRightWidth.setGetter(true);
		this.orderGet++;
		this.borderRightWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderRightWidth() : string {
		if (this.borderRightWidth == null || this.borderRightWidth == undefined) {
			this.borderRightWidth = new CommandAttr<string>();
		}
		return this.borderRightWidth.getCommandReturnValue();
	}
	public setBorderRightWidth(value : string) : T {
		this.resetIfRequired();
		if (this.borderRightWidth == null || this.borderRightWidth == undefined) {
			this.borderRightWidth = new CommandAttr<string>();
		}
		
		this.borderRightWidth.setSetter(true);
		this.borderRightWidth.setValue(value);
		this.orderSet++;
		this.borderRightWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderRightColor() : T {
		this.resetIfRequired();
		if (this.borderRightColor == null || this.borderRightColor == undefined) {
			this.borderRightColor = new CommandAttr<string>()
		}
		
		this.borderRightColor.setGetter(true);
		this.orderGet++;
		this.borderRightColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderRightColor() : string {
		if (this.borderRightColor == null || this.borderRightColor == undefined) {
			this.borderRightColor = new CommandAttr<string>();
		}
		return this.borderRightColor.getCommandReturnValue();
	}
	public setBorderRightColor(value : string) : T {
		this.resetIfRequired();
		if (this.borderRightColor == null || this.borderRightColor == undefined) {
			this.borderRightColor = new CommandAttr<string>();
		}
		
		this.borderRightColor.setSetter(true);
		this.borderRightColor.setValue(value);
		this.orderSet++;
		this.borderRightColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderRightStyle() : T {
		this.resetIfRequired();
		if (this.borderRightStyle == null || this.borderRightStyle == undefined) {
			this.borderRightStyle = new CommandAttr<string>()
		}
		
		this.borderRightStyle.setGetter(true);
		this.orderGet++;
		this.borderRightStyle.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderRightStyle() : string {
		if (this.borderRightStyle == null || this.borderRightStyle == undefined) {
			this.borderRightStyle = new CommandAttr<string>();
		}
		return this.borderRightStyle.getCommandReturnValue();
	}
	public setBorderRightStyle(value : string) : T {
		this.resetIfRequired();
		if (this.borderRightStyle == null || this.borderRightStyle == undefined) {
			this.borderRightStyle = new CommandAttr<string>();
		}
		
		this.borderRightStyle.setSetter(true);
		this.borderRightStyle.setValue(value);
		this.orderSet++;
		this.borderRightStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderRightDashWidth() : T {
		this.resetIfRequired();
		if (this.borderRightDashWidth == null || this.borderRightDashWidth == undefined) {
			this.borderRightDashWidth = new CommandAttr<string>()
		}
		
		this.borderRightDashWidth.setGetter(true);
		this.orderGet++;
		this.borderRightDashWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderRightDashWidth() : string {
		if (this.borderRightDashWidth == null || this.borderRightDashWidth == undefined) {
			this.borderRightDashWidth = new CommandAttr<string>();
		}
		return this.borderRightDashWidth.getCommandReturnValue();
	}
	public setBorderRightDashWidth(value : string) : T {
		this.resetIfRequired();
		if (this.borderRightDashWidth == null || this.borderRightDashWidth == undefined) {
			this.borderRightDashWidth = new CommandAttr<string>();
		}
		
		this.borderRightDashWidth.setSetter(true);
		this.borderRightDashWidth.setValue(value);
		this.orderSet++;
		this.borderRightDashWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetBorderRightDashSpacing() : T {
		this.resetIfRequired();
		if (this.borderRightDashSpacing == null || this.borderRightDashSpacing == undefined) {
			this.borderRightDashSpacing = new CommandAttr<string>()
		}
		
		this.borderRightDashSpacing.setGetter(true);
		this.orderGet++;
		this.borderRightDashSpacing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getBorderRightDashSpacing() : string {
		if (this.borderRightDashSpacing == null || this.borderRightDashSpacing == undefined) {
			this.borderRightDashSpacing = new CommandAttr<string>();
		}
		return this.borderRightDashSpacing.getCommandReturnValue();
	}
	public setBorderRightDashSpacing(value : string) : T {
		this.resetIfRequired();
		if (this.borderRightDashSpacing == null || this.borderRightDashSpacing == undefined) {
			this.borderRightDashSpacing = new CommandAttr<string>();
		}
		
		this.borderRightDashSpacing.setSetter(true);
		this.borderRightDashSpacing.setValue(value);
		this.orderSet++;
		this.borderRightDashSpacing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class BorderView extends BorderViewImpl<BorderView> implements IWidget{
    getThisPointer(): BorderView {
        return this;
    }
    
   	public getClass() {
		return BorderView;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

BorderViewImpl.initialize();

//end - staticinit
