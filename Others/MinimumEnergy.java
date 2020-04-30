/*
    Problem: Minimum Initial Energy Required To Cross Street
    Given an array containing positive and negative numbers.The array represents checkpoints from one end to other end of street.
    Positive and negative values represent amount of energy at that checkpoint.
    Positive numbers increase the energy and negative numbers decrease.
    Find the minimum initial energy required to cross the street such that Energy level never becomes 0 or less than 0.
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.geeksforgeeks.org/minimum-initial-energy-required-to-cross-street/
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) ------------------------------------------------------
*/

public class MinimumEnegry {

    public static int minEnergy(int[] nums){
        int n = nums.length;
        int curr_energy = 0;
        int min_energy =0;
        boolean flag = false;

        for(int i=0; i<n; i++){
            curr_energy += nums[i];

            if(curr_energy <= 0){
                min_energy = Math.max(min_energy,Math.abs(curr_energy)+1);
                flag = true;
            }
        }

        if(flag) {
            return min_energy;
        }else{
            return 1;
        }
    }
    
    public static void main(String[] args){

        int[] nums1 = {4, -10, 4, 4, 4};
        int[] nums2 = {3, 5, 2, 6, 1};
        int[] nums3 = {-1, -5, -9};
        System.out.println(minEnergy(nums1));
        System.out.println(minEnergy(nums2));
        System.out.println(minEnergy(nums3));
    }
}
