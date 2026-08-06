class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int node){
        vis[node] = true;
        for(Integer it : adj.get(node)){
            if(vis[it] == false){
                dfs(adj,vis,it);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[isConnected.length+1];
        for(int i = 0;i < isConnected.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i < isConnected.length;i++){
            for(int j = 0;j < isConnected[0].length;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        for(int i = 0;i < isConnected.length;i++){
            if(vis[i] == false){
                count++;
                dfs(adj,vis,i);
            }
        }
        return count;
    }
}