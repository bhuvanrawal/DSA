package bhuvan.dsa.java.sorting;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhuvan on 25/12/14.
 */
public class CountSort {

    /**
     * This method counts the occourances of a specific integer in the array and puts it into
     * the original list.
     * Time Complexity - O(n)
     * Limitation: works only if the range is fixed (Say characters)
     * @param array
     */
    public static void countSort(List<Integer> array){
        // Assuming that the range of characters is 256
        List<Integer> list = new ArrayList<Integer>(256);
        int i = 0;
        // Initialising the new list which will count the frequency of integers
        while(i < 256){
            list.add(i, 0);
            i++;
        }
        // Increment the frequency of the integer found
        for (i=0;i<array.size();i++){
            list.set(array.get(i), list.get(array.get(i)) + 1);
        }
        int j = 0;
        // Place the integers back into the original list
        for (i=0; i< array.size() ;j++){
            // count the occurance of the particular index (j) in the new list
            for(;j< array.size();j++) {
                if(list.get(j)!=0) {
                    break;
                }
            }
            // put the integer into the original list as many times as its frequency
            for(int k=list.get(j);k>0;k--){
                array.set(i,j);
                i++;
            }
        }
    }
}
