import {Fragment} from './app/Fragment';

export default class Index extends Fragment{
    constructor() {
        super();
    }
    
    public onCreate(obj:any) {
    	alert("If you receive this  alert, you are good to write your first program");
    }
}