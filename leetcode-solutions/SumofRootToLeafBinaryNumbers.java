/*
    Problem: Leetcode.1022 Sum of Root to Leaf Binary Numbers (Easy)
    Given a binary tree, each node has value 0 or 1.
    Each root-to-leaf path represents a binary number starting with the most significant bit.
    For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
    For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
    Return the sum of these numbers.

    Example 1:
    Input: [1,0,1,0,1,0,1]
    Output: 22
    Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
*/

public class SumOfRootToLeafBinaryNumbers {

    static int sum = 0;
    
    public static int sumRootToLeaf(Node root){
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);

        return sum;
    }

    public static void dfs(Node root, StringBuilder sb){
    
        if(root == null){
            return;
        }

        if(root.left == null && root.right ==  null) {
            sum += Integer.parseInt(sb.toString() + root.value, 2);
        }

        dfs(root.left, sb.append(root.value));
        dfs(root.right, sb.append(root.value));

        sb.deleteCharAt(sb.length()-1);
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
