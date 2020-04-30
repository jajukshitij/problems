/*
    Problem: Find the longest continous repeating character in a String
    ---------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------- Time Complexity: O(n) -----------------------------------------------------
                                                                           n = length of string
    ----------------------------------------------------- Space Complexity: O(1) -----------------------------------------------------                                                       
*/

public class LongestRepeatingChar {

    public static AnswerPair maxChar(String str){
    
        char currChar;
        char maxChar = str.charAt(0);
        int currCount = 1;
        int maxCount = 1;

        for(int i =1 ;i <str.length(); i++){
        
            if(str.charAt(i-1) == str.charAt(i)){
                currCount++;
                currChar = str.charAt(i);

                if(currCount> maxCount){
                    maxCount = currCount;
                    maxChar = currChar;
                }
                
            }else{
                currCount = 1;
                currChar = str.charAt(i);
            }
        }

        AnswerPair answerPair = new AnswerPair();
        answerPair.maxChar = maxChar;
        answerPair.maxCount = maxCount;

        return answerPair;
    }
    
    private static class AnswerPair{
        char maxChar;
        int maxCount;

        public AnswerPair(){
          
        }
    }
    
    public static void main(String[] args){
        answerPair = maxChar("abcdeaab");
        System.out.println("char:: "+answerPair.maxChar +" count:: "+answerPair.maxCount);
    }
    
}
