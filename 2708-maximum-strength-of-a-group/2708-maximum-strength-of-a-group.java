class Solution {
    public long maxStrength(int[] nums) {
        if(nums.length == 1) return nums[0];

        long[] max = new long[]{nums[0]};

        solve(nums , max , 1 , 0 , 0);

        return max[0];
    }

    void solve(int[] nums , long[] max , long curr , int picked , int ind){

        // picked till end
        if(ind == nums.length){
            if(picked != 0) max[0] = Math.max(max[0] , curr);

            return;
        }

        // Pick 
        solve(nums , max , (long)curr*nums[ind] , picked+1 , ind+1);
        
        // Not pick
        solve(nums , max , curr , picked , ind+1);
    }
}