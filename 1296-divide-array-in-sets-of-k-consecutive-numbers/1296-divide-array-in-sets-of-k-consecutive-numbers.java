class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;

        // Cannot form groups
        if(n % k != 0) return false;

        Arrays.sort(nums);

        // To store frequency
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i=0 ; i<n ; i++) map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);

        for(int i=0 ; i<n ; i++){
            
            // Value already used
            if(!map.containsKey(nums[i])) continue;

            int cnt = 0 , freq = 0;

            while(freq < k && map.containsKey(nums[i]+cnt)){

                // Decrement frequency
                map.put(nums[i]+cnt , map.get(nums[i]+cnt) - 1);
                if(map.get(nums[i]+cnt) == 0) map.remove(nums[i]+cnt);

                cnt++;
                freq++;
            }

            // Group of size k not formed
            if(freq < k) return false;
        }

        // All groups formed
        return true;

    }
}