class Solution {
    public int numberOfSubstrings(String s) {
        
        // To store freq of a,b,c
        int[] freq = new int[3];

        int left = 0 , right = 0 , len = s.length() , ans = 0;

        // Sliding window
        while(right < len){
            freq[s.charAt(right) - 'a']++;

            // Shrinking
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                
                // If a subarray ending at right has all three characters , then
                // All the subarrays that can be formed after appending characters to the right will also contain all three characters , so add all
                ans += (len - right);

                freq[s.charAt(left) - 'a']--;

                left++;
            }

            right++;
        }

        return ans;
    }
}