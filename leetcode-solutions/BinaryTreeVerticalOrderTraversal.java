public class BinaryTreeVerticalOrderTraversal {

/*  
    Problem : Leetcode 314. Binary Tree Vertical Order Traversal (Medium)

    Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
    If two nodes are in the same row and column, the order should be from left to right.
    
    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: [[9],[3,15],[20],[7]]
    
    Example 2:
    Input: root = [3,9,8,4,0,1,7]
    Output: [[4],[9],[3,0,1],[8],[7]]
    
    Example 3:
    Input: root = [1,2,3,4,10,9,11,null,5,null,null,null,null,null,null,null,6]
    Output: [[4],[2,5],[1,10,9,6],[3],[11]]
    -----------------------------------------------------------------------------------------------------------

    ------------------------ Time Complexity: O(N)) ------------------------
                                             N = number of nodes    
    ------------------------ Space Complexity: O(N) ------------------------
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
  public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        {
        return result;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<PairClass> queue = new LinkedList<>();
        queue.offer(new PairClass(root, 0));
        int minCol =0, maxCol=0;

        while(!queue.isEmpty())
        {
            PairClass pair = queue.poll();
            TreeNode node = pair.node;
            int col = pair.column;

            if(!map.containsKey(col))
            {
            map.put(col, new ArrayList<>());
            }

            map.get(col).add(node.val);
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            
            if(node.left != null)
            {
            queue.offer(new PairClass(node.left, col-1));
            }        
            if(node.right != null)
            {
            queue.offer(new PairClass(node.right, col+1));
            }
        }

        for(int i =minCol; i<=maxCol; i++)
        {
            result.add(map.get(i));
        }
        
        return result;
    }

  public class PairClass {
    int column;
    TreeNode node;

    PairClass(TreeNode node, int column){
      this.column = column;
      this.node = node;
    }
}





















