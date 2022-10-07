export class ScopedObject {
	expression!: string | undefined;
	payload: any;	
	constructor(expression: string, payload: any);
	constructor();
	constructor(expression?: string, payload?: any) {
		this.expression = expression;
		this.payload = payload;
	}
}