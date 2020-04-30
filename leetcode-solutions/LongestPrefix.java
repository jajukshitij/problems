/*
  Problem: Leetcode.14 Longest Prefix (Easy)
  Write a function to find the longest common prefix string amongst an array of strings.
  If there is no common prefix, return an empty string "".

  Example 1:
  Input: ["flower","flow","flight"]
  Output: "fl"
  ----------------------------------------------------------------------------------------------------------------------------------
  
  Reference:
  https://www.youtube.com/watch?v=1YQmI7F9dJ0
  ----------------------------------------------------------------------------------------------------------------------------------
  --------------------------------------------- Time Complexity: O(S) --------------------------------------------------------------
                                                                 S = sum of all the characters in all the strings
  -------------------------------------------- Space Complexity : O(1) -------------------------------------------------------------
  Vertical Scanning  
*/

public class LongestPrefix {

    public static String longestPrefix(String[] strings){
    
        if(strings==null || strings.length==0){
            return "";
        }

        String prefix = strings[0]; // Assuming the first string as prefix
        
        for(int i=1; i<strings.length; i++){
           
            while(strings[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1); // Removing characters from end to get a match
            }
        }

        return prefix;
    }
    
    public static void main(String[] args){
        
        String[] strings={"flower","flow","flight"};
        System.out.println(longestPrefix(strings));
    }
}
