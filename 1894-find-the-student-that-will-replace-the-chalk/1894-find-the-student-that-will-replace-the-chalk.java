class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;

        for(int val : chalk) sum += (long)val;

        k %= sum;

        for(int i=0 ; i<chalk.length ; i++){
            if(k - chalk[i] >= 0){
                k -= chalk[i];
            }

            else return i;
        }

        return 0;
    }
}