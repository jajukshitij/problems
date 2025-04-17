/*
    Problem: Leetcode.103 Binary Tree Zigzag Level Order Traversal (Medium)   
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
                                                                           n = number of nodes
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(Node root) {

        List<List<Integer>> resultList = new ArrayList<>();

        if(root==null){
            return resultList;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean zigzag = false;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0; i<size;i++){

                Node currentNode = queue.poll();
                if(zigzag){
                    currentLevel.add(0,currentNode.value);
                }else{
                    currentLevel.add(currentNode.value);
                }

                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            zigzag=!zigzag;
            resultList.add(currentLevel);
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
