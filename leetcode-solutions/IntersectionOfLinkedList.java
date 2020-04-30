/*
    Problem: Leetcode. Intersection of Linked Lists
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

        while(q!= null){
            if(set.contains(q)){
                return q;
            }
            q = q.next;
        }

        return null;
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

        // Getting two pointers to the same starting point in case listA is longer than listB
        while(lenA>lenB){
            p = p.next;
            lenA--;
        }

        // Getting two pointers to the same starting point in case listB is longer than listA
        while(lenB>lenA){
            q = q.next;
            lenB--;
        }

        // Incrementing both the pointers simultaneously while checking if they are pointing to the same node
        while(p!=q){
            p = p.next;
            q = q.next;
        }

        return p;
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
