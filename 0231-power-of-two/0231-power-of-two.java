class Solution {
    public boolean isPowerOfTwo(int n) {
        if( n == 0 || n <= Integer.MIN_VALUE )return false;

        // Power of two in binary:
        // eg :  4 -> 100
        // 4-1 = 3 -> 011
        // Their bitwise AND(&) will yield 0 since no two corresponding bits are same    
        if((n & n-1) == 0)return true;
        return false;

    }
}