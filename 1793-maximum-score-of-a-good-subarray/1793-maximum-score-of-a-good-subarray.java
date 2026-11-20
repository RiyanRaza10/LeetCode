class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int maxScore = nums[k];

        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];
        int[] nse = new int[n];

        // Compute pse for each element
        for(int i=0 ; i<n ; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Compute nse for each element
        for(int i=n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Calculate score , if k lies strictly between nse[i] and pse[i]
        for(int i=0 ; i<n ; i++){

            // Index k is included
            if(pse[i] < k && nse[i] > k){
                int currScore = (nse[i] - pse[i] - 1) * nums[i];

                maxScore = Math.max(maxScore , currScore);
            }
        }

        return maxScore;
    }
}