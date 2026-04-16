class Solution {
    public int[] sortArray(int[] nums) {
        merge(nums,0,nums.length-1);
        return nums;
    }
    public void merge(int[] nums, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low + high) / 2;
        merge(nums,low,mid);
        merge(nums,mid+1,high);
        mergeHelper(nums,low,mid,high);
    }
    public void mergeHelper(int[] nums,int low,int mid,int high){
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                list.add(nums[left]);
                left++;
            }
            else{
                list.add(nums[right]);
                right++;
            }
        }
        while(left <= mid){
            list.add(nums[left]);
            left++;
        }
        while(right <= high){
            list.add(nums[right]);
            right++;
        }
        for(int i = low;i <= high;i++){
            nums[i] = list.get(i-low);
        }
    }
}