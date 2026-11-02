class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int med = 0 , n = nums.length , steps = 0;

        if(n%2 == 1) med = nums[n/2];
        else med = (nums[n/2] + nums[n/2 - 1])/2;

        for(int val : nums) steps += Math.abs(val-med);

        return steps;
    }
}