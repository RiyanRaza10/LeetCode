class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0 ; i<n ; i++){

            // Remove indexes out of window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.pollFirst();

            // Remove elem that are smaller than currElem as they can never be maximum
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.offerLast(i);

            if(i >= k-1){
                res[i-k+1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}