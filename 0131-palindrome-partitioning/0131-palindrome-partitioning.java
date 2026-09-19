class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> validPartitions = new ArrayList<>();

        generate(validPartitions , new ArrayList<>() , s , 0);

        return validPartitions;
    }

    void generate(List<List<String>> validPartitions , List<String> currCombination , String s , int ind){

        // Partitioned till last , valid partition
        if(ind == s.length()){
            validPartitions.add(new ArrayList<>(currCombination));

            return;
        }

        for(int i=ind ; i<s.length() ; i++){

            // Check if s.substring(ind , i+1) is palindrome , so we can continue further partitioning
            if(isPalindrome(s , ind , i)){
                currCombination.add(s.substring(ind , i+1));

                // Recursive call
                generate(validPartitions , currCombination , s , i+1);

                // Backtrack
                currCombination.removeLast();
            }
        }
    }

    boolean isPalindrome(String s , int start , int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}