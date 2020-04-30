/*
    Problem: Root of Number
    Many times, we need to re-implement basic functions without using any standard library functions already implemented.
    For example, when designing a chip that requires very little memory space.
    In this question we’ll implement a function root that calculates the n’th root of a number. The function takes a nonnegative number x and a positive integer n,
    and returns the positive n’th root of x within an error of 0.001 (i.e. suppose the real root is y, then the error is: |y-root(x,n)| and must satisfy |y-root(x,n)| < 0.001).
    Don’t be intimidated by the question. While there are many algorithms to calculate roots that require prior knowledge in numerical analysis,
    there is also an elementary method which doesn’t require more than guessing-and-checking. Try to think more in terms of the latter.
    Make sure your algorithm is efficient, and analyze its time and space complexities.

    Examples:
    input:  x = 7, n = 3
    output: 1.913

    input:  x = 9, n = 2
    output: 3
    --------------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------------- Time Complexity: O(log (x)) ----------------------------------------------------
                                                                            [ O(n) ; n = number of bits req. to represent x; n = log(x)]    
    -------------------------------------------------------- Space Complexity: O(1) ----------------------------------------------------
    
*/

public class NthRootofNumber {

    // Binary Search based on guessing
    public static double nthRoot(int x, int n){
    
        if(x==0){
            return 0;
        }

        double low =0;
        double high =x;

        double assumedRoot = low + (high-low)/2;

        while( Math.abs( Math.pow(assumedRoot,n) - x ) >= 0.001 ){

            if ( Math.pow(assumedRoot, n) > x){
                high = assumedRoot;
                
            } else if( Math.pow(assumedRoot, n) < x){
                low = assumedRoot;
            }

            assumedRoot = low + (high-low)/2;
        }
        
        return assumedRoot;
    }

    public static int power(int x, int n){
    
        int res =1;

        while(n>=1){
            res *=x;
            n--;
        }

        return res;
    }
    
    public static void main(String[] args){
        System.out.println(nthRoot(7,3));
        System.out.println(nthRoot(9,2));
    }
}
