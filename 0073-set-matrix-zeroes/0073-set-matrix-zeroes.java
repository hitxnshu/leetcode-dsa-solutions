class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){
                    set1.add(i);
                    set2.add(j);
                }
            }
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if((set1.contains(i) || set2.contains(j)) || (set1.contains(i) && set2.contains(j))){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}