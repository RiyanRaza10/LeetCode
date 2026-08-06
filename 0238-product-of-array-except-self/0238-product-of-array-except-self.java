class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] pref = new int[n] , suff = new int[n];
        
        // Prefix product
        pref[0] = 1;
        
        for(int i=1 ; i<n ; i++){
            pref[i] = nums[i-1] * pref[i-1];
        }

        // Suffix product
        suff[n-1] = 1;
        
        for(int i=n-2 ; i>=0 ; i--){
            suff[i] = nums[i+1] * suff[i+1];
        }

        // nums[i] = pref[i] * suff[i]
        for(int i=0 ; i<n ; i++){
            nums[i] = pref[i] * suff[i];
        }

        return nums;
    }
}