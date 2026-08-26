class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int left = 1 , right = nums.length-2;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // Peak
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;

            else if(nums[mid-1] > nums[mid]) right = mid - 1;

            else left = mid + 1;
            
        }

        return -1; 
    }
}