/*
    Problem: Leetcode.384 Design TicTacToe
    Design a Tic-tac-toe game that is played between two players on a NxN grid.
    A move is guaranteed to be valid and is placed on an empty block. Once a winning condition is reached, no more moves is allowed.
    A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
*/

public class DesignTicTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int anti_diagonal;

    public DesignTicTacToe(int n){

        rows = new int[n];
        cols = new int[n];
    }

    public int moves(int row, int col, int player){
        // adding 1 or -1 for resp. player to the row and col position where the player makes a move
        // If |sum| of all elements in the row / col / diagonal / anti-diagonal = board size ; the player wins

        int toAdd=0;

        if(player==1){
            toAdd =1;
        }else{
            toAdd =-1;
        }

        rows[row] += toAdd;
        cols[col] += toAdd;

        if(row==col){ // the move is on diagonal
            diagonal += toAdd;
        }

        int size = rows.length;

        if(row+col == size-1){ // the move is on anti-diagonal
            anti_diagonal += toAdd;
        }

        int winner =0;

        if(Math.abs(rows[row])==size || Math.abs(cols[col])==size || Math.abs(diagonal)==size || Math.abs(anti_diagonal)==size){
            winner= player;
        }

        return winner;
    }

}
