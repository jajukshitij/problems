/*
    Problem: Leetcode. 844 Backspace String Compare(Easy)
    Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
    Note that after backspacing an empty text, the text will continue empty.
    
    Example 1:
    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac"
    --------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------- Time Complexity: O(S+T) --------------------------------------
    ----------------------------------- Space Complexity: O(S+T) -------------------------------------
*/

import java.util.Stack;

public class BackspaceStringCompare {

    public static boolean stringCompare (String s, String t){
        String new_s = buildString(s);
        String new_t = buildString(t);

        return new_s.equals(new_t);
    }

    public static String buildString(String str){
        Stack<Character> stack = new Stack<>();

        for( char c: str.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }
}
