/*
Leetcode.404 Sum Of Left Leaves

Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node. 

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.

Example 2:
Input: root = [1]
Output: 0

*/

public class SumOfLeftLeaves
{
  public int sumOfleftLeaves(TreeNode root)
  {
    
    if(root == null)
    {
      return 0;
    }

    int sum = 0;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while(!stack.isEmpty())
    {
      TreeNode node = stack.pop();
      if(node.left != null)
      {
        if(node.left.left == null && node.left.right == null)
        {
          sum += node.left.val;
        }
        stack.push(node.left);
      }

      if(node.right != null)
      {
        stack.push(node.right);
      }
    }
    
    return sum;
  }  
}



