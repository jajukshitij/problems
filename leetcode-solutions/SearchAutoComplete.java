/*
    Problem: Leetcode. Design Search Autocomplete System (Hard)
    Design a search autocomplete system for a search engine.
    Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#',
    you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
    Here are the specific rules:
    The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
    The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one).
    If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
    If less than 3 hot sentences exist, then just return as many as you can.
    When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
    Your job is to implement the following functions:
    The constructor function:
    AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data.
    Sentences is a string array consists of previously typed sentences.Times is the corresponding times a sentence has been typed.
    Your system should record these historical data.
    Now, the user wants to input a new sentence. The following function will provide the next character the user types:
    List input(char c): The input c is the next character typed by the user.
    The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#').
    Also, the previously typed sentence should be recorded in your system.
    The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
    
    Example:
    Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) 
    The system have already tracked down the following sentences and their corresponding times: 
    "i love you" : 5 times 
    "island" : 3 times 
    "ironman" : 2 times 
    "i love leetcode" : 2 times 
    Now, the user begins another search: 

    Operation: input('i') 
    Output: ["i love you", "island","i love leetcode"] 
    Explanation: 
    There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree.
    Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman".
    Also we only need to output top 3 hot sentences, so "ironman" will be ignored. 

    Operation: input(' ') 
    Output: ["i love you","i love leetcode"] 
    Explanation: 
    There are only two sentences that have prefix "i ". 

    Operation: input('a') 
    Output: [] 
    Explanation: 
    There are no sentences that have prefix "i a". 

    Operation: input('#') 
    Output: [] 
    Explanation: 
    The user finished the input, the sentence "i a" should be saved as a historical sentence in system.
    And the following input will be counted as a new search.
    
    Note: The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
    The number of complete sentences that to be searched won't exceed 100.
    The length of each sentence including those in the historical data won't exceed 100.
    Please use double-quote instead of single-quote when you write test cases even for a character input.
    Please remember to RESET your class variables declared in class AutocompleteSystem,
    as static/class variables are persisted across multiple test cases.
    Please see here for more details.
    ---------------------------------------------------------------------------------------------------------------------------------
    
*/

    /**
     * Your AutocompleteSystem object will be instantiated and called as such:
     * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
     * List<String> param_1 = obj.input(c);
     */

import java.util.*;

public class SearchAutocompleteSystem {

    public class Trie{
    
        Map<Character, Trie> map;
        List<String> list; // Suggestion list of sentences associated with each character

        public Trie(){
            map = new HashMap<>();
            list = new ArrayList<>();
        }
    }

    Trie root = new Trie();
    Map<String, Integer> countMap = new HashMap<>(); // Storing grequency of each sentence
    String query = "";

    public SearchAutocompleteSystem(String[] sentences, int[] times){

        for(int i=0; i<sentences.length; i++){
        
            countMap.put(sentences[i], times[i]);
            insertIntoTrie(sentences[i]);
        }
    }

    public List<String> input(char c){

        List<String> result = new ArrayList<>();

        if(c=='#'){

            if(!countMap.containsKey(query)){ // If it's a new sentence, add it to HashMap with frequency = 1
                countMap.put(query,1);
                insertIntoTrie(query);  // And instert the sentence into Trie
                
            }else{ // Increment the frequency of that sentence
                countMap.put(query, countMap.get(query)+1);
            }
            
            query = "";

        } else{ // Build sentence one char at a time and show the suggestions for current chars
        
            query += c; 
            result = getSuggestions();
        }
        
        return result;
    }


    public List<String> getSuggestions(){

        List<String> result = new ArrayList<>();
        List<String> suggestions = searchTrie(query); // Get Suggestions

        // Sort suggestion list based on highest frequency and 
        // Lexicographically if same frequency
        Collections.sort(suggestions, new Comparator<String>(){
        
            @Override
            public int compare(String a, String b){
            
                if(countMap.get(b) != countMap.get(a)){
                    return countMap.get(b)- countMap.get(a);
                }else{
                    return a.compareTo(b);
                }
            
            }
        });

        int count =1;
        
        // Adding top 3 suggestions to result
        while(count <= 3 && !suggestions.isEmpty()){
        
            result.add(suggestions.get(count));
            count++;
        }

        return result;
    }

    public void insertIntoTrie(String sentence){
    
        char[] arr = sentence.toCharArray();
        Trie curr = root;

        for(char c: arr){
        
            Trie node = curr.map.get(c);

            if(node == null){
            
                node = new Trie();
                curr.map.put(c, node);
            }

            curr.map.get(c).list.add(sentence); // Add Sentence with every character of that sentence 
                                                // For when, a user has typed part of the sentence, to return it as suggestion
            curr = node;
        }
    }

    public List<String> searchTrie(String string){
    
        Trie curr = root;
        char[] arr = string.toCharArray();

        for(char c: arr){
        
            Trie node = curr.map.get(c);

            if(node == null){
                return null;
            }
            
            curr = node;
        }
        return curr.list;
    }

}

