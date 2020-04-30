/*
    Problem: Leetcode.163 Missing Ranges
    Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
    Example:
    Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
    Output: ["2", "4->49", "51->74", "76->99"]
    -------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
*/
import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static List<String> missingRanges(int[] nums, int lower, int upper){
    
        List<String> result = new ArrayList<>();

        if(lower== Integer.MAX_VALUE){
            return result;
        }

        if(nums== null || nums.length==0){
            helper(result,lower,upper);
            return result;
        }

        int start = lower;

        for(int i=0; i<nums.length; i++){

            if(i<nums.length-1 && nums[i]==nums[i+1]){ // Handling duplicates
                continue;
            }

            if(nums[i]==start){
                start++;
            }else{
                helper(result,start,nums[i]-1);
                
                if(nums[i] == Integer.MAX_VALUE){
                    return result;
                }
                start = nums[i]+1;
            }
        }

        if(start <= upper){ // If last element != upper
            helper(result, start, upper);
        }

        return result;
    }


    public static void helper(List<String> result, int left,int right){
    
        if (left==right){
            result.add(String.valueOf(left));
        }else {
            result.add(String.valueOf(left) + "->" + String.valueOf(right));
        }
    }
    
    public static void main(String[] args){
        int[] nums= {0, 1, 3, 50, 75};
        System.out.println(missingRanges(nums, 0, 99));
    }
    
}
