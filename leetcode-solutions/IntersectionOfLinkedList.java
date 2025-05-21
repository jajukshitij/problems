/*
    Problem: Leetcode.160  Intersection of Two Linked Lists (Easy)
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
    If the two linked lists have no intersection at all, return null.
    
    For example, the following two linked lists begin to intersect at node c1: 
    The test cases are generated such that there are no cycles anywhere in the entire linked structure.    
    Note that the linked lists must retain their original structure after the function returns.    
    Custom Judge:    
    The inputs to the judge are given as follows (your program is not given these inputs):    
    intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
    listA - The first linked list.
    listB - The second linked list.
    skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
    skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
    The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program.
    If you correctly return the intersected node, then your solution will be accepted.

    Example 1:  
    Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
    Output: Intersected at '8'
    Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
    From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
    There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
    - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references.
    In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
    
    Example 2:
    Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
    Output: Intersected at '2'
    Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
    From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4].
    There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
*/

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfLinkedLists {
    
    //------------------------------------------------- Method 1: Using HashSet ------------------------------------------------------
    //------------------------------------------------- Time Complexity: O(n+m) ------------------------------------------------------
    // ---------------------------------------------- Space Complexity: O(n) or O(m) --------------------------------------------------

    // Adding all one list to hashset and traversing through the other to check if the same nodes exists in hashset
    
    public static ListNode itersectionHashSet(ListNode headA, ListNode headB){
        if(headA== null || headB== null){
            return null;
        }

        Set<ListNode> set = new HashSet<>();

        ListNode p = headA;

        while(p!= null){
            set.add(p);
            p= p.next;
        }

        ListNode q = headB;

        while(q != null && !set.contains(q))
        {
            q = q.next;
        }

        return q;
    }

    //------------------------------------------------- Method 1: Using Two Pointer ------------------------------------------------------
    //------------------------------------------------- Time Complexity: O(n+m) ------------------------------------------------------
    // ------------------------------------------------- Space Complexity: O(1) ------------------------------------------------------

    public static ListNode intersection(ListNode headA, ListNode headB){
        if(headA== null || headB== null){
            return null;
        }

        ListNode p = headA;
        ListNode q = headB;
        int lenA = 0;
        int lenB = 0;

        while(p!= null){
            lenA++;
            p = p.next;
        }

        while(q!= null){
            lenB++;
            q= q.next;
        }

        // Getting two pointers to equal length starting point (remaining list length from here is same in both lists ) 
        // In case listA is longer than listB
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }

        // In case listB is longer than listA
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }

        // Incrementing both the pointers simultaneously while checking if they are pointing to the same node
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
    
    public static  class ListNode {
        public int value;
        public ListNode next;


        public ListNode(int val) {
            this.value = val;
            this.next = null;
        }

        public ListNode() {
            this.value = -1;
            this.next = null;
        }
    }
    
}
