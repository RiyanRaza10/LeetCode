class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0 ; i<n ; i++) dq.offerLast(i);

        for(int i=n-1 ; i>=0 ; i--){
            while(!dq.isEmpty() && nums[dq.peekFirst()] <= nums[i]) dq.pop();

            res[i] = dq.isEmpty() ? -1 : nums[dq.peekFirst()];
            dq.push(i);
        }   

        return res;
    }
}