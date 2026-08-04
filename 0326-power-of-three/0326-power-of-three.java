class Solution {
    public boolean isPowerOfThree(int n) {
        
        if(n == 0) return false;

        while(n % 3 == 0){
            n /= 3;
        }

        return n == 1;

    }
}

// class Solution {
//     public boolean isPowerOfThree(int n) {
//         boolean ans = true;
//         if(n <= 0){
//             ans = false;
//         }
//         int sum = 1;
//         for(int i=1 ; i<n ;i++){
//             sum *= 3;

//             if(sum == n){
//                 ans = true;
//                 break;
//             }
//             if(sum > n || sum > 1162261467){
//                 ans = false;
//                 break;
//             }  
//         }
//         return ans;
//     }
// }