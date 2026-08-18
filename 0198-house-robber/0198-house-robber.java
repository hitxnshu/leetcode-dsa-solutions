class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        return helper(dp,n,nums);
    }
    public int helper(int[] dp, int n, int[] nums){
        if(n <= 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = Math.max(helper(dp,n-1,nums),nums[n-1] + helper(dp,n-2,nums));
    }
}