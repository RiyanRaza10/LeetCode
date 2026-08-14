class Solution {

    int helper(String word , int k){
        int a = 0 , e = 0 , i = 0 , o = 0 , u = 0 , cons = 0;

        int left = 0 , right = 0 , cnt = 0;

        while(right < word.length()){

            char ch = word.charAt(right);
            if(ch == 'a') a++;
            else if(ch == 'e') e++;
            else if(ch == 'i') i++;
            else if(ch == 'o') o++;
            else if(ch == 'u') u++;
            else cons++;

            while(left <= right && (a > 0 && e > 0 && i > 0 && o > 0 && u > 0 && cons > k ) ){
                char temp = word.charAt(left);
                if(temp == 'a') a--;
                else if(temp == 'e') e--;
                else if(temp == 'i') i--;
                else if(temp == 'o') o--;
                else if(temp == 'u') u--;
                else cons--;

                left++;
            }

            cnt += (right - left + 1);        

            right++;
        }

        return cnt;
    }


    public int countOfSubstrings(String word, int k) {
        
        return helper(word , k) - helper(word , k-1);
    }
}