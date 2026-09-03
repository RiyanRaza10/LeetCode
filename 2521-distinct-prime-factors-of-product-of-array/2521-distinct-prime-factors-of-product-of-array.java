class Solution {

    void factorise(int num , boolean[] isComposite , Set<Integer> primeFactors){

        for(int i=2 ; i*i <= num ; i++){
            
            if(num % i == 0) {

                if(!isComposite[i]) primeFactors.add(i);

                if(!isComposite[num / i]) primeFactors.add(num / i);
            }
            
        }

        // If num is prime then it has no prime factor except itself
        if( !isComposite[num] ) primeFactors.add(num);

    }

    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primeFactors = new HashSet<>();

        int max = -1;

        for(int num : nums) max = Math.max(num , max);
            
        // Sieve Theory    
        boolean[] isComposite = new boolean[max+1];

        for(int i=2 ; i<=max ; i++ ){
            if(!isComposite[i]){
                int j=2*i;

                while(j <= max){
                    isComposite[j] = true;
                    j += i;
                }
            }
        } 

        // Factorising each num in nums
        for(int num : nums){
            factorise(num , isComposite , primeFactors);
        }

        return primeFactors.size();
    }
}