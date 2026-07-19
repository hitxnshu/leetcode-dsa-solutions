class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0,maxNum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r < fruits.length){
            if(map.containsKey(fruits[r])){
                map.put(fruits[r],map.get(fruits[r])+1);
            }
            else{
                map.put(fruits[r],1);
            }
            if(map.size() > 2){
                map.put(fruits[l], map.get(fruits[l])-1);
                map.remove(fruits[l],0);
                l++;
            }
            if(map.size() <= 2){
                int sum = 0;
                for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                    sum += entry.getValue();
                }
                maxNum = Math.max(maxNum,sum);
            }
            r++;
        }
        return maxNum;
    }
}