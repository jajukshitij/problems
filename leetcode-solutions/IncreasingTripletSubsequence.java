/*
    Problem: Leetcode. 334 Increasing Triplet Subsequence (Medium)
    Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
    Formally the function should:
    Return true if there exists i, j, k
    such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
    Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

    Example 1:
    Input: [1,2,3,4,5]
    Output: true
    --------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
*/

public class IncreasingTripletSubsequence {

    public static boolean isTriplet(int[] nums){
        if(nums==null || nums.length<3){
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num: nums){
            if(num<=first){
                first = num;
            }else if(num <=second){
                second = num;
            }else{
                return true;
            }
        }
        return false;
    }
}
