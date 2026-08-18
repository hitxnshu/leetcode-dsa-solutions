class Solution {
    public int helper(int[] dp, int n){
        if(n <= 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = helper(dp,n-1) + helper(dp,n-2);
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;
        return helper(dp,n);
    }
}