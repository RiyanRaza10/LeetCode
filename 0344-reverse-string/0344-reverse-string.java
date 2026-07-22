class Solution {
    public void reverseString(char[] s) {
       int len = s.length;
       char var = 'a';
       for(int i=0 ; i<len/2 ; i++){
            var = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = var;
       }

    }
}