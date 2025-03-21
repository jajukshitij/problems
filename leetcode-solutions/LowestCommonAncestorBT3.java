/*
    Problem: Leetcode.1650 Lowest Common Ancestor of Binary Tree III (Medium)
    Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
    Each node will have a reference to its parent node. The definition for Node is below:    
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
    
    According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants 
    (where we allow a node to be a descendant of itself)."     
    
    Example 1:    
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    Output: 3
    Explanation: The LCA of nodes 5 and 1 is 3.
    
    Example 2:    
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    Output: 5
    Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant of itself according to the LCA definition.
    
    Example 3:    
    Input: root = [1,2], p = 1, q = 2
    Output: 1
    --------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(N) -----------------------------------------------------
    ---------------------------------------------------- Space Complexity: O(N)-----------------------------------------------------
*/

class LowestCommonAncestorBT3 {
    public Node lowestCommonAncestor(Node p, Node q) {
      Set<Node> visited = new HashSet<>();
        while (p!=null || q!=null) {
            if (visited.contains(p)) return p;
            if(p!=null) {
                visited.add(p);
                p = p.parent;
            }
            if (visited.contains(q)) return q;
            if(q!=null) {
                visited.add(q);
                q = q.parent;
            }
        }
        return null;
    }
}


















