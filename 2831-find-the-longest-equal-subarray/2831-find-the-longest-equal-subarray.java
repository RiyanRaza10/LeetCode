class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int[] freq = new int[100001];
        
        int maxLen = 0 , maxFreq = 0;
        int left = 0 , right = 0;

        while(right < nums.size()){
            freq[nums.get(right)]++;
            maxFreq = Math.max(maxFreq , freq[nums.get(right)]);

            while(left <= right && (right - left + 1) - maxFreq > k){
                freq[nums.get(left)]--;

                left++;
            }

            maxLen = Math.max(maxFreq , maxLen);

            right++;
        }   

        return maxLen;
    }
}