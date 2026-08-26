class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        // For sliding window
        int left = 0 , right = 0, ones = 0;

        // To track min length
        int start = 0 , end = s.length();

        boolean validWindowFound = false;

        String minString = s;

        while(right < s.length()){
            if(s.charAt(right) == '1') ones++;

            while(left <= right && ones >= k){
                validWindowFound = true;

                if(ones == k && right - left + 1 <= end - start + 1){
                    
                    // If crrent substring is smaller , simply update your minString
                    if(right - left + 1 < end - start + 1){
                        start = left;
                        end = right;
                    }

                    // If current substring is lexicographically smaller , assign minString to this using pointers { Update pointers}
                    else if(s.substring(left , right + 1).compareTo(s.substring(start , end + 1)) == -1){
                        start = left;
                        end = right;
                    }
                }

                if(s.charAt(left) == '1') ones--;

                left++;
            }

            right++;
        }
        
        // No valid substring found , return empty string
        if(!validWindowFound) return "";

        return s.substring(start , end + 1);

    }
}