class Solution {

    int countSubarrays(int[] nums , int[] freq , int totalDistinct){

        int n = nums.length , currDistinct = 0;
        int left = 0 , right = 0 , cnt = 0 ;

        while(right < n){

            freq[nums[right]]++;

            if(freq[nums[right]] == 1) currDistinct++;

            while(left <= right && currDistinct == totalDistinct){
                freq[nums[left]]--;

                if(freq[nums[left]] == 0) currDistinct--;

                cnt += (n - right);

                left++;
            }

            right++;
        }

        return cnt;
    }

    public int countCompleteSubarrays(int[] nums) {
        int[] freq = new int[2001];

        for(int val : nums) {
            freq[val]++;
        }

        int totalDistinct = 0;

        for(int i=0 ; i<2001 ; i++){
            if(freq[i] > 0){
                freq[i] = 0;
                totalDistinct++;
            }
        }

        return countSubarrays(nums , freq , totalDistinct);
        
    }
}