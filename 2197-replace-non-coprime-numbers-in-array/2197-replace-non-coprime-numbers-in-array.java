class Solution {
    int gcd(int x , int y){
        if(y == 0) return x;
        return gcd(y , x%y);
    }

    void solve(Stack<Integer> st , int curr){
        if(st.isEmpty()){
            st.push(curr);
            return;
        }

        int currGcd = gcd(st.peek() , curr);

        // Co-Prime numbers , push curr
        if(currGcd == 1){
            st.push(curr);
        }

        // Non-coprime numbers , compute lcm and solve recursively
        else{
            // Use long to prevent overflow
            int lcm = (int)(((long)st.pop() * curr) / currGcd); // firstNo * secNo = lcm * hcf
            
            // Solve recursively
            solve(st , lcm);
        }
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();

        for(int val : nums){
            solve(st , val);
        }

        List<Integer> res = new ArrayList<>();
        while(!st.isEmpty()) res.add(st.pop());
        Collections.reverse(res);

        return res;
    }
}