class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int T = 0 , F = 0 , left = 0 , right = 0 , maxLen = 1;

        while(right < answerKey.length()){
            if(answerKey.charAt(right) == 'T') T++;
            else F++;

            while(left <= right && Math.min(T , F) > k){
                if(answerKey.charAt(left) == 'T') T--;
                else F--;

                left++;
            }

            maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }

        return maxLen;
    }
}