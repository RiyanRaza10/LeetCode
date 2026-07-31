class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for(int i = 0 ; i < word.length() ; i++) freq[word.charAt(i) - 'a']++;
        
        Arrays.sort(freq);

        int cnt = 0 , pushes = 0;

        for(int i = 25 ; i >= 0 ; i--){
            
            // Most frequent characters on 1 push
            if(cnt < 8) pushes += freq[i];
                
            // 2 push characters
            else if(cnt > 7 && cnt < 16) pushes += (2 * freq[i]);

            // 3 push characters
            else if(cnt > 15 && cnt < 24) pushes += (3 * freq[i]);
            
            // 4 push characters
            else pushes += (4 * freq[i]);
            
            cnt = (freq[i] > 0) ? cnt += 1 : cnt;
            
        }

        return pushes;
    }
}