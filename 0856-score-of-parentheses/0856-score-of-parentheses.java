class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                st.push(score);
                score = 0;
            }
            else{
                int current = score == 0 ? 1 : 2*score;
                score = st.pop() + current;
            }
        }
        return score;
    }
}