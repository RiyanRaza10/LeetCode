class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length , n = matrix[0].length , maxArea = 0;

        // To keep track of height of '1's for each row
        int[] rowHt = new int[n];

        for(int row=0 ; row<m ; row++){

            // Compute height of '1's for curr row
            for(int col=0 ; col<n ; col++){
                if(matrix[row][col] == '0') rowHt[col] = 0;
                else rowHt[col] += 1;
            }

            Stack<Integer> st = new Stack<>();
            
            // Compute pse's index for each element
            int[] pse = new int[n];
            for(int ind=0 ; ind<n ; ind++){
                int curr = rowHt[ind];

                while(!st.isEmpty() && rowHt[st.peek()] >= curr) st.pop();

                pse[ind] = st.isEmpty() ? -1 : st.peek();
                st.push(ind);
            }

            st.clear();
            
            // Compute nse's index for each element
            int[] nse = new int[n];
            for(int ind=n-1 ; ind>=0 ; ind--){
                int curr = rowHt[ind];

                while(!st.isEmpty() && rowHt[st.peek()] >= curr) st.pop();
                
                nse[ind] = st.isEmpty() ? n : st.peek();
                st.push(ind);
            }

            // Compute maxSquare
            for(int ind=0 ; ind<n ; ind++){
                int currHt = rowHt[ind];
                int currExpansion = (nse[ind] - pse[ind] - 1);

                // Check if square of height currHt , can be formed
                // Check if we can expand currHt , to form a square of height currHt
                if(currExpansion >= currHt) maxArea = Math.max(maxArea , currHt*currHt);
            }
        }

        return maxArea;
    }
}