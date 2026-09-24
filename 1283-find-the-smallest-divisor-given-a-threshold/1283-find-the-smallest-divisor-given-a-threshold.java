class Solution {
    boolean canDivide(int[] nums , int threshold , int divisor){
        int currSum = 0;

        for(int val : nums){
            currSum += (int)Math.ceil((double)val / divisor);
        }

        return currSum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1 , right = -1;

        for(int val : nums) right = Math.max(right , val);

        int ans = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canDivide(nums , threshold , mid)){
                ans = mid;
                right = mid - 1;
            }

            else left = mid + 1;
        } 

        return ans;
    }
}