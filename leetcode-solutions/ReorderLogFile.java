/*
    Problem: Leetcode.937 Reorder Log Files (Easy)
    You have an array of logs.  Each log is a space delimited string of words.
    For each log, the first word in each log is an alphanumeric identifier.  Then, either:
    Each word after the identifier will consist only of lowercase letters, or;
    Each word after the identifier will consist only of digits.
    We will call these two varieties of logs letter-logs and digit-logs.
    It is guaranteed that each log has at least one word after its identifier.
    Reorder the logs so that all of the letter-logs come before any digit-log.
    The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
    The digit-logs should be put in their original order.
    Return the final order of the logs.

    Example 1:
    Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
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
