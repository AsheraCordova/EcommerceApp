// start - imports

export const enum ChoiceMode {
multipleChoice = "multipleChoice",
multipleChoiceModal = "multipleChoiceModal",
none = "none",
singleChoice = "singleChoice",
}
export const enum TranscriptMode {
alwaysScroll = "alwaysScroll",
disabled = "disabled",
normal = "normal",
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

import {ViewGroupImpl} from './ViewGroupImpl'
export abstract class ListViewImpl<T> extends ViewGroupImpl<T> {
	//start - body
	static initialize() {
    }	
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
	@Type(() => CommandAttr)
	@Expose({ name: "cacheColorHint" })
	cacheColorHint!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "choiceMode" })
	choiceMode!:CommandAttr<ChoiceMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "drawSelectorOnTop" })
	drawSelectorOnTop!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "fastScrollEnabled" })
	fastScrollEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollingCache" })
	scrollingCache!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "smoothScrollbar" })
	smoothScrollbar!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "stackFromBottom" })
	stackFromBottom!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "textFilterEnabled" })
	textFilterEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "transcriptMode" })
	transcriptMode!:CommandAttr<TranscriptMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onScrollChange" })
	onScrollChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onScrollStateChange" })
	onScrollStateChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onItemClick" })
	onItemClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onItemLongClick" })
	onItemLongClick!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "listSelector" })
	listSelector!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "listheader" })
	listheader!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "listfooter" })
	listfooter!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.divider = undefined;
		this.dividerHeight = undefined;
		this.footerDividersEnabled = undefined;
		this.headerDividersEnabled = undefined;
		this.cacheColorHint = undefined;
		this.choiceMode = undefined;
		this.drawSelectorOnTop = undefined;
		this.fastScrollEnabled = undefined;
		this.scrollingCache = undefined;
		this.smoothScrollbar = undefined;
		this.stackFromBottom = undefined;
		this.textFilterEnabled = undefined;
		this.transcriptMode = undefined;
		this.onScrollChange = undefined;
		this.onScrollStateChange = undefined;
		this.onItemClick = undefined;
		this.onItemLongClick = undefined;
		this.listSelector = undefined;
		this.listheader = undefined;
		this.listfooter = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
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
		

	public tryGetCacheColorHint() : T {
		this.resetIfRequired();
		if (this.cacheColorHint == null || this.cacheColorHint == undefined) {
			this.cacheColorHint = new CommandAttr<string>()
		}
		
		this.cacheColorHint.setGetter(true);
		this.orderGet++;
		this.cacheColorHint.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getCacheColorHint() : string {
		if (this.cacheColorHint == null || this.cacheColorHint == undefined) {
			this.cacheColorHint = new CommandAttr<string>();
		}
		return this.cacheColorHint.getCommandReturnValue();
	}
	public setCacheColorHint(value : string) : T {
		this.resetIfRequired();
		if (this.cacheColorHint == null || this.cacheColorHint == undefined) {
			this.cacheColorHint = new CommandAttr<string>();
		}
		
		this.cacheColorHint.setSetter(true);
		this.cacheColorHint.setValue(value);
		this.orderSet++;
		this.cacheColorHint.setOrderSet(this.orderSet);
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
		

	public setDrawSelectorOnTop(value : boolean) : T {
		this.resetIfRequired();
		if (this.drawSelectorOnTop == null || this.drawSelectorOnTop == undefined) {
			this.drawSelectorOnTop = new CommandAttr<boolean>();
		}
		
		this.drawSelectorOnTop.setSetter(true);
		this.drawSelectorOnTop.setValue(value);
		this.orderSet++;
		this.drawSelectorOnTop.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetFastScrollEnabled() : T {
		this.resetIfRequired();
		if (this.fastScrollEnabled == null || this.fastScrollEnabled == undefined) {
			this.fastScrollEnabled = new CommandAttr<boolean>()
		}
		
		this.fastScrollEnabled.setGetter(true);
		this.orderGet++;
		this.fastScrollEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isFastScrollEnabled() : boolean {
		if (this.fastScrollEnabled == null || this.fastScrollEnabled == undefined) {
			this.fastScrollEnabled = new CommandAttr<boolean>();
		}
		return this.fastScrollEnabled.getCommandReturnValue();
	}
	public setFastScrollEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.fastScrollEnabled == null || this.fastScrollEnabled == undefined) {
			this.fastScrollEnabled = new CommandAttr<boolean>();
		}
		
		this.fastScrollEnabled.setSetter(true);
		this.fastScrollEnabled.setValue(value);
		this.orderSet++;
		this.fastScrollEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetScrollingCache() : T {
		this.resetIfRequired();
		if (this.scrollingCache == null || this.scrollingCache == undefined) {
			this.scrollingCache = new CommandAttr<boolean>()
		}
		
		this.scrollingCache.setGetter(true);
		this.orderGet++;
		this.scrollingCache.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isScrollingCache() : boolean {
		if (this.scrollingCache == null || this.scrollingCache == undefined) {
			this.scrollingCache = new CommandAttr<boolean>();
		}
		return this.scrollingCache.getCommandReturnValue();
	}
	public setScrollingCache(value : boolean) : T {
		this.resetIfRequired();
		if (this.scrollingCache == null || this.scrollingCache == undefined) {
			this.scrollingCache = new CommandAttr<boolean>();
		}
		
		this.scrollingCache.setSetter(true);
		this.scrollingCache.setValue(value);
		this.orderSet++;
		this.scrollingCache.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetSmoothScrollbar() : T {
		this.resetIfRequired();
		if (this.smoothScrollbar == null || this.smoothScrollbar == undefined) {
			this.smoothScrollbar = new CommandAttr<boolean>()
		}
		
		this.smoothScrollbar.setGetter(true);
		this.orderGet++;
		this.smoothScrollbar.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isSmoothScrollbar() : boolean {
		if (this.smoothScrollbar == null || this.smoothScrollbar == undefined) {
			this.smoothScrollbar = new CommandAttr<boolean>();
		}
		return this.smoothScrollbar.getCommandReturnValue();
	}
	public setSmoothScrollbar(value : boolean) : T {
		this.resetIfRequired();
		if (this.smoothScrollbar == null || this.smoothScrollbar == undefined) {
			this.smoothScrollbar = new CommandAttr<boolean>();
		}
		
		this.smoothScrollbar.setSetter(true);
		this.smoothScrollbar.setValue(value);
		this.orderSet++;
		this.smoothScrollbar.setOrderSet(this.orderSet);
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
		

	public tryGetTextFilterEnabled() : T {
		this.resetIfRequired();
		if (this.textFilterEnabled == null || this.textFilterEnabled == undefined) {
			this.textFilterEnabled = new CommandAttr<boolean>()
		}
		
		this.textFilterEnabled.setGetter(true);
		this.orderGet++;
		this.textFilterEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isTextFilterEnabled() : boolean {
		if (this.textFilterEnabled == null || this.textFilterEnabled == undefined) {
			this.textFilterEnabled = new CommandAttr<boolean>();
		}
		return this.textFilterEnabled.getCommandReturnValue();
	}
	public setTextFilterEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.textFilterEnabled == null || this.textFilterEnabled == undefined) {
			this.textFilterEnabled = new CommandAttr<boolean>();
		}
		
		this.textFilterEnabled.setSetter(true);
		this.textFilterEnabled.setValue(value);
		this.orderSet++;
		this.textFilterEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetTranscriptMode() : T {
		this.resetIfRequired();
		if (this.transcriptMode == null || this.transcriptMode == undefined) {
			this.transcriptMode = new CommandAttr<TranscriptMode>()
		}
		
		this.transcriptMode.setGetter(true);
		this.orderGet++;
		this.transcriptMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getTranscriptMode() : TranscriptMode {
		if (this.transcriptMode == null || this.transcriptMode == undefined) {
			this.transcriptMode = new CommandAttr<TranscriptMode>();
		}
		return this.transcriptMode.getCommandReturnValue();
	}
	public setTranscriptMode(value : TranscriptMode) : T {
		this.resetIfRequired();
		if (this.transcriptMode == null || this.transcriptMode == undefined) {
			this.transcriptMode = new CommandAttr<TranscriptMode>();
		}
		
		this.transcriptMode.setSetter(true);
		this.transcriptMode.setValue(value);
		this.orderSet++;
		this.transcriptMode.setOrderSet(this.orderSet);
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
		

	public setOnScrollStateChange(value : string) : T {
		this.resetIfRequired();
		if (this.onScrollStateChange == null || this.onScrollStateChange == undefined) {
			this.onScrollStateChange = new CommandAttr<string>();
		}
		
		this.onScrollStateChange.setSetter(true);
		this.onScrollStateChange.setValue(value);
		this.orderSet++;
		this.onScrollStateChange.setOrderSet(this.orderSet);
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
export interface OnScrollChangeEvent extends Event{
        //view:AbsListView;

	        firstVisibleItem:number;
	        visibleItemCount:number;
	        totalItemCount:number;

}
export interface OnScrollStateChangeEvent extends Event{
        //view:AbsListView;

	        scrollState:number;

}
export interface OnClickEvent extends Event{
        //v:View;


}
export interface OnItemClickEvent extends Event{
        //parent:AdapterView<?>;

        //view:View;

	        position:number;
	        idInt:number;

}
export interface OnItemLongClickEvent extends Event{
        //parent:AdapterView<?>;

        //view:View;

	        position:number;
	        idInt:number;

}
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
