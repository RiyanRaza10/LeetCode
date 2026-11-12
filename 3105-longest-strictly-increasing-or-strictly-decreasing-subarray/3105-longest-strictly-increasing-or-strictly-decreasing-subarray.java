class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length , maxLen = 1;

        for(int i=0 ; i<n ; i++){
            int ind = i;

            while(ind < n-1 && nums[ind] < nums[ind+1]) ind++;

            maxLen = Math.max(maxLen , ind-i+1);

            ind = i;

            while(ind > 0 && nums[ind] < nums[ind-1]) ind--;

            maxLen = Math.max(maxLen , i-ind+1);
        }

        return maxLen;
    }
}