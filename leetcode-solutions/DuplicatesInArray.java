/*
    Problem: Leetcode.442 Find All Duplicates in an Array (Medium)
    
    Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    Find all the elements that appear twice in this array.
    Could you do it without extra space and in O(n) runtime?

    Example:
    Input:
    [4,3,2,7,8,2,3,1]
    Output:
    [2,3]
    --------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------- Time Complexity: O(n) --------------------------------------------------
    ------------------------------------------------------- Space Complexity: O(1) -------------------------------------------------
*/

import java.util.ArrayList;
import java.util.List;

public class DuplicatesinArray {

    public static void main(String[] args){
        int[] nums= {4,3,2,7,8,2,3,1};

        System.out.println(findDuplicates(nums));
    }

    // Use the fact : 1 ≤ a[i] ≤ n (n = size of array)
    // Go to the element pointed by current element as index 
    // i.e. for 4,3,2,7,8,2,3,1 -> when i = 4, new_element = nums[4-1] = 7
    // mark new elemnent negative 7 -> -7
    // if another 4 in the array, new_element will again point to num[4-1]
    // if value of nums[4-1] = negative then we know we have already seen 4 before, hence duplicate found
    
    public static List<Integer> findDuplicates(int[] nums){
        List<Integer> list = new ArrayList<>();

        for(int i=0; i< nums.length;i++) {
            int index = Math.abs(nums[i])-1; // get the index of new_element, 4-1
            
            if(nums[index]<0){ // Duplicate found, -7 exists
                list.add(index+1);
            }
            nums[index] = -nums[index]; // mark the new_element negative
        }

        return list;
    }
  }
