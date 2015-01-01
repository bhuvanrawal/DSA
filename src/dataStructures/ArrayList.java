package dataStructures;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class created for different kind of questions asked on array in interviews.
 * Arrays will be replaced by arraylist in our implementation.
 */
public class ArrayList {
    /**
     * http://geeksquiz.com/c-program-find-sum-elements-given-array/
     * C Program to find sum of elements in a given array
     *
     * @param arrayList
     * @return
     */
    public static int sumOfElementsInArray(List<Integer> arrayList) {
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
        }
        return sum;
    }

    /**
     * http://geeksquiz.com/c-program-find-largest-element-array/
     * C program to find largest element in an array
     *
     * @param arrayList
     * @return
     */
    public static int largestElementInArray(List<Integer> arrayList) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arrayList.size(); i++) {
            if (max < arrayList.get(i)) {
                max = arrayList.get(i);
            }
        }
        return max;
    }

    /**
     * http://geeksquiz.com/c-program-multiply-two-matrices/
     * C program to multiply two matrices
     *
     * @param a input array 1
     * @param b input array 2
     * @param c result array
     */
    public static void multiplyTwoMatrices(int[][] a, int[][] b, int[][] c) {
        if (a.length != b.length) {
            System.out.println("Invalid Input");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                c[i][j] = 0;
                for (int k = 0; k < a.length; k++) {
                    c[i][j] += a[j][k] * b[k][j];
                }
            }
        }
    }

    /**
     * @param arrayList
     * @param result
     * @return
     */
    public static boolean doesSumAplusBExistInArraySorting(List<Integer> arrayList, int result) {
        Collections.sort(arrayList);
        int start = 0;
        int end = arrayList.size() - 1;
        while (start != end) {
            if (arrayList.get(start) + arrayList.get(end) == result) {
                return true;
            } else if (arrayList.get(start) + arrayList.get(end) > result) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    /**
     * @param arrayList
     * @param result
     * @return
     */
    public static boolean doesSumAplusBExistInArrayHashmap(List<Integer> arrayList, int result) {
        Map<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i : arrayList){
            hashmap.put()
        }
    }
}