class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], currTime = curr[2];
            if(visited[row][col]) continue;
            visited[row][col] = true;
            if(row == m - 1 && col == n - 1) return currTime;
            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]){
                    int nextTime = currTime + 1;
                    if(nextTime < grid[newRow][newCol]){
                        int waitTime = (grid[newRow][newCol] - nextTime) % 2 == 0 ? 0 : 1;
                        nextTime = grid[newRow][newCol] + waitTime;
                    }
                    pq.offer(new int[]{newRow, newCol, nextTime});
                }
            }
        }
        return -1;
    }
}