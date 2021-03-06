/*
    Problem: Leetcode.246 Strobogrammatic Number I (Easy)
    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
    Write a function to determine if a number is strobogrammatic. The number is represented as a string.
    For example, the numbers "69", "88", and "818" are all strobogrammatic.
    ----------------------------------------------------------------------------------------------------------------------------------
    
*/

import java.util.HashMap;
import java.util.Map;

public class Strobogrammatic {

    public static boolean isStrobogrammatic(String num) {

        if(num== null || num.length()==0){
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');

        int start =0;
        int end = num.length()-1;

        while(start <= end){
        
            // 2 conditions to dicard a number
            if(!map.containsKey(num.charAt(start))){
                return false;
            }
            
            if(map.get(num.charAt(start))!=num.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
    
    public static void main(String[] args){
        //System.out.println(isStrobogrammatic("69"));
        System.out.println(decrypt("dnotq"));
    }
}
