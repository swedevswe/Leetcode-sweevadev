class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; 
        int n = box[0].length;
        char[][] rotated = new char[n][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rotated[j][m - i - 1] = box[i][j];
            }
        }
        for(int col = 0; col < m; col++){
            int emptyRow = n - 1;
            for(int row = n - 1; row >= 0; row--){
                if(rotated[row][col] == '#'){
                    char temp = rotated[row][col];
                    rotated[row][col] = '.';
                    rotated[emptyRow][col] = temp;
                    emptyRow--;
                }else if(rotated[row][col] == '*'){
                    emptyRow = row - 1;
                }else{
                    rotated[row][col] = '.';
                }
            }
        }
        return rotated;
    }
}