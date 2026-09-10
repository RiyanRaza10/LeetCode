class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];

        int n = s.length() , steps = 0;

        for(int i=0 ; i<n ; i++) freq[t.charAt(i) - 'a']++;

        for(int i=0 ; i<n ; i++) freq[s.charAt(i) - 'a']--;

        for(int i=0 ; i<26 ; i++){
            if(freq[i] < 0){
                steps += Math.abs(freq[i]);
            }
        }

        return steps;
    }
}