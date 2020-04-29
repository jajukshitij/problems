/*
    Problem: Leetcode.171 Excel Sheet Column Number (Easy)
    Given a column title as appear in an Excel sheet, return its corresponding column number.
    For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28 
        ...

    Example 3:
    Input: "ZY"
    Output: 701
    ---------------------------------------------------------------------------------------------------------------------------------
*/

public class ExcelSheetColumn {

    public static void main(String[] args){

        System.out.println(columnToNumber("AB"));
        System.out.println(columnToNumber("ZY"));
    }

    public static int columnToNumber(String s){

        int res =0;

        for(int i =0; i<s.length(); i++){

            int digit = (s.charAt(i)-'A'+1);
            res =  res *26 + digit;
        }
        return res;
    }
}
