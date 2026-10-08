class Solution {
    public List<List<String>> wordSquares(String[] words) {

        PriorityQueue<List<String>> pq = new PriorityQueue<>((a , b) ->
        {
            // Compare each character
            for(int i=0 ; i<a.size() ; i++){
                int cmp = a.get(i).compareTo(b.get(i));

                if(cmp != 0){
                    return cmp;
                }
            }
            
            return 0;
        });

        int n = words.length;

        boolean[] used = new boolean[n];

        solve(words , pq , used , new ArrayList<>() , n);

        // Returning pq directly in a list doesn't guarantee order
        // so repeatedly poll
        List<List<String>> validSquares = new ArrayList<>();

        while(!pq.isEmpty()){
            validSquares.add(new ArrayList<>(pq.poll()));
        }

        return validSquares;
    }

    void solve(String[] words , PriorityQueue<List<String>> pq , boolean[] used , List<String> curr , int n){
        
        // A valid square formed
        if(curr.size() == 4){
            pq.add(new ArrayList<>(curr));

            return;
        }

        for(int i=0 ; i<words.length ; i++){

            if(!used[i]){
                
                // Check if this word can be used as current side
                if(canPick(curr , words[i] , curr.size())){
                    used[i] = true;
                    curr.add(words[i]);

                    solve(words , pq , used , curr , n);

                    used[i] = false;
                    curr.remove(curr.size()-1);
                }
            }
        }
    }

    boolean canPick(List<String> curr , String s , int ind){

        // Can pick any word as initial
        if(ind == 0){
            return true;
        }

        else if(ind == 1){
            return curr.get(0).charAt(0) == s.charAt(0);
        }

        else if(ind == 2){
            return curr.get(0).charAt(3) == s.charAt(0);
        }

        else if(ind == 3){
            return curr.get(1).charAt(3) == s.charAt(0) && s.charAt(3) == curr.get(2).charAt(3);
        }

        return true;
    }
}