class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int currScore = 0 , maxScore = 0 , left = 0 , right = cardPoints.length - 1;

        // Score from first k cardPoints
        while(left < k){
            currScore += cardPoints[left];
            left++;
        }

        // Let maxScore = score of first k cardPoints
        maxScore = currScore;

        // Removing cardPoints from index k to 0 ans adding cardPoints from last 
        // Also keep track of maximum score that can be obtained
        while(left > 0){
            currScore -= cardPoints[--left];
            currScore += cardPoints[right];

            maxScore = Math.max(currScore , maxScore);

            right--;
        }

        return maxScore;

        
    }
}