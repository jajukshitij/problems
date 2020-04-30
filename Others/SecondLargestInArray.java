/*
    Problem: Find the second largest element in the Array
    ------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: O(n) ------------------------------------------------------
*/

public class KthLargestInArray {

    public static int secondLargestElement(int[] nums){

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int n: nums){

            if(n> first){
                second = first;
                first = n;

            } else if(n > second && n < first){
                second = n;
            }
        }

        return second;
    }
    
     public static void main(String[] args){
 
        int[] nums = {12, 35, 1, 10, 34, 1};
        System.out.println(secondLargestElement(nums));
    }
}
