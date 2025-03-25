/*
    Problem: Leetcode. 347. Top K Frequent Elements (Medium)
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

    Example 1:    
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
    
    Example 2:    
    Input: nums = [1], k = 1
    Output: [1]
    -------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: O(N log(k)) -------------------------------------------
    ---------------------------------------------------- Space Complexity: O(n+k) ----------------------------------------------
*/

public class KFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int num: nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for(int n: map.keySet())
        {
            pq.add(n);

            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        int[] result = new int[k];
        int index=k-1;

        while(index>=0 && !pq.isEmpty())
        {
            result[index]=pq.poll();
            index--;
        }

        return result;
    }
}




