/*
    Problem: Leetcode.155 MinStack (Medium)
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

    Example 1:
    Input
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    Output
    [null,null,null,null,-3,null,0,-2]
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=WxCuL3jleUA
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(1) -----------------------------------------------------
    ----------------------------------------------------- Space Complexity: O(n) -----------------------------------------------------
*/

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min_val = new Stack<>();

    public MinStack(){

    }

    public void push(int x){
        if(min_val.isEmpty() || min_val.peek()>=x){
            min_val.push(x);
        }
        stack.push(x);
    }

    public int pop(){
        if(min_val.peek().equals(stack.peek())){
            min_val.pop();
        }
        return stack.pop();
    }

    public int peek(){
        return stack.peek();
    }

    public int getMin(){
        return min_val.peek();
    }
    
    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(0);
        obj.push(3);
        //obj.pop();
        System.out.println("Peek ::"+ obj.peek());
        System.out.println("Get Min ::"+obj.getMin());
    }
}
