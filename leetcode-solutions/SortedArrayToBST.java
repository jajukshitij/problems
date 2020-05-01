/*
    Problem: Leetcode.108 Convert Sorted Array to Binary Search Tree (Easy)
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    For this problem, a height-balanced binary tree is defined as 
    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Example:
    Given the sorted array: [-10,-3,0,5,9],
    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
          0
         / \
       -3   9
       /   /
     -10  5
    ------------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: O(n) ------------------------------------------------------------
    ------------------------------------------------- Space Complexity: O(n) ------------------------------------------------------------
                                                                      O(n) to store output and O(log n) for recursive stack
    InOrder Traversal
    
*/

public class SortedArrayToBST {

    public static Node sortedArrayToBST(int[] nums){
        return helper(nums,0, nums.length-1);
    }

    public static Node helper(int[] nums, int left, int right){
    
        if(left > right){
            return null;
        }
        
        int mid = (left+right)/2;

        Node root = new Node(nums[mid]);
        root.left = helper(nums, left,mid-1);
        root.right = helper(nums, mid+1, right);

        return root;
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

    public static void main(String[] args){
        int[] nums = {-10,-3,0,5,9};
        Node root = sortedArrayToBST(nums);
    }
}
