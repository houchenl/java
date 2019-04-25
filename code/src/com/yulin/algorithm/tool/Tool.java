package com.yulin.algorithm.tool;

public class Tool {

    /**
     * 交换整形数组中序号为i和j的两个数
     *
     * i==j时，不必交换
     */
    public static void swap(int[] array, int i, int j) {
        if (i == j) return;

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 交换整形数组中序号为i和j的两个数
     *
     * 注意：如果i==j，使用这种方法交换，会导致i位置的数字变为0。所以当i==j时，必须停止交换
     */
    public static void swap2(int[] array, int i, int j) {
        if (i == j) return;

        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    /**
     * 返回待排序数组
     */
    public static int[] getUnSortIntArray() {
        return new int[]{3, 5, 1, 2, 7, 9, 4, 10, 22, 32, 17, 88, 31, 23};
    }

    /**
     * 打印数组
     */
    public static void printArray(int[] array) {
        if (null == array || array.length < 1) return;

        System.out.print("{");
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println("}");
    }

}
