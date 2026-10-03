class Solution {
    public int maxLength(List<String> arr) {
        int[] maxLen = new int[]{0};
        int[] letterFreq = new int[26];

        solve(arr , letterFreq , maxLen , 0 , 0);

        return maxLen[0];
    }

    void solve(List<String> words , int[] letterFreq , int[] maxLen , int currLen , int ind){

        for(int i=ind ; i<words.size() ; i++){

            // Check if letters of current word are unused
            if(canPick(words.get(i) , letterFreq)){

                // Pick
                for(int j=0 ; j<words.get(i).length() ; j++){
                    char ch = words.get(i).charAt(j);
                    letterFreq[ch - 'a']++;
                }

                currLen += words.get(i).length();
                maxLen[0] = Math.max(maxLen[0] , currLen);

                // Recursive call to next word
                solve(words , letterFreq , maxLen , currLen , i+1);

                // Not pick / Backtrack
                for(int j=0 ; j<words.get(i).length() ; j++){
                    char ch = words.get(i).charAt(j);
                    letterFreq[ch - 'a']--;
                }
                currLen -= words.get(i).length();
                
            }
        }
    }

    boolean canPick(String s , int[] letterFreq){
        int[] freq = new int[26];

        // Check if current word contains duplicate letters
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;

            if(freq[ch - 'a'] > 1) return false;
        }
        
        // Check if any letter in s already exists in letterFreq
        for(int i=0 ; i<s.length() ; i++){
            if(letterFreq[s.charAt(i) - 'a'] != 0) return false;
        }

        return true;
    }
}