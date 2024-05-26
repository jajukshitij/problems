/*
Amazon Web Services (AWS) is a cloud computing platform with multiple servers. One of the servers is assigned to serve customer requests. 
There are n customer requests placed sequentially in a queue, where the ith request has a maximum waiting time denoted by wait[i]. 
That is, if the ith request is not served within wait[i] seconds, then the request expires and it is removed from the queue. 
The server processes the request following the First In First Out (FIFO) principle. 
The 1st request is processed first, and the nth request is served last. At each second, the first request in the queue is processed. 
At the next second, the processed request and any expired requests are removed from the queue. 
Given the maximum waiting time of each request denoted by the array wait, find the number of requests present in the queue at every second until it is empty. 
Note: If a request is served at some time instant t, it will be counted for that instant and is removed at the next instant. 
The first request is processed at time = 0. A request expires without being processed when time = wait[i]. 
It must be processed while time < wait[i]. See the example below for wait[3]. The initial queue represents all requests at time = 0 in the order they must be processed. 

Example The number of requests is n = 4, and their maximum wait times are wait = [2, 2, 3, 1]. time = 0 seconds, the 1st request is served. 
The number of requests in the queue is 4. queue = [1, 2, 3, 4]. 
time = 1 second, request 1 is removed because it is processed, request 4 (wait[3] = 1) is removed because time = wait[3] = 1 which exceeds its maximum waiting time.
Also, request 2 is served. The number of requests in the queue at time = 1 seconds is 2. queue = [2, 3].
time = 2 seconds, request 2 is removed because it is processed, request 3 is served. The number of requests in the queue is 1. queue = [3].
time = 3 seconds, request 3 is removed because it is processed. The number of requests in the queue is 0. queue = [empty]. The answer is [4, 2, 1, 0]. 
Function Description Complete the function findRequestsInQueue in the editor below. 
findRequestsInQueue has the following parameter: int wait[n]: the maximum waiting time of each request Returns int[]: the number of requests in the queue at each instant until the queue becomes empty. 
Constraints 1 ≤ n ≤ 105 1 ≤ wait[i] ≤ 105
*/

public class AmazonOARequestsQueue{

  public static void main(String[] args) {

        int[] wait = {2, 2, 3, 1};
        int[] result = findRequestsInQueue(wait);
        System.out.println("result1: " + Arrays.toString(result)); // Output: [4, 2, 1, 0]

        int[] wait2 = {1, 3, 2, 2, 5};
        int[] result2 = findRequestsInQueue(wait2);
        System.out.println("result2: " + Arrays.toString(result2)); // Output: [5, 4, 1, 0, 0]

        int[] wait3 = {4, 3, 2, 1};
        int[] result3 = findRequestsInQueue(wait3);
        System.out.println("result3: " + Arrays.toString(result3)); // Output: [4, 2, 0, 0]
    }

  public static int[] findRequestsInQueue(int[] wait) {

        int[] result = new int[wait.length];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> a-b);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < wait.length; i++) {
            queue.add((wait[i]));
            priorityQueue.add(wait[i]);
            result[i] = 0;
        }

        int currTime = 0;
        while(!queue.isEmpty() && currTime < wait.length)
        {
            result[currTime] = priorityQueue.size();

            // Remove Served Request
            int currReq = queue.poll();
            priorityQueue.remove(currReq);

            currTime++;

            // Remove Expired Requests
            while(!priorityQueue.isEmpty() && priorityQueue.peek() <= currTime)
            {
                int expReq = priorityQueue.poll();
                queue.remove(expReq);
            }
        }
        return result;
    }
}
