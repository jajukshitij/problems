/*
    Problem: Leetcode.22 Generate Parantheses (Medium)
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    For example, given n = 3, a solution set is:

    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]
    -------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=qBbZ3tS0McI
    -------------------------------------------------------------------------------------------------------------------------------
    
*/

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    public static List<String> genereateParanthese(int n){
        List<String> result = new ArrayList<>();
        helper(result, "",0,0,n);
        return result;
    }

    public static void helper(List<String> result, String current, int open, int close, int max){
        
        if(current.length()== max*2){
            result.add(current);
            return;
        }

        if(open<max){
            helper(result, current+"(",open+1, close, max);
        }
        if(close<open){
            helper(result,current+")",open, close+1, max);
        }
    }
}
