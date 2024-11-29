class Solution {
    private static final int[][] MOVES = {{-1,0},{0,1},{1,0},{0,-1}};
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1){
           return -1; 
        } 
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); //min-heap
        pq.offer(new int[]{0,0,0});
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currTime = curr[0], row = curr[1], col = curr[2];
            for(int[] dir : MOVES){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
            }
                    int nextTime = currTime + 1;
                    if(grid[newRow][newCol] > nextTime){
                        int waitTime = ((grid[newRow][newCol] - nextTime + 1) / 2) * 2;
                        nextTime += waitTime;
                    }
                    if(newRow == m - 1 && newCol == n - 1){
                        return nextTime;
                    }
            visited[newRow][newCol] = true;
            pq.offer(new int[]{nextTime, newRow, newCol});
                }
            }
    return -1;
    }
}

