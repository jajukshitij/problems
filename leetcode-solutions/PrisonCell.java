/*
    Problem: Leetcode.957 Prison Cell After N days (Medium)
    There are 8 prison cells in a row, and each cell is either occupied or vacant.
    Each day, whether the cell is occupied or vacant changes according to the following rules:
    If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
    Otherwise, it becomes vacant.
    (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
    We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
    Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

    Example 1:
    Input: cells = [0,1,0,1,1,0,0,1], N = 7
    Output: [0,0,1,1,0,0,0,0]
    Explanation: 
    The following table summarizes the state of the prison on each day:
    Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
    Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
    Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
    Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
    Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
    Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
    Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
    Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
    ----------------------------------------------------------------------------------------------------------------------------------
    
    Reference:
    https://leetcode.com/problems/prison-cells-after-n-days/discuss/205684/JavaPython-Find-the-Loop-or-Mod-14
    ----------------------------------------------------------------------------------------------------------------------------------
    
    --------------------------------------------------- Time Complexity: O(2^m) ------------------------------------------------------
                                                                         m = number of cells in prison
    --------------------------------------------------- Space Complexit: O((2^m) * m) ------------------------------------------------
    
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCell {

    public static int[] prisonAfterNDays(int[] cells, int N){
        Map<String, Integer> map = new HashMap<>(); // Storing array as string else, it'll be reference

        while(N>0){
            map.put(Arrays.toString(cells), N);
            N--;

            int[] cells2 = new int[8];

            for(int i=1; i<7; i++){
                if(cells[i-1]== cells[i+1]){
                    cells2[i]=1;
                }else{
                    cells2[i]=0;
                }
            }

            cells = cells2;

            if( map.containsKey(Arrays.toString(cells)) ){
                N = N % (map.get(Arrays.toString(cells)) - N );
            }
        }

        return cells;
    }
}

/*
   https://leetcode.com/problems/prison-cells-after-n-days/discuss/205684/JavaPython-Find-the-Loop-or-Mod-14/259344
   
   You store the state in the map the first time you see a new state.
   Then when you see the same state again, you know that you have passed (lastSeen - currVal) state in between.
   So now you know your states repeat every (lastSeen - currVal) times.
   So finally you can mod the current N with that value to not repeat the same steps. Below is an example for 10^9 days.
              
   [0,1,0,1,1,0,0,1]
   1000000000

   N -> N % (last_seen - curr_val) ==> result
   999999985 -> 999999985 % (999999999 - 999999985) ==> 5
   4 -> 4 % (999999998 - 4) ==> 4
   3 -> 3 % (999999997 - 3) ==> 3
   2 -> 2 % (999999996 - 2) ==> 2
   1 -> 1 % (999999995 - 1) ==> 1
   0 -> 0 % (999999994 - 0) ==> 0
*/

