/*
    Problem: Leetcode.215 Kth Largest Element in Array (Medium)
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
    not the kth distinct element.

    Example 1:
    Input: [3,2,1,5,6,4] and k = 2
    Output: 5
    --------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=FrWq2rznPLQ
    -------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: O(N log(k)) -------------------------------------------
    ---------------------------------------------------- Space Complexity: O(k) ----------------------------------------------
*/

import java.util.PriorityQueue;

public class KthLargestInArray {

    public static int kthLargestElement(int[] nums, int k){
        // ----Time Complexity: O(n log n)--
        /*Arrays.sort(nums);
        return nums[nums.length-k];*/

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int n : nums){
            priorityQueue.add(n);

            if(priorityQueue.size()>k){
                priorityQueue.remove();
            }
        }

        return priorityQueue.remove();
    }
    
    public static void main(String[] args){
        int[] nums1 = {3,2,3,1,2,4,5,5,6};
        int[] nums2 = {3,2,1,5,6,4};

        System.out.println(kthLargestElement(nums1,4));
        System.out.println(kthLargestElement(nums2,2));
    }
    
}
