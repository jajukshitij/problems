/*
    Problem: Leetcode. 986. Interval List Intersections (Medium)
    You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
    Each list of intervals is pairwise disjoint and in sorted order. Return the intersection of these two interval lists.    
    A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.    
    The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
        
    Example 1:
    Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
    Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
    
    Example 2:    
    Input: firstList = [[1,3],[5,9]], secondList = []
    Output: []
    -------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------Time Complexity: O(n+m) ------------------------------------------------------

    ---------------------------------------Space Complexity: O(1) ------------------------------------------------------
*/


public class IntervalList {
// ------------------------------------------- Interval List INTERSECTION -----------------------------------------------------
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
      int i =0, j =0;
      List<int[]> result = new ArrayList<>();

      while (i <firstList.length && j < secondList.length)
        {
          if(overlap(firstList[i], secondList[j]))
          {
            int[] intersection = intersect(firstList[i],secondList[j]);
            result.add(intersection);
          }

          if(firstList[i][1] < secondList[j][1])
          {
            i++;
          }
          else
          {
            j++;
          }
        }
      
      return result.toArray(new int[result.size()][]);
    }

  private boolean overlap(int[] A, int[] B) //[0,2],[1,5]
  {
    if(A[1] < B[0] || B[1] < A[0])
    {
      return false;
    }
    return true;
  }

  private int[] intersect(int[] A, int[] B)
  {
    int[] res = new int[2];
    
    res[0] = Math.max(A[0], B[0]);
    res[1] = Math.min(A[1], B[1]);
    
    return res;
  }
// ------------------------------------------- Interval List UNION -----------------------------------------------------
    public int[][] intervalUnion(int[][] A, int[][] B) {
      List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        int[] current = null;

        // Iterate through both lists using two pointers
        while (i < A.length && j < B.length) {
            int[] intervalA = A[i];
            int[] intervalB = B[j];

            // Choose the smaller starting interval to process
            if (intervalA[0] < intervalB[0]) {
                current = mergeOrAdd(result, current, intervalA);
                i++;
            } else {
                current = mergeOrAdd(result, current, intervalB);
                j++;
            }
        }

        // Process remaining intervals in A
        while (i < A.length) {
            current = mergeOrAdd(result, current, A[i]);
            i++;
        }

        // Process remaining intervals in B
        while (j < B.length) {
            current = mergeOrAdd(result, current, B[j]);
            j++;
        }

        // Add the last interval if needed
        if (current != null) {
            result.add(current);
        }

        return result.toArray(new int[result.size()][]);
    }

    private int[] mergeOrAdd(List<int[]> result, int[] current, int[] interval) {
        if (current == null) {
            return interval; // Initialize the first interval
        }

        if (interval[0] <= current[1]) {
            // Merge intervals if they overlap
            current[1] = Math.max(current[1], interval[1]);
        } else {
            // No overlap; add the current interval to the result
            result.add(current);
            current = interval;
        }

        return current;
    }
}
