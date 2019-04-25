package com.yulin.proxy.fixed;

public class Client {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();  // 事先已存在的委托类对象

        ProxySubject proxySubject = new ProxySubject(realSubject);  // 创建代理类，传入已存在的委托类对象
        proxySubject.sell();  // 调用代理类方法，代理类中调用委托类对象相关方法实现服务
        proxySubject.print("this is message");
    }

}
