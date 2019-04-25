package com.yulin.proxy.dynamic;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        // 创建被委托类对象
        RealSubject vendor = new RealSubject();
        // 创建中介类实例
        DynamicProxy inter = new DynamicProxy(vendor);
        // 加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        // 获取代理类实例sell
        // 动态生成代理类，代理类的方法由接口指定，代理类方法的调用由handler处理，handler中方法的处理由委托类处理
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[] {Subject.class}, inter);

        // 通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        proxySubject.sell();
        proxySubject.print("this is message");
    }

}
