class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // To count freq of character
        HashMap<Character , Integer> map = new HashMap<>();

        int start = 0 , end = 0 , maxLen = 0;

        while(end < s.length()){
            char ch = s.charAt(end);

            if(map.containsKey(ch)){
                start = Math.max(start , map.get(ch) + 1);
            }

            maxLen = (end - start + 1) > maxLen ? end - start + 1 : maxLen;

            // Putting element with its index
            map.put(ch , end);

            end++;
        }

        return maxLen;

    }
}