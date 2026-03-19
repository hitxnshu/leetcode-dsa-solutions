class Solution {
    public void combination(int last, int n, int k, List<Integer> list, List<List<Integer>> ans){
        if(n == 0 && list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(n <= 0 || list.size() > k){
            return;
        }
        for(int i = last;i <= 9;i++){
            if(i <= n){
                list.add(i);
                combination(i+1,n-i,k,list,ans);
                list.remove(list.size()-1);
            }
            else{
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combination(1,n,k,list,ans);
        return ans;
    }
}