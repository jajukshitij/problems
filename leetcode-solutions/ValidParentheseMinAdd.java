/*
    Proble: Leetcode 921. Minimum Add to Make Parentheses Valid (Medium)
    A parentheses string is valid if and only if:
    It is the empty string,
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.
    You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
    
    For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
    Return the minimum number of moves required to make s valid.
    
    Example 1:    
    Input: s = "())"
    Output: 1
    
    Example 2:    
    Input: s = "((("
    Output: 3
    -------------------------------------------------------------------------------------------------------------------------------------------------------
    ------------------------------------------------------------Time Complexity: O(n) ---------------------------------------------------------------------
    ------------------------------------------------------------Space Complexity: O(1) ---------------------------------------------------------------------
*/

public class ValidParentheseMinAdd {
    public int minAddToMakeValid(String s) {
        int openBraces =0;
        int minAdd =0;

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                openBraces++;
            }
            else if(c == ')')
            {
                if(openBraces >0)
                {
                    openBraces--;
                }
                else
                {
                    minAdd++;
                }
            }
        }

        return minAdd + openBraces;
    }
}
