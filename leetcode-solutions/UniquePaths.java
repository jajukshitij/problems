/*
    Problem: Leetcode.62 Unique Paths (Medium)
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time.
    The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    How many possible unique paths are there?

    Example 1:
    Input: m = 3, n = 2
    Output: 3
    Explanation:
    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Right -> Down
    2. Right -> Down -> Right
    3. Down -> Right -> Right
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(n) ------------------------------------------------------
    ---------------------------------------------------- Space Complexity: O(n) -----------------------------------------------------
    
    Similar Problems: MinimumPathSum ; DecodeWays ; ClimbingStairs
    
*/

public class UniquePaths {
    
    public static int uniquePaths(int n, int m){
    
        int[][] matrix = new int[n][m];

        for(int i=0; i<n; i++){
            matrix[i][0] = 1;
        }
        
        for(int j=0; j<m; j++){
            matrix[0][j]=1;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                matrix[i][j] = matrix[i-1][j]+ matrix[i][j-1];
            }
        }

        return matrix[n-1][m-1];
    }
}
