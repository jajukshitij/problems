/*
    Problem: Leetcode. 364. Nested List Weight Sum II (Medium)
    Description
    You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
    The depth of an integer is the number of lists that it is inside of. 
    For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth. Let maxDepth be the maximum depth of any integer.
    The weight of an integer is maxDepth - (the depth of the integer) + 1.
    Return the sum of each integer in nestedList multiplied by its weight.

    Example 1:
    Input: nestedList = [[1,1],2,[1,1]]
    Output: 8
    Explanation: Four 1's with a weight of 1, one 2 with a weight of 2.
    1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8
    
    Example 2:
    Input: nestedList = [1,[4,[6]]]
    Output: 17
    Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1.
    1*3 + 4*2 + 6*1 = 17
    -------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------Time Complexity: O(n) ------------------------------------------------------
    ---------------------------------------Space Complexity: O(d) ------------------------------------------------------
                                                             d = the maximum depth; d recursive call stack for dfs()

    DFS

    Original Ask: 
                  v × (maxDepth - d + 1)
    Expanding this:
                  v × maxDepth - v × d + v
    Summation across all Nodes:

    (sum of all v × maxDepth) - (sum of all (v × d)) + (sum of all v)
    => (sum of all v) x maxDepth + (sum of all v) - (sum of all (v × d))
    => (sum of all v) x (maxDepth + 1) - (sum of all (v × d))
    => unweightedSum x (maxDepth +1) - weightedsum
*/


public class NestedListWeightSum2 {
    private int maxDepth;
    private int weightedSum; // sum of (value * depth) for all integers
    private int simpleSum; // sum of all integer values (without weights)

    public int depthSumInverse(List<NestedInteger> nestedList) {
        // Process each element in the input list starting at depth 1
        for (NestedInteger nestedInteger : nestedList) {
            dfs(nestedInteger, 1);
        }
        return  simpleSum * (maxDepth + 1) - weightedSum;
    }

    private void dfs(NestedInteger nestedInteger, int currentDepth) {
        // Update the maximum depth encountered
        maxDepth = Math.max(maxDepth, currentDepth);

        if (nestedInteger.isInteger()) {
            // Process integer value: add to both weighted and simple sums
            int value = nestedInteger.getInteger();
            weightedSum += value * currentDepth;
            simpleSum += value;
        } else {
            // Process nested list: recursively traverse each element
            for (NestedInteger childNestedInteger : nestedInteger.getList()) {
                dfs(childNestedInteger, currentDepth + 1);
            }
        }
    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */


