/*
    Problem: Array Index & Element Equality
    Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i.
    Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.

    Examples:
    input: arr = [-8,0,2,5]
    output: 2 # since arr[2] == 2

    input: arr = [-1,0,3,6]
    output: -1 # since no index in arr satisfies arr[i] == i
    -----------------------------------------------------------------------------------------------------------------------------------
   
*/

public class IndexAndElementEquality {

    // ----------------------------------------------- Time Complexity: O(log n)------------------------------------------------------
    // -------------------------------------------Space Complexity: Iterative: O(1) ; Recursive: O(log n)-----------------------------

    public static void findFixedPoint(int[] arr){

        System.out.println("Recursive: "+ binaryRecursive(arr,0, arr.length-1));
        System.out.println("Interative: "+binaryiterative(arr, 0, arr.length-1));
    }

    public static int binaryRecursive (int[] arr, int left, int right){

        if (left<=right){
            int mid = left + (right-left)/2;

            if(arr[mid]== mid){
                int smaller = binaryRecursive(arr, left, mid-1);
                if(smaller!=-1){
                    mid = smaller;
                }
                return mid;
            }else if(arr[mid]<mid){
                return binaryRecursive(arr,mid+1,right);
            }else{
                return binaryRecursive(arr,left,mid-1);
            }
        }
        return -1;
    }

    public static int binaryiterative(int[] arr, int left, int right){

        while(left<=right){
            int mid = left + (right-left)/2;

            if(arr[mid]<mid){
                left = mid+1;
            }else if(arr[mid]== mid &&(mid==0 || arr[mid-1]<mid-1)){
                return mid;
            }else {
                right = mid-1;
            }
        }

        return -1;
    }
    
    public static void main(String[] args){

        int[] arr1 = {-8,0,2,5};
        int[] arr2 = {-1,0,2,3,7,8,9};

        System.out.println("Array 1");
        findFixedPoint(arr1);
        System.out.println("Array 2");
        findFixedPoint(arr2);
    }
}
