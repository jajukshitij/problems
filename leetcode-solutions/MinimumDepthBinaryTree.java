/*
    Problem: Leetcode. 111 Minimum Depth of Binary Tree
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    Note: A leaf is a node with no children.

    Example:
    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    ------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------- Time Complexity: O(n) ---------------------------------------------
                                                                    n = number of nodes
*/

public class BalancedBinaryTree {

    public static  class Node {
        int value;
        Node left, right;

        public Node(int item)
        {
            value = item;
            left = right = null;
        }
    }

    public int minDepth(Node root){
        if(root==null){
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0 || right == 0){
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }
}
