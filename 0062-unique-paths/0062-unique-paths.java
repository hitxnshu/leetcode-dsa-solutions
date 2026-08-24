class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i = 0;i < m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,m-1,n-1);
    }
    public int helper(int[][] dp, int m, int n){
        if(n <= 0 || m <= 0){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        return dp[m][n] = helper(dp,m-1,n) + helper(dp,m,n-1);
    }
}