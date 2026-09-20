class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet();

        backtrack(set , new StringBuilder() , tiles , tiles.length() , 0);

        return set.size();
    }

    void backtrack(Set<String> set , StringBuilder res , String tiles , int n , int ind){

        if(ind == n){

            if(res.length() == 0) return;

            // Add all permutations of res to set
            if(!set.contains(res.toString())){
                boolean[] used = new boolean[res.length()];
                permute(set , res.toString() , new StringBuilder() , used , res.length() , 0);
            }
            
            set.add(res.toString());

            return;
        }

        for(int i=ind ; i<n ; i++){
            res.append(tiles.charAt(i));

            backtrack(set , res , tiles , n , i+1);

            res.deleteCharAt(res.length()-1);
            
            backtrack(set , res , tiles , n , i+1);
        } 
    }

    void permute(Set<String> set , String s , StringBuilder curr , boolean[] used , int n , int ind){

        if(curr.length() == s.length()){
            set.add(curr.toString());

            return;
        }

        for(int i=0 ; i<n ; i++){
            if(!used[i]){
                used[i] = true;
                curr.append(s.charAt(i));

                permute(set , s , curr , used , n , i+1);

                // backtrack
                used[i] = false;
                curr.deleteCharAt(curr.length()-1);
            }
        }
    }
}