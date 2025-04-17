/*
    Problem: Leetcode.236 Lowest Common Ancestor of Binary Tree (Medium)
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as 
    the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
    Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
    
    Example 1:
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    Output: 3
    Explanation: The LCA of nodes 5 and 1 is 3.
    --------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=py3R23aAPCA
    --------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(N) -----------------------------------------------------
    ---------------------------------------------------- Space Complexity: O(N)-----------------------------------------------------
*/

import java.util.*;

public class LowestCommonAncestor {

    public static Node lcaBinaryTree (Node root, Node p, Node q){
    
        if(root ==null){
        }

        Stack<Node> stack = new Stack<>();
        Map<Node, Node> map = new HashMap<>(); // Stroing < Child, Ancestor > relation of each node

        map.put(root, null);
        stack.push(root);

        while(!map.containsKey(p) || !map.containsKey(q)){ // Traversing tree till p and q 

            Node curr_node = stack.pop();

            if(curr_node.left!= null){
                map.put(curr_node.left, curr_node);
                stack.push(curr_node.left);
            }
            
            if(curr_node.right!= null){
                map.put(curr_node.right, curr_node);
                stack.push(curr_node.right);
            }
        }

        Set<Node> ancestors = new HashSet<>();

        while(p!= null){ // Storing all the ancestors of p up till root, including p
            ancestors.add(p);
            p = map.get(p);
        }

        while(!ancestors.contains(q)){ // checking in ancestor set of p, if contains any of the ancestors of q 
                                       // starting from lowest i.e. q
            q = map.get(q);
        }

        return q;
    }

// ------------------------------------------------------- Method 2: Recursive ----------------------------------------------------------
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == p || root == q || root == null)
            return root;
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        if(left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;        
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

