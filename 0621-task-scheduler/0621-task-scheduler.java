class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks) freq[ch - 'A']++;

        int totalTasks = tasks.length , op = 0;

        while(totalTasks > 0){
            boolean[] used = new boolean[26];

            for(int i=0 ; i<=n ; i++){
                char maxCh = '#';
                int maxFreq = 0;

                for(int j=0 ; j<26 ; j++){
                    if(freq[j] > maxFreq && !used[j]){
                        maxFreq = freq[j];
                        maxCh = (char)(65 + j); 
                    }
                }

                if(totalTasks > 0) op++;

                if(maxFreq > 0){
                    used[maxCh - 'A'] = true;
                    freq[maxCh - 'A']--;
                    totalTasks--;
                }
                
            }
        }

        return op;
    }
}