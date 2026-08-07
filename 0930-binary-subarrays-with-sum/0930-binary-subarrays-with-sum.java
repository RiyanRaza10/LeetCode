class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        // Key Idea :
        // (Total subarrays with sum == goal) = (Total subarrays with sum <= goal) - (Total subarrays with sum < goal) 
        int sum = 0 , left = 0 , right = 0 , lessThanEqualToGoalCnt = 0 , equalToGoalCnt = 0;

        // Counting total subarrays with sum <= goal
        while(right < nums.length){
            sum += nums[right];

            while(left <= right && sum > goal){
                sum -= nums[left];
                left++;
            }

            lessThanEqualToGoalCnt += (right - left + 1);

            right++;
        }

        left = 0 ; right = 0 ; sum = 0;

        // Counting total subarrays with sum < goal
        while(right < nums.length){
            sum += nums[right];

            while(left <= right && sum >= goal){
                sum -= nums[left];
                left++;
            }

            equalToGoalCnt += (right - left + 1);

            right++;
        }

        // (Total subarrays with sum <= goal) - (Total subarrays with sum < goal)
        return lessThanEqualToGoalCnt - equalToGoalCnt;
    }
}

// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         Map<Integer , Integer> map = new HashMap<>();

//         int sum = 0 , cnt = 0;

//         // Base Case
//         map.put(0 , 1);

//         for(int i=0 ; i<nums.length ; i++){
//             sum += nums[i];

//             int req = sum - goal;

//             if(map.containsKey(req)){
//                 cnt += map.get(req);
//             }

//             map.put(sum , map.getOrDefault(sum , 0) + 1);
//         }

//         return cnt;
//     }
// }