/*
    Problem: Leetcode. 432. All O`one Data Structure (Hard)
    Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.
    
    Implement the AllOne class:
    
    1. AllOne() = Initializes the object of the data structure.
    2. inc(String key) = Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
    3. dec(String key) = Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure.
       It is guaranteed that key exists in the data structure before the decrement.
    4. getMaxKey() = Returns one of the keys with the maximal count. If no element exists, return an empty string "".
    5. getMinKey() = Returns one of the keys with the minimum count. If no element exists, return an empty string "".
    
    Note that each function must run in O(1) average time complexity.
    
    Example 1:
    Input
    ["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
    [[], ["hello"], ["hello"], [], [], ["leet"], [], []]
    Output
    [null, null, null, "hello", "hello", null, "hello", "leet"]
    
    Explanation
    AllOne allOne = new AllOne();
    allOne.inc("hello");
    allOne.inc("hello");
    allOne.getMaxKey(); // return "hello"
    allOne.getMinKey(); // return "hello"
    allOne.inc("leet");
    allOne.getMaxKey(); // return "hello"
    allOne.getMinKey(); // return "leet"
    ----------------------------------------------------------------------------------------------------------------------------------    
    ------------------------------------------------------ Time Complexity: O(1) -----------------------------------------------------
    ----------------------------------------------------- Space Complexity: O(n) -----------------------------------------------------

    1. Double LinkedList Structure; 
    2. Each node is for a particular frequency;
    3. The LinkedList is soreted from lowest to highest frequency Nodes.
    4. Each node store all the string of that frequency.
    5. HashMap<String, Node>; To retirve the node where that string is stored in O(1) time.
*/

public class Node
{
    Node prev;
    Node next;
    Set<String> keys;
    int freq;

    public Node(int freq)
    {
        this.keys = new HashSet<>();
        this.freq = freq;
    }
}

public class AllOne {
    Node head;
    Node tail;
    Map<String, Node> map;

    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public void inc(String key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            int freq = node.freq;
            node.keys.remove(key);

            Node nextNode = node.next;

            if(nextNode == tail || nextNode.freq != freq+1) // Node with (freq+1) doesn't exists
            {
                Node newNode = new Node(freq+1);
                newNode.keys.add(key);

                newNode.prev = node;
                newNode.next = nextNode;
                node.next = newNode;                
                nextNode.prev = newNode;

                map.put(key, newNode);
            }
            else // nexNode with desired(freq+1) frequency exists
            {
                nextNode.keys.add(key);
                map.put(key, nextNode);
            }

            if(node.keys.isEmpty()) // Delete original node?
            {
                removeNode(node);
            }
        }
        else // New String key; Currently not present in our DB
        {
            // Add as 1st Node, freq = 1
            Node firstNode = head.next;

            if(firstNode == tail || firstNode.freq > 1) // Node with freq = 1 doesn't exists
            {
                Node newNode = new Node(1);
                newNode.keys.add(key);

                newNode.prev = head;
                newNode.next = firstNode;
                head.next = newNode;
                firstNode.prev = newNode;

                map.put(key, newNode);
            }
            else // Node with freq = 1 already exists
            {
                firstNode.keys.add(key);
                map.put(key, firstNode);
            }
        }
    }
    
    public void dec(String key) {
        if(!map.containsKey(key))
        {
            return;
        }

        Node node = map.get(key);
        node.keys.remove(key);
        int freq = node.freq;

        if(freq == 1)
        {
            map.remove(key);
        }
        else
        {
            Node prevNode = node.prev;

            if(prevNode == head || prevNode.freq != freq-1) // Node with (freq-1) doesn't exists
            {
                Node newNode = new Node(freq-1);
                newNode.keys.add(key);

                newNode.prev = prevNode;
                newNode.next = node;
                prevNode.next = newNode;
                node.prev = newNode;

                map.put(key, newNode);
            }
            else // Node with (freq-1) already exists
            {
                prevNode.keys.add(key);
                map.put(key, prevNode);
            } 
        }

        if(node.keys.isEmpty()) // Delete original node?
        {
            removeNode(node);
        }
    }
    
    public String getMaxKey() {
        if(tail.prev == head)
        {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if(head.next == tail)
        {
            return "";
        }
        return head.next.keys.iterator().next();
    }

    public void removeNode(Node node)
    {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}



