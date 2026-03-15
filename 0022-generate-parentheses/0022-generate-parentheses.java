class Solution {
    public void generate(String s,int open,int close,int n,ArrayList<String> list){
        if(close > open){
            return;
        }
        if(open + close == n*2 && open == close){
            list.add(s);
            return;
        }
        if(open < n){
            generate(s + "(",open+1,close,n,list);
        }
        if(open > close){
            generate(s + ")",open,close+1,n,list);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list =  new ArrayList<>();
        generate("",0,0,n,list);
        return list;
    }
}