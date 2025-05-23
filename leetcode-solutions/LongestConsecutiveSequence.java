/*
    Problem: Leetcode.128 Longest Consecutive Sequence (Medium)
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.     
    
    Example 1:    
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    
    Example 2:
    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) ---------------------------------------------------
    ------------------------------------------------------ Space Complexity: O(n) ----------------------------------------------------
*/
public class LongestConsecutiveSequence
  {
    public int longestConsecutive(int[] nums)
    {
      Set<Integer> set = new HashSet<>();

      for(int num: nums)
        {
          set.add(num);
        }

      int res =0;
      for(int num: set)
        {
          if(!set.contains(num-1))
          {
            int currCount =1;

            while(set.contains(num+1))
              {
                currCount++;
                num++;
              }

            res = Math.max(currCount ,res);
          }
        }

      return res;
    }
  }




















