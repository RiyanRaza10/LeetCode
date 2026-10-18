class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        
        // To store last Occurrence of each letter 
        int[] lastOcc = new int[26];

        for(int i=0 ; i<s.length() ; i++) lastOcc[s.charAt(i) - 'a'] = i;

        int right = 0 , left = 0;

        while(right < s.length()){

            // Checf if last occurrence of each letter lies between left and right
            if(lastOcc[s.charAt(right) - 'a'] == right && isValid(s , lastOcc , left , right)){
                // Add length
                list.add(right - left + 1);

                left = right + 1;
            }

            right++;
        }

        return list;
    }

    boolean isValid(String s , int[] lastOcc , int left , int right){

        for(int i=left ; i <= right ; i++){
            if(lastOcc[s.charAt(i) - 'a'] > right) return false;
        }

        return true;
    }
}