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






























import {ViewGroupImpl_LayoutParams} from './ViewGroupImpl';

// end - imports
import {ViewGroupImpl} from './ViewGroupImpl';
export abstract class ToolbarImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "title" })
	title!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "subtitle" })
	subtitle!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "gravity" })
	gravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "titleMargin" })
	titleMargin!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "titleMarginStart" })
	titleMarginStart!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "titleMarginEnd" })
	titleMarginEnd!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "titleMarginTop" })
	titleMarginTop!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "titleMarginBottom" })
	titleMarginBottom!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "titleMargins" })
	titleMargins!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "contentInsetStart" })
	contentInsetStart!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "contentInsetEnd" })
	contentInsetEnd!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "contentInsetLeft" })
	contentInsetLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "contentInsetRight" })
	contentInsetRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "contentInsetStartWithNavigation" })
	contentInsetStartWithNavigation!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "contentInsetEndWithActions" })
	contentInsetEndWithActions!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "maxButtonHeight" })
	maxButtonHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "buttonGravity" })
	buttonGravity!:CommandAttr<Gravity[]>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "collapseIcon" })
	collapseIcon!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "collapseContentDescription" })
	collapseContentDescription!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "navigationIcon" })
	navigationIcon!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "navigationContentDescription" })
	navigationContentDescription!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "logo" })
	logo!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "logoDescription" })
	logoDescription!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "titleTextColor" })
	titleTextColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "subtitleTextColor" })
	subtitleTextColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "menu" })
	menu!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onNavigationIconClick" })
	onNavigationIconClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "overflowIcon" })
	overflowIcon!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onMenuItemClick" })
	onMenuItemClick!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.title = undefined;
		this.subtitle = undefined;
		this.gravity = undefined;
		this.titleMargin = undefined;
		this.titleMarginStart = undefined;
		this.titleMarginEnd = undefined;
		this.titleMarginTop = undefined;
		this.titleMarginBottom = undefined;
		this.titleMargins = undefined;
		this.contentInsetStart = undefined;
		this.contentInsetEnd = undefined;
		this.contentInsetLeft = undefined;
		this.contentInsetRight = undefined;
		this.contentInsetStartWithNavigation = undefined;
		this.contentInsetEndWithActions = undefined;
		this.maxButtonHeight = undefined;
		this.buttonGravity = undefined;
		this.collapseIcon = undefined;
		this.collapseContentDescription = undefined;
		this.navigationIcon = undefined;
		this.navigationContentDescription = undefined;
		this.logo = undefined;
		this.logoDescription = undefined;
		this.titleTextColor = undefined;
		this.subtitleTextColor = undefined;
		this.menu = undefined;
		this.onNavigationIconClick = undefined;
		this.overflowIcon = undefined;
		this.onMenuItemClick = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setTitle(value : string) : T {
		this.resetIfRequired();
		if (this.title == null || this.title == undefined) {
			this.title = new CommandAttr<string>();
		}
		
		this.title.setSetter(true);
		this.title.setValue(value);
		this.orderSet++;
		this.title.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSubtitle(value : string) : T {
		this.resetIfRequired();
		if (this.subtitle == null || this.subtitle == undefined) {
			this.subtitle = new CommandAttr<string>();
		}
		
		this.subtitle.setSetter(true);
		this.subtitle.setValue(value);
		this.orderSet++;
		this.subtitle.setOrderSet(this.orderSet);
		return this.thisPointer;
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
		

	public setTitleMargin(value : string) : T {
		this.resetIfRequired();
		if (this.titleMargin == null || this.titleMargin == undefined) {
			this.titleMargin = new CommandAttr<string>();
		}
		
		this.titleMargin.setSetter(true);
		this.titleMargin.setValue(value);
		this.orderSet++;
		this.titleMargin.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTitleMarginStart(value : string) : T {
		this.resetIfRequired();
		if (this.titleMarginStart == null || this.titleMarginStart == undefined) {
			this.titleMarginStart = new CommandAttr<string>();
		}
		
		this.titleMarginStart.setSetter(true);
		this.titleMarginStart.setValue(value);
		this.orderSet++;
		this.titleMarginStart.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTitleMarginEnd(value : string) : T {
		this.resetIfRequired();
		if (this.titleMarginEnd == null || this.titleMarginEnd == undefined) {
			this.titleMarginEnd = new CommandAttr<string>();
		}
		
		this.titleMarginEnd.setSetter(true);
		this.titleMarginEnd.setValue(value);
		this.orderSet++;
		this.titleMarginEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTitleMarginTop(value : string) : T {
		this.resetIfRequired();
		if (this.titleMarginTop == null || this.titleMarginTop == undefined) {
			this.titleMarginTop = new CommandAttr<string>();
		}
		
		this.titleMarginTop.setSetter(true);
		this.titleMarginTop.setValue(value);
		this.orderSet++;
		this.titleMarginTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTitleMarginBottom(value : string) : T {
		this.resetIfRequired();
		if (this.titleMarginBottom == null || this.titleMarginBottom == undefined) {
			this.titleMarginBottom = new CommandAttr<string>();
		}
		
		this.titleMarginBottom.setSetter(true);
		this.titleMarginBottom.setValue(value);
		this.orderSet++;
		this.titleMarginBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTitleMargins(value : string) : T {
		this.resetIfRequired();
		if (this.titleMargins == null || this.titleMargins == undefined) {
			this.titleMargins = new CommandAttr<string>();
		}
		
		this.titleMargins.setSetter(true);
		this.titleMargins.setValue(value);
		this.orderSet++;
		this.titleMargins.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setContentInsetStart(value : string) : T {
		this.resetIfRequired();
		if (this.contentInsetStart == null || this.contentInsetStart == undefined) {
			this.contentInsetStart = new CommandAttr<string>();
		}
		
		this.contentInsetStart.setSetter(true);
		this.contentInsetStart.setValue(value);
		this.orderSet++;
		this.contentInsetStart.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setContentInsetEnd(value : string) : T {
		this.resetIfRequired();
		if (this.contentInsetEnd == null || this.contentInsetEnd == undefined) {
			this.contentInsetEnd = new CommandAttr<string>();
		}
		
		this.contentInsetEnd.setSetter(true);
		this.contentInsetEnd.setValue(value);
		this.orderSet++;
		this.contentInsetEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setContentInsetLeft(value : string) : T {
		this.resetIfRequired();
		if (this.contentInsetLeft == null || this.contentInsetLeft == undefined) {
			this.contentInsetLeft = new CommandAttr<string>();
		}
		
		this.contentInsetLeft.setSetter(true);
		this.contentInsetLeft.setValue(value);
		this.orderSet++;
		this.contentInsetLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setContentInsetRight(value : string) : T {
		this.resetIfRequired();
		if (this.contentInsetRight == null || this.contentInsetRight == undefined) {
			this.contentInsetRight = new CommandAttr<string>();
		}
		
		this.contentInsetRight.setSetter(true);
		this.contentInsetRight.setValue(value);
		this.orderSet++;
		this.contentInsetRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setContentInsetStartWithNavigation(value : string) : T {
		this.resetIfRequired();
		if (this.contentInsetStartWithNavigation == null || this.contentInsetStartWithNavigation == undefined) {
			this.contentInsetStartWithNavigation = new CommandAttr<string>();
		}
		
		this.contentInsetStartWithNavigation.setSetter(true);
		this.contentInsetStartWithNavigation.setValue(value);
		this.orderSet++;
		this.contentInsetStartWithNavigation.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setContentInsetEndWithActions(value : string) : T {
		this.resetIfRequired();
		if (this.contentInsetEndWithActions == null || this.contentInsetEndWithActions == undefined) {
			this.contentInsetEndWithActions = new CommandAttr<string>();
		}
		
		this.contentInsetEndWithActions.setSetter(true);
		this.contentInsetEndWithActions.setValue(value);
		this.orderSet++;
		this.contentInsetEndWithActions.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setMaxButtonHeight(value : string) : T {
		this.resetIfRequired();
		if (this.maxButtonHeight == null || this.maxButtonHeight == undefined) {
			this.maxButtonHeight = new CommandAttr<string>();
		}
		
		this.maxButtonHeight.setSetter(true);
		this.maxButtonHeight.setValue(value);
		this.orderSet++;
		this.maxButtonHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setButtonGravity(...value : Gravity[]) : T {
		this.resetIfRequired();
		if (this.buttonGravity == null || this.buttonGravity == undefined) {
			this.buttonGravity = new CommandAttr<Gravity[]>();
		}
		
		this.buttonGravity.setSetter(true);
		this.buttonGravity.setValue(value);
		this.orderSet++;
		this.buttonGravity.setOrderSet(this.orderSet);
this.buttonGravity.setTransformer('gravity');		return this.thisPointer;
	}
		

	public setCollapseIcon(value : string) : T {
		this.resetIfRequired();
		if (this.collapseIcon == null || this.collapseIcon == undefined) {
			this.collapseIcon = new CommandAttr<string>();
		}
		
		this.collapseIcon.setSetter(true);
		this.collapseIcon.setValue(value);
		this.orderSet++;
		this.collapseIcon.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setCollapseContentDescription(value : string) : T {
		this.resetIfRequired();
		if (this.collapseContentDescription == null || this.collapseContentDescription == undefined) {
			this.collapseContentDescription = new CommandAttr<string>();
		}
		
		this.collapseContentDescription.setSetter(true);
		this.collapseContentDescription.setValue(value);
		this.orderSet++;
		this.collapseContentDescription.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setNavigationIcon(value : string) : T {
		this.resetIfRequired();
		if (this.navigationIcon == null || this.navigationIcon == undefined) {
			this.navigationIcon = new CommandAttr<string>();
		}
		
		this.navigationIcon.setSetter(true);
		this.navigationIcon.setValue(value);
		this.orderSet++;
		this.navigationIcon.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setNavigationContentDescription(value : string) : T {
		this.resetIfRequired();
		if (this.navigationContentDescription == null || this.navigationContentDescription == undefined) {
			this.navigationContentDescription = new CommandAttr<string>();
		}
		
		this.navigationContentDescription.setSetter(true);
		this.navigationContentDescription.setValue(value);
		this.orderSet++;
		this.navigationContentDescription.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setLogo(value : string) : T {
		this.resetIfRequired();
		if (this.logo == null || this.logo == undefined) {
			this.logo = new CommandAttr<string>();
		}
		
		this.logo.setSetter(true);
		this.logo.setValue(value);
		this.orderSet++;
		this.logo.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setLogoDescription(value : string) : T {
		this.resetIfRequired();
		if (this.logoDescription == null || this.logoDescription == undefined) {
			this.logoDescription = new CommandAttr<string>();
		}
		
		this.logoDescription.setSetter(true);
		this.logoDescription.setValue(value);
		this.orderSet++;
		this.logoDescription.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTitleTextColor(value : string) : T {
		this.resetIfRequired();
		if (this.titleTextColor == null || this.titleTextColor == undefined) {
			this.titleTextColor = new CommandAttr<string>();
		}
		
		this.titleTextColor.setSetter(true);
		this.titleTextColor.setValue(value);
		this.orderSet++;
		this.titleTextColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSubtitleTextColor(value : string) : T {
		this.resetIfRequired();
		if (this.subtitleTextColor == null || this.subtitleTextColor == undefined) {
			this.subtitleTextColor = new CommandAttr<string>();
		}
		
		this.subtitleTextColor.setSetter(true);
		this.subtitleTextColor.setValue(value);
		this.orderSet++;
		this.subtitleTextColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setMenu(value : string) : T {
		this.resetIfRequired();
		if (this.menu == null || this.menu == undefined) {
			this.menu = new CommandAttr<string>();
		}
		
		this.menu.setSetter(true);
		this.menu.setValue(value);
		this.orderSet++;
		this.menu.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnNavigationIconClick(value : string) : T {
		this.resetIfRequired();
		if (this.onNavigationIconClick == null || this.onNavigationIconClick == undefined) {
			this.onNavigationIconClick = new CommandAttr<string>();
		}
		
		this.onNavigationIconClick.setSetter(true);
		this.onNavigationIconClick.setValue(value);
		this.orderSet++;
		this.onNavigationIconClick.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOverflowIcon(value : string) : T {
		this.resetIfRequired();
		if (this.overflowIcon == null || this.overflowIcon == undefined) {
			this.overflowIcon = new CommandAttr<string>();
		}
		
		this.overflowIcon.setSetter(true);
		this.overflowIcon.setValue(value);
		this.orderSet++;
		this.overflowIcon.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnMenuItemClick(value : string) : T {
		this.resetIfRequired();
		if (this.onMenuItemClick == null || this.onMenuItemClick == undefined) {
			this.onMenuItemClick = new CommandAttr<string>();
		}
		
		this.onMenuItemClick.setSetter(true);
		this.onMenuItemClick.setValue(value);
		this.orderSet++;
		this.onMenuItemClick.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class Toolbar extends ToolbarImpl<Toolbar> implements IWidget{
    getThisPointer(): Toolbar {
        return this;
    }
    
   	public getClass() {
		return Toolbar;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ToolbarImpl.initialize();
export interface OnClickEvent extends Event{
        //v:View;


}
export interface OnMenuItemClickEvent extends Event{
        //item:MenuItem;


}

//end - staticinit
