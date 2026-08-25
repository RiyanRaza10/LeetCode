class Solution {
    public long maxTotalValue(int[] nums, int k) {

        int max = -1 , min = Integer.MAX_VALUE;

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] > max) max = nums[i];
            if(nums[i] < min) min = nums[i];
        }

        // As subarray can be repeated , 
        // Return the maximum difference k times
        return ((long)max - min) * k;

    }
}