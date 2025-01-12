/*
    Problem: leetcode.346 Moving Average Data Stream (Easy)
    Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
    
    Example:
    Input:
    ["MovingAverage","next","next","next","next"]
    [[3],[1],[10],[3],[5]]
    
    Output:
    [null, 1.0, 5.5, 4.66667, 6.0]

    Explanation:
    MovingAverage m = new MovingAverage(3);
    m.next(1) = 1 // return 1.00000
    m.next(10) = (1 + 10) / 2 // return 5.50000
    m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
    m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=E-kjYOZEBxY
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------- Time Complexity: O(1) ----------------------------------------------------
    ------------------------------------------------------- Space Complexity: O(n) ---------------------------------------------------
*/

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageDataStream {
    
    int maxSize;
    Queue<Integer> queue;
    double sum;

    public MovingAverageDataStream(int size){
    
        this.maxSize = size;
        queue = new LinkedList<>();
        sum = 0.0;
    }

    public double next(int val){
    
        queue.add(val);
        sum += val;
        
        if(queue.size()>maxSize){
            int remove =queue.poll();
            sum -=remove;
        }

        return sum/queue.size();
    }
}
