class Solution {
    
    public int countRotations(String s, int k) {
        int score = 0 , n = s.length();

        StringBuilder res = new StringBuilder(s);
        
        for(int i=0 ; i<n ; i++){

            int currScore = 0;

            for(int j=0 ; j<n - 1 ; j++){
                if(res.charAt(j) == res.charAt(j+1)) currScore++;
            }

            if(currScore == k) score++;

            // Rotate by one position
            res.append(res.charAt(0));
            res.deleteCharAt(0);

        }

        return score;
    }
}