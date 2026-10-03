class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] totalWays = new int[1];

        solve(nums , totalWays , target , 0 , 0);

        return totalWays[0];
    }

    void solve(int[] nums , int[] totalWays , int target , int curr , int ind){
        // For every value in nums :
        // Either take its negative or positive

        // Expression built till last
        if(ind == nums.length){
            if(curr == target) totalWays[0]++;

            return;
        }

        // Take negative of element
        curr -= (nums[ind]);
        solve(nums , totalWays , target , curr , ind+1);
            
        // Backtrack
        curr += (nums[ind]);

        // Take positive of element
        curr += nums[ind];
        solve(nums , totalWays , target , curr , ind+1);
    
    }
}