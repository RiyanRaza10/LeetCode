class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for(int i=0 ; i<n ; i++) nums[i] = nums[i] * nums[i];

        Arrays.sort(nums);

        long ans = 0;

        int maxPos = (n%2 == 1) ? n/2 + 1 : n/2;
        int cnt = 0;

        for(int i=n-1 ; i>=0 ; i--){
            if(cnt < maxPos){
                ans += nums[i];
                cnt++;
            }

            else ans -= nums[i];
        }

        return ans;
    }
}