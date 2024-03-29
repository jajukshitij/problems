/*
    Problem: Leetcode.242 Valid Anagram (Easy)
    Given two strings s and t , write a function to determine if t is an anagram of s.
    
    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true
    ----------------------------------------------------------------------------------------------------------------------------------
    Problem: Leetcode.389 Find Difference (Easy)
    Given two strings s and t which consist of only lowercase letters.
    String t is generated by random shuffling string s and then add one more letter at a random position.
    Find the letter that was added in t.

    Example:
    Input:
    s = "abcd"
    t = "abcde"
    Output:
    e
    Explanation:
    'e' is the letter that was added.
    ----------------------------------------------------------------------------------------------------------------------------------
*/

public class ValidAnagram {

    // -------------------------------------- Problem: Leetcode.242 Valid Anagram (Easy) --------------------------------------------

    public static boolean isAnagram(String s, String t){


        /*if(s.length()!=t.length()){
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        //int i = 0;
        
       /* for(int k=0; k<s.length(); k++){
            if(sArray[i]!=tArray[i]){
                return false;
            }
            i++;
        }*/

        
        if(s.length()!= t.length()){
            return false;
        }

        int[] array = new int[26];

        for(int i=0; i<s.length(); i++){
        
            array[s.charAt(i)-'a']++;
            array[t.charAt(i)-'a']--;
        }

        for(int i=0; i<26; i++){
        
            if(array[i]!=0){
                return false;
            }
        }

        return true;
    }

    // ----------------------------------------- Remove Characters To Make Anagram ----------------------------------------------
    
    public static int removeChar(String s, String t){

        int[] array = new int[26];

        for(int i=0; i<s.length(); i++){
                array[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++){
            array[t.charAt(i)-'a']--;
        }

        int max=0;

        for(int i=0; i<26; i++){
            max += Math.abs(array[i]);
        }

        return max;
    }
    
    // -------------------------------------- Problem: Leetcode.389 Find Difference (Easy) -----------------------------------------
    
    public static char findDifference(String s, String t){
    
        int MAX = 26;
        int[] arr = new int[MAX];

        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }

        for(char c: t.toCharArray()){
            arr[c-'a']--;
        }

        for(int i=0; i<MAX; i++){
            if(arr[i]!=0){
                return (char) (i+'a');
            }
        }
        
        return ' ';
    }
}
