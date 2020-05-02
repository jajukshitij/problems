/*
    Problem: Leetcos.387 First Unique Character in String (Easy)
    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    Examples:
    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.
    ----------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------------------- Time Complexity: O(n) ---------------------------------------------------
    ------------------------------------------------------- Space Complexity: O(n) ---------------------------------------------------
*/

import java.util.HashMap;
import java.util.Map;

public class UniqueChar {

    public static int firstUniqueChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
        
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0; i<s.length(); i++){
        
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }

        return -1;
    }
}
