class Solution {

    void factorise(int num , HashMap<Integer , Integer> map , boolean[] isPrime){

        // In case if num is prime
        if(isPrime[num]) {
            map.put(num , map.getOrDefault(num , 0) + 1);
            return;
        }
        
        int elem = num;

        for(int i=2 ; i*i <= num ; i++){ 
                
            // Checking first factor
            if(num % i == 0 && isPrime[i]) {
                int prod = 1;

                while(num % i == 0){
                    num /= i;
                    prod *= i;
                    map.put(i , map.getOrDefault(i , 0) + 1);
                }

                if(num == 1) return;

                int secondFactor = elem / prod;

                // Checking second factor
                if(num % secondFactor == 0 && secondFactor != i && isPrime[secondFactor]){
                    while(num % (secondFactor) == 0){
                        num /= secondFactor;
                        map.put(secondFactor , map.getOrDefault(secondFactor , 0) + 1);    
                    }
                }

            }
            
        }

        // Agar divide karte karte last me prime agya
        if(num != 1 && isPrime[num]){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

    }

    void deFactorise(int num , HashMap<Integer , Integer> map , boolean[] isPrime){
        
        // In case if num is prime
        if(isPrime[num]){
            map.put(num , map.get(num) - 1);
            if(map.get(num) == 0) map.remove(num);

            return;
        }

        int elem = num;

        for(int i=2 ; i*i <= num ; i++){ 
                
            // Checking first factor
            if(num % i == 0 && isPrime[i]) {
                int prod = 1;

                while(num % i == 0){
                    num /= i;
                    prod *= i;
                    map.put(i , map.get(i) - 1);
                }

                if(map.get(i) == 0) map.remove(i);

                if(num == 1) return;

                int secondFactor = elem / prod;

                // Checking second factor
                if(num % secondFactor == 0 && secondFactor != i && isPrime[secondFactor]){

                    while(num % (secondFactor) == 0){
                        num /= secondFactor;
                        map.put(secondFactor , map.get(secondFactor) - 1);
                    }

                    if(map.get(secondFactor) == 0) map.remove(secondFactor);
                }

            }
            
        }

        // Agar divide karte karte last me prime agya
        if(num != 1 && isPrime[num]){
            map.put(num , map.get(num) - 1);
            if(map.get(num) == 0) map.remove(num);
        }

    }

    
    public int longestSubarray(int[] nums, int k) {
        int max = -1;

        for(int val : nums) max = Math.max(max , val);
        
        // Sieve theory
        boolean[] isPrime = new boolean[max+1];
        
        Arrays.fill(isPrime , true);

        for(int i=2 ; i<=max ; i++){
            if(isPrime[i]){
                int j=2*i;

                while(j <= max){
                    isPrime[j] = false;
                    j += i;
                }
            }
        }

        
        // Sliding Window 
        HashMap<Integer , Integer> map = new HashMap<>();

        int left = 0 , right = 0 , maxLen = 0;

        while(right < nums.length){
            
            // Add factors of nums[right] to map
            factorise(nums[right] , map , isPrime);

            while(left <= right && map.size() > k){

                // Remove all the factors of nums[left] from map
                deFactorise(nums[left] , map , isPrime);

                left++;
            }

            maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }

        return maxLen;

    }
}