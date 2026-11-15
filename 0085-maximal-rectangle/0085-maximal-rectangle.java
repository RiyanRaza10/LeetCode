class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        int maxArea = 0;

        // Height of 1s in each row
        int[] rowHt = new int[n];
        int[] pse = new int[n];
        int[] nse = new int[n];

        for(int row=0 ; row<m ; row++){

            // Computing height of 1s in this row
            for(int col=0 ; col<n ; col++){
                if(matrix[row][col] == '0') rowHt[col] = 0;
                else rowHt[col] += 1; 
            }

            Stack<Integer> st = new Stack<>();

            // pse's index for each rowHt[ind]
            for(int ind=0 ; ind<n ; ind++){
                int currHt = rowHt[ind];
                while(!st.isEmpty() && rowHt[st.peek()] >= currHt) st.pop();

                pse[ind] = st.isEmpty() ? -1 : st.peek();
                st.push(ind);
            }

            st.clear();
            
            // nse's index for each rowHt[ind]
            for(int ind=n-1 ; ind>=0 ; ind--){
                int currHt = rowHt[ind];
                while(!st.isEmpty() && rowHt[st.peek()] >= currHt) st.pop();

                nse[ind] = st.isEmpty() ? n : st.peek();
                st.push(ind);
            }

            // Compute maximum area rectangle for each rowHt[ind]
            for(int ind=0 ; ind<n ; ind++){
                int currArea = (nse[ind] - pse[ind] - 1) * rowHt[ind];

                maxArea = Math.max(maxArea , currArea);
            }
        }

        return maxArea;
    }
}