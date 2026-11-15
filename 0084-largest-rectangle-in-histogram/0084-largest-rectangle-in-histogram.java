class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];

        // Compute pse's index for each height
        for(int i=0 ; i<n ; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        int[] nse = new int[n];

        // Compute nse's index for each height
        for(int i=n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Calculate area for each height , and track max
        for(int i=0 ; i<n ; i++){
            int currArea = (nse[i] - pse[i] - 1) * heights[i];

            maxArea = Math.max(maxArea , currArea);
        }

        return maxArea;
    }
}