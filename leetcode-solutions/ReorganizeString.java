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

    // -------------------------------------------------- Solution 1: Char Array Count/ Sort -------------------------------------------------
    // --------------------------------------------------- Time Complexity: O(n) -------------------------------------------------------------
    // --------------------------------------------------- n = total chars in the string; k = total unique characters ------------------------
    // -------------------------------------------------- Space Complexity: O(k)  but 'len' will always be less than 26 so can say: O(1) ------
    public String reorganizeString(String s)
    {
      /*
      1. create a freq count arr of each char
      2. get maxCount and index of most freq charac
      3. check maxCount > len+1/2
      4. create ans char array
      4. put the maxchar in even indexes
      5. put the rest of the chars in rand position
      */

        int[] freqArr = new int[26];
        int len = s.length();

        for(char c: s.toCharArray())
            {
                freqArr[c-'a']++;
            }

        int maxCount =0, maxIdx =0;

        for(int i=0; i<freqArr.length; i++)
            {
                if(freqArr[i] > maxCount)
                {
                    maxCount = freqArr[i];
                    maxIdx = i;
                }
            }

        if(maxCount > (len+1)/2)
        {
            return "";
        }

        char[] res = new char[len];
        int index =0;

        while(freqArr[maxIdx] > 0)
            {
                res[index] = (char) (maxIdx +'a');
                index +=2;
                freqArr[maxIdx]--;
            }

        for(int i=0; i< freqArr.length; i++)
            {
                while(freqArr[i] > 0)
                    {
                        if(index >= len)
                        {
                            index = 1;
                        }
                        res[index] = (char) (i +'a');
                        index +=2;
                        freqArr[i]--;
                    }
            }

        return String.valueOf(res);
    }
  }
































