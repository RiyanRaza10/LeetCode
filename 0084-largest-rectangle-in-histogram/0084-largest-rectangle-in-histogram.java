class Pair{
    int val; // height of current bar
    int len; // To store how much we can extend this value (To the right or left) 
    Pair(int v , int i){
        this.val = v;
        this.len = i;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Pair> stack = new Stack<>();

        // To store how much we can extend each bar to the left 
        int[] prevBar = new int[n];

        // Current bar ko left me kitna extend kr sakte h
        // such that height of prevBar >= height of curr bar
        for(int i=0 ; i<n ; i++){
            int prev = 0; // no. of bars that are greater than or equal to current bar's height (To the left)
            int curr = heights[i];

            while(!stack.isEmpty() && stack.peek().val >= curr){
                prev += stack.peek().len + 1;
                stack.pop();
            }

            prevBar[i] = prev;

            stack.push(new Pair(curr , prev));
        }

        stack.clear();

         // To store how much we can extend each bar to the right 
        int[] nextBar = new int[n];

        for(int i=n-1 ; i>=0 ; i--){
            int next = 0; // no. of bars that are greater than or equal to current bar's height (To the right)
            int curr = heights[i];

            while(!stack.isEmpty() && stack.peek().val >= curr){
                next += stack.peek().len + 1;
                stack.pop();
            }

            nextBar[i] = next;

            stack.push(new Pair(curr , next));
        }

        int maxArea = 0;

        // Calculate area for each bar
        // (Left me kitna extend kr sakte h + right me kitna extend kr sakte h) * current height 
        for(int i=0 ; i<n ; i++){
            int currArea = (prevBar[i] + nextBar[i] + 1) * heights[i];

            maxArea = Math.max(maxArea , currArea);
        }

        return maxArea;
    }
}