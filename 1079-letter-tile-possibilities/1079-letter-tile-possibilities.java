class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> allTiles = new HashSet<>();

        boolean[] used = new boolean[tiles.length()];

        solve(allTiles , new StringBuilder() , tiles , used);

        return allTiles.size();
    }

    void solve(Set<String> allTiles , StringBuilder res , String tiles , boolean[] used){

        for(int i=0 ; i<tiles.length() ; i++){
            if(!used[i]){
                
                // Use current tile / pick
                used[i] = true;
                res.append(tiles.charAt(i));

                // Add every possible tile to set
                allTiles.add(res.toString());

                // Recursive call
                solve(allTiles , res , tiles , used);

                // Backtrack / not pick
                used[i] = false;
                res.deleteCharAt(res.length()-1);
            }
        }
    }
}