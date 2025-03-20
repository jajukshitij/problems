/*
    Problem: LeetCode.286 Walls And Gates (Medium)
    
    You are given an m x n grid rooms initialized with these three possible values.
    -1 A wall or an obstacle.
    0 A gate.
    INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
    Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
    
    Example 1:    
    Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
    Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
    
    Example 2:
    Input: rooms = [[-1]]
    Output: [[-1]]    
    ------------------------------------------------------ Time Complexity: O(mn) --------------------------------------------------
*/

public class Solution {

 // ------------------------------------------------------------- BFS ------------------------------------------------------------------
    public void wallsAndGates(int[][] rooms) {
      int m = rooms.length;
      if(m ==0) return;
      int n = rooms[0].length;
      int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
      Queue<int[]> queue = new LinkedList<>();

      for(int i=0; i<m; i++)
        {
          for(int j=0; j<n; j++)
            {
              if(rooms[i][j]== 0)
              {
                queue.offer(new int[]{i,j});
              }
            }
        }

      while(!queue.isEmpty())
        {
          int[] point = queue.poll();
          int row = point[0];
          int col = point[1];

          for(int[] dir: dirs)
            {
              int r = row + dir[0];
              int c = col + dir[1];

              if(r<0 || c<0 || r>=m || c>=n || rooms[r][c] != Integer.MAX_VALUE)
              {
                continue;
              }

              rooms[r][c] = rooms[row][col] +1;
              queue.offer(new int[]{r,c});
            }
        }
      
    }

// ------------------------------------------------------------- DFS ------------------------------------------------------------------
  public void wallsAndGates2(int[][] rooms) {
    int m = rooms.length;
        if(m==0)
        {
            return;
        }
        int n = rooms[0].length;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(rooms[i][j]==0)
                {
                    dfs(i, j, rooms,0);
                }
            }
        }
    }

    public void dfs(int i, int j, int[][] rooms, int steps)
    {
        /* By the solution in comments Time Limit Exceeds,
          while the one out of comments is faster than BFS.
          Leetcode officially gives the BFS as the solution for this problem.

          
        if(i<0 || j<0 || i>=rooms.length || j>= rooms[0].length || rooms[i][j]== -1)
        {
            return;
        }

        if(steps <= rooms[i][j])
        {
            rooms[i][j] = steps;
            dfs(rooms,i+1, j, steps+1);
            dfs(rooms,i-1, j, steps+1);
            dfs(rooms,i, j+1, steps+1);
            dfs(rooms,i, j-1, steps+1);
        }*/

        int m = rooms.length;
        int n = rooms[0].length;
        rooms[i][j] = steps++;
        if (i > 0 && rooms[i - 1][j] > steps)
            dfs(i - 1, j, rooms, steps);
        if (j > 0 && rooms[i][j - 1] > steps)
            dfs(i, j - 1, rooms, steps);
        if (i + 1 < m && rooms[i + 1][j] > steps)
            dfs(i + 1, j, rooms, steps);
        if (j + 1 < n && rooms[i][j + 1] > steps)
            dfs(i, j + 1, rooms, steps);

    }    
    
}
