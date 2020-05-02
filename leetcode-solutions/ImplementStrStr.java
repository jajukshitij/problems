/*
    Problem: Leetcode.28 Inplement strStr() (Easy)
    Implement strStr().
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:
    Input: haystack = "hello", needle = "ll"
    Output: 2
    ------------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
                                                                              n = number of chars in haystack
    ------------------------------------------------------- Space Complexity: O(1) -----------------------------------------------------
    
*/

public static class ImplementStrStr {

    public int strStr(String haystack, String needle) {
    
        int nLen = needle.length();
        int hLen = haystack.length();
        
        for(int i=0; i<=hLen-nLen; i++){
        
            if(haystack.substring(i,i+nLen).equals(needle)){
                return i;
            }
        }
        
        return -1;
        
        //return haystack.indexOf(needle);
    }
}
