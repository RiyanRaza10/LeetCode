class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0 , right = 0 , zeroes = 0 , maxLen = 0 ;

        while(right < nums.length){
            if(nums[right] == 0) zeroes++;

            while(left <= right && zeroes > 1){
                if(nums[left] == 0) zeroes--;

                left++;
            }

            maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }

        return maxLen-1;
    }
}