/*
    Problem: Leetcode.186 Reverse Words in a String II
    Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
    The input string does not contain leading or trailing spaces and the words are always separated by a single space.
    
    Example:
    Given s = "the sky is blue",
    return "blue is sky the".

    Could you do it in-place without allocating extra space?
    -----------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(n) ---------------------------------------------------------
                                                                         n = number of words / total number of characters
    -------------------------------------------------- Space Complexity: O(1) ---------------------------------------------------------
    
*/

public class ReverseWordsII {

    public static void reverseWords(char[] s) {
        reverse(s,0,s.length-1); // Reversing all the characters

        reverseEachWord(s); Reverseving all charachters of word individually

        for(int i=0; i<s.length;i++){
            System.out.print(s[i]);
        }
    }

    public static void reverse(char[] s, int i, int j){
    
        while(i<j){
        
            char temp = s[i];
            s[i]= s[j];
            s[j] =temp;
            i++;
            j--;
        }
    }

    public static void reverseEachWord(char[] s){
    
        int n = s.length;
        int i = 0;
        int j = 0;

        while(i <n){
        
            i = j;
            
            while(j<n && s[j] != ' '){ // Incrementing j till it reaches ' ', which marks end of word
                j++;
            }
            
            reverse(s,i,j-1); // reversing the word found,i.e. between i to j-1
            j++;
        }
    }

    public static void main(String[] args){
        char[] chars = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        char[] chars2 ={'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
                
        reverseWords(chars2);
    }

}
