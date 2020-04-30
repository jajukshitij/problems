/*
    Problem: Pancake Sort
    Given an array of integers arr:
    Write a function flip(arr, k) that reverses the order of the first k elements in the array arr.
    Write a function pancakeSort(arr) that sorts and returns the input array.
    You are allowed to use only the function flip you wrote in the first step in order to make changes in the array.
    
    Example:
    input:  arr = [1, 5, 4, 3, 2]
    output: [1, 2, 3, 4, 5] # to clarify, this is pancakeSort's output
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n^2) -----------------------------------------------------
                                                                           flip: O(k/2) ; pankcakeSort: O(n^2)
    ----------------------------------------------------- Space Complexity: O(1) ------------------------------------------------------
*/

public class PancakeSort {

    public static int[] pancakeSort(int[] arr) {
        int n = arr.length;

      // Sorting from end postion i.e. putting largest element at end, one at a time
        while(n>=0){
            
            // Getting max element in current search space
            int max = arr[0];
            int idx = 0;

            for(int i=1; i<n; i++){
            
                if(arr[i]> max){
                    max= arr[i];
                    idx = i;
                }
            }
            
            flip(arr, idx+1); // Flipping 0 to max element , to get max element at the first position
            flip(arr, n); // flipping the whole array to get max element to last
            n--; // reducing the search spacefrom 0 to n-1 as n holds the right element i.e. max element
        }

        return arr;
    }

    public static void flip(int[] arr, int k){
    
        int start =0;
        int end = k-1;

        while(start<end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }
    
    public static void main(String[] args) {
    
        int[] arr ={3,1,2,4,6,5};
        int[] res = pancakeSort(arr);
    }

}
