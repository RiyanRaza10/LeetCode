class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n];

        for(int i=0 ; i<n ; i++){
            if(i == 0) dp[i] = costs[i] + 1;

            else if(i == 1) {
                int c0 = costs[i] + 4; // Direct start from i = 1
                int c1 = costs[i] + dp[i-1] + 1;

                dp[i] = Math.min(c0 , c1);
            }
            
            else if(i == 2){
                int c0 = costs[i] + 9; // Direct start from 2
                int c1 = costs[i] + dp[i-2] + 4; // 0 -> 2
                int c2 = costs[i] + dp[i-1] + 1; // 1 -> 2

                dp[i] = Math.min(c0 , Math.min(c1 , c2));
            }

            else{
                int c1 = costs[i] + dp[i-3] + 9; // 3 step back
                int c2 = costs[i] + dp[i-2] + 4; // 2 step back
                int c3 = costs[i] + dp[i-1] + 1; // 1 step back

                dp[i] = Math.min(c1 , Math.min(c2 , c3));
            }
        }

        return dp[n-1];
    }
}