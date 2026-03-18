class Solution {
    public void subset(int i, int[] nums, int n, List<Integer> list, List<List<Integer>> ans){
        if(i == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        subset(i+1,nums,n,list,ans);
        list.remove(list.size()-1);
        for(int j = i+1;j < n;j++){
            if(nums[j]!=nums[i]){
                subset(j,nums,n,list,ans);
                return;
            }
        }
        subset(n,nums,n,list,ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            for(int j = i+1;j < nums.length;j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        subset(0,nums,nums.length,list,ans);
        return ans;
    }
}