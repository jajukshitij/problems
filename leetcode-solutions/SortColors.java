/*
    Problem: Leetcode.75 Sort Colors (Medium)
    Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
    with the colors in the order red, white and blue.
    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
    Note: You are not suppose to use the library's sort function for this problem.

    Example:
    Input: [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
    ------------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=uvB-Ns_TVis
    ------------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) -------------------------------------------------------
*/

public class SortColors {

    public static void sortColors (int[] nums){
    
        int start = 0; // Pointer for 0 to place at
        int end = nums.length-1; // Pointer for 2 to place at
        int curr = 0; // Pointer to iterate
        int temp = -1;

        while(curr <= end && start < end){

            if(nums[curr]==0){ // 0 found while iteration, swap it with start poition
            
                temp = nums[curr];
                nums[curr] = nums[start];
                nums[start]= temp;
                
                curr++;
                start++;
                
            } else if(nums[curr] == 2){ // 2 found while iteration, swap it with end poition
            
                temp = nums[curr];
                nums[curr] = nums[end];
                nums[end] = temp;
                
                end--;
                
            }else{ // 1 found in middle
                curr++;
            }
            
        }
    }
    
    public static void main(String[] args){
    
        int[] nums ={2,0,2,1,1,0};
        sortColors(nums);

        for(int i=0; i <nums.length;i++){
            System.out.println(nums[i]);
        }
    }
    
}
