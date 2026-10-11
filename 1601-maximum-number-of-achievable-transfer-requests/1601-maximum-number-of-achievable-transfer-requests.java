class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] maxReq = new int[]{0};

        // To keep track of emplyees leaving and entering the building
        int[] emp = new int[n];

        solve(requests , n , maxReq , emp , 0 , 0);

        return maxReq[0];
    }

    void solve(int[][] requests , int n , int[] maxReq , int[] emp , int currReq , int ind){

        // Reached end of requests
        if(ind == requests.length){

            // Check if all emp in buildings are balanced
            boolean balanced = true;

            for(int i=0 ; i<n ; i++){
                if(emp[i] != 0) balanced = false;
            }

            if(balanced) maxReq[0] = Math.max(maxReq[0] , currReq);

            return;
        }

        // Pick this request
        emp[requests[ind][0]]--;
        emp[requests[ind][1]]++;
        currReq++;

        // Recursive call to next request
        solve(requests , n , maxReq , emp , currReq , ind+1);

        // Backtrack
        emp[requests[ind][0]]++;
        emp[requests[ind][1]]--;
        currReq--;

        // Not pick this request / call for next
        solve(requests , n , maxReq , emp , currReq , ind+1);
    }
}