/*
    Problem: Leetcode. 408 Valid Word Abbreviation (Medium)
    A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.
    For example, a string such as "substitution" could be abbreviated as (but not limited to):
    "s10n" ("s ubstitutio n")
    "sub4u4" ("sub stit u tion")
    "12" ("substitution")
    "su3i1u2on" ("su bst i t u ti on")
    "substitution" (no substrings replaced)
    
    The following are not valid abbreviations:
    "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
    "s010n" (has leading zeros)
    "s0ubstitution" (replaces an empty substring)
    
    Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.
    A substring is a contiguous non-empty sequence of characters within a string.

    Example 1:
    Input: word = "internationalization", abbr = "i12iz4n"
    Output: true
    Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").
    
    Example 2:
    Input: word = "apple", abbr = "a2e"
    Output: false
    Explanation: The word "apple" cannot be abbreviated as "a2e".
    -------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------Time Complexity: O(m+n) ------------------------------------------------------
                                                            m = length of word ; n = length of abbr

    ---------------------------------------Space Complexity: O(1) ------------------------------------------------------
*/

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
      int i = 0;
      int j = 0;
      int n = word.length();
      int m = abbr.length();

      while(i<n && j<m)
        {
          char c = abbr.charAt(j);
          if(Character.isLetter(c))
          {
            if(c != word.charAt(i))
            {
              return false;
            }
            i++;
            j++;
          }
          else if(Character.isDigit(c))
          {
            if(c=='0')
            {
              return false;
            }
            int num = 0;
            while(j < abbr.length() && Character.isDigit(abbr.charAt(j)))
              {
                num = num*10 + (abbr.charAt(j)-'0');
                j++;
              }
            i =i+num;
          }
          else
          {
            return false;
          }
        }

      return i==n && j==m;      
    }
}



