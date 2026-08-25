class Solution {

    int findDivisor(int[] nums , int divisor){
        int ans = 0;

        for(int num : nums){
            ans += Math.ceil((double)(num) / divisor);
        }
        
        return ans;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1 , right = Integer.MIN_VALUE;

        // Taking maximum divisor as max(nums) 
        for(int val : nums){
            if(val > right) right = val;
        }
       
        int minDivisor = 1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            int currDivSum = findDivisor(nums , mid);

            // Minimum found , search left of mid
            if(currDivSum <= threshold){
                minDivisor = mid;

                right = mid - 1;
            }

            else left = mid + 1;
        }

        return minDivisor;

    }
}