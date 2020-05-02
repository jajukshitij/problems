/*
    Problem: Toeplitz Matrix
    A Toeplitz matrix is a matrix where every left-to-right-descending diagonal has the same element.
    Given a non-empty matrix arr, write a function that returns true if and only if it is a Toeplitz matrix.
    The matrix can be any dimensions, not necessarily square.

    For example,
    [[1,2,3,4],
     [5,1,2,3],
     [6,5,1,2]]
    is a Toeplitz matrix, so we should return true, while

    [[1,2,3,4],
     [5,1,9,3],
     [6,5,1,2]]
    isn’t a Toeplitz matrix, so we should return false.
    ----------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n * m) ---------------------------------------------------
    
*/

public class ToeplitzMatrix {

    //------------------------------------------------------- Method 1 --------------------------------------------------------------
    //------------------------------------------------- Space Complexity: O(1) ------------------------------------------------------
    public static boolean isToeplitz(int[][] matrix){

        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return true;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
            
                if(matrix[i][j]!=matrix[i-1][j-1]){
                    return false;
                }
                
            }
        }

        return true;
    }
    
    
    //------------------------------------------------------- Method 2 --------------------------------------------------------------
    //------------------------------------------------- Space Complexity: Recursive call stack --------------------------------------

    public static boolean isToeplitz2(int[][] matrix){
    
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return true;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int j=0; j <cols; j++){
        
            if(!helperToeplitz(matrix,0,j)){
                return false;
            }
        }

        for(int i=1; i<rows; i++){
        
            if(!helperToeplitz(matrix,i,0)){
                return false;
            }
        }

        return true;
    }

    public static boolean helperToeplitz(int[][] matrix, int i, int j){
    
        int rows = matrix.length;
        int cols = matrix[0].length;

        int res = matrix[i][j];

        while(i<rows && j<cols){
            if(matrix[i][j]!= res){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
    
    public static void main(String[] args){

        int[][] matrix ={{1,2,3,4},
                         {5,1,2,3},
                         {6,5,1,2}};

        int[][] matrix2 = {{3,9},
                           {5,3},
                           {6,5}};

        System.out.println(isToeplitz(matrix2));
        System.out.println(isToeplitz2(matrix));
    }
}
