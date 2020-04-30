/*
    Problem: Leetcode.234 Palindrome Linked List (Easy)
    Given a singly linked list, determine if it is a palindrome.

    Example 1:
    Input: 1->2
    Output: false
    
    Example 2:
    Input: 1->2->2->1
    Output: true
    ---------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------------- Time Complexity: O(n) -------------------------------------------------
                                                                               n = length of list; all are linear operations
*/

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public static boolean isPalindome(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head;

        // Getting to middle of the linked list
        while(fast!=null && fast.next!=null){
        
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reversing the second half
        ListNode secondHalf = reverseLinkedlist(slow);

        // Comparing each element in 2 lists
        while(secondHalf!=null){
        
            if(head.value!= secondHalf.value){
                return false;
            }
            
            head = head.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static ListNode reverseLinkedlist(ListNode head){
    
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!=null){
        
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
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

    public static void main(String[] args){

        ListNode list1 = new ListNode();

        list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        System.out.println(isPalindome(list1));
    }

}
