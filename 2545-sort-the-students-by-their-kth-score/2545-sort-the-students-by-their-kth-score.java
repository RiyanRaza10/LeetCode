class Solution {

    void swapRow(int[][] score , int row1 , int row2){
        int rowLen = score[0].length;

        // To store values of one row temporarily
        int[] temp = new int[rowLen];

        for(int i=0 ; i<rowLen ; i++){
            temp[i] = score[row1][i];
        }

        for(int i=0 ; i<rowLen ; i++){
            score[row1][i] = score[row2][i];
        }

        for(int i=0 ; i<rowLen ; i++){
            score[row2][i] = temp[i];
        }

    }

    public int[][] sortTheStudents(int[][] score, int k) {
        int i = 0 , rowLen = score.length;

        while(i < rowLen){

            int j=i;

            while(j > 0 && score[j][k] > score[j-1][k]){

                // Swap rows if needed
                swapRow(score , j , j-1);

                j--;
            }

            i++;
        }

        return score;
    }
}