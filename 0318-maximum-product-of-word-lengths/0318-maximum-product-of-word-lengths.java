class Solution {
    boolean isValid(String s1 , String s2){
        int[] freq = new int[26];
        
        for(int i=0 ; i<s1.length() ; i++){
            char ch = s1.charAt(i);
            freq[ch - 'a']++;
        }

        for(int i=0 ; i<s2.length() ; i++){
            char ch = s2.charAt(i);

            if(freq[ch - 'a'] > 0) return false;
        }

        return true;
    }

    public int maxProduct(String[] words) {
    int maxProd = 0;

    for(int i=0 ; i<words.length ; i++){
        for(int j=i+1; j<words.length ; j++){

            if( isValid(words[i] , words[j])){
                maxProd = Math.max(maxProd , words[i].length() * words[j].length());
            }
        }
    }
    
    return maxProd;

    }
}