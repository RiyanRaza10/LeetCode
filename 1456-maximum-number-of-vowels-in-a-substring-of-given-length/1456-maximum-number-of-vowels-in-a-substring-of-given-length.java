class Solution {

    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }

    public int maxVowels(String s, int k) {
        int max_len = 0 , curr = 0 ;
        
        // Checking initial window me kitne vowel hai
        for(int i=0 ; i<k ; i++){
            if(isVowel(s.charAt(i))) curr++;
        }

        int left = 0 , right = k;

        max_len = curr;

        while(right < s.length()){
            
            // Check if Peechhe Chhoota character vowel hai ya ni
            if(isVowel(s.charAt(left))) curr--;

            // Check if agla character vowel hai ya ni
            if(isVowel(s.charAt(right))) curr++;

            max_len = Math.max(max_len , curr);

            left++;
            right++;
        }

        return max_len;
    }
}