package com.yulin.algorithm.other;

/**
 * 求两个整数的最大公约数
 * */
public class MaximumCommonDivisor {

    public static int mcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return mcd(q, r);
    }

}
