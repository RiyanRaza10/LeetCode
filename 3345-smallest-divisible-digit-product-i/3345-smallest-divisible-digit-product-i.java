class Solution {
    public int smallestNumber(int n, int t) {
        int ans = 0;

        for(int i = n ; i<=10000 ; i++){

            int temp = i , prod = 1;

            while(temp > 0){
            prod *= temp%10;
            temp /= 10;
            }

            if(prod % t == 0){
                return i;
            }
           
        }
        return 0;
    }
}