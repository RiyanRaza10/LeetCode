class Solution {
    public int[] closestPrimes(int left, int right) {
        
        // Sieve of Eratosthenes
        boolean[] isPrime = new boolean[right + 1];

        Arrays.fill(isPrime , true);

        int[] ans = new int[]{-1 , -1};

        isPrime[0] = isPrime[1] = false;

        for(int i=2 ; i<=right ; i++){
            if(isPrime[i]){
                int j = 2*i;

                while(j <= right){
                    isPrime[j] = false;
                    j += i;
                }
            }
        }

        int cnt = 0 , num1 = 0 , num2 = 0 , minDiff = right;

        for(int i=left ; i <= right ; i++){
            
            if(isPrime[i]){

                // Assigning num1 && num2
                if(cnt == 0) num1 = i;
                else if(cnt == 1)num2 = i;
                else{
                    num1 = num2;
                    num2 = i;
                }

                // Counting minimum diff
                if(num2 - num1 > 0 && num2 - num1 < minDiff){
                    ans[0] = num1; ans[1] = num2;
                    minDiff = num2 - num1;
                }

                cnt++;
            }
        }

        return ans;
    }
}