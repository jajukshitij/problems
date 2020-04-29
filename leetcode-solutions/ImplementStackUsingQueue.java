/*
    Problem: Leetcode. 225 Implement Stack Using Queues
    Implement the following operations of a stack using queues.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.
    
    Example:
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);  
    stack.top();   // returns 2
    stack.pop();   // returns 2
    stack.empty(); // returns false
    
    Notes:
    You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
    Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
    You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------ Time Complexity: push O(1) ; pop O(n)--------------------------------------------------

*/

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    Queue<Integer> primaryQueue = new LinkedList<>();
    Queue<Integer> secondaryQueue = new LinkedList<>();
    int top;

    public void push(int x) {
        primaryQueue.add(x);
        top = x;
    }

    public int pop() {

        while(primaryQueue.size()>1){
            top = primaryQueue.remove();
            secondaryQueue.add(top);
        }

        int pop = primaryQueue.remove();

        Queue<Integer> temp = primaryQueue;
        primaryQueue = secondaryQueue;
        secondaryQueue = temp;

        return pop;
    }

    public int peek() {
        return top;
    }

    public boolean empty() {
        return primaryQueue.isEmpty();
    }
}
