public class WeightedRandomSelection {

    // https://stackoverflow.com/a/6409767/6921304
    // https://gamedev.stackexchange.com/questions/162976/how-do-i-create-a-weighted-collection-and-then-pick-a-random-element-from-it
    // Discrete Cumulative Density Function (CDF)

    public class State{
    
        String state;
        int population;

        public State(String state, int population){
            this.state = state;
            this.population = population;
        }
    }

    // ----------------------------------------------- Time Complexity: O(n) ---------------------------------------------------------
    // ---------------------------------------------- Space Complexity: O(1) ---------------------------------------------------------

    public static String selectRandomState(State[] states){

        int totalPopulation =0;

        for(State state: states){
            totalPopulation += state.population;
        }

        double random = Math.random()*totalPopulation;
        double currSum = 0.0;

        for(State state: states){
        
            currSum += state.population;
            
            if(currSum>= random){
                return state.state;
            }
        }

        return "";
    }

    // ----------------------------------------- Time Complexity: O(log n) ; Pre-processing - O(n) ---------------------------------
    // --------------------------------------------------- Space Complexity: O(n) --------------------------------------------------
    // https://blog.bruce-hill.com/a-faster-weighted-random-choice

    public static String selectBinarySearch(State[] states){

        // ----------PRE-PROCESSING -------------
        
        int n = states.length;
        int[] runningTotal = new int[n];
        runningTotal[0] = states[0].population;

        for(int i=1; i<n; i++){
        
            runningTotal[i] = runningTotal[i-1]+ states[i].population;
        }
        
        //---------------------------------------

        double random = Math.random() * runningTotal[n-1];
        int left = 0;
        int right = n-1;

        while(left< right){
        
            int mid = left +(right-left)/2;
            int currSum = runningTotal[mid];

            if(currSum < random){
                left = mid+1;
            }else if(currSum > random){
                right = mid-1;
            }else{
                return states[mid].state;
            }
            
        }
        
        return states[left].state;
    }
}

