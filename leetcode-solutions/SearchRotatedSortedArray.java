/*
Leetcode.33 Search in Rotated Sorted Array (Medium)
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity. 

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

Constraints:
1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
*/

public class SearchRotatedSortedArray{

  public int search(int[] nums, int target) {
        if(nums== null || nums.length==0)
        {
            return -1;
        }

        if(nums.length==1)
        {
            if(nums[0]== target)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }        

        int n = nums.length;

        if(nums[0]< nums[n-1])
        {
            return binarySearch(nums, 0, n-1, target);
        }

        int p = findPivot(nums);

        if(nums[p]== target)
        {
            return p;
        }
        else if(target < nums[0])
        {
            return binarySearch(nums, p, n-1,target);
        }
        else
        {
            return binarySearch(nums,0, p, target);
        }
    }

    public int binarySearch(int[] nums, int left, int right, int target)
    {
        while(left <= right)
        {
            int mid = left +(right-left)/2;

            if(nums[mid]== target)
            {
                return mid;
            }
            else if(nums[mid]> target)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }

        return -1;
    }

    public int findPivot(int[] nums)
    {
        int left =0;
        int right = nums.length-1;

        while(left <= right)
        {
            int mid = left +(right-left)/2;

            if(nums[mid]>nums[mid+1])
            {
                return mid+1;
            }
            if(nums[mid-1]>nums[mid])
            {
                return mid;
            }

            if(nums[mid]>nums[0])
            {
                left = mid+1;
            }
            else
            {
                right = mid;
            }
        }

        return -1;
    }
}
