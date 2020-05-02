/*
    Problem: Leetcode.127 Word Ladder (Medium)
    Given two words (beginWord and endWord), and a dictionary's word list,
    find the length of shortest transformation sequence from beginWord to endWord, such that:
    Only one letter can be changed at a time.
    Each transformed word must exist in the word list.
    Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.
    
    Example 1:
    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]
    Output: 5
    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=M9cVl4d0v04
    -----------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(m * n) ------------------------------------------------------
                                                                        m = size of word, n = number of words
    ------------------------------------------------- Space Complexity: O(m * n) ------------------------------------------------------
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public static int wordLadder( String beginWord, String endWord, String[] wordList){
    
        Set<String> set = new HashSet<>();

        for(String word: wordList){
            set.add(word);
        }

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level =1;

        while(!queue.isEmpty()){
        
            int size = queue.size();

            for(int i = 0; i < size; i++){
            
                String currWord = queue.poll();
                char[] wordArray = currWord.toCharArray();

                for(int j =0; j<wordArray.length; j++){
                
                    char originalChar = wordArray[j];

                    for(char c = 'a'; c <= 'z'; c++){
                    
                        if(wordArray[j] == c){
                            continue;
                        }

                        wordArray[j] = c;
                        String newWord = String.valueOf(wordArray);
                        
                        if(newWord.equals(endWord)){
                            return level+1;
                        }
                        
                        if(set.contains(newWord)){
                            queue.add(newWord);
                            set.remove(newWord);
                        }
                        
                    }
                    wordArray[j] = originalChar;
                }
            }
            
            level++;
        }

        return 0;
    }
    
    
    public static void main(String[] args){

        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};

        System.out.println(wordLadder(beginWord,endWord,wordList));
    }
}
