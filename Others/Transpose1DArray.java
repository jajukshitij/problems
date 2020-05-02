/*
    Problem: Transpose 1D Array
    Given a 1D array, find the transpose without converting it into a 2D array.
    
    Example:
    Input: [0,1,2,3,4,5,6,7,8]
    Output: [0,3,6,1,4,7,2,5,8]
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
*/

public class Transpose1DArray {

    //-------------------------------------------------- Method 1: Extra Space -------------------------------------------------------
    //-------------------------------------------------- Space Complexity: O(n) ------------------------------------------------------
    
    public static void transpose(int[] array){

        int[] new_arr = new int[len];
        int k=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                new_arr[k++]= array[n*j+i]; // set for loop j=0
            }
        }

        for (int p: new_arr){
            System.out.print(p+" ");
        }
    }
    
    //-------------------------------------------------- Method 2: Space Optimized ---------------------------------------------------
    //-------------------------------------------------- Space Complexity: O(1) ------------------------------------------------------
    
    public static void transpose2(int[] array){
    
        int len  = array.length;
        int n = (int) Math.sqrt(len);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                int temp = array[n * i + j];
                array[n * i + j] = array[n * j + i];
                array[n * j + i] = temp;
            }
        }

        for (int p: new_arr){
            System.out.print(p+" ");
        }
    }
    
    public static void main(String[] args){
        int[] array = {0,1,2,3,4,5,6,7,8};
        
        transpose(array);
    }
}
