class Solution {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        int n = types.length;

        // To store {types[i] , colors[i] , prevSizeIncluding of same elements including curr of same property}
        Stack<int[]> st = new Stack<>();

        for(int i=0 ; i<n ; i++){
            if(st.isEmpty()){
                st.push(new int[]{types[i] , colors[i] , 1});
            }
            else{
                int currSize = 1 + ((st.peek()[0] == types[i] && st.peek()[1] == colors[i]) ? st.peek()[2] : 0);
                st.push(new int[]{types[i] , colors[i] , currSize});
            }

            // Maintain stack
            while(!st.isEmpty() && st.peek()[2] >= groupSize[st.peek()[0]]){
                int grpToRmv = groupSize[st.peek()[0]];

                // Remove a group of size grpToRmv
                for(int j=0 ; j<grpToRmv ; j++) st.pop();
            }
        }

        return st.isEmpty();
    }
}