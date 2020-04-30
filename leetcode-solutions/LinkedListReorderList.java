/*
    Problem: Leetcode.143 Reorder List (Medium)
    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    You may not modify the values in the list's nodes, only nodes itself may be changed.

    Example 1:
    Given 1->2->3->4, reorder it to 1->4->2->3.
    -------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=xRYPjDMSUFw
    -------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
                                                                         n = numbe rof nodes, all 3 steps are linear process
*/

public class LinkedListReorderList {

    public static void reorderList(ListNode head){

        if(head==null || head.next==null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode ptr = head;

        // Step 1. Find the middle node in List to break it in two halves
        while(fast!=null && fast.next!= null){
            prev= slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // Step2. Reverse the second half of the list
        ListNode rev_list = reverse(slow);
        
        // Step 3. Merge the two resulting lists
        merge(ptr, rev_list);
    }

    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void merge(ListNode l1, ListNode l2){

        while(l1!=null){
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            l1.next = l2;
            if(l1_next==null){
                break;
            }
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
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
