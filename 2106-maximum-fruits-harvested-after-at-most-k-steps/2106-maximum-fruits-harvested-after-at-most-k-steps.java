class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int[] fr : fruits) map.put(fr[0] , fr[1]);

        int steps = k , rightPos = startPos , currFruits = 0;
        if(map.containsKey(rightPos)) currFruits += map.get(rightPos);

        // Compute k steps to the right
        while(steps-- > 0){
            rightPos++;
            if(map.containsKey(rightPos)) currFruits += map.get(rightPos);
        }

        steps = k;
        int leftPos = startPos-1;
        int maxFruits = currFruits;
        
        // Compute upto k steps to the left , maintaining a constant window of k
        while(steps-- > 0 && rightPos > startPos){
            if(map.containsKey(leftPos)) currFruits += map.get(leftPos); // +1 to the leftPos
            if(map.containsKey(rightPos)) currFruits -= map.get(rightPos); // -2 to the rightPos(each step + its returning step)
            if(rightPos-1 > startPos && map.containsKey(rightPos-1)) currFruits -= map.get(rightPos-1);

            leftPos--;
            rightPos -= 2;    

            maxFruits = Math.max(maxFruits , currFruits);
        }

        // Part 2 left side first
        steps = k;
        currFruits = 0;
        if(map.containsKey(startPos)) currFruits = map.get(startPos); 
        leftPos = startPos;

        // Compute k steps to the left
        while(steps-- > 0){
            leftPos--;
            if(map.containsKey(leftPos)) currFruits += map.get(leftPos);
        }
       
        maxFruits = Math.max(maxFruits , currFruits);
        steps = k;
        rightPos = startPos+1;

        // Compute upto k steps to the right , maintaining a constant window of k
        while(steps-- > 0 && leftPos < startPos){
            // +1 to the rightPos
            if(map.containsKey(rightPos)) currFruits += map.get(rightPos);
            
            // +2 to the leftPos(1 for each step and 1 for returning step)
            if(map.containsKey(leftPos)) currFruits -= map.get(leftPos); 
            if(leftPos + 1 < startPos && map.containsKey(leftPos+1)) currFruits -= map.get(leftPos+1);

            rightPos++;    
            leftPos += 2;

            maxFruits = Math.max(maxFruits , currFruits);
        }

        return maxFruits;
    }
}