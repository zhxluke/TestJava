package com.lcb.ds.array;

/**
 * 类BinarySearch.java的实现描述：TODO 类实现描述
 *
 * @author zhaoxiaoliang 2019年12月9日 下午8:20:13
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15 };

        System.out.println("" + f(10, array));
    }

    public static int f(int a, int[] array) {
        int result = -1;

        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (array[mid] > a) {
                j = mid - 1;
            } else if (array[mid] < a) {
                i = mid + 1;
            } else {
                result = mid;
                break;
            }
        }

        return result;
    }
}
