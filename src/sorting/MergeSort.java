package sorting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by bhuvan on 25/12/14.
 */
public class MergeSort {
    public static List<Integer> mergeSort(List<Integer> array){
        return mergeSort(array, 0, array.size()-1);
    }
    public static List<Integer> mergeSort(List<Integer> array, int min, int max){
        if(max == min){
            return null;
        }
        int mid = (max+min)/2;
        mergeSort(array,min, mid);
        mergeSort(array,mid+1,max);
        return merge(array,min,mid,max);
    }
    public static List<Integer> merge(List<Integer>array, int min, int mid, int max ){
        List<Integer> newList = new ArrayList<Integer>(array);
        //Copy numbers from array into new list whose index < min and whose index is greater than max
        int leftPtr = min;
        int rightPtr = mid+1;
        for(int i=0;i<min;i++){
            newList.set(i,array.get(i));
        }
        for(int i=max+1;i<array.size();i++){
            newList.set(i,array.get(i));
        }
        int i;
        for(i=0;(i< max - min) && (leftPtr<=mid) && (rightPtr<=max);i++){
            if (array.get(leftPtr)<array.get(rightPtr)){
                newList.set(min+i,array.get(leftPtr));
                leftPtr++;
            } else {
                newList.set(min + i, array.get(rightPtr));
                rightPtr++;
            }
        }
        if (leftPtr > mid){
            while(rightPtr <= max){
                newList.set(min+i, array.get(rightPtr));
                i++;
                rightPtr++;
            }
        } else {
            while(leftPtr <= mid) {
                newList.set(min+i, array.get(leftPtr));
                i++;
                leftPtr++;
            }
        }
        Collections.copy(array,newList);
        array = new ArrayList<Integer>(newList);
        return array;
    }
}
