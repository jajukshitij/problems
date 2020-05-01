/*
    Problem: Leetcode.48 Rotate Image (Medium) 
    You are given an n x n 2D matrix representing an image.
    Rotate the image by 90 degrees (clockwise).
    Note:
    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
    DO NOT allocate another 2D matrix and do the rotation.

    Example 1:
    Given input matrix = 
    [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ],
    rotate the input matrix in-place such that it becomes:
    [
      [7,4,1],
      [8,5,2],
      [9,6,3]
    ]
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=SA867FvqHrM
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(n * m) ----------------------------------------------------
    ------------------------------------------------------ Space Complexity: O(1) -----------------------------------------------------
*/

public class RotateImage {

    // Two steps:
    // 1. Transpose => swap elements across diagonal
    // 2. Flip elements symmetrically along each row => first element of row 1 swaps with last element of row 1

    public static void rotateImage(int[][] matrix){
    
        int n = matrix.length;
        int temp = 0;

        for(int i=0 ;i < n; i++){ // Step 1 = TRANSPOSE
            for(int j=i; j<n; j++){
            
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0 ;i < n; i++){  // Step 2 = FLIP ELEMENTS USING 2 POINTERS
            for(int j=0; j<n/2; j++){
            
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
    
    public static void main(String args[]){

        int[][] matrix ={{1,2,3},{4,5,6},{7,8,9}};
        rotateImage(matrix);

        for(int i=0; i<matrix.length;i++){
            for(int j=0;j <matrix[0].length;j++){
            
                System.out.println(matrix[i][j]);
            }
        }
    }
}
