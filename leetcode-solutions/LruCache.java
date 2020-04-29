/*
    Problem: Leetcode.146 LRU Cache (Medium)
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
    The cache is initialized with a positive capacity.
    Follow up:
    Could you do both operations in O(1) time complexity?

    Example:
    LRUCache cache = new LRUCache( 2 /* capacity */ );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    
    https://github.com/bephrem1/backtobackswe/blob/master/Linked%20Lists/LRUCache/LRUCache.java
    https://www.youtube.com/watch?v=S6IfqDXWa10
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: O(1) ---------------------------------------------------------
    Both get and put methods are O (1) time complexity.
    This structure satisfies the constraint for fast addition since any doubly linked list item can be added
    or removed in O(1) time with proper references.

    Hashtable: The hashtable will give us fast access to any item in the doubly linked list items
    to avoid O(n) search for items and the LRU entry (which will always be at the tail of the doubly linked list).

    -------------------------------------------------- Space Complexity: O(n) -------------------------------------------------------
    We use O(n) space since we will store n items where n is the capacity of the cache.
*/

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

        Map<Integer,ListNode> map = new HashMap<>();

        ListNode head = new ListNode();
        ListNode tail = new ListNode();

        int maxCap;
        int currCap;

        public class ListNode{
            int key;
            int val;

            ListNode prev;
            ListNode next;
        }

        public LRUCache(int capacity) {
            this.maxCap = capacity;
            currCap = 0;

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            ListNode node = map.get(key);

            if(node == null){
                return -1;
            }
            moveToHead(node);

            return node.val;
        }

        public void put(int key, int value) {
            ListNode newNode = map.get(key);

            if(newNode ==null){
                ListNode node = new ListNode();
                node.key = key;
                node.val = value;

                map.put(key, node);
                addToFront(node);

                currCap++;

                if(currCap> maxCap){
                    removeLRUCache();
                }
            }else{
                newNode.val = value;
                moveToHead(newNode);
            }
        }

        public void moveToHead(ListNode node){
            removeFromList(node);
            addToFront(node);
        }

        public void addToFront(ListNode node){
            // Updating the new node's pointer first, so that we don't lose reference to ne node next to head
            node.next = head.next;
            node.prev = head;

            head.next.prev = node; // Updating prev pointer of node currently next to head
            head.next = node; // Updating head's next pointer
        }

        public void removeLRUCache(){
            ListNode prevToTail = tail.prev; // Getting the last node in the list
            removeFromList(prevToTail);
            
            map.remove(prevToTail.key);
            currCap--;
        }

        public void removeFromList(ListNode node) {
            ListNode prevSaved = node.prev; // Getting the prev node
            ListNode nextSaved = node.next; // Getting the next node
 
            // Setting their pointers towards each other, skippking the current node
            prevSaved.next = nextSaved;
            nextSaved.prev = prevSaved;
        }
}

