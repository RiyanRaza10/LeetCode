class Solution {
    public int minLength(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int left = 0 , right = 0 , sum = 0 , minLen = nums.length+1;

        while(right < nums.length){
            map.put(nums[right] , map.getOrDefault(nums[right] , 0) + 1);

            if(map.get(nums[right]) == 1) sum += nums[right];    

            // Updating minLen
            if(sum >= k) 
                minLen = Math.min(minLen , right - left + 1);
            
            // Shrinking
            while(left <= right && sum >= k){
                if(map.get(nums[left]) == 1) sum -= nums[left];

                map.put(nums[left] , map.get(nums[left]) - 1);

                if(map.get(nums[left]) <= 0) map.remove(nums[left]);

                left++;

                // Updating minLen
                if(sum >= k) 
                    minLen = Math.min(minLen , right - left + 1);

            }

            right++;

        }

        return minLen == nums.length+1 ? -1 : minLen;
    }
}