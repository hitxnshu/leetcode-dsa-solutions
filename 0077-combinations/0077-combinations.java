class Solution {
    public void combinations(int i, int n, int k,List<Integer> nums, List<Integer> list, List<List<Integer>> mainList){
        if(i == n){
            if(list.size() == k){
                mainList.add(new ArrayList<>(list));//copy of the list passed
            }
            return;
        }
        list.add(nums.get(i));
        combinations(i+1,n,k,nums,list,mainList);
        list.remove(list.size()-1);
        combinations(i+1,n,k,nums,list,mainList);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            nums.add(i);
        }
        List<Integer> list = new ArrayList<>();
        List<List <Integer>> mainList = new ArrayList<>();
        combinations(0,nums.size(),k,nums,list,mainList);
        return mainList;
    }
}