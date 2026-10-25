class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int len = s.length();
        int[] ans = new int[len];

        for(int i=0 ; i<len ; i++){
            int sr = startPos[0] , sc = startPos[1];
            int j = i , moves = 0;

            while(j < len && sr >= 0 && sr < n && sc >= 0 && sc < n){
                char ch = s.charAt(j);

                if(ch == 'L') sc--;
                else if(ch == 'R') sc++;
                else if(ch == 'U') sr--;
                else sr++;

                if(sr >= 0 && sr < n && sc >= 0 && sc < n) moves++;
                j++;
            }

            ans[i] = moves;
        }

        return ans;
    }
}