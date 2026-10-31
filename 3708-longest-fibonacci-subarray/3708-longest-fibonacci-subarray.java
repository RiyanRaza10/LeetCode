class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 2 , left = 0 , right = 2;
        
        while(right < nums.length){

            if(nums[right] != nums[right-1] + nums[right-2]){
                left = right - 1;
            }

            maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }

        return maxLen;
    }
}