/*
    Problem: Leetcode.125 Valid Palindrome (Easy)
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    Note: For the purpose of this problem, we define empty string as valid palindrome.

    Example 1:
    Input: "A man, a plan, a canal: Panama"
    Output: true
    --------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.geeksforgeeks.org/minimum-number-appends-needed-make-string-palindrome/
    --------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) ---------------------------------------------------
*/

public class PalindromeCheck {
    
    // -------------------------------------------------------- Valid Palindrome ----------------------------------------------------
    // ------------------------------------------------------ Time Complexity: O(n) -------------------------------------------------
    // ----------------------------------------------------- n = length of string ---------------------------------------------------
    
    public static boolean isPalindrome(String str){
    // Two Pointer Approach
        int i =0;
        int j= str.length()-1;

        while(i<j){
        
            while(i<j && !Character.isLetterOrDigit(str.charAt(i))){ // Reaching a valid char to compare
                i++;
            }
            
            while(i<j && !Character.isLetterOrDigit(str.charAt(j))){ // Reaching a valid char to compare
                j--;
            }

            if(i<j && Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))){
                return false;
            }
            
            i++;
            j--;
        }

        return true;
    }

    // ---------------------------- Fin Minimum character to append at end to make the string a Plaindrome ---------------------------
    // ---------------------------------------------------- Time Complexity: O(N^2) --------------------------------------------------
    // ----------------------------------------------------- Space Complexity: O(k) --------------------------------------------------
    //                                                                         k = number of chars to be added; String Builder size
    
    public static String minCharsToAdd(String input){

        if(isPalindrome(input)){
            return "";
        }

        int start =0;
        String check = input;

        // Loop to find the longest palindrome, removing 1 char at a time from start
        while(start < input.length() && !isPalindrome(check)){

            check = check.substring(1); // substring from index 1 to n
            start++;
        }

        String result = input.substring(0,start); // substring from index 0 to start needs to be added at the end 
                                                  // but reversed to make it a palindrome
        StringBuilder sb = new StringBuilder(result);

        return sb.reverse().toString();
    }
    
    public static void main(String args[]) {
        String str = "A man, a plan, a canal -- Panama";

        String str1 ="abccccdc";
        System.out.println(minCharsToAdd(str1));

        String str2 ="abc";
        System.out.println(minCharsToAdd(str2));
        String str3 ="abcfcdcdc";
        System.out.println(minCharsToAdd(str3));
        String str4 ="abbbbc";
        System.out.println(minCharsToAdd(str4));

        System.out.println(isPalindrome(str));
    }
}
