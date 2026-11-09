class Pair{
    int first;
    int second;

    Pair(int f , int s){
        this.first = f;
        this.second = s;
    }
}

class MinStack {
    // Store in a Pair where 
    // first value is this last inserted value 
    // second value is the minvalue till that index
    List<Pair> st = new ArrayList<>();

    public MinStack() {
        
    }
    
    public void push(int value) {
        if(st.isEmpty() || st.getLast().second >= value) {
            st.add(new Pair(value , value));
            return;
        }

        // If min till last value is less than current value
        int lastMin = st.getLast().second;
        st.add(new Pair(value , lastMin));
    }
    
    public void pop() {
        st.removeLast();
    }
    
    public int top() {
        return st.getLast().first;
    }
    
    public int getMin() {
        return st.getLast().second;
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