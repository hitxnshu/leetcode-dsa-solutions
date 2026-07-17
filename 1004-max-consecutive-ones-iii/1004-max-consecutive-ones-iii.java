class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0;
        int count = 0;
        while(r < nums.length){
            if(nums[r] == 0){
                count++;
            }
            while(count > k){
                if(nums[l] == 0){
                    count--;
                    l++;
                }
                else{
                    l++;
                }
            }
            if(count <= k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}