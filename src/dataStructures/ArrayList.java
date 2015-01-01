package dataStructures;

import java.util.*;

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
     * http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
     * Given an array A[] and a number x, check for pair in A[] with sum as x
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
     * http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
     * Given an array A[] and a number x, check for pair in A[] with sum as x
     * @param arrayList
     * @param result
     * @return
     */
    public static boolean doesSumAplusBExistInArrayHashmap(List<Integer> arrayList, int result) {
        Map<Integer,Integer> hashtable= new Hashtable<>();
        for (int i : arrayList){
            hashtable.put(arrayList.get(i),0);
        }
        for (int i : arrayList){
            if (hashtable.containsKey(result - arrayList.get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
     * Find the Number Occurring Odd Number of Times
     * @param arrayList
     * @return
     */
    public static int findNumberOccuringOddTimes(List<Integer> arrayList){
        int xor=0;
        for (int i: arrayList){
            xor = i^xor;
        }
        return xor;
    }
}