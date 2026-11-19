class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        int ind = 0;

        for(int i=1 ; i<=n ; i++){
            list.add("Push");
            st.push(i);

            if(st.peek() != target[ind]){
                st.pop();
                list.add("Pop");
            }
            else ind++;

            if(ind == target.length) break;
        }

        return list;
    }
}