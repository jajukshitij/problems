/*
    Problem: 
    You are given an undirected connected graph. An articulation point (or cut vertex) is defined as a vertex which, when removed along with associated edges, makes the graph disconnected (or more precisely, increases the number of connected components in the graph). The task is to find all articulation points in the given graph.

    Input:
    The input to the function/method consists of three arguments:
    numNodes, an integer representing the number of nodes in the graph.
    numEdges, an integer representing the number of edges in the graph.
    edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
    Output:
    Return a list of integers representing the critical nodes.

    Example:
    Input: numNodes = 7, numEdges = 7, edges = [[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]
    Output: [2, 3, 5]
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    
    https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
    https://leetcode.com/discuss/interview-question/436073/
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(V + E) -----------------------------------------------------
*/

import java.util.*;

public class CriticalRouters {

    static int time = 0;

    public static List<Integer> criticalRouters(int numRouters, int numLinks, List<List<Integer>> links){
        time = 0;

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=0; i<numRouters ; i++){
            map.put(i, new HashSet<>());
        }

        for(List<Integer> link: links){
            map.get(link.get(0)).add(link.get(1));
            map.get(link.get(1)).add(link.get(0));
        }

        Set<Integer> set = new HashSet<>();
        int[] low = new int[numRouters];
        int[] ids = new int[numRouters];
        int[] parent = new int[numRouters];

        Arrays.fill(ids,-1);
        Arrays.fill(parent,-1);

        for(int i=0; i<numRouters; i++){
            if(ids[i]==-1){
                dfs(map,low,ids,parent,i,set); //find critical points in DFS tree rooted with vertex 'i'
            }
        }
        
        return new ArrayList<>(set);
    }

    /*1) u is root of DFS tree and it has at least two children.
      2) u is not root of DFS tree and it has a child v such that
      no vertex in subtree rooted with v has a back edge to one of the ancestors of u*/

    public static void dfs(Map<Integer, Set<Integer>> map, int[] low, int[] ids, int[] parent, int cur, Set<Integer> res){

        int children =0;
        ids[cur] = low[cur] = ++time;

        for(int nei : map.get(cur)){

            if(ids[nei]== -1){
                children++;
                parent[nei] = cur;
                dfs(map,low,ids,parent,nei,res);

                low[cur] = Math.min(low[cur], low[nei]); // Check if the subtree rooted with curr has a connection
                                                         // to one of the ancestors of nei

                if((parent[cur]==-1 && children > 1) || (parent[cur]!=-1 && low[nei]>=ids[cur])){
                    res.add(cur);
                }
                // (1) curr is root of DFS tree and has two or more children
                // (2) If curr is not root and low value of one of its child
                // is more than discovery value of curr

            } else if(nei!=parent[cur]){
                low[cur] = Math.min(low[cur], low[nei]); // Update low value of curr for parent function calls
            }
        }
    }
    
        public static void main(String[] args){
        int numRouters = 7;
        int numLinks = 7;
        List<List<Integer>> links = new ArrayList<>();
        List<Integer> curr1 = new ArrayList<>();
        curr1.add(0);
        curr1.add(1);
        links.add(curr1);
        List<Integer> curr2 = new ArrayList<>();
        curr2.add(0);
        curr2.add(2);
        links.add(curr2);
        List<Integer> curr3 = new ArrayList<>();
        curr3.add(1);
        curr3.add(3);
        links.add(curr3);
        List<Integer> curr4 = new ArrayList<>();
        curr4.add(2);
        curr4.add(3);
        links.add(curr4);
        List<Integer> curr5 = new ArrayList<>();
        curr5.add(2);
        curr5.add(5);
        links.add(curr5);
        List<Integer> curr6 = new ArrayList<>();
        curr6.add(5);
        curr6.add(6);
        links.add(curr6);
        List<Integer> curr7 = new ArrayList<>();
        curr7.add(3);
        curr7.add(4);
        links.add(curr7);
        //{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
        System.out.println(criticalRouters(numRouters, numLinks, links));
    }
}
