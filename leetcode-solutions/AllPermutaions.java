/*
    Problem: (Similar to Leetcode. 46 Permutations )
    Find all the possible permutaions of the given string.
    --------------------------------------------------------------------------------------------------------------
    
    Reference: 
    https://www.youtube.com/watch?v=KBHFyg2AcZ4
    https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    -------------------------------------------------------------------------------------------------------------
    --------------------------------- Time Complexity: O(n! * n) ------------------------------------------------
                                                       n = length of the string ; 
                                                       number of permutaions = n! ; time to print each permutation = n
                                                       
*/


public class AllPermutations {

    public static void permutations(String input){
        int end = input.length()-1;
        char[] chars = input.toCharArray();
        
        permute(chars, 0, end);
    }

    public static void permute(char[] subStr, int start, int end){

        if(start==end){
            System.out.println(String.valueOf(subStr));
        }else{
            for(int i=start; i<=end; i++){

                swap(subStr,start,i);
                permute(subStr,start+1,end);
                swap(subStr,start,i);
            }
        }
    }

    public static void swap (char[] cArray, int i, int j){

        char temp = cArray[i];
        cArray[i] = cArray[j];
        cArray[j] = temp;

    }
}

