/*
    Problem: Leetcode.5 Longest Palindromic Substring (Medium)
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:
    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    -------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=y2BD4MJqV20
    -------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n ^2) --------------------------------------------
                                                                         O(n) to expand from mid, O(n) traversal
    --------------------------------------------------- Space Complexity : O(1) --------------------------------------------
*/

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s){
        
        if( s==null || s.length()==0){
            return "";
        }
        
        int start =0;
        int end =0;

        for(int i=0; i <s.length();i++){
            
            // Two possible type of palindrome:
            int len1 = expandfromMid(s,i,i); // aba
            int len2 = expandfromMid(s,i,i+1); // abba
            
            int maxLen = Math.max(len1,len2);

            if(maxLen> end-start) {             // i = middle element, finding the start and end of our substring
                start = i - (maxLen - 1) / 2;
                end = i + (maxLen) / 2;
            }
        }

        return s.substring(start,end+1);
    }

    public static int expandfromMid(String s, int left, int right){

        while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }
    
    public static void main(String[] args){

        System.out.println(longestPalindrome("racecar"));
        System.out.println(longestPalindrome("cbba"));

    }
    
}
