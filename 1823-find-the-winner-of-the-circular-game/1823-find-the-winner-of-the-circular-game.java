class Solution {
    public int findTheWinner(int n, int k) {
        int killed = 0 , cnt = 0 , ind = 0;

        // To keep track of who is alive
        boolean[] dead = new boolean[n];

        // Kill , until 1 is left
        while(killed < n-1){
            ind %= n;
            
            // If !dead , increment cnt
            if(dead[ind] == false)cnt++;

            // Kill
            if(cnt == k){
                dead[ind] = true;
                killed++;

                cnt = 0;
            }

            // Check every index
            ind++;
        }

        // Check who is alive
        for(int i=0 ; i<n ; i++){
            if(dead[i] == false) return i+1;
        }

        return 0;
    }
}