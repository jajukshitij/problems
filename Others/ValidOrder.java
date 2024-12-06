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
  Follow up 2: Given an integer representing number of orders, print all possible valid order paths
  Ex 1: orders = ['P1', 'P1', 'D1'], return ['P1', 'D1']
  Ex 2: orders = ['P1', 'P1', 'D1', 'D1'], return ['P1', 'D1']

  
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
}
