class Pair{
    int price;
    int prevSpan;

    Pair(int p , int ps){
        this.price = p;
        this.prevSpan = ps;
    }
}

class StockSpanner {
    Stack<Pair> stack = new Stack<>();

    public StockSpanner() {

    }
    
    public int next(int price) {
        int currSpan = 1;
        
        while(!stack.isEmpty() && stack.peek().price <= price){
            currSpan += stack.peek().prevSpan;
            stack.pop();
        }

        // Store a Pair in an array
        // First - Price of current stock
        // Second - Span for current stock
        stack.push(new Pair(price , currSpan));

        return currSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */