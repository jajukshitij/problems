/*
    Problem: Leetcode.543 Binary Tree Maximum Path Sum (Hard)
    Given a non-empty binary tree, find the maximum path sum.
    For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
    The path must contain at least one node and does not need to go through the root.

    Example 1:
    Input: [1,2,3]
           1
          / \
         2   3
    Output: 6
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=mOdetMWwtoI
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------- Time Complexity: O(N) ; visit every node once ---------------------------------------
    ------------------------------------------- Space Complexity: O(N) --------------------------------------------------------------
*/


public class MaximumPathSum {

    static int max_sum = Integer.MIN_VALUE;

    public static int maximumPathSum(Node root){
        pathSum(root);
        return max_sum;
    }

    public static int pathSum(Node root){
        if(root==null){
            return 0;
        }

        int left_sum = Math.max(0, pathSum(root.left));
        int right_sum = Math.max(0, pathSum(root.right));

        max_sum = Math.max(max_sum, left_sum + right_sum + root.value);

        return Math.max(left_sum, right_sum) + root.value;
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
