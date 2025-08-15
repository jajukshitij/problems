/*
    Problem: Leetcode. 541 Reverse String II (Easy)
    Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
    If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, 
    then reverse the first k characters and leave the other as original.
    
    Example 1:
    Input: s = "abcdefg", k = 2
    Output: "bacdfeg"
    
    Example 2:
    Input: s = "abcd", k = 2
    Output: "bacd"
    ---------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
    -------------------------------------------------- Space Complexity: O(n) -------------------------------------------------------
 
*/
public class ReverseStringII {
   public String reverseStr(String s, int k) 
   {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i=0;

        while(i<n)
        {
            int j = Math.min(i+k-1, n-1);
            reverse(arr, i, j);
            i = i+2*k;
        }

        return String.valueOf(arr);
    }

    public void reverse(char[] arr, int i, int j)
    {
        while(i <j)
        {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
