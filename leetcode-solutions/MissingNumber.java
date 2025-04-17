/*
    Problem: Leetcode.268 Missing Number (Easy)
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array. 

    Example 1:
    Input: nums = [3,0,1]
    Output: 2
    Explanation:
    n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
    
    Example 2:
    Input: nums = [0,1]
    Output: 2
    Explanation:
    n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity  O(n) -------------------------------------------------------
*/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;

        int exp_sum = len*(len+1)/2;
        int sum =0;

        for (int num : nums)
        {
            sum +=num;
        }

        return exp_sum-sum;
    }
}
