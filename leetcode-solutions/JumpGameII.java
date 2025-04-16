/*
    Problem: Leetcode. 45 Jump Game II (Medium)
    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
    Each element nums[i] represents the maximum length of a forward jump from index i.
    In other words, if you are at nums[i], you can jump to any nums[i + j] where:    
    0 <= j <= nums[i] and
    i + j < n
    Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
    
    Example 1:    
    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    
    Example 2:    
    Input: nums = [2,3,0,1,4]
    Output: 2
    ----------------------------------------------------------------------------------------------------------------------------------

    --------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
    -------------------------------------------------- Space Complexity: O(1) -------------------------------------------------------
*/
/*
  Explanation: 
  Input: nums = [2,3,1,1,4]
  
  1. [2,3,1,1,4]
     We start from index 0. And, we have two choices- jump to index 1 or index 2.
     But we don't know which 1 to choose to get minimum number of jumps in the end.
     
  2. So create a range of all possible jumps and check for the farthest index possible in every range  
      We'll use 2 variables to define the range - near and far
      = from index 0 we can jump to index 1 or 2; so for 2nd iteration-> near =1, far = 2;
    
  3. Farthest index in the current range = current index + maximum jump
     = i+ nums[i]
     = 0 + 2 = 2

  4. we update the variables
    near = far+1 
    far = farthest
    jump++;

       n f
    [2,3,1,1,4]    
    jumps = 1

  5. Continue so on.
*/

public class JumpGameII
  {
    public int jump(int[] nums)
    {
      int near =0, far =0, jumps =0;

      while(far < nums.length-1)
        {
          int farthest = 0;

          for(int i = near; i <= far; i++)
            {
              farthest = Math.max(farthest, i + nums[i]);
            }

          near = far+1;
          far = farthest;
          jumps++;
        }

      return jumps;
    }
  }






















