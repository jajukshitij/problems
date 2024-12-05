public class EmployeeFreeTime {
  /*
  Problem: Leetcode 759 Employee Free Time (Hard)
  We are given a list of employees, where each employee has a list of non-overlapping intervals that represent their working hours.
  The intervals for each employee are sorted. Return a list of finite intervals representing free time for all employees,
  i.e., the time intervals where no one is working.
  
  Example:
  Input: schedule = [[[1, 2], [5, 6]], [[1, 3]], [[4, 10]]]
  Output: [[3, 4]]
  Explanation: There are total 3 employees, and all common free time would be [-inf, 1], [3,4], [10, inf].
  We discard intervals as they aren't finite.

  ------------------------ Time Complexity: O(n log n) ; n = each interval ------------------------
                                             O(n) to interate over all interval to add to priority queue.
                                             O(log n) for each PQ operation
    ------------------------ Space Complexity: O(n) ------------------------
                                               size of PQ.
  */
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    // Min-heap to sort intervals by their start time
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);

        // Add all intervals into the priority queue
        for (List<Interval> employeeSchedule : schedule) {
            for (Interval interval : employeeSchedule) {
                pq.offer(interval);
            }
        }

        // Merge intervals and find free time
        List<Interval> result = new ArrayList<>();
        Interval prev = pq.poll();

        while (!pq.isEmpty()) {
            Interval curr = pq.poll();

            if (prev.end < curr.start) {
                // Found a gap between intervals
                result.add(new Interval(prev.end, curr.start));
                prev = curr;
            } else {
                // Merge overlapping intervals
                prev = new Interval(prev.start, Math.max(prev.end, curr.end));
            }
        }

        return result;   
  }

  public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
