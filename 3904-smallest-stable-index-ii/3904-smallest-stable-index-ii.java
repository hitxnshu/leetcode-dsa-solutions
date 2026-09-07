class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int ans = -1;
        int arr1[] = new int[nums.length];
        int arr2[] = new int[nums.length];
        arr1[0] = nums[0];
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            arr1[i] = Math.max(max,nums[i]);
            max = arr1[i];
        }
        arr2[nums.length-1] = nums[nums.length-1];
        int min = nums[nums.length-1];
        for(int i = nums.length-2;i >= 0;i--){
            arr2[i] = Math.min(min,nums[i]);
            min = arr2[i];
        }
        for(int i = 0;i < nums.length;i++){
            if(arr1[i] - arr2[i] <= k){
                ans = i;
                return ans;
            }
        }
        return -1;
    }
}