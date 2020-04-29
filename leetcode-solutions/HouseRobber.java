/*
    Problem: Leetcode.198 House Robber (Easy)
    You are a professional robber planning to rob houses along a street.
    Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
    and it will automatically contact the police if two adjacent houses were broken into on the same night.
    Given a list of non-negative integers representing the amount of money of each house,
    determine the maximum amount of money you can rob tonight without alerting the police.

    Example 1:
    Input: [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
                 Total amount you can rob = 1 + 3 = 4.
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=xlvhyfcoQa4
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------- Time Complexity: O(n) --------------------------------------------------
                                                                             n = length of array
*/

public class HouseRobber {

    public static int houseRobber(int[] nums){

        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }

        for(int i=2; i<nums.length; i++){
            nums[i] = Math.max(nums[i]+ nums[i-2], nums[i-1]);
        }

        return nums[nums.length-1];
    }
}
