/*
    Problem: Leetcode.937 Reorder Data in Log Files (Medium)
    You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
    
    There are two types of logs:    
    Letter-logs: All words (except the identifier) consist of lowercase English letters.
    Digit-logs: All words (except the identifier) consist of digits.
    
    Reorder these logs so that:    
    The letter-logs come before all digit-logs.
    The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
    The digit-logs maintain their relative ordering.
    
    Return the final order of the logs.

    Example 1:
    Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
    Explanation:
    The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
    The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://leetcode.com/problems/reorder-data-in-log-files/discuss/382006/two-solutions-easy-to-understand-java-100
    -----------------------------------------------------------------------------------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderLogFiles {

    public static String[] reorderLogFile(String logs[]){
    
        List<String> digitList = new ArrayList<>();
        List<String> letterList = new ArrayList<>();

        for(String log: logs){
        
            if(Character.isLetter(log.split(" ")[1].charAt(0))){
                letterList.add(log);
            }else{
                digitList.add(log);
            }
        }

        // Custom Comparator, if strings are equal, comparing the indexws i.e including let1, let2..
        Collections.sort(letterList, new Comparator<String>() {
            public int compare(String o1, String o2) {
          
                String s1 = o1.substring(o1.indexOf(" ") + 1);
                String s2 = o2.substring(o2.indexOf(" ") + 1);

                return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
            }
        });

        String[] ans = new String[logs.length];

        int i=0;
        
        for(String log :letterList){
            ans[i++]= log;
        }

        for(String log :digitList){
            ans[i++]= log;
        }

        return ans;
    }
    
    public static void main(String args[]){
        String[] input ={"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] output =  reorderLogFile(input);

        for(int i=0; i<output.length;i++){
            System.out.println(output[i]);
        }
    }
}
