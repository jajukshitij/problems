/*
    Problem: Leetcode.21 Merge Two Sorted Lists (Easy)
    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.

    Example:
    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
    --------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n) ------------------------------------------------------
    --------------------------------------------------- Space complexity: O(1) -----------------------------------------------------
*/

public class MergeSortedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    
        ListNode sorted = new ListNode(0);
        ListNode pointer = sorted;

        while(l1 !=null && l2 !=null){
        
            if(l1.value<= l2.value){
                sorted.next= l1;
                l1 = l1.next;
                
            } else {
                sorted.next = l2;
                l2 =l2.next;
            }
            
            sorted = sorted.next;
        }
        
        if(l1!=null){
            sorted.next =l1;
        }

        if(l2!=null){
            sorted.next =l2;
        }
        
        return pointer.next;
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
        // creating first list
        list1 = new ListNode(7);
        list1.next = new ListNode(8);
        list1.next.next = new ListNode(9);
        list1.next.next.next = new ListNode(10);
        list1.next.next.next.next = new ListNode(15);
        System.out.print("First List is ");
        print(list1);

        // creating seconnd list
        ListNode list2 = new ListNode(4);
        list2.next = new ListNode(5);
        System.out.print("Second List is ");
        print(list2);

        // add the two lists and see the result
        ListNode rs = mergeTwoLists(list1, list2);
        System.out.print("Resultant List is ");
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


