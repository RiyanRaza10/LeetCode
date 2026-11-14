class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1 ; i>=0 ; i--){
            int nextSmaller = 0;
            
            // Remove smaller than curr , as they won't be visible to the upcoming(left ones to curr)
            while(!st.isEmpty() && st.peek() < heights[i]){
                nextSmaller++;
                st.pop();
            }

            // To greater to the right , return nextSmaller
            if(st.isEmpty()) res[i] = nextSmaller;

            // Height of st.peek() is greater , no one will be visible after that
            // So no. of people visible = (the one at the top of stack) + (all smaller that are removed for curr)
            else if(st.peek() > heights[i]) res[i] = nextSmaller + 1;

            // Push curr
            st.push(heights[i]);
        }

        return res;
    }
}