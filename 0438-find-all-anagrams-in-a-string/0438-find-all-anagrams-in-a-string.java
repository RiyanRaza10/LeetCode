class Solution {

    boolean isAnagram(int[] freq_s , int[] freq_p){
        for(int i=0 ; i<26 ; i++){
            if(freq_s[i] != freq_p[i]) return false;
        }

        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> validIndices = new ArrayList<>();

        int sLen = s.length() , pLen = p.length();

        // No valid anagram possible
        if(sLen < pLen) return validIndices;

        // To count frequency of characters
        int[] freq_s = new int[26] , freq_p = new int[26];

        // Counting frequency of all characters in p
        for(int i=0 ; i<pLen ; i++) freq_p[p.charAt(i) - 'a']++;

        // Checking first window in s
        for(int i = 0 ; i<pLen ; i++){
            freq_s[s.charAt(i) - 'a']++;
        }

        if(isAnagram(freq_s , freq_p)) validIndices.add(0);

        for(int i=pLen ; i<sLen ; i++){
            freq_s[s.charAt(i) - 'a']++;
            freq_s[s.charAt(i - pLen) - 'a']--;

            if(isAnagram(freq_s , freq_p)) validIndices.add(i - pLen + 1);
        }

        return validIndices;
    }
}
