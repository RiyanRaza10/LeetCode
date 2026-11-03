class Solution {
    public int integerReplacement(int n) {
        int steps = 0;

        if(n == Integer.MAX_VALUE) return 32;
        
        while(n != 1){
            if(n % 2 == 0){
                n /= 2;
            }
            else{
                if(n == 3) return steps + 2;

                if((n+1) % 4 == 0) n++;
                else n--;
            }

            steps++;
        }
        
        return steps;
    }
}