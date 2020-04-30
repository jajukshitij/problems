/*
    Problem: Leetcode.74 Search a 2D matrix (Medium)
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
    Example 1:

    Input:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 3
    Output: true
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------- Time Complexity: O(m+n) ---------------------------------------------------------
      In worst case it starts from bottom left and target is at top right. Take (m-1 + n-1) steps to reach. hence O(m+n)
    ------------------------------------------------ Space Complexity O(1) ----------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.List;

public class MatrixSearch {

    public static PairInt positionOfTargetValue (int row, int column, List<List<Integer>> matrix, int targetRPM){
        
        int r = row-1;
        int c = 0;

        while (r>=0 && c < column){
        
            if(matrix.get(r).get(c) > targetRPM){
                r--;
            }else if(matrix.get(r).get(c) < targetRPM){
                c++;
            }else {
                return new PairInt(r,c);
            }
            
        }
        
        return new PairInt(-1,-1);
    }
    
    public static class PairInt{
        int first,second;
        
        PairInt(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        List row1 = new ArrayList();
        row1.add(-3);
        row1.add(10);
        row1.add(31);
        row1.add(40);

        List row2 = new ArrayList();
        row2.add(10);
        row2.add(33);
        row2.add(40);
        row2.add(66);

        List row3 = new ArrayList();
        row3.add(22);
        row3.add(43);
        row3.add(61);
        row3.add(70);

        List matrix = new ArrayList();
        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);

        PairInt result = new PairInt();
        result = positionOfTargetValue (3,4,matrix,22);
        System.out.println("Index at== "+ result.first +" "+ result.second);
    }
}
