class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        //edge case
        if(matrix[0][0] == 1){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0;i < m;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = 0;
                }
            }
        }
        return helper(dp,matrix,m-1,n-1);
    }
    public int helper(int[][] dp,int[][] matrix,int m,int n){
        if(m < 0 || n < 0){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        return dp[m][n] = helper(dp,matrix,m-1,n) + helper(dp,matrix,m,n-1);
    }
}