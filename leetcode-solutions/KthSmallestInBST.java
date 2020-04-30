/*
    Problem: Leetcode.230 Kth Smallest Element in BST (Medium)
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
    Note:
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
    
    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
    Output: 3
    --------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) -----------------------------------------------
*/

import java.util.Stack;

public class KthSmallestInBST {

    public static int kthSmallestElement(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();

        while(root!=null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return-1;
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
