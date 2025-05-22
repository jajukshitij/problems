/*
    Problem: Leetcode. 240 Search a 2D Matrix II (Medium)
    Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

    Example 1:
    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
    Output: true

    Example 2:
    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
    Output: false
    ---------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(m+n) -------------------------------------------------------
    -------------------------------------------------- Space Complexity: O(1) ------------------------------------------------------
*/

public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length <1 || matrix[0].length <1)
        {
            return false;
        }

        int row = 0;
        int col = matrix[0].length-1;

        while(row <= matrix.length-1 && col >= 0)
        {
            if(matrix[row][col] == target)
            {
                return true;
            }
            else if(matrix[row][col] > target)
            {
                col--;
            }
            else
            {
                row++;
            }
        }

        return false;
    }
}
