/*
    Problem: Leetcode.153 Minimum in Rotated Sorted Array (Medium)
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]). Find the minimum element.
    You may assume no duplicate exists in the array.

    Example 1:
    Input: [3,4,5,1,2] 
    Output: 1
    --------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=IzHR_U8Ly6c
    --------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(log (N)) -------------------------------------------------

*/

public class MinInRotatedSortedArray {

    public static int searchMin(int[] nums){
    
        if (nums.length==1){
            return nums[0];
        }
        
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
        
            int mid = left+(right-left)/2;

            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }

            if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }

            if(nums[mid] > nums[0]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
    
        int[] nums ={4,5,6,7,0,1,2};
        System.out.println(searchMin(nums));
    }

}
