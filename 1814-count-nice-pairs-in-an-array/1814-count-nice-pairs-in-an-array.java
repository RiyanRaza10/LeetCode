class Solution {

    int rev(int n){
        long rev = 0;
        double mod = 1e9 + 7;

        while(n > 0){
            rev = rev*10 + (n%10);
            rev %= mod;
            n /= 10;
        }

        return (int)(rev % mod);
    }

    public int countNicePairs(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();

        long ans = 0;

        for(int i=0 ; i<nums.length ; i++){
            int req = nums[i] - rev(nums[i]);

            if(map.containsKey(req)){
                ans += map.get(req) % 1000000007;
            }

            map.put(req , map.getOrDefault(req , 0) + 1);
        }

        return (int)(ans % 1000000007);
    }
}