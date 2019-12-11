package com.lcb.ds.array;

/**
 * 类BinarySearch.java的实现描述：TODO 类实现描述
 *
 * @author zhaoxiaoliang 2019年12月9日 下午8:20:13
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15 };

        System.out.println("" + f(5, array));

        System.out.println("" + f(5, array, 0, array.length - 1));
    }

    public static int f(int a, int[] array) {
        int result = -1;

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("mid->" + mid);

            if (array[mid] > a) {
                end = mid - 1;
            } else if (array[mid] < a) {
                start = mid + 1;
            } else {
                result = mid;
                break;
            }
        }

        return result;
    }

    public static int f(int a, int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        System.out.println("mid->" + mid);

        if (array[mid] > a) {
            return f(a, array, start, mid - 1);
        }
        if (array[mid] < a) {
            return f(a, array, mid + 1, end);
        }

        return mid;
    }
}
