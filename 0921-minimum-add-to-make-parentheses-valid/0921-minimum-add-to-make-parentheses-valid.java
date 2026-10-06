class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        int minAdd = 0;

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == '(') stack.push(')');

            else{
                if(stack.isEmpty()){
                    minAdd++;
                    continue;
                }

                stack.pop();
            }
        }

        return minAdd + stack.size();
    }
}