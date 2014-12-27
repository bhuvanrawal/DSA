package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bhuvan on 27/12/14.
 */
public class BinarySearch {
    public static boolean binarySearch(List<Integer> array,int number, int left, int right){
        if (left > right)
            return false;
        int mid = (left + right)/2;
        if (array.get(mid) == number){
            return true;
        } else if (array.get(mid) < number){
            return binarySearch(array, number, mid+1, right);
        } else {
           return binarySearch(array, number, left, mid-1);
        }
    }
    public static boolean binarySearch(List<Integer> array, int number){
        return binarySearch(array,number,0,array.size()-1);
    }
    public static void main(String [] args){
        Integer [] arr = new Integer[]{1,2,3,4,5};
        for (int a:arr)
        System.out.println(binarySearch(Arrays.asList(arr), a ));
    }
}
