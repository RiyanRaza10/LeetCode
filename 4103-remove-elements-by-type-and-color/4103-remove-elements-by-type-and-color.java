class Pair{
    int type;
    int color;
    int prevSize; // No of elements with same config including curr
    Pair(int t , int c , int ps){
        this.type = t;
        this.color = c;
        this.prevSize = ps;
    }
}

class Solution {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        int n = types.length;
        Stack<Pair> st = new Stack<>();

        for(int i=0 ; i<n ; i++){
            if(st.isEmpty()){
                st.push(new Pair(types[i] , colors[i] , 1));
            }
            else{
                int currSize = 1 + ((st.peek().type == types[i] && st.peek().color == colors[i]) ? st.peek().prevSize : 0);
                st.push(new Pair(types[i] , colors[i] , currSize));
            }

            // Maintain stack
            while(!st.isEmpty() && st.peek().prevSize >= groupSize[st.peek().type]){
                int grpToRmv = groupSize[st.peek().type];

                // Remove a group of size grpToRmv
                for(int j=0 ; j<grpToRmv ; j++) st.pop();
            }
        }

        return st.isEmpty();
    }
}