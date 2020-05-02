/*
    Problem: Leetcode.79 Word Search (Medium)
    Given a 2D board and a word, find if the word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cell,
    where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

    Example:
    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]
    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=vYYNp0Jrdv0
    ---------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
                                                                        n = number of elements in the grid
    -------------------------------------------------- Space Complexity: O(1) ------------------------------------------------------
*/

public class WordSearch {

    public static boolean wordSearch(char[][] board, String word){
    
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
            
                if(board[i][j]== word.charAt(0) && dfs(board, i ,j, 0, word)){
                    return true;
                }
            }
        }
        
        return false;
    }

    public static boolean dfs(char[][] board, int i, int j, int count, String word){
    
        if(count == word.length()){
            return true;
        }
        
        if(i<0 || i>= board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(count)){
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = ' ';

        boolean found = dfs(board, i+1, j, count+1, word)
                        || dfs(board, i-1, j, count+1, word)
                        || dfs(board, i, j+1, count+1, word)
                        || dfs(board, i, j-1, count+1, word);

        board[i][j] = temp;

        return found;
    }
    
    public static void main(String[] args){
        char[][] board = { {'A','B','C','E'},
                           {'S','F','C','S'},
                           {'A','D','E','E'} };

        System.out.println(wordSearch(board,"ABCCED"));
        System.out.println(wordSearch(board,"ABCB"));

    }
}
