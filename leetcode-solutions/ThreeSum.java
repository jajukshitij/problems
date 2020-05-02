/*
    Problem: Leetcode.15 3Sum (Medium)
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.
    Note:
    The solution set must not contain duplicate triplets.
    
    Example:
    Given array nums = [-1, 0, 1, 2, -1, -4],
    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
    ------------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(n^2) ---------------------------------------------------------
*/

    // ---------------------------------------------- Space Complexity: O(1) -----------------------------------------------------------
import java.util.Arrays;

public class ThreeSum {

    public static int[] threeSum( int[] nums,int target){

        Arrays.sort(nums);
        int[] result = {-1,-1,-1};

        for(int i=0 ; i<nums.length ;i++){
        
            int j = i+1;
            int k = nums.length-1;
            
            while(j<k){
            
                if(nums[i]+nums[j]+nums[k] < target){
                    j++;
                }
                if(nums[i]+nums[j]+nums[k] > target){
                    k--;
                }
                
                if(nums[i]+nums[j]+nums[k] == target){
                    result[0] = nums[i];
                    result[1] = nums[j];
                    result[2] = nums[k];
                    return  result;
                }
            }
        }

        return  result;
    }
    
    // ------------------------------------------------- Space Complexity: O(n) ----------------------------------------------------
    // Without sorting, using HashSet
    // https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
    
    public static boolean threeSum (int[] A, int sum){

        for (int i = 0; i < arr_size - 2; i++) {

            // Find pair in subarray A[i+1..n-1]
            // with sum equal to sum - A[i]
            
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            
            for (int j = i + 1; j < arr_size; j++) {
            
                if (s.contains(curr_sum - A[j]) && curr_sum - A[j] != (int)s.toArray()[s.size() - 1]) {
                
                    System.out.printf("Triplet is %d, %d, %d", A[i],
                                      A[j], curr_sum - A[j]);
                    return true;
                }
                
                s.add(A[j]);
            }
        }
        
        return false
    }

}

