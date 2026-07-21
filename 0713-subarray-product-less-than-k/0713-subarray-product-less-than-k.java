class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0,r = 0,prod = 1,count = 0;
        if(nums.length == 1){
            if(nums[0] < k){
                return 1;
            }
            return 0;
        }
        while(r < nums.length){
            prod *= nums[r];
            while(prod >= k){
                prod = prod / nums[l];
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }
}