class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < operations.length;i++){
            String s = operations[i];
            if(s.equals("+")){
                int a = st.pop();
                int b = st.pop();
                int temp = a + b;
                st.push(b);
                st.push(a);
                st.push(temp);
                //take care of the order you push back a and b
            }
            else if(s.equals("C")){
                st.pop();
            }
            else if(s.equals("D")){
                int temp = (st.peek() * 2);
                st.push(temp);
            }
            else{
                int temp = Integer.parseInt(operations[i]);
                st.push(temp);
            }
        }
        int ans = 0;
        while(st.size() > 0){
            ans = ans + st.pop();
        }
        return ans;
    }
}