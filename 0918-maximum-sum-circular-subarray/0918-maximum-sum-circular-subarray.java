class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0 , minSum = 0 , currMin = 0 , currSum = 0 , maxSum = nums[0] , n = nums.length;

        for(int i=0 ; i<n ; i++){
            
            // Total sum of array
            totalSum += nums[i];

            // Kadane's
            currSum += nums[i];
            maxSum = Math.max(maxSum , currSum);
            if(currSum < 0) currSum = 0;

            // Computing minimum sum of nums using Kadane's
            currMin += nums[i];
            minSum = Math.min(minSum , currMin);
            if(currMin > 0) currMin = 0;

        }

        // If all the elem in nums are negative , return the largest one
        if(totalSum == currMin) return maxSum;

        // There are 2 possibilities : 
        // Either maxSum (obtained using kadane's) is Maximum
        //               Or
        // Remove the subarray with minimum sum 
        // then the maximum sum will be circular parts from both ends of array{See test Case 2}
        return Math.max(maxSum , totalSum - minSum);

    }
}