class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if(n == 1) return 0;

        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int left = 1 , right = n-2;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // Found peak element
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1] ) return mid;

            // If mid elem in kinda increasing , search in right half
            if(nums[mid] > nums[mid-1]){
                left = mid + 1;
            }
            
            // Else search in left half
            else right = mid - 1;

        }

        return -1;
    }
}