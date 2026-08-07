class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer , Integer> map = new HashMap<>();

        int sum = 0 , cnt = 0;

        // Base Case
        map.put(0 , 1);

        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];

            int req = sum - goal;

            if(map.containsKey(req)){
                cnt += map.get(req);
            }

            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }

        return cnt;
    }
}