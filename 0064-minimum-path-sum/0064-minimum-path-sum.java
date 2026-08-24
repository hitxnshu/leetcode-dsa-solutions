class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0;i < m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,grid,m-1,n-1);
    }
    public int helper(int[][] dp, int[][] grid, int m, int n){
        if(m <= 0 && n <= 0){
            return grid[0][0];
        }
        if(m <= 0 || n <= 0){
            if(m == 0){
                return dp[m][n] = grid[m][n] + helper(dp,grid,m,n-1);
            }
            if(n == 0){
                return dp[m][n] = grid[m][n] + helper(dp,grid,m-1,n);
            }
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        return dp[m][n] = grid[m][n] + Math.min(helper(dp,grid,m-1,n),helper(dp,grid,m,n-1));
    }
}