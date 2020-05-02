/*
    Problem: Leetcode.98 Validate BST (Medium)
    Given a binary tree, determine if it is a valid binary search tree (BST).
    Assume a BST is defined as follows:
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    Example 1:
        2
       / \
      1   3
    Input: [2,1,3]
    Output: true
    -------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
    -------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
    --------------------------------------------------- Space Complexity: O(n) ----------------------------------------------------
    
    BST Inorder Traversal
*/

import java.util.Stack;

public class ValidateBST {

    static Node prev;
    static  Node root;
    
    //--------------------------------------------------- Recursive Approach -------------------------------------------------
    
    public static boolean isBST (Node root){
    
        if(root==null){
            return true;
        }

        if(!isBST(root.left)){
            return false;
        }

        if(prev !=null && prev.value >= root.value ){
            return false;
        }

        prev = root;

        if(!isBST(root.right)){
            return false;
        }

        return true;
    }
    
    
    //--------------------------------------------------- Iterative Approach -------------------------------------------------

    public static boolean iterativeBST(Node root){
    
        Stack<Node> stack = new Stack<>();

        while(root!=null || !stack.isEmpty()){
        
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if(prev!=null && prev.value>= root.value){
                return false;
            }
            
            prev = root;
            root= root.right;
        }

        return true;
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

