/*
    Problem: Leetcode.12 Integer To Roman (Medium)
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, two is written as II in Roman numeral, just two one's added together.
    Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
    Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

    Example 1:
    Input: 3
    Output: "III"
    ----------------------------------------------------------------------------------------------------------------------------------
    
*/

public class IntegerToRoman {

    public static void main(String args[]){
        System.out.println(intToRoman(20));
    }


 --------------------------------------------------- Time Complexity: O(13) = O(1) --------------------------------------------------
 --------------------------------------------------- Space Complexity: O(13) = O(1) --------------------------------------------------
    
    public static String intToRoman(int num){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        // IMPROVEMENT:Right now, every call re-allocates two arrays. 
        // Marking them static final avoids reallocation and lets JVM intern/optimize them.

        // Limit ranges from 1-3999; as per the rules of Roman number
    
        StringBuilder sb = new StringBuilder(); // IMPROVEMENT: presize to ~15
                                        // To avoid dynamic resizing

        while(num>0){
            for(int i=0; i<values.length;i++){
                if(num >=values[i]){
                    sb.append(symbol[i]);
                    num =  num- values[i];
                    break;
                }
            }
        }

        return sb.toString();
    }
}
