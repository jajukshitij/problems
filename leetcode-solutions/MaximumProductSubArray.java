/*
Leetcode Problem 152. Maximum Product Subarray (Medium)
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer. 

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

public class MaximumProductSubArray
  {
    public int maxProduct(int[] nums)
    {
      if (nums.length == 0) {
            return 0;
        }

        // Initialize maxSoFar and minSoFar with the first element in the array, and
        // result with maxSoFar
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        // Loop through the rest of the elements in the array
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Update maxSoFar and minSoFar with the maximum and minimum of curr, maxSoFar *
            // curr, and minSoFar * curr
            // tempMaxSoFar is used to store the value of maxSoFar so that it does not get
            // updated while calculating minSoFar
            int tempMaxSoFar = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));

            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));

            maxSoFar = tempMaxSoFar;

            // Update result with the maximum of maxSoFar and result
            result = Math.max(maxSoFar, result);
        }

        // Return the final result
        return result;
    }
  }













