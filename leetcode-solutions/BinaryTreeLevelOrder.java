/*
    Problem: LeetCode.102 Binary Tree Level Order Traversal (Medium)
    
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]
    -------------------------------------------------------------------------------------------------------------------------------
    Problem: LeetCode.107 Binary Tree Level Order Traversal II (Easy)
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
    -------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) --------------------------------------------------
                                                                             n = number of nodes
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {

    public static List<List<Integer>> levelOrder(Node root){

        List<List<Integer>> resultList = new ArrayList<>();

        if(root==null){
            return resultList;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0; i<size;i++){

                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);

                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            resultList.add(currentLevel);
           // resultList.add(0,currentLevel); // to create a reverse list of levels (BST Level Order Traversal II)
        }

        return resultList;
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
    
     public static void main(String args[]) {

        BinaryTreeLevelOrder tree = new BinaryTreeLevelOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);

        System.out.println(levelOrder(root));
    }
}
