/*
    Problem: Leetcode.138 Copy List With Random Pointer (Medium)
    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
    Return a deep copy of the list.
    The Linked List is represented in the input/output as a list of n nodes.
    Each node is represented as a pair of [val, random_index] where:
    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=EHpS2TBfWQg
    Check comments: https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43488/Java-O(n)-solution
    ----------------------------------------------------------------------------------------------------------------------------------
*/

import java.util.HashMap;
import java.util.Map;

public class RandomPointer {

    // --------------------------------------------------- Method 1: Using HashMap ----------------------------------------------------
    //----------------------------------------------------- Time Complexity O(n) ------------------------------------------------------
    // ---------------------------------------------------- Space Complexity O(n) -----------------------------------------------------

    public static AlNode deepCopyHashMap (AlNode head){
        if (head == null) return null;

        Map<AlNode, AlNode> map = new HashMap<AlNode, AlNode>();

        // loop 1. copy all the nodes
        AlNode ptr = head;
        while (ptr != null) {
            map.put(ptr, new AlNode(ptr.value)); // Map (Original, NewNode)
            ptr = ptr.next;
        }

        // loop 2. assign next and random pointers
        ptr = head;
        while (ptr != null) {
            map.get(ptr).next = map.get(ptr.next); // newNode's next pointer  =  OriginalNodes's next pointer
                                                    // map.get(originalNode) gets newNode as it is the value, then it is newNode.next
                                                    // ptr.next is oldNode's next pointer:  map.get(ptr.next) gets value of corresponding newNode
            map.get(ptr).arbitrary = map.get(ptr.arbitrary);
            ptr = ptr.next;
        }

        return map.get(head);
    }

    // --------------------------------------------------- Method 2: Inserting new nodes in the list ----------------------------------------------------
    //----------------------------------------------------- Time Complexity O(n) ------------------------------------------------------
    // ---------------------------------------------------- Space Complexity O(1) -----------------------------------------------------

    public static AlNode deepCopy (AlNode head){

        if (head== null){
            return null;
        }

        AlNode ptr = head;

        // ----------------------------------- STEP 1----------------------------------------------
        // Copying a new Linked List
        // Inserting newNodes between node 1 and node 2 .. etc.

        while(ptr != null){
            AlNode newNode = new AlNode(ptr.value);     // Copying the original value of oldNode to newNode
            newNode.next = ptr.next;                    // Copying the oldNode's next pointer, now both newNode1 and oldNode1 -> oldNode2
            ptr.next = newNode;                         // Setting next pointer of oldNode1 -> newNode1.
                                                        // This make oldNode1 -> newNode1 -> oldNode2
            ptr = newNode.next;                         // Now repeating process for oldNode2
        }

        ptr = head;

        // ----------------------------------- STEP 2----------------------------------------------
        // Copying Random Pointers to new list

        while(ptr!=null){
            if(ptr.arbitrary !=null) {
                ptr.next.arbitrary = ptr.arbitrary.next;    // ptr.next.arbitrary = newNode1's arbitrary pointer
            }                                               // ptr.arbitrary.next = corresponding newNode pointed by oldNode1's arbitrary

            ptr = ptr.next.next;                            // Hopping to next oldNode
        }

        // ----------------------------------- STEP 3----------------------------------------------
        // Breaking two lists - restoring original list and new list

        AlNode old_list = head;
        AlNode new_list = head.next;
        ptr = new_list;

        while(old_list != null){

            old_list.next = new_list.next; // Setting next pointer to oldNode2, skipping one node (newNode in between)
            old_list = old_list.next;

            if(new_list.next != null) {
                new_list.next = old_list.next; // Setting next pointer to newNode2, skipping one node (oldNode in between)
            }
            new_list = new_list.next;
        }

        return ptr;
    }
    
    
    public static  class AlNode {
        public int value;
        public AlNode next;
        public AlNode arbitrary;


        public AlNode(int val) {
            this.value = val;
            this.next = null;
            this.arbitrary = null;
        }

        public AlNode() {
            this.value = -1;
            this.next = null;
            this.arbitrary = null;
        }
    }


    public static void main(String[] args) {
        AlNode start = new AlNode(1);
        start.next = new AlNode(2);
        start.next.next = new AlNode(3);
        start.next.next.next = new AlNode(4);
        start.next.next.next.next = new AlNode(5);

        // 1's random points to 3
        start.arbitrary = start.next.next;

        // 2's random points to 1
        start.next.arbitrary = start;

        // 3's and 4's random points to 5
        start.next.next.arbitrary = start.next.next.next.next;
        start.next.next.next.arbitrary = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.arbitrary = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        AlNode cloned_list = deepCopyHashMap(start);
        print(cloned_list);
    }

    static void print(AlNode start) {
        AlNode ptr = start;
        while (ptr != null)
        {
            System.out.println("Data = " + ptr.value +
                    ", Random = "+ptr.arbitrary.value);
            ptr = ptr.next;
        }
    }
}
