class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<Integer> primes = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime , true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2 ; i<=n ; i++){
            if(isPrime[i]){
                primes.add(i);
                int j = 2*i;

                while(j <= n){
                    isPrime[j] = false;
                    j += i;
                }
            }
        }

        int left = 0 , right = primes.size()-1;

        while(left <= right){
            int sum = primes.get(left) + primes.get(right);

            if(sum < n) left++;
            else if(sum > n) right--;

            else{
                ans.add(Arrays.asList(primes.get(left) , primes.get(right)));
                left++;
                right--;
            }
        }

        return ans;
    }
}