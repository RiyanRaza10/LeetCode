class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long totalSubarray = 0 , zeroCnt = 0;

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] == 0) zeroCnt++;
            else zeroCnt = 0;

            totalSubarray += zeroCnt;
        }

        return totalSubarray;
    }
}