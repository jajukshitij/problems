/*
    Problem: 
    https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
    --------------------------------------------------------------------------------------------------------------
    
    ------------------------ Time Complexity: O(n) ----------------------
                                              compare takes O(1) time 
*/

public class AllPossiblePermutations {   

    public static void main(String args[]){
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        search(pat, txt);
    }

    static final int MAX =256;

    public static boolean compare(int pat[], int tw[]){
        for(int i =0; i< MAX; i++){
            if(pat[i] != tw[i]){
                return false;
            }
        }
        return true;
    }

    public static void search(String pat, String txt){

        int lenPat = pat.length();
        int lenTxt = txt.length();

        int countPat[] = new int[MAX];
        int countTW[] = new int[MAX];

        for (int i=0; i<lenPat ;i++){
            countPat[pat.charAt(i)]++;
            countTW[txt.charAt(i)]++;
        }


        for(int i=lenPat; i <lenTxt;i++) {
            if (compare(countPat, countTW)) {
                System.out.println("Match found at " + (i- lenPat));
            }

            countTW[txt.charAt(i)]++;
            countTW[txt.charAt(i-lenPat)]--;
        }

        if(compare(countPat,countTW)){
            System.out.println("Match found at " + (lenTxt- lenPat));
        }

    }
}
