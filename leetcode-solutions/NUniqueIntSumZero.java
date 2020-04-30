/*
    Problem: Leetcode.1304 Find N Unique Integers Sum up to Zero (Easy)
    Given an integer n, return any array containing n unique integers such that they add up to 0.

    Example 1:
    Input: n = 5
    Output: [-7,-1,1,3,4]
    Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=4LoajzOxF4I
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) ------------------------------------------------------
*/

public class NUniqueIntSumZero {

    // -------------------------------------------------- Method 1.  Sum of n-1 -------------------------------------------------------
    public static int[] sumZero(int n){
    
        int[] res = new int[n];
        int sum = 0;

        // Getting sum of n-1 numbers 
        for(int i=0; i<n-1; i++){
            res[i] =i;
            sum = sum+i;
        }

        // Adding last element as -ve sum to make total 0
        res[n-1] = -sum;

        return res;
    }

    // -------------------------------------------------- Method 2.  Sum of n/2 -------------------------------------------------------

    public static int[] sumZero2(int n){
    
        int[] res = new int[n];
        int index = 0;

        // Left half elements are from -ve n/2 to 0 (included if n is odd)
        // Right half element are from 0 (included if n is odd) to n/2
        for(int i=-n/2; i<=n/2; i++){
        
            if(i==0 && n%2==0){ // if n is odd then middle element is 0
                continue;
            }
            res[index++] = i;
        }

        return res;
    }
}
