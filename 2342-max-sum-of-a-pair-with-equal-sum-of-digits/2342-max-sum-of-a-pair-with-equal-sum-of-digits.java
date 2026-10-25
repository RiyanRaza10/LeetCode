class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();

        int maxSum = -1;

        for(int i=0 ; i<nums.length ; i++){
            int sum = 0 , num = nums[i];

            while(num > 0){
                sum += num%10;
                num /= 10;
            }

            if(map.containsKey(sum)){
                if(map.get(sum).size() < 2) map.get(sum).add(nums[i]);

                else{
                    int max1 = Math.max(map.get(sum).get(0) , map.get(sum).get(1));
                    int max2 = Math.max(nums[i] , Math.min(map.get(sum).get(0) , map.get(sum).get(1)));

                    map.put(sum , Arrays.asList(max1 , max2));
                }
            }
            else{
                map.put(sum , new ArrayList<>());
                map.get(sum).add(nums[i]);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key).size() == 2) maxSum = Math.max(maxSum , map.get(key).get(0) + map.get(key).get(1));
        }

        return maxSum;
    }
}