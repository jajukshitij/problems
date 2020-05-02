/*
    Problem: Leetcode.212 Word Search II (Hard)
    Given a 2D board and a list of words from the dictionary, find all words in the board.
    Each word must be constructed from letters of sequentially adjacent cell,
    where "adjacent" cells are those horizontally or vertically neighboring.
    The same letter cell may not be used more than once in a word.

    Example:
    Input: 
    board = [
      ['o','a','a','n'],
      ['e','t','a','e'],
      ['i','h','k','r'],
      ['i','f','l','v']
    ]
    words = ["oath","pea","eat","rain"]
    Output: ["eat","oath"]
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=AXjmTQ8LEoI
    https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java

    https://leetcode.com/problems/word-search-ii/discuss/59784/My-simple-and-clean-Java-code-using-DFS-and-Trie
    https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
    ----------------------------------------------------------------------------------------------------------------------------------
    
    
    ----------------------------------------------- Time Complexity: O(m * n * wl * w) -----------------------------------------------
    -------------------------------------------------- Space Complexity: O(wl * l) ----------------------------------------------------
                                                            m *n = char matrix
                                                            wl = number of words
                                                            w = avg length of word
                                                            
    Time: O(m * n * wl * l) = max(O(wl * l), O(m * n * l * wl)) where
        O(wl * l) - Build the trie
        O(m * n * wl * l) - In the worst case where all words start with different characters

    Space: O(wl * l) = max(O(wl), O(wl * l)) where
        O(wl) - The recursive stack can grow at most to wl layers.
        O(wl * l) - In the worst case when all words start with different characters, the trie has wl * l nodes.
        Also, since each word is stored in a leaf node, all the leaf nodes require wl * l memory.
*/

import java.util.*;

public class WordSearchII {

    public static class Trie{
    
        Map<Character, Trie> map;
        boolean isWord;

        public Trie(){
            map = new HashMap<>();
            isWord = false;
        }
    }

    static Trie root = new Trie();

    public static List<String> findWords(char[][] board, String[] words){
    
        Set<String> result = new HashSet<>();

        for(String word: words){
            insertIntoTrie(word);
        }

        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                dfs(board, result, "", i, j, root);
            }
        }

        return new ArrayList<>(result);
    }


    public static void dfs(char[][] board, Set<String> result, String str, int i, int j, Trie p){

        if(i<0 || i>= board.length || j<0 || j>= board[0].length || board[i][j]== ' ' || p.map.get(board[i][j])== null){
            return;
        }

        char temp = board[i][j];
        p = p.map.get(temp);
        str += temp;

        if(p.isWord){
            result.add(str);
        }

        board[i][j] = ' ';

        dfs(board, result, str, i+1, j, p);
        dfs(board, result, str, i-1, j, p);
        dfs(board, result, str, i, j+1, p);
        dfs(board, result, str, i, j-1, p);

        board[i][j] = temp;
    }


    public static void insertIntoTrie(String word){
    
        char[] arr = word.toCharArray();
        Trie curr = root;

        for(char c : arr){
        
            Trie node = curr.map.get(c);

            if(node == null){
            
                node = new Trie();
                curr.map.put(c, node);
            }
            
            curr = node;
        }
        curr.isWord = true;
    }

    public static boolean search(String word){
    
        char[] arr = word.toCharArray();
        Trie curr = root;

        for(char c : arr){
        
            Trie node = curr.map.get(c);

            if(node == null){
                return false;
            }
            curr = node;
        }

        return curr.isWord;
    }

    public static boolean startsWith(String word){
    
        char[] arr = word.toCharArray();
        Trie curr = root;

        for(char c : arr){
            Trie node = curr.map.get(c);

            if(node == null){
                return false;
            }
            curr = node;
        }

        return true;
    }
}
