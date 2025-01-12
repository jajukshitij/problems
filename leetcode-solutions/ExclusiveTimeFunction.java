/*
    Problem: Leetcode. 636. Exclusive Time of Functions (Medium)
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
    
    Example:
    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
    -------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=h6FmiyYDjmk
    http://www.goodtecher.com/leetcode-17-letter-combinations-of-a-phone-number/
    -------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: O(N * L) = O(N) -----------------------------------------------
                                   N = Length of the input list of logs. L = Average length of each log. This can be considered as constant.
    ------------------------------------------------ Space Complexity: O(N/2) = O(N) -----------------------------------------------
*/
class ExclusiveTimeFunction {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (n == 0 || logs == null || logs.size() == 0) {
            return result;
        }

        // This stack will store the function ids
        Deque<Integer> stack = new ArrayDeque<>();
        // Previous time = start/resume time of the previous function
        int prevTime = 0;

        for (String log : logs) {
            String[] logParts = log.split(":");
            int curTime = Integer.parseInt(logParts[2]);

            if ("start".equals(logParts[1])) {
                // Function is starting now
                if (!stack.isEmpty()) {
                    // Add the exclusive time of previous function
                    result[stack.peek()] += curTime - prevTime;
                }
                stack.push(Integer.parseInt(logParts[0]));
                // Setting the start time for next log.
                prevTime = curTime;
            } else {
                // Function is ending now.
                // Make sure to +1 to as end takes the whole unit of time.
                result[stack.pop()] += curTime - prevTime + 1;
                // prevTime = resume time of the function. Thus adding 1.
                prevTime = curTime + 1;
            }
        }

        return result;
    }
}
