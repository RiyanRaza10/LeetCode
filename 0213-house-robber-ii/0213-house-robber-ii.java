class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0] , nums[1]);

        int[] dp = new int[n];

        // take first house and not take last house
        for(int i=0 ; i<n-1 ; i++){
            if(i == 0) dp[i] = nums[i];
            else if(i == 1) dp[i] = Math.max(nums[1] , nums[0]);

            else dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);    
        }

        int firstTake = dp[n-2];

        dp = new int[n];

        // Not take first house and take last house
        for(int i=1 ; i<n ; i++){
            if(i == 1) dp[i] = nums[i];
            else if(i == 2) dp[i] = Math.max(nums[i] , dp[i-1]);

            else dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);
        }

        return Math.max(dp[n-1] , firstTake);
    }
}