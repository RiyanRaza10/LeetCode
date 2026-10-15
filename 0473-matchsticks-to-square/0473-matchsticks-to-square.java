class Solution {
    // Key Idea : Try to place largest pieces first

    public boolean makesquare(int[] matchsticks) {
        // Array is sorted , taaki pick krne me aasaani ho
        Arrays.sort(matchsticks);

        int totalSum = 0 , n = matchsticks.length;

        int[] sidesSum = new int[4];

        for(int val : matchsticks) totalSum += val;

        // Impossible lengthss
        if(totalSum % 4 != 0) return false;

        return solve(matchsticks , sidesSum , totalSum / 4 , n , n-1);
    
    }

    boolean solve(int[] matchsticks , int[] sidesSum , int sideLen , int n , int ind){
        
        // Picked all
        if(ind == -1){
            // Check if length of all sides is equal to sideLen
            return (sidesSum[0] == sideLen && sidesSum[0] == sidesSum[1] && sidesSum[1] == sidesSum[2] && sidesSum[2] == sidesSum[3]);
        }

        if(matchsticks[ind] > sideLen) return false;
        
        for(int i=0 ; i<4 ; i++){
            
            if(sidesSum[i] + matchsticks[ind] <= sideLen){
                // Pick for current side
                sidesSum[i] += matchsticks[ind];

                if(solve(matchsticks , sidesSum , sideLen , n , ind-1)) return true;

                // Backtrack / remove from current side
                sidesSum[i] -= matchsticks[ind];
            } 
        }

        // Couldn't form any combination
        return false;
    }
}