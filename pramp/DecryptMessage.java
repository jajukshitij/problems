/*
    Problem: Decrypt Message
    An infamous gang of cyber criminals named “The Gray Cyber Mob”, which is behind many hacking attacks and drug trafficking,
    has recently become a target for the FBI. After intercepting some of their messages, which looked like complete nonsense,
    the agency learned that they indeed encrypt their messages, and studied their method of encryption.
    Their messages consist of lowercase latin letters only, and every word is encrypted separately as follows:
    Convert every letter to its ASCII value. Add 1 to the first letter, and then for every letter from the second one to the last one,
    add the value of the previous letter. Subtract 26 from every letter until it is in the range of lowercase letters a-z in ASCII.
    Convert the values back to letters.

    For instance, to encrypt the word “crime”
    Decrypted message:	c	r	i	m	e
    Step 1:	99	114	105	109	101
    Step 2:	100	214	319	428	529
    Step 3:	100	110	111	116	113
    Encrypted message:	d	n	o	t	q
    
    The FBI needs an efficient method to decrypt messages.
    Write a function named decrypt(word) that receives a string that consists of small letters only and returns the decrypted word
    Explain your solution and analyze its time and space complexities.

    Examples:
    input:  word = "dnotq"
    output: "crime"

    input:  word = "flgxswdliefy"
    output: "encyclopedia"
    ----------------------------------------------------------------------------------------------------------------------------------
    
    ----------------------------------------------------------- Time Complexity: O(n) ------------------------------------------------
                                                                                 n = length of string
    ---------------------------------------------------------- Space Complexity: O(n) ------------------------------------------------
*/

public class DecryptMessage {

  // Reverse engineer the encryption algorithm
  public static String decrypt(String word) {
  
        String result = "";
        int prevAscii = 1;

        for (int i = 0; i < word.length(); i++) {
        
            int decry = asciiValue(word.charAt(i)); // get ASCII value of char
            decry = decry - prevAscii;  // Subtract prev ASCII sum
            
            while (decry < asciiValue('a')) { // Keep adding 26 until value is in lowercase chars range
                decry += 26;
            }
            
            result += (char) decry; // Add to result string
            prevAscii += decry; // build prev ASCII to subtract from next char
            
        }

        return result;
    }

    public static int asciiValue(char c){
        return (int) c;
    }

}
