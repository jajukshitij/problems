/*
    Problem: Leetcode. 283 Move Zeroes
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    
    Example:
    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Note:
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------Time Complexity: O(n) -------------------------------------------------------
*/

public class MoveZeroes {

    public static void moveZeroes(int[] nums){

        int n = nums.length;
        int zero = 0;

        for(int i=0; i<n; i++){
        
            if(nums[i]!=0){
                
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                zero++;
            }
        }
    }
    
    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int i=0; i< nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
