class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        // I will mark used element as 456(just a random number)

        List<Integer> list = new ArrayList<>();

        int m = matrix.length , n = matrix[0].length; 

        int i = 0 , j = 0;

        // To keep track of lastly used element
        int[] lastVisited = new int[]{0,0};

        while(list.size() < m*n){

            // Going left to right
            if(lastVisited[0] != 0){
                i = lastVisited[0];
                j = lastVisited[1] + 1;
            }

            while(j < n && matrix[i][j] != 456){
                list.add(matrix[i][j]);
                matrix[i][j] = 456;
                lastVisited[0] = i;
                lastVisited[1] = j;
                j++;
            }

            // Going up to down
            i = lastVisited[0] + 1;
            j = lastVisited[1];

            while(i < m && matrix[i][j] != 456){
                list.add(matrix[i][j]);
                matrix[i][j] = 456;
                lastVisited[0] = i;
                lastVisited[1] = j;
                i++;
            }

            // Going right to left
            i = lastVisited[0];
            j = lastVisited[1] - 1;
            
            while(j >= 0 && matrix[i][j] != 456){
                list.add(matrix[i][j]);
                matrix[i][j] = 456;
                lastVisited[0] = i;
                lastVisited[1] = j;
                j--;
            }

            // Going down to up
            i = lastVisited[0] - 1;
            j = lastVisited[1] ;

            while(i >= 0 && matrix[i][j] != 456){
                list.add(matrix[i][j]);
                matrix[i][j] = 456;
                lastVisited[0] = i;
                lastVisited[1] = j;
                i--;
            }
            
        }

        return list;

    }
}