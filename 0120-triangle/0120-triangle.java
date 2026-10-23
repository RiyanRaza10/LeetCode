class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<triangle.get(i).size() ; j++){

                if(i == 0 && j == 0) dp[i][j] = triangle.get(i).get(j);

                else if(j == 0) dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                else if(j == triangle.get(i).size()-1) dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];

                else dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1] , dp[i-1][j]);
            }
        }
        
        int minSum = Integer.MAX_VALUE;

        for(int i=0 ; i<n ; i++){
            if(dp[n-1][i] < minSum) minSum = dp[n-1][i];
        }

        return minSum;
    }
}