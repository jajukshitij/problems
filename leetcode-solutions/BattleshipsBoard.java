/* 
    Problem: Leetcode. 419 Battleships in a Board (Medium)
    
    Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
    You receive a valid board, made of only battleships or empty slots.
    Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
    At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
    
    Example:
    X..X
    ...X
    ...X
    In the above board there are 2 battleships
    --------------------------------------------------------------------------------------------------------------------------
    Reference: 
    https://www.youtube.com/watch?v=wBG6078g1gE
    
    ----------------------------------- Time Complexity: O(n * m) ------------------------------------------------
    
*/

public class BattleshipsinBoard {

    public static int counShips(char[][] board){
        int count  =0;

        for(int i =0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(i>0 && board[i-1][j]=='X'){
                    continue;
                }

                if(j>0 && board[i][j-1]=='X'){
                    continue;
                }
                count++;
            }
        }

        return count;
    }
}
