class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int left = 0 , right = 0 , maxLen = 0;

        while(right < nums.length){
            map.put(nums[right] , map.getOrDefault(nums[right] , 0) + 1);

            while(left <= right && map.get(nums[right]) > k){
                map.put(nums[left] , map.get(nums[left]) - 1);

                left++;
            }

            maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }

        return maxLen;
    }
}