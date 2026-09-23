class Solution {
    public int minOperations(int[] nums, int x) {
        // Find the maximum length of subarray with sum equals "sum(nums) - x"
        // Then reduce this length from nums.length to get minimum answer
        int totalSum = 0;

        for(int val : nums) totalSum += val;

        int extraSum = totalSum - x , extraSumLen = 0 , left = 0 , right = 0 , currSum = 0;

        while(right < nums.length){
            currSum += nums[right];

            while(left <= right && currSum > extraSum){
                currSum -= nums[left];

                left++;
            }

            if(currSum == extraSum) extraSumLen = Math.max(extraSumLen , right - left + 1);

            right++;
        }

        // Check if a subarray with sum x , existed or not
        return (extraSumLen == 0 && totalSum != x) ? -1 : nums.length - extraSumLen; 
    }
}