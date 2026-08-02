class Solution {
    public boolean stoneGame(int[] piles) {

        int left = 0 , right = piles.length-1;

        int Alice = 0 , Bob = 0 , player = 0;

        // 0 - Alice
        // 1 - Bob

        while(left < right){

            // Alice's Chance
            if(player == 0){
                if(piles[left] > piles[right]){
                    Alice += piles[left];
                    left++;
                }
                else{
                    Alice += piles[right];
                    right--;
                }
                player = 1;
            }

            // Bob's Chance
            else if(player == 1){
                if(piles[left] > piles[right]){
                    Bob += piles[right];
                    right--;
                }
                else{
                    Bob += piles[left];
                    left++;
                }
                player = 0;
            }
            
        }

        return Alice > Bob;
    }
}