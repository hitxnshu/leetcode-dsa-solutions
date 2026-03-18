class Solution {
    public void combination(int i,int[] nums,int n,int target,List<Integer> list, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || i == n){
            return;
        }
        list.add(nums[i]);
        combination(i+1,nums,n,target-nums[i],list,ans);
        list.remove(list.size()-1);
        for(int j = i+1;j < n;j++){
            if(nums[j]!=nums[i]){
                combination(j,nums,n,target,list,ans);
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for(int i = 0;i < candidates.length;i++){
            for(int j = i+1;j < candidates.length;j++){
                if(candidates[i] > candidates[j]){
                    int temp = candidates[i];
                    candidates[i] = candidates[j];
                    candidates[j] = temp;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combination(0,candidates,candidates.length,target,list,ans);
        return ans;
    }
}