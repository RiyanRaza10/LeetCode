class Solution {
    public boolean canAliceWin(int n) {
        int stones = 10;

        while(n > 0){
            if(n - stones < 0){
                return stones%2 != 0;
            }
            n -= stones--;
        }

        return stones%2 != 0;
    }
}