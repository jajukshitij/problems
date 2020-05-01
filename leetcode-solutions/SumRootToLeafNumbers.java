/*
    Problem: Leetcode.129 Sum of Root to Leaf Binary Numbers (Medium)
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
    An example is the root-to-leaf path 1->2->3 which represents the number 123.
    Find the total sum of all root-to-leaf numbers.
    Note: A leaf is a node with no children.

    Example:
    Input: [1,2,3]
        1
       / \
      2   3
    Output: 25
    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
*/

public class SumOfRootToLeafBinaryNumbers {

    int total =0;
    
    public int sumNumbers(DiameterOfBinaryTree.Node root) {
        sumRoot(root, 0);
        return total;
    }

    public void sumRoot(DiameterOfBinaryTree.Node root, int sum){
    
        if(root== null){
            return;
        }

        sum = sum*10 + root.value;

        if(root.left==null && root.right== null){
            total += sum;
        }

        sumRoot(root.left, sum);
        sumRoot(root.right, sum);
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
