/*
    Problem: Leetcode. 235 Lowest Common Ancestor of Binary Search Tree (Easy)
    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as 
    the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
    Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

    Example 1:
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    Output: 6
    Explanation: The LCA of nodes 2 and 8 is 6.
    -----------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(N) -----------------------------------------------------
    ---------------------------------------------------- Space Complexity: O(1)-----------------------------------------------------
*/

import java.util.*;

public class LowestCommonAncestor {

    public static Node lcaBST (Node root, Node p, Node q){
    
        if(root == null){
            return null;
        }

        int pVal = p.value;
        int qVal = q.value;

        while (root!=null){
            int rootVal = root.value;

            if(pVal>rootVal && qVal>rootVal){
                root = root.right;
            }else if(pVal< rootVal && qVal<rootVal){
                root = root.left;
            }else{
                return root;
            }
            
        }
        
        return null;
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
