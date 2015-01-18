package bhuvan.dsa.java;

import java.util.*;

/**
 * Created by bhuvan on 8/1/15.
 */
public class DynamicProgramming {
    public int longestPalindromicSubsequenceNaive(List<Integer> arrayList){
        return longestPalindromicSubsequenceNaive(arrayList, 0,arrayList.size()-1);
    }
    public int longestPalindromicSubsequenceNaive(List<Integer> arrayList, int start, int end){
        if (start == end) {
            return 0;
        }
        if (arrayList.get(start) == arrayList.get(end)) {
            return 2 + longestPalindromicSubsequenceNaive(arrayList,start+1, end -1);
        } else {
            return Math.max(longestPalindromicSubsequenceNaive(arrayList, start+1,end),
                    longestPalindromicSubsequenceNaive(arrayList, start, end-1));
        }

    }
    /**
     * Reverse the list and apply longest Common Subsequence
     */
    /**
     * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
     * Largest Sum Contiguous Subarray
     * Algo: Keep two variables maxSoFar and maxTillHere
     * maxTillHere gets initialised to current element as soon as it gets negative.
     * maxSoFar will store the value of maxTillHere if its greater than its value.
     * @param arrayList
     * @return
     */
    public int largestContiguousSumSubarray(List<Integer> arrayList){
        int maxSoFar = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int curr_max = 0;
        for (int j=1; j<arrayList.size(); j++){
            curr_max = Math.max(arrayList.get(j), arrayList.get(j)+curr_max);
            maxSoFar = Math.max(maxSoFar,curr_max);
        }
        return maxSoFar;
    }
    /**
     * http://www.geeksforgeeks.org/ugly-numbers/
     * Ugly Numbers
     */
    /**
     * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
     * Maximum size square sub-matrix with all 1s
     */
    /**
     * http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
     *
     * Program for Fibonacci numbers
     */
    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
     * http://www.algorithmist.com/index.php/Longest_Increasing_Subsequence
     * Longest Increasing Subsequence
     */
    public static int longestIncreasingSubsequence(List<Integer> arrayList){
        int i,j;
        List<Integer> newList = new ArrayList<Integer>();
        int max;
        for (i=0;i<arrayList.size();i++){
            max =0;
            for (j=0;j<i;j++){
                if (arrayList.get(i)> arrayList.get(j)){
                    if (max< newList.get(j)){
                        max = newList.get(j);
                    }
                }
            }
            newList.set(i,max+1);

        }
        max =0;
        for (i =0 ;i<arrayList.size();i++){
            if (max < newList.get(i)){
                    max = newList.get(i);
            }
        }
        return max;
    }

    /**
     * the max index of both list is compared if they are equal call the same method with max1-1 & max2-1
     * else call the function twice with max1-1, max2 & max1, max2-1 and return maximum of these 2 calls
     * @param arrayList1
     * @param arrayList2
     */
    public static int longestCommonSubsequenceNaive(List<Integer> arrayList1,int max1, List<Integer> arrayList2, int max2){
        if (max1<0 || max2<0){
            return 0;
        }
        else {
            if (arrayList1.get(max1)==arrayList2.get(max2)){
                return 1 + longestCommonSubsequenceNaive(arrayList1, max1-1, arrayList2, max2-1);
            } else {
                return Math.max(longestCommonSubsequenceNaive(arrayList1, max1-1, arrayList2, max2-1),
                        longestCommonSubsequenceNaive(arrayList1, max1-1, arrayList2, max2-1));
            }
        }
    }

    public static int[][] longestCommonSubsequenceDP(List<Integer> arrayList1, List<Integer> arrayList2) {
        int[][] array = new int[arrayList1.size()][arrayList2.size()];
        for (int i=0; i<arrayList1.size();i++) {
            for (int j=0; j<arrayList2.size();j++) {
                if (i==0||j==0) {
                    array[i][j] =0;
                } else if (arrayList1.get(i) == arrayList2.get(j)){
                    array[i][j] = array[i-1][j-1]+1;
                } else {
                    array[i][j] = Math.max(array[i-1][j],array[i][j-1]);
                }
            }
        }
        return array;
    }

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
     * Given two strings of size m, n and set of operations replace (R), insert (I) and delete (D) all at equal cost.
     * Find minimum number of edits (operations) required to convert one string into another.
     * @param list1
     * @param list2
     * @return
     */
    public static int minimumEditDistance(List<Character> list1,int index1, List<Character> list2, int index2){
        int[][] array = new int[list1.size()][list2.size()];
        int temp;
        for (int i=0;i<list1.size();i++){
            for (int j=0;j<list2.size();j++) {
                if (i == 0){
                    array[0][j] = j;
                }else if (j==0) {
                        array[i][0] = i;
                } else {
                    if (list1.get(i) == list2.get(j)){
                        temp  = array[i-1][j-1];
                        array[i][j] = Math.min(Math.min(array[i-1][j]+1,array[i][j-1]+1),temp);
                    } else {
                        temp = array[i-1][j-1] +1;
                        array[i][j] = Math.min(Math.min(array[i-1][j]+1,array[i][j-1]+1),temp);
                    }
                }

            }

        }
        return array[list1.size()-1][list2.size()-1];
    }

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
     * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words.
     * This is a famous Google interview question, also being asked by many other companies now a days.
     * @param dictionary
     * @param array
     */
    public static void workBreakProblem(HashMap dictionary, char[] array){
        /**
         * Naive Algo is as follows:
         * we calculate all the substrings from i=0 to n if it exists in dictionary at j then we
         * recursively call the function on substring starting from j
         * Note we are doing repetitive calculations here
         */
            }

    /**
     * http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
     * Count Possible Decodings of a given Digit Sequence
     * @param array
     * @param n
     * @return
     */
    public static int countPossibleDecodings(char[] array, int n){
        int [] count = new int[n];
        count[0]=1;
        count[1]=1;
        if (n==0)
            return 1;

        for (int i=2 ; i<=n;i++) {
            count[i] = 0;
            /**
             * Now two cases are possible either that we  include previous 2 numbers in the current count
             * or only the last one in the current count
             */
            if (array[i-1]> '0')
                count[i] = count[i-1];

            if (array[i-2]<'2' || (array[i-2]=='2'&& array[i-1]<'7')) {
                count[i] += count[i-2];
            }
        }
        return count[n];
    }
}
