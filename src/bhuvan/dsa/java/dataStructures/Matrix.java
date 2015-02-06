package bhuvan.dsa.java.dataStructures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bhuvan on 2/6/15.
 */
public class Matrix {
    /**
     *  http://www.geeksforgeeks.org/turn-an-image-by-90-degree/
     *  Turn an image by 90 degree
     * @param inputMatrix
     */
    public static void turnMatrix90Degree(int[][] inputMatrix){
        int[][] outputMatrix = new int[inputMatrix.length][inputMatrix.length];
        int k = inputMatrix.length -1;
        for (int i=0;i<inputMatrix.length; i++){
            List<Integer> linkedList = new LinkedList<Integer>();
            for (int j=0; j<inputMatrix.length; j++){
                linkedList.add(inputMatrix[i][j]);
            }
            for (int j=0;j<inputMatrix.length;j++) {
                outputMatrix[k][j] = linkedList.get(j);
            }
            k--;
        }
    }
}
