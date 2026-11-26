class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int qLen = queries.length , wLen = words.length;
        int[] res = new int[qLen];
        int[] queryFreq = new int[qLen];
        int[] wordFreq = new int[wLen];

        for(int i=0 ; i<qLen ; i++) queryFreq[i] = countFreq(queries[i]);
        for(int i=0 ; i<wLen ; i++) wordFreq[i] = countFreq(words[i]);

        for(int i=0 ; i<qLen ; i++){
            int cnt = 0;
            for(int j=0 ; j<wLen ; j++){
                if(queryFreq[i] < wordFreq[j]) cnt++;
            }

            res[i] = cnt;
        }

        return res;
    }

    int countFreq(String s){
        int[] freq = new int[26];
        char smallest = 'z';

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;

            if(ch < smallest) smallest = ch;
        }

        return freq[smallest - 'a'];
    }
}