package com.yulin.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型通配符
 *
 * 如果想接收多种数据类型的数据作为参数，但不使用参数类型，此时，不在乎数据类型是什么，使用类型通配符`?`
 * */
public class TypeWildCard {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();

        name.add("icon");
        age.add(18);
        number.add(222341);

        printData(name);
        printData(age);
        printData(number);
    }

    private static void printData(List<?> data) {
        System.out.println(data.get(0));
    }

}
