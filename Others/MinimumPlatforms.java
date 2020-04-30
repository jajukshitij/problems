/*
    Problem: Minimum Number of Platforms Required for a Railway/Bus Station
    Given arrival and departure times of all trains that reach a railway station, 
    the task is to find the minimum number of platforms required for the railway station so that no train waits.
    We are given two arrays which represent arrival and departure times of trains that stop.

    Examples:
    Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
    dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
    Output: 3
    Explantion: There are at-most three trains at a time (time between 11:00 to 11:20)
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------- Time Complexity: O(N log N) -----------------------------------------------------
    -------------------------------------------------- Space Complexity: O(1) -------------------------------------------------------
    
*/

import java.util.Arrays;

public class MinimumPlatforms {

    public static int minPlatforms(int[] arrivals, int[] departures){

        if(arrivals == null || departures == null){
            return 0;
        }

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int i = 1;
        int j = 0;

        int n = arrivals.length;
        int curr_platforms =1;
        int min_platforms =1;


        while(i<n && j <n){

            if(arrivals[i]<= departures[j]){
            
                curr_platforms++;

                if(curr_platforms> min_platforms){
                    min_platforms = curr_platforms;
                }
                
                i++;

            } else{
                curr_platforms--;
                j++;
            }

        }

        return min_platforms;
    }
    
    public static void main(String[] args){

        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(minPlatforms(arr, dep));
    }
}
