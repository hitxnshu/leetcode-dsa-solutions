class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length()){
            return list;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < p.length();i++){
            if(map.containsKey(p.charAt(i))){
                map.put(p.charAt(i),map.get(p.charAt(i))+1);
            }
            else{
                map.put(p.charAt(i),1);
            }
        }
        int n = p.length();
        HashMap<Character,Integer> map2 = new HashMap<>();
        int l = 0,r = 0;
        for(int i = 0;i < p.length();i++){
            if(map2.containsKey(s.charAt(i))){
                map2.put(s.charAt(i),map2.get(s.charAt(i))+1);
            }
            else{
                map2.put(s.charAt(i),1);
            }
            r = i;
        }
        if(map2.equals(map)){
            list.add(0);
        }
        while(r < s.length()-1){
            map2.put(s.charAt(l),map2.get(s.charAt(l))-1);
            map2.remove(s.charAt(l),0);
            l++;
            r++;
            if(map2.containsKey(s.charAt(r))){
                map2.put(s.charAt(r),map2.get(s.charAt(r))+1);
            }
            else{
                map2.put(s.charAt(r),1);
            }
            if(map2.equals(map)){
                list.add(l);
            }
        }
        return list;
    }
}