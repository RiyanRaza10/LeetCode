class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0] , moves = 0;

        for(int val : nums) max = Math.max(max , val);

        for(int val : nums) moves += max - val;

        return moves;
    }
}