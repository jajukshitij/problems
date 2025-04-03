/*
    Problem: Leetcode. 767. Reorganize String (Medium)
    Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
    Return any possible rearrangement of s or return "" if not possible.    
    
    Example 1:    
    Input: s = "aab"
    Output: "aba"

    Example 2:    
    Input: s = "aaab"
    Output: ""
    ---------------------------------------------------------------------------------------------------------------------------------
*/

public class ReorganizeString
  {
    // -------------------------------------------------- Solution 1: Priority Queue + HashMap -----------------------------------------------
    // --------------------------------------------------- Time Complexity: O(n log k) -------------------------------------------------------
    // -------------------------------------------------- Space Complexity: O(k) -------------------------------------------------------------
    // --------------------------------------------------- n = total chars in the string; k = total unique characters ------------------------
    public String reorganizeString(String s)
    {
      Map<Character, Integer> map = new HashMap<>();
      
      for(char c: s.toCharArray())
        {
          map.put(c, map.getOrDefault(c,0)+1);
        }

      PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)-> map.get(b)- map.get(a));
      maxHeap.addAll(map.keySet());
      StringBuilder sb = new StringBuilder();

      while(maxHeap.size() >= 2)
        {
          char char1 = maxHeap.poll();
          char char2 = maxHeap.poll();

          sb.append(char1);
          sb.append(char2);

          map.put(char1, map.get(char1)-1);
          map.put(char2, map.get(char2)-1);

          if(map.get(char1) > 0)
          {
            maxHeap.add(char1);
          }
          if(map.get(char2) > 0)
          {
            maxHeap.add(char2);
          }          
        }

      if(!maxHeap.isEmpty())
      {
        char c = maxHeap.poll();

        if(map.get(c) > 1)
        {
          return "";
        }
        sb.append(c);
      }

      return sb.toString();
    }

    // -------------------------------------------------- Solution 1: Char Array Count/ Sort -----------------------------------------------
    // --------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------
    // -------------------------------------------------- Space Complexity: O(k) -------------------------------------------------------------
    public String reorganizeString(String s)
    {
      
    }
  }
