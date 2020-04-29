/*
    Problem: Leetcode 953. Verifying an Alien Dictionary (Easy)
    In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
    Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
    
    Example 1:

    Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
    Output: true
    Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
    -------------------------------------------------------------------------------------------------------------------
    Reference: https://www.youtube.com/watch?v=qSbJZWENtX4
    
    --------------------------- Time Complexity: O(C) -------------------------------------
                                                 C = number of characters in words array
    
    --------------------------- Space Complexity: O(1) -------------------------------------                     
*/

public class AlienDictionaryVerify {

    static int[] char_map;
    public static boolean isAlienSorted(String[] words, String order){
        if(words== null || words.length <=1){
            return true;
        }
        if(order == null || order.length()==0){
            return false;
        }

        char_map =new int[26];
        
        // Building char_map based on given lexicographical order
        // For ex. order = "hlabcdefgijkmnopqrstuvwxyz" ;  h=0 , l=1, a=2 ...
        for(int i=0; i< order.length(); i++){
            char_map[order.charAt(i)-'a'] = i;
        }

        for(int i=1; i< words.length; i++){
            if(compare(words[i-1], words[i]) > 0){
                return false;
            }
        }

        return true;
    }

    public static int compare(String first, String second){

        int len = Math.min(first.length(), second.length());
        int res =0;
        
        for(int i=0; i<len ; i++){
            if(first.charAt(i)!= second.charAt(i)){
                res = char_map[first.charAt(i)-'a'] - char_map[second.charAt(i)-'a'];
            }
            if(res!=0){
                break;
            }
        }

        if(res== 0){
            return first.length()-second.length(); // for case-> "pqr", "pqrs"
        }else{
            return res;
        }
    }
}
