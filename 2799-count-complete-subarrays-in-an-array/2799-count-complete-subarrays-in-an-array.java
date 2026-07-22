class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            HashMap<Integer,Integer> map2 = new HashMap<>();
            for(int j = i;j < nums.length;j++){
                if(map2.containsKey(nums[j])){
                    map2.put(nums[j],map2.get(nums[j])+1);
                }
                else{
                    map2.put(nums[j],1);
                }
                if(map2.size() == map.size()){
                    count++;
                }
            }
        }
        return count;
        // int l = 0, r = 0, count = 0;
        // while(r < nums.length){
        //     if(map2.containsKey(nums[r])){
        //         map2.put(nums[r],map2.get(nums[r])+1);
        //     }
        //     else{
        //         map2.put(nums[r],1);
        //     }
        //     while(map2.size() > map.size()){
        //         map.put(nums[l],map.get(nums[l])-1);
        //         map.remove(nums[l],0);
        //         l++;
        //     }
        //     if(map2.size() == map.size()){
        //         count++;
        //     }
        //     r++;
        // }
        // return count;
    }
}