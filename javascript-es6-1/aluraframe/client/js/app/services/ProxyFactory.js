// aluraframe/client/js/app/services/ProxyFactory.js

class ProxyFactory {

    static create(obj, props, action) {
        
        return new Proxy(obj, {

            get(target, prop, receiver) {

                if(props.includes(prop) && ProxyFactory._ehFuncao(target[prop])) {

                    return function() {

                        let result = Reflect.apply(target[prop], target, arguments);
                        action(target);
                        return result;
                    }
                }
                return Reflect.get(target, prop, receiver);
            },

            set(target, prop, value, receiver) {

                let result = Reflect.set(target, prop, value, receiver);
                if(props.includes(prop)) action(target);
                return result;
            }
        })
    }

    static _ehFuncao(prop) {
        return typeof(prop) == typeof(Function);
    }
}