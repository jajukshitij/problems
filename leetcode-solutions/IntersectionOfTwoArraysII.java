/*
    Problem: Leetcode. Intersection of Two Arrays II
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    
    //--------------------------------------------------- Method 1: Two Pointer -----------------------------------------------------
    //------------------------------------------- Time Complexity: O(n log(n) + m log (m)) --------------------------------------
    //------------------------------------------------ Space Complexity: O(1) ----------------------------------------------------

    public static int[] intersect(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;
        int i=0;
        int j=0;
        int count =0;

        while(i<len1 && j<len2){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                nums1[count] = nums1[i];
                count++;
                i++;
                j++;
            }
        }

        return Arrays.copyOfRange(nums1,0,count);
    }

    //--------------------------------------------------- Method 1: HashMap -----------------------------------------------------
    //------------------------------------------------ Time Complexity: O(n + m) ------------------------------------------------
    //--------------------------------------------- Space Complexity: O( Min(n,m)) ----------------------------------------------

    public static int[] intersectHashMap(int[] nums1, int[] nums2){

        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1>len2){
            return intersectHashMap(nums2,nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums1){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        int count =0;

        for(int n: nums2){
            if(map.containsKey(n) && map.get(n)>0){
                nums1[count]= n;
                count++;

                int k = map.get(n)-1;
                map.put(n, k);
            }
        }

        return Arrays.copyOfRange(nums1, 0,count);

    }
}
