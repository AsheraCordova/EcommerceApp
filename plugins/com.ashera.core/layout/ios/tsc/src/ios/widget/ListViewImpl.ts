// start - imports

export const enum ChoiceMode {
multipleChoice = "multipleChoice",
multipleChoiceModal = "multipleChoiceModal",
none = "none",
singleChoice = "singleChoice",
}
export const enum IosSeparatorStyle {
none = "none",
singleLine = "singleLine",
}
export const enum IosCellSelectionStyle {
none = "none",
gray = "gray",
blue = "blue",
default = "default",
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
export abstract class ListViewImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "iosRowHeight" })
	iosRowHeight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosEstimatedRowHeight" })
	iosEstimatedRowHeight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosCellLayoutMarginsFollowReadableWidth" })
	iosCellLayoutMarginsFollowReadableWidth!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosInsetsContentViewsToSafeArea" })
	iosInsetsContentViewsToSafeArea!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSectionHeaderHeight" })
	iosSectionHeaderHeight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSectionFooterHeight" })
	iosSectionFooterHeight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosEstimatedSectionHeaderHeight" })
	iosEstimatedSectionHeaderHeight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosEstimatedSectionFooterHeight" })
	iosEstimatedSectionFooterHeight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSectionHeaderTopPadding" })
	iosSectionHeaderTopPadding!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSeparatorColor" })
	iosSeparatorColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosNumberOfSections" })
	iosNumberOfSections!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAllowsSelection" })
	iosAllowsSelection!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAllowsMultipleSelection" })
	iosAllowsMultipleSelection!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAllowsSelectionDuringEditing" })
	iosAllowsSelectionDuringEditing!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAllowsMultipleSelectionDuringEditing" })
	iosAllowsMultipleSelectionDuringEditing!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSelectionFollowsFocus" })
	iosSelectionFollowsFocus!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSectionIndexMinimumDisplayRowCount" })
	iosSectionIndexMinimumDisplayRowCount!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSectionIndexColor" })
	iosSectionIndexColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSectionIndexBackgroundColor" })
	iosSectionIndexBackgroundColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSectionIndexTrackingBackgroundColor" })
	iosSectionIndexTrackingBackgroundColor!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosHasUncommittedUpdates" })
	iosHasUncommittedUpdates!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosHasActiveDrag" })
	iosHasActiveDrag!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosDragInteractionEnabled" })
	iosDragInteractionEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosHasActiveDrop" })
	iosHasActiveDrop!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsEditing" })
	iosIsEditing!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosRemembersLastFocusedIndexPath" })
	iosRemembersLastFocusedIndexPath!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAllowsFocus" })
	iosAllowsFocus!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosAllowsFocusDuringEditing" })
	iosAllowsFocusDuringEditing!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosFillerRowHeight" })
	iosFillerRowHeight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosIsPrefetchingEnabled" })
	iosIsPrefetchingEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onItemClick" })
	onItemClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onItemLongClick" })
	onItemLongClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onScrollChange" })
	onScrollChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "listheader" })
	listheader!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "listfooter" })
	listfooter!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollX" })
	scrollX!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollY" })
	scrollY!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "choiceMode" })
	choiceMode!:CommandAttr<ChoiceMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "stackFromBottom" })
	stackFromBottom!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "listSelector" })
	listSelector!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSeparatorStyle" })
	iosSeparatorStyle!:CommandAttr<IosSeparatorStyle>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosCellSelectionStyle" })
	iosCellSelectionStyle!:CommandAttr<IosCellSelectionStyle>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSeparatorInsetTop" })
	iosSeparatorInsetTop!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSeparatorInsetBottom" })
	iosSeparatorInsetBottom!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSeparatorInsetLeft" })
	iosSeparatorInsetLeft!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "iosSeparatorInsetRight" })
	iosSeparatorInsetRight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "divider" })
	divider!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "dividerHeight" })
	dividerHeight!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "footerDividersEnabled" })
	footerDividersEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "headerDividersEnabled" })
	headerDividersEnabled!:CommandAttr<boolean>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.iosRowHeight = undefined;
		this.iosEstimatedRowHeight = undefined;
		this.iosCellLayoutMarginsFollowReadableWidth = undefined;
		this.iosInsetsContentViewsToSafeArea = undefined;
		this.iosSectionHeaderHeight = undefined;
		this.iosSectionFooterHeight = undefined;
		this.iosEstimatedSectionHeaderHeight = undefined;
		this.iosEstimatedSectionFooterHeight = undefined;
		this.iosSectionHeaderTopPadding = undefined;
		this.iosSeparatorColor = undefined;
		this.iosNumberOfSections = undefined;
		this.iosAllowsSelection = undefined;
		this.iosAllowsMultipleSelection = undefined;
		this.iosAllowsSelectionDuringEditing = undefined;
		this.iosAllowsMultipleSelectionDuringEditing = undefined;
		this.iosSelectionFollowsFocus = undefined;
		this.iosSectionIndexMinimumDisplayRowCount = undefined;
		this.iosSectionIndexColor = undefined;
		this.iosSectionIndexBackgroundColor = undefined;
		this.iosSectionIndexTrackingBackgroundColor = undefined;
		this.iosHasUncommittedUpdates = undefined;
		this.iosHasActiveDrag = undefined;
		this.iosDragInteractionEnabled = undefined;
		this.iosHasActiveDrop = undefined;
		this.iosIsEditing = undefined;
		this.iosRemembersLastFocusedIndexPath = undefined;
		this.iosAllowsFocus = undefined;
		this.iosAllowsFocusDuringEditing = undefined;
		this.iosFillerRowHeight = undefined;
		this.iosIsPrefetchingEnabled = undefined;
		this.onItemClick = undefined;
		this.onItemLongClick = undefined;
		this.onScrollChange = undefined;
		this.listheader = undefined;
		this.listfooter = undefined;
		this.scrollX = undefined;
		this.scrollY = undefined;
		this.choiceMode = undefined;
		this.stackFromBottom = undefined;
		this.listSelector = undefined;
		this.iosSeparatorStyle = undefined;
		this.iosCellSelectionStyle = undefined;
		this.iosSeparatorInsetTop = undefined;
		this.iosSeparatorInsetBottom = undefined;
		this.iosSeparatorInsetLeft = undefined;
		this.iosSeparatorInsetRight = undefined;
		this.divider = undefined;
		this.dividerHeight = undefined;
		this.footerDividersEnabled = undefined;
		this.headerDividersEnabled = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetIosRowHeight() : T {
		this.resetIfRequired();
		if (this.iosRowHeight == null || this.iosRowHeight == undefined) {
			this.iosRowHeight = new CommandAttr<number>()
		}
		
		this.iosRowHeight.setGetter(true);
		this.orderGet++;
		this.iosRowHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosRowHeight() : number {
		if (this.iosRowHeight == null || this.iosRowHeight == undefined) {
			this.iosRowHeight = new CommandAttr<number>();
		}
		return this.iosRowHeight.getCommandReturnValue();
	}
	public setIosRowHeight(value : number) : T {
		this.resetIfRequired();
		if (this.iosRowHeight == null || this.iosRowHeight == undefined) {
			this.iosRowHeight = new CommandAttr<number>();
		}
		
		this.iosRowHeight.setSetter(true);
		this.iosRowHeight.setValue(value);
		this.orderSet++;
		this.iosRowHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosEstimatedRowHeight() : T {
		this.resetIfRequired();
		if (this.iosEstimatedRowHeight == null || this.iosEstimatedRowHeight == undefined) {
			this.iosEstimatedRowHeight = new CommandAttr<number>()
		}
		
		this.iosEstimatedRowHeight.setGetter(true);
		this.orderGet++;
		this.iosEstimatedRowHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosEstimatedRowHeight() : number {
		if (this.iosEstimatedRowHeight == null || this.iosEstimatedRowHeight == undefined) {
			this.iosEstimatedRowHeight = new CommandAttr<number>();
		}
		return this.iosEstimatedRowHeight.getCommandReturnValue();
	}
	public setIosEstimatedRowHeight(value : number) : T {
		this.resetIfRequired();
		if (this.iosEstimatedRowHeight == null || this.iosEstimatedRowHeight == undefined) {
			this.iosEstimatedRowHeight = new CommandAttr<number>();
		}
		
		this.iosEstimatedRowHeight.setSetter(true);
		this.iosEstimatedRowHeight.setValue(value);
		this.orderSet++;
		this.iosEstimatedRowHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosCellLayoutMarginsFollowReadableWidth() : T {
		this.resetIfRequired();
		if (this.iosCellLayoutMarginsFollowReadableWidth == null || this.iosCellLayoutMarginsFollowReadableWidth == undefined) {
			this.iosCellLayoutMarginsFollowReadableWidth = new CommandAttr<boolean>()
		}
		
		this.iosCellLayoutMarginsFollowReadableWidth.setGetter(true);
		this.orderGet++;
		this.iosCellLayoutMarginsFollowReadableWidth.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosCellLayoutMarginsFollowReadableWidth() : boolean {
		if (this.iosCellLayoutMarginsFollowReadableWidth == null || this.iosCellLayoutMarginsFollowReadableWidth == undefined) {
			this.iosCellLayoutMarginsFollowReadableWidth = new CommandAttr<boolean>();
		}
		return this.iosCellLayoutMarginsFollowReadableWidth.getCommandReturnValue();
	}
	public setIosCellLayoutMarginsFollowReadableWidth(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosCellLayoutMarginsFollowReadableWidth == null || this.iosCellLayoutMarginsFollowReadableWidth == undefined) {
			this.iosCellLayoutMarginsFollowReadableWidth = new CommandAttr<boolean>();
		}
		
		this.iosCellLayoutMarginsFollowReadableWidth.setSetter(true);
		this.iosCellLayoutMarginsFollowReadableWidth.setValue(value);
		this.orderSet++;
		this.iosCellLayoutMarginsFollowReadableWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosInsetsContentViewsToSafeArea() : T {
		this.resetIfRequired();
		if (this.iosInsetsContentViewsToSafeArea == null || this.iosInsetsContentViewsToSafeArea == undefined) {
			this.iosInsetsContentViewsToSafeArea = new CommandAttr<boolean>()
		}
		
		this.iosInsetsContentViewsToSafeArea.setGetter(true);
		this.orderGet++;
		this.iosInsetsContentViewsToSafeArea.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosInsetsContentViewsToSafeArea() : boolean {
		if (this.iosInsetsContentViewsToSafeArea == null || this.iosInsetsContentViewsToSafeArea == undefined) {
			this.iosInsetsContentViewsToSafeArea = new CommandAttr<boolean>();
		}
		return this.iosInsetsContentViewsToSafeArea.getCommandReturnValue();
	}
	public setIosInsetsContentViewsToSafeArea(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosInsetsContentViewsToSafeArea == null || this.iosInsetsContentViewsToSafeArea == undefined) {
			this.iosInsetsContentViewsToSafeArea = new CommandAttr<boolean>();
		}
		
		this.iosInsetsContentViewsToSafeArea.setSetter(true);
		this.iosInsetsContentViewsToSafeArea.setValue(value);
		this.orderSet++;
		this.iosInsetsContentViewsToSafeArea.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosSectionHeaderHeight() : T {
		this.resetIfRequired();
		if (this.iosSectionHeaderHeight == null || this.iosSectionHeaderHeight == undefined) {
			this.iosSectionHeaderHeight = new CommandAttr<number>()
		}
		
		this.iosSectionHeaderHeight.setGetter(true);
		this.orderGet++;
		this.iosSectionHeaderHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosSectionHeaderHeight() : number {
		if (this.iosSectionHeaderHeight == null || this.iosSectionHeaderHeight == undefined) {
			this.iosSectionHeaderHeight = new CommandAttr<number>();
		}
		return this.iosSectionHeaderHeight.getCommandReturnValue();
	}
	public setIosSectionHeaderHeight(value : number) : T {
		this.resetIfRequired();
		if (this.iosSectionHeaderHeight == null || this.iosSectionHeaderHeight == undefined) {
			this.iosSectionHeaderHeight = new CommandAttr<number>();
		}
		
		this.iosSectionHeaderHeight.setSetter(true);
		this.iosSectionHeaderHeight.setValue(value);
		this.orderSet++;
		this.iosSectionHeaderHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosSectionFooterHeight() : T {
		this.resetIfRequired();
		if (this.iosSectionFooterHeight == null || this.iosSectionFooterHeight == undefined) {
			this.iosSectionFooterHeight = new CommandAttr<number>()
		}
		
		this.iosSectionFooterHeight.setGetter(true);
		this.orderGet++;
		this.iosSectionFooterHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosSectionFooterHeight() : number {
		if (this.iosSectionFooterHeight == null || this.iosSectionFooterHeight == undefined) {
			this.iosSectionFooterHeight = new CommandAttr<number>();
		}
		return this.iosSectionFooterHeight.getCommandReturnValue();
	}
	public setIosSectionFooterHeight(value : number) : T {
		this.resetIfRequired();
		if (this.iosSectionFooterHeight == null || this.iosSectionFooterHeight == undefined) {
			this.iosSectionFooterHeight = new CommandAttr<number>();
		}
		
		this.iosSectionFooterHeight.setSetter(true);
		this.iosSectionFooterHeight.setValue(value);
		this.orderSet++;
		this.iosSectionFooterHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosEstimatedSectionHeaderHeight() : T {
		this.resetIfRequired();
		if (this.iosEstimatedSectionHeaderHeight == null || this.iosEstimatedSectionHeaderHeight == undefined) {
			this.iosEstimatedSectionHeaderHeight = new CommandAttr<number>()
		}
		
		this.iosEstimatedSectionHeaderHeight.setGetter(true);
		this.orderGet++;
		this.iosEstimatedSectionHeaderHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosEstimatedSectionHeaderHeight() : number {
		if (this.iosEstimatedSectionHeaderHeight == null || this.iosEstimatedSectionHeaderHeight == undefined) {
			this.iosEstimatedSectionHeaderHeight = new CommandAttr<number>();
		}
		return this.iosEstimatedSectionHeaderHeight.getCommandReturnValue();
	}
	public setIosEstimatedSectionHeaderHeight(value : number) : T {
		this.resetIfRequired();
		if (this.iosEstimatedSectionHeaderHeight == null || this.iosEstimatedSectionHeaderHeight == undefined) {
			this.iosEstimatedSectionHeaderHeight = new CommandAttr<number>();
		}
		
		this.iosEstimatedSectionHeaderHeight.setSetter(true);
		this.iosEstimatedSectionHeaderHeight.setValue(value);
		this.orderSet++;
		this.iosEstimatedSectionHeaderHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosEstimatedSectionFooterHeight() : T {
		this.resetIfRequired();
		if (this.iosEstimatedSectionFooterHeight == null || this.iosEstimatedSectionFooterHeight == undefined) {
			this.iosEstimatedSectionFooterHeight = new CommandAttr<number>()
		}
		
		this.iosEstimatedSectionFooterHeight.setGetter(true);
		this.orderGet++;
		this.iosEstimatedSectionFooterHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosEstimatedSectionFooterHeight() : number {
		if (this.iosEstimatedSectionFooterHeight == null || this.iosEstimatedSectionFooterHeight == undefined) {
			this.iosEstimatedSectionFooterHeight = new CommandAttr<number>();
		}
		return this.iosEstimatedSectionFooterHeight.getCommandReturnValue();
	}
	public setIosEstimatedSectionFooterHeight(value : number) : T {
		this.resetIfRequired();
		if (this.iosEstimatedSectionFooterHeight == null || this.iosEstimatedSectionFooterHeight == undefined) {
			this.iosEstimatedSectionFooterHeight = new CommandAttr<number>();
		}
		
		this.iosEstimatedSectionFooterHeight.setSetter(true);
		this.iosEstimatedSectionFooterHeight.setValue(value);
		this.orderSet++;
		this.iosEstimatedSectionFooterHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosSectionHeaderTopPadding() : T {
		this.resetIfRequired();
		if (this.iosSectionHeaderTopPadding == null || this.iosSectionHeaderTopPadding == undefined) {
			this.iosSectionHeaderTopPadding = new CommandAttr<number>()
		}
		
		this.iosSectionHeaderTopPadding.setGetter(true);
		this.orderGet++;
		this.iosSectionHeaderTopPadding.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosSectionHeaderTopPadding() : number {
		if (this.iosSectionHeaderTopPadding == null || this.iosSectionHeaderTopPadding == undefined) {
			this.iosSectionHeaderTopPadding = new CommandAttr<number>();
		}
		return this.iosSectionHeaderTopPadding.getCommandReturnValue();
	}
	public setIosSectionHeaderTopPadding(value : number) : T {
		this.resetIfRequired();
		if (this.iosSectionHeaderTopPadding == null || this.iosSectionHeaderTopPadding == undefined) {
			this.iosSectionHeaderTopPadding = new CommandAttr<number>();
		}
		
		this.iosSectionHeaderTopPadding.setSetter(true);
		this.iosSectionHeaderTopPadding.setValue(value);
		this.orderSet++;
		this.iosSectionHeaderTopPadding.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosSeparatorColor() : T {
		this.resetIfRequired();
		if (this.iosSeparatorColor == null || this.iosSeparatorColor == undefined) {
			this.iosSeparatorColor = new CommandAttr<string>()
		}
		
		this.iosSeparatorColor.setGetter(true);
		this.orderGet++;
		this.iosSeparatorColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosSeparatorColor() : string {
		if (this.iosSeparatorColor == null || this.iosSeparatorColor == undefined) {
			this.iosSeparatorColor = new CommandAttr<string>();
		}
		return this.iosSeparatorColor.getCommandReturnValue();
	}
	public setIosSeparatorColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosSeparatorColor == null || this.iosSeparatorColor == undefined) {
			this.iosSeparatorColor = new CommandAttr<string>();
		}
		
		this.iosSeparatorColor.setSetter(true);
		this.iosSeparatorColor.setValue(value);
		this.orderSet++;
		this.iosSeparatorColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosNumberOfSections() : T {
		this.resetIfRequired();
		if (this.iosNumberOfSections == null || this.iosNumberOfSections == undefined) {
			this.iosNumberOfSections = new CommandAttr<number>()
		}
		
		this.iosNumberOfSections.setGetter(true);
		this.orderGet++;
		this.iosNumberOfSections.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosNumberOfSections() : number {
		if (this.iosNumberOfSections == null || this.iosNumberOfSections == undefined) {
			this.iosNumberOfSections = new CommandAttr<number>();
		}
		return this.iosNumberOfSections.getCommandReturnValue();
	}
	
		

	public tryGetIosAllowsSelection() : T {
		this.resetIfRequired();
		if (this.iosAllowsSelection == null || this.iosAllowsSelection == undefined) {
			this.iosAllowsSelection = new CommandAttr<boolean>()
		}
		
		this.iosAllowsSelection.setGetter(true);
		this.orderGet++;
		this.iosAllowsSelection.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAllowsSelection() : boolean {
		if (this.iosAllowsSelection == null || this.iosAllowsSelection == undefined) {
			this.iosAllowsSelection = new CommandAttr<boolean>();
		}
		return this.iosAllowsSelection.getCommandReturnValue();
	}
	public setIosAllowsSelection(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAllowsSelection == null || this.iosAllowsSelection == undefined) {
			this.iosAllowsSelection = new CommandAttr<boolean>();
		}
		
		this.iosAllowsSelection.setSetter(true);
		this.iosAllowsSelection.setValue(value);
		this.orderSet++;
		this.iosAllowsSelection.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAllowsMultipleSelection() : T {
		this.resetIfRequired();
		if (this.iosAllowsMultipleSelection == null || this.iosAllowsMultipleSelection == undefined) {
			this.iosAllowsMultipleSelection = new CommandAttr<boolean>()
		}
		
		this.iosAllowsMultipleSelection.setGetter(true);
		this.orderGet++;
		this.iosAllowsMultipleSelection.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAllowsMultipleSelection() : boolean {
		if (this.iosAllowsMultipleSelection == null || this.iosAllowsMultipleSelection == undefined) {
			this.iosAllowsMultipleSelection = new CommandAttr<boolean>();
		}
		return this.iosAllowsMultipleSelection.getCommandReturnValue();
	}
	public setIosAllowsMultipleSelection(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAllowsMultipleSelection == null || this.iosAllowsMultipleSelection == undefined) {
			this.iosAllowsMultipleSelection = new CommandAttr<boolean>();
		}
		
		this.iosAllowsMultipleSelection.setSetter(true);
		this.iosAllowsMultipleSelection.setValue(value);
		this.orderSet++;
		this.iosAllowsMultipleSelection.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAllowsSelectionDuringEditing() : T {
		this.resetIfRequired();
		if (this.iosAllowsSelectionDuringEditing == null || this.iosAllowsSelectionDuringEditing == undefined) {
			this.iosAllowsSelectionDuringEditing = new CommandAttr<boolean>()
		}
		
		this.iosAllowsSelectionDuringEditing.setGetter(true);
		this.orderGet++;
		this.iosAllowsSelectionDuringEditing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAllowsSelectionDuringEditing() : boolean {
		if (this.iosAllowsSelectionDuringEditing == null || this.iosAllowsSelectionDuringEditing == undefined) {
			this.iosAllowsSelectionDuringEditing = new CommandAttr<boolean>();
		}
		return this.iosAllowsSelectionDuringEditing.getCommandReturnValue();
	}
	public setIosAllowsSelectionDuringEditing(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAllowsSelectionDuringEditing == null || this.iosAllowsSelectionDuringEditing == undefined) {
			this.iosAllowsSelectionDuringEditing = new CommandAttr<boolean>();
		}
		
		this.iosAllowsSelectionDuringEditing.setSetter(true);
		this.iosAllowsSelectionDuringEditing.setValue(value);
		this.orderSet++;
		this.iosAllowsSelectionDuringEditing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAllowsMultipleSelectionDuringEditing() : T {
		this.resetIfRequired();
		if (this.iosAllowsMultipleSelectionDuringEditing == null || this.iosAllowsMultipleSelectionDuringEditing == undefined) {
			this.iosAllowsMultipleSelectionDuringEditing = new CommandAttr<boolean>()
		}
		
		this.iosAllowsMultipleSelectionDuringEditing.setGetter(true);
		this.orderGet++;
		this.iosAllowsMultipleSelectionDuringEditing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAllowsMultipleSelectionDuringEditing() : boolean {
		if (this.iosAllowsMultipleSelectionDuringEditing == null || this.iosAllowsMultipleSelectionDuringEditing == undefined) {
			this.iosAllowsMultipleSelectionDuringEditing = new CommandAttr<boolean>();
		}
		return this.iosAllowsMultipleSelectionDuringEditing.getCommandReturnValue();
	}
	public setIosAllowsMultipleSelectionDuringEditing(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAllowsMultipleSelectionDuringEditing == null || this.iosAllowsMultipleSelectionDuringEditing == undefined) {
			this.iosAllowsMultipleSelectionDuringEditing = new CommandAttr<boolean>();
		}
		
		this.iosAllowsMultipleSelectionDuringEditing.setSetter(true);
		this.iosAllowsMultipleSelectionDuringEditing.setValue(value);
		this.orderSet++;
		this.iosAllowsMultipleSelectionDuringEditing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosSelectionFollowsFocus() : T {
		this.resetIfRequired();
		if (this.iosSelectionFollowsFocus == null || this.iosSelectionFollowsFocus == undefined) {
			this.iosSelectionFollowsFocus = new CommandAttr<boolean>()
		}
		
		this.iosSelectionFollowsFocus.setGetter(true);
		this.orderGet++;
		this.iosSelectionFollowsFocus.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosSelectionFollowsFocus() : boolean {
		if (this.iosSelectionFollowsFocus == null || this.iosSelectionFollowsFocus == undefined) {
			this.iosSelectionFollowsFocus = new CommandAttr<boolean>();
		}
		return this.iosSelectionFollowsFocus.getCommandReturnValue();
	}
	public setIosSelectionFollowsFocus(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosSelectionFollowsFocus == null || this.iosSelectionFollowsFocus == undefined) {
			this.iosSelectionFollowsFocus = new CommandAttr<boolean>();
		}
		
		this.iosSelectionFollowsFocus.setSetter(true);
		this.iosSelectionFollowsFocus.setValue(value);
		this.orderSet++;
		this.iosSelectionFollowsFocus.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosSectionIndexMinimumDisplayRowCount() : T {
		this.resetIfRequired();
		if (this.iosSectionIndexMinimumDisplayRowCount == null || this.iosSectionIndexMinimumDisplayRowCount == undefined) {
			this.iosSectionIndexMinimumDisplayRowCount = new CommandAttr<number>()
		}
		
		this.iosSectionIndexMinimumDisplayRowCount.setGetter(true);
		this.orderGet++;
		this.iosSectionIndexMinimumDisplayRowCount.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosSectionIndexMinimumDisplayRowCount() : number {
		if (this.iosSectionIndexMinimumDisplayRowCount == null || this.iosSectionIndexMinimumDisplayRowCount == undefined) {
			this.iosSectionIndexMinimumDisplayRowCount = new CommandAttr<number>();
		}
		return this.iosSectionIndexMinimumDisplayRowCount.getCommandReturnValue();
	}
	public setIosSectionIndexMinimumDisplayRowCount(value : number) : T {
		this.resetIfRequired();
		if (this.iosSectionIndexMinimumDisplayRowCount == null || this.iosSectionIndexMinimumDisplayRowCount == undefined) {
			this.iosSectionIndexMinimumDisplayRowCount = new CommandAttr<number>();
		}
		
		this.iosSectionIndexMinimumDisplayRowCount.setSetter(true);
		this.iosSectionIndexMinimumDisplayRowCount.setValue(value);
		this.orderSet++;
		this.iosSectionIndexMinimumDisplayRowCount.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosSectionIndexColor() : T {
		this.resetIfRequired();
		if (this.iosSectionIndexColor == null || this.iosSectionIndexColor == undefined) {
			this.iosSectionIndexColor = new CommandAttr<string>()
		}
		
		this.iosSectionIndexColor.setGetter(true);
		this.orderGet++;
		this.iosSectionIndexColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosSectionIndexColor() : string {
		if (this.iosSectionIndexColor == null || this.iosSectionIndexColor == undefined) {
			this.iosSectionIndexColor = new CommandAttr<string>();
		}
		return this.iosSectionIndexColor.getCommandReturnValue();
	}
	public setIosSectionIndexColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosSectionIndexColor == null || this.iosSectionIndexColor == undefined) {
			this.iosSectionIndexColor = new CommandAttr<string>();
		}
		
		this.iosSectionIndexColor.setSetter(true);
		this.iosSectionIndexColor.setValue(value);
		this.orderSet++;
		this.iosSectionIndexColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosSectionIndexBackgroundColor() : T {
		this.resetIfRequired();
		if (this.iosSectionIndexBackgroundColor == null || this.iosSectionIndexBackgroundColor == undefined) {
			this.iosSectionIndexBackgroundColor = new CommandAttr<string>()
		}
		
		this.iosSectionIndexBackgroundColor.setGetter(true);
		this.orderGet++;
		this.iosSectionIndexBackgroundColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosSectionIndexBackgroundColor() : string {
		if (this.iosSectionIndexBackgroundColor == null || this.iosSectionIndexBackgroundColor == undefined) {
			this.iosSectionIndexBackgroundColor = new CommandAttr<string>();
		}
		return this.iosSectionIndexBackgroundColor.getCommandReturnValue();
	}
	public setIosSectionIndexBackgroundColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosSectionIndexBackgroundColor == null || this.iosSectionIndexBackgroundColor == undefined) {
			this.iosSectionIndexBackgroundColor = new CommandAttr<string>();
		}
		
		this.iosSectionIndexBackgroundColor.setSetter(true);
		this.iosSectionIndexBackgroundColor.setValue(value);
		this.orderSet++;
		this.iosSectionIndexBackgroundColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosSectionIndexTrackingBackgroundColor() : T {
		this.resetIfRequired();
		if (this.iosSectionIndexTrackingBackgroundColor == null || this.iosSectionIndexTrackingBackgroundColor == undefined) {
			this.iosSectionIndexTrackingBackgroundColor = new CommandAttr<string>()
		}
		
		this.iosSectionIndexTrackingBackgroundColor.setGetter(true);
		this.orderGet++;
		this.iosSectionIndexTrackingBackgroundColor.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosSectionIndexTrackingBackgroundColor() : string {
		if (this.iosSectionIndexTrackingBackgroundColor == null || this.iosSectionIndexTrackingBackgroundColor == undefined) {
			this.iosSectionIndexTrackingBackgroundColor = new CommandAttr<string>();
		}
		return this.iosSectionIndexTrackingBackgroundColor.getCommandReturnValue();
	}
	public setIosSectionIndexTrackingBackgroundColor(value : string) : T {
		this.resetIfRequired();
		if (this.iosSectionIndexTrackingBackgroundColor == null || this.iosSectionIndexTrackingBackgroundColor == undefined) {
			this.iosSectionIndexTrackingBackgroundColor = new CommandAttr<string>();
		}
		
		this.iosSectionIndexTrackingBackgroundColor.setSetter(true);
		this.iosSectionIndexTrackingBackgroundColor.setValue(value);
		this.orderSet++;
		this.iosSectionIndexTrackingBackgroundColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosHasUncommittedUpdates() : T {
		this.resetIfRequired();
		if (this.iosHasUncommittedUpdates == null || this.iosHasUncommittedUpdates == undefined) {
			this.iosHasUncommittedUpdates = new CommandAttr<boolean>()
		}
		
		this.iosHasUncommittedUpdates.setGetter(true);
		this.orderGet++;
		this.iosHasUncommittedUpdates.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosHasUncommittedUpdates() : boolean {
		if (this.iosHasUncommittedUpdates == null || this.iosHasUncommittedUpdates == undefined) {
			this.iosHasUncommittedUpdates = new CommandAttr<boolean>();
		}
		return this.iosHasUncommittedUpdates.getCommandReturnValue();
	}
	
		

	public tryGetIosHasActiveDrag() : T {
		this.resetIfRequired();
		if (this.iosHasActiveDrag == null || this.iosHasActiveDrag == undefined) {
			this.iosHasActiveDrag = new CommandAttr<boolean>()
		}
		
		this.iosHasActiveDrag.setGetter(true);
		this.orderGet++;
		this.iosHasActiveDrag.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosHasActiveDrag() : boolean {
		if (this.iosHasActiveDrag == null || this.iosHasActiveDrag == undefined) {
			this.iosHasActiveDrag = new CommandAttr<boolean>();
		}
		return this.iosHasActiveDrag.getCommandReturnValue();
	}
	
		

	public tryGetIosDragInteractionEnabled() : T {
		this.resetIfRequired();
		if (this.iosDragInteractionEnabled == null || this.iosDragInteractionEnabled == undefined) {
			this.iosDragInteractionEnabled = new CommandAttr<boolean>()
		}
		
		this.iosDragInteractionEnabled.setGetter(true);
		this.orderGet++;
		this.iosDragInteractionEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosDragInteractionEnabled() : boolean {
		if (this.iosDragInteractionEnabled == null || this.iosDragInteractionEnabled == undefined) {
			this.iosDragInteractionEnabled = new CommandAttr<boolean>();
		}
		return this.iosDragInteractionEnabled.getCommandReturnValue();
	}
	public setIosDragInteractionEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosDragInteractionEnabled == null || this.iosDragInteractionEnabled == undefined) {
			this.iosDragInteractionEnabled = new CommandAttr<boolean>();
		}
		
		this.iosDragInteractionEnabled.setSetter(true);
		this.iosDragInteractionEnabled.setValue(value);
		this.orderSet++;
		this.iosDragInteractionEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosHasActiveDrop() : T {
		this.resetIfRequired();
		if (this.iosHasActiveDrop == null || this.iosHasActiveDrop == undefined) {
			this.iosHasActiveDrop = new CommandAttr<boolean>()
		}
		
		this.iosHasActiveDrop.setGetter(true);
		this.orderGet++;
		this.iosHasActiveDrop.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosHasActiveDrop() : boolean {
		if (this.iosHasActiveDrop == null || this.iosHasActiveDrop == undefined) {
			this.iosHasActiveDrop = new CommandAttr<boolean>();
		}
		return this.iosHasActiveDrop.getCommandReturnValue();
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
	public setIosIsEditing(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsEditing == null || this.iosIsEditing == undefined) {
			this.iosIsEditing = new CommandAttr<boolean>();
		}
		
		this.iosIsEditing.setSetter(true);
		this.iosIsEditing.setValue(value);
		this.orderSet++;
		this.iosIsEditing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosRemembersLastFocusedIndexPath() : T {
		this.resetIfRequired();
		if (this.iosRemembersLastFocusedIndexPath == null || this.iosRemembersLastFocusedIndexPath == undefined) {
			this.iosRemembersLastFocusedIndexPath = new CommandAttr<boolean>()
		}
		
		this.iosRemembersLastFocusedIndexPath.setGetter(true);
		this.orderGet++;
		this.iosRemembersLastFocusedIndexPath.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosRemembersLastFocusedIndexPath() : boolean {
		if (this.iosRemembersLastFocusedIndexPath == null || this.iosRemembersLastFocusedIndexPath == undefined) {
			this.iosRemembersLastFocusedIndexPath = new CommandAttr<boolean>();
		}
		return this.iosRemembersLastFocusedIndexPath.getCommandReturnValue();
	}
	public setIosRemembersLastFocusedIndexPath(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosRemembersLastFocusedIndexPath == null || this.iosRemembersLastFocusedIndexPath == undefined) {
			this.iosRemembersLastFocusedIndexPath = new CommandAttr<boolean>();
		}
		
		this.iosRemembersLastFocusedIndexPath.setSetter(true);
		this.iosRemembersLastFocusedIndexPath.setValue(value);
		this.orderSet++;
		this.iosRemembersLastFocusedIndexPath.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAllowsFocus() : T {
		this.resetIfRequired();
		if (this.iosAllowsFocus == null || this.iosAllowsFocus == undefined) {
			this.iosAllowsFocus = new CommandAttr<boolean>()
		}
		
		this.iosAllowsFocus.setGetter(true);
		this.orderGet++;
		this.iosAllowsFocus.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAllowsFocus() : boolean {
		if (this.iosAllowsFocus == null || this.iosAllowsFocus == undefined) {
			this.iosAllowsFocus = new CommandAttr<boolean>();
		}
		return this.iosAllowsFocus.getCommandReturnValue();
	}
	public setIosAllowsFocus(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAllowsFocus == null || this.iosAllowsFocus == undefined) {
			this.iosAllowsFocus = new CommandAttr<boolean>();
		}
		
		this.iosAllowsFocus.setSetter(true);
		this.iosAllowsFocus.setValue(value);
		this.orderSet++;
		this.iosAllowsFocus.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosAllowsFocusDuringEditing() : T {
		this.resetIfRequired();
		if (this.iosAllowsFocusDuringEditing == null || this.iosAllowsFocusDuringEditing == undefined) {
			this.iosAllowsFocusDuringEditing = new CommandAttr<boolean>()
		}
		
		this.iosAllowsFocusDuringEditing.setGetter(true);
		this.orderGet++;
		this.iosAllowsFocusDuringEditing.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosAllowsFocusDuringEditing() : boolean {
		if (this.iosAllowsFocusDuringEditing == null || this.iosAllowsFocusDuringEditing == undefined) {
			this.iosAllowsFocusDuringEditing = new CommandAttr<boolean>();
		}
		return this.iosAllowsFocusDuringEditing.getCommandReturnValue();
	}
	public setIosAllowsFocusDuringEditing(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosAllowsFocusDuringEditing == null || this.iosAllowsFocusDuringEditing == undefined) {
			this.iosAllowsFocusDuringEditing = new CommandAttr<boolean>();
		}
		
		this.iosAllowsFocusDuringEditing.setSetter(true);
		this.iosAllowsFocusDuringEditing.setValue(value);
		this.orderSet++;
		this.iosAllowsFocusDuringEditing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosFillerRowHeight() : T {
		this.resetIfRequired();
		if (this.iosFillerRowHeight == null || this.iosFillerRowHeight == undefined) {
			this.iosFillerRowHeight = new CommandAttr<number>()
		}
		
		this.iosFillerRowHeight.setGetter(true);
		this.orderGet++;
		this.iosFillerRowHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getIosFillerRowHeight() : number {
		if (this.iosFillerRowHeight == null || this.iosFillerRowHeight == undefined) {
			this.iosFillerRowHeight = new CommandAttr<number>();
		}
		return this.iosFillerRowHeight.getCommandReturnValue();
	}
	public setIosFillerRowHeight(value : number) : T {
		this.resetIfRequired();
		if (this.iosFillerRowHeight == null || this.iosFillerRowHeight == undefined) {
			this.iosFillerRowHeight = new CommandAttr<number>();
		}
		
		this.iosFillerRowHeight.setSetter(true);
		this.iosFillerRowHeight.setValue(value);
		this.orderSet++;
		this.iosFillerRowHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetIosIsPrefetchingEnabled() : T {
		this.resetIfRequired();
		if (this.iosIsPrefetchingEnabled == null || this.iosIsPrefetchingEnabled == undefined) {
			this.iosIsPrefetchingEnabled = new CommandAttr<boolean>()
		}
		
		this.iosIsPrefetchingEnabled.setGetter(true);
		this.orderGet++;
		this.iosIsPrefetchingEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isIosIsPrefetchingEnabled() : boolean {
		if (this.iosIsPrefetchingEnabled == null || this.iosIsPrefetchingEnabled == undefined) {
			this.iosIsPrefetchingEnabled = new CommandAttr<boolean>();
		}
		return this.iosIsPrefetchingEnabled.getCommandReturnValue();
	}
	public setIosIsPrefetchingEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.iosIsPrefetchingEnabled == null || this.iosIsPrefetchingEnabled == undefined) {
			this.iosIsPrefetchingEnabled = new CommandAttr<boolean>();
		}
		
		this.iosIsPrefetchingEnabled.setSetter(true);
		this.iosIsPrefetchingEnabled.setValue(value);
		this.orderSet++;
		this.iosIsPrefetchingEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnItemClick(value : string) : T {
		this.resetIfRequired();
		if (this.onItemClick == null || this.onItemClick == undefined) {
			this.onItemClick = new CommandAttr<string>();
		}
		
		this.onItemClick.setSetter(true);
		this.onItemClick.setValue(value);
		this.orderSet++;
		this.onItemClick.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnItemLongClick(value : string) : T {
		this.resetIfRequired();
		if (this.onItemLongClick == null || this.onItemLongClick == undefined) {
			this.onItemLongClick = new CommandAttr<string>();
		}
		
		this.onItemLongClick.setSetter(true);
		this.onItemLongClick.setValue(value);
		this.orderSet++;
		this.onItemLongClick.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnScrollChange(value : string) : T {
		this.resetIfRequired();
		if (this.onScrollChange == null || this.onScrollChange == undefined) {
			this.onScrollChange = new CommandAttr<string>();
		}
		
		this.onScrollChange.setSetter(true);
		this.onScrollChange.setValue(value);
		this.orderSet++;
		this.onScrollChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setListheader(value : string) : T {
		this.resetIfRequired();
		if (this.listheader == null || this.listheader == undefined) {
			this.listheader = new CommandAttr<string>();
		}
		
		this.listheader.setSetter(true);
		this.listheader.setValue(value);
		this.orderSet++;
		this.listheader.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setListfooter(value : string) : T {
		this.resetIfRequired();
		if (this.listfooter == null || this.listfooter == undefined) {
			this.listfooter = new CommandAttr<string>();
		}
		
		this.listfooter.setSetter(true);
		this.listfooter.setValue(value);
		this.orderSet++;
		this.listfooter.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScrollX() : T {
		this.resetIfRequired();
		if (this.scrollX == null || this.scrollX == undefined) {
			this.scrollX = new CommandAttr<string>()
		}
		
		this.scrollX.setGetter(true);
		this.orderGet++;
		this.scrollX.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScrollX() : string {
		if (this.scrollX == null || this.scrollX == undefined) {
			this.scrollX = new CommandAttr<string>();
		}
		return this.scrollX.getCommandReturnValue();
	}
	public setScrollX(value : string) : T {
		this.resetIfRequired();
		if (this.scrollX == null || this.scrollX == undefined) {
			this.scrollX = new CommandAttr<string>();
		}
		
		this.scrollX.setSetter(true);
		this.scrollX.setValue(value);
		this.orderSet++;
		this.scrollX.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScrollY() : T {
		this.resetIfRequired();
		if (this.scrollY == null || this.scrollY == undefined) {
			this.scrollY = new CommandAttr<string>()
		}
		
		this.scrollY.setGetter(true);
		this.orderGet++;
		this.scrollY.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getScrollY() : string {
		if (this.scrollY == null || this.scrollY == undefined) {
			this.scrollY = new CommandAttr<string>();
		}
		return this.scrollY.getCommandReturnValue();
	}
	public setScrollY(value : string) : T {
		this.resetIfRequired();
		if (this.scrollY == null || this.scrollY == undefined) {
			this.scrollY = new CommandAttr<string>();
		}
		
		this.scrollY.setSetter(true);
		this.scrollY.setValue(value);
		this.orderSet++;
		this.scrollY.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetChoiceMode() : T {
		this.resetIfRequired();
		if (this.choiceMode == null || this.choiceMode == undefined) {
			this.choiceMode = new CommandAttr<ChoiceMode>()
		}
		
		this.choiceMode.setGetter(true);
		this.orderGet++;
		this.choiceMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getChoiceMode() : ChoiceMode {
		if (this.choiceMode == null || this.choiceMode == undefined) {
			this.choiceMode = new CommandAttr<ChoiceMode>();
		}
		return this.choiceMode.getCommandReturnValue();
	}
	public setChoiceMode(value : ChoiceMode) : T {
		this.resetIfRequired();
		if (this.choiceMode == null || this.choiceMode == undefined) {
			this.choiceMode = new CommandAttr<ChoiceMode>();
		}
		
		this.choiceMode.setSetter(true);
		this.choiceMode.setValue(value);
		this.orderSet++;
		this.choiceMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetStackFromBottom() : T {
		this.resetIfRequired();
		if (this.stackFromBottom == null || this.stackFromBottom == undefined) {
			this.stackFromBottom = new CommandAttr<boolean>()
		}
		
		this.stackFromBottom.setGetter(true);
		this.orderGet++;
		this.stackFromBottom.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isStackFromBottom() : boolean {
		if (this.stackFromBottom == null || this.stackFromBottom == undefined) {
			this.stackFromBottom = new CommandAttr<boolean>();
		}
		return this.stackFromBottom.getCommandReturnValue();
	}
	public setStackFromBottom(value : boolean) : T {
		this.resetIfRequired();
		if (this.stackFromBottom == null || this.stackFromBottom == undefined) {
			this.stackFromBottom = new CommandAttr<boolean>();
		}
		
		this.stackFromBottom.setSetter(true);
		this.stackFromBottom.setValue(value);
		this.orderSet++;
		this.stackFromBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetListSelector() : T {
		this.resetIfRequired();
		if (this.listSelector == null || this.listSelector == undefined) {
			this.listSelector = new CommandAttr<string>()
		}
		
		this.listSelector.setGetter(true);
		this.orderGet++;
		this.listSelector.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getListSelector() : string {
		if (this.listSelector == null || this.listSelector == undefined) {
			this.listSelector = new CommandAttr<string>();
		}
		return this.listSelector.getCommandReturnValue();
	}
	public setListSelector(value : string) : T {
		this.resetIfRequired();
		if (this.listSelector == null || this.listSelector == undefined) {
			this.listSelector = new CommandAttr<string>();
		}
		
		this.listSelector.setSetter(true);
		this.listSelector.setValue(value);
		this.orderSet++;
		this.listSelector.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setIosSeparatorStyle(value : IosSeparatorStyle) : T {
		this.resetIfRequired();
		if (this.iosSeparatorStyle == null || this.iosSeparatorStyle == undefined) {
			this.iosSeparatorStyle = new CommandAttr<IosSeparatorStyle>();
		}
		
		this.iosSeparatorStyle.setSetter(true);
		this.iosSeparatorStyle.setValue(value);
		this.orderSet++;
		this.iosSeparatorStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setIosCellSelectionStyle(value : IosCellSelectionStyle) : T {
		this.resetIfRequired();
		if (this.iosCellSelectionStyle == null || this.iosCellSelectionStyle == undefined) {
			this.iosCellSelectionStyle = new CommandAttr<IosCellSelectionStyle>();
		}
		
		this.iosCellSelectionStyle.setSetter(true);
		this.iosCellSelectionStyle.setValue(value);
		this.orderSet++;
		this.iosCellSelectionStyle.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setIosSeparatorInsetTop(value : string) : T {
		this.resetIfRequired();
		if (this.iosSeparatorInsetTop == null || this.iosSeparatorInsetTop == undefined) {
			this.iosSeparatorInsetTop = new CommandAttr<string>();
		}
		
		this.iosSeparatorInsetTop.setSetter(true);
		this.iosSeparatorInsetTop.setValue(value);
		this.orderSet++;
		this.iosSeparatorInsetTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setIosSeparatorInsetBottom(value : string) : T {
		this.resetIfRequired();
		if (this.iosSeparatorInsetBottom == null || this.iosSeparatorInsetBottom == undefined) {
			this.iosSeparatorInsetBottom = new CommandAttr<string>();
		}
		
		this.iosSeparatorInsetBottom.setSetter(true);
		this.iosSeparatorInsetBottom.setValue(value);
		this.orderSet++;
		this.iosSeparatorInsetBottom.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setIosSeparatorInsetLeft(value : string) : T {
		this.resetIfRequired();
		if (this.iosSeparatorInsetLeft == null || this.iosSeparatorInsetLeft == undefined) {
			this.iosSeparatorInsetLeft = new CommandAttr<string>();
		}
		
		this.iosSeparatorInsetLeft.setSetter(true);
		this.iosSeparatorInsetLeft.setValue(value);
		this.orderSet++;
		this.iosSeparatorInsetLeft.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setIosSeparatorInsetRight(value : string) : T {
		this.resetIfRequired();
		if (this.iosSeparatorInsetRight == null || this.iosSeparatorInsetRight == undefined) {
			this.iosSeparatorInsetRight = new CommandAttr<string>();
		}
		
		this.iosSeparatorInsetRight.setSetter(true);
		this.iosSeparatorInsetRight.setValue(value);
		this.orderSet++;
		this.iosSeparatorInsetRight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetDivider() : T {
		this.resetIfRequired();
		if (this.divider == null || this.divider == undefined) {
			this.divider = new CommandAttr<string>()
		}
		
		this.divider.setGetter(true);
		this.orderGet++;
		this.divider.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getDivider() : string {
		if (this.divider == null || this.divider == undefined) {
			this.divider = new CommandAttr<string>();
		}
		return this.divider.getCommandReturnValue();
	}
	public setDivider(value : string) : T {
		this.resetIfRequired();
		if (this.divider == null || this.divider == undefined) {
			this.divider = new CommandAttr<string>();
		}
		
		this.divider.setSetter(true);
		this.divider.setValue(value);
		this.orderSet++;
		this.divider.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetDividerHeight() : T {
		this.resetIfRequired();
		if (this.dividerHeight == null || this.dividerHeight == undefined) {
			this.dividerHeight = new CommandAttr<string>()
		}
		
		this.dividerHeight.setGetter(true);
		this.orderGet++;
		this.dividerHeight.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getDividerHeight() : string {
		if (this.dividerHeight == null || this.dividerHeight == undefined) {
			this.dividerHeight = new CommandAttr<string>();
		}
		return this.dividerHeight.getCommandReturnValue();
	}
	public setDividerHeight(value : string) : T {
		this.resetIfRequired();
		if (this.dividerHeight == null || this.dividerHeight == undefined) {
			this.dividerHeight = new CommandAttr<string>();
		}
		
		this.dividerHeight.setSetter(true);
		this.dividerHeight.setValue(value);
		this.orderSet++;
		this.dividerHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFooterDividersEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.footerDividersEnabled == null || this.footerDividersEnabled == undefined) {
			this.footerDividersEnabled = new CommandAttr<boolean>();
		}
		
		this.footerDividersEnabled.setSetter(true);
		this.footerDividersEnabled.setValue(value);
		this.orderSet++;
		this.footerDividersEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setHeaderDividersEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.headerDividersEnabled == null || this.headerDividersEnabled == undefined) {
			this.headerDividersEnabled = new CommandAttr<boolean>();
		}
		
		this.headerDividersEnabled.setSetter(true);
		this.headerDividersEnabled.setValue(value);
		this.orderSet++;
		this.headerDividersEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class ListView extends ListViewImpl<ListView> implements IWidget{
    getThisPointer(): ListView {
        return this;
    }
    
   	public getClass() {
		return ListView;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ListViewImpl.initialize();

//end - staticinit
