/*
    Problem: 
    You have rating (0-10) of the hotels per user in this format:
    scores = [
        {'hotel_id': 1001, 'user_id': 501, 'score': 7},
        {'hotel_id': 1001, 'user_id': 502, 'score': 7},
        {'hotel_id': 1001, 'user_id': 503, 'score': 7},
        {'hotel_id': 2001, 'user_id': 504, 'score': 10},
        {'hotel_id': 3001, 'user_id': 505, 'score': 5},
        {'hotel_id': 2001, 'user_id': 506, 'score': 5}
    ]
    Any given hotel might have more than one score.

    Implement a function, get_hotels(scores, min_avg_score) that returns a list of hotel ids
    that have average score equal to or higher than min_avg_score.

    get_hotels(scores, 5) -> [1001, 2001, 3001]
    get_hotels(scores, 7) -> [1001, 2001]
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
    ----------------------------------------------------- Space Complexity: O(n) -----------------------------------------------------
    
    Possible Optimization: Using BST (RedBlack Tree) Time Complexity: O(log n + k)
    https://www.careercup.com/question?id=5651833474252800
    
        1. HashMap to reference the hotel_id to its BinarySearchTree node.
        2. BinarySearch Tree(RB Tree implementation) with average score as the key.

        add_hotel h
        - node* n = map.get(h.id)
        - tree.erase(n)
        - n.count++
        - n.score_sum += h.score
        - tree.insert(n)

        get_list(avg_score):
        - Binary Search to get to first node greater than equal to avg_score
        - Traverse through the remaining nodes in the right to get the list of ids
        - O(log n + k) [ k is the size of output]
    
*/

import java.util.*;

public class HotelAverageScore {

    public static class Hotel{
        String hotel_id;
        String user_id;
        int score;

        public Hotel(String hotel_id, String user_id, int score){
            this.hotel_id = hotel_id;
            this.user_id = user_id;
            this.score = score;
        }
    }

    public static List<String> getHotels(Hotel[] scores, int min_avg_score){

        List<String> result = new ArrayList<>();
        if(scores== null || scores.length==0){
            return result;
        }

        Map<String, int[]> map = new HashMap<>();

        for(Hotel score: scores){

            if(!map.containsKey(score.hotel_id)){
                map.put(score.hotel_id, new int[] {score.score, 1});
            }else{
                int[] count = map.get(score.hotel_id);
                count[0] += score.score;
                count[1]++;
                map.put(score.hotel_id, count);
            }
        }

        for(String hotel_id : map.keySet()){

            int[] count = map.get(hotel_id);
            double avg = count[0]/(double)count[1];

            if(avg>= min_avg_score){
                result.add(hotel_id);
            }
        }

        return result;
    }


    public static List<String> sortHotels(Hotel[] scores){

        List<String> result = new ArrayList<>();
        if(scores== null || scores.length==0){
            return result;
        }

        Map<String, int[]> map = new HashMap<>();

        for(Hotel score: scores){

            if(!map.containsKey(score.hotel_id)){
                map.put(score.hotel_id, new int[] {score.score, 1});
            }else{
                int[] count = map.get(score.hotel_id);
                count[0] += score.score;
                count[1]++;
                map.put(score.hotel_id, count);
            }
        }


        TreeSet<Map.Entry<String, int[]>> treeSet = new TreeSet<>(new Comparator<Map.Entry<String, int[]>>(){
            @Override
            public int compare(Map.Entry<String, int[]> a, Map.Entry<String, int[]> b){
                if(getAverage(b.getValue()) > getAverage(a.getValue())){
                    return 1;
                }else if(getAverage(b.getValue()) < getAverage(a.getValue())){
                    return -1;
                }
                return 0;
            }
        });

        treeSet.addAll(map.entrySet());

        while(!treeSet.isEmpty()){
            //result.add(priorityQueue.poll().getKey());
            result.add(treeSet.pollFirst().getKey());
        }

        return result;
    }


    public static double getAverage(int[] count){
        return count[0]/ (double) count[1];
    }
    
    public static void main(String[] args){
    
        Hotel[] scores = new Hotel[6];

        scores[0] = new Hotel("1001","501", 7);
        scores[1] = new Hotel("1001","502", 7);
        scores[2] = new Hotel("1001","503", 7);
        scores[3] = new Hotel("2001","504", 10);
        scores[4] = new Hotel("3001","505", 5);
        scores[5] = new Hotel("2001","506", 5);

        System.out.println("Above Min Average 5: " + getHotels(scores,5));
        System.out.println("Above Min Average 7: " + getHotels(scores,7));

        System.out.println("Sorted List: " + sortHotels(scores));

    }

}
