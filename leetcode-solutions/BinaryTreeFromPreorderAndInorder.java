/*
  Problem: Leetcode. 105 Construct Binary Tree From Preorder and Inorder Traversal (Medium)
  
  Given preorder and inorder traversal of a tree, construct the binary tree.
  Note:
  You may assume that duplicates do not exist in the tree.
  
  For example, given
  preorder = [3,9,20,15,7]
  inorder = [9,3,15,20,7]
  Return the following binary tree:

      3
     / \
    9  20
      /  \
     15   7
   -------------------------------------------------------------------------------------------------------------------------------
*/

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderAndInorder {

    public static  class Node {
        int value;
        Node left, right;

        public Node(int item)
        {
            value = item;
            left = right = null;
        }
    }

    int[] preorder;
    int[] inorder;
    int pre_index =0;
    Map<Integer,Integer> map;

    public Node constructBinaryTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        this.inorder = inorder;

        map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(0, inorder.length);
    }


    public Node helper(int left, int right){
        if(left==right){
            return null;
        }

        int root_val = preorder[pre_index];
        Node root = new Node(root_val);

        int index = map.get(root_val);

        pre_index++;


        root.left = helper(left,index);
        root.right = helper(index+1, right);

        return root;
    }
}
