/* 
   Problem: Leetcode.121 Best Time To Buy and Sell Stock (Easy)
   
   Say you have an array for which the ith element is the price of a given stock on day i.
   If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
   Note that you cannot sell a stock before you buy one.

   Example 1:
   Input: [7,1,5,3,6,4]
   Output: 5
   Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
   
   ----------------------------------------------------------------------------------------------------------------------------------
   
   --------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
                                                                        n = length of array
*/

public class BestTimeToBuySellStockII {

    public static void main(String[] args){
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit (int[] nums){
        int minPrice = nums[0];
        int maxProfit =0;

        for(int i=1; i< nums.length; i++){
            if(nums[i]<minPrice){
                minPrice= nums[i];
            }else{
                maxProfit = Math.max(maxProfit,nums[i]-minPrice);
            }
        }
        return maxProfit;
    }
}
