/*
    Problem: Leetcode.76 Minimum Window Substring (Hard)
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    Example:
    Input: S = "ADOBECODEBANC", T = "ABC"
    Output: "BANC"
    Note:
    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
    --------------------------------------------------------------------------------------------------------------------
    Reference:
    https://www.youtube.com/watch?v=eS6PZLjoaq8
    
    --------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------ Time Complexity: O(s + t)------------------------------------------------
    ------------------------------------------ Space Complexity: O(s + t) ----------------------------------------------
*/

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s ="ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {

        if(s== null || s.length()==0 || t== null || t.length()==0 || s.length()<t.length()){
            return "";
        }

        Map<Character, Integer> map = new HashMap<>(); // HashMap for character count in string t
        
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int count = t.length();
        int minLeft =0;
        int minWin = s.length();
        int i=0;
        int j=0;
        boolean found = false;

        while(j<s.length()){
            char c = s.charAt(j);

            if(map.containsKey(c)){
            
                map.put(c, map.get(c)-1); // Decrementig count for each character found in s
                
                if(map.get(c)>=0){ // if less than or equal to 0 , then that char doesn't exists in t
                    count--; 
                }
            }

            // incrementing i to reduce the window size, i to j
            while(count==0 && i<=j){ // when count = 0 ; all characters of t have been found in range i to j

                found = true;

                char l = s.charAt(i);
                
                if(map.containsKey(l)){ // character exists in t ; this is the smallest possible window for current i to j
                                        // cannot increment i anymore, hence count ++ to break out of inner loop
                    map.put(l, map.get(l)+1);

                    if(map.get(l)>=1){
                        count++;
                    }
                }

                if(j-i+1 <= minWin){
                    minLeft =i;
                    minWin = j-i+1;
                }
                i++;
            }
            j++;
        }

        if(found){
            return s.substring(minLeft, minLeft+minWin);
        }else{
            return "";
        }
    }
}
