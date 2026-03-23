class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char ans = ' ';
        for(int i = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                ans = s.charAt(i);
                break;
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        return ans;
    }
}