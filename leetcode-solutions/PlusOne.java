/*
    Problem: Leetcode.66 Plus One (Easy)
    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
    The digits are stored such that the most significant digit is at the head of the list,
    and each element in the array contain a single digit.
    You may assume the integer does not contain any leading zero, except the number 0 itself.

    Example 1:
    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    -----------------------------------------------------------------------------------------------------------------------------------
*/

public class PlusOne {

    public static int[] plusOne(int[] digits){

        int n = digits.length;

        for(int i=n-1; i>=0; i--){

            if(digits[i] < 9){
            
                digits[i]++;
                break;
            }else {
                digits[i] = 0;
            }
            
        }

        if( digits[0] == 0) { // If first element is 0 then we need to just put a 1 before all these 0
        
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }

        return digits;
    }
    
    public static void main(String[] args){
        int[] digits = {1,2,3};
        int[] nums = plusOne(digits);
        for(int i=0; i< nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
    
}
