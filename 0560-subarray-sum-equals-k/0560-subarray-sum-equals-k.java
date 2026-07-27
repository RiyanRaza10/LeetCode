class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // To store , key : prefixsum
        //            value : number of subarrays with same prefixsum  
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int sum = 0 , ans = 0;

        // Base case -> if sum == k
        map.put(0 , 1);

        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];

            int diff = sum - k;

            if(map.containsKey(diff)){
                ans += map.get(diff);
            }

            // Number of subarrays ending with sum
            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }

        return ans;
    }
}