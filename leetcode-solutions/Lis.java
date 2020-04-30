/*
    Problem: Leetcode. Longest Increasing Subsequence (Medium)
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/LongestIncreasingSubsequence/LongestIncreasingSubsequence.java
    https://www.youtube.com/watch?v=fV-TF4OvZpk
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n^2) ---------------------------------------------------
    ------------------------------------------------------ Space Complexity: O(n) ----------------------------------------------------
    Dynamic Programming
*/

import java.util.Arrays;

public class LIS {

    public static int longestIncreasingSubsequence(int[] nums){
        if(nums== null || nums.length==0){
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1); // Default LIS for each element individuall is 1

        int maxVal = 1;

        for(int i=1; i<nums.length; i++){

            for(int j=0; j<i; j++){
            
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            maxVal = Math.max(maxVal, dp[i]);
        }

        return maxVal;
    }
    
    public static void main(String[] args){
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(longestIncreasingSubsequence(nums));
    }
}
