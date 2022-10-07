
export class Intent {
    data: any = {};
	put(key: string, value: any) {
		this.data[key] = value;
	}
	
	putJSONString(key: string, jsonStr: string) {
		this.data[key] = JSON.parse(jsonStr);
	}
	
	get(key: string) : any{
		return this.data[key];
	}
	
	getObject() {
		return this.data;
	}
}