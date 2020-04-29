/*
    Problem: Leetcode.706 Design HashMap (Easy)
    
    Design a HashMap without using any built-in hash table libraries.
    To be specific, your design should include these functions:
    put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
    get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
    --------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
   
    Logic if same as that behind the actual HashMap:
    Step 1. Computing hashcode of key,
    Step 2. Calculating array index/bucket from hashcode
    Step 3. With the help of index calculated, directly jump to that index/bucket.
    Step 4. Now, each and every element in the bucket is scanned sequentially to see, if there is any 
            key-value pair present, which has the same key we are trying to put.
    
    Bucket is a LinkedList, and HashMap is an array of LinkedLists
    Each element in a bucket is a ListNode, which is scanned sequentially. 
    
    https://leetcode.com/problems/design-hashmap/discuss/227081/Java-Solutions
    http://javabypatel.blogspot.com/2015/10/time-complexity-of-hashmap-get-and-put-operation.html
    -------------------------------------------------------------------------------------------------------------------------------
    
    
    --------- Worst case --------------
    ---------------------------------------------- Time Complexity: O(n) -----------------------------------------------------------
    ---------------------------------------------- Space Complexity: O(n) ----------------------------------------------------------

    --------- Average/ Best case --------
    ---------------------------------------------- Time Complexity: O(1) -----------------------------------------------------------
    ---------------------------------------------- Space Complexity: O(1) ----------------------------------------------------------
*/

public class DesignHashMap {

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */

    ListNode[] nodes = new ListNode[10000];

    public void put(int key, int value){
        int index = getIndex(key);
        ListNode prev = findElement(index, key);

        if(prev.next == null){
            prev.next = new ListNode(key, value);
        }else{
            prev.next.value = value;
        }

    }

    public int get(int key){
        int index = getIndex(key);
        ListNode prev = findElement(index, key);

        if(prev.next!= null){
            return prev.next.value;
        }

        return -1;
    }

    public void remove(int key){
        int index = getIndex(key);
        ListNode prev = findElement(index, key);

        if(prev.next!= null){
            prev.next = prev.next.next;
        }
    }

    public int getIndex(int key){
        return Integer.hashCode(key) % nodes.length;
    }

    public ListNode findElement(int index, int key){

        if(nodes[index]== null){
            nodes[index] = new ListNode(-1,-1);
            return nodes[index];
        }

        ListNode prev = nodes[index];

        while(prev.next != null && prev.next.key != key){
            prev = prev.next;
        }

        return prev;
    }

    public class ListNode{
        int key, value;
        ListNode next;

        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
