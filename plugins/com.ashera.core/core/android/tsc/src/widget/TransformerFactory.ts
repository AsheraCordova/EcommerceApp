import CommandAttr from './CommandAttr';
import {Transformer} from './Transformer';

export class TransformerFactory {
    private static registrationMap: Map<string, ITranform> = new Map<string, ITranform>();
    private static transformerFactory:TransformerFactory = new TransformerFactory();
    constructor() {
        Transformer.registerDefaultTransformers(TransformerFactory.registrationMap);   
    }

    public static getInstance() : TransformerFactory{     
        return TransformerFactory.transformerFactory;
    }

    register(key:string, transform:ITranform) {
        TransformerFactory.registrationMap.set(key, transform);
    }

    transform(value: any, obj: any, type: any, transformer:any) : any {
        
        let key: string = transformer;

        if (key != null) {
            let transformer = TransformerFactory.registrationMap.get(key) as ITranform;
            return transformer.transform(value, obj, type);
        }

        return value;
    }
}

export interface ITranform {
    transform(value: any, obj: CommandAttr<any>, type: any) : any;
}