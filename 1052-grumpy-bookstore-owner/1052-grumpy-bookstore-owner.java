class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0,maxSum = 0,r = 0,l = 0;
        for(int i = 0;i < customers.length;i++){
            if(grumpy[i] == 0){
                sum += customers[i];
            }
        }
        for(int i = 0;i < minutes;i++){
            if(grumpy[i] == 1){
                sum += customers[i];
            }
            r = i;
        }
        maxSum = sum;
        while(r < customers.length-1){
            if(grumpy[l] == 1){
                sum = sum - customers[l];
            }
            l++;
            r++;
            if(grumpy[r] == 1){
                sum = sum + customers[r];
            }
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}