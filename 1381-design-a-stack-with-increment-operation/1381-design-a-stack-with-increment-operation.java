class CustomStack {
    Deque<Integer> dq = new ArrayDeque<>();
    int mSize;
    
    public CustomStack(int maxSize) {
        mSize = maxSize;
    }
    
    public void push(int x) {
        if(dq.size() < mSize) dq.offerLast(x);
    }
    
    public int pop() {
        return dq.isEmpty() ? -1 : dq.pollLast();
    }
    
    public void increment(int k, int val) {
        Stack<Integer> st = new Stack<>();

        int maxOp = Math.min(k , dq.size());
        for(int i=0 ; i<maxOp ; i++){
            st.add(dq.pollFirst() + val);
        }

        while(!st.isEmpty()) dq.offerFirst(st.pop());
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */