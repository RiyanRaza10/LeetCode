class Solution {
    public boolean splitString(String s) {
       return solve(s , new ArrayList<>() , 0);
    }

    boolean solve(String s , List<Long> curr , int ind){
        
        // Partitioned till end
        if(ind == s.length()){

            // Should contain atleast two numbers
            if(curr.size() >= 2) return true;

            return false;
        }
        
        for(int i=ind ; i<s.length() ; i++){

            long currNum = convertToNum(s , ind , i);

            if(currNum == -1234) continue;

            if(curr.size() == 0){
                // Pick
                curr.add(currNum);

                // Recursive call
                if(solve(s , curr , i+1)) return true;

                // Backtrack
                curr.remove(curr.size()-1);
            } 

            else{
                long prevNum = curr.get(curr.size()-1);

                if(currNum == prevNum - 1){
                    // Pick
                    curr.add(currNum);

                    // Recursive call
                    if(solve(s , curr , i+1)) return true;

                    // Backtrack
                    curr.remove(curr.size()-1);
                }
                
            }
        }

        // Cannot partition till end
        return false;
    }

    long convertToNum(String s , int start , int end){
        long num = 0;

        while(start <= end){
            num = num*10 + s.charAt(start) - '0';

            // Overflow
            if(num > 9999999999L) return -1234;

            start++;
        }

        return num;
    }
}