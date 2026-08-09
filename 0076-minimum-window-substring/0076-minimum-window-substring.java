class Solution {

    boolean isValid(int[] mapS , int[] mapT)
    {
        for(int i=0 ; i<256 ; i++){
            if(mapS[i] < mapT[i]) return false;
        }

        return true;
    }

    public String minWindow(String s, String t) {

        // No valid window possible
        if(s.length() < t.length()) return "";

        boolean validWindowFound = false;
    
        // Pointers to keep track of valid window's size
        int start = 0 , end = 0 , minLen = Integer.MAX_VALUE;
    
        // Pointers for sliding window
        int left = 0 , right = 0;

        // Array maps to keep track of characters
        int[] mapS = new int[256] , mapT = new int[256];

        // Counting characters in t with their freq
        for(char ch : t.toCharArray()){
            mapT[ch]++;
        }

        // Sliding Window
        while(right < s.length()){
            char ch = s.charAt(right);
            mapS[ch]++;

            // Shrinking
            while(left <= right && isValid(mapS , mapT)){

                    validWindowFound = true;

                    if(right - left + 1 < minLen){
                        minLen = right - left + 1;                

                        start = left;
                        end = right;
                    }
                
                mapS[s.charAt(left)]--;
                left++;
            }
            
            right++;
        }
        
        // No valid window found
        if(!validWindowFound) return "";

        return s.substring(start , end + 1);

    }
}