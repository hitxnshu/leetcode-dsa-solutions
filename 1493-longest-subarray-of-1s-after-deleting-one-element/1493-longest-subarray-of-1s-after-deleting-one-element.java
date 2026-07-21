class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0,r = 0,maxLen = 0,count = 0;
        while(r < nums.length){
            if(nums[r] == 0){
                count++;
            }
            while(count > 1){
                if(nums[l] == 0){
                    count--;
                }
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen-1;
    }
}