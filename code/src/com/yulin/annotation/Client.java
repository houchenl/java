package com.yulin.annotation;

/**
 * 将TestAnnotation这个"标签"贴在Test类上
 * */
@MyTypeAnnotation
public class Client {

    @MyFieldAnnotation("phoenix")
    public String name;

    @MyMethodAnnotation(content = "call method print()")
    public String print() {
        return "";
    }

}
