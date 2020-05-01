/*
    Problem: Leetcode.13 Roman To Integer (Easy)
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
    Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

    Example 1:
    Input: "III"
    Output: 3
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
    ----------------------------------------------------- Space Complexity: O(1) -----------------------------------------------------
    
*/

public class RomanToInteger {

    public static int romanToInt(String str){
        int res =0;

        for(int i= str.length()-1; i>=0;i--){

            switch (str.charAt(i)){

                case'I':
                    res += (res >= 5 ? -1:1);
                    break;

                case'V':
                    res += 5;
                    break;

                case'X':
                    res += 10 * (res >= 50 ? -1:1);
                    break;

                case'L':
                    res += 50;
                    break;

                case'C':
                    res += 100 * (res >= 500 ? -1:1);
                    break;

                case'D':
                    res += 500;
                    break;

                case'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}
