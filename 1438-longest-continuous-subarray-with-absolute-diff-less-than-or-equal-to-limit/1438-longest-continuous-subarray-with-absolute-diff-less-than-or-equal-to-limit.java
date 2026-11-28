class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int left = 0 , right = n , maxLen = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(subExists(nums , limit , mid)){
                left = mid+1;
                maxLen = mid;
            }            
            else right = mid-1;
        }

        return maxLen;
    }

    boolean subExists(int[] nums , int limit , int k){
        // Check if subarray of size k and abs diff <= limits exists

        int n = nums.length;
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();

        for(int i=0 ; i<n ; i++){
            // Maintain maxDq
            while(!maxDq.isEmpty() && maxDq.peekFirst() <= i-k) maxDq.pollFirst();
            while(!maxDq.isEmpty() && nums[maxDq.peekLast()] < nums[i]) maxDq.pollLast();
            maxDq.offerLast(i);

            // Maintain minDq
            while(!minDq.isEmpty() && minDq.peekFirst() <= i-k) minDq.pollFirst();
            while(!minDq.isEmpty() && nums[minDq.peekLast()] > nums[i]) minDq.pollLast();
            minDq.offerLast(i);

            if(i >= k-1){
                if(Math.abs(nums[maxDq.peekFirst()] - nums[minDq.peekFirst()]) <= limit) return true;
            }
        }

        return false;
    }
}