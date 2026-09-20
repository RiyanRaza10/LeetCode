class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        // All groups cannot be formed
        if(n % groupSize != 0) return false;

        // To track frequency
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int val : hand) map.put(val , map.getOrDefault(val , 0) + 1);

        Arrays.sort(hand);

        for(int i=0 ; i<n ; i++){

            // We might have formed a group with this 
            if(!map.containsKey(hand[i])) continue;

            int group = 1 , cnt = 1;

            // Decrement frequency of current card
            map.put(hand[i] , map.get(hand[i])-1);
            if(map.get(hand[i]) == 0) map.remove(hand[i]);

            if(map.containsKey(hand[i]+cnt)){

                // Form a group of size groupSize with consecutive cards
                while(group < groupSize && map.containsKey(hand[i]+cnt)){
                    
                    // Decrement frequency
                    map.put(hand[i]+cnt , map.get(hand[i]+cnt) - 1);
                    if(map.get(hand[i]+cnt) == 0) map.remove(hand[i]+cnt);

                    group++;
                    cnt++;
                }
            }

            // Check if a group of size groupSize is formed
            if(group < groupSize) return false;

        }

        // All groups formed successfully
        return true;
    }
}