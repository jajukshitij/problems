/*
    Problem: LeetCode. 70 Climbing Stairs (Easy)
    
    You are climbing a stair case. It takes n steps to reach to the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    Note: Given n will be a positive integer.

    Example 1:
    Input: 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Refrence:
    https://www.youtube.com/watch?v=uHAToNgAPaM
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) ----------------------------------------------------
    
*/

public class ClimbingStairs {

    public static void main(String[] args){
        System.out.println(climbStaris(4));
    }

    public static int climbStaris(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i =2; i<n+1; i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }

        return dp[n];
    }
}
