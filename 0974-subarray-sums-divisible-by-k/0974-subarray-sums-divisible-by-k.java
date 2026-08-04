class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        map.put(0 , 1);

        int sum = 0 , cnt = 0;

        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];

            int req = sum % k;

            // To search for positive remainders
            req = req < 0 ? req+k : req;

            if(map.containsKey(req)){
                cnt += map.get(req);
            }

            map.put(req , map.getOrDefault(req , 0) + 1);
        }

        return cnt;

    }
}