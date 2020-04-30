/*
    Problem: Leetcode.17 Letter Combinations of Phone Number (Medium)
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
    
    Example:
    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
    -------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=h6FmiyYDjmk
    http://www.goodtecher.com/leetcode-17-letter-combinations-of-a-phone-number/
    -------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: O(3^n * 4^m) -----------------------------------------------
                                                                       n = number of digits mapping to 3 letters
                                                                       m = number of digits mapping to 4 letters
    ------------------------------------------------ Space Complexity: O(3^n * 4^m) -----------------------------------------------
                                                                       3^n * 4^m  possible combinations in result 
*/

import java.util.*;

public class LetterCombinationPhoneNumber {

    public static List<String> numberToLetter(String digits){
        if(digits==null || digits.equals("")){
            return null;
        }
        Map<Character, char[]> map= new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(digits, sb, map, result);

        return result;
    }


    public static void helper(String digits, StringBuilder sb, Map<Character, char[]> map, List<String> result){

        if(digits.length()== sb.length()){
            result.add(sb.toString());
            return;
        }

        for(char ch: map.get(digits.charAt(sb.length()))){
            sb.append(ch);

            helper(digits,sb,map,result);
            sb.deleteCharAt(sb.length()-1); // To find other combinations for second number with first one
                                            // eg. from 'ad', delete 'd' to get 'ae'
        }
    }
    
    public static void main(String[] args){
        System.out.println(numberToLetter("23"));
    }
}
