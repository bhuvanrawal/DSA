package bhuvan.dsa.java.searching;

import java.util.List;

/**
 * Created by bhuvan on 2/6/15.
 */
public class InterpolationSearch {
    /**
     * http://en.wikipedia.org/wiki/Interpolation_search
     * http://www.geeksforgeeks.org/g-fact-84/
     * Interpolation search works better than Binary Search for
     * a sorted and uniformly distributed array.
     * On average the interpolation search makes about log(log(n)) 
     * comparisons (if the elements are uniformly distributed), 
     * where n is the number of elements to be searched. 
     * In the worst case (for instance where the numerical values of the keys 
     * increase exponentially) it can make up to O(n) comparisons.
     * @param sortedArray
     */
    public static int interpolationSearch(List<Integer> sortedArray, int toFind){
        int low =0;
        int high = sortedArray.size()-1;
        int mid;
        while (toFind >= sortedArray.get(low) && sortedArray.get(high)>=toFind){
            mid = low + ((toFind - sortedArray.get(low)) * (high -low)) / 
                    (sortedArray.get(high) - sortedArray.get(low));
            if (sortedArray.get(mid) < toFind){
                low = mid + 1;                
            } else if (sortedArray.get(mid)> toFind){
                high = mid -1;                
            } else {
                return mid;
            }
        }
        if (sortedArray.get(low) == toFind){
            return low;            
        } else {
            return -1;
        }
    }
}