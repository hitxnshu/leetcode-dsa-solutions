class Solution {
    public boolean isPrime(int n){
        if(n == 0 || n == 1){
            return false;
        }
        for(int i = 2;i < n;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            if(isPrime(nums[i])){
                set.add(nums[i]);
            }
            else{
                for(int j = 2;j < nums[i];j++){
                    if(nums[i] % j == 0){
                        if(isPrime(j)){
                            set.add(j);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}