/*
    Problem: Leetcode.198 House Robber (Medium)
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
    ------------------------------------------------------- Space Complexity: O(n) --------------------------------------------------
*/

public class HouseRobber {

    public static int houseRobber(int[] nums){

        if(nums==null || nums.length==0){
            return 0;
        }
        
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }

        for(int i=2; i<n; i++){
            nums[i] = Math.max(nums[i]+ nums[i-2], nums[i-1]);
        }

        return nums[n-1];
    }

    // ------------------------------------------------------- Time Complexity: O(n) --------------------------------------------------
    // ------------------------------------------------------- Space Complexity: O(1) -------------------------------------------------

    public static int houseRobber(int[] nums){

        if(nums==null || nums.length==0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }

        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }

        int prevRob = 0;
        int maxRob =0;

        for(int num: nums)
            {
                int temp = Math.max(maxRob, prevRob + num);
                prevRob = maxRob;
                maxRob = temp;
            }

        return maxRob;
    }
}
