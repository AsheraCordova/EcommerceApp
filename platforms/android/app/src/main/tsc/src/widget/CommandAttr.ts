import {Transform, Type} from "class-transformer";
import 'babel-polyfill';
import {TransformerFactory} from "./TransformerFactory";

export default class CommandAttr<T> {
    @Transform(({value, obj, type}) => TransformerFactory.getInstance().transform(value, obj, type, obj.transformer))
    private value!: T;
    private commandReturnValue!: T;
	private setter: boolean = false;
    private getter: boolean = false;
    private transformer!: string;
    public type: string = "attribute";
    private orderGet: number = 0;
    private orderSet: number = 0;
    private childPath!: string;

	public getChildPath(): string {
		return this.childPath;
	}

	public setChildPath(value: string) {
		this.childPath = value;
    }

	public getOrderSet(): number {
		return this.orderGet;
	}

	public setOrderSet(value: number) {
		this.orderSet = value;
    }
	public getOrderGet(): number {
		return this.orderGet;
	}

	public setOrderGet(value: number) {
		this.orderGet = value;
    }


	public getTransformer(): string {
		return this.transformer;
	}

	public setTransformer(value: string) {
		this.transformer = value;
    }
    
    /**
     * Getter value
     * @return {T}
     */
	public getCommandReturnValue(): T {
		return this.commandReturnValue;
	}

    /**
     * Setter value
     * @param {T} value
     */
	public setCommandReturnValue(value: T) {
		this.commandReturnValue = value;
	}

    /**
     * Getter value
     * @return {T}
     */
	public getValue(): T {
		return this.value;
	}

    /**
     * Getter set
     * @return {boolean}
     */
	public getSetter(): boolean {
		return this.setter;
	}

    /**
     * Getter get
     * @return {boolean}
     */
	public getGetter(): boolean {
		return this.getter;
	}
	
    /**
     * Setter value
     * @param {T} value
     */
	public setValue(value: T) {
		this.value = value;
	}

    /**
     * Setter set
     * @param {boolean} value
     */
	public setSetter(value: boolean) {
		this.setter = value;
	}

    /**
     * Setter get
     * @param {boolean} value
     */
	public setGetter(value: boolean) {
		this.getter = value;
	}
}