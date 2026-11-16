class Solution {
    public int calculate(String s) {
        Stack<String> st = new Stack<>();
        int res = 0;

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == ' ') continue;

            else if(ch == '+' || ch == '-'){
                
                if(!st.isEmpty() && (st.peek().equals("+") || st.peek().equals("-"))){
                    char prevSign = st.pop().charAt(0);

                    if(prevSign == '-'){
                        if(st.isEmpty() || st.peek().equals("(")){ // Check if unary subtraction (-(2+3))
                            res = res * (-1);
                        }
                        else{
                            int prev = Integer.parseInt(st.pop());
                            res = prev - res;
                        }
                        
                    }
                    else{
                        int prev = Integer.parseInt(st.pop());

                        if(prevSign == '+') res += prev;
                        else res = prev - res;
                    }
                }

                st.push(res+"");
                res = 0;
                st.push(ch+"");
            }

            else if(ch == '('){
                st.push("(");
                res = 0;
            }
            
            else if(ch == ')'){

                // Evaluate upto current open
                if(st.peek().equals("+")){
                    st.pop();
                    int prev = Integer.parseInt(st.pop());
                    res += prev;
                }
                else if(st.peek().equals("-")){
                    st.pop();
                    int prev = Integer.parseInt(st.pop());
                    res = prev - res;
                }

                // Remove curr open
                if(!st.isEmpty() && st.peek().equals("(")) st.pop();

                // Solve upto prev open
                while(!st.isEmpty() && !st.peek().equals("(")){
                    char prevSign = st.pop().charAt(0);

                    if(prevSign == '+'){
                        int prev = Integer.parseInt(st.pop());

                        res += prev;
                    }
                    else if(prevSign == '-'){
                        if(st.isEmpty() || st.peek().equals("(")){
                            res = res * (-1);
                        }
                        else{
                            int prev = Integer.parseInt(st.pop());
                            res = prev - res;
                        }
                        
                    }
                }
            }

            // digit
            else{
                res = res*10 + (ch - '0');
            }
        }

        // Evaluate bacha hua expression without brackets
        while(!st.isEmpty() && (st.peek().equals("+") || st.peek().equals("-"))){
            char prevSign = st.pop().charAt(0);

            if(prevSign == '+'){
                int prev = Integer.parseInt(st.pop());
                res += prev;
            }

            else if(prevSign == '-'){
                if(st.isEmpty() || st.peek().equals("(")){ // Unary subtraction
                    res = res * (-1);
                }
                else{
                    int prev = Integer.parseInt(st.pop());
                    res = prev - res;
                }
            }
        }
        
        return res;
    }
}