class Solution {
    public int countOfSubstrings(String word, int k) {
        
        int cnt = 0;

        for(int ind=0 ; ind<word.length() ; ind++){
            
            int a = 0 , e = 0 , i = 0 , o = 0 , u = 0 , cons = 0;

            for(int j=ind ; j<word.length() ; j++){
                char ch = word.charAt(j);
                if(ch == 'a') a++;
                else if(ch == 'e') e++;
                else if(ch == 'i') i++;
                else if(ch == 'o') o++;
                else if(ch == 'u') u++;
                else cons++;

                if(a > 0 && e > 0 && i > 0 && o > 0 && u > 0 && cons == k) cnt++;

            }
        }

        return cnt;
    }
}