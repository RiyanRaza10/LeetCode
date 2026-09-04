class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length , maxFromStart = -1;

        int[] minFromLast = new int[n];

        minFromLast[n-1] = nums[n-1];

        for(int i=n-2 ; i>=0 ; i--){
            minFromLast[i] = Math.min(minFromLast[i+1] , nums[i]);
        }

        for(int i=0 ; i<nums.length ; i++){
            maxFromStart = Math.max(maxFromStart , nums[i]);

            if(maxFromStart - minFromLast[i] <= k) return i;
        }
        
        return -1;
    }
}