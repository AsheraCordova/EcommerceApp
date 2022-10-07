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
export abstract class WebViewImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "loadUrl" })
	loadUrl_!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "initialScale" })
	initialScale!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "clearCache" })
	clearCache_!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onPageStarted" })
	onPageStarted!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onPageFinished" })
	onPageFinished!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onReceivedError" })
	onReceivedError!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.loadUrl_ = undefined;
		this.initialScale = undefined;
		this.clearCache_ = undefined;
		this.onPageStarted = undefined;
		this.onPageFinished = undefined;
		this.onReceivedError = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public loadUrl(value : string) : T {
		this.resetIfRequired();
		if (this.loadUrl_ == null || this.loadUrl_ == undefined) {
			this.loadUrl_ = new CommandAttr<string>();
		}
		
		this.loadUrl_.setSetter(true);
		this.loadUrl_.setValue(value);
		this.orderSet++;
		this.loadUrl_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setInitialScale(value : number) : T {
		this.resetIfRequired();
		if (this.initialScale == null || this.initialScale == undefined) {
			this.initialScale = new CommandAttr<number>();
		}
		
		this.initialScale.setSetter(true);
		this.initialScale.setValue(value);
		this.orderSet++;
		this.initialScale.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public clearCache(value : boolean) : T {
		this.resetIfRequired();
		if (this.clearCache_ == null || this.clearCache_ == undefined) {
			this.clearCache_ = new CommandAttr<boolean>();
		}
		
		this.clearCache_.setSetter(true);
		this.clearCache_.setValue(value);
		this.orderSet++;
		this.clearCache_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnPageStarted(value : string) : T {
		this.resetIfRequired();
		if (this.onPageStarted == null || this.onPageStarted == undefined) {
			this.onPageStarted = new CommandAttr<string>();
		}
		
		this.onPageStarted.setSetter(true);
		this.onPageStarted.setValue(value);
		this.orderSet++;
		this.onPageStarted.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnPageFinished(value : string) : T {
		this.resetIfRequired();
		if (this.onPageFinished == null || this.onPageFinished == undefined) {
			this.onPageFinished = new CommandAttr<string>();
		}
		
		this.onPageFinished.setSetter(true);
		this.onPageFinished.setValue(value);
		this.orderSet++;
		this.onPageFinished.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnReceivedError(value : string) : T {
		this.resetIfRequired();
		if (this.onReceivedError == null || this.onReceivedError == undefined) {
			this.onReceivedError = new CommandAttr<string>();
		}
		
		this.onReceivedError.setSetter(true);
		this.onReceivedError.setValue(value);
		this.orderSet++;
		this.onReceivedError.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class WebView extends WebViewImpl<WebView> implements IWidget{
    getThisPointer(): WebView {
        return this;
    }
    
   	public getClass() {
		return WebView;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

WebViewImpl.initialize();
export interface OnPageStartedEvent extends Event{
        //view:View;


}
export interface OnPageFinishedEvent extends Event{
        //view:View;


}
export interface OnReceivedErrorEvent extends Event{
        //view:View;

        //error:String;


}

//end - staticinit
