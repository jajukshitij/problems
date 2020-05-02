/*
    Problem: Leetcode.126 Word Ladder II (Hard)
    Given two words (beginWord and endWord), and a dictionary's word list,
    find all shortest transformation sequence(s) from beginWord to endWord, such that:
    Only one letter can be changed at a time
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
    Note:
    Return an empty list if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.
    
    Example 1:
    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]
    Output:
    [
      ["hit","hot","dot","dog","cog"],
      ["hit","hot","lot","log","cog"]
    ]
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=vZNFOBEfib4
    https://happygirlzt.com/code/126.html
    
    ------------------------------------------------ Time Complexity: O(m * n) -------------------------------------------------------
                                                                      m = size of word, n = number of words
    ------------------------------------------------ Space Complexity: O(m * n) ------------------------------------------------------
    
    BFS to create the graph (HashMap)
    DFS to populate the result
*/

import java.util.*;

public class WordLadderII {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
    
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        
        if(!wordSet.contains(endWord)){
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);

        bfs(startSet, endWord, map, wordSet);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(result, list, beginWord, endWord, map);

        return result;
    }

    public static void bfs(Set<String> startSet, String endWord, Map<String, List<String>> map, Set<String> wordSet){

        if(startSet.size()==0){
            return;
        }

        Set<String> temp = new HashSet<>();
        wordSet.removeAll(startSet);
        boolean finish = false;

        for(String str: startSet){
        
            char[] arr = str.toCharArray();

            for(int i=0; i<arr.length; i++){
            
                char originalChar = arr[i];

                for(char c='a'; c<='z'; c++){
                
                    if(c == arr[i]) continue;

                    arr[i] = c;

                    String newWord = String.valueOf(arr);

                    if(wordSet.contains(newWord)){
                    
                        if(newWord.equals(endWord)){
                            finish= true;
                        }else{
                            temp.add(newWord);
                        }

                        if(!map.containsKey(str)){
                            map.put(str, new ArrayList<>());
                        }

                        map.get(str).add(newWord);
                    }
                }

                arr[i]= originalChar;
            }
        }

        if(!finish){
            bfs(temp, endWord, map, wordSet);
        }
    }

    public static void dfs(List<List<String>> result, List<String> list, String currWord, String endWord,
                           Map<String, List<String>> map){

        if(currWord.equals(endWord)){
        
            result.add(new ArrayList<>(list));
            return;
        }

        if(map.containsKey(currWord)) {
        
            for (String str : map.get(currWord)) {

                list.add(str);
                dfs(result, list, str, endWord, map);
                list.remove(list.size()-1);
            }
        }
    }
}
