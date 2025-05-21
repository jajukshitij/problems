/*  
    Problem : Leetcode 445. Add Two Numbers II (Medium)
    You are given two non-empty linked lists representing two non-negative integers.
    The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
       
    Example 1:
    Input: l1 = [7,2,4,3], l2 = [5,6,4]
    Output: [7,8,0,7]
    
    Example 2:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [8,0,7]

    ------------------------ Time Complexity: O(m +n) ------------------------
                                              m and n = number of nodes in l1 and l2, respectively.    
    ------------------------ Space Complexity: O(m + n) ------------------------
                                               size of new result list.
*/

public class AddTwoNumbers2
  {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        int carry =0;
        ListNode result = new ListNode();
        ListNode head = result;

        while(r1 != null || r2 != null || carry != 0)
        {
            int sum =0;
            if(r1 != null)
            {
                sum += r1.val;
                r1 = r1.next;
            }

            if(r2 != null)
            {
                sum += r2.val;
                r2 = r2.next;
            }

            sum +=carry;

            carry = sum /10;
            result.next = new ListNode(sum %10);

            result = result.next;
        }

        return reverse(head.next);
    }

    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
  }
