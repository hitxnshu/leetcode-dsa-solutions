class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0,r = 0;
        for(int i = 0;i < k;i++){
            sum += arr[i];
            r = i;
        }
        int count = 0;
        if((sum/k)>= threshold){
            count++;
        }
        int l = 0;
        while(r < arr.length-1){
            sum = sum - arr[l];
            l++;
            r++;
            sum = sum + arr[r];
            if((sum/k) >= threshold){
                count++;
            }
        }
        return count;
    }
}