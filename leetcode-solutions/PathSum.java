/*
    Problem: Leetcode.112 PathSum (Easy)
    Given a binary tree and a sum, determine if the tree has a 
    root-to-leaf path such that adding up all the values along the path equals the given sum.
    Note: A leaf is a node with no children.

    Example:
    Given the below binary tree and sum = 22,
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=Hg82DzMemMI
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) -----------------------------------------------------
    ------------------------------------------------------ Space Complexity: O(n) -----------------------------------------------------
    
*/

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public static boolean pathSum(Node root, int sum){
    
        if(root ==null){
            return false;
        }
        
        if(root.value==sum && root.left==null && root.right==null){
            return true;
        }

        return pathSum(root.left, sum-root.value) || pathSum(root.right,sum-root.value);
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
