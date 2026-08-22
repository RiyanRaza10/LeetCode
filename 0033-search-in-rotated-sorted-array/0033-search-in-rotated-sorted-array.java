class Solution {
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length-1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;

            // Found
            if(nums[mid] == target) return mid;

            // Checking if left part is sorted
            if(nums[left] <= nums[mid]){

                // If target lies in this search space , trim down the search space
                if(nums[left] <= target && nums[mid] > target){
                    right = mid - 1;
                }

                else left = mid + 1;
            }

            // Checking if right part is sorted 
            else{

                // If target lies in this search space , trim down the search space
                if(nums[mid] <= target && nums[right] >= target){
                    left = mid + 1;
                }

                else right = mid - 1;
            }
        }

        return -1;
    }
}