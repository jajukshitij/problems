/*
    Problem: Pairs with Specific Difference
    Given an array arr of distinct integers and a nonnegative integer k, write a function findPairsWithGivenDifference 
    that returns an array of all pairs [x,y] in arr, such that x - y = k. If no such pairs exist, return an empty array.
    Note: the order of the pairs in the output array should maintain the order of the y element in the original array.

    Examples:
    input:  arr = [0, -1, -2, 2, 1], k = 1
    output: [[1, 0], [0, -1], [-1, -2], [2, 1]]

    input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
    output: []
    ----------------------------------------------------------------------------------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoDiff {

    public static int[][] pairsWithDifference(int[] arr, int k){

        if(arr== null || arr.length==0 || k==0){
            return new int[0][0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int n: arr){
            map.put(n-k, n);
        }

        for(int n: arr){
            if(map.containsKey(n)){
            
                List<Integer> curr_list = new ArrayList<>();
                curr_list.add(map.get(n));
                curr_list.add(n);
                result.add(curr_list);
            }
        }

        int[][] res = new int[result.size()][2];

        for(int i =0; i< result.size(); i++){
        
            res[i][0]= result.get(i).get(0);
            res[i][1]= result.get(i).get(1);
        }

        return res;
    }
    
    
    public static void main(String[] args){

        int[] arr = {0, -1, -2, 2, 1};
        int[][] res = pairsWithDifference(arr,1);

        for(int i=0; i<res.length; i++){
            for(int j=0; j<2; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
