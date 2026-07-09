class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1; 
        findStart(nums,target,ans);
        findEnd(nums,target,ans);
        return ans;
    }
    public void findStart(int[] nums,int target,int[] ans){
            int low = 0;
            int high = nums.length-1;
            while(low <= high){
                int mid = (low+high)/2;
                if(nums[mid] == target){
                    ans[0] = mid;
                    high = mid-1;
                }
                else if(nums[mid] > target){
                    high = mid-1;
                }
                else{
                    low = mid + 1;
                }
            }
            return;
    }
    public void findEnd(int[] nums,int target,int[] ans){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                ans[1] = mid;
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        return;
    }
}