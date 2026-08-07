class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Key Idea : 
        // (Total Subarrays with K diff Integers) = (Total Subarrays with less than equal to K diff Integers)
        //                                        - (Total Subarrays with less than K diff Integers)


        // To store number of count of Integers with their frequency
        HashMap<Integer , Integer> map = new HashMap<>();

        int left = 0 , right = 0 , lessThanEqualToKCnt = 0 , lessThanKCnt = 0;

        // Counting total Subarrays with less than equal to K diff Integers
        while(right < nums.length){
            map.put(nums[right] , map.getOrDefault(nums[right] , 0) + 1);

            while(left <= right && map.size() > k){
                map.put(nums[left] , map.get(nums[left]) - 1);

                if(map.get(nums[left]) <= 0) map.remove(nums[left]);

                left++;
            }

            lessThanEqualToKCnt += (right - left + 1);

            right++;
        }

        left = 0 ; right = 0 ; 

        // Re-Initialising map so no need of new one
        map = new HashMap<>();

        // Counting total Subarrays with less than K diff Integers
        while(right < nums.length){
            map.put(nums[right] , map.getOrDefault(nums[right] , 0) + 1);

            while(left <= right && map.size() >= k){
                map.put(nums[left] , map.get(nums[left]) - 1);

                if(map.get(nums[left]) <= 0) map.remove(nums[left]);

                left++;
            }

            lessThanKCnt += (right - left + 1);

            right++;
        }

        // (Total Subarrays with less than equal to K diff Integers) - (Total Subarrays with less than K diff Integers)
        return lessThanEqualToKCnt - lessThanKCnt;
        
    }
}