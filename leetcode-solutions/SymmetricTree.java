/*
    Problem: Leetcode.101 Symmetric Tree (Easy)
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following [1,2,2,null,3,null,3] is not:
        1
       / \
      2   2
       \   \
       3    3
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------------- Time Compllexity: O(n) ------------------------------------------------
    --------------------------------------------------------- Space Compllexity: O(n) ------------------------------------------------
                                                                                 recursive call stack
*/

public class SymmetricTree {

    static Node prev;
    static  Node root;

    public static boolean isSymmetric(Node root){
        return isMirror(root,root);
    }

    public static boolean isMirror(Node n1, Node n2){
    
        if(n1==null && n2== null){
            return true;
        }
        
        if(n1==null || n2==null) {
            return false;
        }

        if( n1.value == n2.value && isMirror(n1.left,n2.right) && isMirror(n1.right,n2.left) ){
            return true;
        }else {
            return false;
        }

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

        SymmetricTree tree = new SymmetricTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);

        System.out.println(isSymmetric(root));
    }
    
}
