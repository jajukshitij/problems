/*
    Problem: Leetcode.23 Merge k Sorted Lists (Hard)
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

    Example:
    Input:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    Output: 1->1->2->3->4->4->5->6
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=zLcNwcR6yO4
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: O(N log (k)) -------------------------------------------------
                                                                       k = no. of Linked Lists ; N= total number of Nodes
                                                                       O(log k) for every add/ remove in PQ

    ---------------------------------------------------- Space Complexity: O(N)------------------------------------------------------
*/

import java.util.PriorityQueue;

public class MergeKSortedList {

    //-------------------------------------------------- Method 1: Using PQ (not creating new nodes) (Better Time Complexity) ----------------------------------
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node); // Only adding first Node of each List 
            }
        }

        while (!queue.isEmpty()) {
            ptr.next = queue.poll();
            ptr = ptr.next;
            
            if (ptr.next != null) {
                queue.add(ptr.next);
            }
        }

        return head.next;
        /*
        Ex:
        [
        1->4->5,
        1->3->4,
        2->6
        ]
        
        After first FOR loop, queue will contain 1,1,2.        
        Now in the while loop, 1 (1st list) will be removed from queue and we test 1.next!=null and add 4 to the queue. 
        so after 1st iteration queue will be 1,2,4.        
        In the 2nd iteration, 1 ( 2nd list) will be removed from queue and test 1.next!=null (1.next is 3), add 3 to the queue.
        So queue will be 2,3,4 after this iteration and this continues, so the size of queue will always be <=K.
        */
    }

    //-------------------------------------------------- Method 2: Using PQ  O(N log (N))----------------------------------
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==1){
            return lists[0];
        }
        if(lists.length==0){
            return null;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(ListNode l :lists){
            while (l !=null) {
                priorityQueue.add(l.value);
                l= l.next;
            }
        }

        ListNode res = new ListNode(0);
        ListNode pointer = res;
        while (!priorityQueue.isEmpty()){
            res.next= new ListNode(priorityQueue.remove());
            res = res.next;
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

   //------------------------------------------------- Method 3: Merge 1 List at a Time -------------------------------------------------------- 
   /*------------------------------------------------- Time Complexity: O(kN) --------------------------------------------------------
                                                                       k = no. of Linked Lists ; N= total number of Nodes
                                                                       O(log k) for every add/ remove in PQ

    ---------------------------------------------------- Space Complexity: O(N)------------------------------------------------------*/

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1)
        {
            return lists[0];
        }

        if(lists.length==0)
        {
            return null;
        }
        for(int i =1; i<lists.length; i++)
        {
            lists[0] = merge2List(lists[0], lists[i]);
        }

        return lists[0];
    }

    public ListNode merge2List(ListNode l1, ListNode l2)
    {
        ListNode sorted = new ListNode(0);
        ListNode ptr = sorted;

        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                sorted.next = l1;
                l1 = l1.next;
            }
            else
            {
                sorted.next = l2;
                l2 = l2.next;
            }
            sorted = sorted.next;
        }

        if(l1 != null)
        {
            sorted.next = l1;
        }
        if(l2 != null)
        {
            sorted.next = l2;
        }

        return ptr.next;
    }
}


