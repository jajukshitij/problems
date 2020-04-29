/*
    Problem: Leetcode.49 Group Anagrams (Medium)
    
    Given an array of strings, group anagrams together.

    Example:
    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    Note:
    All inputs will be in lowercase.
    The order of your output does not matter.
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------- Time Complexity: O(n* Klog(K)) ---------------------------------------------------- 
                                                            N = length of array, K = maximum length of a string in array
    The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(K log(K)) time

    ----------------------------------------------- Space Complexity O(nK)-------------------------------------------------------------

*/

import java.util.*;

public class GroupAnagram {
    public static void main(String args[]) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List list = groupAnagram(input);

        for(int i=0; i< list.size(); i++) {
                System.out.println(list.get(i));
        }
    }


    public static List<List<String>> groupAnagram (String[] strArray){
        if(strArray.length==0){
            return new ArrayList();
        }
        Map<String,List> map = new HashMap<>();

        for(String str:strArray){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key =String.valueOf(charArray);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
