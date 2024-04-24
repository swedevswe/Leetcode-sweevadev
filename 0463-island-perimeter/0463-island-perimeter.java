class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int area = 0;
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j]==1){
                    if(i==0 || grid[i-1][j]==0) area++;
                    if(i==rows-1 || grid[i+1][j]==0) area++;
                    if(j==0 || grid[i][j-1]==0) area++;
                    if(j==cols-1 || grid[i][j+1]==0) area++;
                }
            }
        }
        return area;
    }
}