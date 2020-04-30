/*
    Problem: Leetcode.973 K Clossest Points To Origin (Medium)
    We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
    (Here, the distance between two points on a plane is the Euclidean distance.)
    You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

    Example 1:
    Input: points = [[1,3],[-2,2]], K = 1
    Output: [[-2,2]]
    Explanation: 
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
    ------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------- Time Complexity: O(n log(k)) --------------------------------------------
    ------------------------------------------------- Space Complexity: O(k) -----------------------------------------------
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    public static int[][] kClosestPoints(int[][] points, int k){

        // Creating a max heap with comparator on Euclidean distance
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return getDistance(b)- getDistance(a);
            }
        });

        for(int[] point: points){
            priorityQueue.add(point);

            if(priorityQueue.size()>k){ // max heap size = k
                priorityQueue.poll();
            }
        }

        int[][] res = new int[k][2];
        
        // max heap contains k points with smallest distances in descending order
        for(int i=0; i<k; i++){
            res[i] = priorityQueue.poll();
        }

        return res;
    }

    // Calculating Euclidean distance
    public static int getDistance(int[] point){
        return (point[0]*point[0] + point[1]*point[1]);
    }
}
