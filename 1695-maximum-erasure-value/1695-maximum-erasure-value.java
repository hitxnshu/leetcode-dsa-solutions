class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0,r = 0,sum = 0,maxSum = 0;
        while(r < nums.length){
            while(map.containsKey(nums[r])){
                map.put(nums[l],map.get(nums[l])-1);
                map.remove(nums[l],0);
                sum -= nums[l];
                l++;
            }
            map.put(nums[r],1);
            sum += nums[r];
            maxSum = Math.max(sum,maxSum);
            r++;
        }
        return maxSum;
    }
}