class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0,r = 0,maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r < nums.length){
            if(map.containsKey(nums[r])){
                map.put(nums[r],map.get(nums[r])+1);
            }
            else{
                map.put(nums[r],1);
            }
            while(map.get(nums[r]) > k){
                map.put(nums[l],map.get(nums[l])-1);
                map.remove(nums[l],0);
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}