class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < asteroids.length;i++){
            int current = asteroids[i];
            while(!st.isEmpty() && st.peek() > 0 && current < 0){
                if(Math.abs(current) > Math.abs(st.peek())){
                    st.pop();
                    continue;
                }
                else if(Math.abs(current) == Math.abs(st.peek())){
                    st.pop();
                    current = 0;
                    break;
                }
                else{
                    current = 0;
                    break;
                }
            }
            if(current != 0){
                st.push(current);
            }
        }
        int arr[] = new int[st.size()];
        for(int i = 0;i < st.size();i++){
            arr[i] = st.get(i);
        }
        return arr;
    }
}