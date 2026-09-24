class Solution {
    boolean canSplit(int[] nums , int k , int maxSum){
        int currPartitions = 1 , currSum = 0;

        for(int val : nums){
            if(currSum + val <= maxSum){
                currSum += val;
            }

            else{
                currSum = val;
                currPartitions++;
            }
        }

        return currPartitions <= k;
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

            if(canSplit(nums , k , mid)){
                ans = mid;
                right = mid - 1;
            }

            else left = mid + 1;
        }

        return ans;
    }
}