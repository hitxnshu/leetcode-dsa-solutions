class Solution {
    public int maxVowels(String s, int k) {
        int l = 0,r = 0;
        int maxCount = 0,currCount = 0;
        for(int i = 0;i < k;i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                currCount++;
            }
            r = i;
        }
        maxCount = currCount;
        while(r < s.length()-1){
            char ch = s.charAt(l);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                currCount--;
            }
            l++;
            r++;
            char ch1 = s.charAt(r);
            if(ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u'){
                currCount++;
            }
            maxCount = Math.max(maxCount,currCount);
        }
        return maxCount;
    }
}