class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 1){
            return nums[0];
        }
        int n = nums.length;
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0;i < n-1;i++){
            list1.add(nums[i]);
        }
        List<Integer> list2 = new ArrayList<>();
        for(int i = 1;i < n;i++){
            list2.add(nums[i]);
        }
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int a = helper1(dp1,n-1,list1);
        int b = helper2(dp2,n-1,list2);
        return Math.max(a,b);
    }
    public int helper1(int[] dp1, int n,List<Integer> list1){
        if(n <= 0){
            return 0;
        }
        if(dp1[n-1] != -1){
            return dp1[n-1];
        }
        return dp1[n-1] = Math.max(helper1(dp1,n-1,list1),list1.get(n-1) + helper1(dp1,n-2,list1));
    }
    public int helper2(int[] dp2, int n,List<Integer> list2){
        if(n <= 0){
            return 0;
        }
        if(dp2[n-1] != -1){
            return dp2[n-1];
        }
        return dp2[n-1] = Math.max(helper2(dp2,n-1,list2),list2.get(n-1) + helper2(dp2,n-2,list2));
    }
}