class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0 , j = 0;
        long sum1 = 0 , sum2 = 0 , maxSum = 0 , MOD = (long)1e9 + 7;

        while(i < nums1.length && j < nums2.length){

            while(i < nums1.length && j < nums2.length && nums1[i] <= nums2[j]){
                
                // found common element , track maximum path
                if(nums1[i] == nums2[j]){
                    maxSum += Math.max(sum1 , sum2) % MOD;
                    sum1 = 0;
                    sum2 = 0;
                }

                sum1 += nums1[i];
                i++;
            }

            while(j < nums2.length && i < nums1.length && nums2[j] <= nums1[i]){
                
                // found common element , track maximum path
                if(nums1[i] == nums2[j]){
                    maxSum += Math.max(sum1 , sum2) % MOD;
                    sum1 = 0;
                    sum2 = 0;
                }
                
                sum2 += nums2[j];
                j++;
            }
        }

        // Bacha hua part of nums1
        while(i < nums1.length) sum1 += nums1[i++];

        // Bacha hua part of nums2
        while(j < nums2.length) sum2 += nums2[j++];

        maxSum += Math.max(sum1 , sum2) % MOD;

        return (int)(maxSum % MOD);

    }
}