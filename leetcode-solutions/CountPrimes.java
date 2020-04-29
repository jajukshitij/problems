/*
    Problem: Leetcode. Count Primes
    Count the number of prime numbers less than a non-negative number, n.

    Example:
    Input: 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://www.youtube.com/watch?v=UMVa5fRKC8I
    ----------------------------------------------------------------------------------------------------------------------------------
    
    -------------------------------------------- Time Complexity : O(log (log n)) -----------------------------------------------------
    -------------------------------------------- Space Complexity : O(n) -------------------------------------------------------------
    
    The Sieve of Eratosthenes method
*/

public class CountPrimes {

    public static int countPrimes(int n){
        boolean[] primes = new boolean[n];

        // Starting with assumtion, all numbers are prime
        for(int i=0; i<n; i++){
            primes[i] = true;
        }

        for(int i=2; i*i<n; i++){ // factors exist only up to √n
            
            if(primes[i]){
                
                for(int j = i*i; j<n; j+=i){ // j += i; iterating over multiples of i
                    primes[j]=false;
                }
            }
        }

        int count =0;
        for(int i=2; i<n; i++){
            if(primes[i]){
                count++;
            }
        }
        return count;
    }
}
