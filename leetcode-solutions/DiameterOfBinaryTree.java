/*
    Problem: Leetcode.543 Diameter of Binary Tree (Easy)
    Given a binary tree, you need to compute the length of the diameter of the tree.
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    This path may or may not pass through the root.

    Example:
    Given a binary tree
              1
             / \
            2   3
           / \     
          4   5    
    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
    Note: The length of path between two nodes is represented by the number of edges between them.
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------- Time Complexity: O(N) ; visit every node once ----------------------------------------
    ------------------------------------------- Space Complexity: O(N) --------------------------------------------------------------
*/


public class DiameterOfBinaryTree {

    static int max_chain = 0;
    
    public static int diameterOfBinaryTree(Node root){
        height(root);
        return max_chain;
    }

    public static int height(Node root){

        if(root==null){
            return 0;
        }

        int left_height = height(root.left);
        int right_height = height(root.right);

        max_chain = Math.max(max_chain,left_height+right_height);

        return Math.max(left_height,right_height)+1;
        
        /* The particular problem c=doesn't consider root itself but in general you need add 1 for such problems.
        max_chain = Math.max(max_chain,left_height+right_height+1);
        */
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
