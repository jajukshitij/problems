/*
    Problem: Leetcode.113 PathSum II (Medium)
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    Note: A leaf is a node with no children.
    
    Example:
    Given the below binary tree and sum = 22,
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \    / \
    7    2  5   1
    Return:
    [
       [5,4,11,2],
       [5,8,4,5]
    ]
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=3B5gnrwRmOA
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) -----------------------------------------------------
    ------------------------------------------------------ Space Complexity: O(n) -----------------------------------------------------
    
*/

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static List<List<Integer>> pathSum2(Node root, int sum){
    
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(root,sum, current,result);

        return result;
    }

    public static void dfs(Node root, int sum, List<Integer> current, List<List<Integer>> result){
    
        if(root== null){
            return;
        }
        
        current.add(root.value);
        
        if(root.value==sum && root.left==null && root.right==null){
            result.add(current);
        }

        dfs(root.left,sum-root.value,current,result);
        dfs(root.right,sum-root.value,current,result);

        current.remove(current.size()-1);
    }

  
  public static  class Node {
  
        int value;
        Node left, right;

        public Node(int item)
        {
            value = item;
            left = right = null;
        }
    }
}
