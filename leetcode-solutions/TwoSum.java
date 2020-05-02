/*
    Problem: Leetcode.1 Two Sum (Easy)
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
    --------------------------------------------------------------------------------------------------------------------------------
    Problem: Leetcode. Two Sum II - Input Array is Sorted (Easy)
    Given an array of integers that is already sorted in ascending order,
    find two numbers such that they add up to a specific target number.
    The function twoSum should return indices of the two numbers such that they add up to the target,
    where index1 must be less than index2.

    Note:
    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.
    
    Example:
    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
    --------------------------------------------------------------------------------------------------------------------------------
*/

import java.util.*;

public class TwoSum {

    //--------------------------------------------- Time Complexity: O(n log (n)) -------------------------------------------------
    //------------------------------------------------- Space Complexity: O(1) ----------------------------------------------------
    //-------------------------------- Two Sum II - Input Array is Sorted (Time Complexity: O(n)) ---------------------------------

    public static int[] twoSumIndex(int[] nums, int target){
    
        Arrays.sort(nums);
        
        int[] result = new int[2];
        int i= 0;
        int j = nums.length-1;

        while (i<j){
        
            if(nums[i]+nums[j]< target){
                i++;
            } else if(nums[i]+nums[j]> target){
                j--;
            }else{
                result[0]=i;
                result[1]=j;
                break;
            }
            
        }
        return result;

    }

    //-------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
    //------------------------------------------------- Space Complexity: O(n) -----------------------------------------------------
    
    public static int[] twoSumHash (int[] nums, int target){
    
        int[] result = new int[2];
        Map<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0; i<nums.length;i++){
        
            int diff = target- nums[i];
            
            if(hashMap.containsKey(diff)){
                result[0]= i;
                result[1] = hashMap.get(diff);
                return result;
            }
            
            hashMap.put(nums[i],i);
        }
        
        return result;
    }
    
    //--------------------------------------------- Time Complexity: O(n log (n)) -------------------------------------------------
    //------------------------------------------------- Space Complexity: O(1) -----------------------------------------------------
    
    public static int twoSumCount (int[] nums, int target){
        
        Arrays.sort(nums);
        
        int i =0;
        int j= nums.length-1;
        int count =0;

        while(i<j){
            
            if(nums[i]+nums[j] < target){
                i++;
            }else if (nums[i]+nums[j] > target){
                j--;
            }else{               
                count++;
                i++;
                j--;
                
                while(i<j && nums[i]==nums[i-1]){
                    i++;
                }
                
                while(i<j && nums[j]==nums[j+1] ){
                    j--;
                }
                
            }
        }
        
        return count;
    }

}

