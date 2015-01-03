package bhuvan.dsa.java.sorting;
import java.util.List;

/**
 * Created by bhuvan on 25/12/14.
 */
public class QuickSort {
    public static void quickSort(List<Integer>array){
        quickSort(array,0,array.size()-1);
    }
    public static void quickSort(List<Integer> array, int start, int end){
        if(start >= end)
            return;
        int pos = partition(array, start, end);
        quickSort(array,0, pos-1);
        quickSort(array, pos + 1, end);
    }
    public static int partition(List<Integer> array, int start, int end){
        int pivot = array.get(start);
        int i = start + 1;
        int j = end;
        boolean swapped = false;
        while (i < j) {
            swapped = true;
            while (true) {
                if (array.get(i) > pivot && i <= end) {
                    i--;
                    break;
                } else {
                    i++;
                    continue;
                }
            }
            while (true) {
                if (array.get(j) < pivot || j == i) {
                    break;
                } else {
                    j--;
                    continue;
                }
            }
            // Swapping the values at i & j
            int temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
        if (swapped){
            // finally swapping the values at i & start
            array.set(start, array.get(i));
            array.set(i, pivot);
            return i;
        } else {
            return start;
        }
    }
}
