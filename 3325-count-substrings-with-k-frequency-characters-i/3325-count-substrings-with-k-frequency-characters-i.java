class Solution {
    public int numberOfSubstrings(String s, int k) {
        int[] freq = new int[26];

        int left = 0 , right = 0 , cnt = 0 , len = s.length();

        while(right < len){
            freq[s.charAt(right) - 'a']++;

            while(left <= right && freq[s.charAt(right) - 'a'] >= k){
                cnt += (len - right);

                freq[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return cnt;
    }
}