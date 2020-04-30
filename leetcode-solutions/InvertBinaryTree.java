/*
    Problem: Leetcode.226 Invert Binary Tree (Easy)
    Invert a binary tree.

    Example:
    Input:

         4
       /   \
      2     7
     / \   / \
    1   3 6   9
    Output:

         4
       /   \
      7     2
     / \   / \
    9   6 3   1
    ---------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(n) -------------------------------------------------
*/

public class InvertBinaryTree {

    public static TreeNode invertBinaryTree(TreeNode root){
        if(root == null){
            return null;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertBinaryTree(right);
        root.right = invertBinaryTree(left);

        return root;
    }
    
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }
    }
}
