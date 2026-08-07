class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0 , right = 0 , zeroes = 0 , maxLen = 0;

        while(right < nums.length){
            zeroes = nums[right] == 0 ? zeroes + 1 : zeroes;

            while(left <= right && zeroes > k){
                if(nums[left] == 0) zeroes--;

                left++;
            }

            maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }

        return maxLen;

    }
}