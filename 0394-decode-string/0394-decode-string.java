class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == '['){
                if(res.length() != 0) st.push(res.toString()); // Push curr String
                if(num != 0) st.push(num+""); // push freq if any
                st.push("[");

                // re-initialise
                res = new StringBuilder();
                num = 0;
            }

            else if(ch == ']'){
                st.pop(); // Remove open for curr

                // Solve to the left
                while(!st.isEmpty() && !st.peek().equals("[")){
                    
                    // If prev pushed is frequency / integer
                    if(Character.isDigit(st.peek().charAt(0))){
                        int freq = Integer.parseInt(st.pop()); // freq to repeat
                        String curr = res.toString(); // curr string
                        res = new StringBuilder(); // Reinitialise

                        for(int fr=0 ; fr<freq ; fr++) res.append(curr); // Update res
                    }

                    // If prev pushed was string
                    else{
                        String curr = res.toString();
                        String prev = st.pop();
                        res = new StringBuilder(prev);
                        res.append(curr);
                    }
                }
            }

            // digit
            else if(Character.isDigit(ch)){
                if(res.length() != 0){ // push and re-initialise
                    st.push(res.toString());
                    res = new StringBuilder();
                }
                num = num*10 + (ch - '0');
            }

            // letter
            else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}