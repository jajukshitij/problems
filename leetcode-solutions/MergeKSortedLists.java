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

   //------------------------------------------------- Merge 1 List at a Time -------------------------------------------------------- 
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


