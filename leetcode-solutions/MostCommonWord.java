/*
    Problem: Leetcode.819 Most Common Word (Easy)
    Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
    It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
    Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.
    The answer is in lowercase.
    
    Example:
    Input: 
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]
    Output: "ball"
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n+m) -----------------------------------------------------
                                                                           n = number of words in paragraph,
                                                                           m = number of words in banned set
    ---------------------------------------------------- Space Complexity: O(n+m) -----------------------------------------------------
    
*/

import java.util.*;

public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned){
    
        Set<String> bannedSet = new HashSet<>();
        bannedSet.addAll(Arrays.asList(banned));

        Map<String,Integer> countMap = new HashMap<>();

        String final_word = "";
        int freq = 0;

        String[] words = paragraph.replaceAll("\\W+"," ").toLowerCase().split(" ");

        for(String w:words){

            if(!bannedSet.contains(w)){
                countMap.put(w,countMap.getOrDefault(w,0)+1);

                if(countMap.get(w)>freq){
                    freq = countMap.get(w);
                    final_word = w;
                }
            }
        }

        return final_word;
    }
    
    public static void main(String args[]) {
        String[] banned = {"hit"};
        String paragraph ="Bob hit a ball, the hit BALL flew far after it was hit.";
        System.out.println(mostCommonWord(paragraph,banned));

    }
}
