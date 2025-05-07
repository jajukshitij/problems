/*
    Problem: Leetcode.271 Encode Decode Strings (Medium)
    Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
    
    Example 1:    
    Input: ["neet","code","love","you"]    
    Output:["neet","code","love","you"]
    ---------------------------------------------------------------------------------------------------------------------------------
*/
// --------------------------------------------------------- Time Complexity: O(m) ---------------------------------------------------
//                                                                          for both encode() and decode()
// --------------------------------------------------------- Space Complexity: O(m+n) -------------------------------------------------
//                                                                          m = sum of lengths of all the strings; 
//                                                                          n = number of strings
public class Solution {

    public String encode(List<String> strs) {
      StringBuilder res = new StringBuilder();
      
      for(String str: strs)
        {
          res.append(str.length()).append(",");
          res.append(str);
        }
      return res.toString();
    }

    public List<String> decode(String str) {
      List<String> result = new ArrayList<>();
      List<Integer> sizes = new ArrayList<>();
      int i =0;
      
      while(i < len)
        {
          int size = 0;

          while(str.charAt(i)!=',')
            {
              size = size*10 + Character.getNumericValue(str.charAt(i));
              i++;
            }
          
          i++;
          String word = str.substring(i, i+size);
          result.add(word);
          
          i = i+size;
        }

      return result;
    }
}











