class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalTransaction = 0 , startingStation = 0 , currTransaction = 0;

        for(int i=0 ; i<n ; i++){
            totalTransaction += (gas[i] - cost[i]);

            currTransaction += (gas[i] - cost[i]);

            // After doing gas[i] - cost[i]
            // If currTransaction comes out to be negative , 
            // it means we cannot start at current station , move to next station
            if(currTransaction < 0){
                currTransaction = 0;

                // Current station pe transaction negative hogya to direct jump to next station
                startingStation = i+1;
            }

        }

        // Kisi station wapis aa hi nahi sakta , transaction negative hai
        if(totalTransaction < 0) return -1;

        return startingStation;

    }
}