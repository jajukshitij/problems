/*
    Problem: Leetcode.25 Reverse Nodes in k-Group (Hard)
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    k is a positive integer and is less than or equal to the length of the linked list.
    If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

    Example:
    Given this linked list: 1->2->3->4->5
    For k = 2, you should return: 2->1->4->3->5
    For k = 3, you should return: 3->2->1->4->5
    Note:
    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, only nodes itself may be changed.
    -----------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O (N * k) ----------------------------------------------------
                                                                         Traversing N nodes and reversing k
    --------------------------------------------------- Space Complexity: O(N/k) ------------------------------------------------------
                                                                         Recursive stack
*/

public class ReverseNodesKGroup {

    public static ListNode reverseKNodes(ListNode head, int k){

        int count=0;
        ListNode node = head;
        
        while(count < k){
            
            if(node== null){
                return head;        // If less than k nodes left then return head
            }
            
            node= node.next;
            count++;
        }
        
        ListNode prev = reverseKNodes(node,k); // prev node points to answer of subproblem
        ListNode curr = head;
        ListNode next = null;

        // Classic Reverse LinkedList
        while(count>0){      
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
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

        list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);
        System.out.println("Original List is ");
        print(list1);


        ListNode rs = reverseKNodes(list1, 2);
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


