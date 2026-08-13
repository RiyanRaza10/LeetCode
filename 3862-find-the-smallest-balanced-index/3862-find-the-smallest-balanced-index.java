class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;

        long[] prod = new long[n];

        // For Overflow
        long max = (long)1e14;

        prod[n-1] = 1;

        for(int i=n-2 ; i>=0 ; i--){
            
            // Overflow step { if prod[i] > Long.MAX_VALUE , then do not multiply else assign prod[i] = 1e14 + 1}
            if(prod[i+1] > max/nums[i+1]) prod[i] = max+1;

            else
            prod[i] = nums[i+1] * prod[i+1]; 
        } 

        long sum = 0;

        for(int i=1 ; i<n ; i++){
            sum += nums[i-1];

            // Balanced Index
            if(sum == prod[i]) {
                return i;
            }

        }

        return -1;
    }
}