package com.yulin.proxy.fixed;

/**
 * 委托类，实现了接口
 * */
public class RealSubject implements Subject {

    @Override
    public void sell() {
        System.out.println("in sell method");
    }

    @Override
    public void print(String msg) {
        System.out.println("in print method, msg " + msg);
    }

}
