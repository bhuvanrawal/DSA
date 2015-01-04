package bhuvan.dsa.java.dataStructures;

import bhuvan.dsa.java.sorting.QuickSort;

import javax.swing.text.Utilities;
import java.util.List;

import java.util.*;
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
    public static int findNumberOccuringOddTimes(List<Integer> arrayList) {
        int xor = 0;
        for (int i : arrayList) {
            xor = i ^ xor;
        }
        return xor;
    }

    /**
     * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
     * Largest Sum Contiguous Subarray
     * Kadane’s Algorithm:
     * @param arrayList
     * @return
     */
    public static int largestContinuousSum(List<Integer> arrayList){
        int max_till_now=0;
        int max_ending_here=0;
        for (int i:arrayList){
            max_ending_here += max_ending_here + i;
            if (max_ending_here < 0)
                max_ending_here = 0;
            else if (max_ending_here >= max_till_now) {
                max_till_now = max_ending_here;
            }
        }
        return max_till_now;
    }

    /**
     * http://www.geeksforgeeks.org/find-the-missing-number/
     * Find the Missing Number
     * @param arrayList
     * @return
     */
    public static int findTheMissingNumber(List<Integer> arrayList){
        int sum =0;
        for (int i:arrayList){
            sum += i;
        }
        return (arrayList.size()*(arrayList.size()-1)/2) - sum;
    }
    public static boolean searchInRotatedPivotedArray(List<Integer> arrayList, int number){
        int mid = arrayList.size()/2;
        int min = 0;
        int max = arrayList.size();
        while (true) {
            mid =( min +max)/2;
            if (arrayList.get(mid) == number)
            {
                return true;
            }
            else if (mid == max)
            {
                return false;
            } else if (number < arrayList.get(mid) && number > arrayList.get(min)){
                max = mid;
                mid = mid + max/2;
            }
        }
    }

    /**
     * http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
     * Merge an array of size n into another array of size m+n
     * @param bigArray
     * @param smallArray
     */
    public static void mergeTwoSortedArrays(int[] bigArray, int[] smallArray ){
        int bigLength = bigArray.length;
        int lastIndex = bigLength -1;
        for (int i = bigArray.length - 1; i>=0; i--){
            if (bigArray[i]!=-1){
                bigArray[lastIndex] = bigArray[i];
                lastIndex--;
            }
        }
        int i = lastIndex;
        int j = 0;
        int index = 0;
        while (true){
            if (j == smallArray.length) {
                // copy big array entirely
                while (i != bigLength){
                    bigArray[index] = bigArray[i];
                    i++;
                    index++;
                }
                break;
            } else if (i == bigLength) {
                // copy small array entirely
                while (j != smallArray.length){
                    bigArray[index] = smallArray[j];
                    j++;
                    index++;
                }
                break;
            } else {
                if (bigArray[i]>smallArray[j]){
                    bigArray[index] = bigArray[i];
                    i++;
                } else {
                    bigArray[index] = smallArray[j];
                    j++;
                }
                index++;
            }
        }

    }

    /**
     * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
     * Median of two sorted arrays
     * @param arrayList
     * @return
     */
    public static int median(List<Integer> arrayList){
        int middle = arrayList.size()/2;
        int start = 0;
        int end = arrayList.size()-1;
        int pos = QuickSort.partition(arrayList,start,end);
        while (true) {
            if (pos == middle)
                return arrayList.get(pos);
            else if (pos < middle) {

            }
        }
    }

    /**
     * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
     * Maximum sum such that no two elements are adjacent
     * @param arrayList
     * @return
     */
    public static int maxSumNoTwoNumAdjacent(List<Integer> arrayList) {
        int incl = 0;
        int excl = 0;
        int excl_new = 0;
        for (int i = 0; i<arrayList.size(); i++) {
            excl_new = incl>excl ? incl:excl;
            incl = excl + arrayList.get(i);
            excl = excl_new;
        }
        return Math.max(incl,excl);
    }

    /**
     * http://www.geeksforgeeks.org/leaders-in-an-array/
     * Leaders in an array
     * @param arrayList
     * @return
     */
    public static List<Integer> leaders(List<Integer> arrayList) {
        List newList = new java.util.ArrayList();
        int max = Integer.MIN_VALUE;
        for (int i = arrayList.size()-1; i>=0; i--) {
            if (arrayList.get(i) > max){
                max = arrayList.get(i);
                newList.add(max);
            }
        }
        return newList;
    }

    /**
     * http://www.geeksforgeeks.org/sort-elements-by-frequency/
     * Sort elements by frequency
     * @param arrayList
     * @return
     */
    public static List<Integer> sortFrequency (List<Integer> arrayList){
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i=0; i<arrayList.size(); i++) {
            if (frequencyMap.containsKey(arrayList.get(i))) {
                int temp = frequencyMap.get(arrayList.get(i));
                frequencyMap.put(arrayList.get(i), temp++);
            } else {
                frequencyMap.put(arrayList.get(i), 1);
            }
        }
        int[][] array = new int[frequencyMap.size()][2];
        int j=0;
        for (int i: frequencyMap.keySet()) {
            array[j][0] = i;
            array[j][1] = frequencyMap.get(i);
            j++;
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        List finalList = new LinkedList();
        for (int i=0; i<array.length; i++) {
            int num = array[i][1];
            while (num --!=0){
                finalList.add(array[i][0]);
            }
        }
        return finalList;
    }

    /**
     * http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
     * Maximum difference between two elements such that larger element appears after the smaller number
     * @param arrayList
     * @return
     */
    public static int maxDiffBetweenTowNumbers(List<Integer> arrayList){
        int minTillNow=Integer.MAX_VALUE;
        int maxDIffrence=Integer.MIN_VALUE;
        for (int i = arrayList.size()-1;i>=0;i--) {
            if (arrayList.get(i)< minTillNow) {
                minTillNow = arrayList.get(i);
            }
            if (arrayList.get(i)-minTillNow>maxDIffrence){
                maxDIffrence = arrayList.get(i)-minTillNow;
            }
        }
        return maxDIffrence;
    }

    /**
     * http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
     * Union and Intersection of two sorted arrays
     * MergeSort merge logic, return a new list
     * @param list1
     * @param list2
     */
    public static void unionTwoLists(List list1, List list2){

    }

    /**
     * http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
     * Union and Intersection of two sorted arrays
     * @param list1
     * @param list2
     * @return
     */
    public static List<Integer> intersectionTwoLists(List<Integer> list1, List<Integer> list2){
        int i=0,j=0;
        List<Integer> newList = new LinkedList<>();
        for (;i<list1.size()&&j<list2.size();) {
            if (list1.get(i).equals( list2.get(j))){
                newList.add(list1.get(i));
            } else if (list1.get(i)>list2.get(j)){
                j++;
            } else {
                i++;
            }
        }
        return newList;
    }

    /**
     * http://www.geeksforgeeks.org/search-floor-and-ceil-in-a-sorted-array/
     * Floor and Ceiling in a sorted array
     * Use modified binary search in the last iteration return the next and previous numbers
     * @param arrayList
     * @param x
     */
    public static void floorCeiling(List<Integer> arrayList, int x){
        int min = 0;
        int max = arrayList.size()-1;
        int mid = (min +max)/2;
        boolean flag = false;
        while ((mid < max) && (mid > min)){
            if (arrayList.get(mid) > x){
                max = mid;
            } else if (arrayList.get(mid) < x){
                min = mid;
            } else {
                flag = true;
                // Number found
                // execute logic
                break;
            }
            mid = (mid +max) /2;
        }
        if (!flag){
            System.out.println("Floor: "+arrayList.get(mid)+ "\n Ceil:"+ arrayList.get(mid+1));
        }
    }

    /**
     * http://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
     * Two elements whose sum is closest to zero
     * @param arrayList
     */
    public static void twoNumbersSumCloseToZero(List<Integer> arrayList){
        Collections.sort(arrayList);
        int i = 0,j = arrayList.get(arrayList.size()-1);
        int minSum = Integer.MAX_VALUE;
        while (i < j){
            if (Math.abs(arrayList.get(i)) == Math.abs(arrayList.get(j))) {
                System.out.println(0);
                return;
            } else if (Math.abs(arrayList.get(i)) < Math.abs(arrayList.get(j))) {
                if (Math.abs(arrayList.get(i)- arrayList.get(j))<Math.abs(minSum)) {
                    minSum = Math.abs(arrayList.get(i)- arrayList.get(j));
                }
                j++;
            } else if (Math.abs(arrayList.get(i)) > Math.abs(arrayList.get(j))) {
                if (Math.abs(arrayList.get(i)- arrayList.get(j))<Math.abs(minSum)) {
                    minSum = Math.abs(arrayList.get(i)- arrayList.get(j));
                }
                i++;
            }
        }
    }

    /**
     * http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
     * Segregate 0s and 1s in an array
     * @param arrayList
     */
    public static void segregate0sAnd1sInList(List<Integer> arrayList){
        int i =0, j=arrayList.size()-1;

        while (i < j){
            while (i<j && arrayList.get(i)==0) {
                i++;
            }
            while (j>i && arrayList.get(j)==1) {
                j--;
            }
            if (arrayList.get(i)==1 && arrayList.get(j)==0){
                // Swap list[i] & list[j]
                int temp = arrayList.remove(j);
                arrayList.add(i, arrayList.get(j));
                arrayList.add(j, temp);
            }
        }
    }

    /**
     * http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
     * k largest(or smallest) elements in an array | added Min Heap method
     * @param arrayList
     * @param k
     * @return
     */
    public static int kthLargestElement(List arrayList, int k){
        return bhuvan.dsa.java.Utilities.quickSelect(arrayList,k);
    }


}