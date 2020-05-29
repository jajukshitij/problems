/*
    Problem: Leetcode. 116 Populating Next Right Pointers in Each Node (Medium)
         and Leetcode. 117 Populating Next Right Pointers in Each Node II (Medium)
    
    The binary tree has the following definition:
    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }
    
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.
    
    Follow up:
    You may only use constant extra space.
    Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
    ------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
    --------------------------------------------------- Space Complexity: O(1) ----------------------------------------------------
*/

public class BinaryTreeNextRightPointer {

    public Node connect(Node root) {
       
        if (root == null) {
            return root;
        }
        
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        while (queue.size() > 0) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                
                Node node = queue.poll();
                
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                
                if (node.left != null) {
                    Q.add(node.left);
                }
                
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }
        
        return root;        
    }    
}
