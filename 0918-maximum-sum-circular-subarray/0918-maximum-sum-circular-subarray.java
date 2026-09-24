class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0 , currSum = 0 , minSum = Integer.MAX_VALUE , maxSum = Integer.MIN_VALUE , currMin = 0;

        for(int i=0 ; i<nums.length ; i++){

            totalSum += nums[i];

            // Kadane's
            currSum += nums[i];
            maxSum = Math.max(maxSum , currSum);
            if(currSum < 0) currSum = 0;

            // Minimum sum subarray
            currMin += nums[i];
            minSum = Math.min(minSum , currMin);
            if(currMin > 0) currMin = 0;

        }

        if(totalSum == minSum) return maxSum;

        return Math.max(maxSum , totalSum - minSum);
    }
}