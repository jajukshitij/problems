/*
    Problem: Leetcode.169 Majority Element (Easy)
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times. 
    You may assume that the majority element always exists in the array.

    Example 1:    
    Input: nums = [3,2,3]
    Output: 3
    
    Example 2:    
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2
    ----------------------------------------------------------------------------------------------------------------------------------
*/

public class MajorityElement
  {
    // ----------------------------------------------------- Method 1: HashMap ------------------------------------------------------
    //------------------------------------------------------ Time Complexity: O(n) ---------------------------------------------------
    //------------------------------------------------------ Space Complexity: O(n) ----------------------------------------------------
    
    public int majorityElement(int[] nums)
    {
      Map<Integer,Integer> map = new HashMap<>();
      int n = nums.length;

      for(int num: nums)
      {
        map.put(num, map.getOrDefault(num, 0)+1);
      }

      for(Map.Entry<Integer, Integer> entry : map.entrySet())
      {
        if(entry.getValue() > n/2)
        {
          return entry.getKey();
        }
      }

      return -1;
    }

// ----------------------------------------------------- Method 2: Sorting ------------------------------------------------------
//------------------------------------------------------ Time Complexity: O(n log n) ---------------------------------------------------
//------------------------------------------------------ Space Complexity: O(1) ----------------------------------------------------

    public int majorityElement(int[] nums)
    {
      Arrays.sort(nums);
      return nums[nums.length / 2];
    }

// ----------------------------------------------------- Method 3: Boyer-Moore Voting Algorithm ------------------------------------------------------
//------------------------------------------------------ Time Complexity: O(n) ---------------------------------------------------
//------------------------------------------------------ Space Complexity: O(1) ----------------------------------------------------

    public int majorityElement(int[] nums)
    {
      int count = 0;
      Integer candidate = null;

      for (int num : nums) 
      {
        if (count == 0) 
        {
          candidate = num;
        }
        count += (num == candidate) ? 1 : -1;
      }

      return candidate;
    }
  }
