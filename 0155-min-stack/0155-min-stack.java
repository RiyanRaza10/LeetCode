class MinStack {
    Stack<int[]> st = new Stack<>(); // {currValue , minTillCurr};

    public MinStack() {
        
    }
    
    public void push(int value) {
        int currMin = value;
        if(!st.isEmpty()) currMin = Math.min(st.peek()[1] , currMin);

        st.push(new int[]{value , currMin});
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */