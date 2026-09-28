class Solution {
    public int maxDepth(String s) {
        int paren = 0 , maxDepth = 0 ;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                paren++;
                maxDepth = Math.max(paren , maxDepth);
            }
            else if(ch == ')'){
                paren--;
            }
        }

        return maxDepth;
    }
}