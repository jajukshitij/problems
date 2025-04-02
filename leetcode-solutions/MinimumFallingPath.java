/*
    Problem: Leetcode 931. Minimum Falling Path Sum (Medium)
    Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
    A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
    Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).     
    
    Example 1:    
    Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
    Output: 13
    Explanation: There are two falling paths with a minimum sum as shown.
    
    Example 2:
    Input: matrix = [[-19,57],[-40,-5]]
    Output: -59
    Explanation: The falling path with a minimum sum is shown.
    ------------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n*m) -------------------------------------------------------
    
    ------------------------------------------------------ Space Complexity: O(1) -------------------------------------------------------
*/
public class MinimumFallingPath
  {
    public int minFallingPathSum(int[][] matrix)
    {
      int n = matrix.length;
      int m = matrix[0].length;
      int min = Integer.MAX_VALUE;

      if(n == 1 && m == 1)
      {
        return matrix[0][0];
      }
      else if(n ==1)
      {
        for(int j=0; j<m; j++)
          {
            min = Math.min(min, matrix[0][j]);
          }
      }

      for(int i=1; i<n; i++)
        {
          for(int j=0; j<m;j++)
            {
              if(j==0)
              {
                matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
              }
              else if(j==m-1)
              {
                matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j-1]);
              }
              else
              {
                matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i-1][j+1], matrix[i-1][j-1]));
              }
              if(i == n-1)
              {
                min = Math.min(min, matrix[i][j]);
              }
            }
        }
      return min;
    }
  }























