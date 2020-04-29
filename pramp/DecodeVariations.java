/*
    Problem: Decode Variations
    A letter can be encoded to a number in the following way:
    'A' -> '1', 'B' -> '2', 'C' -> '3', ..., 'Z' -> '26'
    A message is a string of uppercase letters, and it is encoded first using this scheme. For example, 'AZB' -> '1262'
    Given a string of digits S from 0-9 representing an encoded message, return the number of ways to decode it.

    Examples:
    input:  S = '1262'
    output: 3
    explanation: There are 3 messages that encode to '1262': 'AZB', 'ABFB', and 'LFB'.
    ----------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------- Time Complexity : O(n)------------------------------------------
    ---------------------------------------------- Space Complexity : O(n)------------------------------------------
*/

public class DecodeWays {

    public static void main(String[] args){

        System.out.println(decodeWays("1262"));
    }

    public static int decodeWays(String s){
        if(s==null || s.length()==0 || s.charAt(0)=='0'){
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1] =1;

        for(int i=2; i<dp.length; i++){

            if(s.charAt(i-1) > '0'){
                dp[i] =dp[i-1];
            }
            if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6') ){
                dp[i]= dp[i]+ dp[i-2];
            }

        }

        return dp[s.length()];
    }
}
