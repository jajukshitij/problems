/*
    Problem: Leetcode.589 N-ary Tree Preorder Traversal (Easy)
    Given an n-ary tree, return the preorder traversal of its nodes' values.
    Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.
    Follow up:
    Recursive solution is trivial, could you do it iteratively?

    Example 1:
    Input: root = [1,null,3,2,4,null,5,6]
    Output: [1,3,5,6,2,4]
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) ------------------------------------------------------
    ---------------------------------------------------- Space Complexity: O(n) ------------------------------------------------------
    
*/

import java.util.*;

public class NaryTreePreorder {

    // ----------------------------------------------- Iterative Approach --------------------------------------------------------

    public static List<Integer> preorder(Node root){
        List<Integer> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
        
            Node curr = stack.pop();
            result.add(curr.val);

            for(int i=curr.children.size()-1; i>=0; i--){
            
                stack.push(curr.children.get(i));
            }
        }

        return result;
    }
    
    // ----------------------------------------------- Recursive Approach --------------------------------------------------------
    
    ArrayList<Integer> result_rec = new ArrayList<>();

    public List<Integer> preorderRecursive(Node root) {
    
        if(root == null){
            return result_rec;
        }
        
        result_rec.add(root.val);
        
        for(int i = 0; i<root.children.size();i++){
        
            preorderRecursive(root.children.get(i));
        }
        
       return result_rec;
    }
    
    public static  class Node {
        public int val;
        public List<Node> children;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}


