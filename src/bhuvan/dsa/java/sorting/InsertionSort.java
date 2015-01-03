package bhuvan.dsa.java.sorting;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhuvan on 25/12/14.
 */
public class InsertionSort {
    /**
     *  This method sorts the list of integers by using insertion sort technique
     *  A new list is created which is maintained as sorted,
     *  the original list is created, the index of number is found in the sortedList and inserted there
     * @param unsortedList a list of unsorted integers
     * @return new list
     */
    public static List<Integer> insertionSort(final List<Integer> unsortedList){
        List<Integer> sortedList = new ArrayList<Integer>(unsortedList.size());
        int i=0;
        // For all the numbers in the unSorted list run this loop
        for(int number : unsortedList){

            if (i == 0){
                sortedList.add(number);
            } else {
                // If the number is greater than last number in the sorted list
                // simply insert it in the end
                if (sortedList.get(i-1) < number){
                    sortedList.add(i,number);
                }
                // else search for its position in the sortedList
                else {
                    for (int j=0;j < i;j++){
                        if (number < sortedList.get(j)){
                            sortedList.add(j,number);
                            break;
                        }
                    }
                }
            }
            i++;
        }
        return sortedList;
    }
}
