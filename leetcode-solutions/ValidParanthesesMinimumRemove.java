/*
  Leetcode 1249. Minimum Remove to Make Valid Parentheses (Medium)
    Given a string s of '(' , ')' and lowercase English characters.    
    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid
    and return any valid string. Formally, a parentheses string is valid if and only if:    
    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.
     
    Example 1:    
    Input: s = "lee(t(c)o)de)"
    Output: "lee(t(c)o)de"
    Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
    
    Example 2:
    Input: s = "a)b(c)d"
    Output: "ab(c)d"
    
    Example 3:    
    Input: s = "))(("
    Output: ""
    Explanation: An empty string is also valid.
    -------------------------------------------------------------------------------------------------------------------------------------------------------
    ------------------------------------------------------------Time Complexity: O(n) ---------------------------------------------------------------------
    ------------------------------------------------------------Space Complexity: O(n) ---------------------------------------------------------------------
*/


public class ValidParanthesesMinimumRemove {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i =0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c =='(')
            {
                stack.push(i);
            }
            else if(c ==')')
            {
                if(!stack.isEmpty() && s.charAt(stack.peek())=='(')
                {
                    stack.pop();
                }
                else
                {
                    stack.push(i);
                }
            }
            
        }

        StringBuilder sb = new StringBuilder();

        for(int i =s.length()-1; i>=0; i--)
        {
            char c= s.charAt(i);
            if(!stack.isEmpty() && stack.peek()== i)
            {
                stack.pop();
            }
            else
            {
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }
}
