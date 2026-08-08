class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int left = 0 , right = k;
        long curr = 0 , maxSum = 0;

        for(int i=0 ; i<k ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
            curr += nums[i];
        }

        if(map.size() == k) maxSum = curr;

        while(right < nums.length){
            
            curr += nums[right];
            curr -= nums[left];

            map.put(nums[right] , map.getOrDefault(nums[right] , 0) + 1);
            map.put(nums[left] , map.get(nums[left]) - 1);

            if(map.get(nums[left]) <= 0) map.remove(nums[left]);

            if(map.size() == k){
                maxSum = curr > maxSum ? curr : maxSum;
            }

            left++;
            right++;
        }

        return maxSum;
    }
}