/*
    Problem: Leetcode. 151 Reverse Words in a String (Medium)
    Given an input string, reverse the string word by word.

    Example 1:
    Input: "the sky is blue"
    Output: "blue is sky the"

    Note:
    A word is defined as a sequence of non-space characters.
    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    You need to reduce multiple spaces between two words to a single space in the reversed string.
    ---------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
    -------------------------------------------------- Space Complexity: O(n) -------------------------------------------------------
 
*/

public class ReverseWordsinString {

    public static void main(String[] args){
        System.out.println(reverseWords("  hello world!  "));
    }

    public static String reverseWords(String str){
    
        if(str== null || str.length()==0){
            return"";
        }
        
        String[] strArr = str.trim().split("\\s+"); // Creating a string array of words
        
        if(strArr.length ==0){
            return"";
        }

        StringBuilder sb = new StringBuilder();

        for(int i = strArr.length-1; i>=0; i--){
            sb.append(strArr[i]).append(" ");
        }

        return sb.substring(0,sb.length()-1);
    }
}
