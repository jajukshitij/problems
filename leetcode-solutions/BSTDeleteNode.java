/*
    Problem: Leetcode. 450 Delete Node In BST (Medium)
    
    Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
    Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.
    Note: Time complexity should be O(height of tree).

    Example:

    root = [5,3,6,2,4,null,7]
    key = 3

        5
       / \
      3   6
     / \   \
    2   4   7

    Given key to delete is 3. So we find the node with value 3 and delete it.

    One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

        5
       / \
      4   6
     /     \
    2       7

    Another valid answer is [5,2,6,null,4,null,7].

        5
       / \
      2   6
       \   \
        4   7
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=a-53QSxovUA
    -----------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(h) ---------------------------------------------------------
                                                                         h = height of tree
*/

public class BSTDeleteNode {

    public static  class Node {
        int value;
        Node left, right;

        public Node(int item)
        {
            value = item;
            left = right = null;
        }
    }

    public static Node deleteNode(Node root, int key){
        if(root == null){
            return null;
        }
        // Searching key in the tree
        if(root.value > key){
            root.left = deleteNode(root.left, key);
        }else if(root.value < key){
            root.right = deleteNode(root.right, key);
        }else{ // Key found
        
            if(root.left == null){ // Case 1. key = leaf node / no left sub-tree
                return root.right;
            }else if(root.right== null){ // Case 2. key = no right sub-tree
                return root.left;
            }else{ // Case 3. key has both left and right sub-tree
                Node minNode = getMin(root.right); // Find the smallest node in right-subtree
                root.value = minNode.value; // Replace key with the smallest node found
                root.right = deleteNode(root.right,root.value); // Recursive Call to delete the smallest found node 
            }
        }

        return root;
    }

    public static Node getMin(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
