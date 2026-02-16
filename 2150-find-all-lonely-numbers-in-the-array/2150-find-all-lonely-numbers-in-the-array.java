class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }
        for(int i : map.keySet()){
            if(map.get(i) == 1){
                if(!map.containsKey(i+1) && !map.containsKey(i-1)){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}