// Approach - 2 { Updated version of last submission }

// Key Idea : Instead of calculating subarrays with sum < k
//            we can use the same function for subarrays with sum <= k by calculating subarrays with sum < k-1
//            Then it will use less lines of code and promotes code reusability

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // (Total Subarrays with K diff Integers) = (Total Subarrays with less than equal to K diff Integers)
        //                                        - (Total Subarrays with less than K diff Integers 
        //                                              or less than equal to k-1 Integers)
        return countSubarray(nums , k) - countSubarray(nums , k-1);        
    }

    int countSubarray(int[] nums , int k){

        // To keep track of number of different Integers
        HashMap<Integer , Integer> map = new HashMap<>();

        int left = 0 , right = 0 , ans = 0;

        // Sliding Window
        while(right < nums.length){
            map.put(nums[right] , map.getOrDefault(nums[right] , 0) + 1);

            // Shrinking
            while(left <= right && map.size() > k){
                map.put(nums[left] , map.get(nums[left]) - 1);

                if(map.get(nums[left]) <= 0) map.remove(nums[left]);

                left++;
            }

            ans += (right - left + 1);

            right++;
        }

        return ans;
    }
}