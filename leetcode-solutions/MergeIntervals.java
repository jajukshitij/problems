/*
    Problem: Leetcode.56 Merge Intervals (Medium)
    Given a collection of intervals, merge all overlapping intervals.

    Example 1:
    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6]
    ------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=qKczfGUrFY4
    ------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------- Time Complexity: O(n log (n)) ---------------------------------------------------
    ------------------------------------------------ Space Complexity: O (n) ------------------------------------------------------
    
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals){

        if(intervals == null || intervals.length<=1){
            return intervals;
        }

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]); // Sorting based on start time

        List<int[]> result = new ArrayList<>();
        int[] curr = intervals[0];
        result.add(curr);

        for(int[] interval :intervals){
            int curr_beg = curr[0];
            int curr_end = curr[1];
            int next_beg = interval[0];
            int next_end = interval[1];

            if(curr_end >= next_beg){
                curr[1] = Math.max(curr_end , next_end);
            }else{
                curr = interval;
                result.add(curr);
            }
            
        }

        return result.toArray(new int[result.size()][]);
    }
    
    public static void main(String[] args){

        int[][] intervals ={{1,3},{2,6},{8,10},{15,18}};
        mergeIntervals(intervals);
        //Output :    [[1,6],[8,10],[15,18]]
    }
}
