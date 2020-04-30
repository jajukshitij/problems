/*
    Problem: Leetcode.118 Pascal Triangle (Easy)
    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it.

    Example:
    Input: 5
    Output:
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=icoql2WKmbA
    ----------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n^2) ------------------------------------------------------
    Dynamic Programming
*/

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> pascalsTriangle(int numRows){

        List<List<Integer>> result = new ArrayList<>();

        if(numRows < 1){
            return result;
        }

        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        result.add(first_row);

        for(int i=1; i<numRows; i++){
        
            List<Integer> prev_row = result.get(i-1);
            List<Integer> curr_row = new ArrayList<>();

            curr_row.add(1);

            for(int j =1; j<i; j++){
            
                curr_row.add(prev_row.get(j-1) + prev_row.get(j) );
            }

            curr_row.add(1);
            result.add(curr_row);
        }

        return result;
    }
    
    public static void main(String[] args){
        System.out.println(pascalsTriangle(5));
    }
}
