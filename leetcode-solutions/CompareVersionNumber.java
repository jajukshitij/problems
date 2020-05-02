/*
    Problem: Leetcode.165 Compare Version Number (Medium)
    Compare two version numbers version1 and version2.
    If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
    You may assume that the version strings are non-empty and contain only digits and the . character.
    The . character does not represent a decimal point and is used to separate number sequences.
    For instance, 2.5 is not "two and a half" or "half way to version three",
    it is the fifth second-level revision of the second first-level revision.
    You may assume the default revision number for each level of a version number to be 0.
    For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number.
    Its third and fourth level revision number are both 0.

    Example 1:
    Input: version1 = "0.1", version2 = "1.1"
    Output: -1
    -----------------------------------------------------------------------------------------------------------------------------------
    
    ---------------------------------------------------- Time Complexity: O(min(n,m)) -------------------------------------------------
                                                                          n = length of ver1 , m = length of ver2
*/

public class CompareVersionNumber {

    public int compareVersionNumber(String version1, String version2){
        
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        int len = Math.max(ver1.length, ver2.length);
        int v1 =0;
        int v2 =0;

        for(int i=0; i<len; i++){
            
            if(i < ver1.length){
                v1= Integer.parseInt(ver1[i]);
            }else{
                v1=0;
            }

            if(i < ver2.length){
                v2= Integer.parseInt(ver2[i]);
            }else{
                v2=0;
            }

            if(v1 > v2){
                return 1;
            }else if(v2 > v1){
                return -1;
            }
        }

        return 0;
    }
}
