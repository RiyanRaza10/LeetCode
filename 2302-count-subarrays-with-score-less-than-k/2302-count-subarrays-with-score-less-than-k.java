class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left = 0 , right = 0 ;

        long score = 0 , sum = 0 , ans = 0;

        while(right < nums.length){
            sum += nums[right];
            score = sum * (right - left + 1);

            while(left <= right && score >= k){
                sum -= nums[left];
                left++;
                score = sum * (right - left + 1);

            }

            ans += (right - left + 1);

            right++;
        }

        return ans;
    }
}