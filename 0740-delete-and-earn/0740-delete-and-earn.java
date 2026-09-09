class Solution {
    public int deleteAndEarn(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int sum = nums[0];
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                sum += nums[i];
            }
            else{
                list.add(sum);
                sum = nums[i+1];

                if(nums[i+1] > nums[i]+1){
                    list.add(0);
                }
            }
        }
        list.add(sum);
        int dp[] = new int[list.size()];
        Arrays.fill(dp,-1);
        return helper(list,list.size()-1,dp);
    }
    public int helper(List<Integer> list, int n, int[] dp){
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = Math.max(helper(list,n-1,dp), list.get(n) + helper(list,n-2,dp));
    }
}