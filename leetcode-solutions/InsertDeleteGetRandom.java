/*
    Problem: Leetcode. 380. Insert Delete GetRandom O(1) (Medium)
    
    Implement the RandomizedSet class:
    . RandomizedSet() Initializes the RandomizedSet object.
    . bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
    . bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
    . int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called).
      Each element must have the same probability of being returned.
    You must implement the functions of the class such that each function works in average O(1) time complexity.

    Example 1:    
    Input
    ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
    [[], [1], [2], [2], [], [1], [2], []]

    Output
    [null, true, false, true, 2, true, false, 2]
    ------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------- Time Complexity: O(1) -----------------------------------------------------
    --------------------------------------------------- Space Complexity: O(n) ----------------------------------------------------
*/
public class RandomizedSet {
  private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
        {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
        {
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size()-1);

        list.set(index, lastElement);
        map.put(lastElement, index);

        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
