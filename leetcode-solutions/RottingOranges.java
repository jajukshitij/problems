/*
    Problem: Leetcode.994 Rotting Oranges (Medium)
    In a given grid, each cell can have one of three values:
    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.
    Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
    Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

    Example 1:
    Input: [[2,1,1],[1,1,0],[0,1,1]]
    Output: 4
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=TzoDDOj60zE
    ---------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n*m) -------------------------------------------------------
    -------------------------------------------------- Space Complexity: O(n*m) -------------------------------------------------------
    Zombie Matrix
    BFS
*/

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int rottingOranges(int[][] grid){
    
        if(grid==null || grid.length==0){
            return -1;
        }
        
        int row= grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
            
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j}); // Adding rotten orange cells to queue
                    
                }else if(grid[i][j]==1){
                    fresh++; // Count fresh oranges
                }
            }
        }

        if(fresh==0){ // No fresh oranges to rotten
            return 0;
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // 4 directions to traverse
        int mins = 0;

        while(!queue.isEmpty()){
        
            int size = queue.size();

            while(size-- >0){
            
                int[] rot = queue.poll(); // Picking rotten orange cell out of queue, to turn fresh oranges around it rotten
                int x = rot[0];
                int y = rot[1];

                for(int[] dir : dirs){ // Traversing 4 direction around the rotten orange cell
                
                    int i = x + dir[0];
                    int j = y+ dir[1];

                    if(i >=0 && i<row && j>=0 && j<col && grid[i][j]==1)
                    {                   
                        grid[i][j] = 2; // Turn fresh ornage rotten
                        queue.offer(new int[]{i,j}); // Add this rotten orange to queue to process later
                        fresh--; // Decrement count to keep track of fresh oranges left
                    }
                }
            }
            mins++;
        }

        if(fresh==0){
            return mins-1; // In last while loop, last rotten orange is added to the queue 
                           // but there are no more fresh oranges to rotten in the next queue
                           // Hence -1 to not count that loop
        }else{ // All fresh oranges couldn't be reached
            return -1;
        }
    }
    
    public static void main(String[] args){

        int[][] grid ={ {2,1,1},
                        {1,1,0},
                        {0,1,1}};

        System.out.println(rottingOranges(grid));
    }
}
