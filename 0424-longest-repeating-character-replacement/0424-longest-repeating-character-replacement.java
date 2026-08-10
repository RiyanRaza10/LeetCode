class Solution {

    boolean isValid(int[] freq , int k){
        int max = 0 , total = 0;

        for(int val : freq){
            total += val;
            max = Math.max(val , max);
        }

        return (total - max <= k ) ? true : false; 
    }

    public int characterReplacement(String s, int k) {
        int left = 0 , right = 0 , maxLen = 0;

        int[] freq = new int[26];

        while(right < s.length()){

            freq[s.charAt(right) - 'A']++;

            while(left <= right && !isValid(freq , k)){
                freq[s.charAt(left) - 'A']--;

                left++;
            }

            maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }

        return maxLen;
    }
}