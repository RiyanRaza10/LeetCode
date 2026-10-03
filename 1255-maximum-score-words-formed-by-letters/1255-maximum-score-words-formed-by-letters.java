class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] maxScore = new int[]{0};
        int[] letterFreq = new int[26];

        // Store all the occurrences of letters
        for(char ch : letters) letterFreq[ch - 'a']++;

        solve(words , letterFreq , score , maxScore , 0 , 0);

        return maxScore[0];
    }

    void solve(String[] words , int[] letterFreq , int[] score , int[] maxScore , int currScore , int ind){

        for(int i=ind ; i<words.length ; i++){

            // Check if current word can be formed using letters availaable
            if(canForm(words[i] , letterFreq)){

                // Pick 
                for(int j=0 ; j<words[i].length() ; j++){
                    char ch = words[i].charAt(j);
                    letterFreq[ch - 'a']--;

                    currScore += score[ch - 'a'];
                }

                maxScore[0] = Math.max(maxScore[0] , currScore);

                // Recursive call to next word
                solve(words , letterFreq , score , maxScore , currScore , i+1);

                // Not Pick / Backtrack 
                for(int j=0 ; j<words[i].length() ; j++){
                    char ch = words[i].charAt(j);
                    letterFreq[ch - 'a']++;

                    currScore -= score[ch - 'a'];
                }

            }
        }
    }

    boolean canForm(String s , int[] letterFreq){
        int[] currFreq = new int[26];

        for(int i=0 ; i<s.length() ; i++) currFreq[s.charAt(i) - 'a']++;

        for(int i=0 ; i<26 ; i++){
            if(currFreq[i] > letterFreq[i]) return false;
        }

        return true;
    }
}