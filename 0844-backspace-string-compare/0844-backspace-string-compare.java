class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        Stack<Character> rt = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '#' && st.size() > 0){
                st.pop();
            }
            else if(s.charAt(i) == '#' && st.size() == 0){

            }
            else{
                st.push(s.charAt(i));
            }
        }
        for(int i = 0;i < t.length();i++){
            if(t.charAt(i) == '#' && rt.size() > 0){
                rt.pop();
            }
            else if(t.charAt(i) == '#' && rt.size() == 0){

            }
            else{
                rt.push(t.charAt(i));
            }
        }
        if(st.size()!=rt.size()){
            return false;
        }
        while(st.size() > 0){
            if(st.pop()!=rt.pop()){
                return false;
            }
        }
        return true;
    }
}