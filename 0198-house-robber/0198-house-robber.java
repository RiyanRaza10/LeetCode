class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        for(int i=0 ; i<n ; i++){
            if(i == 0) dp[i] = nums[0];
            else if(i == 1) dp[i] = Math.max(dp[i-1] , nums[i]);

            else dp[i] = Math.max(dp[i-1] , nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }
}