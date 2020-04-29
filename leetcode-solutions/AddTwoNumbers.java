public class AddTwoNumbers {

/*  
    Problem : Leetcode 2. Add Two Numbers (Medium)
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
    -----------------------------------------------------------------------------------------------------------
    Reference:
    https://www.youtube.com/watch?v=LLPuC5kWD8U#action=share

    ------------------------ Time Complexity: O(max(m,n)) ------------------------
                                              m and n = number of nodes in l1 and l2, respectively.    
    ------------------------ Space Complexity: O(max(m,n)) ------------------------
                                               size of new result list.
*/

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;

        while(l1 != null || l2!= null || carry !=0){

            int sum = ((l1 == null) ? 0 : l1.value ) + ((l2 == null)? 0 : l2.value) + carry; // If a node is null add 0 
                                                                                             //else node.value
            result.next = new ListNode(sum % 10);
            carry = sum /10;

            if(l1 != null){
                l1 = l1.next; // Advance l1
            }

            if(l2 !=null){
                l2 = l2.next; // Advance l2
            }

            result = result.next; // Advance result
        }
        return head.next;
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
        list1.next = new ListNode(5);
        list1.next.next = new ListNode(9);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(6);
        System.out.print("First List is ");
        print(list1);

        // creating seconnd list
        ListNode list2 = new ListNode(8);
        list2.next = new ListNode(4);
        System.out.print("Second List is ");
        print(list2);

        // add the two lists and see the result
        ListNode rs = addTwoNumbers(list1, list2);
        System.out.print("Resultant List is ");
        print(rs);
    }

    static void print(ListNode start) {
        ListNode ptr = start;
        while (ptr != null)
        {
            System.out.println("Node = " + ptr.value);
            ptr = ptr.next;
        }
    }
}
