class Solution {

    int countPartitions(int[] nums , int maxSum){
        int currSum = 0 , partition = 1;

        for(int val : nums){
            if(currSum + val <= maxSum){
                currSum += val;
            }

            else{
                partition++;

                currSum = val;
            }
        }

        return partition;
    }

    public int splitArray(int[] nums, int k) {
        int left = -1 , right = 0;

        for(int val : nums){
            left = Math.max(left , val);

            right += val;
        }

        int ans = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int currPartition = countPartitions(nums , mid);

            // Valid Partition found , search smaller
            if(currPartition <= k){
                ans = mid;

                right = mid - 1;
            }

            else left = mid + 1;
        }

        return ans;
    }
}