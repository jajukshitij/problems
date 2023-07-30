/*
Leetcode 830. Positions of Large Groups (Easy)
In a string s of lowercase letters, these letters form consecutive groups of the same character.
For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].
A group is considered large if it has 3 or more characters.
Return the intervals of every large group sorted in increasing order by start index.

Example 1:
Input: s = "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the only large group with start index 3 and end index 6.

Example 2:
Input: s = "abc"
Output: []
Explanation: We have groups "a", "b", and "c", none of which are large groups.

*/

public class PositionOfLargeGroups {
  
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start =0;
        int len = s.length();

        while(start < len)
        {
            int end = start;

            while(end< len && s.charAt(start) == s.charAt(end))
            {
                end++;
            }

            if(end-start >=3)
            {
                List<Integer> large = new ArrayList<>();
                large.add(start);
                large.add(end-1);

                result.add(large);
            }

            start = end;
        }

        return result;
    }
}
