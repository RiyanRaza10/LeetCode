class Solution {
    public int findMin(int[] nums) {
        int left = 0 , right = nums.length-1 , min = nums[0];

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] < min){
                min = nums[mid];
            }

            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++;
                right--;

                continue;
            }

            if(nums[left] <= nums[mid]){
                if(nums[left] < min) min = nums[left];

                left = mid+1;
            }
            
            else{
                if(nums[right] < min) min = nums[left];

                right = mid - 1;
            }
        }

        return min;
    }
}