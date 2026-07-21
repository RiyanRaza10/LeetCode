class Solution {
    public int nthUglyNumber(int n) {
        
        int[] ugly = new int[n] ;

        int ind2 = 0 , ind3 = 0 , ind5 = 0;

        ugly[0] = 1;

        for(int i=1 ; i<n ; i++){

            ugly[i] = Math.min(ugly[ind2]*2 , Math.min( ugly[ind3]*3 , ugly[ind5]*5 ));

            if( ugly[i] == ugly[ind2]*2 ) ind2++;
            if( ugly[i] == ugly[ind3]*3 ) ind3++;
            if( ugly[i] == ugly[ind5]*5 ) ind5++;

        }

        return ugly[n-1];
    }
}