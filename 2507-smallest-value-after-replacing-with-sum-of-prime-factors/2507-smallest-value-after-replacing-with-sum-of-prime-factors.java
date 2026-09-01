class Solution {

    public int smallestValue(int n) {
        int sum = 0 , temp = n;

        for(int i=2 ; i<=n ; i++){
            
            while(n % i == 0){
                sum += i;
                n /= i;
            }                
            
        }

        return temp == sum ? sum : smallestValue(sum);

    }
}

 // while(n != 0){

        //     int curr = sumPrimes(n);

        //     if(curr == -1) return n;

        //     n = curr;

        // }