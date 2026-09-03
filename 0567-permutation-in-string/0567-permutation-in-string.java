class Solution {

    boolean checkPermutation(int[] freqS1 , int[] freqS2){
        for(int i=0 ; i<26 ; i++){
            if(freqS1[i] != freqS2[i]) return false;
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        // No possible permutation of s1 can ezist in s2
        if(s2.length() < s1.length()) return false;

        int[] freqS1 = new int[26] , freqS2 = new int[26];

        for(char ch : s1.toCharArray()) freqS1[ch - 'a']++;

        for(int i=0 ; i<s1.length() ; i++){
            char ch = s2.charAt(i);

            freqS2[ch - 'a']++;
        }

        if(checkPermutation(freqS1 , freqS2)) return true;

        for(int i=s1.length() ; i<s2.length() ; i++){
            freqS2[s2.charAt(i) - 'a']++;
            freqS2[s2.charAt(i - s1.length()) - 'a']--;

            if(checkPermutation(freqS1 , freqS2)) return true;

        }

        return false;
    }
}