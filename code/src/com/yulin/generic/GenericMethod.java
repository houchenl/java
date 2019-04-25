package com.yulin.generic;

/**
 * 泛型方法
 * 在调用时可以接受不同类型的参数
 *
 * 1. 泛型方法声明部分有一个类型参数声明部分(尖括号包裹)，在方法返回类型之前
 * 2. 类型参数声明部分包含一个或多个类型参数，参数间由逗号隔开
 * 3. 类型参数可以用来声明方法返回值类型
 * 4. 类型参数只能是引用型类型，不能是原始类型(如int/double/char)
 * */
public class GenericMethod {

    private static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * 有界类型参数
     * 有时需要限制被允许传递到类型参数的类型种类范围，如比较数字大小时只希望接受Number或其子类
     * 声明有界面类型参数时，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界
     * */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }

    public static void main(String[] args) {
        // 使用引用类型声明数组
//        Integer[] intArray = {1, 2, 3, 4, 5};
//        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
//        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
//
//        printArray(intArray);
//        printArray(doubleArray);
//        printArray(charArray);

        System.out.println(maximum(3, 4, 5));
        System.out.println(maximum(6.6, 8.8, 7.7));
        System.out.println(maximum("pear", "apple", "orange"));
    }

}
