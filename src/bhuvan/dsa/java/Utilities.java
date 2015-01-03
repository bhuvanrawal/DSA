package bhuvan.dsa.java;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import bhuvan.dsa.java.sorting.*;
/**
 * Created by bhuvan on 27/12/14.
 */
public class Utilities {
    public List giveArrayList(){
        Random r = new Random();
        List<Integer> newList = new ArrayList<Integer>();
        for (int i=0; i<100; i++){
            newList.add(r.nextInt());
        }
        return newList;
    }
    public static int quickSelect(List arrayList, int index){
        return quickSelect(arrayList, index, 0, arrayList.size());
    }
    public static int quickSelect(List<Integer> arrayList, int index, int start, int end){
        int pos = QuickSort.partition(arrayList,start,end);
        if (pos == index){
            return arrayList.get(pos);
        } else if (pos > index){
            // Need to check only left hand side of the array
            return quickSelect(arrayList, index, start, pos);
        } else {
            // Need to check only right side of the array
            return quickSelect(arrayList, index, pos+1, end);
        }
    }
}
