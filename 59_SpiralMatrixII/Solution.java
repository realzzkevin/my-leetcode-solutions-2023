class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int size = 1;
        int up = 0;
        int left = 0;
        int down = n-1;
        int right = n-1;

        while (size <= n*n){
            for(int l = left; l <= right; l++){
                matrix[up][l] = size;
                size++;
            }
            for(int u = up+1; u <= down; u++){
                matrix[u][right] = size;
                size++;
            }
            if( right != left) {
                for(int r = right-1; r >= left; r--){
                    matrix[down][r] = size;
                    size++;
                }
            }
            if(up != down){
                for(int d = down-1; d > up; d--){
                    matrix[d][left] = size;
                    size++;
                }
            }

            up++;
            left++;
            down--;
            right--;
        }

        return matrix;

    }
}