/*
    Problem: Leetcode.42 Trapping Raing Water (Hard)
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it is able to trap after raining.
    
    Example:
    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=HmBbcDiJapY
    
*/

public class TrappingRainWater {

    // -------------------------------------------- Time Complexity: O(n)---------------------------------------------
    //--------------------------------------------- Space Complexity: O(1) -------------------------------------------

    public static int trappingRainWater(int[] height){

        if(height.length<=1){
            return 0;
        }

        int left = 0;
        int right = height.length-1;
        int left_max = 0;
        int right_max = 0;
        int res = 0;

        while(left < right){

            if(height[left]<height[right]){

                if(height[left] > left_max){
                    left_max = height[left];
                }else{
                    res += left_max - height[left];
                }
                left++;

            }else{

                if(height[right] > right_max){
                    right_max = height[right];
                }else{
                    res += right_max - height[right];
                }
                right--;
            }
        }

        return res;

    }

    // -------------------------------------------- Time Complexity: O(n^2)---------------------------------------------
    //--------------------------------------------- Space Complexity: O(1) -------------------------------------------

    public static int trappingRainWaterBruteForce (int[] height){

        int n = height.length;
        int res = 0;

        for(int i=0; i<n; i++){
            int left_max = 0;
            int right_max = 0;

            for(int j=0; j<i; j++){
                left_max = Math.max(left_max, height[j]);
            }

            for(int j=i+1; j<n; j++){
                right_max = Math.max(right_max, height[j]);
            }

            int min =  Math.min(left_max, right_max);
            res += Math.max(0,min-height[i]);

        }

        return res;
    }
    
    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater(height));
        System.out.println(trappingRainWaterBruteForce(height));
    }
}
