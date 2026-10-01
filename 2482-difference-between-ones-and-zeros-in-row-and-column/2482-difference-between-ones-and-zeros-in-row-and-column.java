class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        ArrayList<HashMap<Integer,Integer>> rows = new ArrayList<>();
        ArrayList<HashMap<Integer,Integer>> cols = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i < m;i++){
            rows.add(new HashMap<>());
        }
        for(int i = 0;i < n;i++){
            cols.add(new HashMap<>());
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(rows.get(i).containsKey(grid[i][j])){
                    rows.get(i).put(grid[i][j],rows.get(i).get(grid[i][j]) + 1);
                }
                else{
                    rows.get(i).put(grid[i][j],1);
                }
            }
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(cols.get(i).containsKey(grid[j][i])){
                    cols.get(i).put(grid[j][i],cols.get(i).get(grid[j][i]) + 1);
                }
                else{
                    cols.get(i).put(grid[j][i],1);
                }
            }
        }
        int diff[][] = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                diff[i][j] = rows.get(i).getOrDefault(1,0) + cols.get(j).getOrDefault(1,0) - rows.get(i).getOrDefault(0,0) - cols.get(j).getOrDefault(0,0);
            }
        }
        return diff;
    }
}