package sorting;
import java.util.List;

/**
 * Created by bhuvan on 25/12/14.
 */
public class BubbleSort {
    /**
     * This  method sorts by bubbleSort logic, if no swapping is there in the first
     * iteration of the outer loop then it means the array is already sorted
     * Worst case Complexity is of O(n^2), best case O(n)
     * takes in a list of unsorted integers
     * @param array
     */
    public static void sort(List<Integer> array){
        int i = 0;
        //initiliazing j to the last element
        int lastPtr = array.size() -1;
        boolean isSwapped = false;
        do {
            isSwapped = false;
            for (i = 0; i < lastPtr; i++){
                if (array.get(i)>array.get(i+1)){
                    int tmp = array.get(i);
                    array.set(i,array.get(i+1));
                    array.set(i+1, tmp);
                    // Since we have swapped an element we need to run the
                    // outer loop once again
                    isSwapped = true;
                }

            }
            // the last element is put in its place so it need
            // not be considered in further iterations decrement j
            lastPtr--;
        } while (isSwapped);

    }
}
