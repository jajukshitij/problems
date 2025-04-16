/*
    Problem: Leetcode.295 Find Median from Data Stream (Hard)
    The median is the middle value in an ordered integer list. If the size of the list is even,
    there is no middle value, and the median is the mean of the two middle values.
    For example, for arr = [2,3,4], the median is 3.
    For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
    
    Implement the MedianFinder class:
    MedianFinder() initializes the MedianFinder object.
    void addNum(int num) adds the integer num from the data stream to the data structure.
    double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.    
    
    Example 1:    
    Input
    ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
    [[], [1], [2], [], [3], []]
    Output
    [null, null, null, 1.5, null, 2.0]
    
    Explanation
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);    // arr = [1]
    medianFinder.addNum(2);    // arr = [1, 2]
    medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
    medianFinder.addNum(3);    // arr[1, 2, 3]
    medianFinder.findMedian(); // return 2.0
    ----------------------------------------------------------------------------------------------------------------------------------

    ----------------------------------------------- Time Complexity: O(log(n)) -----------------------------------------------
                                                          O(3 ⋅ logn) ≈ O(logn) ;  (3 heap insertions)
    -------------------------------------------------- Space Complexity: O(n) ----------------------------------------------------
*/
public class MedianFromDataStream
  {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean even = true;
    
    public MedianFinder()
    {
      minHeap = new PriorityQueue<>();
      maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num)
    {
      if(even)
      {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
      }
      else
      {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
      }
      even = !even;        
    }
    
    public double findMedian()
    {
      if(even)
      {
        return (double) (minHeap.peek() + maxHeap.peek())/2;
      }
      else
      {
        return maxHeap.peek();
      }
    } 
  }
