class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer , Integer> map = new HashMap<>();

        // Putting first 2 pairings sum of nums1 and nums2 in map
        for(int val1 : nums1){
            for(int val2 : nums2){
                int sum = val1 + val2;

                map.put(sum , map.getOrDefault(sum , 0) + 1);
            }
        }

        int cnt = 0;

        // Counting required pairs
        for(int val1 : nums3){
            for(int val2 : nums4){
                int req = -(val1 + val2);

                if(map.containsKey(req)) cnt += map.get(req);
            }
        }
        
        return cnt;
    }
}