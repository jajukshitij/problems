/*
    Problem: Leetcode.763 Partition Labels (Medium)
    A string S of lowercase letters is given. We want to partition this string into as many parts as possible 
    so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

    Example 1:
    Input: S = "ababcbacadefegdehijhklij"
    Output: [9,7,8]
    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=5NCjHqx2v-k
    ---------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(N) --------------------------------------------------------
                                                                        N = length of string
    -------------------------------------------------- Space Complexity: O(1) -------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static List<Integer> partitionLabels(String S){
    
        if(S == null || S.length()==0){
            return null;
        }

        List<Integer> result = new ArrayList<>();
        int[] last_idx = new int[26];
        
        // Saving the last index position where each unique character occurs
        for(int i=0; i<S.length(); i++){
        
            last_idx[S.charAt(i)-'a'] = i;
        }

        int start=0; int end =0;

        for(int i=0; i<S.length(); i++){
        
            end = Math.max(end, last_idx[ S.charAt(i)-'a' ]);  // 'end' marks the end each partition,
                                                               // by getting the highest value for last occurance each character 

            if(end == i){ // when end is reached during traversal, partition is found start - end
            
                result.add(end-start+1);
                start= end+1; // setting start point for next partition
            }
        }

        return result;
    }
    
    public static void main(String[] args){

        String input = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(input));
    }
    
}
