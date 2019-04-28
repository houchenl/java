package com.yulin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用@interface定义注解，就像定义类和接口一样
 * 注解类似于标签
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyTypeAnnotation {

    int id() default -1;

    String msg() default "MyTypeAnnotation";

    String value() default "";

}
