/*
    Problem: Leetcode.11 Container With Most Water (Medium)    
    You are given an integer array height of length n. There are n vertical lines drawn such that 
    the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.    
    Return the maximum amount of water a container can store.
    Note: You may not slant the container and n is at least 2.

    Example 1:
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
    In this case, the max area of water (blue section) the container can contain is 49.
    
    Example 2:    
    Input: height = [1,1]
    Output: 1
    ------------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=TI3e-17YAlc
    ------------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------------- Time Complexity: O(n) ----------------------------------------------------
    --------------------------------------------------------- Space Complexity: O(1) ---------------------------------------------------
*/

public class ConatinerMostWater {

    public static int mostWater(int[] height){
        int left = 0;
        int right = height.length-1;
        int maxArea = Integer.MIN_VALUE;

        while(left<right){
            int min = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, min*(right-left));

            if(height[left]<height[right]){ // closing in from end which has smaller value
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
}
