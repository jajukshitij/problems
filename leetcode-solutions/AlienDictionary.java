/*
    Problem:  Leetcode 269. Alien Dictionary (Hard)
    There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
    You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
    Derive the order of letters in this language.

    Example 1:
    Given the following words in dictionary,
    [
      "wrt",
      "wrf",
      "er",
      "ett",
      "rftt"
    ]

    The correct order is: "wertf".

    Note:
    1. You may assume all letters are in lowercase.
    2. You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
    3. If the order is invalid, return an empty string.
    4. There may be multiple valid order of letters, return any one of them is fine.
    
   ---------------------------------------------------------------------------------------------------------------------
   Reference : https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/268-missing-number/269-alien-dictionary.html
   Solution: BFS , Topological Sort
   
   ------------------------ Time Complexity: O(V + E) ------------------------
                                             V = All unique character in the input
                                             E = Direct lexicographic relation between characters
*/

import java.util.*;

public class AlienDictionary {

    public static String alienOrder(String[] words) {
        if(words == null || words.length==0){
            return null;
        }

        Map<Character, Set<Character>> map = new HashMap<>();
        int[] indegree = new int[26];

        // Creating a HasMap, key = each character in words
        // value  = Hashset of characters, which follow the key lexicographically
        
        for(String word : words){
            for(int i=0; i<word.length(); i++){
                if(!map.containsKey(word.charAt(i))){
                    map.put(word.charAt(i), new HashSet<>());
                }
            }
        }

        // Polulating values of the Hashmap
        // For ex.  for words -> "wrt","wrf" we can conclude f follows t
        // Hence map would store <t, [f]>;
        
        // Also populating indegree of the characters
        // For ex.  for words -> "wrt","wrf" 
        // indegree of f = 1 and others = 0
        
        for(int i=1; i<words.length; i++){
            String first = words[i-1];
            String second = words[i];

            int len = Math.min(first.length(),second.length());

            for(int j=0; j<len; j++){

                if(first.charAt(j)!= second.charAt(j)){

                    if(!map.get(first.charAt(j)).contains(second.charAt(j))){
                        map.get(first.charAt(j)).add(second.charAt(j));
                        indegree[second.charAt(j)-'a']++;
                    }

                    break; // Need to break as sson as we finr first difference as following comparisons don't make sense.
                           // For ex. from just these 2 words -> "abz","ack" , we can only conclude c follows b.
                }
            }
        }


        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        // Starting BFS with the character having indegree = 0
        for(char key: map.keySet()){
            if(indegree[key-'a']==0){
                queue.add(key);
            }
        }

        while(!queue.isEmpty()){
            char curr = queue.poll();
            result.append(curr);

            if(map.containsKey(curr)){

                for(char c: map.get(curr)){
                    // reducing the indegree of all the characters following the key, as key is added to the result
                    if(indegree[c-'a'] > 0) {
                        indegree[c - 'a']--; 
                    }

                   if(indegree[c-'a']==0){
                       queue.add(c);
                   }
                }
            }
        }

        if(result.length() == map.size()){
            return result.toString();
        }else{ // invalid input
            return "";
        }

    }
}
