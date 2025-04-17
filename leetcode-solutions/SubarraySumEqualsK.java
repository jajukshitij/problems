/*
    Problem: LeetCode.560 Subarray Sum Equals K (Medium)
    
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
    A subarray is a contiguous non-empty sequence of elements within an array.
    
    Example 1:    
    Input: nums = [1,1,1], k = 2
    Output: 2
    
    Example 2:    
    Input: nums = [1,2,3], k = 3
    Output: 2
    -------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) --------------------------------------------------
    ------------------------------------------------------ Space Complexity: O(n) --------------------------------------------------
*/
public class Solution {
    public int subarraySum(int[] nums, int k) {
      int sum =0;
      int count =0;
      Map<Integer, Integer> map = new HashMap<>();
      // map = (sum, num of occurences)
      map.put(0,1);  // for when sum = k
      for(int i =0; i<nums.length; i++)
        {
          sum += nums[i];

          if(map.containsKey(sum-k))
          {
            count += map.get(sum-k);
          }

          map.add(sum, map.getOrDefault(sum,0)+1);
        }
      
      return count;
    }
}










