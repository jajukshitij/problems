/*
    Problem: Leetcode.19 Remove Nth Node from end of the List (Medium)
    Given a linked list, remove the n-th node from the end of list and return its head.

    Example:
    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:
    Given n will always be valid.
    Follow up:
    Could you do this in one pass?
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
    ------------------------------------------------------ Space Complexity: O(1) -----------------------------------------------------
    
*/

public class RemoveNthNode {

    public static ListNode removeNode(ListNode head, int k){
    
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i=0; i<=k; i++){
            fast = fast.next; // Setting fast k+1 (dummy starts prev to 0 th node) nodes ahead
        }

        while(fast!= null){ // When fast == nul, slow will be pointing at node previous to target node
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next; // removing node nest to slow

        return dummy.next;
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

    public static void main(String[] args){
        ListNode list1 = new ListNode();

        list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);
        System.out.println("Original List is ");
        print(list1);


        ListNode rs = removeNode(list1,2);
        System.out.println("Removed Node list is ");
        print(rs);
    }

    static void print(ListNode start) {
        ListNode ptr = start;
        while (ptr != null)
        {
            System.out.println("Data = " + ptr.value);
            ptr = ptr.next;
        }
    }
}

