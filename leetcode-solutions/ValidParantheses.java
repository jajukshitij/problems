/*
    Problem: Leetcode.20 Valid Paranthese (Easy)
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.

    Example 1:
    Input: "()"
    Output: true
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
                                                                           n = Length of String
*/

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s){

        if(s.length()%2 !=0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int i=0; i< s.length();i++){
        
            if(s.charAt(i)=='('){
                stack.push(')');
            }
            
            else if(s.charAt(i)=='['){
                stack.push(']');
            }
            
            else if(s.charAt(i)=='{'){
                stack.push('}');
            }
            
            else if(stack.isEmpty() || stack.peek() != s.charAt(i) ){
                return false;
            } else{
                stack.pop();
            }
            
        }
        
        return stack.isEmpty();
    }
}
