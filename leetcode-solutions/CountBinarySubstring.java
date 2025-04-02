/*
    Problem: Leetcode 696. Count Binary Substrings (Easy)
    Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's,
    and all the 0's and all the 1's in these substrings are grouped consecutively.
    Substrings that occur multiple times are counted the number of times they occur.     
    
    Example 1:    
    Input: s = "00110011"
    Output: 6
    Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
    Notice that some of these substrings repeat and are counted the number of times they occur.
    Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.

    Example 2:    
    Input: s = "10101"
    Output: 4
    Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
    ------------------------------------------------------------------------------------------------------------------------------------
    https://leetcode.com/problems/count-binary-substrings/solutions/1172553/js-python-java-c-easy-rolling-count-solution-w-explanation
    
    Since the 0's and 1's have to be grouped consecutively, we only have to be concerned with the most recent two groups (curr, prev) at any time as we iterate through the input string (s).
    Since each addition to our answer (ans) must therefore be centered on the "edge" between the two groups, we should be able to count multiple increases to ans at the same time.
    For example, if we find a group that is "0001111", then we know that we've found multiple answer counts centered on the "01".
    Each additional extra character on both sides will be an extra answer, which means that "0011" and "000111" are also answers. 
    In other words, the number that we should add to ans is equal to min(zeros, ones), or 3 in this example.    
    So we can now iterate through s, keeping track of the curr and prev groups, and when we find the end of a group, we can calculate our addition to ans and then swap the two variables while resetting curr to 1.    
    Since we're going to be comparing s[i] to s[i-1] to see if the character has changed, we'll need to start our iteration with i = 1 which means we should define a starting value for curr of 1. 
    Also, since the end of s is technically the end of a group, we should add another min(curr, prev) onto ans before we return ans, as it won't be accounted for in the iteration through s.
        
    ------------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(N) -------------------------------------------------------
                                                                              N= length of string
    ------------------------------------------------------ Space Complexity: O(1) -------------------------------------------------------
*/
public class CountBinarySubstring
  {
    public int countBinarySubstrings(String s)
    {
      int curr=1, prev=0, ans=0;

        for(int i=1; i<s.length(); i++)
        {
            if(s.charAt(i-1)== s.charAt(i))
            {
                curr++;
            }
            else
            {
                ans += Math.min(prev,curr);
                prev = curr;
                curr = 1;
            }
        }

        ans += Math.min(prev,curr);

        return ans;
    }
  }



























