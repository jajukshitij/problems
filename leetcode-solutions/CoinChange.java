/*
    Problem: Leetcode.322 Coin Change (Medium)
    
    You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    Example 1:
    Input: coins = [1, 2, 5], amount = 11
    Output: 3 
    Explanation: 11 = 5 + 5 + 1
    -------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=Y0ZqKpToTic
    https://www.youtube.com/watch?v=NJuKJ8sasGk&feature=youtu.be
    -------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------- Time Complexity: O(n* m) --------------------------------------------------------
                                                                   n = amount and m = number of coins
*/

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int amount, int[] coins){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        
        dp[0]=0;

        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
            
                if(i>=coins[j]){
                    dp[i]= Math.min(dp[i], dp[i-coins[j]]+1);
                }
                
            }
        }

        return dp[amount]>amount? -1: dp[amount];
    }
}
