package com.yulin.proxy.dynamic;

/**
 * 委托类
 * */
public class RealSubject implements Subject {

    @Override
    public void sell() {
        System.out.println("in sell method");
    }

    @Override
    public void print(String msg) {
        System.out.println("print method " + msg);
    }

}
