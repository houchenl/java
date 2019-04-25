package com.yulin.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 中介类
 * */
public class DynamicProxy implements InvocationHandler {

    // 中介类通过聚合方式持有委托类对象，subject为委托类对象
    // 外部对代理类对象的调用转化为对invoke的调用，invoke内再调委托类对象
    // 中介类与委托类构成了静态代理关系，在这里，中介类就是代理类，委托类就是委托类
    private Object subject;

    public DynamicProxy(Object obj) {
        this.subject = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(subject, args);
        System.out.println("after");
        return result;    // 可以返回 null
    }

}
