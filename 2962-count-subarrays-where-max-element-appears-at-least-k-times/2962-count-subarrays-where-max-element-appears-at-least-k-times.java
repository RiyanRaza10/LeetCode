class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElem = -1 , maxElemFreq = 0;

        for(int val : nums) maxElem = Math.max(maxElem , val);

        int left = 0 , right = 0 , n = nums.length;

        long subCnt = 0;

        while(right < n){
            if(nums[right] == maxElem) maxElemFreq++;

            while(left <= right && maxElemFreq >= k){
                subCnt += (n - right);

                if(nums[left] == maxElem) maxElemFreq--;

                left++;
            }

            if(maxElemFreq >= k) subCnt += (n - right);

            right++;
        }

        return subCnt;
    }
}