/*
    Problem: Leetcode. 895 Maximum Frequency Stack (Hard)
    Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
    Implement the FreqStack class:    
    FreqStack() constructs an empty frequency stack.
    void push(int val) pushes an integer val onto the top of the stack.
    int pop() removes and returns the most frequent element in the stack.
    If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.     
    
    Example 1: 
    
    Input
    ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
    [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
    
    Output
    [null, null, null, null, null, null, null, 5, 7, 5, 4]
    
    Explanation
    FreqStack freqStack = new FreqStack();
    freqStack.push(5); // The stack is [5]
    freqStack.push(7); // The stack is [5,7]
    freqStack.push(5); // The stack is [5,7,5]
    freqStack.push(7); // The stack is [5,7,5,7]
    freqStack.push(4); // The stack is [5,7,5,7,4]
    freqStack.push(5); // The stack is [5,7,5,7,4,5]
    freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
    freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
    freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
    freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].

    ----------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(1) ------------------------------------------------------
    --------------------------------------------------- Space Complexit: O(n) ------------------------------------------------------
*/

public class FreqStack {
    Map<Integer, Integer> freqMap; // <element, frequency>
    Map<Integer, Stack<Integer>> groupMap; // <frequency, elements(in the order they are closer to top)>
    int maxFreq;

    public FreqStack() {
        maxFreq =0;
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0)+1;
        freqMap.put(val, freq);

        if(freq > maxFreq)
        {
            maxFreq = freq;
        }

        groupMap.computeIfAbsent(freq, z-> new Stack()).push(val);        
    }
    
    public int pop() {
        int x = groupMap.get(maxFreq).pop(); // get the top element from the stack with max frequency

        int newFreq = freqMap.get(x)-1;
        freqMap.put(x, newFreq);

        if(groupMap.get(maxFreq).size() == 0)
        {
            maxFreq--;
        }

        return x;
    }
}


