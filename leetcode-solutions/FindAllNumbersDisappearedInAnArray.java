/*
Leetcode 448. Find All Numbers Disappeared in an Array (Easy)
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]
 
Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
*/


public class FindDisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {

      /*List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i=1; i<= nums.length; i++)
        {
            set.add(i);
        }

        for(int i=0; i< nums.length; i++)
        {
            if(set.contains(nums[i]))
            {
                set.remove(nums[i]);
            }
        }

        result.addAll(set);

        return result;*/ 

      
        List<Integer> result = new ArrayList<Integer>();

        for(int i =0; i< nums.length; i++)
        {
            int index = Math.abs(nums[i]);

            if(nums[index-1]>0)
            {
            nums[index-1] = - nums[index-1];
            }
        }

        for(int i =0; i< nums.length; i++)
        {            
            if(nums[i]>0)
            {
                result.add(i+1);
            }
        }

        return result;       
    }
}
