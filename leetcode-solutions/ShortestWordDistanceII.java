/*
    Problem: Leetcode.244 Shortest Word Distance II (Medium)
    Design a data structure that will be initialized with a string array, 
    and then it should answer queries of the shortest distance between two different strings from the array.

    Implement the WordDistance class:    
    1. WordDistance(String[] wordsDict)
                              initializes the object with the strings array wordsDict.
    2. int shortest(String word1, String word2) 
                              returns the shortest distance between word1 and word2 in the array wordsDict.
     
    
    Example 1:    
    Input
    ["WordDistance", "shortest", "shortest"]
    [[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
    
    Output
    [null, 3, 1]
    
    Explanation
    WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
    wordDistance.shortest("coding", "practice"); // return 3
    wordDistance.shortest("makes", "coding");    // return 1
    -------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------- Time Complexity: -----------------------------------------------
                                                              Constructor: O(n)
                                                                           n = length of wordsDict
                                                              shortest: O(p + q)
                                                                      p = length of word1 indices list
                                                                        = number of time word1 apprears
                                                                      q = length of word2 indices list
                                                                        = number of time word2 apprears 

    ------------------------------------------------ Space Complexity: -----------------------------------------------
                                                             Constructor: O(n)
                                                                           n = length of wordsDict
                                                              shortest: O(1)
*/


public class ShortestWordDistanceII {
    // Map to store each word and its list of indices in the original array
    private Map<String, List<Integer>> wordIndicesMap = new HashMap<>();

    public ShortestWordDistanceII(String[] wordsDict) {
        for (int index = 0; index < wordsDict.length; index++) {
            wordIndicesMap.computeIfAbsent(wordsDict[index], key -> new ArrayList<>()).add(index);
        }
    }

    // Uses two-pointer technique since indices lists are sorted.
    public int shortest(String word1, String word2) {
        // Get the sorted lists of indices for both words
        List<Integer> indicesWord1 = wordIndicesMap.get(word1);
        List<Integer> indicesWord2 = wordIndicesMap.get(word2);

        int minDistance = Integer.MAX_VALUE;

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < indicesWord1.size() && pointer2 < indicesWord2.size()) {
            int currentDistance = Math.abs(indicesWord1.get(pointer1) - indicesWord2.get(pointer2));
            minDistance = Math.min(minDistance, currentDistance);

            // Move the pointer pointing to the smaller index
            // This ensures we check all possible pairs efficiently
            if (indicesWord1.get(pointer1) <= indicesWord2.get(pointer2)) {
                pointer1++;
            } else {
                pointer2++;
            }
        }

        return minDistance;
    }
}



