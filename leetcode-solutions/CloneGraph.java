/*
    Problem: LeetCode. 133 Clone Graph (Medium)
    
    Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
    Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
    class Node {
        public int val;
        public List<Node> neighbors;
    }
    ---------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=vma9tCQUXk8
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------ Time Complexity: O(V + E) -----------------------------------------------------------
    BFS
*/

import java.util.*;

public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node root){

        if(root==null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Node,Node> map = new HashMap<>(); // Map <Old node, New Node>

        queue.add(root);
        map.put(root, new Node(root.val, new ArrayList<>()));

        while(!queue.isEmpty()){
            Node currNode = queue.remove();

            for(Node n : currNode.neighbors){

                if(!map.containsKey(n)){ // creating copy of the neighbour of root if it doesn't exist

                    map.put(n, new Node(n.val, new ArrayList<>()));
                    queue.add(n);
                }

                map.get(currNode).neighbors.add(map.get(n)); // adding the copy of neighbour to the copy of root
            }
        }
        return map.get(root);
    }
}

