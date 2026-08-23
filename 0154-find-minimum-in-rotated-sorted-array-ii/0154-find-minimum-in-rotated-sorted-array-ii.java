class Solution {
    public int findMin(int[] nums) {
        int left = 0 , right = nums.length-1 , min = 5001;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // if nums[left] == nums[right] , compare minimum ans shrink pointers
            // Then continue , to recalculate mid
            if(nums[left] == nums[right]){
                if(nums[left] < min) min = nums[left];

                left++;
                right--;

                continue;
            }

            // Check if left part is sorted , compare its minimum and eliminate left half
            if(nums[left] <= nums[mid]){

                if(nums[left] < min) min = nums[left];

                left = mid + 1;
            }

            // Check if right part is sorted , compare its minimum and eliminate the right half
            else{

                if(nums[mid] < min) min = nums[mid];

                right = mid - 1;
            }
            
        }

        return min;
    }
}