class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();

        int totalValidParen = 0 , op = 0 , cl = 0 , totalLetters = 0;

        // Precomputing how many valid pairs of parentheses exist in s
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '(') op++;
            else if(ch == ')'){
                if(cl < op) cl++;

                else continue;
            }
            else totalLetters++;

            totalValidParen = Math.max(Math.min(op , cl) , totalValidParen);
        }

        solve(ans , s , new StringBuilder() , totalValidParen , totalLetters , 0 , 0 , 0 , 0);

        // No valid combination found , return empty string in a list
        if(ans.size() == 0) ans.add("");

        return new ArrayList(ans);
    }

    void solve(Set<String> ans , String s , StringBuilder curr , int totalValidParen , int totalLetters , int open , int close , int currLetters , int ind){

        // Invalid Combo
        if(close > open || open > totalValidParen) return;

        // Reached end of string
        if(ind == s.length()){
        
            // Valid Combination
            if(open == close && open == totalValidParen && currLetters == totalLetters) ans.add(curr.toString());

            return;
        }

        char ch = s.charAt(ind);

        // Pick
        curr.append(ch);

        if(ch == '(') open++;
        else if(ch == ')') close++;
        else currLetters++;

        // Recursive call
        solve(ans , s , curr , totalValidParen , totalLetters , open , close , currLetters , ind+1);

        // Backtrack
        curr.deleteCharAt(curr.length()-1);

        if(ch == '(') open--;
        else if(ch == ')') close--;
        else currLetters--;

        // Not pick this current character , call next
        solve(ans , s , curr , totalValidParen , totalLetters , open , close , currLetters , ind+1);
            
    }
}