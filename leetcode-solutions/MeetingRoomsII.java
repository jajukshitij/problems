/*
    Problem: Leetcode.253 Meeting Rooms II (Medium)
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
    find the minimum number of conference rooms required.
    -----------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://zhuhan0.blogspot.com/2017/03/leetcode-253-meeting-rooms-ii.html
    https://www.youtube.com/watch?v=PWgFnSygweI
    -----------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------- Time Complexity: O(n log (n)) -------------------------------------------------
    ------------------------------------------------ Space Complexity: O(n) -----------------------------------------------------
    
    1. Sort meetings by start time
    2. Push the first meeting in a min heap of end times.
    3. Iterate through meetings.If the earliest ending meeting has ended when the current meeting starts, pop from heap.
    i.e. heap.poll.end <= current meeting's start
    4. Push current meeting in the heap
    5. Required number of rooms = Heap size at the end
    
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals){

        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>( (a,b)-> a[1]-b[1] );
        minHeap.add(intervals[0]);

        for(int i =1; i<intervals.length; i++){

            if(intervals[i][0] >= minHeap.peek()[1]){
            
                minHeap.poll();
            }
            
            minHeap.add(intervals[i]);
        }

        return minHeap.size();
    }
    
    public static void main(String[] args){

        int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        System.out.println(minMeetingRooms(intervals));
    }
}
