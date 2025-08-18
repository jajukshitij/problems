/*
    Problem: Leetcode.277 Find the Celebrity (Medium)

    The given problem presents a scenario where you're at a party with n people, each labeled with a unique number between 0 and n - 1. 
    Your goal is to identify a possible celebrity among them. A celebrity is defined by two conditions: 
    first, every other person at the party knows the celebrity, 
    and second, the celebrity does not know anyone else at the party.
    
    Your tool is a function knows(a, b), which checks if person a knows person b. 
    You need to use this function to determine who, if anyone, is the celebrity at the party. 
    It is important to minimize the number of calls to the knows function, since your objective is to find the celebrity efficiently.
    The output of your task is to return the unique label of the celebrity if one exists, or -1 if there is no celebrity present.

    -------------------------------------------------------------------------------------------------------------------------------

    ---------------------------------------------- Time Complexity: O(n) -----------------------------------------------------------
    ---------------------------------------------- Space Complexity: O(1) ----------------------------------------------------------
*/

public class FindCelebrity {

    public int findCelebrity(int n) {
        int candidate = 0; // Initial assumption: the first person (0) may be the celebrity

        // First Pass: Find a candidate for celebrity
        for (int i = 1; i < n; ++i) {
            // If the candidate knows i, candidate cannot be a celebrity, thus i might be
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // Second Pass: Verify the candidate is really a celebrity
        for (int i = 0; i < n; ++i) {            
            if (candidate != i) { // Skip if i is the same as the candidate
                // If the candidate knows i, or i doesn't know the candidate, 
                // then the candidate cannot be a celebrity
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return -1;
                }
            }
        }
        return candidate;
    }
}
