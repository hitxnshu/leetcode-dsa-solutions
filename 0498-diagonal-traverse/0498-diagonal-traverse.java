class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> list = new ArrayList<>();
        for(int d = 0;d < m+n-1;d++){
            if(d == 0 || d % 2 == 0){
                for(int i = m-1;i >= 0;i--){
                int j = d-i;
                if(j >=0 && j < n){
                    list.add(mat[i][j]);
                }
            }
            }
            else if(d % 2 != 0){
                for(int i = 0;i < m;i++){
                int j = d-i;
                if(j >=0 && j < n){
                    list.add(mat[i][j]);
                }
            }
            }

        }
        int arr[] = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}