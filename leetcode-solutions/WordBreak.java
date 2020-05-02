/*
    Problem: Leetcode.139 Word Break (Medium)
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
    determine if s can be segmented into a space-separated sequence of one or more dictionary words.
    Note:
    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
    
    Example 1:
    Input: s = "leetcode", wordDict = ["leet", "code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=hLQYQ4zj0qg
    ---------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n^2) -----------------------------------------------------
*/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static boolean wordbreak(String s, List<String> wordDict){
    
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];

        dp[0]= true;

        for(int i=1; i<n+1; i++){

            for(int j=0; j<i; j++){

                if(dp[j] && set.contains(s.substring(j,i))){
                
                    dp[i]= true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
