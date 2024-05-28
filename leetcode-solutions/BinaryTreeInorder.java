/*
Leetcode Problem 94. Binary Tree Inorder Traversal (Easy)
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
*/

public class BinaryTreeInorder
  {
  
    public List<Integer> inorderTraversal(TreeNode root) {
      Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        while(root != null || !stack.isEmpty())
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    
    }
  }
