/*
    Problem: Leetcode.53 Maximum Subarray (Easy)
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Example:
    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Follow up:
    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=2MmGzdiKR9Y
    -----------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(n) ----------------------------------------------------------
    -------------------------------------------------- Space Complexity: O(1) ---------------------------------------------------------
    Greedy Approach
    
*/

public class MaximumSubArray {

    public static int maxSubArray(int[] nums){
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i =1; i<nums.length; i++){
        
            currSum = Math.max(nums[i], currSum+nums[i]); // if curr element itself is > previous sum + curr; (in case of -ves)
            maxSum = Math.max(maxSum,currSum);
            
        }

        return maxSum;
    }
    
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    
}
