class Solution {
    public void subset(int i, int[] nums, List<Integer> list, List<List<Integer>> ans, int n){
        if(i == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        subset(i+1,nums,list,ans,n);
        list.remove(list.size()-1);
        subset(i+1,nums,list,ans,n);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        subset(0,nums,list,ans,nums.length);
        return ans;
    }
}