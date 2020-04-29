/*
    Problem: Find The Duplicates
    Given two sorted arrays arr1 and arr2 of passport numbers, implement a function findDuplicates that returns an array of all passport numbers that are both in arr1 and arr2.
    Note that the output array should be sorted in an ascending order.
    Let N and M be the lengths of arr1 and arr2, respectively.
    Solve for two cases and analyze the time & space complexities of your solutions: 
    M ≈ N - the array lengths are approximately the same M ≫ N - arr2 is much bigger than arr1.

    Example:
    input:  arr1 = [1, 2, 3, 5, 6, 7], arr2 = [3, 6, 7, 8, 20]
    output: [3, 6, 7] # since only these three values are both in arr1 and arr2
*/

import java.util.ArrayList;
import java.util.List;

public class DuplicatesinArray {

    public static void main(String[] args){
    
        int[] a= {1, 2, 3, 5, 6, 7};
        int[] b ={3, 6, 7, 8, 20};
        findCommon(a,b);
    }

    // Case 1. When M ≈ N - the array lengths are approximately the same
    // -------------------------------------------- Time Complexity: O(M+N)--------------------------------------------------------

    public static int[] findCommon(int[] arr1, int[] arr2) {
        int i =0;
        int j =0;

        int n = arr1.length;
        int m = arr2.length;
        List<Integer> result = new ArrayList<>();

        while(i< n && j < m){

            if(arr1[i] <arr2[j]){
                i++;
            } else if(arr1[i]> arr2[j]){
                j++;
            }else{
                result.add(arr1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[result.size()];

        for(int k =0; k< result.size(); k++){
            res[k] = result.get(k);
        }

        return res;
    }

    // Case 2. When M >> N - arr2 is much bigger than arr1
    // -------------------------------------------- Time Complexity: O(N log(M))--------------------------------------------------------

    public static int[] findCommon2(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        if(n> m){
            return findCommon2(arr2, arr1);
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0; i< n; i++){
            if(binarySearch(arr2, arr1[i])!= -1){
                result.add(arr1[i]);
            }
        }

        int[] res = new int[result.size()];

        for(int k =0; k< result.size(); k++){
            res[k] = result.get(k);
        }


        return res;

    }

    public static int binarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid] == key){
                return mid;
            }else if(arr[mid]> key){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return -1;
    }


}
