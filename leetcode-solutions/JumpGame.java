/*
    Problem: Leetcode. 55 Jump Game (Medium)
    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
    Return true if you can reach the last index, or false otherwise.   
    
    Example 1:    
    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    
    Example 2:    
    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter
    ----------------------------------------------------------------------------------------------------------------------------------

    --------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
    -------------------------------------------------- Space Complexity: O(1) -------------------------------------------------------
*/
/*
  Explanation: 
  Input: nums = [2,3,1,1,4]
  
  1. [2,3,1,1,4]
            i g
    i = current position
    g = goal

  2. if current position + maximum jump >= goal then GOOD 
      = 3 + 1 >= 4
      = true
    
  3. We can reach the current goal(= index 4) from current position(= index 3), 
    that means if we reach index 3, we are sure that we can definitely reach the goal(= the last index)

  4. That's why we can move goal to index 3.
      [2,3,1,1,4]
           i g
      current position + maximum jump >= goal
      = 2 + 1 >= 3
      = true

  5. Continue so on.
*/

public class JumpGame
  {
    public boolean canJump(int[] nums)
    {
      int goal = nums.length-1;

      for(int i=nums.length-2; i>=0; i--)
        {
          if(i + nums[i] >= goal)
          {
            goal = i;
          }
        }

      return goal ==0;
    }
  }
