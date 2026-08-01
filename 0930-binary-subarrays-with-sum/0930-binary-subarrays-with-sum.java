class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer , Integer> map = new HashMap<>();

        int cnt = 0 , sum = 0;

        // Base case
        map.put(0 , 1);

        for(int val : nums){
            sum += val;

            int req = sum - goal;

            if(map.containsKey(req)){
                cnt += map.get(req);
            }

            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }

        return cnt;
    }
}