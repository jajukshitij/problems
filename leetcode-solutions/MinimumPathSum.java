/*
    Problem: Leetcode.64 Minimum Path Sum (Medium)
    Given a m x n grid filled with non-negative numbers,
    find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    Note: You can only move either down or right at any point in time.

    Example:
    Input:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    Output: 7
    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
    --------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=ItjZdu6jEMs
    --------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(n*m) -----------------------------------------------------
*/

public class MinimumPathSum {

    public static int minSumPath(int[][] grid){
    
        if(grid ==null || grid.length==0){
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        
        // In first row you can only move right i.e cell in first row can only be reached from their left cell
        for(int i =1; i<n; i++){
            grid[i][0]= grid[i][0] + grid[i-1][0];
        }
        
        // In first column you can only move down i.e cell in first column can only be reached from their up cell
        for(int j =1; j<m; j++){
            grid[0][j]= grid[0][j]+ grid[0][j-1];
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                grid[i][j]= Math.min( grid[i-1][j], grid[i][j-1]) + grid[i][j]; // Minimum of left or top + the current cell
            }
        }

        return grid[n-1][m-1];
    }
}
