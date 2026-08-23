class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        if(nums[0] != nums[1]) return nums[0];

        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int left = 1 , right = nums.length - 2;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // Found
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];

            // If mid is odd and element at mid and mid -1 is equal , then left part does not contain single element
            // If mid is even and elem at mid and mid+1 is equal , then also left part does not contain single elem
            // Therefore eliminate left part
            if((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])){
                left = mid + 1;
            }

            // Else elimiate right part
            else right = mid-1;

        }

        // Not found
        return -1;
    }
}
