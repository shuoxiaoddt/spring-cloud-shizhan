package com.shizhan.springcloud.base.basegrammer.testimport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xiaos 2019/2/18
 * //TODO 写点注释吧
 */
public class MyServiceProxy implements InvocationHandler {

    private Object service;

    MyServiceProxy(Object service){
        this.service = service;
    }

    public Object newInstance(){
        return Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("equals".equals(method.getName())) {
            try {
                Object
                        otherHandler =
                        args.length > 0 && args[0] != null ? Proxy.getInvocationHandler(args[0]) : null;
                return equals(otherHandler);
            } catch (IllegalArgumentException e) {
                return false;
            }
        } else if ("hashCode".equals(method.getName())) {
            return hashCode();
        } else if ("toString".equals(method.getName())) {
            return toString();
        }
        System.err.println("proxy obj : "+ args[0]);
        return method.invoke(service,args);
    }
}
