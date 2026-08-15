class Solution {
    public int numberOfSubstrings(String s, int k) {
        int l = 0,r = 0,count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r))+1);
            }
            else{
                map.put(s.charAt(r),1);
            }
            while(map.get(s.charAt(r)) >= k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                // if(map.get(s.charAt(l)) == 0){
                //     map.remove(s.charAt(l),0);
                // }
                l++;
            }
            count += l;
            r++;
        }
        return count; 
    }
}