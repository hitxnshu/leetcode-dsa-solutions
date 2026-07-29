class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int[] nums, int k){
        int l = 0,r = 0,count = 0,countOdd = 0;
        while(r < nums.length){
            if(nums[r] % 2 != 0){
                countOdd++;
            }
            while(countOdd > k){
                if(nums[l] % 2 != 0){
                    countOdd--;
                }
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;        
    }
}