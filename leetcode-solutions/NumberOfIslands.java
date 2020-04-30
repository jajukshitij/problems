/*
    Problem: Leetcode.200 Number Of Islands (Medium)
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

    Example 1:
    Input:
    11110
    11010
    11000
    00000

    Output: 1
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=o8S2bO3pmO4
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(n * m) ----------------------------------------------------
    --------------------------------------------------- Space Complexity: O(n * m) ----------------------------------------------------
*/

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {

        int count=0;

        for(int i=0; i <grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
            
                if(grid[i][j]=='1'){ // Island found
                   count++;
                   dfs(grid,i,j); // changing  all the connected 1s and this cell so that same island doesn't get recounted
                }
                
            }
        }

        return count;
    }

    public static void dfs(char[][]grid,int i,int j){
    
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0'){ // Out of bounds or not an island
            return;
        }
        
        grid[i][j]='0'; // Changing the value so same cell doesn't get counted again
        
        // Traversing in 4 directions
        
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

    // ---------------------------------------------------- Size of Islands -----------------------------------------------------------

    public static List<Integer> sizeOfIslands(int[][] nums){
    
        List<Integer> result = new ArrayList<>();

        if(nums==null || nums.length==0){
            return result;
        }

        for(int i =0; i<nums.length; i++){
            for(int j =0; j<nums[0].length; j++){
            
                if(nums[i][j]==0) {
                
                    int size = 0;
                    size = helper(nums, i, j);
                    result.add(size);
                }
                
            }
        }

        return result;
    }

    public static int helper(int[][] nums, int i, int j){

        if(i<0 || i>= nums.length || j<0 || j>=nums.length || nums[i][j]!=0){
            return 0;
        }

        nums[i][j]=1;
        int count = 0;

        count++;

        for(int p = i-1; p <= i+1; p++){
            for(int q = j-1; q <= j+1; q++){
            
                count += helper(nums, p, q);
            }
        }

        /*count += helper(nums, i-1, j);
        count += helper(nums, i+1, j);
        count += helper(nums, i, j-1);
        count += helper(nums, i, j+1);
        count += helper(nums, i+1, j+1);
        count += helper(nums, i+1, j-1);
        count += helper(nums, i-1, j+1);
        count += helper(nums, i-1, j-1);*/

        return count;
    }
    
    
    public static void main(String args[]){
        char M[][] = new char[][] { { '1', '1', '0', '0', '0' },
                                    { '0', '1', '0', '0', '1' },
                                    { '1', '0', '0', '1', '1' },
                                    { '0', '0', '0', '0', '0' },
                                    { '1', '0', '1', '0', '1' } };

        int[][] matrix = new int[][]{{0,1,2,0},
                                     {0,2,2,1},
                                     {2,1,0,0},
                                     {1,1,0,0}};

        System.out.println(numIslands(M));
        System.out.println(sizeOfIslands(matrix));
    }

}
