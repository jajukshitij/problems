/*
    Problem: Leetcode.3 Longest Substring Without Repeating Characters (Medium)
    Given a string, find the length of the longest substring without repeating characters.

    Example 1:
    Input: "abcabcbb"
    Output: 3 
    Explanation: The answer is "abc", with the length of 3. 
    ------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=8FDMiWQijpo
    -------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
                                                                       Index i will iterate n times
    ---------------------------------------------- Space Complexity: O(min(m, n)) -------------------------------------------------
                                                                     n = length of string, m = size of character set (alphabets) 
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringNonRepeating {

    public static int longestSubstring (String s) {

        int max=0;
        HashSet<Character> set = new HashSet<>();
        int start=0;
        int end =0;

            while(end < s.length()){
            
            if( !set.contains(s.charAt(end)) ){ // Adding all unique (not in set) chars
            
                set.add(s.charAt(end));
                end++;
                max = Math.max(max, set.size());
                
            }else{ // Removing the char pointed by 'start' , new substring start++ -> end
            
                set.remove(s.charAt(start));
                start++;
                
            }
        }
        return max;
    }
    
    public static void main(String args[]) {
        System.out.println(longestSubstring("abcabcbb"));
    }

}
