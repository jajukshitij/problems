/*
    Problem: LinkedIn Connection Distance
    Find the degree of connection between two users on LinkedIn, where users are represented as nodes in a graph,
    and connections (friendships) are edges. The goal is to determine the shortest path (or degree of separation) between two nodes.
    
    Given:
    A graph where each node represents a user, and an edge represents a connection between two users.
    Two users (source and target).
    Task:
    Find the shortest path (minimum degree of separation) between the source and target users. If no path exists, return -1.
    
    Example 1: 
    connections = [
        ("A", "B"), ("B", "C"), ("C", "D"), ("D", "E"),
        ("A", "F"), ("F", "G"), ("G", "H")
    ]
    source = "A"
    target = "E"
    Output: 3
    ----------------------------------------------------------------------------------------------------------------------------------    
    ------------------------------------------------------ Time Complexity: O(V + E) -----------------------------------------------------
                                                                            where V is the number of nodes and E is the number of edges
    ----------------------------------------------------- Space Complexity: O(V + E) -----------------------------------------------------

    Approach BFS: 
    Graph Representation:
      Create a bidirectional adjacency list to represent the graph; using HashMap <Node, List of all connections>
    
    Breadth-First Search (BFS):
      BFS is ideal for finding the shortest path in an unweighted graph.
      Start from the source node, explore all its neighbors, and continue level by level until the target is found.
    
    Edge Cases:
      If the source and target are the same, return 0.
      If either the source or target is not in the graph, return -1.
*/

public class ConnectionDistance {
    public static int connectionDistance(List<List<String>> connections, String source, String target) {
        // Build the graph as an adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> connection : connections) {
            String u = connection.get(0);
            String v = connection.get(1);
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Edge case: source and target are the same
        if (source.equals(target)) {
            return 0;
        }

        // BFS initialization
        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair(source, 0));
        visited.add(source);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String currentNode = current.node;
            int distance = current.distance;

            // Explore neighbors
            for (String neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                if (neighbor.equals(target)) {
                    return distance + 1;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new Pair(neighbor, distance + 1));
                }
            }
        }

        // If no path exists
        return -1;
    }

    // Helper class to store node and distance
    static class Pair {
        String node;
        int distance;

        Pair(String node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        List<List<String>> connections = Arrays.asList(
            Arrays.asList("A", "B"), Arrays.asList("B", "C"), Arrays.asList("C", "D"), Arrays.asList("D", "E"),
            Arrays.asList("A", "F"), Arrays.asList("F", "G"), Arrays.asList("G", "H")
        );
        String source = "A";
        String target = "E";
        System.out.println(connectionDistance(connections, source, target)); // Output: 3
    }
}
