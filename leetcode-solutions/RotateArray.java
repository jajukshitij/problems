/*
    Problem: Leetcode.189 Rotate Array (Easy)
    Given an array, rotate the array to the right by k steps, where k is non-negative.
    Follow up:
    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?

    Example 1:
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Constraints:
    1 <= nums.length <= 2 * 10^4
    It's guaranteed that nums[i] fits in a 32 bit-signed integer.
    k >= 0
    ------------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) -------------------------------------------------------
    ----------------------------------------------------- Space Complexity: O(1) -------------------------------------------------------
    
*/

public class RotateArray {

    public static void rotateArray(int[] nums, int k){
    
        int n = nums.length;
        k = k%n; // If k is larger than n
        
        reverse(nums, 0, n-1); // Reverse all numbers
        reverse(nums, 0, k-1); // Reverse k number
        reverse(nums, k, n-1); // Reverse form k to n-1
    }

    public static void reverse(int[] nums, int start ,int end){

        while(start<end){
        
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
