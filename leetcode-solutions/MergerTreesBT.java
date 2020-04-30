/*
    Problem: Leetcode.617 Merge Two Binary Trees (Easy)
    Given two binary trees and imagine that when you put one of them to cover the other,
    some nodes of the two trees are overlapped while the others are not.
    You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
    then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

    Example 1:
    Input: 
      Tree 1                     Tree 2                  
              1                         2                             
             / \                       / \                            
            3   2                     1   3                        
           /                           \   \                      
          5                             4   7                  
    Output: 
    Merged tree:
           3
          / \
         4   5
        / \   \ 
       5   4   7
    ------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(n) ---------------------------------------------------
                                                                          n = min number of nodes from 2 trees traversed
    ---------------------------------------------------- Space Complexity: O(n) -------------------------------------------------
    
*/

public class MergeTrees {

    public static Node mergeTrees(Node t1, Node t2){
    
        if(t1== null){
            return t2;
        }
        
        if(t2== null){
            return t1;
        }

        t1.value = t1.value+ t2.value;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
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
