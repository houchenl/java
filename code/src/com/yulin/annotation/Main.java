package com.yulin.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        boolean isAnnotationPresent = Client.class.isAnnotationPresent(MyTypeAnnotation.class);
        System.out.println("isAnnotationPresent " + isAnnotationPresent);

        if (isAnnotationPresent) {
            MyTypeAnnotation annotation = Client.class.getAnnotation(MyTypeAnnotation.class);
            int id = annotation.id();
            String msg = annotation.msg();
            System.out.println("id " + id + ", msg " + msg);
        }

        try {
            Field a = Client.class.getField("name");
            a.setAccessible(true);
            MyFieldAnnotation annotation = a.getAnnotation(MyFieldAnnotation.class);
            if (annotation != null) {
                String name = annotation.value();
                System.out.println("name is " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Method m = Client.class.getDeclaredMethod("print");
            if (m != null) {
                MyMethodAnnotation annotation = m.getAnnotation(MyMethodAnnotation.class);
                Annotation[] annotations = m.getAnnotations();
                if (null != annotation) {
                    String content = annotation.content();
                    System.out.println("content is " + content);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
