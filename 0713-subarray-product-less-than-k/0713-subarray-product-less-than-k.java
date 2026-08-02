class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int left = 0 , right = 0 , prod = 1 , ans = 0;

        while(right < nums.length){
            prod *= nums[right];

            while(left <= right && prod >= k){
                prod /= nums[left];
                left++;
            }

            ans += (right - left + 1);

            right++;
        }

        return ans;
    }
}