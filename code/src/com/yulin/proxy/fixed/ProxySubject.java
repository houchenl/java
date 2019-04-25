package com.yulin.proxy.fixed;

/**
 * 静态代理类
 * 也实现了接口，但接口方法和实现是调用了委托类的实现
 * 静态代理类在方法中对委托类的实现进行了增强，甚至过滤
 * */
public class ProxySubject implements Subject {

    private Subject subject;  // 代理类通过聚合持有委托类实现对象的引用

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void sell() {
        System.out.println("before");
        subject.sell();    // 代理类中调用委托类的实现
        System.out.println("after");
    }

    @Override
    public void print(String msg) {
        System.out.println("before");
        subject.print(msg);    // 代理类中调用委托类的实现
        System.out.println("after");
    }

}
