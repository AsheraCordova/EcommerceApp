import {TransformerFactory, ITranform} from './TransformerFactory';
import CommandAttr from './CommandAttr';
import {Gravity} from './TypeConstants';
export class Transformer {
    constructor() {
        
    }
    static registerDefaultTransformers(regMap:Map<string, ITranform>) {
        regMap.set('gravity', new GravityTransformer());
    }
} 


class GravityTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let gravityArr:Array<Gravity> = new Array<Gravity>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
                    case "top":
                        gravityArr.push(Gravity.top);
                        break;
                    case "bottom":
                        gravityArr.push(Gravity.bottom);
                        break;
                    case "start":
                        gravityArr.push(Gravity.start);
                        break;
                    case "end":
                        gravityArr.push(Gravity.end);
                        break;
                    case "right":
                        gravityArr.push(Gravity.right);
                        break;
                    case "left":
                        gravityArr.push(Gravity.left);
                        break;                        
                    case "center_horizontal":
                        gravityArr.push(Gravity.center_horizontal);
                        break;
                    case "center_vertical":
                        gravityArr.push(Gravity.center_vertical);
                        break;
                    case "center":
                        gravityArr.push(Gravity.center);
                        break;
                    case "clip_vertical":
                        gravityArr.push(Gravity.clip_vertical);
                        break; 
                    case "center_horizontal":
                        gravityArr.push(Gravity.center_horizontal);
                        break;    
                }
                
            }
            return gravityArr;
        }
    }
}