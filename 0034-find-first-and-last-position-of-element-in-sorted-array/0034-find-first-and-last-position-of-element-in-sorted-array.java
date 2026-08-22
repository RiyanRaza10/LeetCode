class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length == 0) return new int[]{-1 ,-1};
        
        int first = -1 , last = -1;

        int left = 0 , right = nums.length-1;

        // Lower Bound
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                first = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target) left = mid + 1;

            else right = mid - 1;

        }

        left = 0; right = nums.length-1;

        // Upper Bound
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                last = mid;
                left = mid + 1;
            }
            
            else if(nums[mid] < target) left = mid + 1;

            else right = mid - 1;
            
        }

        return new int[]{first , last};

    }
}