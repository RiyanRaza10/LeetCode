class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> res = new ArrayList<>();

        Stack<Long> st = new Stack<>();

        for(int i=0 ; i<nums.length ; i++){
            long curr = nums[i];

            while(!st.isEmpty() && st.peek() == curr){
                curr = (long)curr + st.pop();
            }

            st.push((long)curr);
        }

        while(!st.isEmpty()) res.add(st.pop());

        Collections.reverse(res);

        return res;
    }
}