/*
    Problem: Leetcode.285 Inorder Successor Of BST
    Pramp. BST Successor Search 
    In a BST, an Inorder Successor of a node is defined as the node with the smallest key greater than the key of the input node.
    Given a node inputNode in a BST, you’re asked to write a function findInOrderSuccessor that returns the Inorder Successor of inputNode.
    If inputNode has no Inorder Successor, return null
    ---------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n) --------------------------------------------------
                                                                         n = number of nodes in the tree
*/

import java.util.Stack;

public class InorderSuccessorBST {

    // -------------------------------------------- Method 1: Parent pointer ---------------------------------------------------
    
    public static TreeNode parentPointer(TreeNode p){
        if(p.right!=null){
            p = p.right;
            while(p.left!=null){
                p = p.left;
            }
            return p;
        }

        TreeNode par = p.parent;
        TreeNode child = p;

        while(par!=null && par.right== child){
             child = par;
             par = child.parent;
        }
        return par;
    }

   // -------------------------------------------- Method 2: When parent pointer not given -----------------------------------------

    public static TreeNode successor(TreeNode root, TreeNode p){

        if(p.right!=null){
            p = p.right;
            while(p.left!=null){
                p = p.left;
            }
            return p;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = new TreeNode(0);

        while(root!= null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root= root.left;
            }

            root= stack.pop();

            if(prev!= null && prev== p){
                return root;
            }
            prev = root;
            root= root.right;
        }

        return null;
    }
    
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode parent;

      TreeNode(int x) {
          val = x;
      }
    }
}
