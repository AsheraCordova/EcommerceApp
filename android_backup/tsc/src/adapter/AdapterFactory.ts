import MockAdapter from './MockAdapter';
import Adapter from './Adapter';

export default class AdapterFactory {
    public static getInstance() : Adapter{
        return new MockAdapter();
    }
}