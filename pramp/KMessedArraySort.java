/*
    Problem: K-messed Array Sort
    Given an array of integers arr where each element is at most k places away from its sorted position,
    code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2,
    an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.
    Analyze the time and space complexities of your solution.

    Example:
    input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
    output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(n log(k)) -----------------------------------------------
    ------------------------------------------------------- Space Complexity: O(k) --------------------------------------------------
    
*/

import java.util.PriorityQueue;

public class KMessedArraySort {

    public static int[] kMessedSort(int[] arr, int k){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0; i<=k; i++){ // Adding first k+1 elements in min heap
            priorityQueue.add(arr[i]);
        }

        int index =0;

        // Adding elements from min heap back in array and adding new element in heap to sort
        // maintaining size of min heap = k
        for(int i=k+1; i<arr.length; i++){
            arr[index++] = priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        // Ading last k elements from heap in array.
        while(!priorityQueue.isEmpty()){
            arr[index++] = priorityQueue.poll();
        }

        return arr;
    }
    
    public static void main(String[] main){

        int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        kMessedSort(arr, 2);
        
        for(int n: arr){
            System.out.println(n);
        }
    }
}
