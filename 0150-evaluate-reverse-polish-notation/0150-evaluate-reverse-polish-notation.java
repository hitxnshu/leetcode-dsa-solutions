class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < tokens.length;i++){
            String c = tokens[i];
            if(c.matches("-?\\d+")){// IMPORTANT - check for if string is a number
                st.push(Integer.parseInt(c));//CONVERSION OF STRING TO INT
            }
            else{
                int val2 = st.pop();
                int val1 = st.pop();
                switch(c){
                    case "+" : 
                    st.push(val1+val2);
                    break;
                }
                switch(c){
                    case "-" : 
                    st.push(val1-val2);
                    break;
                }
                switch(c){
                    case "*" : 
                    st.push(val1*val2);
                    break;
                }
                switch(c){
                    case "/" : 
                    st.push(val1/val2);
                    break;
                }
            }
        }
        return st.pop();
    }
}