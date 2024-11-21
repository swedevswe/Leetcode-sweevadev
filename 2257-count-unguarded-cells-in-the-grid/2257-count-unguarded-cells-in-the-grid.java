class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] wall : walls){
            grid[wall[0]][wall[1]] = 2;
        }
        for(int[] guard : guards){
            grid[guard[0]][guard[1]] = 1;
        }
        for(int[] guard : guards){
            int x = guard[0];
            int y = guard[1];
            for(int i = x - 1; i >= 0; i--){
                if(grid[i][y] == 2 || grid[i][y] == 1) break;
                grid[i][y] = 3;
            }
            for(int i = x + 1; i < m; i++){
                if(grid[i][y] == 2 || grid[i][y] == 1) break;
                grid[i][y] = 3;
            }
            for(int j = y - 1; j >= 0; j--){
                if(grid[x][j] == 2 || grid[x][j] == 1) break;
                grid[x][j] = 3;
            }
            for(int j = y + 1; j < n; j++){
                if(grid[x][j] == 2 || grid[x][j] == 1) break;
                grid[x][j] = 3;
            }
        }
        int unguardedCount = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) unguardedCount++;
            }
        }
        return unguardedCount;
    }
}