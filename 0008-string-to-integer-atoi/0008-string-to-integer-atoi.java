class Solution {

    // Recursion Approach
    long helper(String s , long res , int i , int sign){

        if( i == s.length() || !Character.isDigit(s.charAt(i)) ) return res * sign;

        char ch = s.charAt(i);

        res = res * 10 + (ch - '0');

        if(res > Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
        if(res > Integer.MAX_VALUE && sign == -1) return Integer.MIN_VALUE;

        return helper(s , res , i+1 , sign);

    }

    public int myAtoi(String s) {
        int sign = 1 , i = 0;
        
        // Handling leading spaces
        s = s.trim();
        
        if(s.length() == 0) return 0;

        long res = 0;

        // Handling Sign
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }

        res = helper(s , res , i , sign);

        return (int)res;

    }
}


// Normal Approach

// class Solution {
//     public int myAtoi(String s) {
//         s = s.trim();

//         if(s.length() == 0) return 0;
        
//         int i = 0 , sign = 1;
        
//         // Bigger container to handle overflow if occurs
//         long res = 0;

//         // Handling sign
//         if(s.charAt(i) == '-'){
//             i++;
//             sign = -1;
//         }
        
//         else if(s.charAt(i) == '+') i++;

//         while(i < s.length() && (s.charAt(i) >= 48 && s.charAt(i) <= 57)){
//             char ch = s.charAt(i);

//             res = res*10 + (ch - '0');

//             // Checking overflow (imp step)
//             if(sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//             else if(sign == -1 && res > Integer.MAX_VALUE ) return Integer.MIN_VALUE;

//             i++;

//         }
       
//         return (int)(res*sign);
//     }
// }