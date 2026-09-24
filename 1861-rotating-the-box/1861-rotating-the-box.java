class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        for(int i = 0;i < m;i++){
            int empty = n-1;
            for(int j = n-1;j >=0;j--){
                if(boxGrid[i][j] == '*'){
                    empty = j-1;
                }
                else if(boxGrid[i][j] == '#'){
                    if(j < empty){
                        boxGrid[i][empty] = '#';
                        boxGrid[i][j] = '.';
                    }
                    empty--;
                }
            }
        }
        char rotatedBox[][] = new char[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                rotatedBox[i][j] = boxGrid[m-1-j][i];
            }
        }
        // for(int i = n-1;i > 0;i--){
        //     for(int j = 0;j < m;j++){
        //         if(rotatedBox[i][j] == '.' && rotatedBox[i-1][j] != '*' && rotatedBox[i-1][j] == '#'){
        //             rotatedBox[i][j] = '#';
        //             rotatedBox[i-1][j] = '.';
        //         }
        //     }
        // }
        return rotatedBox;
    }
}