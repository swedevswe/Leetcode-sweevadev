class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] dist = new int[m][n];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[]{0, 0});
        while(!dq.isEmpty()){
            int[] current = dq.pollFirst();
            int x = current[0];
            int y = current[1];
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n){
                    continue;
                }
                int newCost = dist[x][y] + grid[nx][ny];
                if(newCost < dist[nx][ny]){
                    dist[nx][ny] = newCost;
                    if(grid[nx][ny] == 0){
                        dq.addFirst(new int[] {nx, ny});
                    }else{
                        dq.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}