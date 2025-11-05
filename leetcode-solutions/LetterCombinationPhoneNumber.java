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
                                                                       Each digit can produce up to 3 or 4 branches 
                                                                       → total combinations = product of branch counts
    ------------------------------------------------ Space Complexity: O(n) -----------------------------------------------
                                                                       n = recurrsion stack depth 
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
        if (digits == null || digits.isEmpty()) return result;
        StringBuilder sb = new StringBuilder();
        backtrack(digits, sb, map, result);

        return result;
    }


    public static void backtrack(String digits, StringBuilder sb, Map<Character, char[]> map, List<String> result){

        if(digits.length()== sb.length()){
            result.add(sb.toString());
            return;
        }

        for(char ch: map.get(digits.charAt(sb.length()))){
            sb.append(ch);

            backtrak(digits,sb,map,result);
            sb.deleteCharAt(sb.length()-1); // To find other combinations for second number with first one
                                            // eg. from 'ad', delete 'd' to get 'ae'
        }
    }
    
    public static void main(String[] args){
        System.out.println(numberToLetter("23"));
    }
}
// -----------------------------------------------------------  Problem 2 -----------------------------------------------------
// ----------------------------------------------------  Phone Keypad Word Matching -------------------------------------------

/*
    Problem: 
    Given the standard mapping from English letters to digits on a phone keypad  
    Write a program that outputs all words that can be formed from any n-digit phone number from the list of given KNOWN_WORDS,
    considering the mapping mentioned above. 
    KNOWN_WORDS= ['careers', 'linkedin', 'hiring', 'interview', 'linkedgo'] 

    Example 1:
    phoneNumber: 2273377 
    Output: ['careers'] 

    Example 2:
    phoneNumber: 54653346 
    Output: ['linkedin', 'linkedgo']

 ------------------------------------------------- Time Complexity: O(N x L) -----------------------------------------------
                                                                       N = number of words, L = average length
 ------------------------------------------------ Space Complexity: O(1) -----------------------------------------------
                                                                       Constant extra space
*/
public class PhoneNumberToWords {

    private static final Map<Character, Character> charToDigit = createMapping();

    private static Map<Character, Character> createMapping() {
        Map<Character, Character> map = new HashMap<>();
        map.put('a', '2'); map.put('b', '2'); map.put('c', '2');
        map.put('d', '3'); map.put('e', '3'); map.put('f', '3');
        map.put('g', '4'); map.put('h', '4'); map.put('i', '4');
        map.put('j', '5'); map.put('k', '5'); map.put('l', '5');
        map.put('m', '6'); map.put('n', '6'); map.put('o', '6');
        map.put('p', '7'); map.put('q', '7'); map.put('r', '7'); map.put('s', '7');
        map.put('t', '8'); map.put('u', '8'); map.put('v', '8');
        map.put('w', '9'); map.put('x', '9'); map.put('y', '9'); map.put('z', '9');
        return map;
    }

    public static List<String> getMatchingWords(String phoneNumber, List<String> knownWords) {
        List<String> result = new ArrayList<>();

        for (String word : knownWords) {
            if (wordToDigits(word).equals(phoneNumber)) {
                result.add(word);
            }
        }
        return result;
    }

    private static String wordToDigits(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toLowerCase().toCharArray()) {
            if (charToDigit.containsKey(c)) {
                sb.append(charToDigit.get(c));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> KNOWN_WORDS = Arrays.asList("careers", "linkedin", "hiring", "interview", "linkedgo");

        String phone1 = "2273377";
        String phone2 = "54653346";

        System.out.println(getMatchingWords(phone1, KNOWN_WORDS)); // [careers]
        System.out.println(getMatchingWords(phone2, KNOWN_WORDS)); // [linkedin, linkedgo]
    }
}

