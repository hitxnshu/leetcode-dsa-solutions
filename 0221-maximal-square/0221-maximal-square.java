class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0;i < n;i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
            }
        }
        for(int i = 0;i < m;i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
            }
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
            }
        }
        int side = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(dp[i][j] > side){
                    side = dp[i][j];
                }
            }
        }
        return side*side;
    }
}
// remember we are given char matrix not int matrix and we used diff loop for finding max because in the first n^2 loop we are taking i,j from 1,1 not from 0,0