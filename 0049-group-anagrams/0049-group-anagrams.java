class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char stri[] = str.toCharArray();
            Arrays.sort(stri);
            String sorted = new String(stri);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        ans.addAll(map.values());
        return ans;
    }
}