class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int left = 0 , right = 0;

        while(right < nums.length){
            
            if(nums[right] < minK || nums[right] > maxK) left = right + 1;

            ans += (right - left + 1);

            right++;
        }

        return ans;
    }
}