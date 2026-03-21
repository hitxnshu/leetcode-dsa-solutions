class Solution {
    public void helper(int i,String digits,String current, List<String> list){
        String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(i == digits.length()){
            list.add(current);
            return;
        }
        String s = map[digits.charAt(i) - '0'];
        for(int j = 0;j < s.length();j++){
            helper(i+1,digits,current+s.charAt(j),list);

        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> list  = new ArrayList<>();
        helper(0,digits,"",list);
        return list;
    }
}