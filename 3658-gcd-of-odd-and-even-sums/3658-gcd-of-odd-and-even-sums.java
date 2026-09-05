class Solution {

    int gcd(int x , int y){
        if(y == 0) return x;

        return gcd(y , x%y);
    }

    public int gcdOfOddEvenSums(int n) {
        
        int oddSum = n*n;
        int evenSum = n*n + n;

        return gcd(oddSum , evenSum);
    }
}