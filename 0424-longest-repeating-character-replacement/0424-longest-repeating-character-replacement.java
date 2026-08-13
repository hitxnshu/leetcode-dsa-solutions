class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0,r = 0, maxLen = 0,max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r))+1);
            }
            else{
                map.put(s.charAt(r),1);
            }
            max = Math.max(max,map.get(s.charAt(r)));
            while((r-l+1)-max > k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}