/*
    Problem: Leetcode. 675 Cut Trees For Golf Event (Hard)
    
    You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
    0 represents the obstacle can't be reached. 1 represents the ground can be walked through.
    The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
    In one step you can walk in any of the four directions top, bottom, left and right also when standing in a point which is a tree you can decide whether or not to cut off the tree.
    You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
    You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
    You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

    Example 1:
    Input: 
    [
     [1,2,3],
     [0,0,4],
     [7,6,5]
    ]
    Output: 6
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------ Time Complexity: O((n*m)^2) ------------------------------------------------------
                                                                      (n*m) trees visited and (n*m) time to search trees
    ------------------------------------------------ Space Complexity: O((n*m)) ------------------------------------------------------
    
*/

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutTreesGolfEvent {

    public int cutOffTree(List<List<Integer>> forest){
        if(forest==null || forest.size()==0){
            return 0;
        }

        int n = forest.size();
        int m = forest.get(0).size();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)-> a[2]-b[2]); // min heap based on tree size

        for(int i=0; i < n; i++){
            for(int j=0; j< m; j++){
                if(forest.get(i).get(j)>1){
                    priorityQueue.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }

        int[] start = {0,0};
        int sum =0;
        while(!priorityQueue.isEmpty()){

            int[] target = priorityQueue.poll(); // starting with the smallest tree first
            int step = bfs(forest, start, target, n, m );
            if(step<0){
                return -1;
            }
            sum +=step;
            start[0] = target[0]; next iteration starts from the smallest tree cut this time
            start[1] = target[1];
        }

        return sum;
    }

    public static int bfs(List<List<Integer>> forest, int[] start, int[] target, int n, int m){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int step =0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                int[] tree = queue.poll();

                if(tree[0]== target[0] && tree[1]== target[1]){
                    return step;
                }
                for(int[] dir :dirs){
                    int x = tree[0] + dir[0];
                    int y = tree[1] + dir[1];

                    if(x<0 || x>= n || y<0 || y>=m || visited[x][y] || forest.get(x).get(y)<=1){
                        continue;
                    }

                    queue.add(new int[]{x,y});
                    visited[x][y]= true;
                }
            }
            step++;
        }

        return -1;
    }
}
