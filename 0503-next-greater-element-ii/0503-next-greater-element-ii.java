class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();

        // Push all the indexes int dq , to be used as circular elements
        for(int i=0 ; i<nums.length ; i++) dq.offerLast(i);

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];

        for(int i=nums.length-1 ; i>=0 ; i--){
            int curr = nums[i];

            // Remove current element , so it cannot be used further
            if(!dq.isEmpty() && dq.peekLast() == i) dq.pollLast();

            // Remove elements from the top of stack , which are <= curr
            while(!stack.isEmpty() && stack.peek() <= curr) stack.pop();

            // If nextGreater exists from right , return from stack
            if(!stack.isEmpty()) res[i] = stack.peek();
            
            // Use circular property and get next greater from the start
            else{
                while(!dq.isEmpty() && nums[dq.peekFirst()] <= curr) dq.pollFirst();

                res[i] = dq.isEmpty() ? -1 : nums[dq.peekFirst()];
            }

            // Push curr into stack
            stack.push(curr);
        }

        return res;
    }
}