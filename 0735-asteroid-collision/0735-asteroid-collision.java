class Solution {

    void solve(Stack<Integer> stack , int ast){
        // Empty
        if(stack.isEmpty()) stack.push(ast);

        // <-o <-o OR o-> o->
        else if((stack.peek() > 0 && ast > 0) || (stack.peek() < 0 && ast < 0)) stack.push(ast);

        // <-o o->
        else if(stack.peek() < 0 && ast > 0) stack.push(ast);

        // o-> <-o
        else if(stack.peek() > 0 && ast < 0){
            int top = Math.abs(stack.peek());
            int astt = Math.abs(ast);

            // o-> (<-o)Weak
            if(top > astt) return;

            // Equal size , both destryoed 
            else if(top == astt) stack.pop();
            
            // Weak(o->) <-o 
            // Destroy all the asteroids to the left that are weaker than ast
            else{
                stack.pop();
                solve(stack , ast);
            }
        }

    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            solve(stack, ast);
        }

        int[] res = new int[stack.size()];

        for(int i=stack.size()-1 ; i>=0 ; i--){
            res[i] = stack.pop();
        }

        return res;
    }
}