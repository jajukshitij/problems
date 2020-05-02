/*
    Problem: Leetcode.916 Word Subset (Medium)
    We are given two arrays A and B of words. Each word is a string of lowercase letters.
    Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
    For example, "wrr" is a subset of "warrior", but is not a subset of "world".
    Now say a word a from A is universal if for every b in B, b is a subset of a. 
    Return a list of all universal words in A.  You can return the words in any order.

    Example 1:
    Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
    Output: ["facebook","google","leetcode"]
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://leetcode.com/problems/word-subsets/solution/
    https://www.youtube.com/watch?v=tvioNeOXRUg
    ----------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------------- Time Complexity: O(A+B) -------------------------------------------------
    ----------------------------------------------- Space Complexity: O (A.length + B.length) ----------------------------------------
*/

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public static List<String> wordSubset(String[] A, String[] B ){
    
        if(A== null || B== null || A.length==0 || B.length==0){
            return null;
        }

        List<String> result = new ArrayList<>();
        int[] max_count = new int[26];

        for(String str: B){
        
            int[] curr_count = getCharCount(str);

            for(int i=0; i<26; i++){
                max_count[i] = Math.max(max_count[i], curr_count[i]);
            }
        }


        for(String str: A){
        
            int[] par_curr = getCharCount(str);
            boolean valid = true;
            
            for(int i=0; i<26; i++){
            
                if(max_count[i]>par_curr[i]){
                    valid = false;
                    break;
                }
            }

            if(valid){
                result.add(str);
            }
        }

        return result;
    }


    public static int[] getCharCount(String s){
    
        int[] result = new int[26];
        
        for(char c: s.toCharArray()){
            result[c-'a']++;
        }
        
        return result;
    }
}
