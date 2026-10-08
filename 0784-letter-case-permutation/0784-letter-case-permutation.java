class Solution {
    public List<String> letterCasePermutation(String s) {
        // Key Idea : For each character u have 2 choices , either pick it or not pick it
        //          if it is letter first pick its lowercase then not pick it
        //          then pick its uppercase then not pick it
        List<String> ans = new ArrayList<>();

        backtrack(ans , new StringBuilder() , s , 0);

        return ans;
    }

    void backtrack(List<String> ans , StringBuilder curr , String s , int ind){
        
        // Reached last
        if(ind == s.length()){
            if(curr.length() == s.length()) ans.add(curr.toString());

            return;
        }

        char ch = s.charAt(ind);

        if(Character.isDigit(ch)){
            // Pick this digit
            curr.append(ch);

            backtrack(ans , curr , s , ind+1);

            // not pick this digit
            curr.deleteCharAt(curr.length()-1);
        }

        else{
            // Pick lower case
            curr.append(Character.toLowerCase(ch));

            backtrack(ans , curr , s , ind+1);

            // not pick lower case
            curr.deleteCharAt(curr.length()-1);

            // Pick upper case
            curr.append(Character.toUpperCase(ch));

            backtrack(ans , curr , s , ind+1);

            // not pick upper case
            curr.deleteCharAt(curr.length()-1);
        }
    }
}