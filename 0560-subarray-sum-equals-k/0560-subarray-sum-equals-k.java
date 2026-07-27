class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // To store , key : prefixsum
        //            value : number of subarrays with same prefixsum  
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int prefixSum = 0 , ans = 0;

        // Base case -> if sum == k
        map.put(0 , 1);

        for(int i=0 ; i<nums.length ; i++){
            prefixSum += nums[i];

            // Required subarray
            int diff = prefixSum - k;

            if(map.containsKey(diff)){
                ans += map.get(diff);
            }

            // Putting number of subarrays ending with same prefixSum
            map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1);
        }

        return ans;
    }
}