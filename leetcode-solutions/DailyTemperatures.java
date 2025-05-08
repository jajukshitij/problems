/*
    Problem: Leetcode.739 Daily Temperatures (Medium)
    Given an array of integers temperatures represents the daily temperatures,
    return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
    If there is no future day for which this is possible, keep answer[i] == 0 instead.

    Example 1:    
    Input: temperatures = [73,74,75,71,69,72,76,73]
    Output: [1,1,4,2,1,1,0,0]
    
    Example 2:
    Input: temperatures = [30,40,50,60]
    Output: [1,1,1,0]
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) -----------------------------------------------------
    ----------------------------------------------------- Space Complexity: O(n) -----------------------------------------------------
*/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
      int n = temperatures.length;
      int[] res = new int[n];
      Arrays.fill(res,0);
      
      Stack<Integer> stack = new Stack<>();

      for(int i=0; i<n; i++)
        {
          while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i])
            {
              int prevIdx = stack.pop();
              res[prevIdx] = i-prevIdx;
            }
          stack.push(i);
        }

      return res;        
    }
}
