class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0 , right = 0 , lessThanEqualToKCnt = 0 , lessThanKCnt = 0 , oddCnt = 0;

        // Counting subarrays with oddCnt <= k
        while(right < nums.length){
            if(nums[right] % 2 == 1) oddCnt++;

            while(left <= right && oddCnt > k){
                if(nums[left] % 2 == 1) oddCnt--;

                left++;
            }

            lessThanEqualToKCnt += (right - left + 1);

            right++;            
        }

        left = 0; right = 0 ; oddCnt = 0;

        // Counting subarrays with oddCnt < k
        while(right < nums.length){
            if(nums[right] % 2 == 1) oddCnt++;

            while(left <= right && oddCnt >= k){
                if(nums[left] % 2 == 1) oddCnt--;

                left++;
            }

            lessThanKCnt += (right - left + 1);

            right++;            
        }

        // (Subarrays with oddCnt == k) = (Subarrays with oddCnt <= k) - (Subarrays with oddCnt < k)
        return lessThanEqualToKCnt - lessThanKCnt;

    }
}


// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
        
//         // To store , key : no. of odd numbers till index
//         //            value : no. of subarrays with same count of odd numbers
//         HashMap<Integer , Integer> map = new HashMap<>();

//         int oddCount = 0 , ans = 0;

//         // Base case if oddCount == k
//         map.put(0 , 1);

//         for(int i=0 ; i<nums.length ; i++){

//             if(nums[i] % 2 == 1) oddCount++;

//             // Required subarray
//             int diff = oddCount - k;

//             if(map.containsKey(diff)){
//                 ans += map.get(diff);
//             }

//             // Putting no. of subarrays with same no. of oddCount
//             map.put(oddCount , map.getOrDefault(oddCount , 0) + 1);
//         }

//         return ans;
//     }
// }