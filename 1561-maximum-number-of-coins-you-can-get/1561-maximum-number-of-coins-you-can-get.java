class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int n = piles.length;

        int j = n-2 , myCoins = 0 , pileTaken = 0;

        // Give bob a pile from start , 
        // Alice from end
        // Take yours from the one before Alice
        while(pileTaken < n/3){
            myCoins += piles[j];

            pileTaken++;

            j -= 2;   
        }

        return myCoins;
    }
}

    // i = 0 , j = n-2 , k = n-1;
    // while(i < j){
    //     myCoins += piles[j];
    //     i++;
    //     j -= 2;
    //     k -= 2;   
    // }