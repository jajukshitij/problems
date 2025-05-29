/*
    Problem: Leetcode.207 Course Schedule (Medium)
    
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

    Example 1:
    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take. 
                 To take course 1 you should have finished course 0. So it is possible.
    -----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=rG2-_lgcZzo

    https://leetcode.com/problems/course-schedule/discuss/58516/Easy-BFS-Topological-sort-Java
    https://github.com/Nideesh1/Algo/blob/master/leetcode/L_207.java
    ------------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------- Time Complexity: O(V+E) ----------------------------------------------------
    where V represents the number of vertices and E represents the number of edges.
    We pop each node exactly once from the zero in-degree queue and that gives us V.
    Also, for each vertex, we iterate over its adjacency list and in totality, we iterate over all the edges in the graph which gives us E. Hence, O(V+E)

    ------------------------------------------------------- Space Complexity: O(V+E) ----------------------------------------------------
    The in-degree array requires O(V) space. We use an intermediate queue data structure to keep all the nodes with 0 in-degree. 
    In the worst case, there won't be any prerequisite relationship and the queue will contain all the vertices initially since all of them will have 0 in-degree.
    That gives us O(V). Additionally, we also use the adjacency list to represent our graph initially.
    The space occupied is defined by the number of edges because for each node as the key, we have all its adjacent nodes in the form of a list as the value.
    Hence, O(E). So, the overall space complexity is O(V+E)
    
    BFS / Topological Sort
*/

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites){

        int[] indegree = new int[numCourses]; // index = course number , indegree[index] = indegree for that course
        Map<Integer, List<Integer>> map = new HashMap<>(); // Map <Prerequisite, Dependant courses>

        for(int[] prereq : prerequisites){
            int pre = prereq[1]; // Prerequisite
            int dep = prereq[0]; // Dependant
            
            indegree[dep]++; // If a graph is drawn it would look like: pre -> dep
                             // indegree value = number of prerequisites need for that course    
            
            if(!map.containsKey(pre))
            {
                map.put(pre, new ArrayList<Integer>());
            }

            map.get(pre).add(dep); // Adding all the dependant course to its prerequisite          
        }

        Queue<Integer> queue = new LinkedList<>();        
        
        // Starting BFS with course with no prerequisite
        for(int i=0; i<numCourses; i++){
            
            if(indegree[i]==0){
                queue.offer(i); 
            }
        }

        int count =0;

        while(!queue.isEmpty()){
            count++;
            int curr = queue.poll(); // Removing from queue implies we have taken this course 
                                     // and can reduce the indegree for dependant courses

            List<Integer> deps = map.get(curr);

            if(deps != null) {
                for (int dep : deps) {
                    indegree[dep]--; // reducing the prerequesite count for resp. dependant courses

                    if (indegree[dep] == 0) { // Course ready to take
                        queue.offer(dep);
                    }
                }

            }
        }

        return (count==numCourses);
    }

//  --------------------------------------------------------------  Course Schedule 2 ----------------------------------------------------------
    /*
    Problem: Leetcode. 210 Course Schedule 2 (Medium)
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
    You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. 
    If it is impossible to finish all courses, return an empty array.  
    
    Example 1:    
    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: [0,1]
    Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
    
    Example 2:    
    Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
    Output: [0,2,1,3]
    Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
    Both courses 1 and 2 should be taken after you finished course 0.
    So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses]; // index = course number , indegree[index] = indegree for that course
        Map<Integer, List<Integer>> map = new HashMap<>(); // Map <Prerequisite, Dependant courses>

        for(int[] prereq: prerequisites)
        {
            int pre = prereq[1]; // Prerequisite
            int dep = prereq[0]; // Dependant

            indegree[dep]++;
            
            if(!map.containsKey(pre))
            {
                map.put(pre, new ArrayList<Integer>());
            }

            map.get(pre).add(dep);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i<numCourses; i++)
        {
            if(indegree[i]==0)
            {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            res[index++] = curr;

            List<Integer> deps = map.get(curr);

            if(deps != null)
            {
                for(int dep: deps)
                {
                    indegree[dep]--;

                    if(indegree[dep]==0)
                    {
                        queue.offer(dep);
                    }
                }
            }
        }

        if(index == numCourses)
        {
            return res;
        }
        else
        {
            return new int[0];
        }
    }
}
