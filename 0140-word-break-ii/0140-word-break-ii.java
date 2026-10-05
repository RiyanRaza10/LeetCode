class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        HashMap<String , Integer> map = new HashMap<>();

        for(String word : wordDict) map.put(word , 0);

        solve(ans , s , map , new ArrayList() , 0);

        return ans;
    }

    void solve(List<String> ans , String s , HashMap<String , Integer> map , List<String> curr , int ind){

        // Partitioned s till last
        if(ind == s.length()){

            // Convert curr to String
            StringBuilder res = new StringBuilder();

            for(int i=0 ; i<curr.size() ; i++){
                res.append(curr.get(i));

                if(i != curr.size()-1) res.append(" ");
            }

            ans.add(res.toString());

            return;
        }

        for(int i=ind ; i<s.length() ; i++){
            String sub = s.substring(ind , i+1);

            if(map.containsKey(sub)){
                curr.add(sub);

                // Recursive call
                solve(ans , s , map , curr , i+1);

                // backtrack
                curr.remove(curr.size()-1);
            }
        }
    }
}