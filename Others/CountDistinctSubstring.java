/*
    Problem: Substring calculator, count the number of distict subtrings in the given string
    --------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://github.com/harishvc/challenges/blob/master/string-count-distinct-substrings.py
    https://cs.stackexchange.com/questions/13140/number-of-distinct-substrings-in-a-string
    --------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------  Time Complexity: O(n^2)---------------------------------------------------------
*/

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSubstrings {

    public static void main(String[] args){
        System.out.println(countDistinct("aaabc"));
    }

    public static int countDistinct(String string){

        Set<String> set = new HashSet<>();

        for(int i =0; i< string.length(); i++){

            String substring = "";

            for(int j=i; j< string.length(); j++){ // subtrings from i to n, concatenating 1 character at a time
                substring += string.charAt(j);
                set.add(substring);
            }
        }

        return set.size();
    }
}
