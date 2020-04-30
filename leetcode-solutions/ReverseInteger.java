/*
    Problem: Leetcode.7 Reverse Integer (Easy)
    Given a 32-bit signed integer, reverse digits of an integer.

    Example 1:
    Input: 123
    Output: 321
    Note:
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: 
    [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=oTZnrkGTV2w
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(log(num)) ------------------------------------------------
                                                                            log base 10 (num) = number of digits in num
*/

public class ReverseInteger {

    public static int reverseInt(int num){

        String s = String.valueOf(num);
        int start =0;
        boolean isNeg = false;

        if(s.charAt(start)=='-'){
            isNeg = true;
            start++;
        }

        double res =0;

        for(int i = s.length()-1; i >= start; i--){
        
            int digit = (int) (s.charAt(i)-'0');
            res = res*10 + digit;
        }

        if(isNeg){
            res = -res;
        }

        if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE){
            res = 0;
        }

        return (int) res;

    }
    
    public static void main(String[] args){

        System.out.println(reverseInt(-123));
    }
}
