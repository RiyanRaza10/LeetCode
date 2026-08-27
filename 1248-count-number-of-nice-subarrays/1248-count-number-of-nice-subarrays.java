class Solution {

    int countNiceSubarrays(int[] nums , int k){
        int left = 0 , right = 0 , niceSubarrays = 0 , oddCnt = 0;

        while(right < nums.length){
            if(nums[right] % 2 == 1) oddCnt++;

            while(left <= right && oddCnt > k){
                if(nums[left] % 2 == 1) oddCnt--;

                left++;
            }

            niceSubarrays += (right - left + 1);

            right++;
        }

        return niceSubarrays;

    }

    public int numberOfSubarrays(int[] nums, int k) {
        
        return countNiceSubarrays(nums , k) - countNiceSubarrays(nums , k-1);

    }
}