public class MenuTree {
  /*
  https://leetcode.com/discuss/interview-question/1583430/doordash-questions-consolidated

  At DoorDash, menus are updated daily even hourly to keep them up-to-date. Each menu can be regarded as a tree.
  When the merchant sends us the latest menu, can we calculate how many nodes has changed?
  Assume each Node structure is as below:

  class Node {
      String key;
      int value;
      boolean active;
      List children;
  }
  Assume there are no duplicate nodes with the same key.
  Output: Return the number of changed nodes in the tree.

  Example 1:
  Existing Menu in our system:

  Existing tree
                             a(1, T)
                             /     \
                      b(2, T)     c(3, T)
                        / \              \
              d(4, T) e(5, T)        f(6, T)
  
  Legend: In "a(1, T)", a is the key, 1 is the value, T is True for active status 
  
  New Menu sent by the Merchant:
  
  New tree
                    a(1, T)
                       |
                    c(3, F)
                       |
                   f(66, T)
  
  Expected Answer: 5 Explanation: Node b, Node d, Node e are automatically set to inactive.
  The active status of Node c and the value of Node f changed as well.
  
  Example 2
  Existing Menu in our system:
  
   Existing tree
                            a(1, T)
                             /    \
                     b(2, T)      c(3, T)
                        / \           \
              d(4, T) e(5, T)     g(7, T)
  New Menu sent by the Merchant:
  
  New tree
                          a(1, T)
                        /          \
                  b(2, T)         c(3, T)
                 /  |    \              \
        d(4, T) e(5, T)  f(6, T)      g(7, F)
  Expected Answer: 2 Explanation: Node f is a newly-added node. Node g changed from Active to inactive

  ------------------------ Time Complexity: O(n+m) ; n = nodes in existing tree, m = nodes in new tree ------------------------
    ------------------------ Space Complexity: O(n+m) ; HashMaps for storing all nodes------------------------
*/

  public class Node {
    String key;
    int value;
    boolean active;
    List<Node> children;

    Node(String key, int value, boolean active) {
        this.key = key;
        this.value = value;
        this.active = active;
        this.children = new ArrayList<>();
    }
}

  public static int countChangedNodes(Node existing, Node latest) {
        Map<String, Node> existingMap = new HashMap<>();
        Map<String, Node> latestMap = new HashMap<>();
        
        // Flatten both trees into maps for easy comparison
        flattenTree(existing, existingMap);
        flattenTree(latest, latestMap);

        int changes = 0;

        // Compare nodes in the existing tree
        for (String key : existingMap.keySet()) {
            Node oldNode = existingMap.get(key);
            Node newNode = latestMap.get(key);

            if (newNode == null) {
                // Node is in the existing tree but not in the latest (removed or inactive)
                changes++;
            } else if (oldNode.value != newNode.value || oldNode.active != newNode.active) {
                // Node exists in both but has changes
                changes++;
            }
        }

        // Check for new nodes in the latest tree
        for (String key : latestMap.keySet()) {
            if (!existingMap.containsKey(key)) {
                // Node is in the latest tree but not in the existing (newly added)
                changes++;
            }
        }

        return changes;
    }

    // Helper function to flatten the tree into a map
    private static void flattenTree(Node root, Map<String, Node> map) {
        if (root == null) return;

        map.put(root.key, root);

        for (Node child : root.children) {
            flattenTree(child, map);
        }
    }

  // Helper function to flatten the tree into a map
    private static void flattenTree(Node root, Map<String, Node> map) {
      if(root == null)
      {
        return;
      }
      
      map.put(root.key, root.children);
      
      foreach(Node child: root.children)
        {
          flattenTree(child, map);
        }
    }

    public static void main(String[] args) {
        // Example 1
        Node existing1 = new Node("a", 1, true);
        Node b1 = new Node("b", 2, true);
        Node c1 = new Node("c", 3, true);
        Node d1 = new Node("d", 4, true);
        Node e1 = new Node("e", 5, true);
        Node f1 = new Node("f", 6, true);
        b1.children.add(d1);
        b1.children.add(e1);
        c1.children.add(f1);
        existing1.children.add(b1);
        existing1.children.add(c1);

        Node latest1 = new Node("a", 1, true);
        Node c2 = new Node("c", 3, false);
        Node f2 = new Node("f", 66, true);
        c2.children.add(f2);
        latest1.children.add(c2);

        System.out.println(countChangedNodes(existing1, latest1)); // Expected output: 5

        // Example 2
        Node existing2 = new Node("a", 1, true);
        Node b2 = new Node("b", 2, true);
        Node c3 = new Node("c", 3, true);
        Node d2 = new Node("d", 4, true);
        Node e2 = new Node("e", 5, true);
        Node g1 = new Node("g", 7, true);
        b2.children.add(d2);
        b2.children.add(e2);
        c3.children.add(g1);
        existing2.children.add(b2);
        existing2.children.add(c3);

        Node latest2 = new Node("a", 1, true);
        Node b3 = new Node("b", 2, true);
        Node c4 = new Node("c", 3, true);
        Node d3 = new Node("d", 4, true);
        Node e3 = new Node("e", 5, true);
        Node f3 = new Node("f", 6, true);
        Node g2 = new Node("g", 7, false);
        b3.children.add(d3);
        b3.children.add(e3);
        b3.children.add(f3);
        c4.children.add(g2);
        latest2.children.add(b3);
        latest2.children.add(c4);

        System.out.println(countChangedNodes(existing2, latest2)); // Expected output: 2
    }






















  

  
}
