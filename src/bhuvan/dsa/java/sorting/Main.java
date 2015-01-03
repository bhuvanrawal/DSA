package bhuvan.dsa.java.sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bhuvan on 25/12/14.
 */
public class Main {
    // This is the driver method to test the Sorting methods
    public static void main(String [] args){
        Integer [] arr = {5,3,4,2,9};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        // new ArrayList<Integer>();
        List<Integer> testList = new ArrayList<Integer>(list);
        BubbleSort.sort(testList);
        System.out.println(testList);
        testList = new ArrayList<Integer>(list);
        System.out.println(InsertionSort.insertionSort(list));
        testList = new ArrayList<Integer>(list);
        QuickSort.quickSort(testList);
        System.out.println(testList);
        testList = new ArrayList<Integer>(list);
        CountSort.countSort(testList);
        System.out.println(testList);
        testList = new ArrayList<Integer>(list);
        System.out.println(MergeSort.mergeSort(testList));
        System.out.println(testList);
    }

}
