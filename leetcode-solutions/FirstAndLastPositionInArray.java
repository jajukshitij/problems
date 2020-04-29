/*
    Problem: Leetcode.34 Find First and Last Position of Element in Sorted Array (Medium)
    Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
    Your algorithm's runtime complexity must be in the order of O(log n).
    If the target is not found in the array, return [-1, -1].

    Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    --------------------------------------------------------------------------------------------------------------------------------
    
*/

public class FirstAndLastPositionInArray {


    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        searchRange(nums, 6);

    }

    public static void searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearch1(nums, target);
        result[1] = binarySearch2(nums, target);

        for(int n: result){
            System.out.println( "res:::: " + n);
        }

        return;
    }

    public static int binarySearch1(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left +(right-left)/2;

            if(nums[mid]== target){
                while(mid>=1 && nums[mid-1]==target){
                    mid--;
                }
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right= mid-1;
            }
        }

        return -1;
    }

    public static int binarySearch2(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left +(right-left)/2;

            if(nums[mid]== target){
                while(mid<nums.length-1 && nums[mid+1]==target){
                    mid++;
                }
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right= mid-1;
            }
        }

        return -1;
    }
}
