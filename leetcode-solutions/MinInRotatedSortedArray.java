/*
    Leetcode.153 Find Minimum in Rotated Sorted Array (Medium)
    Suppose an array of length n sorted in ascending order is rotated between 1 and n times. 
    For example, the array nums = [0,1,2,4,5,6,7] might become:
    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.
    
    Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].    
    Given the sorted rotated array nums of unique elements, return the minimum element of this array.    
    You must write an algorithm that runs in O(log n) time.   

    Example 1:    
    Input: nums = [3,4,5,1,2]
    Output: 1
    Explanation: The original array was [1,2,3,4,5] rotated 3 times.
    
    Example 2:    
    Input: nums = [4,5,6,7,0,1,2]
    Output: 0
    Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
*/

//--------------------------------------------------------------Time Complexity: O(log n) -----------------------------------------------------------
//--------------------------------------------------------------Space Complexity: O(1) -----------------------------------------------------------
public class MinInRotatedSortedArray
  {
    public int findMin(int[] nums) {
        int left =0;
        int right = nums.length-1;

        while(left < right)
        {
            int mid = left + (right-left)/2;

            if(nums[mid] <= nums[right])
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }
        }

        return nums[left];
    }
  }

//------------------------------------------------------- Leetcode 154. Find Minimum in Rotated Sorted Array II (Hard)----------------------------------
//---------------------------------------------------------------- Array contains duplicates -------------------------------------------------------------

public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        if (nums[left] < nums[right])
        {
            return nums[left];
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        
        return nums[right];
    }




