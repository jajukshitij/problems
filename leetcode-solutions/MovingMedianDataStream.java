/*
    Problem: Leetcode.295 Find Median Data Stream (Hard)
    Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
    So the median is the mean of the two middle value.

    For example,
    [2,3,4], the median is 3
    [2,3], the median is (2 + 3) / 2 = 2.5
    Design a data structure that supports the following two operations:
    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

    Example:
    addNum(1)
    addNum(2)
    findMedian() -> 1.5
    addNum(3) 
    findMedian() -> 2
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/
    ---------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O( log(N) ) -------------------------------------------------
                                                                         O(log (N)) to addNum ; O(1) to find median
    ----------------------------------------------------- Space Complexity: O(N) -----------------------------------------------------
*/

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MovingMedianDataStream {

    PriorityQueue<Integer> minHeap = null; // upper half , ascending
    PriorityQueue<Integer> maxHeap =  null; // lower half , descending

    public MovingMedianDataStream(){
        minHeap = new PriorityQueue<>();

        //maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });

    }

    public void addNum(int num){
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll()); // assure all elements in maxHeap are smaller than minHeap

        if(minHeap.size() < maxHeap.size()){ // load balancing
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian(){
    
        if(minHeap.size()> maxHeap.size()){
            return minHeap.peek();
        }else{
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
    }
}
