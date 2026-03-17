class Solution {
    public void combination(int i, int[] nums, int target, int n, List<Integer> list, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || i == n){
            return;
        }
        list.add(nums[i]);
        combination(i,nums,target-nums[i],n,list,ans);
        list.remove(list.size()-1);
        combination(i+1,nums,target,n,list,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combination(0,candidates,target,candidates.length,list,ans);
        return ans;
    }
}