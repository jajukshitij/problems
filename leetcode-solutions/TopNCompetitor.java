/*
    Problem: Top N Competitors / Buzzword
    Given a list of reviews, a list of keywords and an integer k.
    Find the most popular k keywords in order of most to least frequently mentioned.
    The comparison of strings is case-insensitive.
    Multiple occurances of a keyword in a review should be considred as a single mention.
    If keywords are mentioned an equal number of times in reviews, sort alphabetically.

    Example 1:
    Input:
    k = 2
    keywords = ["anacell", "cetracular", "betacellular"]
    reviews = [
      "Anacell provides the best services in the city",
      "betacellular has awesome services",
      "Best services provided by anacell, everyone should use anacell",
    ]

    Output:
    ["anacell", "betacellular"]

    Explanation:
    "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
    ------------------------------------------------------------------------------------------------------------------------------------
    Pramp: Word Count Engine
    Implement a document scanning function wordCountEngine,which receives a string document and returns a list of all unique words in it
    and their number of occurrences, sorted by the number of occurrences in a descending order.If two or more words have the same count,
    they should be sorted according to their order in the original sentence. Assume that all letters are in english alphabet.
    You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.
    The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.
    Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.

    Examples:
    input:  document = "Practice makes perfect. you'll only
                        get Perfect by practice. just practice!"
    output: [ ["practice", "3"], ["perfect", "2"],
              ["makes", "1"], ["youll", "1"], ["only", "1"], 
              ["get", "1"], ["by", "1"], ["just", "1"] ]
    
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------- Time Complexity: O (N log (k)) ----------------------------------------------------
                                                                    N = numReviews ;  k = topNCompetitors (adding in heapsize)

    ----------------------------------------------- Space Complexity : O ( max (k ,n)) ------------------------------------------------
                                                                        k = topNCompetitors (size of hashmap, set etc.)
                                                                        n =  length of longest review in review (word array)
*/


import java.util.*;

public class TopNCompetitors {

    public static List<String> topNCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors,
                                               int numReviews, List<String> reviews){

        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(competitors); // HashSet for faster lookups of competitors

        Map<String, Integer> map = new HashMap<>();


        for(String r: reviews){
        
            String[] strs = r.split("\\W"); // creating an array or word for each review
            Set<String> added = new HashSet<>(); // to check we don't count the same competitor in same review more than once

            for(String s: strs){
            
                s =s.toLowerCase();
                if(set.contains(s) && !added.contains(s)){
                
                    map.put(s, map.getOrDefault(s,0)+1); // adding count of each competitor
                    added.add(s);
                }
            }
        }

        Queue<Map.Entry<String, Integer>> maxHeap =
                new PriorityQueue<>((a,b)->
                        a.getValue() == b.getValue()?       // if equal no. of time then add alphabetically
                                a.getKey().compareTo(b.getKey()):
                                b.getValue() - a.getValue()); // else add the one with greater count first

        maxHeap.addAll(map.entrySet()); // adding the hashmap
        // in the above defined order

        while(!maxHeap.isEmpty() && topNCompetitors-- >0){
            res.add(maxHeap.poll().getKey());
        }

        return res;
    }
    
    
    public static void main(String[] args){

        int topNCompetitors =2;
        List<String> competitors = new ArrayList<>();
        competitors.add("anacell");
        competitors.add("cetracular");
        competitors.add("betacellular");

        List<String> reviews = new ArrayList<>();
        reviews.add("Anacell provides the best services in the city");
        reviews.add("betacellular has awesome services");
        reviews.add("Best services provided by anacell, everyone should use anacell");

        int numCompetitors =3;
        int numReviews =3;

        System.out.println(topNCompetitors(numCompetitors,topNCompetitors,competitors,numReviews,reviews));

    }
    
    
    // -------------------------------------------- Pramp:  Word Count Engine --------------------------------------------------------
    
    static String[][] wordCountEngine(String document) {

    document = document.toLowerCase().replaceAll("[^a-zA-Z0-9_-]", " "); 
    String[] words = document.split("\\s+");
    
    Map<String, int[]> map = new HashMap<>();
    
    int index =1;
    
    for(String word: words){
      
      if(!map.containsKey(word)){
        map.put(word, new int[]{1,index++});
        
      }else{
        map.get(word)[0]++;
      }
      
    }
    
    String[][] result = new String[map.size()][2];
    
    PriorityQueue <Map.Entry<String, int[]>> pq = 
      new PriorityQueue<>( (a,b)-> a.getValue()[0] == b.getValue()[0] ? a.getValue()[1]-b.getValue()[1] : b.getValue()[0]- a.getValue()[0] );
    
    pq.addAll(map.entrySet());
    
    for(int i =0; i< result.length; i++){
      
      result[i][0] = pq.poll().getKey();
      result[i][1] = String.valueOf(map.get(result[i][0])[0]);
      
    }
    
    return result;

  }
  
  
}

