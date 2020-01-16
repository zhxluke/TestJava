package com.lcb.bit;

/**
 * 类BitOperation.java的实现描述：位运算
 *
 * @author zhaoxiaoliang 2020年1月15日 下午12:28:53
 */
public class BitOperation {

    public static void main(String[] agrs) {
        System.out.println("isOdd(m)=" + isOdd(2));
        System.out.println("find(array)=" + find(new int[] { 1, 2, 3, 1, 3 }));
        System.out.println("pow(m,n)=" + pow(2, 4));
        System.out.println("m^n=" + (2 ^ 3 ^ 2));

        // 相互赋值
        int x = 2;
        int y = 3;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x=" + x + " y=" + y);
        
        System.out.println("findN(n)=" + findN(19));

    }

    /**
     * n最大的2的幂指数
     * 
     * @param n
     * @return
     */
    public static int findN(int n) {
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;

        return (n + 1) >> 1;
    }

    /**
     * 判断是否为奇数
     * 
     * @param m
     * @return
     */
    public static boolean isOdd(int m) {
        return (m & 1) == 1;
    }

    /**
     * 数字出现1次
     * 
     * @param array
     * @return
     */
    public static int find(int[] array) {
        int tmp = array[0];
        for (int i = 1; i < array.length; i++) {
            tmp = tmp ^ array[i];
        }

        return tmp;
    }

    /**
     * m的n次方
     * 
     * @param m
     * @param n
     * @return
     */
    public static int pow(int m, int n) {
        int sum = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                sum *= m;
            }
            m *= m;
            n = n >> 1;
        }

        return sum;
    }
}
