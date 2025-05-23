/*
    Problem: LeetCode. 199. Binary Tree Right Side View (Medium)
    
    Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

    Example 1:    
    Input: root = [1,2,3,null,5,null,4]    
    Output: [1,3,4]    
    Explanation:
          1 <-------
         / \
        2   3 <-------
         \   \
         5    4 <-------
      
    Example 2:    
    Input: root = [1,2,3,4,null,null,null,5]    
    Output: [1,3,4,5]    
    Explanation:
          1 <-------
         / \
        2   3 <-------
       / 
      4 <-------
     /
    5 <-------
    
    Example 3:    
    Input: root = [1,null,3]    
    Output: [1,3]
    
    Example 4:    
    Input: root = []    
    Output: []
    -------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) --------------------------------------------------
                                                                             n = number of nodes
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i =0; i< size; i++)
            {
                TreeNode node = queue.poll();

                if(i == size-1)
                {
                    result.add(node.val);
                }

                if(node.left != null)
                {
                    queue.add(node.left);
                }

                if(node.right != null)
                {
                    queue.add(node.right);
                }
            }
        }

        return result;
    }
}
