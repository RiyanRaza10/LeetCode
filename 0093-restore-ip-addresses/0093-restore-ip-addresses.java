class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> restored = new ArrayList<>();

        generate(restored , new ArrayList<>() , s , 0);

        return restored;
    }

    void generate(List<String> restored , List<String> currCombination , String s , int ind){
        
        // Too much partitions , go back
        if(currCombination.size() > 4) return;

        // Partitioned till end , could be a valid IP
        if(ind == s.length()){

            // Less than 4 partitions , invalid
            if(currCombination.size() < 4) return;

            // Converting currCombination to a valid IP in string
            StringBuilder res = new StringBuilder();

            for(int i=0 ; i<currCombination.size() ; i++){
                res.append(currCombination.get(i));

                if(i != currCombination.size()-1) res.append(".");;
            }

            // Valid IP address found , add it to restored
            restored.add(res.toString());

            return;
        }

        for(int i=ind ; i<s.length() ; i++){

            // Check if s.substring(ind , i+1) is a valid partition
            if(isValid(s , ind , i)){
                currCombination.add(s.substring(ind , i+1));

                // Recursive call
                generate(restored , currCombination , s , i+1);

                // Backtrack
                currCombination.removeLast();
            }
        }
    }

    boolean isValid(String s , int start , int end){
        boolean leadingZero = false;
        if(s.charAt(start) == '0') leadingZero = true;

        int num = 0;

        for(int i=start ; i <= end ; i++){
            num = num*10 + (s.charAt(i) - '0');

            if(num > 255) return false; // Out of range
        }

        // If leadingZero is present , return true only if num == 0 && substring is "0" {"00" is invalid}
        // coz leading zero is only allowed if whole num is zero
        if(leadingZero) return (num == 0 && end - start + 1 == 1);
        
        return num <= 255;
    }
}