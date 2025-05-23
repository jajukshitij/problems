/*
    Problem: Leetcode.150 Evaluate Reverse Polish Notation (Medium)
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
    Evaluate the expression. Return an integer that represents the value of the expression.
    
    Note that:    
    The valid operators are '+', '-', '*', and '/'.
    Each operand may be an integer or another expression.
    The division between two integers always truncates toward zero.
    There will not be any division by zero.
    The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.
     
    
    Example 1:    
    Input: tokens = ["2","1","+","3","*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9

    Example 2:    
    Input: tokens = ["4","13","5","/","+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) -----------------------------------------------------
    ----------------------------------------------------- Space Complexity: O(n) -----------------------------------------------------
*/
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String tok: tokens)
        {
            if(tok.equals("+") || tok.equals("-") || tok.equals("*") || tok.equals("/"))
            {
                int num2 = stack.pop();
                int num1 = stack.pop();

                if(tok.equals("+"))
                {
                    stack.push(num1+num2);
                }
                else if(tok.equals("-"))
                {
                    stack.push(num1-num2);
                }
                else if(tok.equals("*"))
                {
                    stack.push(num1*num2);
                }
                else if(tok.equals("/"))
                {
                    stack.push(num1/num2);
                }
            }
            else
            {
                int num = Integer.parseInt(tok);
                stack.push(num);
            }
        }

        return stack.pop();
    }
}
