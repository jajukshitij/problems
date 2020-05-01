/*
    Problem: Leetcode.54 Spiral Matrix (Medium)
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    Example 1:
    Input:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    Output: [1,2,3,6,9,8,7,4,5]
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=3joo9yAZVh8
    -----------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n * m) -----------------------------------------------------
    --------------------------------------------------- Space Complexity: O(n * m) ----------------------------------------------------
                                                                          To store result
*/

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralMatrix(int[][] matrix){
    
        List<Integer> result = new ArrayList<>();

        if(matrix==null || matrix.length==0){
            return result;
        }
        
        int rowBegin =0;
        int rowEnd = matrix.length -1;
        int colBegin =0;
        int colEnd = matrix[0].length-1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){

            for(int i = colBegin; i <= colEnd; i++){
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for(int i = rowBegin; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]);
                }
            }
            colBegin++;

        }

        return result;
    }
    
    public static void main(String args[]){
        int[][] matrix = {  {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9,10,11,12}};
        System.out.println(spiralMatrix(matrix));
    }
    
}
