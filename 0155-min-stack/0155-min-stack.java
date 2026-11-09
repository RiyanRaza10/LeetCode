class MinStack {

    List<Integer> st = new ArrayList<>();
    List<Integer> min = new ArrayList<>();

    public MinStack() {
        
    }
    
    public void push(int value) {
        st.add(value);

        // Check if current value is less than minLast
        if(min.isEmpty() || min.getLast() >= value) min.add(value);
    }
    
    public void pop() {
        int top = st.getLast();
        st.removeLast();

        // If minValue is top value of st , removeLast min
        if(top == min.getLast()) min.removeLast();
    }
    
    public int top() {
        return st.getLast();
    }
    
    public int getMin() {
        return min.getLast();
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