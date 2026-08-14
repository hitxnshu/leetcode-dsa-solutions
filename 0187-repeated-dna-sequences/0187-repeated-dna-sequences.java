class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() < 10){
            return list;   
        }
        String temp = "";
        int l = 0,r = 0;
        for(int i = 0;i < 10;i++){
            temp += s.charAt(i);
            r = i;
        }
        HashMap<String,Integer> map = new HashMap<>();
        map.put(temp,1);
        while(r < s.length()-1){
            r++;
            temp += s.charAt(r);
            temp = temp.substring(1);
            l++;
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }
            else{
                map.put(temp,1);
            }
        }
        for(String a : map.keySet()){
            if(map.get(a) > 1){
                list.add(a);
            }
        }
        return list;
    }
}