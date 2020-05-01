/*
    Problem: Leetcode.73 Set Matrix Zeroes (Medium)
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

    Example 1:

    Input: 
    [
      [1,1,1],
      [1,0,1],
      [1,1,1]
    ]
    Output: 
    [
      [1,0,1],
      [0,0,0],
      [1,0,1]
    ]
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=6_KMkeh5kEc
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(m * n) --------------------------------------------------
    ------------------------------------------------------ Space Complexity: O(1) ---------------------------------------------------
    
*/


public class SetMatrixZero {

    public static void setZero(int[][] matrix){
    
        int n = matrix.length;
        int m = matrix[0].length;
        boolean isCol = false;

        // Using first row and first column like boolean array to record is zero is present in them.

        for(int i=0; i<n; i++){

            if(matrix[i][0]==0){        // Checking if first column needs to be 0
                isCol = true;
            }

            for(int j =1; j<m; j++){
            
                if(matrix[i][j]==0){        // Setting first row and column =0 for any corresponding cell =0
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i =1; i<n; i++){            // Iterating matrix except first row and first column
            for(int j=1; j<m; j++){
            
                if(matrix[i][0]==0 || matrix[0][j]==0){     // If first row or column = 0 setting corresponding cell 0
                    matrix[i][j]= 0;
                }
            }
        }

        if(matrix[0][0]==0){                // If first cell = 0, setting first row =0
            for (int j=0; j<m; j++){
                matrix[0][j]=0;
            }
        }

        if(isCol){                      // Setting first column = 0
            for(int i=0; i<n; i++){
                matrix[i][0]=0;
            }
        }
    }
    
    public static void main(String[] args){
        int[][] matrix1 = {{0,1,2,0},
                            {3,4,5,2},
                            {1,3,1,5}};

        int[][] matrix2 = {{1,1,1},
                            {1,0,1},
                            {1,1,1}};

        setZero(matrix1);
        System.out.println("Matrix 1 ::::::");

        for(int i=0; i<matrix1.length; i++){
            for(int j=0; j<matrix1[0].length; j++){
                System.out.print(matrix1[i][j]);
            }
            System.out.println(" ");
        }

        setZero(matrix2);
        System.out.println("Matrix 2 ::::::");

        for(int i=0; i<matrix2.length; i++){
            for(int j=0; j<matrix2[0].length; j++){
                System.out.print(matrix2[i][j]);
            }
            System.out.println(" ");
        }

    }
    
}


