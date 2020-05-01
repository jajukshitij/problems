/*
    Problem: Leetcode.8 String To Integer (Medium)
    Implement atoi which converts a string to an integer.
    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
    Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
    and interprets them as a numerical value.
    The string can contain additional characters after those that form the integral number,
    which are ignored and have no effect on the behavior of this function.
    If the first sequence of non-whitespace characters in str is not a valid integral number,
    or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
    If no valid conversion could be performed, a zero value is returned.

    Note:
    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
    
    Example 1:

    Input: "42"
    Output: 42
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=lJy5GhKYHl0
    ----------------------------------------------------------------------------------------------------------------------------------
    
*/

public class StringtoInteger {

    public static int myAtoi(String str) {
    
        if(str ==null || str.length()==0){
            return 0;
        }

        str= str.trim();

        double result = 0;
        int start =0;

        boolean isNeg = false;

        if(start < str.length() && (str.charAt(start)=='+' || str.charAt(start)=='-')){
            start++;
        }
        if(start < str.length() && (str.charAt(0)=='-')){
            isNeg = true;
        }

        if( start < str.length() && Character.isDigit(str.charAt(start)) ){
        
            for(int i= start; i < str.length(); i++){
            
                if(!Character.isDigit(str.charAt(i))){
                    break;
                }
                
                int digit = (int) (str.charAt(i)-'0');
                result = result *10 + digit;
            }
        }

        if(isNeg){
            result = -result;
        }

        if(result > Integer.MAX_VALUE ){
            result = Integer.MAX_VALUE;
        }else if(result < Integer.MIN_VALUE ){
            result = Integer.MIN_VALUE;
        }

        return (int) result;
    }
    
    public static void main(String[] args){
        System.out.println("Result :: "+ myAtoi("+"));
    }
}
