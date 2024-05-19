/*
    Problem: Leetcode.88 Merge Sorted Array (Easy)
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    Note: The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
    
    Example:
    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3
    Output: [1,2,2,3,5,6]
    --------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=LXq6wnkkeNA
    --------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(M+N) ----------------------------------------------------
    --------------------------------------------------- Space Complexity: O(1) ----------------------------------------------------
*/

public class MergeSortedArray {

    public static void mergeArray(int[] nums1, int[] nums2, int m, int n){
    
        // Two pointers at end of each array for comparison
        int i = m-1;
        int j = n-1;
        int count = m+n-1;

        while(i>=0 && j>=0){
        
            if(nums1[i]> nums2[j]) {
                nums1[count] = nums1[i];
                i--;
            }else{
                nums1[count] =  nums2[j];
                j--;
            }
            count--;
        }

        while(j>=0){
        
            nums1[count] = nums2[j];
            count--;
            j--;
        }
    }
}
