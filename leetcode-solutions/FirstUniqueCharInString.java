/*
    Problem: Leetcode.387 First Unique Character in a String (Easy)
    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1. 

    Example 1:
    Input: s = "leetcode"
    Output: 0
    Explanation:
    The character 'l' at index 0 is the first character that does not occur at any other index.
    
    Example 2:
    Input: s = "loveleetcode"
    Output: 2    
    ----------------------------------------------- Time Complexity: O(n) -----------------------------------------------
    -------------------------------------------------- Space Complexity: O(n) ----------------------------------------------------
*/

public class FirstUniqueCharInString
  {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] charArray = s.toCharArray();

        for(Character c: charArray)
        {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(int i=0; i< charArray.length; i++)
        {
            if(map.get(charArray[i])==1)
            {
                return i;
            }
        }

        return -1;
    }
  }
