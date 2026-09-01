class Solution {

    int sumPrimes(int n){
        int sum = 0 , temp = n;

        boolean []isPrime = new boolean[n+1];
        Arrays.fill(isPrime , true);

        isPrime[0] = isPrime[1] = false;

        for(int i=2 ; i*i <= n ; i++){
            if(isPrime[i]){

                int j = 2*i;

                while(j <= n){
                    isPrime[j] = false;
                    j += i;
                }
            }
        }

        for(int i=2 ; i<=n ; i++){
            if(isPrime[i] && n % i == 0){
                
                while(n % i == 0){
                    System.out.println("i : " + i) ;
                    sum += i;
                    n /= i;
                }
            }
        }

        return sum == temp ? -1 : sum;
    }

    public int smallestValue(int n) {

        while(n != 0){

            int curr = sumPrimes(n);

            if(curr == -1) return n;

            n = curr;

        }

        return n;
    }
}