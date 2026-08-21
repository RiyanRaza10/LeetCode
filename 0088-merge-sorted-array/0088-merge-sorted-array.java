class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int ind = m + n -1 ;

        m--;
        n--;

        // Merge both sorted arrays
        while(m >= 0 && n >= 0){

            if(nums1[m] >= nums2[n]){
                nums1[ind--] = nums1[m--];
            }
            else nums1[ind--] = nums2[n--];
            
        }

        while(m >= 0) nums1[ind--] = nums1[m--];

        while(n >= 0) nums1[ind--] = nums2[n--];

    }
}