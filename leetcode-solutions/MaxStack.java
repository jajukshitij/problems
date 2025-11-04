/*
    Problem: Leetcode. 716. Max Stack (Hard)
    Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.

    Implement the MaxStack class:
    
    MaxStack() Initializes the stack object.
    void push(int x) Pushes element x onto the stack.
    int pop() Removes the element on top of the stack and returns it.
    int top() Gets the element on the top of the stack without removing it.
    int peekMax() Retrieves the maximum element in the stack without removing it.
    int popMax() Retrieves the maximum element in the stack and removes it.
    If there is more than one maximum element, only remove the top-most one.
    
    You must come up with a solution that supports O(1) for each top call and O(logn) for each other call.
    
    Example 1:
    Input
    ["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
    [[], [5], [1], [5], [], [], [], [], [], []]
    Output
    [null, null, null, null, 5, 5, 1, 5, 1, 5]
    
    Explanation
    MaxStack stk = new MaxStack();
    stk.push(5);   // [5] the top of the stack and the maximum number is 5.
    stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
    stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
    stk.top();     // return 5, [5, 1, 5] the stack did not change.
    stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
    stk.top();     // return 1, [5, 1] the stack did not change.
    stk.peekMax(); // return 5, [5, 1] the stack did not change.
    stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
    stk.top();     // return 5, [5] the stack did not change.
    ----------------------------------------------------------------------------------------------------------------------------------    
   
    ----------------------------------------------------- Time Complexity ------------------------------------------------------------

    push(x): O(log n) - Appending to doubly linked list is O(1), 
                        but adding to the SortedList requires O(log n) for binary search insertion
    pop(): O(log n) - Removing from the tail of the doubly linked list is O(1), 
                  but removing from the SortedList requires O(log n) as it needs to find and shift elements after removal
    top(): O(1) - Simply returns the value at the tail of the doubly linked list
    peekMax(): O(log n) - TreeMap.lastKey() fetches the maximum key using a balanced tree
    popMax(): O(log n) - Removing from the doubly linked list is O(1)
                    but Popping from the SortedList is O(log n) 
   
    ----------------------------------------------------- Space Complexity: O(n) -----------------------------------------------------
*/

public class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}

// Doubly linked list - Used as the underlying stack structure
class DoubleLinkedList {
    private final Node head;
    private final Node tail;

    public DoubleLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    // Append a new node to the end of the list (before tail)
    public Node append(int val) {
        Node node = new Node(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        return node;
    }

    public static Node remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public Node pop() {
        return remove(tail.prev);
    }

    public int peek() {
        return tail.prev.val;
    }
}

//  Uses a doubly linked list for stack operations 
// and a TreeMap for tracking maximum values
class MaxStack {
    private DoubleLinkedList stack;                    // Doubly linked list acting as stack
    private TreeMap<Integer, List<Node>> valueToNodes; // TreeMap mapping values to their nodes

    public MaxStack() {
        stack = new DoubleLinkedList();
        valueToNodes = new TreeMap<>();
    }

    public void push(int x) {
        Node node = stack.append(x);
        valueToNodes.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
    }

    public int pop() {
        Node node = stack.pop();
        // Remove node reference from TreeMap
        List<Node> nodes = valueToNodes.get(node.val);
        int value = nodes.remove(nodes.size() - 1).val;
        // Clean up empty list from TreeMap
        if (nodes.isEmpty()) {
            valueToNodes.remove(node.val);
        }
        return value;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        // TreeMap's lastKey() gives us the maximum value in O(log n)
        return valueToNodes.lastKey();
    }

    public int popMax() {
        // Get the maximum value
        int maxValue = peekMax();
        // Get list of nodes with this value
        List<Node> nodes = valueToNodes.get(maxValue);
        // Remove the most recent node with max value (last in the list)
        Node node = nodes.remove(nodes.size() - 1);
        // Clean up empty list from TreeMap
        if (nodes.isEmpty()) {
            valueToNodes.remove(maxValue);
        }
        // Remove the node from the doubly linked list
        DoubleLinkedList.remove(node);
        return maxValue;
    }
}
