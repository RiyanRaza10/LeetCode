class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        // In the main loop , whenever there is no nge at right,
        // This will work as the circular array
        for(int i=n-1 ; i>=0 ; i--) stack.push(nums[i]);

        for(int i=n-1 ; i>=0 ; i--){
            int curr = nums[i];

            // Remove smaller/equal elements to the right
            while(!stack.isEmpty() && stack.peek() <= curr) stack.pop();

            res[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push curr elem into stack
            stack.push(curr);    
        }

        return res;
    }
}