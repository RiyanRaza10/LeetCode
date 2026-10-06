class Solution {
    public int minAddToMakeValid(String s) {
        int minAdd = 0 , open = 0;

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == '('){
                open++;
            }

            else{
                // Add an open paren atp
                if(open == 0){
                    minAdd++;
                    continue;
                }

                // Decrement open
                open--;
            }
        }

        return minAdd + open;
    }
}