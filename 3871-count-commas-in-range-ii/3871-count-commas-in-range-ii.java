class Solution {
    
    public long countCommas(long n) {
        return helper(n, 0);
    }

    long helper(long n , long ans){
        
        // n >= 1e15
        if(n == 1_000_000_000_000_000L){
            return helper(n - 1 , 5);    
        }

        // n >= 1_000_000_000_000
        // n >= 1e12 
        else if(n >= (1_000_000_000_000L)){
            ans += (n - 999999999999L) * 4;
            return helper(999999999999L , ans);
        }

        // n >= 1_000_000_000
        // n >= 1e9
        else if(n >= 1_000_000_000L){
            ans += (n - 999999999L) * 3;
            return helper(999999999L , ans);
        }

        // n >= 1_000_000
        // n >= 1e6 
        else if(n >= 1_000_000L){ 
            ans += (n - 999999L) * 2;
            return helper( 999999L , ans);
        }

        // n >= 1_000L
        // n >= 1e15
        else if(n >= 1_000L){
            ans += (n - 999);
            return ans;
        }

        else return ans;
        
    }
}

 // // No comma
        // if(n < 1000) return ans;

        // // Less than 2 commas
        // else if(n < 1000000){
        //     ans += (n - 999);
        //     return ans;
        // }

        // // Less than 3 commas
        // else if(n < (long)(1e9)){
        //     ans += (n - (long)999999) * 2;
        //     return helper((long)999999 , ans);
        // }

        // // Less than 4 commas
        // else if(n < (long)(1e12)){
        //     ans += (long)(n - (long)999999999) * 3;
        //     return helper((long)999999999 , ans);
        // }

        // // Less than 5 commas
        // else if(n < (long)1e15){
        //     ans += (long)((long)((long)1e12 - 1)) * (long)4;
        //     return helper((long)((long)1e12 - 1), ans);
        // }

        // else return 0;