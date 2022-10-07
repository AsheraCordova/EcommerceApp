import { plainToInstance } from "class-transformer";

export default (config: any): any => {
    return (
        target: any,
        propertyKey: string,
        descriptor: PropertyDescriptor,
    ) => {
        // save a reference to the original method
        const originalMethod = descriptor.value;
        // rewrite original method with custom wrapper
        descriptor.value = async function(...args: any[])  {
            args[0] = plainToInstance(config, args[0]);
            const result = await originalMethod.apply(this, args);
            return result;
        }

        return descriptor;
    }
}