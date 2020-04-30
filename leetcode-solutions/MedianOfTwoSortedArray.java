/*
    Problem: Leetcode.4 Median of Two Sorted Array (Hard)
    There are two sorted arrays nums1 and nums2 of size m and n respectively.
    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    You may assume nums1 and nums2 cannot be both empty.

    Example 1:
    nums1 = [1, 3]
    nums2 = [2]
    The median is 2.0
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
    https://www.youtube.com/watch?v=LPFhl65R7ww&feature=youtu.be
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: O( log (Min(x,y)) ) -------------------------------------------
    ------------------------------------------------------ Space Complexity: O(1) ----------------------------------------------------
*/

public class MedianOfTwoSortedArrays {

    public static double medianOfArrays(int[] nums1, int[] nums2){
    
        int x = nums1.length;
        int y = nums2.length;

        if(x>y){ // Making sure nums1 is smaller of the two 
            return medianOfArrays(nums2, nums1);
        }

        int low = 0;
        int high = x;
        int mid = (x+y+1)/2;

        while(low<=high){
            int partitionX = (low+high)/2;
            int partitionY = mid - partitionX;

            int maxLeftX = (partitionX==0)? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = (partitionX==x)? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY==0)? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = (partitionY==y)? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){ // Correct partion spot found
            
                if((x+y)%2==0){
                    return ((double) Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY))/2;
                }else{
                    return ((double) Math.max(maxLeftX,maxLeftY));
                }
                
            } else if(maxLeftX > minRightY){
                high = partitionX-1;
            } else {
                low = partitionX+1;
            }
            
        }
        return -1; // Invalid Input
    }
    
}
