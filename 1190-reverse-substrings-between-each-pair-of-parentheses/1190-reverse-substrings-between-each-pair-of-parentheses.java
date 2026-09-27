class Solution {
    public String reverseParentheses(String s) {
        StringBuilder res = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == '(' ) stack.push(ch);
            
            // Time to reverse hehee
            else if(ch == ')'){
                // Take out characters until '('
                while(stack.peek() != '('){
                    res.append(stack.pop());
                }

                // Remove last opening bracket
                stack.pop();

                // Push reversed string into stack
                for(int j=0 ; j<res.length() ; j++){
                    stack.push(res.charAt(j));
                }

                // Re-initialise
                res = new StringBuilder();
            }

            else stack.push(ch);

        }

        // Re-initialise to store ans
        res = new StringBuilder();

        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
    
        return res.reverse().toString();
        
    }
}