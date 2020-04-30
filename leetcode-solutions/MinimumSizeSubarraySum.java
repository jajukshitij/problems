/*
    Problem: Leetcode.209 Minimum Size Subarray Sum (Medium)
    Given an array of n positive integers and a positive integer s,
    find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

    Example: 
    Input: s = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: the subarray [4,3] has the minimal length under the problem constraint.
    -----------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=jKF9AcyBZ6E
    -----------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n) ---------------------------------------------------
    --------------------------------------------------- Space Complexity: O(1) --------------------------------------------------
    
*/

public class MinimumSizeSubarraySum {

    public static int minSizeSubarray(int[] nums, int sum){
    
        int result = Integer.MAX_VALUE;
        int left = 0;
        int curr_sum = 0;

        // Two Pointers, i to find the subarray with target sum 
        for(int i=0; i<nums.length; i++){
            curr_sum += nums[i];

            while(curr_sum >= sum){ // left to reduce the size of the subarray
                result = Math.min(result, i-left+1);
                curr_sum = curr_sum - nums[left];
                left++;
            }
        }

        if(result != Integer.MAX_VALUE){
            return result;
        }else{
            return 0;
        }
        
    }
    
    public static void main(String[] args){
        int nums[] = {2,3,1,2,4,3};
        System.out.println(minSizeSubarray(nums,7));
    }
}
