/*
    Problem: Leetcode.938 Range Sum of BST (Easy)
    Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
    The binary search tree is guaranteed to have unique values.

    Example 1:
    Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
    Output: 32
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
*/

public class SumOfRootToLeafBinaryNumbers {

    int sum =0;

    public int rangeSumBST(DiameterOfBinaryTree.Node root, int L, int R) {
        dfs(root, L, R);
        return sum;
    }

    public void dfs(DiameterOfBinaryTree.Node root, int L, int R){
    
        if(root == null){
            return;
        }

        if(root.value>= L && root.value<=R){
            sum +=root.value;
        }

        dfs(root.left, L, R);
        dfs(root.right, L, R);
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
