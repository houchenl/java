package com.yulin.generic;

/**
 * 泛型类
 *
 * 泛型类的声明和普通类相似，除了在类后面添加参数类型声明
 * 多个参数类型之间用逗号分隔，参数类型如果限制类型范围使用extends关键字
 * */
public class GenericClass<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return this.t;
    }

    public static void main(String[] args) {
        GenericClass<Integer> integerBox = new GenericClass<>();
        GenericClass<String> stringBox = new GenericClass<>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("lesson"));

        System.out.println(integerBox.get());
        System.out.println(stringBox.get());
    }

}
