/*
    Problem: Leetcode.74. Search a 2D Matrix (Medium)
    You are given an m x n integer matrix matrix with the following two properties:
    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.
    
    You must write a solution in O(log(m * n)) time complexity.

    Example 1:  
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    Output: true

    Example 2:
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
    Output: false
    ---------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(log (m*n)) -------------------------------------------------------
    -------------------------------------------------- Space Complexity: O(1) ------------------------------------------------------
*/

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m*n-1;

        while(left <= right)
        {
            int mid = left +(right-left)/2;
            int value = matrix[mid/n][mid%n];
          // 'mid / n' = row, since each row has 'n' columns
          // 'mid % n' = column, i.e. remainder after dividing mid by number of columns
          // This treats the 2D matrix as a flattened 1D array for binary search

            if(value == target)
            {
                return true;
            }
            else if(value < target)
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }

        return false;
    }
}
