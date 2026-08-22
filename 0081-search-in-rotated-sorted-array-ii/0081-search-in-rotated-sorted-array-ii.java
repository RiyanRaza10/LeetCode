class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0 , right = nums.length-1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;

            // Found
            if(nums[mid] == target) return true;

            // Trimming down search space
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++;
                right--;
                continue; // Need to recalculate mid
            }

            // Check if left part is sorted
            if(nums[left] <= nums[mid]){

                // Check if target lies in sorted left part
                if(nums[left] <= target && nums[mid] >= target){
                    right = mid - 1;
                }

                else left = mid + 1;

            }

            // Check if right part is sorted
            else{

                // Check if target lies in sorted right part
                if(nums[mid] <= target && nums[right] >= target){
                    left = mid + 1;
                }

                else right = mid -1;
            }
        }

        return false;
    }
}