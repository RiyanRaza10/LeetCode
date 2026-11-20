class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int n = nums.length;
        int lb = -1 , ub = n;

        for(int i=0 ; i<n ; i++){
            if(nums[i] != sorted[i]) {
                lb = i;
                break;
            }
        }

        if(lb == -1) return 0;

        for(int i=n-1 ; i>=0 ; i--){
            if(nums[i] != sorted[i]) {
                ub = i;
                break;
            }
        }

        return ub - lb + 1;
    }
}