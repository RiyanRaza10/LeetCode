class Solution {

    public int longestBeautifulSubstring(String word) {
        
        if(word.length() < 5) return 0;

        int left = 0 , right = 0 , maxLen = 0;

        int a = 0 , e = 0 , i = 0 , o = 0 , u = 0;

        while(right < word.length()){

            if(word.charAt(right) == 'a'){
                a++;

                while(left <= right && (e > 0 || i > 0 || o > 0 || u > 0) ){

                    char ch = word.charAt(left);
                    if(ch == 'a') a--;
                    else if(ch == 'e') e--;
                    else if(ch == 'i') i--;
                    else if(ch == 'o') o--;
                    else u--;

                    left++;
                }

                if(a > 0 && e > 0 && i > 0 && o > 0 && u > 0 ){
                    maxLen = Math.max(maxLen , right - left + 1);
                }
            }

            else if(word.charAt(right) == 'e'){
                e++;

                while(left <= right && (i > 0 || o > 0 || u > 0) ){
                    
                    char ch = word.charAt(left);
                    if(ch == 'a') a--;
                    else if(ch == 'e') e--;
                    else if(ch == 'i') i--;
                    else if(ch == 'o') o--;
                    else u--;
                    
                    left++;
                }

                if(a > 0 && e > 0 && i > 0 && o > 0 && u > 0 ){
                    maxLen = Math.max(maxLen , right - left + 1);
                }
            }

            else if(word.charAt(right) == 'i'){
                i++;

                while(left <= right && (o > 0 || u > 0) ){
                    char ch = word.charAt(left);
                    if(ch == 'a') a--;
                    else if(ch == 'e') e--;
                    else if(ch == 'i') i--;
                    else if(ch == 'o') o--;
                    else u--;

                    left++;
                }

                if(a > 0 && e > 0 && i > 0 && o > 0 && u > 0 ){
                    maxLen = Math.max(maxLen , right - left + 1);
                }
            }

            else if(word.charAt(right) == 'o'){
                o++;

                while(left <= right && (u > 0) ){

                    char ch = word.charAt(left);
                    if(ch == 'a') a--;
                    else if(ch == 'e') e--;
                    else if(ch == 'i') i--;
                    else if(ch == 'o') o--;
                    else u--;

                    left++;
                }

                if(a > 0 && e > 0 && i > 0 && o > 0 && u > 0 ){
                    maxLen = Math.max(maxLen , right - left + 1);
                }
            }

            else if(word.charAt(right) == 'u'){
                u++;

                if(a > 0 && e > 0 && i > 0 && o > 0 && u > 0 ){
                    maxLen = Math.max(maxLen , right - left + 1);
                }
            }

            right++;
        }

        return maxLen;
    }
}