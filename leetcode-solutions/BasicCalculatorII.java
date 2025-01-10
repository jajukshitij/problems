/*
    Problem: Leetcode. 227. Basic Calculator II (Medium)
    Given a string s which represents an expression, evaluate this expression and return its value. The integer division should truncate toward zero.
    You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
    
    Example 1:
    Input: s = "3+2*2"
    Output: 7
    
    Example 2:    
    Input: s = " 3/2 "
    Output: 1
    
    Example 3:    
    Input: s = " 3+5 / 2 "
    Output: 5
    -------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------Time Complexity: O(n) ------------------------------------------------------
                                                              n = length of string
    ---------------------------------------Space Complexity: O(n) ------------------------------------------------------
*/

public class BasicCalculatorII {
    public int calculate(String s) {
       if (s == null || s.isEmpty())
        {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();        
        int num = 0;
        char operator ='+';

        for(int i =0; i< s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num = (num*10) + (c-'0');
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length()-1)
            {
                if(operator== '+')
                {
                    stack.push(num);
                }
                else if(operator == '-')
                {
                    stack.push(-num);
                }
                else if(operator == '*')
                {
                    stack.push(stack.pop()*num);
                }
                else if(operator == '/')
                {
                    stack.push(stack.pop()/num);
                }
                operator = c;
                num =0;
            }
        }

        int result =0;
        while(!stack.isEmpty())
        {
            result = result + stack.pop();
        }

        return result;
    }
}



