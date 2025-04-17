/*
    Problem: Leetcode.1152 Analyze User Website Visit Pattern (Medium)
    You are given two string arrays username and website and an integer array timestamp. 
    All the given arrays are of the same length and the tuple [username[i], website[i], timestamp[i]] indicates that 
    the user username[i] visited the website website[i] at time timestamp[i].
    A pattern is a list of three websites (not necessarily distinct).
    For example, ["home", "away", "love"], ["leetcode", "love", "leetcode"], and ["luffy", "luffy", "luffy"] are all patterns.
    The score of a pattern is the number of users that visited all the websites in the pattern in the same order they appeared in the pattern.
    
    For example, if the pattern is ["home", "away", "love"], 
    the score is the number of users x such that x visited "home" then visited "away" and visited "love" after that.
    
    Similarly, if the pattern is ["leetcode", "love", "leetcode"], 
    the score is the number of users x such that x visited "leetcode" then visited "love" and visited "leetcode" one more time after that.
    
    Also, if the pattern is ["luffy", "luffy", "luffy"], 
    the score is the number of users x such that x visited "luffy" three different times at different timestamps.
    Return the pattern with the largest score. If there is more than one pattern with the same largest score, return the lexicographically smallest such pattern.
    
    Note that the websites in a pattern do not need to be visited contiguously, they only need to be visited in the order they appeared in the pattern.
    
    Example 1:
    Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], 
    timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
    Output: ["home","about","career"]
    Explanation: The tuples in this example are:
    ["joe","home",1],["joe","about",2],["joe","career",3],["james","home",4],["james","cart",5],["james","maps",6],["james","home",7],["mary","home",8],["mary","about",9], and ["mary","career",10].
    The pattern ("home", "about", "career") has score 2 (joe and mary).
    The pattern ("home", "cart", "maps") has score 1 (james).
    The pattern ("home", "cart", "home") has score 1 (james).
    The pattern ("home", "maps", "home") has score 1 (james).
    The pattern ("cart", "maps", "home") has score 1 (james).
    The pattern ("home", "home", "home") has score 0 (no user visited home 3 times).
    
    Example 2:
    Input: username = ["ua","ua","ua","ub","ub","ub"], timestamp = [1,2,3,4,5,6], website = ["a","b","a","a","b","c"]
    Output: ["a","b","a"]
*/
/*----------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------- Explanation -----------------------------------------------------------------------------
What they are asking -> take every possible combination of website ( 3 in number ) such that timestamp1 < timestamp2 < timestamp3 for each user.
and see that combinations occurs for other user. Return the combination which occurs maximum.

If we have a tie in this combination string then returns the combination which is smallest ( in terms of lexographical order )

Lets take an example they have given in the problem statement
username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"]
timestamp = [1,2,3,4,5,6,7,8,9,10]
website = ["home","about","career","home","cart","maps","home","home","about","career"]

So combinations of website for Joe will be [ home,about,career ]
Similarly combinations of James will be set:[[home,cart,maps], [home,maps,home], [home,cart,home]] ( :D 'BOND. JAMES BOND' )
For Mary : [home,about,career]

we have to find a which pattern occurs the max, here we can clearly see [home,about,career] occurs 2 times, so that is the output.
*/
public class UserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String,List<Info>> map = new HashMap();
        Map<String, Set<String> > userPattern = new HashMap();
        for( int i = 0 ; i < username.length;i++ )
        {
          map.computeIfAbsent( username[i], (key)-> new ArrayList()).add( new Info(timestamp[i], website[i] ) );
          Collections.sort( map.get( username[i] ), (n1,n2) -> n1.timeStamp - n2.timeStamp);
        } 
        //map: {joe=[<home 1>, <about 2>, <career 3>], james=[<home 4>, <cart 5>, <maps 6>, <home 7>], mary=[<home 8>, <about 9>, <career 10>]}
        for( String user : map.keySet() )
        {
            List<Info>  info = map.get( user );
            if( info.size() <3 ) continue;//skip the user who has visited less than 3 websites
			for( String pattern : generate(info) )
                userPattern.computeIfAbsent( pattern, (key) -> new HashSet() ).add( user ); 
        }
        // userPattern: {cart#maps#home=[james], home#cart#maps=[james], home#about#career=[joe, mary], home#maps#home=[james], home#cart#home=[james]}
        PriorityQueue< Pair<String, Integer> > pq = new PriorityQueue<>(( n1,n2) ->{
           if( n1.getValue() == n2.getValue()) 
               return n1.getKey().compareTo( n2.getKey());
        return n2.getValue()-n1.getValue();                                    
        });
        
        for( String pattern : userPattern.keySet() )
            pq.offer( new Pair<>( pattern,userPattern.get( pattern ).size() ) );
        
        Pair<String, Integer > pair = pq.poll();// return thr first index
               
    return Arrays.asList( pair.getKey().split("#") );
    }
       
    public Set<String> generate( List<Info> info )
    {
        Set<String> set = new HashSet();
        for( int i =0; i < info.size()-2; i++ )//generate all the three pair if Info is info: [<home 4>, <cart 5>, <maps 6>, <home 7>]
            for( int j =i+1; j < info.size()-1; j++ )
                for( int k=j+1; k < info.size(); k++)
                    set.add( info.get(i).website+"#" + info.get(j).website + "#" + info.get(k).website );
    return set;   //function returns set: [home#cart#maps, home#maps#home, home#cart#home]      
    }
}
//POJO Class
class Info{
    String website;
    int timeStamp;
    public Info( int t, String w ){
        website = w;
        timeStamp= t;
    }
    public String toString(){
        return "<" + website + " " + timeStamp+ ">";
    }
}
