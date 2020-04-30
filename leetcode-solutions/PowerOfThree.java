/*
    Problem: Leetcode.326 Power Of Three (Easy)
    Given an integer, write a function to determine if it is a power of three.

    Example 1:
    Input: 27
    Output: true
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------ Time Complexity: O(log n) -------------------------------------------------------
                                                                      log base 3 (n)
    ------------------------------------------------- Space Complexity: O(1) ---------------------------------------------------------
*/

public class PowerOfThree {

    public static boolean isPower(int n){
    
        if(n<1){
            return false;
        }

        while(n%3==0){
            n= n/3;
        }

        if(n==1){
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String[] args){
        System.out.println(isPower(27));
    }
}
