class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int sum = 0;

        // If sum == k (eg : [2,4])
        map.put(0 , -1);

        for(int i=0 ; i<nums.length ; i++){

            sum += nums[i];

            // Required sum
            int rem = sum % k;

            if(map.containsKey(rem)){
                if(i - map.get(rem) >= 2) return true;
            }

            // If map already contains rem then
            // no need to update else it will shorten the subarray
            else{
                map.put(rem , i);
            }

        }

        return false;

    }
}