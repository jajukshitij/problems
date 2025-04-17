/*
    Problem: Leetcode.206 Reverse Linked List (Easy)
    Reverse a singly linked list.

    Example:
    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=O0By4Zq0OFc
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
    ---------------------------------------------------- Space complexity: O(1) ---------------------------------------------------
*/


public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next; // Save next node
            curr.next = prev; // Reverse next pointer
            prev = curr; // Advance prev
            curr = next; // Advance curr
        }

        return prev;
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

    public static void main(String args[]) {
        ListNode list1 = new ListNode();

        list1 = new ListNode(7);
        list1.next = new ListNode(8);
        list1.next.next = new ListNode(9);
        list1.next.next.next = new ListNode(10);
        list1.next.next.next.next = new ListNode(15);
        System.out.println("Original List is ");
        print(list1);


        ListNode rs = reverseList(list1);
        System.out.println("Reversed List is ");
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
