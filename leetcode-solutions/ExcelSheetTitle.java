/*
    Problem: Leetcode.168 Excel Sheet Column Title (Easy)
    
    Given a positive integer, return its corresponding column title as appear in an Excel sheet.

    For example:

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB 
        ...
    Example 1:
    Input: 28
    Output: "AB"
    ---------------------------------------------------------------------------------------------------------------------------------
    
*/

public class ExcelSheetTitle {

    public static void main(String[] args){

        System.out.println(numberToColumn(28));
        System.out.println(numberToColumn(701));
    }

    //The key is n--. The minimum in 26-bit number is mapped to 1, not 0

    public static String numberToColumn(int n){

        StringBuilder sb = new StringBuilder();

        while(n>0){
            n--;
            int rem = n%26;
            sb.append((char)(rem+'A'));
            n= n/26;
        }

       return sb.reverse().toString();
    }
}
