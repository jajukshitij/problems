/*
    Problem: Leetcode.238 Product Of Array Except Self (Medium)
    Given an array nums of n integers where n > 1, return an array output such that 
    output[i] is equal to the product of all the elements of nums except nums[i].

    Example:
    Input:  [1,2,3,4]
    Output: [24,12,8,6]
    Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) 
    fits in a 32 bit integer.

    Note: Please solve it without division and in O(n).
    Follow up:
    Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=tSRFtR3pv74
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity  O(n) -------------------------------------------------------
*/

public class ProductOfArray {

    //-------------------------------------------------- Space Complexity  O(n) ------------------------------------------------------

    public static int[] productExceptSelf2(int[] nums){
    
        int n = nums.length;

        int[] left_products = new int[n]; // product of all elements to the left of curr element
        int[] right_products = new int[n];// product of all elements to the rigth of curr element
        int[] result = new int[n];

        left_products[0] = 1; // left product of element at 0 index =1
        right_products[n-1] = 1; // left product of element at n-1 index =1

        for(int i = 1; i < n; i++){
            left_products[i] = left_products[i-1]* nums[i-1];
        }

        for(int i= n-2; i >= 0; i--){
            right_products[i] = right_products[i+1]* nums[i+1];
        }

        for(int i=0; i < n; i++){
            result[i]= left_products[i] * right_products[i];
        }

        return result;
    }

    //----------------------------------------------------- Space Complexity  O(1) ---------------------------------------------------

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        result[0] = 1;
        int R = 1;

        for(int i =1; i <n; i++){
            result[i] = result[i-1]* nums[i-1];
        }

        for(int i= n-1; i>=0; i--){
            result[i] = result[i] * R;
            R = R* nums[i];
        }

        return result;
    }
    
    public static void main(String args[]) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);

        for(int i=0; i< res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
