class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long currSum = 0 ;

        int[] ans = new int[n];

        Arrays.fill(ans , -1);

        if(k*2 > n) return ans;

        for(int i=0 ; i<2*k ; i++){
            if(i < n) currSum += nums[i];
        }

        int start = 0 , end = 2*k , ind = k;

        while(end < n){
            currSum += nums[end];

            ans[ind] = (int)(currSum / (long)(k*2 + 1));

            currSum -= nums[start];
            
            ind++;
            start++;
            end++;

        }

        return ans;
    }
}