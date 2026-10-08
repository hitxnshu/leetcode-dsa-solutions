class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int arr1[] = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            max = Math.max(max,nums[i]);
            arr1[i] = max;
        }

        int arr2[] = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i = nums.length-1;i >= 0;i--){
            min = Math.min(min,nums[i]);
            arr2[i] = min;
        }

        int finale[] = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            finale[i] = arr1[i] - arr2[i];
        }
        int index = -1;
        for(int i = 0;i < nums.length;i++){
            if(finale[i] <= k){
                index = i;
                break;
            }
        }
        return index;
    }
}