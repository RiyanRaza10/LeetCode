class Solution {

    int rev(int n){
        int revNum = 0;

        while(n > 0){
            revNum = revNum*10 + (n%10);
            n /= 10;
        }

        return revNum;
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