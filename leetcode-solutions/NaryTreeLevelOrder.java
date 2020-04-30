/*
    Problem: Leetcode.429 N-ary Tree Level Order Traversal (Medium)
    Given an n-ary tree, return the level order traversal of its nodes' values.
    Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.
    Follow up:
    Recursive solution is trivial, could you do it iteratively?

    Example 1:
    Input: root = [1,null,3,2,4,null,5,6]
    Output: [[1],[3,2,4],[5,6]]
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) ------------------------------------------------------
    ---------------------------------------------------- Space Complexity: O(n) ------------------------------------------------------
    
*/

import java.util.*;

public class NaryTreePreorder {

    public static List<List<Integer>> levelOrder(Node root){
    
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
        
            int size = queue.size();
            List<Integer> currentList = new ArrayList<>();

            for(int i=0; i<size ; i++){
            
                Node curr = queue.poll();
                currentList.add(curr.val);

                for(Node child: curr.children){
                    queue.add(child);
                }
            }

            result.add(currentList);
        }

        return result;
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

