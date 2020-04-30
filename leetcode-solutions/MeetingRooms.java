/*
    Problem: Leetcode.252 Meeting Rooms (Easy)
    Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , 
    determine if a person could attend all meetings.

    Example:
    Input: [ [0, 30], [5, 10], [15, 20] ]
    Output: false.
    -----------------------------------------------------------------------------------------------------------------------------

    --------------------------------------------- Time Complexity: O(n log (n)) -------------------------------------------------
    ------------------------------------------------ Space Complexity: O(1) -----------------------------------------------------
    
*/

import java.util.Arrays;

public class MeetingRooms {

    public static boolean canAttendMeetings(int[][] intervals){

        Arrays.sort(intervals,(a,b)-> a[0]-b[0]); // Sorting based on start time

        for(int i =1; i<intervals.length ; i++){
        
            if(intervals[i-1][1] > intervals[i][0]){
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args){

        int[][] intervals = {{7, 10},{2, 4}};
        System.out.println(canAttendMeetings(intervals));
    }
}
