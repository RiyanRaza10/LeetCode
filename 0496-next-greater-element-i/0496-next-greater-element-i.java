class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0 ; i<nums1.length ; i++) map.put(nums1[i] , i);

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums1.length];

        for(int i=nums2.length-1 ; i>=0 ; i--){
            int curr = nums2[i];

            // Remove elements from the top of stack which are smaller than curr
            while(!stack.isEmpty() && stack.peek() < curr) stack.pop();

            if(map.containsKey(curr)){
                ans[map.get(curr)] = stack.isEmpty() ? -1 : stack.peek();
            }

            // Push curr
            stack.push(curr);
        }

        return ans;
    }
}