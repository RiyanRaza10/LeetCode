class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> all = new ArrayList<>();

        backtrack(all , new StringBuilder() , n , 0 , 0);

        return all;
    }

    void backtrack(List<String> all , StringBuilder curr , int n , int open , int closed){

        // Ivalid combination
        if(closed > open || open > n || closed > n) return;

        // Possible valid combination
        if(curr.length() == 2*n){

            // Valid combination found
            if(open == n && closed == n) all.add(curr.toString());

            return;
        }

        // Starting of string , add open
        if(open == 0){
            curr.append("(");
            backtrack(all , curr , n , open+1 , closed);
        }

        // Append open paren
        if(open < n){
            curr.append("(");
            backtrack(all , curr , n , open+1 , closed);

            curr.deleteCharAt(curr.length()-1);
        }

        // Append closed paren
        if(closed < n){
            curr.append(")");
            backtrack(all , curr , n , open , closed+1);

            curr.deleteCharAt(curr.length()-1);
        }


    }
}