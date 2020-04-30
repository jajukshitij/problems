/*
    Problem: Leetcode.154 Minimum in Rotated Sorted Array (Hard)
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]). Find the minimum element.
    The array may contain duplicates.

    Example 1:
    Input: [1,3,5]
    Output: 1
    --------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(log (N)) -------------------------------------------------

*/

public class MinInRotatedSortedArrayII {

    public int searchMin (int[] nums){
    
        int low = 0;
        int high = nums.length-1;

        while(low<high){
            int mid = low + (high-low)/2;

            if(nums[mid]> nums[high]){
                low = mid+1;
            } else if(nums[mid]< nums[high]){
                high = mid;
            }else{
                high--;
            }
        }
        return nums[low];
        
    }

    public static void main(String[] args){
    
        int[] nums = {3,4,5,1,2};
        System.out.println(searchMin(nums));
    }

}
