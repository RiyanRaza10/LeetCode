class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        // To store , key : no. of odd numbers till index
        //            value : no. of subarrays with same count of odd numbers
        HashMap<Integer , Integer> map = new HashMap<>();

        int oddCount = 0 , ans = 0;

        // Base case if oddCount == k
        map.put(0 , 1);

        for(int i=0 ; i<nums.length ; i++){

            if(nums[i] % 2 == 1) oddCount++;

            // Required subarray
            int diff = oddCount - k;

            if(map.containsKey(diff)){
                ans += map.get(diff);
            }

            // Putting no. of subarrays with same no. of oddCount
            map.put(oddCount , map.getOrDefault(oddCount , 0) + 1);
        }

        return ans;
    }
}