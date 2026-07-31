class Solution {
    public int singleNumber(int[] nums) {
       
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int val : nums){
            map.put(val , map.getOrDefault(val , 0) + 1);
        }

        for(int val : nums){
            if(map.get(val) == 1) return val;
        }

        return 69;
    }
}