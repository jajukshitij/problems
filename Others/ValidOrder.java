public class ValidOrder {
  /*
  https://leetcode.com/discuss/interview-question/1583430/doordash-questions-consolidated
  https://leetcode.com/discuss/interview-question/846916/Validate-Orders-Path-(Doordash)
  
  Problem: Given a set list of pickups and deliveries for order, figure out if the given list is valid or not.
  A delivery cannot happen for an order before pickup.

  Examples:
  [P1, P2, D1, D2]==>valid
  [P1, D1, P2, D2]==>valid
  [P1, D2, D1, P2]==>invalid
  [P1, D2]==>invalid
  [P1, P2]==>invalid
  [P1, D1, D1]==>invalid
  []==>valid
  [P1, P1, D1]==>invalid
  [P1, P1, D1, D1]==>invalid
  [P1, D1, P1]==>invalid
  [P1, D1, P1, D1]==>invalid

  ------------------------ Time Complexity: O(n) ; n = size of orders-------------------------------------------
                                             from the loop; set operations are O(1)
  -------------------------- Space Complexity: O(n) ------------------------------------------------------------
                                              size of 2 HashSets
    
  Follow up 1: Find longest valid subarray
  Ex 1: orders = ['P1', 'P1', 'D1'], return ['P1', 'D1']
  Ex 2: orders = ['P1', 'P1', 'D1', 'D1'], return ['P1', 'D1']

  Follow up 2: Given an integer representing number of orders, print all possible valid order paths  
  */

  public boolean isValid(List<String> orders) {
    Set<Character> p_set = new HashSet<>();
    Set<Character> d_set = new HashSet<>();

    for (String order : orders) {
        char task_type = order.charAt(0);
        char task_num = order.charAt(1);

        if (task_type == 'P')
        {
            if (p_set.contains(task_num)) // Duplicate pickup
            {
              return false;
            }
            p_set.add(task_num);
        } 
        else if (task_type == 'D') 
        {
            if (d_set.contains(task_num) || !p_set.contains(task_num)) // Duplicate or No-pickup delivery
            {
              return false;
            }
            d_set.add(task_num);
        }
        else
        {
            return false; // Invalid input format
        }
    }
    return p_set.size() == d_set.size(); // All pickups matched with deliveries
  }

  // ----------------------------------- Follow up 1: Longest Valid Subarray--------------------------------------------
  
  public static List<String> findLongestValidSubarray(List<String> orders) {
        Set<Character> p_set = new HashSet<>();
        Set<Character> d_set = new HashSet<>();
        List<String> currentSubarray = new ArrayList<>();
        List<String> longestSubarray = new ArrayList<>();

        for (String order : orders) {
            char task_type = order.charAt(0);
            char task_num = order.charAt(1);

            if (task_type == 'P') {
                // Add pickup to current subarray
                if (p_set.contains(task_num)) {
                    // Duplicate pickup; reset tracking
                    resetTracking(p_set, d_set, currentSubarray);
                }
                p_set.add(task_num);
                currentSubarray.add(order);
            } else if (task_type == 'D') {
                // Check delivery validity
                if (d_set.contains(task_num) || !p_set.contains(task_num)) {
                    // Invalid delivery; reset tracking
                    resetTracking(p_set, d_set, currentSubarray);
                } else {
                    d_set.add(task_num);
                    currentSubarray.add(order);
                }
            } else {
                // Invalid input; reset tracking
                resetTracking(p_set, d_set, currentSubarray);
            }

            // Update longest valid subarray
            if (currentSubarray.size() > longestSubarray.size()) {
                longestSubarray = new ArrayList<>(currentSubarray);
            }
        }

        return longestSubarray;
    }

  private static void resetTracking(Set<Character> p_set, Set<Character> d_set, List<String> currentSubarray) {
        p_set.clear();
        d_set.clear();
        currentSubarray.clear();
    }

  //----------------------------------- Follow up 2: Generate Valid Orders--------------------------------------------

  public static List<String> generateValidOrders(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, 0, 0);
        return result;
    }

    private static void backtrack(List<String> result, List<String> current, int n, int pickupCount, int deliveryCount) {
        // Base case: If the sequence is complete, add it to the result
        if (current.size() == 2 * n) {
            result.add(String.join(",", current));
            return;
        }

        // Add a pickup if we haven't reached the max number of pickups
        if (pickupCount < n) {
            current.add("P" + (pickupCount + 1));
            backtrack(result, current, n, pickupCount + 1, deliveryCount);
            current.remove(current.size() - 1);
        }

        // Add a delivery if we have unmatched pickups
        if (deliveryCount < pickupCount) {
            current.add("D" + (deliveryCount + 1));
            backtrack(result, current, n, pickupCount, deliveryCount + 1);
            current.remove(current.size() - 1);
        }
    }
}
