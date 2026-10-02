class Solution {
    public int maxUniqueSplit(String s) {
        // To track maximum substrings
        int[] maxSub = new int[]{0};

        backtrack(new ArrayList<>() , s , maxSub , 0);

        return maxSub[0];
    }

    void backtrack(List<String> list , String s , int[] maxSub , int ind){

        // Partitioned s till last , compare maxSub
        if(ind == s.length()){
            maxSub[0] = Math.max(maxSub[0] , list.size());

            return;
        }

        for(int i=ind ; i<s.length() ; i++){

            // Check if this substring is un-used
            if(!list.contains(s.substring(ind , i+1))){

                // Pick
                list.add(s.substring(ind , i+1));

                // Recursive call
                backtrack(list , s , maxSub , i+1);

                // Backtrack
                list.remove(list.size()-1);
            }
        }
    }
}