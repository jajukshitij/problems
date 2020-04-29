/*
    Problem: Leetcode.559 Maximum Depth of N-ary Tree (Hard)
    Given a n-ary tree, find its maximum depth.
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.

    Example 1:
    Input: root = [1,null,3,2,4,null,5,6]
    Output: 3
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------- Time Complexity: O(N) ; visit every node once ---------------------------------------
    ------------------------------------------- Space Complexity: O(N) --------------------------------------------------------------
*/


public class HeightOfNaryTree {

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int max_d = 0;
        for(Node child: root.children){
            max_d = Math.max(max_d, maxDepth(child));
        }

        return max_d+1;
    }
    
    public static class Node {
    
    int val;
    List<Node> children;

      public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
      }
    }
}
