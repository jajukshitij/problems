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

            List<Integer> neighbours = map.getOrDefault( pre, new ArrayList<>() );
            indegree[dep]++; // If a graph is drawn it would look like: pre -> dep
                             // indegree value = number of prerequisites need for that course
            neighbours.add(dep);

            map.put(pre, neighbours);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count =0;
        
        // Starting BFS with course with no prerequisite
        for(int i=0; i<numCourses; i++){
            
            if(indegree[i]==0){
                queue.add(i); 
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll(); // Removing from queue implies we have taken this course 
                                     // and can reduce the indegree for dependant courses

            if(indegree[curr]==0){
                count++;
            }

            if(map.containsKey(curr)) {
                for (int nei : map.get(curr)) {
                    indegree[nei]--; // reducing the prerequesite count for resp. dependant courses

                    if (indegree[nei] == 0) { // Course ready to take
                        queue.add(nei);
                    }
                }

            }
        }

        return (count==numCourses);
    }
}
