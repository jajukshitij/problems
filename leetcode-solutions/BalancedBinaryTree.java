/*
    Problem: Leetcode. 110 Balanced Binary Tree
    Given a binary tree, determine if it is height-balanced.
    For this problem, a height-balanced binary tree is defined as:
    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
    
    Example 1:
    Given the following tree [3,9,20,null,null,15,7]:
        3
       / \
      9  20
      /  \
     15   7
    -------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------Time Complexity: O(n) ------------------------------------------------------
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

    public static boolean isBalanced(Node root){
    
        if(height(root)<=-1){
            return false;
        }
        return true;
    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }

        int left_height = height(root.left);
        if(left_height <= -1) return -1;

        int right_height = height(root.right);
        if(right_height <= -1) return -1;

        if(Math.abs(left_height - right_height) <= 1){
            return Math.max(left_height, right_height) + 1;
        }else{
            return -1;
        }
    }
}
