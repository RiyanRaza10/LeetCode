class Solution {
    // Each step has a cost either going one side
    // Or even returning from each side
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxPos = Math.max(fruits[fruits.length-1][0] , startPos+k+1);

        int[] fruitsAt = new int[maxPos+1];

        for(int[] fr : fruits) fruitsAt[fr[0]] = fr[1];

        int steps = k , rightPos = startPos;
        int currFruits = fruitsAt[startPos] , maxFruits = 0;

        // Compute k steps to the right
        while(steps-- > 0){
            rightPos++;
            if(rightPos >= 0 && rightPos <= maxPos) currFruits += fruitsAt[rightPos];
        }

        steps = k;
        int leftPos = startPos-1;
        maxFruits = Math.max(maxFruits , currFruits);
        
        // Compute upto k steps to the left , maintaining a constant window of k
        while(steps-- > 0 && rightPos > startPos){
            // +1 step to the leftPos
            if(leftPos >= 0 && leftPos <= maxPos) currFruits += fruitsAt[leftPos]; 
            
            // -2 steps to the rightPos(each step + its returning step)
            if(rightPos >= 0 && rightPos <= maxPos) currFruits -= fruitsAt[rightPos]; 
            if(rightPos-1 > startPos && (rightPos-1 >= 0 && rightPos-1 <= maxPos)) currFruits -= fruitsAt[rightPos-1];

            leftPos--;
            rightPos -= 2;    

            maxFruits = Math.max(maxFruits , currFruits);
        }

        // Part 2 left side first
        steps = k;
        currFruits = fruitsAt[startPos]; 
        leftPos = startPos;

        // Compute k steps to the left
        while(steps-- > 0){
            leftPos--;
            if(leftPos >= 0 && leftPos <= maxPos) currFruits += fruitsAt[leftPos];
        }
       
        maxFruits = Math.max(maxFruits , currFruits);
        steps = k;
        rightPos = startPos+1;

        // Compute upto k steps to the right , maintaining a constant window of k
        while(steps-- > 0 && leftPos < startPos){
            // +1 to the rightPos
            if(rightPos >= 0 && rightPos <= maxPos) currFruits += fruitsAt[rightPos];
            
            // +2 to the leftPos(1 for each step and 1 for returning step)
            if(leftPos >= 0 && leftPos <= maxPos) currFruits -= fruitsAt[leftPos]; 
            if(leftPos + 1 < startPos && (leftPos + 1 >= 0 && leftPos+1 <= maxPos)) currFruits -= fruitsAt[leftPos+1];

            rightPos++;    
            leftPos += 2;

            maxFruits = Math.max(maxFruits , currFruits);
        }

        return maxFruits;
    }
}