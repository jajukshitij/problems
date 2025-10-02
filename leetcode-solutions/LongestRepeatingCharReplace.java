/*
    Problem: Leetcode. 424 Longest Repeating Character Replacement
    You are given a string s and an integer k. You can choose any character of the string 
    and change it to any other uppercase English character. 
    You can perform this operation at most k times.
    Return the length of the longest substring containing the same letter you can get after performing the above operations.
    
    Example 1:    
    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.

    Example 2:
    Input: s = "AABABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.
    -------------------------------------------------------------------------------------------------------------------------------
    Reference: https://www.youtube.com/watch?v=gqXU1UyA8pk&t=964s
    
    ------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
    ---------------------------------------------- Space Complexity: O(m) -------------------------------------------------
                                                                     m = unique chars in string
    Sliding Window
*/

public class LongestRepeatingCharReplace {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        int maxFreq = 0;
        int res =0;

        for(int j=0; j<s.length(); j++)
        {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c,0)+1);
            maxFreq= Math.max(maxFreq, map.get(c));

            while((j-i+1)- maxFreq > k)
            {
                char l = s.charAt(i);
                map.put(l, map.get(l)-1);
                i++;
            }

            res = Math.max(res, j-i+1);
        }

        return res;
    }
}
